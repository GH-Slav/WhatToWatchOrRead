package by.tms.whattowatchorread.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import by.tms.whattowatchorread.R

class BookmarkFragment : Fragment(R.layout.fragment_bottom_bookmark) {

    private lateinit var bookmarkViewModel: BookmarkViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}
