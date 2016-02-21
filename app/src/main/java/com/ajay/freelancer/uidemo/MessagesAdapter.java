package com.ajay.freelancer.uidemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MessagesAdapter extends BaseAdapter{
    List<Messages> messages;
    static Context c;

    MessagesAdapter(List<Messages> persons,Context c){
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
            convertView = inflater.inflate(R.layout.messages_listview, null);

        title = (TextView)convertView.findViewById(R.id.message_title);
        time = (TextView)convertView.findViewById(R.id.message_time);
        content = (TextView)convertView.findViewById(R.id.message_content);
        personPhoto = (CircularImageView)convertView.findViewById(R.id.person_photo);

if(position==0) {
    new ShowcaseView.Builder((Activity) c)
            //   .withMaterialShowcase()
            .setTarget(new ViewTarget(convertView.findViewById(R.id.person_photo)))
            .setContentTitle("Feature title")
            .setContentText("Learn more about this feature in a sentence or two. Its great!")
            .setStyle(R.style.CustomShowcaseTheme2)
            .build();
}
        content.setText(messages.get(position).content);
        title.setText(messages.get(position).heading);
        time.setText(messages.get(position).time);
        personPhoto.setImageResource(messages.get(position).photoId);


        return  convertView;
    }
    private LayoutInflater inflater;

    }
