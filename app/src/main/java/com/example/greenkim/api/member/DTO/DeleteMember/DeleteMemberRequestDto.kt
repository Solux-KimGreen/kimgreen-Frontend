package com.example.greenkim.api.member.DTO.DeleteMember

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

//탈퇴하기
data class DeleteMemberRequestDto(
    @SerializedName("password")val password: String
)
