package by.tms.whattowatchorread.ui.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.retrofit.MediaSearchApi
import by.tms.whattowatchorread.retrofit.MediaSearchFactoryApi
import com.squareup.picasso.Picasso
import io.reactivex.Observer
import kotlinx.android.synthetic.main.fragment_bottom_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_search, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val searchViewModel = activity?.run {
            ViewModelProvider(this).get(SearchViewModel::class.java)
        }

        CoroutineScope(Dispatchers.IO).launch {

            val apiKey = "3b56dd30d856264722d3d600c0e88ab5"
            val query = "Mandalorian"
            val responseMultiSearch = MediaSearchFactoryApi.getRetrofit()
                .getPartStringMultiSearch(apiKey, query, 1, false)
                .await()
            val multiSearch = responseMultiSearch.body()
//            val id = multiSearch?.results?.get(0)?.id
//            val mediaType = multiSearch?.results?.get(0)?.mediaType
         val responseDetails = MediaSearchFactoryApi.getRetrofit()
                .getPartStringDetails("tv", 88588, apiKey)
                .await()
//            val details = responseDetails.body()
//            val responseDetailsEpisode = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringDetailsEpisode(mediaType, id, 1, 1, apiKey)
//                .await()
//            val detailsEpisode = responseDetailsEpisode.body()
//            val responseContentRatings = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringContentRatings(mediaType!!, id!!, apiKey)
//                .await()
//            val contentRatings = responseContentRatings.body()


            withContext(Dispatchers.Main) {
                recycler_view_search.adapter = AdapterApiSearch(multiSearch)
                recycler_view_search.layoutManager = LinearLayoutManager(context as MainActivity)
                recycler_view_search.setHasFixedSize(true)
            }
        }
    }
}



//        searchViewModel?.multiSearch?.value?.results?.get(0)?.genreIds
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.genreIds
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.originalName
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.name
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.originCountry
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.firstAirDate
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.voteAverage
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.overview
//        searchViewModel?.multiSearch?.value?.results?.get(0)?.posterPath
//        searchViewModel?.details?.value?.episodeRunTime?.get(0)
//        searchViewModel?.detailsEpisode?.value?.name
//        searchViewModel?.detailsEpisode?.value?.overview
//        searchViewModel?.detailsEpisode?.value?.seasonNumber
//        searchViewModel?.detailsEpisode?.value?.voteAverage
//        searchViewModel?.detailsEpisode?.value?.stillPath
//        searchViewModel?.contentRatings?.value?.results?.get(0)?.iso31661
//        searchViewModel?.contentRatings?.value?.results?.get(0)?.rating




