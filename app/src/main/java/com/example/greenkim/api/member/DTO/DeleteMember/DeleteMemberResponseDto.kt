package com.example.greenkim.api.member.DTO.DeleteMember

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

//탈퇴하기
data class DeleteMemberResponseDto(
    @SerializedName("status")val status: Int,
    @SerializedName("success")val success: Boolean,
    @SerializedName("message")val message: String
)
