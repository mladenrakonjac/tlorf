package me.factliverpool.tlrof.networking

import com.google.gson.annotations.SerializedName

/**
 * Created by mladenrakonjac on 22/11/2017.
 */
data class BaseServerResponse<T>(
        @SerializedName("data") var data: T?,
        @SerializedName("message") var message: String?,
        @SerializedName("status_code") val statusCode: Int,
        @SerializedName("access_token") val accessToken: String?
)