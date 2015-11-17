package com.test.treinamentomobile.brasileirao_placar2015.adapter;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.treinamentomobile.brasileirao_placar2015.R;
import com.test.treinamentomobile.brasileirao_placar2015.model.Match;
import com.test.treinamentomobile.brasileirao_placar2015.view.MatchItemView;
import com.test.treinamentomobile.brasileirao_placar2015.view.MatchItemView_;

import org.androidannotations.annotations.EBean;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by treinamentomobile on 11/14/15.
 */

@EBean
public class MatchAdapter extends AABaseAdapter<Match> implements StickyListHeadersAdapter {

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = MatchItemView_.build(context);
        }

        ((MatchItemView) convertView).bind(getItem(position));

        return convertView;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if (textView == null) {
            textView = new TextView(context);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                textView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            } else {
                textView.setBackgroundColor(context.getColor(R.color.colorAccent));
            }
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10, 10, 10, 10);
        }

        textView.setText(String.format("Rodada %d", getItem(position).getRound()));
        return textView;
    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getRound();
    }
}