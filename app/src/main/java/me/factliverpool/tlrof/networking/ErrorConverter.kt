package me.factliverpool.tlrof.networking

import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class ErrorConverter(retrofit: Retrofit) {

    private val converter = retrofit
            .responseBodyConverter<BaseServerError>(BaseServerError::class.java, arrayOfNulls(0))

    fun parseError(response: HttpException): BaseServerError {

        val error: BaseServerError

        try {
            error = converter.convert(response.response().errorBody()!!)
        } catch (e: IOException) {
            return BaseServerError("Unexpected Error", 0)
        }

        return error
    }
}