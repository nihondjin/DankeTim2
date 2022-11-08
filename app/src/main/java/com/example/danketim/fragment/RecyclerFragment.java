package com.example.danketim.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.danketim.OnItemClickListener;
import com.example.danketim.R;
import com.example.danketim.adapter.CountryAdapter;
import com.example.danketim.model.CountryModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment implements OnItemClickListener {


    private final CountryAdapter adapter = new CountryAdapter(this);
    private final CountryRepository repository = new CountryRepository();
    private RecyclerView recyclerView;
    private FloatingActionButton buttonAdd;
    private List<CountryModel> list;
    private CountryModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView);
        buttonAdd = view.findViewById(R.id.buttonAdd);
        onAdd();
        initialize();
        setUpListener();
        adapter.setData(repository.getListOfCountries());

    }

    private void onAdd() {
        getParentFragmentManager().setFragmentResultListener("backStack", getViewLifecycleOwner(), new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (requestKey.equals("backStack")) {
                    model =(CountryModel) result.getSerializable("serialiazable");
                    list.add(model);
                    adapter.setData(list);
                }
            }
        });
    }

    private void initialize() {
        recyclerView.setAdapter(adapter);
    }

    private void setUpListener() {
        buttonAdd.setOnClickListener((View view) -> {
            getParentFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new ThirdFragment())
                    .addToBackStack("RecyclerFragment")
                    .commit();
        });
    }

    @Override
    public void onClick(CountryModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("country", model);
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.add(R.id.fragment_container, DetailFragment.class, bundle)
                .addToBackStack("RecyclerView")
                .commit();
    }
}