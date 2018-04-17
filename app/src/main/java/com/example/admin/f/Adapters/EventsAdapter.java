package com.example.admin.f.Adapters;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.admin.f.R;
import com.example.admin.f.Models.News;
import com.example.admin.f.Fragments.EventsPlusFragment;
import static com.example.admin.f.Fragments.EventsFragment.navigationListener;
import static com.example.admin.f.MainActivity.toolbarTitle;

/**
 * Created on 25.04.2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private ArrayList<News> news;

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cell_events, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {

        holder.image.setImageResource(news.get(position).getImage());
        holder.title.setText(news.get(position).getTitle());
        holder.desc.setText(news.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setData(ArrayList<News> news) {
        this.news = news;
        if (this.news == null) {
            this.news = new ArrayList<>();
        }
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView desc;


        public ViewHolder(final View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (TextView) itemView.findViewById(R.id.desc);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventsPlusFragment moreInfo = new EventsPlusFragment();
                    Bundle args = new Bundle();
                    args.putInt("index", getAdapterPosition());
                    moreInfo.setArguments(args);
                    toolbarTitle.push("Repertuar FŁ");
                    navigationListener.onNavigate(moreInfo);
                }
            });
        }
    }
}
