package com.ajay.freelancer.uidemo;

import android.app.LocalActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * Created by msajaynath on 01/12/15.
 */
public class InfoFragment extends Fragment {

    private FragmentTabHost tabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tabHost = new FragmentTabHost(getActivity());
        tabHost.setup(getActivity(), getChildFragmentManager(), R.layout.fragment_tab_info);

        Bundle arg1 = new Bundle();
        arg1.putInt("Arg for Frag1", 1);
        tabHost.addTab(tabHost.newTabSpec("INFO").setIndicator("INFO"),
                InfoListFragment.class, arg1);

        Bundle arg2 = new Bundle();
        arg2.putInt("Arg for Frag2", 2);
        tabHost.addTab(tabHost.newTabSpec("CHECK-IN'S").setIndicator("CHECK-IN'S"),
                BranchesListFragment.class, arg2);

        Bundle arg3 = new Bundle();
        arg3.putInt("Arg for Frag3", 3);
        tabHost.addTab(tabHost.newTabSpec("PHOTOS").setIndicator("PHOTOS"),
                GalleryFragment.class, arg2);
//        tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.color.colorBluePrimary);
//        tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.color.colorBluePrimary);
//        tabHost.setse(Color.WHITE);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.getTabWidget().setStripEnabled(false);

        TabWidget widget = tabHost.getTabWidget();
        for(int i = 0; i < widget.getChildCount(); i++) {
            View v = widget.getChildAt(i);
            // tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.colorBluePrimary)); // selected

            // Look for the title view to ensure this is an indicator and not a divider.
            TextView tv = (TextView)v.findViewById(android.R.id.title);
            if(tv == null) {
                continue;
            }
            v.setBackgroundResource(R.drawable.tab_bar_background);
            tv.setTextSize(16);
        }
        //tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.colorBluePrimary)); // selected
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                TabWidget widget = tabHost.getTabWidget();
                for(int i = 0; i < widget.getChildCount(); i++) {
                    View v = widget.getChildAt(i);
                    // tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(getResources().getColor(R.color.colorBluePrimary)); // selected

                    // Look for the title view to ensure this is an indicator and not a divider.
                    TextView tv = (TextView)v.findViewById(android.R.id.title);

                    if(tv == null) {
                        continue;
                    }
                    tv.setTextColor(getResources().getColor(R.color.cardview_shadow_start_color));
                }
                View v = widget.getChildAt(tabHost.getCurrentTab());
                TextView tv = (TextView)v.findViewById(android.R.id.title);

                if(tv != null) {
                    tv.setTextColor(getResources().getColor(R.color.cardview_light_background));

                    ;
                }



            }
        });
        return tabHost;
    }
}