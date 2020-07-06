package com.example.theedenv3.ui.daily

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.example.theedenv3.R
import com.google.android.material.tabs.TabLayout


class DailyFragment : Fragment() {
    //Tab标题
    private val title = arrayOf("收藏", "推荐", "小组", "动态")
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout

    companion object {
        fun newInstance() = DailyFragment()
    }

    private lateinit var viewModel: DailyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val root = inflater.inflate(R.layout.daily_fragment, container, false)
        viewPager = root.findViewById(R.id.viewpager_tab)
        tabLayout = root.findViewById(R.id.daily_tab)

        //使用适配器将ViewPager与Fragment绑定在一起
        viewPager.adapter = MyFragmentPagerAdapter(childFragmentManager)
        //将TabLayout与ViewPager绑定
        tabLayout.setupWithViewPager(viewPager)

        initData()
        initListener()
//        supportActionBar!!.hide() //隐藏掉整个ActionBar


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
        viewModel = ViewModelProviders.of(this).get(DailyViewModel::class.java)
        // TODO: Use the ViewModel
    }

    //自定义适配器
    inner class MyFragmentPagerAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            if (position == 1) {
                return TaskFragment() //娱乐
            } else if (position == 2) {
                return TaskFragment() //游戏
            } else if (position == 3) {
                return MomentFragment() //我的
            }
            return TaskFragment() //首页
        }

        override fun getCount(): Int {
            return title.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return title[position]
        }
    }

}
