package com.example.fitnessapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.FragmentRecycler.ModalClass;
import com.example.fitnessapp.FragmentRecycler.NewAdapter;
import com.example.fitnessapp.R;
import com.example.fitnessapp.RecyclerView.Adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExercisesFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<ModalClass> mList;
    NewAdapter newAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_exercises, container, false);

        recyclerView = v.findViewById(R.id.recyclerViewId);

        newAdapter = new NewAdapter(mList, getContext());
        recyclerView.setAdapter(newAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mList= new ArrayList<>();
        mList.add(new ModalClass(R.drawable.bench,"Bench press description"));
        mList.add(new ModalClass(R.drawable.ohp,"OHP description"));


    }


}
