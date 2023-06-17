package com.example.core.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: VB? = null

    protected val binding: VB
        get() = _binding!!

    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initInject()

        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding.root)

        initUI()

        initObserves()

        initListeners()

    }

    abstract fun initInject()

    abstract fun initUI()

    abstract fun initObserves()

    abstract fun initListeners()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}