package com.test.treinamentomobile.brasileirao_placar2015.adapter;

/**
 * Created by treinamentomobile on 11/16/15.
 */


import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.treinamentomobile.brasileirao_placar2015.model.Team;
import com.test.treinamentomobile.brasileirao_placar2015.view.TeamItemView;
import com.test.treinamentomobile.brasileirao_placar2015.view.TeamItemView_;

import org.androidannotations.annotations.EBean;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

@EBean
public class TeamAdapter extends AABaseAdapter<Team> implements StickyListHeadersAdapter {
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = TeamItemView_.build(context);
        }
        ((TeamItemView) convertView).bind(getItem(position));
        return convertView;
    }
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if (textView == null) {
            textView = new TextView(context);
            textView.setBackgroundColor(Color.BLACK);
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10, 10, 10, 10);
        }
        textView.setText(String.valueOf(getItem(position).getName().charAt(0)));
        return textView;
    }
    @Override
    public long getHeaderId(int position) {
        return getItem(position).getName().charAt(0);
    }
}