package com.test.treinamentomobile.brasileirao_placar2015.connection;

import com.test.treinamentomobile.brasileirao_placar2015.model.MatchesListResponse;
import com.test.treinamentomobile.brasileirao_placar2015.model.TeamListResponse;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

/**
 * Created by treinamentomobile on 11/16/15.
 */
@Rest(rootUrl = "http://mockbrasileirao.herokuapp.com/api", converters = MyGsonHttpMessageConverter.class)
public interface RestConnection {

    @Get("/teams")
    TeamListResponse getTeams();

    @Get("/matches")
    MatchesListResponse getMatches();
}
