package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gautruc.butter.databinding.ActivityFragmentUserPolicyBinding;
import com.gautruc.butter.databinding.ActivityProfileScreenBinding;

public class FragmentUserPolicy extends AppCompatActivity {

    ActivityFragmentUserPolicyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_user_policy);
        binding = ActivityFragmentUserPolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imvBackFromPolicyToProfileScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentUserPolicy.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}