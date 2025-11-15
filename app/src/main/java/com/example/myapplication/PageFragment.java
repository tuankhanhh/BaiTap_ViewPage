package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PageFragment extends Fragment {

    private int layoutType;

    public static PageFragment newInstance(int type) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layoutType = getArguments().getInt("type");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        switch (layoutType) {
            case 0:
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                break;
            case 1:
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
                break;
            case 2:
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                break;
        }

        recyclerView.setAdapter(new ItemAdapter(generateData()));

        return view;
    }

    private ArrayList<Item> generateData() {
        ArrayList<Item> items = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            items.add(new Item("Item " + i));
        }
        return items;
    }
}
