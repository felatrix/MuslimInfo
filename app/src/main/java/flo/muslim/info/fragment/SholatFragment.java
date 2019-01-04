package flo.muslim.info.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import flo.muslim.info.R;
import flo.muslim.info.adapter.SholatAdapter;
import flo.muslim.info.model.SholatModel;


public class SholatFragment extends Fragment {

    public SholatFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sholat, container, false);
        // 1. get a reference to recyclerView

        RecyclerView rv = rootView.findViewById(R.id.rvSholat);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(rootView.getContext(), 3));

        SholatAdapter mAdapter = new SholatAdapter(rootView.getContext(), getSholatList());
        rv.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    private List<SholatModel> getSholatList() {
        List<SholatModel> listItems = new ArrayList<>();
        listItems.add(new SholatModel( R.string.label_sholat1,  R.drawable.ic_logo_1));
        listItems.add(new SholatModel( R.string.label_sholat2,  R.drawable.ic_logo_2));
        listItems.add(new SholatModel( R.string.label_sholat3,  R.drawable.ic_logo_3));
        listItems.add(new SholatModel( R.string.label_sholat4,  R.drawable.ic_logo_4));
        return listItems;
    }

}
