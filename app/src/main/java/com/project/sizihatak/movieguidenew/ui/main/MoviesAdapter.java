package com.project.sizihatak.movieguidenew.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.project.sizihatak.movieguidenew.R;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private MainContract.View mainView;
    private Context context;

    MoviesAdapter(List<Movie> movies, MainContract.View mainView) {
        this.movies = movies;
        this.mainView = mainView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.movie = movies.get(position);
        holder.name.setText(movies.get(position).getTitle());
        holder.itemView.setOnClickListener(holder);
        Glide.with(context).load(holder.movie.getPosterPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.movie_poster)
        ImageView poster;
        @BindView(R.id.title_background)
        View titleBackground;
        @BindView(R.id.movie_name)
        TextView name;

        public Movie movie;

        public ViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, root);
        }

        @Override
        public void onClick(View view) {
            MoviesAdapter.this.mainView.onMovieClicked(movie);
        }
    }
}
