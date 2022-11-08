package com.pr7.kotlin_flow_with_retrofit_mvvm.view

import android.content.Context
import android.net.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.pr7.kotlin_flow_with_retrofit_mvvm.R
import com.pr7.kotlin_flow_with_retrofit_mvvm.model.postrepository.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.textview1)
        val mainRepository=MainRepository()

        if (observeinternetConnection()){
            
        }


//        if(hasNetwork(this@MainActivity) == true){
//            GlobalScope.launch {
//                mainRepository.getallposts2().collect{
//                    withContext(Dispatchers.Main){
//                        textView.text=it.size.toString()
//                    }
//                }
//            }
//        }else{
//            textView.text="No Internet Connection"
//        }


    }

//    fun hasNetwork(context: Context): Boolean? {
//        var isConnected: Boolean? = false // Initial Value
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
//        if (activeNetwork != null && activeNetwork.isConnected)
//            isConnected = true
//        return isConnected
//    }

    fun observeinternetConnection():Boolean{
        var a=false
        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            // network is available for use
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                a= true
            }

            // lost network connection
            override fun onLost(network: Network) {
                super.onLost(network)
                a=false
            }
        }
        val connectivityManager = getSystemService(ConnectivityManager::class.java) as ConnectivityManager
        connectivityManager.requestNetwork(networkRequest, networkCallback)

        return a
    }
}