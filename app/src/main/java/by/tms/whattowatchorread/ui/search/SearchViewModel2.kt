package by.tms.whattowatchorread.ui.search

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.entity.contentratings.ContentRatings
import by.tms.whattowatchorread.entity.details.Details
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import by.tms.whattowatchorread.retrofit.MediaSearchFactoryApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchViewModel2 : ViewModel() {

    private val liveDataMultiSearch = MutableLiveData<MultiSearch>()
    private val liveDataDetails = MutableLiveData<Details>()
    private val liveDataDetailsEpisode = MutableLiveData<DetailsEpisode>()
    private val liveDataContentRatings = MutableLiveData<ContentRatings>()

    val multiSearch: LiveData<MultiSearch> = liveDataMultiSearch
    val details: LiveData<Details> = liveDataDetails
    val detailsEpisode: LiveData<DetailsEpisode> = liveDataDetailsEpisode
    val contentRatings: LiveData<ContentRatings> = liveDataContentRatings

//    fun dataRetrofitMediaLiveData() {
//
//        CoroutineScope(Dispatchers.IO).launch {
//
//            val apiKey = "3b56dd30d856264722d3d600c0e88ab5"
//            val query = "Mandalorian"
//            val responseMultiSearch = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringMultiSearch(apiKey, query, 1, false)
//                .await()
//            val multiSearch = responseMultiSearch.body()
//            val id = multiSearch?.results?.get(0)?.id
//            val mediaType = multiSearch?.results?.get(0)?.mediaType
//            val responseDetails = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringDetails(mediaType!!, id!!, apiKey)
//                .await()
//            val details = responseDetails.body()
//            val responseDetailsEpisode = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringDetailsEpisode(mediaType, id, 1, 1, apiKey)
//                .await()
//            val detailsEpisode = responseDetailsEpisode.body()
//            val responseContentRatings = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringContentRatings(mediaType!!, id!!, apiKey)
//                .await()
//            val contentRatings = responseContentRatings.body()
//
//
//            withContext(Dispatchers.Main) {
//                liveDataMultiSearch.postValue(multiSearch)
//                liveDataDetails.postValue(details)
//                liveDataDetailsEpisode.postValue(detailsEpisode)
//                liveDataContentRatings.postValue(contentRatings)
//            }
//        }
//    }
}