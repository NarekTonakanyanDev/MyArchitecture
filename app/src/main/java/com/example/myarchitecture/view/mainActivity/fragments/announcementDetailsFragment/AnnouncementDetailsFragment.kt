package com.example.myarchitecture.view.mainActivity.fragments.announcementDetailsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.myarchitecture.databinding.AnnouncementDetailsBinding
import com.example.myarchitecture.shared.utils.AppConstants
import com.example.myarchitecture.view.baseView.BaseFragment


class AnnouncementDetailsFragment : BaseFragment() {

    private lateinit var mBinding: AnnouncementDetailsBinding
    private val mViewModel: AnnouncementDetailsViewModel by lazy { createViewModel(AnnouncementDetailsViewModel::class.java) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = AnnouncementDetailsBinding.inflate(inflater, container, false)

        initSubscribers()

        val id = arguments?.getInt(AppConstants.ID)
        mViewModel.getAnnouncementDetails(id)

        return mBinding.root
    }

    private fun initSubscribers() {
        requestSubscriber(mViewModel, mBinding.announcementDetailsStateLayout)

        mViewModel.getAnnouncementDetailsLiveData().observe(viewLifecycleOwner, Observer {
            mBinding.model = it
        })
    }
}