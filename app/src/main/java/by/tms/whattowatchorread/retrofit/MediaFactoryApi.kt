package by.tms.whattowatchorread.retrofit

import android.util.Log
import by.tms.whattowatchorread.BuildConfig

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

const val BASEURL = "https://api.themoviedb.org/3/"
const val APIKEYTMDB = BuildConfig.TMDB_API_KEY

object MediaFactoryApi {

    private val loggingInterceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val baseInterceptor = Interceptor { chain ->
        val newUrl = chain
            .request()
            .url()
            .newBuilder()
            .addQueryParameter("api_key", APIKEYTMDB)
            .build()
        Log.d("TAG", "key ----> $APIKEYTMDB")
        val newRequest = chain
            .request()
            .newBuilder()
            .url(newUrl)
            .build()
        Log.d("TAG", "okhttp ----> " + newRequest.url().toString())
        chain.proceed(newRequest)
    }

    private val tmdbClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(baseInterceptor)
        .build()

    fun getRetrofit() : MediaApi{  val retrofit = Retrofit.Builder()
        .client(tmdbClient)
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

        return retrofit.create()
    }
}
