package by.tms.whattowatchorread.entity.tvserials


import by.tms.whattowatchorread.entity.tvserials.Result
import com.google.gson.annotations.SerializedName

data class TVSerial(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)