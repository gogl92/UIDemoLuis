package com.ajay.freelancer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ajay.freelancer.uidemo.Messages;
import com.ajay.freelancer.uidemo.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class NewsAdapter extends BaseAdapter{
    List<Messages> messages;
    static Context c;

    public NewsAdapter(List<Messages> persons, Context c){
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
        CircularImageView personPhoto;

        if (inflater == null)
            inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.news_listview, null);

        title = (TextView)convertView.findViewById(R.id.message_title);
        content = (TextView)convertView.findViewById(R.id.message_content);

        content.setText(messages.get(position).content);
        title.setText(messages.get(position).heading);
       // time.setText(messages.get(position).time);
       // personPhoto.setImageResource(messages.get(position).photoId);


        return  convertView;
    }
    private LayoutInflater inflater;

    }
