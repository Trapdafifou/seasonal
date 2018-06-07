package com.example.elgrim.seasonal.http;

import android.app.Application;
import android.text.TextUtils
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

interface ServiceInterface {
    fun post(path: String, token: String?, params: JSONObject, completionHandler: (response: JSONObject?) -> Unit)
    fun get(path: String, token: String?, completionHandler: (response: JSONArray?) -> Unit)
}

class BackendVolley : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private val requestQueue: RequestQueue? = null
        get() {
            if (field == null) {
                return Volley.newRequestQueue(applicationContext)
            }
            return field
        }

    fun <T> addToRequestQueue(request: Request<T>, tag: String) {
        request.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue?.add(request)
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        request.tag = TAG
        requestQueue?.add(request)
    }

    fun cancelPendingRequests(tag: Any) {
        if (requestQueue != null) {
            requestQueue!!.cancelAll(tag)
        }
    }

    companion object {
        private val TAG = BackendVolley::class.java.simpleName
        @get:Synchronized
        var instance: BackendVolley? = null
            private set
    }
}