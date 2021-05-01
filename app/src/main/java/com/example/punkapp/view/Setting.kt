package com.example.punkapp.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.punkapp.R

class Setting : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.setting_fragment, rootKey)
    }
}