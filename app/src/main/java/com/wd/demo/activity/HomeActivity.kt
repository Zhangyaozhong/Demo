package com.wd.demo.activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.wd.demo.R
import com.wd.demo.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val itemId = item.itemId
        if (itemId == R.id.item_information) {
            viewpager.currentItem = 0
            return true
        } else if (itemId == R.id.item_message) {
            viewpager.currentItem = 1
        } else {
            viewpager.currentItem = 2
        }
        return false
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    @SuppressLint("ResourceType")
    override fun onPageSelected(position: Int) {
        bottom_navigation.menu.getItem(position).isChecked = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initBottomNav()
        initListener()
    }

    private fun initListener() {
        viewpager.addOnPageChangeListener(this)
        //为viewpager设置adapter
        viewpager.adapter = ViewPagerAdapter(supportFragmentManager)
        bottom_navigation.setOnNavigationItemSelectedListener(this)

    }

    //    导航栏的设置
    @SuppressLint("PrivateResource")
    private fun initBottomNav() {
        //        取消导航栏图标着色
        bottom_navigation.itemIconTintList = null

        /**设置MenuItem的字体颜色**/

        val colorStateList = resources.getColorStateList(R.color.dim_foreground_disabled_material_light)
        bottom_navigation.itemTextColor = colorStateList
        /**设置MenuItem默认选中项**/
        bottom_navigation.menu.getItem(0).isChecked = true

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && Build.VERSION.SDK_INT > 19) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }
}
