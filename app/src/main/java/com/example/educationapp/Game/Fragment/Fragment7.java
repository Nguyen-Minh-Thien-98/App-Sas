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


public class Fragment7 extends Fragment {

    RelativeLayout rlt7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_7, container, false);
        rlt7 = view.findViewById(R.id.rlf7);
        rlt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment7 = new Fragment7();
                Fragment fragment8 = new Fragment8();
                fragmentTransaction.add(R.id.fragmentcontent,fragment8);
                fragmentTransaction.remove(fragment7);
                fragmentTransaction.commit();
            }
        });

        return  view;
    }
}