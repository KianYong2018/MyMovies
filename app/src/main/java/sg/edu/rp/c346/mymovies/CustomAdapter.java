package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 16038975 on 23/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Movie> movies;

    public CustomAdapter (@NonNull Context context, int resource, @NonNull ArrayList<Movie> object){
        super(context,resource,object);
        parent_context = context;
        layout_id = resource;
        movies = object;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        //Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater)parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Inflate a new view hierarchy from the specified xml resource (layout_id)
        //and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id,parent,false);

        //Obtain the UI elements and bind them to their respective Java variable
        TextView tvMovie = rowView.findViewById(R.id.textViewMovieTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);

        ImageView imageView = rowView.findViewById(R.id.imageViewRating);
        //Obtain the property values from the Data Class object
        //and set them to the corresponding UI elements.
        Movie currentItem = movies.get(position);
        tvMovie.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear() + " - ");
        tvGenre.setText(currentItem.getGenre());
        if(currentItem.getRated() == "g"){
            imageView.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRated() == "m18"){
            imageView.setImageResource(R.drawable.rating_m18);
        }else if(currentItem.getRated() == "nc16"){
            imageView.setImageResource(R.drawable.rating_nc16);
        }else if(currentItem.getRated() == "pg"){
            imageView.setImageResource(R.drawable.rating_pg);
        }else if(currentItem.getRated() == "pg13"){
            imageView.setImageResource(R.drawable.rating_pg13);
        }else{
            imageView.setImageResource(R.drawable.rating_r21);
        }

        return rowView;
    }
}
