package by.tms.whattowatchorread.ui.search.card

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.detailsepisode.TmdbDetailsEpisode
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_api_card_episode_app.view.*

class AdapterApiSearchCard(
    var listDetailsEpisodeTmdb: TmdbDetailsEpisode?
) :
    RecyclerView.Adapter<AdapterApiSearchCard.MediaViewHolder>() {


    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_data_api_card_episode_app, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listDetailsEpisodeTmdb?.episodes?.size!!
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView
        val name = listDetailsEpisodeTmdb?.episodes?.get(position)?.name
        val airDate = listDetailsEpisodeTmdb?.episodes?.get(position)?.airDate
        val seasonNumber = listDetailsEpisodeTmdb?.episodes?.get(position)?.seasonNumber
        val episodeNumber =  listDetailsEpisodeTmdb?.episodes?.get(position)?.episodeNumber
        val overview = listDetailsEpisodeTmdb?.episodes?.get(position)?.overview
        val voteAverage = listDetailsEpisodeTmdb?.episodes?.get(position)?.voteAverage
        val posterPath = listDetailsEpisodeTmdb?.posterPath




        viewMedia.cardAppTitleLarge.text = "$name"
        viewMedia.cardAppSecondaryTextLarge.text = " Сезон $seasonNumber серия $episodeNumber \n $airDate"
        viewMedia.cardAppSupportingTextLarge.text = "$overview "
        viewMedia.cardAppRatingLarge.text = voteAverage.toString()

        val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
        Picasso.get().load(imageUrl)
            .into(viewMedia.cardAppImageLarge)


//        viewMedia.setOnClickListener {
//  //          val intent = Intent(holder.itemView.context, CardActivity::class.java)
// //           holder.itemView.context.startActivity(intent)
//        }

    }
}