package by.tms.whattowatchorread.retrofit

import by.tms.whattowatchorread.entity.contentratings.ContentRatings
import by.tms.whattowatchorread.entity.details.Details
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import by.tms.whattowatchorread.entity.news.News
import by.tms.whattowatchorread.entity.tvserials.TVSerial
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MediaSearchApi {

    @GET("3/search/multi")
    suspend fun getPartStringMultiSearch(
        @Query("api_key")
        api_key: String,
        @Query("query")
        query: String,
        @Query("page")
        page: Int,
        @Query ("include_adult")
        include_adult: Boolean)
            : MultiSearch

    @GET("3/search/tv")
    suspend fun getPartStringTVSerial(
        @Query("api_key")
        api_key: String,
        @Query("query")
        query: String,
        @Query("page")
        page: Int,
        @Query ("include_adult")
        include_adult: Boolean)
            : TVSerial

    @GET("3/{media_type}/{id}")
    suspend fun getPartStringDetails(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("api_key")
        api_key: String)
            : Details

    @GET("3/{media_type}/{id}/season/{season}/episode/{episode}")
    suspend fun getPartStringDetailsEpisode(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Path("season")
        season: Int,
        @Path("episode")
        episode: Int,
        @Query("api_key")
        api_key: String)
            : DetailsEpisode

    @GET("3/{media_type}/{id}/content_ratings")
    suspend fun getPartStringContentRatings(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("api_key")
        api_key: String)
            : ContentRatings

    @GET("v2/everything")
    suspend fun getPartStringNews(
        @Query("q")
        q: String,
        @Query("apiKey")
        apiKey: String)
            : News

}