package com.test.treinamentomobile.brasileirao_placar2015.fragment;

/**
 * Created by treinamentomobile on 11/16/15.
 */

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;
import com.test.treinamentomobile.brasileirao_placar2015.DetailTeamActivity_;
import com.test.treinamentomobile.brasileirao_placar2015.adapter.TeamAdapter;
import com.test.treinamentomobile.brasileirao_placar2015.model.Team;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;

import java.util.List;


@EFragment
public class ListTeamsFragment extends ListFragment {

    @Bean
    TeamAdapter adapter;

    @AfterViews
    public void init() {
        fetchData();
    }

    @Background
    void fetchData() {
        adapter.setList(getTeams());
        setListAdapter(adapter);
    }

    @UiThread
    @Override
    public void setListAdapter(ListAdapter adapter) {
        super.setListAdapter(adapter);
    }

    private List<Team> getTeams() {
        List<Team> teams = new Select().all().from(Team.class).execute();
        return teams;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        long teamId = adapter.getItem(position).getId();
        DetailTeamActivity_.intent(getActivity()).teamId(teamId).start();
    }
}
