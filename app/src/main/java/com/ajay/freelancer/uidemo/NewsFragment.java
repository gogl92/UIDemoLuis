package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.os.Bundle;
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
public class NewsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.news_layout, container, false);
        ListView rv = (ListView)rootView.findViewById(R.id.messages_List);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        initializeData();
        //rv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        NewsAdapter adapter = new NewsAdapter(messagesList,getActivity());

        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(getActivity(),NewsDetailActivity.class);
                startActivity(i);
                Log.d("DEBUG","hereee");
            }
        });
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private List<Messages> messagesList;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        messagesList = new ArrayList<>();
        messagesList.add(new Messages("Synth polaroid bitters chillwave pickled. Vegan disrupt!", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("So strongly and metaphysically did I conceive of my situation then, that while earnestly.", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("Synth polaroid bitters chillwave pickled. Vegan disrupt!", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("So strongly and metaphysically did I conceive of my situation then, that while earnestly.", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("Synth polaroid bitters chillwave pickled. Vegan disrupt!", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("So strongly and metaphysically did I conceive of my situation then, that while earnestly.", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("Synth polaroid bitters chillwave pickled. Vegan disrupt!", "19 Jul","", R.drawable.pic1));
        messagesList.add(new Messages("So strongly and metaphysically did I conceive of my situation then, that while earnestly.", "19 Jul","", R.drawable.pic1));

    }
}
