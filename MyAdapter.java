package com.example.a111zy;
/*
 *@auther:周鑫光
 *@Date: 2019/11/1
 *@Time:19:40
 *@Description:${DESCRIPTION}
 * */

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {


    private List<StudentBean.ListdataBean> listdata;

    public MyAdapter(List<StudentBean.ListdataBean> listdata) {

        this.listdata = listdata;
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(parent.getContext(), R.layout.item, null);
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.textView = convertView.findViewById(R.id.tv_name);
            holder.title = convertView.findViewById(R.id.tv_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        StudentBean.ListdataBean listdataBean = listdata.get(position);
        holder.title.setText(listdataBean.getName());
        holder.textView.setText(listdataBean.getContent());
        final ViewHolder finalHolder = holder;
        Until.getInstance().doGetphoto(listdataBean.getAvatar(), new Until.MyCallback() {
            @Override
            public void onsuccess(String josn) {

            }

            @Override
            public void onphotosuccess(Bitmap bitmap) {
                finalHolder.imageView.setImageBitmap(bitmap);
            }
        });
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView title;

    }

}
