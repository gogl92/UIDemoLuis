package com.ajay.freelancer.uidemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ajay.freelancer.adapters.CustomSectionAdapter;
import com.ajay.freelancer.adapters.SectionedGridRecyclerViewAdapter;
import com.ajay.freelancer.adapters.SimpleAdapter;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SimpleAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.gallery_layout, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));

        //Your RecyclerView.Adapter
        mAdapter = new SimpleAdapter(getActivity());

        //This is the code to provide a sectioned grid
        List<SectionedGridRecyclerViewAdapter.Section> sections =
                new ArrayList<SectionedGridRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SectionedGridRecyclerViewAdapter.Section(0, "Dec 2015"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(3, "Jan 2016"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(8, "Feb 2016"));
      //  sections.add(new SectionedGridRecyclerViewAdapter.Section(14, "Section 4"));
      //  sections.add(new SectionedGridRecyclerViewAdapter.Section(20, "Section 5"));

        //Add your adapter to the sectionAdapter
        SectionedGridRecyclerViewAdapter.Section[] dummy = new SectionedGridRecyclerViewAdapter.Section[sections.size()];
        SectionedGridRecyclerViewAdapter mSectionedAdapter = new
                SectionedGridRecyclerViewAdapter(getActivity(),R.layout.gallery_section,R.id.section_text,mRecyclerView,mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        mRecyclerView.setAdapter(mSectionedAdapter);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
