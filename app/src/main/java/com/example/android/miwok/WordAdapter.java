package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mCategoryColor;

    public WordAdapter(Activity context, ArrayList<Word> words, int categoryColor){
        super(context, 0, words);
        mCategoryColor = categoryColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if current view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Word currentWord = getItem(position);

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mCategoryColor);
        textContainer.setBackgroundColor(color);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextview = (TextView) listItemView.findViewById(R.id.defaul_text_view);
        defaultTextview.setText(currentWord.getDefaultTranslation());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }



        return listItemView;
    }
}
