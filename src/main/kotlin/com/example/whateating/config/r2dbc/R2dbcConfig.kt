package com.example.whateating.config.r2dbc

import com.example.whateating.config.r2dbc.properties.DataPoolProperties
import com.example.whateating.config.r2dbc.properties.R2dbcPoolProperties
import dev.miku.r2dbc.mysql.MySqlConnectionFactoryProvider.MYSQL_DRIVER
import io.r2dbc.pool.PoolingConnectionFactoryProvider.*
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryOptions.*
import io.r2dbc.spi.Option
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.MySqlDialect
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.reactive.TransactionalOperator
import java.time.Duration

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing
@EnableTransactionManagement
class R2dbcConfig(
    private val r2dbcPoolProperties: R2dbcPoolProperties,
    private val dataPoolProperties: DataPoolProperties,
) : AbstractR2dbcConfiguration() {

    @Bean
    override fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val converters = ArrayList<Any>().apply {
            addAll(MySqlDialect.INSTANCE.converters)
            addAll(R2dbcCustomConversions.STORE_CONVERTERS)
        }
        return R2dbcCustomConversions(converters)
    }

    @Bean
    fun transactionManager(@Qualifier(value = "connectionFactory") connectionFactory: ConnectionFactory): ReactiveTransactionManager? {
        return R2dbcTransactionManager(connectionFactory)
    }

    @Bean
    fun transactionalOperator(transactionManager: ReactiveTransactionManager) =
        TransactionalOperator.create(transactionManager)

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return ConnectionFactories.get(
            builder()
                .option(DRIVER, POOLING_DRIVER)
                .option(PROTOCOL, MYSQL_DRIVER)
                .option(HOST, dataPoolProperties.host)
                .option(USER, dataPoolProperties.username)
                .option(PORT, dataPoolProperties.port)
                .option(PASSWORD, dataPoolProperties.password)
                .option(DATABASE, dataPoolProperties.db)
                .option(MAX_SIZE, r2dbcPoolProperties.maxSize)
                .option(INITIAL_SIZE, r2dbcPoolProperties.initialSize)
                .option(MAX_IDLE_TIME, Duration.ofSeconds(r2dbcPoolProperties.maxIdleTime))
                .option(
                    MAX_CREATE_CONNECTION_TIME,
                    Duration.ofSeconds(r2dbcPoolProperties.maxCreateConnectionTime)
                )
                .option(MAX_LIFE_TIME, Duration.ofMinutes(r2dbcPoolProperties.maxLife))
                .option(Option.valueOf("tlsVersion"), r2dbcPoolProperties.tlsVersion)
                .build()
        )
    }
}
