package com.example.royalroadofspec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListBoardAdapter_4 extends BaseAdapter {
    private ArrayList<ListBoardItem_4> listViewItemList = new ArrayList<ListBoardItem_4>();

    public ListBoardAdapter_4(){

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
            convertView = inflater.inflate(R.layout.board_item_4, parent, false);
        }

        TextView titleTextView = (TextView)convertView.findViewById(R.id.textView1);   //제목
        TextView timeTextView = (TextView)convertView.findViewById(R.id.textView2);    //시간
        TextView nameTextView = (TextView)convertView.findViewById(R.id.textView3);    //닉넴
        TextView likeTextView = (TextView)convertView.findViewById(R.id.likeNum);
        TextView chatTextView = (TextView)convertView.findViewById(R.id.chatNum);

        ListBoardItem_4 listViewItem = listViewItemList.get(position);

        String time = listViewItem.getDate().substring(13)+"   |";


        titleTextView.setText(listViewItem.getTitle());
        timeTextView.setText(time);
        nameTextView.setText(listViewItem.getUserName());
        likeTextView.setText(String.valueOf(listViewItem.getLikes()));
        chatTextView.setText(String.valueOf(listViewItem.getComments()));

        return convertView;
    }

    public void addItem(String title, String content, String name, String category, String date, Integer like, Integer comment){
        ListBoardItem_4 item = new ListBoardItem_4();

        item.setTitle(title);
        item.setDate(date);
        item.setUserName(name);
        item.setLikes(like);
        item.setComments(comment);
        item.setCategory(category);
        item.setContent(content);

        listViewItemList.add(item);
    }
}
