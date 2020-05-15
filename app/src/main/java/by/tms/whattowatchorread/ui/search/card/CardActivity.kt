package by.tms.whattowatchorread.ui.search.card

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.retrofit.MediaFactoryApi

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        setup()
    }
    @SuppressLint("SetTextI18n")
    private fun setup() {
        CoroutineScope(Dispatchers.IO).launch {

         //   val id  = intent.getStringExtra(ID).toInt()
            val id = 82856
         //   val mediaType  = intent.getStringExtra(MEDIA)
            val mediaType = "tv"
            val responseTmdbDetails = MediaFactoryApi.getRetrofit()
                .getPartStringDetails(mediaType, id,"ru-RU").await()
            val listTmdbDetails = responseTmdbDetails.body()
//            val responseTmdbDetailsEpisode = MediaFactoryApi.getRetrofit()
//                .getPartStringDetailsEpisode(mediaType, id,1,"ru-RU").await()
//            val listTmdbDetailsEpisode = responseTmdbDetailsEpisode.body()
//            val responseTmdbContentRatings = MediaFactoryApi.getRetrofit()
//                .getPartStringContentRatings(mediaType, id,"ru-RU").await()
//            val listTmdbContentRatings = responseTmdbContentRatings.body()


            if (responseTmdbDetails.isSuccessful) {

                withContext(Dispatchers.Main) {

                    val name = listTmdbDetails?.name
                    val firstAirDate = listTmdbDetails?.firstAirDate
                    val originalName = listTmdbDetails?.originalName

                    val originCountry = listTmdbDetails?.originCountry
                    val overview = listTmdbDetails?.overview
                    val voteAverage = listTmdbDetails?.voteAverage
                    val posterPath = listTmdbDetails?.posterPath
                    val genreIds = listTmdbDetails?.genres?.get(0)?.name
                    val episodeRunTime = listTmdbDetails?.episodeRunTime
//
//                    val iso31661 = listTmdbContentRatings?.results?.get(0)?.iso31661
//                    val rating = listTmdbContentRatings?.results?.get(0)?.rating



                    cardAppTitleLarge.text = "$name"
                    cardAppSecondaryTextLarge.text = "$originalName  $originCountry \n $firstAirDate  $episodeRunTime"
                    cardAppSupportingTextLarge.text = "$overview"
                    genreIds?.forEach { genre -> textGenresLarge.text = "$genre" }
                    cardAppRatingLarge.text = voteAverage.toString()
//                    cardAppAgeRatingLarge.text = "$iso31661 $rating"
                    val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
                    Picasso.get().load(imageUrl)
                        .into(cardAppImageLarge)

//                    recyclerViewSearchCard.apply {
//                        adapter =
//                            AdapterApiSearchCard(
//                                listTmdbDetailsEpisode
//                            )
//                        layoutManager = LinearLayoutManager(context)
//                        setHasFixedSize(true)
//                    }
                }
            } else {
                Log.e("ERROR", responseTmdbDetails.code().toString())
            }
        }
    }
}


