package com.example.askmedic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.askmedic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()//,Communicator
{

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        val secondFragment = SecondFragment()
//        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_content_main, secondFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

//    override fun passDataCom( editTextInput: String, ) {
//        val bundle = Bundle()
//        bundle.putString("message", editTextInput,)
//
//        val transaction = this.supportFragmentManager.beginTransaction()
//        val secondlogin = SecondLoginFragment()
//        secondlogin.arguments = bundle
//
//        transaction.replace(R.id.nav_host_fragment_content_main, secondlogin)
//        transaction.commit()
//    }


}