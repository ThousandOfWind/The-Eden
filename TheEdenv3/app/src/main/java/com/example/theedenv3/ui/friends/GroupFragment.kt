package com.example.theedenv3.ui.friends

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.theedenv3.R
import android.widget.Toast
import com.example.theedenv3.data.predefine.GroupRewardRule
import com.example.theedenv3.data.sample.GroupTaskSample

import com.example.theedenv3.data.sample.UserSample
import com.example.theedenv3.util.ItemClickListener
import kotlinx.android.synthetic.main.fragment_group.*


class GroupFragment : androidx.fragment.app.Fragment(),
    ItemClickListener {

    private lateinit var rewAdapter: RewardAdapter
    private var groupRewards = ArrayList<GroupRewardRule>()

    private lateinit var groupMemberSampleAdapter: UserImgAdapter
    private var groupMemberSamples = ArrayList<UserSample>()

    private lateinit var groupTaskSamplesAdapter: GroupTaskRecyclerViewAdapter
    private var groupTaskSamples = ArrayList<GroupTaskSample>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        groupTaskSamples.add(GroupTaskSample.BEDROOM_TASK)
        groupTaskSamples.add(GroupTaskSample.GYM_TASK)
        groupTaskSamplesAdapter = GroupTaskRecyclerViewAdapter(groupTaskSamples, this)
        setHasOptionsMenu(true)

    }

    fun initData(){
        groupRewards.clear()
        groupRewards.add((GroupRewardRule.R1))
        groupRewards.add((GroupRewardRule.R2))
        groupRewards.add((GroupRewardRule.R2))
        rewAdapter = RewardAdapter(groupRewards, context)

        groupMemberSamples.clear()
        groupMemberSamples.add(UserSample.XIAOLEE)
        groupMemberSamples.add(UserSample.XIAOMIN)
        groupMemberSamples.add(UserSample.XIAOWANG)
        groupMemberSamples.add(UserSample.XIAOZHANG)
        groupMemberSamples.add(UserSample.NEW)
        groupMemberSampleAdapter = UserImgAdapter(groupMemberSamples, context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View?{
        val root = inflater.inflate(R.layout.fragment_group, container, false)
        val gridview_reward: GridView = root.findViewById(R.id.gridview_reward)
        val gridview_groupmember: GridView = root.findViewById(R.id.gridview_groupmember)
        initData()
        gridview_reward.adapter = rewAdapter
        gridview_groupmember.numColumns = groupMemberSamples.size
        gridview_groupmember.adapter = groupMemberSampleAdapter
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initData()
//        gridview_reward.adapter = rewAdapter
//        gridview_groupmember.numColumns = min(4, groupMemberSamples.size)
//        gridview_groupmember.adapter = groupMemberSampleAdapter
        list_grouptask.apply {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = groupTaskSamplesAdapter
        }
        refresh_list.setOnRefreshListener {
            //Refresh items
            groupTaskSamplesAdapter.notifyDataSetChanged()
            refresh_list.isRefreshing = false
        }
    }
    override fun onItemSelected(index: Int) {
//        findNavController().navigate(samples[index].taskId)
        Toast.makeText(context, groupTaskSamples[index].toString() , Toast.LENGTH_SHORT)
    }

    companion object {
        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() = GroupFragment()
    }
}