package com.example.askmedic

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.askmedic.databinding.FragmentThirdBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonThird.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }
        binding.signupDoctor.setOnClickListener{
            startActivity(Intent(this@ThirdFragment.context, DoctorsProfile::class.java))

            val id_time = System.currentTimeMillis().toString()

            val doctorname = binding.etFullname.text.toString()
            val doctorage = binding.etAge.text.toString()
            val institution = binding.etInstitution.text.toString()
            val specialty = binding.etSpeciality.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.doctorPassword.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Doctors")
            val Doctor = Doctor(doctorname, doctorage, institution, specialty, email, password)
            val new_id =doctorname + id_time

            database.child(new_id).setValue(Doctor).addOnSuccessListener {

                binding.etFullname.text.clear()
                binding.etAge.text.clear()
                binding.etInstitution.text.clear()
                binding.etSpeciality.text.clear()
                binding.etEmail.text.clear()
                binding.doctorPassword.text.clear()

                Toast.makeText(this.context,"Success", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{

                Toast.makeText(this.context,"Failed", Toast.LENGTH_SHORT).show()

            }

        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}