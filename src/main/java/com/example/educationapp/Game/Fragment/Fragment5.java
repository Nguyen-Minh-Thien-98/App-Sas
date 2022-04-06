package com.example.educationapp.Game.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.educationapp.R;


public class Fragment5 extends Fragment {

    RelativeLayout rlt5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_5, container, false);
        rlt5 = view.findViewById(R.id.rlf5);
        rlt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment5 = new Fragment5();
                Fragment fragment6 = new Fragment6();
                fragmentTransaction.add(R.id.fragmentcontent, fragment6);
                fragmentTransaction.remove(fragment5);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}