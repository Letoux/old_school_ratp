package com.old_school_ratp.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.old_school_ratp.databinding.ActivityMainBinding
import com.old_school_ratp.request.lines.Lines
import com.old_school_ratp.request.utils.ApiClient
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val apiClient = ApiClient()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickListeners()
    }

    private fun clickListeners() {
        binding.bus.setOnClickListener{
            Log.d("transport","Ca c est le bouton du bus")
        }
        binding.metro.setOnClickListener {
            apiClient.getApiService().getMetroLines("metros")
                    .enqueue(object : Callback<Lines> {
                        override fun onResponse(call: retrofit2.Call<Lines>,
                                                response: Response<Lines>) {
                            Log.d("metro", response.code().toString())
                            Log.d("metro", call.request().url() .toString())
                            Log.d("metro", response.body().toString())
                            Log.d("metro", response.body()?.result?.metros?.get(1)?.directions.toString())
                        }

                        override fun onFailure(call: retrofit2.Call<Lines>, t: Throwable) {
                            Log.d("metro", "C'est cassé")
                            Log.d("metro", call.request().url().toString())
                            Log.d("metro", call.request().method().toString())
                            Log.d("metro", t.message.toString())
                        }
                    })

        }
        binding.RER.setOnClickListener{
            Log.d("transport","Ca c est le bouton du RER")
        }
        binding.tram.setOnClickListener {
            Log.d("transport","Ca c est le bouton du tram")
        }
    }
}
/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("elem", "Bonjour bonjour")
        var snackbar: Toast = Toast.makeText(this, "www.journaldev.com", Toast.LENGTH_LONG)
        snackbar.show()

        val bus: Button = findViewById(R.id.bus)
        bus.setOnClickListener{
            Log.d("elem", "This is the welcome text")
        }
    }

*/