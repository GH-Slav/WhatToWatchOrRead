package by.tms.whattowatchorread.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.entity.multisearch.MultiSearch
import kotlinx.android.synthetic.main.fragment_bottom_search.*


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

        if (editSearch.text!!.isNotEmpty()){
        val query = editSearch.text.toString()}
        editSearch.text!!.clear()


        val searchViewModel = activity?.run {
            ViewModelProvider(this).get(SearchViewModel::class.java)
        }


        recyclerViewSearch.adapter = AdapterApiSearch(
            searchViewModel?.dataModelMultiSearch,
            searchViewModel?.dataModelDetails,
            searchViewModel?.dataModelDetailsEpisode,
            searchViewModel?.dataModelContentRatings
        )
        recyclerViewSearch.layoutManager = LinearLayoutManager(context as MainActivity)
        recyclerViewSearch.setHasFixedSize(true)

    }
}







