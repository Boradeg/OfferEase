package com.example.geofencing_food_place
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.telephony.TelephonyCallback.UserMobileDataStateListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.shashank.sony.fancytoastlib.FancyToast


class UserLogin : AppCompatActivity() {

    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlogin)

        val edemail = findViewById<TextInputEditText>(R.id.email)
        val edpassword = findViewById<TextInputEditText>(R.id.pass)
        val btnlogin = findViewById<AppCompatButton>(R.id.login_btn)
        val txtforgotuser = findViewById<TextView>(R.id.tv_forget_password)
        val txtreguser = findViewById<TextView>(R.id.sign_up)
        val back = findViewById<ImageView>(R.id.back_btn_user_login)
        back.setOnClickListener(){
            val intent = Intent(applicationContext,Myhome::class.java)
            startActivity(intent)
            finish()
        }
        //got to register activity

        txtreguser.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        auth = FirebaseAuth.getInstance()

        //login
        btnlogin.setOnClickListener {

            if(edemail.text!!.isEmpty()) {
                edemail.setError("Enter Email Id")
                return@setOnClickListener
            }
            else if (edpassword.text!!.isEmpty()){
                edpassword.setError("Enter Password")
                return@setOnClickListener
            }



            auth.signInWithEmailAndPassword(edemail.text.toString(),edpassword.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        FancyToast.makeText(this,"Success",FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS,true).show()
                        //Toast.makeText(applicationContext,"successfully Login", Toast.LENGTH_LONG).show()
                        val intent = Intent(applicationContext, UserDashboard2::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else
                    {
                        FancyToast.makeText(this,"Failed to login",FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                      //  Toast.makeText(applicationContext,"Failed to login", Toast.LENGTH_LONG).show()
                    }
                }
        }

        //forgot password
        txtforgotuser.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Forgot Password")
            val view = layoutInflater.inflate(R.layout.dailog_forgot,null)
            val username = view.findViewById<EditText>(R.id.ed_forgot)
            builder.setView(view)
            builder.setPositiveButton("Reset", DialogInterface.OnClickListener { _, _ ->
                forgotpassword(username)
            })
            builder.setNegativeButton("Close", DialogInterface.OnClickListener { _, _ ->  })
            builder.show()

        }
    }

    private fun forgotpassword(username: EditText?) {

        auth.sendPasswordResetEmail(username!!.text.toString())
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                    FancyToast.makeText(this,"Email Sent",FancyToast.LENGTH_LONG,
                        FancyToast.SUCCESS,true).show()
                    //Toast.makeText(applicationContext,"Email Sent", Toast.LENGTH_LONG).show()
                }
            }



    }
}