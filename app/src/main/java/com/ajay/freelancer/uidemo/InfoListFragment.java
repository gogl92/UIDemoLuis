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

import com.ajay.freelancer.adapters.CustomSectionAdapter;

import java.util.ArrayList;
import java.util.List;


public class InfoListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.infolistview_layout, container, false);
        ListView rv = (ListView)rootView.findViewById(R.id.info_List);

        initializeData();
        //rv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        CustomSectionAdapter adapter = new CustomSectionAdapter(getActivity());
        adapter.addSectionHeaderItem(new Messages("Score", "Score","", R.drawable.pic1));

        adapter.addItem(new Messages("Rank", "149.", "", R.drawable.pic1));
        adapter.addItem(new Messages("Point", "284289","", R.drawable.pic1));
        adapter.addSectionHeaderItem(new Messages("Contact", "Contact", "", R.drawable.pic1));

        adapter.addItem(new Messages("Street Address 145,", "","", R.drawable.pic1));
        adapter.addItem(new Messages("+385 01 2345 678", "","", R.drawable.pic1));
        adapter.addItem(new Messages("contact@example.com", "","", R.drawable.pic1));
        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i=new Intent(getActivity(),CardsActivity.class);
                startActivity(i);
                Log.d("DEBUG", "hereee");
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
        messagesList.add(new Messages("Restuarent Mosley Eisley", "Mos Eisley, Tatoonine","110m", R.drawable.pic1));
        messagesList.add(new Messages("Infinum", "Strojaska Cest 22, Zagrb","345m", R.drawable.pic1));
        messagesList.add(new Messages("Mojo Bar Wine, rakia & co.", "Fra Grg Martia 5","380m", R.drawable.pic1));
        messagesList.add(new Messages("Krivia put", "Savska 14, Zagreb","110m", R.drawable.pic1));
        messagesList.add(new Messages("Infinum", "Strojarska cesta 22, Zagreb","1.3km", R.drawable.pic1));
        messagesList.add(new Messages("InMusic festival", "Strojarska cesta 22, Zagreb","1.4km", R.drawable.pic1));
        messagesList.add(new Messages("Fragern put", "Savska 14, Zagreb","2.4km", R.drawable.pic1));

    }
}
