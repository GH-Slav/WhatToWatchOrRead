package by.tms.whattowatchorread.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.data_api_card_app.view.*

class AdapterApiSearch(val listMedia: MultiSearch?) :
    RecyclerView.Adapter<AdapterApiSearch.MediaViewHolder>() {


    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.data_api_card_app, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMedia?.results!!.size
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView

        viewMedia.cardAppTitle.text = listMedia?.results?.get(position)?.name
        viewMedia.cardAppSecondaryText.text = listMedia?.results?.get(position)?.originalName
        viewMedia.cardAppRating.text = listMedia?.results?.get(position)?.voteAverage.toString()

        val url = listMedia?.results?.get(position)?.posterPath

        Picasso.get().load("https://image.tmdb.org/t/p/w500${url}").into(viewMedia.cardAppImage)

    }
}