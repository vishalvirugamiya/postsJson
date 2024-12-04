package com.example.postjson

import android.os.Bundle
import android.util.Log
import android.view.Display
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.postjson.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
            postData()
    }

    private fun postData() {

        val url = "https://dummyjson.com/posts"
        val queue = Volley.newRequestQueue(this)

        val stringRequest = StringRequest(

            Request.Method.GET, url, Response.Listener<String> { response ->

                var Mobject :JSONObject=JSONObject(response.toString())

                val total :Int=Mobject.getInt("total")
                var skip  :Int=Mobject.getInt("skip")
                var limit :Int=Mobject.getInt("limit")

               binding.textView.text = limit.toString()

               // Log.d("==*===","total==$total")

            },
            Response.ErrorListener { volleyError ->
                binding.textView.text = volleyError.localizedMessage
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}