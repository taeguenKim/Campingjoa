package com.geun.campingjoa.board;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.geun.campingjoa.R;
import com.geun.campingjoa.login.G;


import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BoardAdapter extends BaseAdapter {

    Context context;
    ArrayList<Writeinfo> writeinfos;

    public BoardAdapter(Context context, ArrayList<Writeinfo> writeinfos){
        this.context =context;
        this.writeinfos = writeinfos;
    }


    @Override
    public int getCount() {
        return writeinfos.size();
    }

    @Override
    public Object getItem(int position) {
        return writeinfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Writeinfo info=writeinfos.get(position);

        View itemview=null;

        itemview=LayoutInflater.from(context).inflate(R.layout.item_board,parent,false);

        CircleImageView iv =itemview.findViewById(R.id.iv);
        TextView tvNickname =itemview.findViewById(R.id.item_name_text);
        TextView tvTitle= itemview.findViewById(R.id.item_title);
        TextView tvTime =itemview.findViewById(R.id.item_time_text);

        Glide.with(context).load(G.profile).into(iv);

        tvNickname.setText(info.nickname);
        tvTitle.setText(info.title);
        tvTime.setText(info.time);

        return itemview;
    }
}
