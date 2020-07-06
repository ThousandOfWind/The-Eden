package com.example.theedenv3.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.theedenv3.R
import com.example.theedenv3.data.sample.PlaceSample
import com.example.theedenv3.ui.town.PlaceAdapter


class TownFragment : Fragment() {
    private lateinit var townViewModel: TownViewModel
    private var samples = ArrayList<PlaceSample>()
    private lateinit var sampleAdapter: PlaceAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        townViewModel =
                ViewModelProviders.of(this).get(TownViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_town, container, false)
        val gridView: GridView = root.findViewById(R.id.gridview)
        initData()

        sampleAdapter = PlaceAdapter(samples,context)
        gridView.adapter = sampleAdapter
        return root
    }

    fun initData() {
        //图标
        samples.add(PlaceSample.SAMPLE_1)
        samples.add(PlaceSample.SAMPLE_2)
        samples.add(PlaceSample.SAMPLE_1)
        samples.add(PlaceSample.SAMPLE_1)
        samples.add(PlaceSample.SAMPLE_2)
        samples.add(PlaceSample.SAMPLE_1)
    }

    companion object {
        const val ARG_PAGE = "ARG_PAGE"
        fun newInstance(page: Int): TownFragment {
            val args = Bundle()
            args.putInt(ARG_PAGE, page)
            val pageFragment = TownFragment()
            pageFragment.setArguments(args)
            return pageFragment
        }
    }
}
