package com.proway.fake_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.proway.fake_api.databinding.MainActivityBinding
import com.proway.fake_api.view.FragmentProduct
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)

        setContentView(binding.root)

        replaceFrag(FragmentProduct())
    }

    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).commitNow()
    }
}