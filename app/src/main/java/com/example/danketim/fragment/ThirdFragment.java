package com.example.danketim.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.danketim.R;
import com.example.danketim.model.CountryModel;


public class ThirdFragment extends Fragment {

    private EditText editText, editUrl, editName;
    private Button buttonSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editUrl = view.findViewById(R.id.editTextThird1);
        editText = view.findViewById(R.id.editTextThird);
        editName = view.findViewById(R.id.editTextThird2);
        buttonSend = view.findViewById(R.id.buttonSend);
        setOnClickListener();
    }

    private void setOnClickListener() {
        buttonSend.setOnClickListener(view -> {
            String uriEdit = editUrl.getText().toString().trim();
            String editCount = editText.getText().toString().trim();
            String editPopulation  = editName.getText().toString().trim();
            if (uriEdit.isEmpty() && editPopulation.isEmpty() && editCount.isEmpty()){
                editUrl.setError("error");
                editName.setError("error");
                editText.setError("error");
            }else if (uriEdit.isEmpty()){
                editUrl.setError("error");
            }else if (editPopulation.isEmpty()){
                editUrl.setError("error");
            }else if (editCount.isEmpty()){
                editText.setError("error");
            }else {
                Bundle bundle  = new Bundle();
                CountryModel model = new CountryModel(uriEdit, editCount,Integer.parseInt(editPopulation), "#36D375");
                bundle.putSerializable("serializable", model);
                getParentFragmentManager().setFragmentResult("backStack", bundle);
                getParentFragmentManager().popBackStack();
            }
        });
    }
}