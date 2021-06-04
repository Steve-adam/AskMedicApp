@file:Suppress("UNREACHABLE_CODE")

package com.example.askmedic

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.askmedic.databinding.FragmentSecondBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second_login.*


class SecondLoginFragment : Fragment() {

    private lateinit var _binding: SecondLoginFragment
    private lateinit var database :DatabaseReference
    private val binding get() = _binding!!

    var displayMessage: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_login, container, false)

        displayMessage = arguments?.getString("message")


        binding.button_back.setOnClickListener{

            val username : String = binding.loginName.text.toString()
            if(username.isNotEmpty()){
               readData(username)
            }else{
                Toast.makeText(this.context,"Please Enter the username",Toast.LENGTH_SHORT).show()
            }

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }



    private fun readData(username: String) {

        val newID = displayMessage
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(newID.toString()).get().addOnSuccessListener {

            if (it.exists()) {
                val username = it.child("name").value
                val email = it.child("email").value
                val password = it.child("password").value
                Toast.makeText(this.context,"Successfully Loggged In!!",Toast.LENGTH_SHORT).show()

                binding.loginName.text.clear()
                binding.loginEmail.text.clear()
                binding.loginPassword.text.clear()

                binding.loginName.text.toString()
                binding.loginEmail.text.toString()
                binding.loginPassword.text.toString()


           }else{
                Toast.makeText(this.context,"user doesnt exists",Toast.LENGTH_SHORT).show()
           }
        }.addOnFailureListener{
            Toast.makeText(this.context,"Sorry mate",Toast.LENGTH_SHORT).show()
        }
    }


}