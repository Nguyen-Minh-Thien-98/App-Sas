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


public class Fragment2 extends Fragment {
    RelativeLayout rlt2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_2, container, false);
        rlt2 = view.findViewById(R.id.rlf2);
        rlt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment3 = new Fragment3();
                Fragment fragment2 = new Fragment2();
                fragmentTransaction.add(R.id.fragmentcontent, fragment3);
                fragmentTransaction.commit();
                fragmentTransaction.remove(fragment2);
            }
        });

        return view;
    }
}