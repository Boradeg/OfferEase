package com.example.geofencing_food_place

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth

    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextInputEditText>(R.id.username_si)
        val number = findViewById<TextInputEditText>(R.id.number_si)
        val email = findViewById<TextInputEditText>(R.id.email_si)
        val password = findViewById<TextInputEditText>(R.id.password_si)
        val btn = findViewById<AppCompatButton>(R.id.sign_up_si)
        val back = findViewById<RelativeLayout>(R.id.back_btn_act_main)
        back.setOnClickListener(){
            val intent = Intent(applicationContext,Myhome::class.java)
            startActivity(intent)
            finish()
        }

        val txtloginuser = findViewById<TextView>(R.id.sign_up_tv_s)

        txtloginuser.setOnClickListener(){
            val intent = Intent(applicationContext,login::class.java)
            startActivity(intent)
            finish()
        }


        auth = FirebaseAuth.getInstance()

        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("User")

        btn.setOnClickListener {
            if(name.text!!.isEmpty())
            {
                name.setError("Enter name")
                return@setOnClickListener
            }else if(password.text!!.isEmpty())
            {
                password.setError("Enter Password ")
                return@setOnClickListener
            }else if(number.text!!.isEmpty())
            {
                number.setError("Enter Contact Number")
                return@setOnClickListener
            }else if(email.text!!.isEmpty())
            {
                email.setError("Enter Email id")
                return@setOnClickListener
            }


            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful)
                    {
                        val currentuser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentuser?.uid!!))
                        currentUserdb?.child("name")?.setValue(name.text.toString())


                        currentUserdb?.child("number")?.setValue(number.text.toString())
                        FancyToast.makeText(this,"Success", FancyToast.LENGTH_LONG,
                            FancyToast.SUCCESS,true).show()
                        //Toast.makeText(applicationContext,"success", Toast.LENGTH_LONG).show()
                        sharedata(email.text.toString())

                    }
                    else
                    {
                        FancyToast.makeText(this,"failed",FancyToast.LENGTH_LONG,
                            FancyToast.ERROR,true).show()
                        //Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    private fun sharedata(email: String) {

        val editor = getSharedPreferences("My", MODE_PRIVATE).edit()
        editor.putString("mail", email)


        editor.apply()
        editor.commit()


    }
}