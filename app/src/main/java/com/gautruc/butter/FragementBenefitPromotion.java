package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.gautruc.butter.databinding.ActivityFragementBenefitPromotionBinding;

import java.util.ArrayList;

public class FragementBenefitPromotion extends AppCompatActivity {

    ListView lv;

    ActivityFragementBenefitPromotionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragement_benefit_promotion);

        binding = ActivityFragementBenefitPromotionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imvBenefit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}