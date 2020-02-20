package com.padcmyanmar.padcx.travelapp.activities

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.padcx.travelapp.R
import com.padcmyanmar.padcx.travelapp.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val pagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.currentItem = 0

        bottomNavigation.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener{

                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when(item.itemId){
                        R.id.action_home -> {
                            viewPager.currentItem = 0
                            return true
                        }
                        R.id.action_rating -> {
                            viewPager.currentItem = 1
                            return true
                        }
                        R.id.action_favoirte -> {
                            viewPager.currentItem = 2
                            return true
                        }
                        R.id.action_price -> {
                            viewPager.currentItem = 3
                            return true
                        }
                        R.id.action_search -> {
                            viewPager.currentItem = 4
                            return true
                        }
                    }
                    return false
                }
            })
    }
}
