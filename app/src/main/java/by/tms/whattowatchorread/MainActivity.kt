package by.tms.whattowatchorread

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.entity.detailsepisode.DetailsEpisode
import by.tms.whattowatchorread.retrofit.MediaSearchFactoryApi
import by.tms.whattowatchorread.ui.search.AdapterApiSearch
import by.tms.whattowatchorread.ui.search.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.minutes

const val GENREIDS = "GENREIDS"
const val ORIGINALNAME = "ORIGINALNAME"
const val NAME = "NAME"
const val ORIGINCOUNTRY = "ORIGINCOUNTRY"
const val FIRSTAIRDATE = "FIRSTAIRDATE"
const val VOTEAVERAGE = "VOTEAVERAGE"
const val OVERVIEW = "OVERVIEW"
const val POSTERPATH = "POSTERPATH"
const val EPISODERUNTIME = "EPISODERUNTIME"
const val NAMEEPISODE = "NAMEEPISODE"
const val OVERVIEWEPISODE = "OVERVIEWEPISODE"
const val SEASONNUMBER = "SEASONNUMBER"
const val VOTEAVERAGEEPISODE = "VOTEAVERAGEEPISODE"
const val STILLPATH = "STILLPATH"
const val ISO = "ISO"
const val CONTENTRATING = "CONTENTRATING"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_search,
//                R.id.navigation_bookmark,
//                R.id.navigation_news,
//                R.id.navigation_history,
//                R.id.navigation_notifications
//            )
//        )

        val titleToolbarOne = resources.getString(R.string.title_search)
        val titleToolbarTwo = resources.getString(R.string.title_bookmark)
        val titleToolbarThree = resources.getString(R.string.title_news)
        val titleToolbarFour = resources.getString(R.string.title_history)
        val titleToolbarFive = resources.getString(R.string.title_notifications)
        val titleToolbarDefault = resources.getString(R.string.app_name)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            topAppBar.title = when (destination.id) {
                R.id.navigation_search -> titleToolbarOne
                R.id.navigation_bookmark -> titleToolbarTwo
                R.id.navigation_news -> titleToolbarThree
                R.id.navigation_history -> titleToolbarFour
                R.id.navigation_notifications -> titleToolbarFive
                else -> titleToolbarDefault
            }
        }
        //    setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



//        CoroutineScope(Dispatchers.IO).launch {
//            val apiKey = "3b56dd30d856264722d3d600c0e88ab5"
//            val query = "Mandalorian"
//            val responseMultiSearch = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringMultiSearch(apiKey, query, 1, false)
//                .await()
//            val multiSearch = responseMultiSearch.body()
//            val id = multiSearch?.results?.get(0)?.id
//            val mediaType = multiSearch?.results?.get(0)?.mediaType
//            val responseDetails = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringDetails(mediaType!!, id!!, apiKey)
//                .await()
//            val details = responseDetails.body()
//            val responseDetailsEpisode = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringDetailsEpisode(mediaType, id, 1, 1, apiKey)
//                .await()
//            val detailsEpisode = responseDetailsEpisode.body()
//            val responseContentRatings = MediaSearchFactoryApi.getRetrofit()
//                .getPartStringContentRatings(mediaType!!, id!!, apiKey)
//                .await()
//            val contentRatings = responseContentRatings.body()
//
//
//            if (responseMultiSearch.isSuccessful) {
//
//                withContext(Dispatchers.Main) {
//
//
//
//                }
//            } else {
//                Log.e("ERROR", responseMultiSearch.code().toString())
//            }
//        }
    }
}
