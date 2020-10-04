package com.lifeistech.litboard2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class postAdapter extends ArrayAdapter<post> {

    List<post> items;

    public postAdapter(Context conText, int resource, List<post> objects) {
        super(conText, resource, objects);
        items = objects;
    }

    @Override
    public View getView(int pposition, View convertView, ViewGroup parent) {
        post item = getItem(pposition);
        final ViewHolder viewHelper;

        if (convertView != null) {
            viewHelper = (ViewHolder) convertView.getTag();
        } else {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_item_post, parent, false);

            viewHelper = new ViewHolder();
            viewHelper.userNameText = (TextView) convertView.findViewById(R.id.username);
            viewHelper.messengeText = (TextView) convertView.findViewById(R.id.messenge);

            convertView.setTag(viewHelper);

        }

        viewHelper.userNameText.setText(item.getUserName());
        viewHelper.messengeText.setText(item.getMessenge());

        return convertView;


    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public post getItem(int position) {
        return items.get(position);
    }


    static class ViewHolder {
        TextView userNameText;
        TextView messengeText;
    }


}
