package by.tms.whattowatchorread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        CoroutineScope(Dispatchers.IO).launch {


            runSplashAndGoMainStop()

        }
    }

    suspend fun runSplashAndGoMainStop() {
        delay(2500)
        withContext(Dispatchers.Main) {
            startActivity(Intent(this@SplashScreenActivity, AuthorizationActivity::class.java))
        }
    }

}

