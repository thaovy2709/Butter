package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gautruc.butter.databinding.FragmentCancelOrderBinding;
import com.gautruc.butter.databinding.FragmentCancelSuccessBinding;

public class CancelOrderFragment extends AppCompatActivity {

    FragmentCancelOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_cancel_order);
        binding = FragmentCancelOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvent();
    }

    private void addEvent() {
        binding.txtReasonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(CancelOrderFragment.this);
                dialog.setContentView(R.layout.dialog_cancelorder);

                RadioGroup rg_cancelorder;
                RadioButton rad_reason1, rad_reason2, rad_reason3, rad_reason4;

                Button btn_confirmCancel = dialog.findViewById(R.id.btn_confirmCancel);
                btn_confirmCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(CancelOrderFragment.this, CancelSuccessFragment.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });

        binding.imvBackOngoingTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}