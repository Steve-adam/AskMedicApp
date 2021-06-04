package com.example.askmedic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class DoctorsProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors_profile)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}


//override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//    menuInflater.inflate(R.menu.menu,menu)
//    return super.onCreateOptionsMenu(menu)
//
//}
//
//override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//    R.id.app_bar_search -> {
//        // User chose the "Settings" item, show the app settings UI...
//        true
//    }
//    R.id.Reports -> {
//        // User chose the "Favorite" action, mark the current item
//        // as a favorite...
//        true
//    }
//    R.id.share -> {
//        // User chose the "Favorite" action, mark the current item
//        // as a favorite...
//        true
//    }
//    R.id.about -> {
//        // User chose the "Favorite" action, mark the current item
//        // as a favorite...
//        true
//    }
//    else -> {
//        // If we got here, the user's action was not recognized.
//        // Invoke the superclass to handle it.
//        super.onOptionsItemSelected(item)
//    }
//}