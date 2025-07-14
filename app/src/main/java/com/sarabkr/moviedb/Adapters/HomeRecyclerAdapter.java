package com.sarabkr.moviedb.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sarabkr.moviedb.Models.SearchArrayObject;
import com.sarabkr.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends  RecyclerView.Adapter<HomeViewHolder>{
    Context context;
    List<SearchArrayObject> list;
    OnMovieClickListener listener;

    public HomeRecyclerAdapter(Context context, List<SearchArrayObject> list, OnMovieClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.home_movies_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.textView_movie.setText(list.get(position).getTitle());
        holder.textView_year.setText(String.valueOf(list.get(position).getYear()));
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView_poster);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class HomeViewHolder extends RecyclerView.ViewHolder{
    // initialise the element of the item and identify them by id
    ImageView imageView_poster;
    TextView textView_movie;
    TextView textView_year;
    CardView home_container;
    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.imageView_poster);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        textView_year = itemView.findViewById(R.id.textView_year);
        home_container = itemView.findViewById(R.id.home_container);
    }
}
interface OnMovieClickListener {
    void onMovieClicked(String id);

}
