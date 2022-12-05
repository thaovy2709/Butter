package com.gautruc.butter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.gautruc.butter.databinding.ActivityFragmentPersonalInformationBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FragmentPersonalInformation extends AppCompatActivity {

    ActivityFragmentPersonalInformationBinding binding;
    EditText datePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_personal_information);
        getSupportActionBar().hide();

        binding = ActivityFragmentPersonalInformationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        datePicker = findViewById(R.id.edt_ChonNgaySinh);
        //Tắt phần nhập từ bàn phím
        datePicker.setInputType(InputType.TYPE_NULL);

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(datePicker);
            }
        });

        addEvents();
    }

    private void addEvents() {
        binding.radgGioiTinhGroup.getCheckedRadioButtonId();

        binding.btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FragmentPersonalInformation.this, "Đã cập nhật thành công", Toast.LENGTH_SHORT).show();
            }
        });

        binding.imvBackFromPersonalInfToProfileScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FragmentPersonalInformation.this, ProfileScreenActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showDateDialog(EditText datePicker) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = simpleDateFormat.format(calendar.getTime());
                datePicker.setText(dateString);
            }
        };

        new DatePickerDialog(FragmentPersonalInformation.this, dateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}