package com.ajay.freelancer.uidemo;


import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.wearable.internal.ChannelSendFileResponse;

import java.util.ArrayList;
import java.util.List;


public class BranchesListFragment extends Fragment {

    private static final String[] SUGGESTIONS = {
            "Restuarent Mosley Eisley", "Infinum", "Mojo Bar Wine, rakia & co.",
            "InMusic festival", "Fragern put"
    };
    private SimpleCursorAdapter mAdapter;
    private SearchView searchView;
    private MatrixCursor c;
    private ListView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.brancheslistview_layout, container, false);
         rv = (ListView)rootView.findViewById(R.id.messages_List);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        initializeData(null);
        //rv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        
        setHasOptionsMenu(true);
        final String[] from = new String[] {"cityName"};
        final int[] to = new int[] {android.R.id.text1};
        mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.suggesion_menu_layout,
                null,
                from,
                to,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

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
    private void initializeData(String query){
        messagesList = new ArrayList<>();
        if(query==null) {
            messagesList.add(new Messages("Restuarent Mosley Eisley", "Mos Eisley, Tatoonine", "110m", R.drawable.pic1));
            messagesList.add(new Messages("Infinum", "Strojaska Cest 22, Zagrb", "345m", R.drawable.pic1));
            messagesList.add(new Messages("Mojo Bar Wine, rakia & co.", "Fra Grg Martia 5", "380m", R.drawable.pic1));
            messagesList.add(new Messages("Krivia put", "Savska 14, Zagreb", "110m", R.drawable.pic1));
            messagesList.add(new Messages("Infinum", "Strojarska cesta 22, Zagreb", "1.3km", R.drawable.pic1));
            messagesList.add(new Messages("InMusic festival", "Strojarska cesta 22, Zagreb", "1.4km", R.drawable.pic1));
            messagesList.add(new Messages("Fragern put", "Savska 14, Zagreb", "2.4km", R.drawable.pic1));
        }
        else
        {
            List<Messages>  messagesListDump = new ArrayList<>();

            messagesListDump.add(new Messages("Restuarent Mosley Eisley", "Mos Eisley, Tatoonine", "110m", R.drawable.pic1));
            messagesListDump.add(new Messages("Infinum", "Strojaska Cest 22, Zagrb", "345m", R.drawable.pic1));
            messagesListDump.add(new Messages("Mojo Bar Wine, rakia & co.", "Fra Grg Martia 5", "380m", R.drawable.pic1));
            messagesListDump.add(new Messages("Krivia put", "Savska 14, Zagreb", "110m", R.drawable.pic1));
            messagesListDump.add(new Messages("Infinum", "Strojarska cesta 22, Zagreb", "1.3km", R.drawable.pic1));
            messagesListDump.add(new Messages("InMusic festival", "Strojarska cesta 22, Zagreb", "1.4km", R.drawable.pic1));
            messagesListDump.add(new Messages("Fragern put", "Savska 14, Zagreb", "2.4km", R.drawable.pic1));
            for(int i=0;i<messagesListDump.size();i++)
            {
                if(messagesListDump.get(i).heading.toLowerCase().startsWith(query.toLowerCase()))
                {

                    messagesList.add(messagesListDump.get(i));
                }

            }

        }
        BranchesListAdapter adapter = new BranchesListAdapter(messagesList,getActivity());

        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), CardsActivity.class);
                startActivity(i);
                Log.d("DEBUG", "hereee");
            }
        });
    }


        @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.search_menu, menu);
    }




    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
         searchView = (SearchView) MenuItemCompat
                .getActionView(menu.findItem(R.id.search));
        searchView.setSuggestionsAdapter(mAdapter);
        searchView.setIconifiedByDefault(false);
        // Getting selected (clicked) item suggestion
        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionClick(int position) {
                // Your code here
                String suggestion = getSuggestion(position);

                searchView.setQuery(suggestion, true);

                return true;
            }

            @Override
            public boolean onSuggestionSelect(int position) {
                // Your code here
                String suggestion = getSuggestion(position);

                searchView.setQuery(suggestion, true);
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                initializeData(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                populateAdapter(s);
                return false;
            }
        });
    }

    // You must implements your logic to get data using OrmLite
    private void populateAdapter(String query) {
          c = new MatrixCursor(new String[]{ BaseColumns._ID, "cityName" });
        for (int i=0; i<SUGGESTIONS.length; i++) {
            if (SUGGESTIONS[i].toLowerCase().startsWith(query.toLowerCase()))
                c.addRow(new Object[] {i, SUGGESTIONS[i]});
        }
        mAdapter.changeCursor(c);
    }

    private String getSuggestion(int position) {
        Cursor cursor = (Cursor) searchView.getSuggestionsAdapter().getItem(
                position);
        String suggest1 = cursor.getString(cursor.getColumnIndex("cityName"));
        return suggest1;
    }

}
