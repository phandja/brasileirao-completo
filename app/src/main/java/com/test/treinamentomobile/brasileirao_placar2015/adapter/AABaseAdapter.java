package com.test.treinamentomobile.brasileirao_placar2015.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by treinamentomobile on 11/14/15.
 */

@EBean
public abstract class AABaseAdapter<T> extends BaseAdapter {

    @RootContext
    Context context;

    private List<T> list;

    @Override
    public int getCount() {
        return getList().size();
    }

    @Override
    public T getItem(int i) {
        return getList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public List<T> getList() {
        if (list == null) {
            list = new ArrayList<T>();
        }
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}