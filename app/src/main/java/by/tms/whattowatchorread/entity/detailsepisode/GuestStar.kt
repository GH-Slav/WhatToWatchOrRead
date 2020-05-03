package by.tms.whattowatchorread.entity.detailsepisode


import com.google.gson.annotations.SerializedName

data class GuestStar(
    @SerializedName("character")
    val character: String,
    @SerializedName("credit_id")
    val creditId: String,
    @SerializedName("gender")
    val gender: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("profile_path")
    val profilePath: Any
)