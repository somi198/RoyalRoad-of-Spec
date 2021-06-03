package com.example.royalroadofspec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class ListBoardAdapter extends BaseAdapter {
    private ArrayList<ListBoardItem> listViewItemList = new ArrayList<ListBoardItem>();

    public ListBoardAdapter(){

    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.board_item, parent, false);
        }

        TextView titleTextView = (TextView)convertView.findViewById(R.id.textView1);   //제목
        TextView timeTextView = (TextView)convertView.findViewById(R.id.textView2);    //시간
        TextView nameTextView = (TextView)convertView.findViewById(R.id.textView3);    //닉넴
        TextView likeTextView = (TextView)convertView.findViewById(R.id.likeNum);
        TextView chatTextView = (TextView)convertView.findViewById(R.id.chatNum);

        ListBoardItem listViewItem = listViewItemList.get(position);


        titleTextView.setText(listViewItem.getTitle());
        timeTextView.setText(listViewItem.getTime());
        nameTextView.setText(listViewItem.getName());
        likeTextView.setText(listViewItem.getLike());
        chatTextView.setText(listViewItem.getChat());

        return convertView;
    }

    public void addItem(String title, Date date, String name, String like, String chat){
        ListBoardItem item = new ListBoardItem();

        item.setTitle(title);
        item.setTime(date);
        item.setName(name);
        item.setLike(like);
        item.setChat(chat);

        listViewItemList.add(item);
    }
}
