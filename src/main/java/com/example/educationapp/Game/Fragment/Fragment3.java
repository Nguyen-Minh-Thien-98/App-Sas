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


public class Fragment3 extends Fragment {
    RelativeLayout rlt3;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        rlt3 = view.findViewById(R.id.rlf3);

        rlt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment4 = new Fragment4();
                Fragment fragment3 = new Fragment3();
                fragmentTransaction.add(R.id.fragmentcontent, fragment4);
                fragmentTransaction.remove(fragment3);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}