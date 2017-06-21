package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by anirudh on 18/6/17.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquakes> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquakes> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Earthquakes eq = getItem(position);
        TextView magnitude = (TextView)listItemView.findViewById(R.id.magnitude);
        TextView locationOffset = (TextView)listItemView.findViewById(R.id.location_offset);
        TextView locationPrimary = (TextView)listItemView.findViewById(R.id.location_primary);
        TextView time = (TextView)listItemView.findViewById(R.id.time);
        TextView date = (TextView)listItemView.findViewById(R.id.date);
        DecimalFormat formatter = new DecimalFormat("0.00");
        magnitude.setText(formatter.format(eq.getMagnitude()));
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();
        magnitudeCircle.setColor(ContextCompat.getColor(getContext(),getMagnitudeColor(eq.getMagnitude())));
        String location = eq.getLocation();
        int splitPoint = location.indexOf("of");
        locationOffset.setText(location.substring(0,splitPoint+2));
        locationPrimary.setText(location.substring(splitPoint+3 ,location.length()));
        long timeInMilliSeconds = eq.getDateTime();
        Date dateObject = new Date(timeInMilliSeconds);
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedTime);
        date.setText(formattedDate);
        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private int getMagnitudeColor(double magnitude){
        switch((int)magnitude){
            case 0:
            case 1:
                return R.color.magnitude1;
            case 2:
                return R.color.magnitude2;
            case 3:
                return R.color.magnitude3;
            case 4:
                return R.color.magnitude4;
            case 5:
                return R.color.magnitude5;
            case 6:
                return R.color.magnitude6;
            case 7:
                return R.color.magnitude7;
            case 8:
                return R.color.magnitude8;
            case 9:
                return R.color.magnitude9;
            default:
                return R.color.magnitude10plus;
        }
    }
}
