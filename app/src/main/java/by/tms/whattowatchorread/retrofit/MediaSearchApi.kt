package by.tms.whattowatchorread.retrofit

import by.tms.whattowatchorread.entity.contentratings.ContentRatings
import by.tms.whattowatchorread.entity.details.Details
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MediaSearchApi {

    @GET("search/multi")
    fun getPartStringMultiSearch(
        @Query("api_key")
        api_key: String,
        @Query("query")
        query: String,
        @Query("page")
        page: Int,
        @Query ("include_adult")
        include_adult: Boolean)
            : Deferred<Response<MultiSearch>>

    @GET("{media_type}/{id}")
    fun getPartStringDetails(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("api_key")
        api_key: String)
            : Deferred<Response<Details>>

    @GET("{media_type}/{id}/season/{season}/episode/{episode}")
    fun getPartStringDetailsEpisode(
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
            : Deferred<Response<DetailsEpisode>>

    @GET("{media_type}/{id}/content_ratings")
    fun getPartStringContentRatings(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("api_key")
        api_key: String)
            : Deferred<Response<ContentRatings>>

}