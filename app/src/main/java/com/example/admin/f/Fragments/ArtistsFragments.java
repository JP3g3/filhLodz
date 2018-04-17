package com.example.admin.f.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.f.R;

import static com.example.admin.f.Fragments.EventsFragment.navigationListener;
import static com.example.admin.f.MainActivity.toolbarTitle;

/**
 * Created by admin on 07.07.2017.
 */

public class ArtistsFragments extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artists, container, false);

        setListener(R.id.img1, view);
        setListener(R.id.img2, view);
        setListener(R.id.img3, view);

        return view;
    }

    private void setListener(int resId, View view) {
        View subview = view.findViewById(resId);
        if (subview != null) {
            subview.setOnClickListener(this);
        }
    }

    private void openFragments(int index){
        ArtistsPlusFragments more = new ArtistsPlusFragments();
        Bundle args = new Bundle();
        args.putInt("index", index);
        more.setArguments(args);
        toolbarTitle.push("Artyści FŁ");
        navigationListener.onNavigate(more);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img1:
                openFragments(1);
                break;
            case R.id.img2:
                openFragments(2);
                break;
            case R.id.img3:
                openFragments(3);
                break;
            default:
                break;
        }
    }
}
