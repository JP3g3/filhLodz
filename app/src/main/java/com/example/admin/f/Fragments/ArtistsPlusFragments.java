package com.example.admin.f.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.f.R;

/**
 * Created by admin on 07.07.2017.
 */

public class ArtistsPlusFragments extends Fragment {

    ImageView image;
    TextView title;
    TextView desc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artists_plus, container, false);

        image = (ImageView) view.findViewById(R.id.image);
        title = (TextView) view.findViewById(R.id.title);
        desc = (TextView) view.findViewById(R.id.desc);

        Bundle b = getArguments();
        if(b != null){
            Integer index = b.getInt("index");

            if(index == 1) {
                image.setImageResource(R.drawable.dawid_ber);
                title.setText(R.string.artist_title1);
                desc.setText(R.string.artists_desc1);
            }
            else if(index == 2){
                image.setImageResource(R.drawable.orkiestra);
                title.setText(R.string.artist_title2);
                desc.setText(R.string.artists_desc2);
            }
            else if(index == 3){
                image.setImageResource(R.drawable.chor);
                title.setText(R.string.artist_title3);
                desc.setText(R.string.artists_desc3);
            }
        }

        return view;
    }
}
