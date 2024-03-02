package com.example.homework23

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework23.databinding.FragmentFirstBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    private var picture =
        "https://catchsuccess.ru/wp-content/uploads/2/a/3/2a38c91431548a291a6b6019d9ecd3d7.jpeg"

    private var list = listOf("It's Kotlin!")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setOnclickListeners()
    }

    private fun setOnclickListeners() {
        binding?.btnChangeText?.setOnClickListener() {
            CoroutineScope(Dispatchers.IO).async {
                binding?.btnChangeText?.text = list.toString()
            }
        }
        binding?.btnLoadImage?.setOnClickListener() {

            CoroutineScope(Dispatchers.Main).launch {
                Glide.with(requireContext()).load(picture).into(binding?.ivPicture!!)
            }
        }

    }

}