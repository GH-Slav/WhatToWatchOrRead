package by.tms.whattowatchorread.ui.news

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.ui.search.AdapterApiSearch
import by.tms.whattowatchorread.ui.search.SearchViewModel
import kotlinx.android.synthetic.main.fragment_bottom_news.*
import kotlinx.android.synthetic.main.fragment_bottom_search.*
import kotlin.coroutines.coroutineContext

class NewsFragment : Fragment() {

    private var viewModelNewsView: NewsViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModelNewsView = activity?.run {
            ViewModelProvider(this).get(NewsViewModel::class.java)
        }

        showFirstNewsView()



    }

    private fun showFirstNewsView() {
        viewModelNewsView?.repositoryNews?.observe(viewLifecycleOwner, Observer {
            Log.d("Lognews", "$it")
            recyclerViewNews.apply {
                adapter = AdapterApiNews(it)
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
            }
        })
    }
}
