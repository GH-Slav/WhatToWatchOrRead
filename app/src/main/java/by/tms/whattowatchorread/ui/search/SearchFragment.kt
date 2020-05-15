package by.tms.whattowatchorread.ui.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.retrofit.MediaFactoryApi
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_bottom_search.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SearchFragment : Fragment(R.layout.fragment_bottom_search) {

    private lateinit var searchViewModel: SearchViewModel
    private var searchList = ArrayList<String>()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchViewModel = activity.run {
            ViewModelProvider(this as ViewModelStoreOwner).get(SearchViewModel::class.java) }

        editSearch.apply { setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                searchList.clear()
                val text = editSearch.text
                searchList.add(text.toString())
                editSearch.text!!.clear()
                searchViewModel.query = searchList[0]
                setupAdapter(searchViewModel.query)
                return@OnKeyListener true
            }
            false
        }) }

//        editText.doAfterTextChanged { t ->
//            searchList.clear()
//            if (t.toString().isEmpty()) {
//                setupRecycler(startList)
//            } else {
//                startList.forEach {item ->
//                    if (item.country.toLowerCase().contains(t.toString().toLowerCase())) {
//                        searchList.add(item)
//                    }
//                }
//                setupRecycler(searchList)
//            }
//        }


//        // Write a message to the database
////        val database = FirebaseDatabase.getInstance()
////        val myRef = database.getReference("message")
////
////        myRef.setValue("Hello, World!")

 }


    private fun setupAdapter(query: String) {
            CoroutineScope(Dispatchers.IO).launch {

                val responseTmdbMultiSearch = MediaFactoryApi.getRetrofit()
                    .getPartStringMultiSearch("ru-RU", query, 1, false).await()
                val listTmdbMultiSearch = responseTmdbMultiSearch.body()
//            val mediaType = listTmdbMultiSearch?.results?.get(0)?.mediaType
                val id = listTmdbMultiSearch?.results?.get(0)?.id

//
//            val responseTmdbDetails = MediaFactoryApi.getRetrofit()
//                .getPartStringDetails(mediaType!!, id!!,"ru-RU").await()//
//
//                val responseTmdbDetails = MediaFactoryApi.getRetrofit()
//                .getPartStringDetails(mediaType!!, id!!,"ru-RU").await()//
                val responseTmdbContentRatings = MediaFactoryApi.getRetrofit()
                    .getPartStringContentRatings("tv", id!!,"ru-RU").await()
                val listTmdbContentRatings = responseTmdbContentRatings.body()



            if (responseTmdbMultiSearch.isSuccessful) {

                withContext(Dispatchers.Main) {
                    recyclerViewSearch.apply {
                        adapter = AdapterApiSearch(listTmdbMultiSearch, listTmdbContentRatings)
                        layoutManager = LinearLayoutManager(context as MainActivity)
                        setHasFixedSize(true)
                    }
                }
            } else {
                Log.e("ERROR", responseTmdbMultiSearch.code().toString())
            }
        }
    }
}






