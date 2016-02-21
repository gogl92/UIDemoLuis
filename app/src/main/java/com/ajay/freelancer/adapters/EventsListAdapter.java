package com.ajay.freelancer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajay.freelancer.uidemo.EventsDetailActivity;
import com.ajay.freelancer.uidemo.Messages;
import com.ajay.freelancer.uidemo.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class EventsListAdapter extends BaseAdapter{
    List<Messages> messages;
    static Context c;

    public EventsListAdapter(List<Messages> persons, Context c){
        this.messages = persons;
        this.c=c;
    }


    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Messages getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView title,content,time;
      ImageView personPhoto;

        if (inflater == null)
            inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.events_listview, null);
        CardView card= (CardView) convertView.findViewById(R.id.card_view);
        title = (TextView)convertView.findViewById(R.id.title);
        time = (TextView)convertView.findViewById(R.id.message_title);
        content = (TextView)convertView.findViewById(R.id.content);
        personPhoto = (ImageView)convertView.findViewById(R.id.person_photo);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, EventsDetailActivity.class);
                c.startActivity(i);

            }
        });

        content.setText(messages.get(position).content);
        title.setText(messages.get(position).heading);
        time.setText(messages.get(position).time);
        personPhoto.setImageResource(messages.get(position).photoId);


        return  convertView;
    }
    private LayoutInflater inflater;

    }
