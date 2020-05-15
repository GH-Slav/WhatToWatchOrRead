package by.tms.whattowatchorread.ui.search.card

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.retrofit.MediaFactoryApi
import by.tms.whattowatchorread.ui.search.ID
import by.tms.whattowatchorread.ui.search.MEDIA
import by.tms.whattowatchorread.ui.search.POSTERPATH
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*
import kotlinx.android.synthetic.main.fragment_bottom_search.*
import kotlinx.android.synthetic.main.fragment_bottom_search.recyclerViewSearch
import kotlinx.android.synthetic.main.item_card_poster.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardPoster : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_card_poster)

        val posterPath = intent.getStringExtra(POSTERPATH)

        val imageUrl = "https://image.tmdb.org/t/p/w500/$posterPath"

        Picasso.get().load(imageUrl)
            .into(cardAppImageLargePoster)


    }
}



