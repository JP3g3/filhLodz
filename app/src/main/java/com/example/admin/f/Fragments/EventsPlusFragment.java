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

import static com.example.admin.f.Fragments.EventsFragment.imgId;

/**
 * Created by admin on 03.07.2017.
 */

public class EventsPlusFragment extends Fragment{

    ImageView image;
    TextView title;
    TextView date;
    TextView desc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_plus, container, false);

        String[] ImageName = getResources().getStringArray(R.array.events_name);
        String[] ImageDate = getResources().getStringArray(R.array.events_date);
        String[] ImageDesc = getResources().getStringArray(R.array.events_desc);

        image = (ImageView) view.findViewById(R.id.image);
        title = (TextView) view.findViewById(R.id.title);
        date = (TextView) view.findViewById(R.id.date);
        desc = (TextView) view.findViewById(R.id.desc);

        Bundle b = getArguments();
        if(b != null){
            Integer index = b.getInt("index");

            image.setImageResource(imgId[index]);
            title.setText("Kolory Polski - " + ImageName[index]);
            date.setText(ImageDate[index]);
            desc.setText(ImageDesc[index]);
        }

        return view;
    }
}
