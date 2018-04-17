package com.example.admin.f.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.f.R;

/**
 * Created by admin on 03.07.2017.
 */

public class ContactFragment extends Fragment implements View.OnClickListener {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        setListener(R.id.mail, view);
        setListener(R.id.mail2, view);
        setListener(R.id.tel, view);

        return view;
    }

    private void setListener(int resId, View view) {
        View subview = view.findViewById(resId);
        if (subview != null) {
            subview.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.mail:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "filharmonia@filharmonia.lodz.pl" });
                startActivity(Intent.createChooser(intent, ""));
                startActivity(intent);
                break;
            case R.id.mail2:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setType("plain/text");
                intent2.putExtra(Intent.EXTRA_EMAIL, new String[] { "bilety@filharmonia.lodz.pl" });
                startActivity(Intent.createChooser(intent2, ""));
                startActivity(intent2);
                break;
            case R.id.tel:
                Intent intent3 = new Intent(Intent.ACTION_DIAL);
                intent3.setData(Uri.parse("tel:426 647 979"));
                startActivity(intent3);
                break;
            default:
                break;

        }
    }

}
