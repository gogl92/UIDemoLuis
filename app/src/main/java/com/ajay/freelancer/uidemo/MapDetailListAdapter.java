package com.ajay.freelancer.uidemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MapDetailListAdapter extends BaseAdapter{
    List<Messages> messages;
    static Context c;

    MapDetailListAdapter(List<Messages> persons, Context c){
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
        ImageView img;
        if (inflater == null)
            inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.mapdetaillist_listview, null);

        img = (ImageView)convertView.findViewById(R.id.person_photo);
        title = (TextView)convertView.findViewById(R.id.message_title);
        time = (TextView)convertView.findViewById(R.id.message_time);
        content = (TextView)convertView.findViewById(R.id.message_content);
        img.setBackgroundResource(messages.get(position).photoId);
        content.setText(messages.get(position).content);
        title.setText(messages.get(position).heading);
        time.setText(messages.get(position).time);


        return  convertView;
    }
    private LayoutInflater inflater;

    }
