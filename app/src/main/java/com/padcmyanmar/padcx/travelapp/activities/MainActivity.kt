package com.padcmyanmar.padcx.travelapp.activities

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer,HomeFragment.newInstance("a","b"))
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener{

                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.action_home -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.flContainer,HomeFragment.newInstance("a","b"))
                                .commit()
                            return true
                        }
                        R.id.action_rating -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.flContainer,RatingFragment.newInstance("a","b"))
                                .commit()
                            return true
                        }
                        R.id.action_favoirte -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.flContainer,FavoriteFragment.newInstance("a","b"))
                                .commit()
                            return true
                        }
                        R.id.action_price -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.flContainer,PriceFragment.newInstance("a","b"))
                                .commit()
                            return true
                        }
                        R.id.action_search -> {
                            supportFragmentManager.beginTransaction()
                                .replace(R.id.flContainer,SearchFragment.newInstance("a","b"))
                                .commit()
                            return true
                        }
                    }
                    return false
                }
            })
    }
}
