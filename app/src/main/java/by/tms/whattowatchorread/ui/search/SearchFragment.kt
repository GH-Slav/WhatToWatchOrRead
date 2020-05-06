package by.tms.whattowatchorread.ui.search

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import kotlinx.android.synthetic.main.fragment_bottom_search.*


class SearchFragment : Fragment() {

    private var viewModelSearchView: SearchViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_search, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        editSearch.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
               editSearch.text!!.clear()
                return@OnKeyListener true
            }
            false
        })



        viewModelSearchView = activity?.run {
            ViewModelProvider(this).get(SearchViewModel::class.java)

        }



        viewModelSearchView?.query = "Sherlock"

        showFirstSearchView()






    }
    private fun showFirstSearchView() {
        viewModelSearchView?.repositoryTVSerial?.observe(viewLifecycleOwner, Observer {
            val h = it
            viewModelSearchView?.id = it.results.get(0).id
            Log.d("Log", "$h")
            recyclerViewSearch.apply { adapter = AdapterApiSearch(h)
                layoutManager = LinearLayoutManager(context as MainActivity)
                setHasFixedSize(true) }
        })

        viewModelSearchView?.repositoryDetails?.observe(viewLifecycleOwner, Observer {



        })
        viewModelSearchView?.repositoryDetailsEpisode?.observe(viewLifecycleOwner, Observer {


        })
        viewModelSearchView?.repositoryContentRating?.observe(viewLifecycleOwner, Observer {

        })
    }
}







