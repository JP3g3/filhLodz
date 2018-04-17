package com.example.admin.f.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.f.R;
import com.example.admin.f.Adapters.EventsAdapter;
import com.example.admin.f.Listeners.NavigationListener;
import com.example.admin.f.Models.News;

import java.util.ArrayList;

/**
 * Created on 24.04.2017.
 */

public class EventsFragment extends Fragment {

   ArrayList<News> news;

    public static Integer[] imgId={
            R.drawable.kolory_polski0,
            R.drawable.kolory_polski1,
            R.drawable.kolory_polski2,
            R.drawable.kolory_polski3,
            R.drawable.kolory_polski4,
            R.drawable.kolory_polski5,
            R.drawable.kolory_polski6,
            R.drawable.kolory_polski7,
    };

    public static NavigationListener navigationListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof NavigationListener) {
            navigationListener = (NavigationListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        RecyclerView newsList = (RecyclerView) view.findViewById(R.id.news_list);
        newsList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        EventsAdapter eventsAdapter = new EventsAdapter();
        newsList.setAdapter(eventsAdapter);

        loadData();
        eventsAdapter.setData(news);

        return view;
    }


    private void loadData() {
        news = new ArrayList<>();

        String[] ImageName = getResources().getStringArray(R.array.events_name);
        String[] ImageDate = getResources().getStringArray(R.array.events_date);

        for (int i = 0; i < 8; i++) {
            news.add(new News(imgId[i], "Kolory Polski - " + ImageName[i], ImageDate[i]));
        }
    }
}
