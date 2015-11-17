package com.test.treinamentomobile.brasileirao_placar2015.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.treinamentomobile.brasileirao_placar2015.R;
import com.squareup.picasso.Picasso;
import com.test.treinamentomobile.brasileirao_placar2015.model.Team;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by treinamentomobile on 11/16/15.
 */
@EViewGroup(R.layout.item_team)
public class TeamItemView extends LinearLayout {

    @ViewById
    TextView text;

    @ViewById
    ImageView image;

    public TeamItemView(Context context) {
        super(context);
    }

    public TeamItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    public void init() {
        setOrientation(HORIZONTAL);
    }

    public void bind(Team team) {
        text.setText(team.getName());
        Picasso.with(getContext())
                .load(team.getUrlLogo())
                .placeholder(R.mipmap.ic_launcher)
                .resize(100, 100)
                .into(image);
    }
}
