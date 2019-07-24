package com.prototype.ditenun.ditenunuiprototype.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prototype.ditenun.ditenunuiprototype.R;
import com.prototype.ditenun.ditenunuiprototype.adapter.HorizontalAdapter;
import com.prototype.ditenun.ditenunuiprototype.model.Ulos;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Ulos> data;
    private List<Ulos> data1;
    private List<Ulos> data2;
    private List<Ulos> data3;
    private List<Ulos> data4;

    RecyclerView horizontal_recycler_view;
    RecyclerView horizontal_recycler_view1;
    RecyclerView horizontal_recycler_view2;
    RecyclerView horizontal_recycler_view3;
    RecyclerView horizontal_recycler_view4;
    HorizontalAdapter horizontalAdapter;
    HorizontalAdapter horizontalAdapter1;
    HorizontalAdapter horizontalAdapter2;
    HorizontalAdapter horizontalAdapter3;
    HorizontalAdapter horizontalAdapter4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        horizontal_recycler_view = (RecyclerView) rootView.findViewById(R.id.horizontal_recycler_view);
        horizontal_recycler_view1 = (RecyclerView) rootView.findViewById(R.id.horizontal_recycler_view1);
        horizontal_recycler_view2 = (RecyclerView) rootView.findViewById(R.id.horizontal_recycler_view2);
        horizontal_recycler_view3 = (RecyclerView) rootView.findViewById(R.id.horizontal_recycler_view3);
        horizontal_recycler_view4 = (RecyclerView) rootView.findViewById(R.id.horizontal_recycler_view4);

        data = fill_with_data();
        data1 = fill_with_data1();
        data2 = fill_with_data2();
        data3 = fill_with_data3();
        data4 = fill_with_data4();

        horizontalAdapter = new HorizontalAdapter(data, getContext());
        horizontalAdapter1 = new HorizontalAdapter(data1, getContext());
        horizontalAdapter2 = new HorizontalAdapter(data2, getContext());
        horizontalAdapter3 = new HorizontalAdapter(data3, getContext());
        horizontalAdapter4 = new HorizontalAdapter(data4, getContext());

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager horizontalLayoutManager4 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
        horizontal_recycler_view1.setLayoutManager(horizontalLayoutManager1);
        horizontal_recycler_view1.setAdapter(horizontalAdapter1);
        horizontal_recycler_view2.setLayoutManager(horizontalLayoutManager2);
        horizontal_recycler_view2.setAdapter(horizontalAdapter2);
        horizontal_recycler_view3.setLayoutManager(horizontalLayoutManager3);
        horizontal_recycler_view3.setAdapter(horizontalAdapter3);
        horizontal_recycler_view4.setLayoutManager(horizontalLayoutManager4);
        horizontal_recycler_view4.setAdapter(horizontalAdapter4);

        return rootView;
    }

    public List<Ulos> fill_with_data() {

        List<Ulos> data = new ArrayList<>();

        data.add(new Ulos( "Ulos Bintang Maratur", R.drawable.bintangmaratur));
        data.add(new Ulos( "Ulos Ragihotang", R.drawable.ragihotang));
        data.add(new Ulos( "Ulos Sibolang", R.drawable.sibolang));
        data.add(new Ulos( " ", R.drawable.lainnya));

        return data;
    }

    public List<Ulos> fill_with_data1() {

        List<Ulos> data = new ArrayList<>();

        data.add(new Ulos( "Kain Ikat Maumere", R.drawable.maumere));
        data.add(new Ulos( "Tenun Flores", R.drawable.tenunflorse));
        data.add(new Ulos( "Kain Nggela", R.drawable.nggela));
        data.add(new Ulos( " ", R.drawable.lainnya));

        return data;
    }

    public List<Ulos> fill_with_data2() {

        List<Ulos> data = new ArrayList<>();

        data.add(new Ulos( "Kain Tenun Ikat Troso", R.drawable.troso));
        data.add(new Ulos( "Kain Blanket", R.drawable.blanket));
        data.add(new Ulos( "Kain Surgawi Toraja", R.drawable.surgawitoraja));
        data.add(new Ulos( " ", R.drawable.lainnya));

        return data;
    }

    public List<Ulos> fill_with_data3() {

        List<Ulos> data = new ArrayList<>();

        data.add(new Ulos( "Kain Endek", R.drawable.endek));
        data.add(new Ulos( "Kain Gerinsing", R.drawable.gerinsing));
        data.add(new Ulos( "Songket Bali", R.drawable.songketbali));
        data.add(new Ulos( " ", R.drawable.lainnya));

        return data;
    }

    public List<Ulos> fill_with_data4() {

        List<Ulos> data = new ArrayList<>();

        data.add(new Ulos( "Batik Tenun Papua", R.drawable.papua1));
        data.add(new Ulos( "Kamoro", R.drawable.kamoro));
        data.add(new Ulos( "Motif Batik Cendrawasih", R.drawable.cendrawasih));
        data.add(new Ulos( " ", R.drawable.lainnya));

        return data;
    }
}
