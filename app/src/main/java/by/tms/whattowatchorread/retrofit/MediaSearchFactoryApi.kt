package by.tms.whattowatchorread.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


const val BASEURL = "https://api.themoviedb.org/"
const val BASEURLNEWS = "https://newsapi.org/"


object MediaSearchFactoryApi {

    fun getRetrofit(): MediaSearchApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create()
    }



    fun getRetrofitNews(): MediaSearchApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASEURLNEWS)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit.create()}



}