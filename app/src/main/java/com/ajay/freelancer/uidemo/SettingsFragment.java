package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ajay.freelancer.adapters.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msajaynath on 01/12/15.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML res
        // ource
        addPreferencesFromResource(R.xml.pref_general);
    }

}