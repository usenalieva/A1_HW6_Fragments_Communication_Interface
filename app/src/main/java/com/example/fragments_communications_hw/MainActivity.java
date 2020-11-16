package com.example.fragments_communications_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.fragments_communications.R;


public class MainActivity extends AppCompatActivity implements IntFragments, RecyclerViewFragment.Conductor{

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RecyclerViewFragment recyclerViewFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecViewFragment();
        initFragmentEditText();
    }

    private void initRecViewFragment() {
        recyclerViewFragment = (RecyclerViewFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_recycler_view);
    }

    private void initFragmentEditText() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add( R.id.fragment_container, new EditTextFragment());
        transaction.commit();
    }

    @Override
    public void showFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.show(recyclerViewFragment);
        transaction.commit();
    }

    @Override
    public void hideFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.hide(recyclerViewFragment);
        transaction.commit();
    }

    @Override
    public void msgConductor(String msg) {
        RecyclerViewFragment recViewFragment = (RecyclerViewFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_recycler_view);
        recViewFragment.sendMsgToAdapter(msg);
    }
}

