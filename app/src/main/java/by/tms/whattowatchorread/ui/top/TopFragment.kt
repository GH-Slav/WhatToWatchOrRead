package by.tms.whattowatchorread.ui.top

import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.retrofit.MediaFactoryApi
import kotlinx.android.synthetic.main.fragment_bottom_top_popularity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopFragment : Fragment(R.layout.fragment_bottom_top_popularity) {

    private lateinit var topPopularityViewModel: TopPopularityViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupAdapter()

    }
    private fun setupAdapter() {
        CoroutineScope(Dispatchers.IO).launch {

            val responseTop = MediaFactoryApi.getRetrofit()
                .getPartStringTop("tv").await()
            val listTmdbTop = responseTop.body()

            Log.e("TAG2", "$listTmdbTop")



            if (responseTop.isSuccessful) {

                withContext(Dispatchers.Main) {
                    recyclerViewTop.apply {
                        adapter = AdapterApiTop(listTmdbTop)
                        layoutManager = GridLayoutManager(context as MainActivity, 4)
                        setHasFixedSize(true)
                    }
                }
            } else {
                Log.e("ERROR", responseTop.code().toString())
            }
        }
    }
}

