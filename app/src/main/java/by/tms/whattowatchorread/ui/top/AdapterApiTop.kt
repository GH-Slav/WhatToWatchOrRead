package by.tms.whattowatchorread.ui.top

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.top.TmdbTop
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card_poster_two.view.*

class AdapterApiTop(var listTop: TmdbTop?
) :
    RecyclerView.Adapter<AdapterApiTop.MediaViewHolder>() {


    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_poster_two, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listTop?.totalResults!!
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView

        val posterPath = listTop?.results?.get(position)?.posterPath

        val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"
        Picasso.get().load(imageUrl)
            .into(viewMedia.cardAppImageLargePoster)



    }
}