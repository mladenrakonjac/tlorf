package me.factliverpool.tlrof.networking

import com.google.gson.annotations.SerializedName

/**
 * Created by mladenrakonjac on 22/11/2017.
 */
data class BaseServerError (
        @SerializedName("message") override var message: String?,
        @SerializedName("status_code") val statusCode: Int
) : Throwable()