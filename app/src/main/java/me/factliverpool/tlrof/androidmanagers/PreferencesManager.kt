package me.factliverpool.tlrof.androidmanagers

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by mladenrakonjac on 07/10/16.
 */

class PreferencesManager(context: Context, name: String) {
    private var sharedPreferences: SharedPreferences = context.getSharedPreferences(name,
            Context.MODE_PRIVATE)

    companion object {

        private val SHARED_ACCESS_TOKEN = "shared_access_token"
        private val SHARED_USERNAME = "shared_username"

    }

    fun saveAccessToken(accessToken: String) {
        sharedPreferences.edit().putString(SHARED_ACCESS_TOKEN, accessToken).apply()
    }

    fun getAccessToken(): String {
        return sharedPreferences.getString(SHARED_ACCESS_TOKEN, "")
    }

    fun saveUsername(username: String) {
        sharedPreferences.edit().putString(SHARED_USERNAME, username).apply()
    }

    fun getUsername(): String {
        return sharedPreferences.getString(SHARED_USERNAME, "")
    }

}
