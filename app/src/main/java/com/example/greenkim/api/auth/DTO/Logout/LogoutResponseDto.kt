package com.example.greenkim.api.auth.DTO.Logout

import android.provider.ContactsContract.Data
import com.google.gson.annotations.SerializedName

//로그아웃
data class LogoutResponseDto (
    @SerializedName("status")val status: Int,
    @SerializedName("success")val success: Boolean,
    @SerializedName("message")val message: String,
    @SerializedName("data")val data: Data
)