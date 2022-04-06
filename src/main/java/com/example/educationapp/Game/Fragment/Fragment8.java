package com.example.educationapp.Game.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.educationapp.Game.HomeQuizActivity;

import com.example.educationapp.R;
import com.example.educationapp.Service.BackgroundsSoundCottruyen;


public class Fragment8 extends Fragment {

    RelativeLayout rlt8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_8, container, false);
        rlt8 = view.findViewById(R.id.rlf8);
        rlt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment8 = new Fragment8();
                fragmentTransaction.remove(fragment8);
                fragmentTransaction.commit();
                // chuyển về Activity bản đồ
                Intent intent = new Intent(getActivity(), HomeQuizActivity.class);
                startActivity(intent);
                getActivity().finish();
                getActivity().stopService(new Intent(getActivity(), BackgroundsSoundCottruyen.class));
            }
        });

        return  view;
    }
}