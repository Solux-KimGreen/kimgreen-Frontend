package com.example.greenkim.api.member.DTO.profile

import com.google.gson.annotations.SerializedName

class ProfileImgRequestDto (
    @SerializedName("status") val status:Int,
    @SerializedName("success") val success:Boolean,
    @SerializedName("message") val message:String
)