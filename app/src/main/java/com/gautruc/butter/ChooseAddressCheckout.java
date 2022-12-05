package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseAddressCheckout extends AppCompatActivity {

    ImageView imv_backCheckout;
    Button btn_saveAddress;
    EditText edt_address;

    TextView txt_address;
    //khai báo spinner
    Spinner spinnerCity, spinnerDistrict, spinnerWard;
    ArrayAdapter<String> adapterCity, adapterDistrict, adapterWard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_choose_address_checkout);

        linkView();
        loadAddress();

        chooseAddress();

        addEvent();



    }

    private void chooseAddress() {

    }

    private void addEvent() {

        imv_backCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_saveAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ChooseAddressCheckout.this, "Bạn đã cập nhật địa chỉ thành công", Toast.LENGTH_SHORT);
                toast.show();

                String str = edt_address.getText().toString();
                    Intent intent = new Intent(ChooseAddressCheckout.this, CheckoutActivity.class);
                    intent.putExtra("new address",str);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
        });


    }

    private void backActivity() {
    }

    private void loadAddress() {
        adapterCity = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterCity.addAll(getResources().getStringArray(R.array.city_array));
        spinnerCity.setAdapter(adapterCity);

        adapterDistrict = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterDistrict.addAll(getResources().getStringArray(R.array.district_array));
        spinnerDistrict.setAdapter(adapterDistrict);

        adapterWard = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterWard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterWard.addAll(getResources().getStringArray(R.array.ward_array));
        spinnerWard.setAdapter(adapterWard);

    }

    private void linkView() {
        btn_saveAddress = findViewById(R.id.btn_saveAddress);
        imv_backCheckout = findViewById(R.id.imv_backCheckout);
        spinnerCity = findViewById(R.id.spinnerCity);
        spinnerDistrict = findViewById(R.id.spinnerDistrict);
        spinnerWard = findViewById(R.id.spinnerWard);
        txt_address = findViewById(R.id.txt_address);
        edt_address = findViewById(R.id.edt_address);

    }
}