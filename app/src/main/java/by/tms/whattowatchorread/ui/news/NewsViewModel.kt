package by.tms.whattowatchorread.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import by.tms.whattowatchorread.retrofit.MediaRepository
import by.tms.whattowatchorread.retrofit.MediaSearchFactoryApi
import kotlinx.coroutines.Dispatchers

class NewsViewModel : ViewModel() {


    var repository = MediaRepository()

    private val apiKey = "e6c999278715401da5ae53d8a2ddafa9"
    var query = "movie"


    val repositoryNews = liveData(Dispatchers.IO) {
        val retrofitNews =
            repository.getClientRetrofitNews().getPartStringNews(apiKey, query)
        emit(retrofitNews)
    }
}