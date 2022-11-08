package com.example.danketim.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.danketim.R;
import com.example.danketim.model.CountryModel;


public class DetailFragment extends Fragment {

    private ImageView imageFullScreen;
    private TextView namePerson;
    private CountryModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageFullScreen = view.findViewById(R.id.imageViewFullScreen);
     //   namePerson = view.findViewById(R.id.txtx);
        getData();
    }

    private void getData() {
        Bundle argument = getArguments();
        if (argument != null){
            CountryModel model = (CountryModel) argument.getSerializable("country");
            Glide.with(imageFullScreen.getContext()).load(model.getImageUrl()).into(imageFullScreen);


        }
    }
}