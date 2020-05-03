package by.tms.whattowatchorread.entity.contentratings


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("rating")
    val rating: String
)