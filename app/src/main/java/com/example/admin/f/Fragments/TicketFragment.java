package com.example.admin.f.Fragments;

/**
 * Created by admin on 03.07.2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.admin.f.R;
import com.example.admin.f.Adapters.SpinnerTicketType;

public class TicketFragment extends Fragment {

    public static Spinner eventType;
    public static Spinner ticketType;
    public static Spinner zoneType;
    TextView result;
    TextView resultPlus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ticket, container, false);

        eventType = (Spinner) view.findViewById(R.id.eventType);
        ticketType = (Spinner) view.findViewById(R.id.ticketType);
        zoneType = (Spinner) view.findViewById(R.id.zoneType);
        result = (TextView) view.findViewById(R.id.result);
        resultPlus = (TextView) view.findViewById(R.id.resultPlus);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(getActivity(), R.array.ticket_eventType, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.ticket_ticketType, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.ticket_zoneType, android.R.layout.simple_spinner_dropdown_item);

        eventType.setAdapter(adapter1);
        ticketType.setAdapter(adapter2);
        zoneType.setAdapter(adapter3);

        SpinnerTicketType event = new SpinnerTicketType(this);
        eventType.setOnItemSelectedListener(event);
        SpinnerTicketType ticket = new SpinnerTicketType(this);
        ticketType.setOnItemSelectedListener(ticket);
        SpinnerTicketType zone = new SpinnerTicketType(this);
        zoneType.setOnItemSelectedListener(zone);

        return view;
    }


    public String spinnerResult(Spinner spinner){
        return spinner.getSelectedItem().toString();
    }

    public TextView getResult() {
        return result;
    }

    public TextView getResultPlus() {
        return resultPlus;
    }
}
