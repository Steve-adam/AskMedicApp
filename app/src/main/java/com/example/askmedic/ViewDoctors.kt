package com.example.askmedic

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_view_doctors.*

class ViewDoctors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_doctors)

        getUsers()

    }
    fun getUsers(){

        val usersarray:ArrayList<Doctor> = ArrayList()
        val myAdapter = CustomAdapter(this, usersarray)

        val progress = showProgress()
        progress.show()

        val firebase_ref = FirebaseDatabase.getInstance().reference.child("Doctors")

        firebase_ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                usersarray.clear()
                for(snap in snapshot.children){
                    val user = snap.getValue(Doctor::class.java)
                    usersarray.add(user!!)
                }
                myAdapter.notifyDataSetChanged()
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                progress.dismiss()
                showMessage("Databased is locked","Please try again when available")
            }

        })
        userList.adapter = myAdapter


    }
    fun showMessage(title:String, message: String){
        val dialogBox = AlertDialog.Builder(this)
        dialogBox.setTitle(title)
        dialogBox.setMessage(message)
        dialogBox.setPositiveButton("OK",{dialog, which -> dialog.dismiss() })
        dialogBox.create().show()
    }
    fun showProgress(): ProgressDialog{
        val progress = ProgressDialog(this)
        progress.setTitle("Saving...")
        progress.setMessage("Please wait while data is being retrieved")
        return progress
    }
}