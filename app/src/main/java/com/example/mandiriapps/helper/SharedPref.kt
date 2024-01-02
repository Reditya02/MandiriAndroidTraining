package com.example.mandiriapps.helper

import android.content.Context

class SharedPref(context: Context) {

    private val preferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        preferences.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(): String {
        return preferences.getString(KEY_TOKEN, "") ?: ""
    }

    companion object {
        private const val SHARED_PREF = "shared_pref"
        private const val KEY_TOKEN = "key_token"
    }
}