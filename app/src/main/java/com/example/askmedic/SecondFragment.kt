package com.example.askmedic

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.askmedic.databinding.FragmentSecondBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment(){

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private lateinit var database: DatabaseReference
//    private lateinit var communicator: Communicator



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

//        communicator = activity as Communicator

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.signupPatient.setOnClickListener {

            val id_time = System.currentTimeMillis().toString()
            val name = binding.etName.text.toString().trim()
            val age = binding.etAge.text.toString()
            val residence = binding.etresidence.text.toString()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etpassword.text.toString()

            val appProgress = showProgress()
            val new_id = name + id_time


                database = FirebaseDatabase.getInstance().getReference("Users")
                val User = User(name, age, residence, email, password)
                 //Generate user id using name and sign up time


                appProgress.show()
                database.child(new_id).setValue(User).addOnSuccessListener {
                    appProgress.dismiss()

                    binding.etName.text.clear()
                    binding.etAge.text.clear()
                    binding.etresidence.text.clear()
                    binding.etEmail.text.clear()
                    binding.etpassword.text.clear()

                    Toast.makeText(this.context,"Success",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{

                    Toast.makeText(this.context,"Failed",Toast.LENGTH_SHORT).show()

                }

                startActivity(Intent(this@SecondFragment.context, Profile::class.java))



//            communicator.passDataCom(new_id)


        }
    }

    fun showProgress(): ProgressDialog {
        val progress = ProgressDialog(this.context)
        progress.setTitle("Saving...")
        progress.setMessage("Please wait as data is being saved")
        return progress
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

