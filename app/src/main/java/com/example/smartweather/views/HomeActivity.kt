package com.example.smartweather.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smartweather.R
import com.example.smartweather.databinding.ActivityHomeBinding
import com.example.smartweather.viewModel.HomeViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription
import java.util.concurrent.TimeUnit

class HomeActivity : AppCompatActivity() {

    private val homeViewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }
    lateinit var bindingView: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_home)

        bindingView.apply {
            lifecycleOwner = this@HomeActivity
            homeViewModel.replaceFragment(this@HomeActivity, SplashScreenFragment.newInstance(), "")

            Observable.interval(4000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    homeViewModel.replaceFragment(this@HomeActivity, ListHomeFragment.newInstance(), "")
                }, { error -> })

        }

    }
}