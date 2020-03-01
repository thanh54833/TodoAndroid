package com.thanh.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import com.thanh.sharedpreferences.SharedConfig.APP_PREF_MODE
import com.thanh.sharedpreferences.SharedConfig.APP_PREF_NAME
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author krzysztof.kosobudzki
 */

private class PreferenceProperty<T>(
    private val key: String,
    private val defaultValue: T,
    private val getter: SharedPreferences.(String, T) -> T,
    private val setter: SharedPreferences.Editor.(String, T) -> SharedPreferences.Editor
) : ReadWriteProperty<Context, T> {

    override fun getValue(thisRef: Context, property: KProperty<*>): T =
        thisRef.getPreferences()
            .getter(key, defaultValue)

    override fun setValue(thisRef: Context, property: KProperty<*>, value: T) =
        thisRef.getPreferences()
            .edit()
            .setter(key, value)
            .apply()

    private fun Context.getPreferences(): SharedPreferences =
        getSharedPreferences(APP_PREF_NAME, APP_PREF_MODE)
}

fun intPreference(key: String, defaultValue: Int = 0): ReadWriteProperty<Context, Int> =
    PreferenceProperty(
        key = key,
        defaultValue = defaultValue,
        getter = SharedPreferences::getInt,
        setter = SharedPreferences.Editor::putInt
    )

fun booleanPreference(
    key: String,
    defaultValue: Boolean = false
): ReadWriteProperty<Context, Boolean> =
    PreferenceProperty(
        key = key,
        defaultValue = defaultValue,
        getter = SharedPreferences::getBoolean,
        setter = SharedPreferences.Editor::putBoolean
    )

fun stringPreference(
    key: String,
    defaultValue: String? = null
): ReadWriteProperty<Context, String?> =
    PreferenceProperty(
        key = key,
        defaultValue = defaultValue,
        getter = SharedPreferences::getString,
        setter = SharedPreferences.Editor::putString
    )