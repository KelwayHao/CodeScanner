package com.example.codescanner.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.codescanner.data.room.CodeScanEntity
import kotlinx.coroutines.flow.Flow

fun FragmentActivity.openFragment(idFrameFragment: Int, fragment: Fragment, tag: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(idFrameFragment, fragment, tag)
        .addToBackStack(tag)
        .commit()
}
