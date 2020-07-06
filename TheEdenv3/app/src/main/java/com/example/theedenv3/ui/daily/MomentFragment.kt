package com.example.theedenv3.ui.daily

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.theedenv3.R
import android.widget.Toast
import com.example.theedenv3.data.sample.MomentSample

import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.fragment_task_list.*


class MomentFragment : androidx.fragment.app.Fragment(),
    ItemClickListener {

    private lateinit var sampleAdapter: MomentRecyclerViewAdapter
    private var samples = ArrayList<MomentSample>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        samples.add(MomentSample.SAMPLE_1)
        samples.add(MomentSample.SAMPLE_2)
        samples.add(MomentSample.SAMPLE_1)
        samples.add(MomentSample.SAMPLE_2)
        sampleAdapter = MomentRecyclerViewAdapter(samples, this)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate(R.layout.fragment_task_list, container, false)

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
        Toast.makeText(context, samples[index].user_name.toString() + samples[index].punch_time, Toast.LENGTH_SHORT)
    }

    companion object {
        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() = MomentFragment()
    }
}