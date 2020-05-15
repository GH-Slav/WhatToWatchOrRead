package by.tms.whattowatchorread.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import by.tms.whattowatchorread.R

class NotificationsFragment : Fragment(R.layout.fragment_bottom_notifications) {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}
