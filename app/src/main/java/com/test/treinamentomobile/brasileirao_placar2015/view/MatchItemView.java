package com.test.treinamentomobile.brasileirao_placar2015.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.treinamentomobile.brasileirao_placar2015.R;
import com.test.treinamentomobile.brasileirao_placar2015.model.Match;
import com.test.treinamentomobile.brasileirao_placar2015.model.Team;

import com.test.treinamentomobile.brasileirao_placar2015.DetailTeamActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import java.text.SimpleDateFormat;

/**
 * Created by hemobile on 14/11/15.
 */
@EViewGroup(R.layout.item_match_2)
public class MatchItemView extends RelativeLayout {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM HH:mm");

    @ViewById
    TextView textHomeTeam, textAwayTeam, textScore, textPlace, textDatetime;

    @ViewById
    ImageView imgHomeTeam, imgAwayTeam;
    private Match match;

    public MatchItemView(Context context) {
        super(context);
    }

    public MatchItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void bind(Match match) {
        this.match = match;
        Team homeTeam = match.getHomeTeam();
        textHomeTeam.setText(homeTeam.getName());
        Picasso.with(getContext()).load(homeTeam.getUrlLogo()).into(imgHomeTeam);

        Team awayTeam = match.getAwayTeam();
        textAwayTeam.setText(awayTeam.getName());
        Picasso.with(getContext()).load(awayTeam.getUrlLogo()).into(imgAwayTeam);

        textDatetime.setText(SDF.format(match.getDate()));
        textPlace.setText(match.getPlace());
        if (match.getHomeTeamScore() >= 0) {
            textScore.setText(String.format("%d X %d", match.getHomeTeamScore(), match.getAwayTeamScore()));
        } else {
            textScore.setText("X");
        }
    }

    @Click({R.id.img_away_team, R.id.img_home_team})
    void onTeamClick(View v) {
        long teamId;
        if (v == imgHomeTeam) {
            teamId = match.getHomeTeam().getId();
        } else {
            teamId = match.getAwayTeam().getId();
        }
        DetailTeamActivity_.intent(getContext()).teamId(teamId).start();
    }
}


