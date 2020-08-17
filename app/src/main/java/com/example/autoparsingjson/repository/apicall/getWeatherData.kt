package com.example.autoparsingjson.repository.apicall

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.*

open class getWeatherData {
    companion object {
        val errorHandler = CoroutineExceptionHandler { _, error ->
            error.printStackTrace()
            //TrackingCrash.logException(error)
        }
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Main + Job() + errorHandler)
    fun sendRequest(context: Context, ml:MutableLiveData<String>) {
        var s = ""
        coroutineScope.launch(Dispatchers.IO) {
// ...

// Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(context)
            val url =
                "https://opendata.cwb.gov.tw/api/v1/rest/datastore/F-C0032-001?Authorization=CWB-9A3F0E3E-CC4F-4284-84D3-F57EBDAB6A08&format=JSON&locationName=%E8%87%BA%E5%8C%97%E5%B8%82&elementName=PoP";
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    ml.value = "Response is: ${response.substring(0, 500)}"
                },
                Response.ErrorListener { ml.value = "That didn't work!" })

// Add the request to the RequestQueue.
            queue.add(stringRequest)
            //Log.d(TAG, "sendRequest: "+s)

        }

    }
}