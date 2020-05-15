package by.tms.whattowatchorread.retrofit

import by.tms.whattowatchorread.entity.contentratings.TmdbContentRatings
import by.tms.whattowatchorread.entity.details.TmdbDetails
import by.tms.whattowatchorread.entity.detailsepisode.TmdbDetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.TmdbMultiSearch
import by.tms.whattowatchorread.entity.top.TmdbTop
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MediaApi {

    @GET("search/multi?")
    fun getPartStringMultiSearch(
        @Query("language")
        language: String,
        @Query("query")
        query: String,
        @Query("page")
        page: Int,
        @Query("include_adult")
        include_adult: Boolean
    )
            : Deferred<Response<TmdbMultiSearch>>


    @GET("3/{media_type}/{id}")
     fun getPartStringDetails(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("language")
        language: String)
            : Deferred<Response<TmdbDetails>>

    @GET("3/{media_type}/{id}/season/{season}")
    fun getPartStringDetailsEpisode(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Path("season")
        season: Int,
        @Query("language")
        language: String)
            : Deferred<Response<TmdbDetailsEpisode>>

    @GET("3/{media_type}/{id}/content_ratings")
    fun getPartStringContentRatings(
        @Path("media_type")
        media_type: String,
        @Path("id")
        id: Int,
        @Query("language")
        language: String)
            : Deferred<Response<TmdbContentRatings>>

    @GET("3/{media_type}/popular")
    fun getPartStringTop(
        @Path("media_type")
        media_type: String)
            : Deferred<Response<TmdbTop>>


}