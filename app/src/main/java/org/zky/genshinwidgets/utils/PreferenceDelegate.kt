package org.zky.genshinwidgets.utils

import android.content.Context
import android.content.SharedPreferences
import org.zky.genshinwidgets.cst.SpCst
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.reflect.KProperty

class PreferenceDelegate<T>(val name: String, private val default: T) {
    companion object {
        private const val file_name = SpCst.DEFAULT_SP_NAME

        private val prefs: SharedPreferences by lazy {
            application.applicationContext.getSharedPreferences(file_name, Context.MODE_PRIVATE)
        }

        fun clearPreference() {
            prefs.edit().clear().apply()
        }

        fun clearPreference(key: String) {
            prefs.edit().remove(key).apply()
        }

        fun contains(key: String): Boolean = prefs.contains(key)

        fun getAll(): Map<String, *> = prefs.all
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
        getSharedPreferences(name, default)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) =
        putSharedPreferences(name, value)

    private fun putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            is String -> putString(name, value)
            else -> putString(name, serialize(value))
        }.apply()
    }

    private fun <A> serialize(obj: A): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var result = byteArrayOutputStream.toString("ISO-8859-1")
        result = URLEncoder.encode(result, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return result
    }

    private fun getSharedPreferences(name: String, default: T): T = with(prefs) {
        val res = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> deSerialization(getString(name, serialize(default)))
        }
        return res as T
    }

    private fun <A> deSerialization(str: String?): A {
        val redStr = URLDecoder.decode(str, "UTF-8")
        ObjectInputStream(ByteArrayInputStream(redStr.toByteArray(charset("ISO-8859-1")))).use {
            return it.readObject() as A
        }
    }
}
