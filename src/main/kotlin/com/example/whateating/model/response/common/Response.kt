package com.example.whateating.model.response.common

import com.example.whateating.model.enums.ResponseCode

// @Schema(description = "단일건 응답 객체", title = "SingleResponse")
data class SingleResponse<out T>(
//    @Schema(description = "응답 결과", nullable = false)
    val result: ResponseCode? = ResponseCode.SUCCESS,
//    @Schema(description = "응답 데이터", nullable = false)
    val data: T? = null
)

// @Schema(description = "복수건 응답 객체", title = "MultiResponse")
data class MultiResponse<out T>(
//    @Schema(description = "응답 결과", nullable = false)
    val result: ResponseCode? = ResponseCode.SUCCESS,
//    @Schema(description = "응답 데이터", nullable = false)
    val data: List<T>? = null
)

// @Schema(description = "에러 응답 객체", title = "ExceptionResponse")
data class ExceptionResponse(
//    @Schema(description = "응답 결과", nullable = false, defaultValue = "ERROR")
    val result: ResponseCode? = ResponseCode.ERROR,
//    @Schema(description = "에러 사유", nullable = false)
    val error: ErrorData
)

// @Schema(description = "에러 상세 내용", title = "ErrorData")
data class ErrorData(
//    @Schema(description = "정의한 코드값", nullable = false)
    val code: String,
//    @Schema(description = "에러 메시지", nullable = false)
    val message: String? = "",
//    @Schema(description = "에러 상세 메시지", nullable = false)
    val detail: String? = ""
)
