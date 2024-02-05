package com.example.greenkim.api.auth.DTO.ChangePassword

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

//비밀번호 변경하기
data class ChangePasswordRequestDto(
    @SerializedName("passwordToCheck")val passwordToCheck: String,
    @SerializedName("newPassword")val newPassword: String
)
