package com.example.admin.f.Adapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.admin.f.Fragments.TicketFragment;

import static com.example.admin.f.Fragments.TicketFragment.ticketType;
import static com.example.admin.f.Fragments.TicketFragment.zoneType;

/**
 * Created by admin on 06.07.2017.
 */

public class SpinnerTicketType implements AdapterView.OnItemSelectedListener {

    TicketFragment ticket;
    public SpinnerTicketType(TicketFragment ticket) {
        this.ticket = ticket;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        
        switch (ticket.spinnerResult(TicketFragment.eventType)) {
            case "Koncerty symfoniczne":
                ((Spinner) ticketType).setEnabled(true);
                ((Spinner) zoneType).setEnabled(true);
                if (ticket.spinnerResult(ticketType).equals("Bilet normalny")) {
                    if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 1"))
                        ticket.getResult().setText("48 zł");
                    else if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 2"))
                        ticket.getResult().setText("34 zł");
                    else ticket.getResult().setText("Bark biletów!");
                } else {
                    if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 1"))
                        ticket.getResult().setText("36 zł");
                    else if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 2"))
                        ticket.getResult().setText("24 zł");
                    else ticket.getResult().setText("Bark biletów!");
                }
                ticket.getResultPlus().setText("Czy wiesz że:\nMmożesz zakupić abonament, w którym:\n"
                        + "na 5 koncertów dostaniesz 15% rabatu\n"
                        + "na 10 koncertów dostaniesz 25% rabatu\n"
                        + "na 15 i więcej koncertów dostaniesz 35% rabatu");
                break;

            case "Specjalne koncerty symfoniczne":
                ((Spinner) ticketType).setEnabled(true);
                ((Spinner) zoneType).setEnabled(true);
                if (ticket.spinnerResult(ticketType).equals("Bilet normalny")) {
                    if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 1"))
                        ticket.getResult().setText("60 zł");
                    else if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 2"))
                        ticket.getResult().setText("40 zł");
                    else ticket.getResult().setText("Bark biletów!");
                } else {
                    if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 1"))
                        ticket.getResult().setText("50 zł");
                    else if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 2"))
                        ticket.getResult().setText("30 zł");
                    else ticket.getResult().setText("Bark biletów!");
                }
                ticket.getResultPlus().setText("Czy wiesz że:\nMmożesz zakupić abonament, w którym:\n"
                        + "na 5 koncertów dostaniesz 15% rabatu\n"
                        + "na 10 koncertów dostaniesz 25% rabatu\n"
                        + "na 15 i więcej koncertów dostaniesz 35% rabatu");
                break;

            case "Nadzwyczajne koncerty symfoniczne":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(false);
                ticket.getResult().setText("ceny biletów ustalane są indywidualnie przez Dyrekcję FŁ");
                ticket.getResultPlus().setText("");
                break;

            case "Koncerty kameralne i organowe":
                ((Spinner) ticketType).setEnabled(true);
                ((Spinner) zoneType).setEnabled(false);
                if (ticket.spinnerResult(ticketType).equals("Bilet normalny"))
                    ticket.getResult().setText("32 zł");
                 else ticket.getResult().setText("22 zł");
                ticket.getResultPlus().setText("");
                break;

            case "Koncerty szkolne, współorganizowane ze szkołami muzycznymi":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(false);
                ticket.getResult().setText("15 zł");
                ticket.getResultPlus().setText("");
                break;

            case "Transmisje \"The Metropolitan Opera Live in HD\"":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(true);
                if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 1")) {
                    ticket.getResult().setText("80 zł");
                    ticket.getResultPlus().setText("Czy wiesz że:\nCena pojedynczego biletu w abonamencie: 48 PLN");
                }
                else if (ticket.spinnerResult(TicketFragment.zoneType).equals("Strefa 2")) {
                    ticket.getResult().setText("60 zł");
                    ticket.getResultPlus().setText("Czy wiesz że:\nCena pojedynczego biletu w abonamencie: 36 PLN");
                }
                else {
                    ticket.getResult().setText("40 zł");
                    ticket.getResultPlus().setText("");
                }
                break;

            case "Warsztaty dla dzieci \"Odkrywcy muzyki\"":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(false);
                ticket.getResult().setText("20 zł");
                ticket.getResultPlus().setText("Czy wiesz że:\nCena pojedynczego biletu w abonamencie: 18 PLN");
                break;


            case "Koncert \"Odkrywcy muzyki\"":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(false);
                ticket.getResult().setText("10 zł (dla dzieci do 3 lat: 5 zł)");
                ticket.getResultPlus().setText("");
                break;

            case "Warsztaty dla dzieci \"Baby Boom Bum\"":
                ((Spinner) ticketType).setEnabled(false);
                ((Spinner) zoneType).setEnabled(false);
                ticket.getResult().setText("30 zł");
                ticket.getResultPlus().setText("Czy wiesz że:\n" +
                        "Abonament na 3 warsztaty w kolejnych miesiącach (X-XII, I-III, IV-VI): 72 PLN\nCena pojedynczego biletu w abonamencie: 24 PLN");
                break;

            case "Dziecięcy Uniwersytet Artystyczny (DUA)":
                ((Spinner) ticketType).setEnabled(true);
                ((Spinner) zoneType).setEnabled(false);
                if (ticket.spinnerResult(ticketType).equals("Bilet normalny"))
                    ticket.getResult().setText("Warsztat w FŁ: 30 zł\nWarsztat w ASP: \n35 zł\nSpeaking Concert: \n40 zł");
                else
                    ticket.getResult().setText("Warsztat w FŁ: 30 zł\nWarsztat w ASP: \n35 zł\nSpeaking Concert: \n30 zł");
                ticket.getResultPlus().setText("Czy wiesz że\n" +
                        "FŁ: Przy zakupie minimum 3 warsztatów cena warsztatu w FŁ: 25 zł\n" +
                        "ASP: Przy zakupie minimum 3 warsztatów cena warsztatu: 30 zł\n" +
                        "Speaking Concert: 16 zł (przy zakupie minimum 2 warsztatów)");
                break;
            default:
                ticket.getResult().setText("dupa!");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
