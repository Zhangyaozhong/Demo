package com.wd.demo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wd.demo.fragment.CommunityFragment
import com.wd.demo.fragment.InformationFragment
import com.wd.demo.fragment.MessageFragment

/**
 * @name Demo
 * @class name：com.wd.demo.adapter
 * @author 张耀中
 * @time 2019/4/9 14:49
 */
class ViewPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val fragmentArray = arrayOf(InformationFragment(), MessageFragment(), CommunityFragment())
    override fun getItem(p0: Int): Fragment {
        return fragmentArray[p0]
    }

    override fun getCount(): Int {
        return 3
    }
}