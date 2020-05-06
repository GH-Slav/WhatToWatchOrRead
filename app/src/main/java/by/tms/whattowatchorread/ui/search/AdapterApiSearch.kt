package by.tms.whattowatchorread.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.CardActivity
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.contentratings.ContentRatings
import by.tms.whattowatchorread.entity.details.Details
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_api_card_app.view.*

class AdapterApiSearch(
    val listMultiSearch: MultiSearch
) : RecyclerView.Adapter<AdapterApiSearch.MediaViewHolder>() {

    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_api_card_app, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
     return listMultiSearch.results.size

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView
        val name = listMultiSearch.results.get(position).name
        //    val firstAirDate = listDetails?.firstAirDate
        val originalName = listMultiSearch.results.get(position).originalName
        val originCountry = listMultiSearch.results.get(position).originCountry
        val overview = listMultiSearch.results.get(position).overview
        val voteAverage = listMultiSearch.results.get(position).voteAverage
        val posterPath = listMultiSearch.results.get(position).posterPath
        val genreIds = listMultiSearch.results.get(position).genreIds
//        val episodeRunTime = listDetails?.episodeRunTime
        //    val iso31661 = listContentRating?.results?.get(0)?.iso31661
        //      val rating = listContentRating?.results?.get(0)?.rating


//        searchViewModel?.detailsEpisode?.value?.name
//        searchViewModel?.detailsEpisode?.value?.overview
//        searchViewModel?.detailsEpisode?.value?.seasonNumber
//        searchViewModel?.detailsEpisode?.value?.voteAverage
//        searchViewModel?.detailsEpisode?.value?.stillPath
  //      $firstAirDate $episodeRunTime

        viewMedia.cardAppTitleLarge.text = "$name "
        viewMedia.cardAppSecondaryTextLarge.text = "$originalName $originCountry"
        viewMedia.cardAppSupportingTextLarge.text = "Episode time m \n $overview "
//        viewMedia.textGenresLarge.text = genreIds.toString()
        viewMedia.cardAppRatingLarge.text = voteAverage.toString()
 //       viewMedia.cardAppAgeRatingLarge.text = "$iso31661 $rating"
        Picasso.get().load("https://image.tmdb.org/t/p/w500${posterPath}")
            .into(viewMedia.cardAppImageLarge)

        //      viewMedia.switchMaterialAddDelete

        viewMedia.setOnClickListener { val intent = Intent(holder.itemView.context , CardActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }

    }
}