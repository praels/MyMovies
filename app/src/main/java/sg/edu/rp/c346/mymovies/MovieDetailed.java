package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by 16020552 on 24/7/2018.
 */

public class MovieDetailed extends AppCompatActivity {

    TextView tvTitle;
    TextView tvYear;
    TextView tvDesc;
    TextView tvDate;
    TextView tvLocation;
    RatingBar rbFour;

    @Override
    protected void onCreate( Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed);

        tvTitle = findViewById(R.id.textViewTitlee);
        tvYear = findViewById(R.id.textViewYearGenree);
        tvDesc = findViewById(R.id.textViewDescriptionn);
        tvDate = findViewById(R.id.textViewDatee);
        tvLocation = findViewById(R.id.textViewLocation);
        rbFour = findViewById(R.id.ratingBarFour);

        Intent intentR = getIntent();
        tvTitle.setText(intentR.getStringExtra("title"));
        tvYear.setText(intentR.getStringExtra("year"));
        tvDesc.setText(intentR.getStringExtra("desc"));
        tvDate.setText(intentR.getStringExtra("fulldate"));
        tvLocation.setText(intentR.getStringExtra("loca"));
        rbFour.setNumStars(intentR.getIntExtra("number",0));

    }

}