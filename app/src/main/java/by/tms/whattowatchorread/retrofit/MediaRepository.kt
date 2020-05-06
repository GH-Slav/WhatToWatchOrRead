package by.tms.whattowatchorread.retrofit

class MediaRepository {
    private var client = MediaSearchFactoryApi
    private var clientNews = MediaSearchFactoryApi

    suspend fun getClientRetrofit() = client.getRetrofit()
    suspend fun getClientRetrofitNews() = clientNews.getRetrofitNews()
}