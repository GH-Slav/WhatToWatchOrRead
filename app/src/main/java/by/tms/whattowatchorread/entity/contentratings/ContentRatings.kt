package by.tms.whattowatchorread.entity.contentratings


import com.google.gson.annotations.SerializedName

data class ContentRatings(
    @SerializedName("id")
    val id: Int,
    @SerializedName("results")
    val results: List<Result>
)