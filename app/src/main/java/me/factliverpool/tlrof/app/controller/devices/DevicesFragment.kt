package me.factliverpool.tlrof.app.controller.devices

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.factliverpool.tlrof.R
import me.factliverpool.tlrof.custom.baselca.BaseFragment
import me.factliverpool.tlrof.databinding.FragmentDevicesBinding
import javax.inject.Inject

class DevicesFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentDevicesBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: DevicesViewModel


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_devices, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DevicesViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        handleNoInternetConnection(viewModel)

//        viewModel.clockState.observe(this,
//                Observer<String> {
//                    it?.let {
//
//                        binding.currentStateTextView.visibility = View.VISIBLE
//                        binding.currentStateTextView.text = it
//
//                        Handler().postDelayed({ binding.currentStateTextView.visibility = View.GONE }
//                                , 5000)
//                    }
//
//                })


        viewModel.startListeningForInvitations()

    }
}