package com.example.judetesmainmenuxml.ui.liked

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LikedViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Liked Fragment"
    }

    val text: LiveData<String> = _text
}