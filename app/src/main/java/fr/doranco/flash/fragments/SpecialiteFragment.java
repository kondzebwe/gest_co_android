package fr.doranco.flash.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import fr.doranco.flash.R;
import fr.doranco.flash.adapter.SpecialiteAdapter;
import fr.doranco.flash.databinding.FragmentSpecialiteBinding;
import fr.doranco.flash.entity.Specialite;

public class SpecialiteFragment extends Fragment {
    private FragmentSpecialiteBinding binding;

    public SpecialiteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSpecialiteBinding.inflate(inflater,container, false);

        // creation des objets
        Specialite specialite1 = new Specialite("Securite informatique");
        Specialite specialite2 = new Specialite("Systeme informatique");
        Specialite specialite3 = new Specialite("Dev Web Java");
        Specialite specialite4 = new Specialite("DevOps");
        Specialite specialite5 = new Specialite("Machine Learning");

        List<Specialite> specialiteList = new ArrayList<>();
        specialiteList.add(specialite1);
        specialiteList.add(specialite2);
        specialiteList.add(specialite3);
        specialiteList.add(specialite4);
        specialiteList.add(specialite5);
        // parametre le recycler view
        binding.recyclerViewSpecialiteFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewSpecialiteFragment.setAdapter(new SpecialiteAdapter(specialiteList));

        return binding.getRoot();
    }
}