package com.example.greenkim.api.member.DTO.AlarmSettingChange

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

//알람 설정 변경
data class AlarmResponseDto(
    @SerializedName("status")val status: Int,
    @SerializedName("success")val success: Boolean,
    @SerializedName("message")val message: String,
    @SerializedName("data")val data: ContactsContract.Data
)
