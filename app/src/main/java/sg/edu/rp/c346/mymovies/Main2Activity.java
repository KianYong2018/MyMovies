package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ImageView imageView;
    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvDescription;
    TextView tvWatch;
    TextView tvTheatre;
    RatingBar ratingBar;

    //Store Rating bar
    float bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView = findViewById(R.id.imageView2);
        tvTitle = findViewById(R.id.textViewMovieTitle2);
        tvYear = findViewById(R.id.textViewYear2);
        tvGenre = findViewById(R.id.textViewGenre2);
        tvDescription = findViewById(R.id.textViewDescription);
        tvWatch = findViewById(R.id.textViewWatchOn);
        tvTheatre = findViewById(R.id.textViewInTheatre);
        ratingBar = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String rated = intentReceived.getStringExtra("Rated");
        String Title = intentReceived.getStringExtra("Title");
        String Year = intentReceived.getStringExtra("Year");
        String Genre = intentReceived.getStringExtra("Genre");
        String Description = intentReceived.getStringExtra("Description");
        String Watch = intentReceived.getStringExtra("Watch");
        String Theatre = intentReceived.getStringExtra("Theatre");

        tvTitle.setText(Title);
        tvYear.setText(Year);
        tvGenre.setText(Genre);
        tvDescription.setText(Description);
        tvWatch.setText(Watch);
        tvTheatre.setText(Theatre);

        if(rated.equals("pg")){
            imageView.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("g")){
            imageView.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("m18")){
            imageView.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equals("nc16")){
            imageView.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("pg13")){
            imageView.setImageResource(R.drawable.rating_pg13);
        }
        else{
            imageView.setImageResource(R.drawable.rating_r21);
        }

        ratingBar.setIsIndicator(true);
        //ratingBar.setNumStars(5);
        ratingBar.setRating(intentReceived.getIntExtra("UserRating",0));
    }

}
