package me.factliverpool.tlrof.app.monitor.player

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.factliverpool.tlrof.R
import me.factliverpool.tlrof.custom.baselca.BaseFragment
import me.factliverpool.tlrof.databinding.FragmentPlayerBinding
import javax.inject.Inject

class PlayerFragment @Inject constructor() : BaseFragment() {

    private lateinit var binding: FragmentPlayerBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PlayerViewModel


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PlayerViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        handleNoInternetConnection(viewModel)

        viewModel.clockState.observe(this,
                Observer<Boolean> {
                    it?.let {

                        binding.showText.visibility = View.VISIBLE
                        Handler().postDelayed({ binding.showText.visibility = View.GONE }
                                , 5000)
                    }

                })


        viewModel.startListeningForInvitations()

    }
}