package com.geun.campingjoa.hotplace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.geun.campingjoa.R;

import java.util.ArrayList;

public class hotplace_Adapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<item_hotplace> al;
    LayoutInflater inf;


    public hotplace_Adapter(Context context,int Layout,ArrayList<item_hotplace> data) {
        this.context = context;
        this.layout = Layout;
        this.al = data;
        inf = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=inf.inflate(layout,null);
        }

        ImageView profile =(ImageView) convertView.findViewById(R.id.hotplace_iv);
        TextView title=(TextView)convertView.findViewById(R.id.sub_title);
        TextView place=(TextView)convertView.findViewById(R.id.sub_place);
        TextView show=(TextView)convertView.findViewById(R.id.sub_show);
        TextView money=(TextView)convertView.findViewById(R.id.sub_money);
        TextView people=(TextView)convertView.findViewById(R.id.people);


        final item_hotplace m=al.get(position);

        profile.setImageResource(m.profile);
        title.setText(m.title);
        place.setText(m.place);
        show.setText(m.show);
        money.setText(m.money);
        people.setText(m.people);




        return convertView;

    }
}
