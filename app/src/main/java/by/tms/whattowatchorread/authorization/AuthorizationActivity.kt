package by.tms.whattowatchorread.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import by.tms.whattowatchorread.authorization.activity.LogInActivity
import by.tms.whattowatchorread.authorization.activity.RegActivity
import by.tms.whattowatchorread.authorization.fragment.LogInFragment
import by.tms.whattowatchorread.authorization.fragment.RegistrationFragment
import kotlinx.android.synthetic.main.activity_authorization.*

const val EMAIL = "EMAIL"
const val PASSWORD = "PASSWORD"

class AuthorizationActivity : AppCompatActivity(), View.OnClickListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        buttonLogIn.setOnClickListener(this)
        buttonRegisterNow.setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonLogIn -> {
 //               val fragmentLogin = LogInFragment()
 //               supportFragmentManager.beginTransaction().replace(R.id.fragmentMainScreen, fragmentLogin)
 //                   .commit()
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonRegisterNow -> {
 //               val fragmentRegistrationNew = RegistrationFragment()
 //               supportFragmentManager.beginTransaction()
 //                   .replace(R.id.fragmentMainScreen, fragmentRegistrationNew)
 //                   .commit()
                val intent = Intent(this, RegActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonSocialNetworkFive -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonSocialNetworkOne -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonSocialNetworkTwo -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonSocialNetworkThree -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.buttonSocialNetworkFour -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

    }
}
