package com.example.greenkim.api.member.DTO.GetMember

import com.google.gson.annotations.SerializedName

//설정창 정보 불러오기
data class GetMemberResponseDto (
    @SerializedName("status")val status: Int,
    @SerializedName("success")val success: Boolean,
    @SerializedName("message")val message: String,
    @SerializedName("data")val data: List<Data>
)