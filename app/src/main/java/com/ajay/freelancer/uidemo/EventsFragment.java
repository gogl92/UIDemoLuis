package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ajay.freelancer.adapters.EventsListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msajaynath on 01/12/15.
 */
public class EventsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.events_layout, container, false);
        ListView rv = (ListView)rootView.findViewById(R.id.messages_List);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        initializeData();
        //rv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        EventsListAdapter adapter = new EventsListAdapter(messagesList,getActivity());

        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Log.d("DEBUG", "hereee");
            }
        });
        //setHasOptionsMenu(true);

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
        messagesList.add(new Messages("Run The Jewels", "Run the Jewels is an American hip hop duo, formed by rappers El-P and Killer Mike in 2013. That same year, they released their sel...","Iron City, Birmingham, AL\n", R.drawable.events_cover1));
        messagesList.add(new Messages("The Growlers", "Run the Jewels is an American hip hop duo, formed by rappers El-P and Killer Mike in 2013. That same year, they released their sel...","Bahmas City, Algerina, AL\n", R.drawable.events_cover2));

    }





}
