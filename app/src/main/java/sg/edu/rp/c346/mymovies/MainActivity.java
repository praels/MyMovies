package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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

        lvMovie = findViewById(R.id.listViewMovies);

        alMovie = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        date1.set(2014,11,15);
        Calendar date2 = Calendar.getInstance();
        date2.set(2015,05,15);

        Movie movie1 = new Movie("The Avengers","2012","pg13","Action | Sci-Fi",date1,"Golden Village-Bishan","Nick Fury of S.H.I.E.L.D assembles a team of superheroes to save the planet from Loki and his army.",5);
        Movie movie2 = new Movie("Planes","2013","pg","Animation | Comedy",date2,"Cathay - AMK Hub","A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",5);

        alMovie.add(movie1);
        alMovie.add(movie2);

        caMovie = new CustomAdapter(this,R.layout.movie_item,alMovie);
        lvMovie.setAdapter(caMovie);


        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getBaseContext(),MovieDetailed.class);
                intent.putExtra("title",alMovie.get(i).getTitle());
                intent.putExtra("year",alMovie.get(i).getYearGenre());
                intent.putExtra("desc",alMovie.get(i).getDescription());
                intent.putExtra("fulldate","Watch on: " +alMovie.get(i).getDateString());
                intent.putExtra("loca","In Theatre: "+alMovie.get(i).getIn_theatre());
                intent.putExtra("number",alMovie.get(i).getRating());
                startActivity(intent);
            }
        });
    }
}