package by.tms.whattowatchorread.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import by.tms.whattowatchorread.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_bottom_history.*

class HistoryFragment : Fragment() {

    private lateinit var modelHistory: HistoryViewModel
    private lateinit var viewPage: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var fragmentYou: YouFragment
    private lateinit var fragmentFriends: FriendsFragment


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_history, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val modelHistory = ViewModelProvider(this).get(HistoryViewModel::class.java)

        viewPage = view_pager_history
        tabLayout = tabs_history

        fragmentYou = YouFragment()
        fragmentFriends = FriendsFragment()

        tabLayout.setupWithViewPager(viewPage)

        viewPage.adapter
        view_pager_history.adapter


   //     val viewPagerAdapter = HistoryViewPagerAdapter(this,  0)





    }
}

