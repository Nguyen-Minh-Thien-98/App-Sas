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


public class Fragment4 extends Fragment {

    RelativeLayout rlt4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_4, container, false);
        rlt4 = view.findViewById(R.id.rlf4);
        rlt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment4 = new Fragment4();
                Fragment fragment5 = new Fragment5();
                fragmentTransaction.add(R.id.fragmentcontent, fragment5);
                fragmentTransaction.remove(fragment4);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}