package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.StringRes

class CafeDetailFragment : Fragment() {

    private var cafeTitleResId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cafeTitleResId = it.getInt(ARG_CAFE_TITLE_RES_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cafe_detail, container, false)
        val titleTextView = view.findViewById<TextView>(R.id.cafe_detail_title_textview)
        if (cafeTitleResId != 0) {
            titleTextView.text = getString(cafeTitleResId)
        } else {
            titleTextView.text = "Cafe Details"
        }
        return view
    }

    companion object {
        private const val ARG_CAFE_TITLE_RES_ID = "cafe_title_res_id"

        @JvmStatic
        fun newInstance(@StringRes cafeTitleResId: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CAFE_TITLE_RES_ID, cafeTitleResId)
                }
            }
    }
}