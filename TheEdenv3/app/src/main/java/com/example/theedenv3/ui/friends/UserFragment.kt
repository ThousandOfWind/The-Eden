package com.example.theedenv3.ui.friends

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theedenv3.R
import android.widget.Toast

import com.example.theedenv3.data.sample.UserSample
import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.usr_list.*


class UserFragment : androidx.fragment.app.Fragment(),
    ItemClickListener {

    private lateinit var sampleAdapter: UserRecyclerViewAdapter
    private var samples = ArrayList<UserSample>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        samples.add(UserSample.XIAOLEE)
        samples.add(UserSample.XIAOMIN)
        samples.add(UserSample.XIAOWANG)
        samples.add(UserSample.XIAOZHANG)
        sampleAdapter = UserRecyclerViewAdapter(samples, this)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.usr_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = sampleAdapter
        }
        refresh_list.setOnRefreshListener {
            //Refresh items

            sampleAdapter.notifyDataSetChanged()
            refresh_list.isRefreshing = false
        }
    }
    override fun onItemSelected(index: Int) {
//        findNavController().navigate(samples[index].taskId)
        Toast.makeText(context, samples[index].toString() , Toast.LENGTH_SHORT)
    }

    companion object {
        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() = UserFragment()
    }
}