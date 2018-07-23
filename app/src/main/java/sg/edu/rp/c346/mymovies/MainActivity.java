package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovie;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        alMovie = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);
        Movie item1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi",date1,"Golden Village - Bishan","Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,5,15);
        Movie item2 = new Movie("Planes","2013","pg","Animation | Comedy",date2,"Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);
        alMovie.add(item1);
        alMovie.add(item2);

        caMovie = new CustomAdapter(this,R.layout.movie,alMovie);

        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
                intent.putExtra("Rated",alMovie.get(i).getRated());
                intent.putExtra("Title",alMovie.get(i).getTitle());
                intent.putExtra("Year",alMovie.get(i).getYear());
                intent.putExtra("Genre",alMovie.get(i).getGenre());
                intent.putExtra("Description",alMovie.get(i).getDescription());
                intent.putExtra("Watch",alMovie.get(i).getWatchOnString());
                intent.putExtra("Theatre",alMovie.get(i).getIn_theatre());
                intent.putExtra("UserRating",alMovie.get(i).getUserRating());

                startActivity(intent);
            }
        });
    }
}