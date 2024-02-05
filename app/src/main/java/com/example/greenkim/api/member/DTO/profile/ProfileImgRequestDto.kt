package com.example.greenkim.api.member.DTO.profile

import com.google.gson.annotations.SerializedName

//프로필 사진 변경하기
data class ProfileImgRequestDto (
    @SerializedName("status") val status:Int,
    @SerializedName("success") val success:Boolean,
    @SerializedName("message") val message:String
)