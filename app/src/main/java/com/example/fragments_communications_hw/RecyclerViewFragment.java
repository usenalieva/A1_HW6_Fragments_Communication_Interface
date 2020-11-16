package com.example.fragments_communications_hw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments_communications.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<String> list;

    public RecyclerViewFragment() {
    }

    public interface Conductor {
        void msgConductor(String msg);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        setUpView(view);
        return view;
    }

    private void setUpView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
    }

    public void sendMsgToAdapter(String msg) {
        adapter.displayMsg(msg);
    }
}
