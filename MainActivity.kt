package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener()
        {
            val firstName=binding.first.text.toString()
            val lastName=binding.last.text.toString()
            val age=binding.age.text.toString()

            val username=binding.username.text.toString()
            database= FirebaseDatabase.getInstance().getReference("User")
            val user1=User(firstName, lastName, age, username)
            database.child(username).setValue(user1).addOnSuccessListener {
                binding.first.text.clear()
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener(){
                Toast.makeText(this, "Not saved", Toast.LENGTH_SHORT).show()
            }
        }

    }
}