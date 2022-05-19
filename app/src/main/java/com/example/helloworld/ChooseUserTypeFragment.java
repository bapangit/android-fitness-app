package com.example.helloworld;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ChooseUserTypeFragment extends Fragment implements View.OnClickListener {

    LinearLayout linearLayoutMember,linearLayoutCoach;
    Drawable unSelectedBG,selectedBG;
    TextView buttonProceed;

    int USER_TYPE_MEMBER = 0,USER_TYPE_COACH=1;
    int USER_TYPE;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_user_type, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        linearLayoutMember = view.findViewById(R.id.idLinearLayoutMember);
        linearLayoutCoach = view.findViewById(R.id.idLinearLayoutCoach);
        buttonProceed = view.findViewById(R.id.idButtonProceed);
        unSelectedBG = ContextCompat.getDrawable(getContext(),R.drawable.bg_rounded_corner_20);
        selectedBG = ContextCompat.getDrawable(getContext(),R.drawable.bg_rounded_corner_20_selected);

        linearLayoutMember.setOnClickListener(this::onClick);
        linearLayoutCoach.setOnClickListener(this::onClick);
        buttonProceed.setOnClickListener(this::onClick);


        USER_TYPE = USER_TYPE_MEMBER;
        select(linearLayoutMember);
        deSelect(linearLayoutCoach);

    }

    void select(LinearLayout linearLayout){
        linearLayout.setBackground(selectedBG);
    }
    void deSelect(LinearLayout linearLayout){
        linearLayout.setBackground(unSelectedBG);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idLinearLayoutMember){
            USER_TYPE = USER_TYPE_MEMBER;
            select(linearLayoutMember);
            deSelect(linearLayoutCoach);

        }else if(v.getId() == R.id.idLinearLayoutCoach){
            USER_TYPE = USER_TYPE_COACH;
            select(linearLayoutCoach);
            deSelect(linearLayoutMember);
        }else if (v.getId() == R.id.idButtonProceed){
            Intent intent = new Intent(getContext(),RegistrationActivity.class);
            intent.putExtra("USER_TYPE",USER_TYPE);
            startActivity(intent);
        }
    }
}