package com.ajay.freelancer.uidemo;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;

import java.util.List;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p/>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class Settings1Activity  extends PreferenceActivity
{

    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener;
    private ListPreference listcolPreference;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppThemeSettings);
       // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);


        super.onCreate(savedInstanceState);
        // add the xml resource          
        addPreferencesFromResource(R.xml.pref_general);
//
//        SharedPreferences prefs = PreferenceManager
//                .getDefaultSharedPreferences(this);
//        prefs.registerOnSharedPreferenceChangeListener(this);
        //ListPreference colour = (ListPreference) findPreference("language_preference");
        ListPreference listPreference = (ListPreference) findPreference("language_preference");
        if(listPreference.getValue()==null) {
            // to ensure we don't get a null value
            // set first value by default
            listPreference.setValueIndex(0);
        }
        listPreference.setSummary(listPreference.getValue().toString());
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                preference.setSummary(newValue.toString());
                return true;
            }
        });

         listcolPreference = (ListPreference) findPreference("pref_col");
        if(listcolPreference.getValue()==null) {
            // to ensure we don't get a null value
            // set first value by default
            listcolPreference.setValueIndex(0);
        }
        listcolPreference.setSummary(listcolPreference.getValue().toString());
        listcolPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                preference.setSummary(newValue.toString());
                return true;
            }
        });
    }


}
