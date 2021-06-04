package com.example.askmedic
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class Profile : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<Button>(R.id.appointments_btn).setOnClickListener{
            val go_to_map = Intent(this@Profile, ChooseAppointment::class.java)
            startActivity(go_to_map)

        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.app_bar_search -> {
            // User chose the "Settings" item, show the app settings UI...
            true
        }
        R.id.Reports -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            true
        }
        R.id.share -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            true
        }
        R.id.about -> {
            // User chose the "Favorite" action, mark the current item
            // as a favorite...
            true
        }
        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }


}