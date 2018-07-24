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
 * Created by 16020552 on 24/7/2018.
 */

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> toDoList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI elements and bind them to their respective Java variable.
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYearGenre = rowView.findViewById(R.id.textViewYearGenre);
        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);

        // Obtain the property values from the Data Class object
        // and set them to the corresponding UI elements.
        Movie currentItem = toDoList.get(position);
        tvTitle.setText(currentItem.getTitle());
        tvYearGenre.setText(currentItem.getYear()+ "-" + currentItem.getGenre());

        if(currentItem.getRated()=="pg13"){
            ivRating.setImageResource(R.drawable.rating_pg13);

        }else if(currentItem.getRated()=="pg"){
            ivRating.setImageResource(R.drawable.rating_pg);
        }else if(currentItem.getRated()=="g"){
            ivRating.setImageResource(R.drawable.rating_g);
        }else if(currentItem.getRated()=="nc16"){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }else if(currentItem.getRated()=="m18"){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else if(currentItem.getRated()=="r21"){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        return rowView;

    }
}