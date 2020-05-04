package by.tms.whattowatchorread.authorization.fragment

import android.R.attr.password
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.tms.whattowatchorread.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRegistrar
import com.google.firebase.auth.FirebaseUser

const val TAG = "TAG"
class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form_registration, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        val mAuth = FirebaseAuth.getInstance()
//        mAuth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener(this,
//                OnCompleteListener<AuthResult?> { task ->
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with the signed-in user's information
//                        Log.d(TAG, "createUserWithEmail:success")
//                        val user: FirebaseUser = mAuth.getCurrentUser()
//                        updateUI(user)
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                        Toast.makeText(
//                            this@EmailPasswordActivity, "Authentication failed.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        updateUI(null)
//                    }
//
//                    // ...
//                })

    }
}







