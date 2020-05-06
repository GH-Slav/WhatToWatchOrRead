package by.tms.whattowatchorread.authorization.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import by.tms.whattowatchorread.MainActivity
import by.tms.whattowatchorread.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_log_in.*

private val TAG = "LoginActivity"
//global variables
private var email: String? = null
private var password: String? = null
//UI elements
private var tvForgotPassword: TextView? = null
private var etEmail: EditText? = null
private var etPassword: EditText? = null
private var btnLogin: Button? = null
//Firebase references
private var mAuth: FirebaseAuth? = null

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        initLogIn()

    }

    private fun initLogIn() {
        tvForgotPassword = textForgotYourPasswordLog
        etEmail = editTextForgotPassword
        etPassword = editTextAuthorizationPassword
        btnLogin = buttonOkLogIn
        mAuth = FirebaseAuth.getInstance()
        tvForgotPassword!!
            .setOnClickListener {
                etEmail?.text?.clear()
                etPassword?.text?.clear()
                startActivity(
                Intent(this@LogInActivity,
                ForgotPasswordActivity::class.java)

            ) }

        btnLogin!!.setOnClickListener { loginUser() }
    }

    private fun loginUser() {

        email = etEmail?.text.toString()
        password = etPassword?.text.toString()

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {


            Log.d(TAG, "Logging in user.")

            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        updateUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.e(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(this@LogInActivity , "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateUI() {
        val intent = Intent(this@LogInActivity , MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }


}
