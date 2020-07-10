package com.geun.campingjoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class hotplace_Adapter extends BaseAdapter {

    ArrayList<item_hotplace> items=new ArrayList<item_hotplace>();
    Context context;

    public void addItem(item_hotplace item){
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context=parent.getContext();
        item_hotplace listItem=items.get(position);
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_hotplace,parent,false);
        }

        ImageView hotplaceiv=convertView.findViewById(R.id.hotplace_iv);
        TextView place=convertView.findViewById(R.id.sub_place);
        TextView show=convertView.findViewById(R.id.sub_show);
        TextView money=convertView.findViewById(R.id.sub_money);


        Glide.with(context).load(hotplaceiv).into();

        return null;
    }
}
