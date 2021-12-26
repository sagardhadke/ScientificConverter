package net.uniquecomputer.ScientificConverter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private final List<Movie> movies;
    private Context context;

    public MoviesAdapter(List<Movie> movies,Context context) {
        this.context=context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_movie,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setMovie(movies.get(position));
        holder.imagePoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Java Onliner Compiler",Toast.LENGTH_SHORT).show();
                if (movies.get(position).name.equals("Java online compiler")){
                    Intent intent=new Intent(context,JavaComp.class);
                    context.startActivity(intent);
                }else if (movies.get(position).name.equals("python online compiler")){
                    Intent intent=new Intent(context,python.class);
                    context.startActivity(intent);
                }else if (movies.get(position).name.equals("CPP online compiler")){
                    Intent intent=new Intent(context,cpp.class);
                    context.startActivity(intent);
                }else if (movies.get(position).name.equals("PHP online compiler")){
                    Intent intent=new Intent(context,php.class);
                    context.startActivity(intent);
                }else{
                    Intent intent=new Intent(context,htmlcssjs.class);
                    context.startActivity(intent);

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {

        private final RoundedImageView imagePoster;
        private final TextView textNameM, textCategory, textReleaseDate;
        private final RatingBar ratingBar;

        public MovieViewHolder(View view) {
            super(view);
            imagePoster = view.findViewById(R.id.imagePoster);
            textNameM = view.findViewById(R.id.textNameM);
            textCategory = view.findViewById(R.id.textCategory);
            textReleaseDate = view.findViewById(R.id.textReleaseDate);
            ratingBar = view.findViewById(R.id.ratingbarJvm);
        }

        void setMovie(Movie movie) {
            imagePoster.setImageResource(movie.poster);
            textNameM.setText(movie.name);
            textCategory.setText(movie.category);
            textReleaseDate.setText(movie.releaseDate);
            ratingBar.setRating(movie.rating);
        }
    }
}
