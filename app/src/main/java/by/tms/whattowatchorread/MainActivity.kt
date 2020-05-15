package by.tms.whattowatchorread

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*




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
        val titleToolbarThree = resources.getString(R.string.title_top)
        val titleToolbarFour = resources.getString(R.string.title_history)
        val titleToolbarFive = resources.getString(R.string.title_notifications)
        val titleToolbarDefault = resources.getString(R.string.app_name)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            topAppBar.title = when (destination.id) {
                R.id.navigation_search -> titleToolbarOne
                R.id.navigation_bookmark -> titleToolbarTwo
                R.id.navigation_top -> titleToolbarThree
                R.id.navigation_history -> titleToolbarFour
                R.id.navigation_notifications -> titleToolbarFive
                else -> titleToolbarDefault
            }
        }
        //    setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
