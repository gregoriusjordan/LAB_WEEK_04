package com.example.lab_week_04

import androidx.annotation.StringRes // Import this
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Keep TABS_FIXED here, or move it if it's more globally used
val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title,
)

class CafeAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return TABS_FIXED.size
    }

    override fun createFragment(position: Int): Fragment {
        // Assuming CafeDetailFragment is correctly defined and takes arguments if needed
        return CafeDetailFragment.newInstance(TABS_FIXED[position]) // Example: Pass the title Res ID
    }

    // Add this method to get the string resource ID for the tab title
    @StringRes
    fun getTabTitle(position: Int): Int {
        return TABS_FIXED[position]
    }
}