package com.ajay.freelancer.uidemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.tooltip.Tooltip;

/**
 * Created by msajaynath on 01/12/15.
 */
public class InBoxFragment extends Fragment {
    private ListView rv;
    private DisplayMetrics displayMetrics;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.inbox_layout, container, false);
         rv = (ListView)rootView.findViewById(R.id.messages_List);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());

        initializeData();
        //rv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).build());

        MessagesAdapter adapter = new MessagesAdapter(messagesList,getActivity());

        rv.setAdapter(adapter);
        rv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getActivity(), CardsActivity.class);
                startActivity(i);
                Log.d("DEBUG", "hereee");
            }
        });
        displayMetrics = getResources().getDisplayMetrics();

        rv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

       // new EasyDialog()


                Tooltip.make(getActivity(),
                        new Tooltip.Builder(101)
                                .anchor(view, Tooltip.Gravity.BOTTOM)
                                .closePolicy(new Tooltip.ClosePolicy()
                                        .insidePolicy(true, false)
                                        .outsidePolicy(true, false), 3000)
                                .activateDelay(800)
                                .showDelay(300)
                                .text("Learn more about this feature in a sentence or two. Its great!")
                                .maxWidth(500)
                                .withArrow(true)
                                .withOverlay(true)
                                .floatingAnimation(Tooltip.AnimationBuilder.DEFAULT)
                                .maxWidth((int) (displayMetrics.widthPixels - 20))
                               // .withStyleId(R.styleable.TooltipLayout)
                                .build()

                ).show();
                return false;
            }
        });
       
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // View vv=rv.getChildAt(0).findViewById(R.id.person_photo);

    }

    private List<Messages> messagesList;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData(){
        messagesList = new ArrayList<>();
        messagesList.add(new Messages("Alvin Armstrong", "This is a sample message that crosses over in two lines and goes on for a while.","2h", R.drawable.pic1));
        messagesList.add(new Messages("Lisa Richards", "This is a sample message that crosses over in two lines and goes on for a while.","3h", R.drawable.pic2));
        messagesList.add(new Messages("Owen Brown", "This is a sample message that crosses over in two lines and goes on for a while.","10h", R.drawable.pic3));
        messagesList.add(new Messages("Leser Naygaard", "This is a sample message that crosses over in two lines and goes on for a while.","5h", R.drawable.pic4));
        messagesList.add(new Messages("Lonar Malvo", "This is a sample message that crosses over in two lines and goes on for a while.","2h", R.drawable.pic5));
        messagesList.add(new Messages("James Garnfeld", "This is a sample message that crosses over in two lines and goes on for a while.","3h", R.drawable.pic6));
        messagesList.add(new Messages("Alvin Armstrong", "This is a sample message that crosses over in two lines and goes on for a while.","2h", R.drawable.pic7));

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem item3  = menu.findItem(R.id.search);
        item3.setVisible(false);
    }
}
