package com.example.greenkim.api.auth.DTO.ChangePassword

import com.example.greenkim.api.auth.DTO.Data
import com.google.gson.annotations.SerializedName

//비밀번호 변경하기
data class ChangePasswordResponseDto(
    @SerializedName("status")val status: Int,
    @SerializedName("success")val success: Boolean,
    @SerializedName("message")val message:String,
    @SerializedName("data")val data: Data
)
