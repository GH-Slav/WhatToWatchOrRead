package by.tms.whattowatchorread.ui.search

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.contentratings.TmdbContentRatings
import by.tms.whattowatchorread.entity.multisearch.TmdbMultiSearch
import by.tms.whattowatchorread.ui.search.card.CardActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_api_card_app.view.*

const val ID = "ID"
const val MEDIA = "MEDIA"
//const val GENREIDS = "GENREIDS"
//const val ORIGINALNAME = "ORIGINALNAME"
//const val NAME = "NAME"
//const val ORIGINCOUNTRY = "ORIGINCOUNTRY"
//const val FIRSTAIRDATE = "FIRSTAIRDATE"
//const val VOTEAVERAGE = "VOTEAVERAGE"
//const val OVERVIEW = "OVERVIEW"
const val POSTERPATH = "POSTERPATH"
//const val EPISODERUNTIME = "EPISODERUNTIME"
//const val NAMEEPISODE = "NAMEEPISODE"
//const val OVERVIEWEPISODE = "OVERVIEWEPISODE"
//const val SEASONNUMBER = "SEASONNUMBER"
//const val VOTEAVERAGEEPISODE = "VOTEAVERAGEEPISODE"
//const val STILLPATH = "STILLPATH"
//const val ISO = "ISO"
//const val CONTENTRATING = "CONTENTRATING"

class AdapterApiSearch(
    var listSearchTmdb: TmdbMultiSearch?,
    var listContentRatingTmdb: TmdbContentRatings?
) :
    RecyclerView.Adapter<AdapterApiSearch.MediaViewHolder>() {


//    fun setData(newListSearchTmdb: TmdbMultiSearch?){
//        listSearchTmdb = newListSearchTmdb
//        notifyDataSetChanged()
//    }

    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_api_card_app, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listSearchTmdb?.results?.count()!!
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView
        val name = listSearchTmdb?.results?.get(position)?.name
        val id = listSearchTmdb?.results?.get(position)?.id
        val mediaType = listSearchTmdb?.results?.get(position)?.mediaType
        val firstAirDate = listSearchTmdb?.results?.get(position)?.firstAirDate
        val originalName = listSearchTmdb?.results?.get(position)?.originalName

        val originCountry = listSearchTmdb?.results?.get(position)?.originCountry?.get(0)
        val overview = listSearchTmdb?.results?.get(position)?.overview
        val voteAverage = listSearchTmdb?.results?.get(position)?.voteAverage
        val posterPath = listSearchTmdb?.results?.get(position)?.posterPath
        val genreIds = listSearchTmdb?.results?.get(position)?.genreIds
        //      val episodeRunTime = listSearchTmdb?.results?.get(position)

        val iso31661 = listContentRatingTmdb?.results?.get(position)?.iso31661
        val rating = listContentRatingTmdb?.results?.get(position)?.rating



        viewMedia.cardAppTitleLarge.text = "$name"
        viewMedia.cardAppSecondaryTextLarge.text = "$originalName  $originCountry \n $firstAirDate"
        viewMedia.cardAppSupportingTextLarge.text = "$overview "
        genreIds?.forEach { genre -> viewMedia.textGenresLarge.text = "$genre" }
        viewMedia.cardAppRatingLarge.text = voteAverage.toString()
        viewMedia.cardAppAgeRatingLarge.text = "$iso31661 $rating"
        val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
        Picasso.get().load(imageUrl)
            .into(viewMedia.cardAppImageLarge)

        //      viewMedia.switchMaterialAddDelete

        viewMedia.setOnClickListener {
            val intent = Intent(holder.itemView.context, CardActivity::class.java)
            //intent.putExtra(ID, id)
         //   intent.putExtra(MEDIA, mediaType)
            holder.itemView.context.startActivity(intent)
        }

//        viewMedia.cardAppImageLarge.setOnClickListener {
//            val intent = Intent(holder.itemView.context, CardActivity::class.java)
//            intent.putExtra(POSTERPATH, posterPath)
//            holder.itemView.context.startActivity(intent)
//        }

    }
}