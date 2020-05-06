package by.tms.whattowatchorread.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import by.tms.whattowatchorread.retrofit.MediaRepository
import by.tms.whattowatchorread.retrofit.MediaSearchFactoryApi
import kotlinx.coroutines.Dispatchers

class SearchViewModel : ViewModel() {

    var repository = MediaRepository()

    private val apiKey = "3b56dd30d856264722d3d600c0e88ab5"
    var query = "Mandalorian"
    var mediaType = "tv"
    var id = 82856
    val page = 1
    var season = 1
    var episode = 1



    val repositoryMultiSearch = liveData(Dispatchers.IO) {
        val retrofitMultiSearch =
            repository.getClientRetrofit().getPartStringMultiSearch(apiKey, query, page, false)
        emit(retrofitMultiSearch)
    }

    val repositoryTVSerial = liveData(Dispatchers.IO) {
        val retrofitTVSerial =
            repository.getClientRetrofit().getPartStringMultiSearch(apiKey, query, page, false)
        emit(retrofitTVSerial)
    }

    val repositoryDetails = liveData(Dispatchers.IO) {
        val retrofitDetails =
            repository.getClientRetrofit().getPartStringDetails(mediaType, id, apiKey)
        emit(retrofitDetails)

    }
    val repositoryDetailsEpisode = liveData(Dispatchers.IO) {
        val retrofitDetailsEpisode =
            repository.getClientRetrofit().getPartStringDetailsEpisode(mediaType, id, season, episode, apiKey)
        emit(retrofitDetailsEpisode)

    }
    val repositoryContentRating = liveData(Dispatchers.IO) {
        val retrofitContentRatings =
            repository.getClientRetrofit().getPartStringContentRatings(mediaType, id, apiKey)
        emit(retrofitContentRatings)
    }

}