package by.tms.whattowatchorread.ui.news

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.tms.whattowatchorread.CardActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import by.tms.whattowatchorread.entity.news.News
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card_news.view.*
import kotlinx.android.synthetic.main.item_data_api_card_app.view.*

class AdapterApiNews(
    private val listNews: News
) : RecyclerView.Adapter<AdapterApiNews.MediaViewHolder>() {

    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_news, parent, false)
        return MediaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
     return 4

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        val viewMedia = holder.itemView
        val title = listNews.articles.get(position).title
        val description = listNews.articles.get(position).description
        val url = listNews.articles.get(position).url
        val urlToImage = listNews.articles.get(position).urlToImage


        viewMedia.cardAppTitleLargeNews.text = "$title "
        viewMedia.cardAppSecondaryTextLargeNews.text = "$url "
        viewMedia.cardAppSupportingTextLargeNews.text = "$description "

        Picasso.get().load(urlToImage).
            into(viewMedia.cardAppImageLarge)


    }
}