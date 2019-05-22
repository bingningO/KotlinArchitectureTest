package com.example.zhubingning.kotlinarchitecturetest.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.zhubingning.kotlinarchitecturetest.R
import com.example.zhubingning.kotlinarchitecturetest.di.component.DaggerActivityComponent
import com.example.zhubingning.kotlinarchitecturetest.di.module.ActivityModule
import javax.inject.Inject

class MainActivity: AppCompatActivity(), MainContract.View {
    override fun showAboutFragment() {
        // todo
    }

    override fun showListFragment() {
        // todo
    }

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)
    }

    private fun injectDependency() {
	    val activityComponent = DaggerActivityComponent.builder()
			    .activityModule(ActivityModule(this))
			    .build()

	    activityComponent.inject(this)
    }
}
