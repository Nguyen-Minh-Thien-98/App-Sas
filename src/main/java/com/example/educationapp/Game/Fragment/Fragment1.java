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


public class Fragment1 extends Fragment {


    RelativeLayout rLf1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        rLf1 = view.findViewById(R.id.rlf1);
        rLf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment2 = new Fragment2();
                Fragment fragment1 = new Fragment1();
                fragmentTransaction.add(R.id.fragmentcontent, fragment2);
                fragmentTransaction.commit();
                fragmentTransaction.remove(fragment1);
            }
        });
        return view;

    }
}