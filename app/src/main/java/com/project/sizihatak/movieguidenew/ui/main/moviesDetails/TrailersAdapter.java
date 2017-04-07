package com.project.sizihatak.movieguidenew.ui.main.moviesDetails;


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
import com.project.sizihatak.movieguidenew.data.network.model.Trailer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.ViewHolder> {

    private List<Trailer> trailers = new ArrayList<>();
    private MoviesDetailsContract.View moviesDetailsView;
    private Context context;


    TrailersAdapter(MoviesDetailsContract.View moviesDetailsView) {
        this.moviesDetailsView = moviesDetailsView;
    }

    void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    @Override
    public TrailersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.trailer_list_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(TrailersAdapter.ViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.title.setText(trailer.getName());
        holder.itemView.setOnClickListener(holder);
        Glide.with(context).load(trailer.getThumbnailPath())
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.imageView_trailerItem_poster)
        ImageView poster;
        @BindView(R.id.textView_trailerItem_title)
        TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {
            TrailersAdapter.this.moviesDetailsView.onTrailerClick(getAdapterPosition());
        }

    }
}
