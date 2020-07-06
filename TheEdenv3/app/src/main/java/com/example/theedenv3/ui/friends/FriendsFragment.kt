package com.example.theedenv3.ui.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.theedenv3.R
import com.example.theedenv3.ui.friends.GroupFragment
import com.example.theedenv3.ui.friends.UserFragment
import com.google.android.material.tabs.TabLayout

class FriendsFragment : Fragment() {
    private val title = arrayOf("小组", "我关注的", "关注我的")
    private lateinit var friendsViewModel: FriendsViewModel
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    companion object {
        fun newInstance() = FriendsFragment()
    }


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        friendsViewModel =
                ViewModelProviders.of(this).get(FriendsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_friends, container, false)
        tabLayout = root.findViewById(R.id.friends_tab)
        viewPager = root.findViewById(R.id.friends_viewpager)

        //使用适配器将ViewPager与Fragment绑定在一起
        viewPager.adapter = MyFragmentPagerAdapter(childFragmentManager)
        //将TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager)

        initData()
        initListener()
        return root
    }

    private fun initData() {}
    private fun initListener() {
//        //TabLayout切换时导航栏图片处理
//        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) { //选中图片操作
//                for (i in title.indices) {
//                    if (tab === tabLayout!!.getTabAt(i)) {
//                        tabLayout!!.getTabAt(i)!!.setIcon(selectTabRes[i])
//                        viewPager!!.currentItem = i
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab) { //未选中图片操作
//                for (i in title.indices) {
//                    if (tab === tabLayout!!.getTabAt(i)) {
//                        tabLayout!!.getTabAt(i)!!.setIcon(unSelectTabRes[i])
//                    }
//                }
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var viewModel = ViewModelProviders.of(this).get(FriendsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    //自定义适配器
    inner class MyFragmentPagerAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            if (position == 1) {
                return UserFragment()
            } else if (position == 2) {
                return UserFragment()
            }
            return GroupFragment()
        }

        override fun getCount(): Int {
            return title.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return title[position]
        }
    }

}
