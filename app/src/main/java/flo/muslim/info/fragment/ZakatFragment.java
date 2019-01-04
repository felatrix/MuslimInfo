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
import flo.muslim.info.adapter.ZakatAdapter;
import flo.muslim.info.model.ZakatModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZakatFragment extends Fragment {


    public ZakatFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_zakat, container, false);
        // 1. get a reference to recyclerView

        RecyclerView rv = rootView.findViewById(R.id.rvZakat);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(rootView.getContext(), 3));

        ZakatAdapter mAdapter = new ZakatAdapter(rootView.getContext(), getZakatList());
        rv.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    private List<ZakatModel> getZakatList() {
        List<ZakatModel> listItems = new ArrayList<>();
        listItems.add(new ZakatModel( R.string.label_zakat1));
        listItems.add(new ZakatModel( R.string.label_zakat2));
        listItems.add(new ZakatModel( R.string.label_zakat3));

        return listItems;
    }

}
