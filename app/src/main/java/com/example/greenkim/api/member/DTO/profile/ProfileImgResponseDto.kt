package com.example.greenkim.api.member.DTO.profile

import com.google.gson.annotations.SerializedName

//프로필 사진 변경하기
class ProfileImgResponseDto(
    @SerializedName("img") val img: String
)
