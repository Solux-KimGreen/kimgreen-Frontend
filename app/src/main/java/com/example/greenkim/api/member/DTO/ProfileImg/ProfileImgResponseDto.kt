package com.example.greenkim.api.member.DTO.ProfileImg

import com.google.gson.annotations.SerializedName

//프로필 사진 변경하기
data class ProfileImgResponseDto(
    @SerializedName("img") val img: String
)
