package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentMethodFragment extends AppCompatActivity {


    ImageView imv_paymentbackcheckout;
    RadioGroup radgroup_payment;
    TextView txt_paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_payment_method);


        linkView();
        chooseMethod();
        addEvents();


    }

    private void linkView() {
        imv_paymentbackcheckout = findViewById(R.id.imv_paymentbackcheckout);
        radgroup_payment = findViewById(R.id.radgroup_payment);
        txt_paymentMethod = findViewById(R.id.txt_paymentMethod);
    }

    private void chooseMethod() {
        radgroup_payment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rad_money){
                    Toast toast = Toast.makeText(PaymentMethodFragment.this, "Bạn đã áp dụng phương thức thanh toán là tiền mặt thành công", Toast.LENGTH_SHORT);
                    toast.show();
                    String str = "Tiền mặt";

                    Intent intent = new Intent(PaymentMethodFragment.this, CheckoutActivity.class);

                    intent.putExtra("payment",str);
//
//                    startActivity(intent);

//                    String str = edt_address.getText().toString();
//                    Intent intent = new Intent(ChooseAddressCheckout.this, CheckoutActivity.class);
//                    intent.putExtra("new address",str);
                    setResult(Activity.RESULT_FIRST_USER, intent);
                    finish();

                }
                else if(checkedId == R.id.rad_Momo){
                    Toast toast = Toast.makeText(PaymentMethodFragment.this, "Bạn đã áp dụng phương thức thanh toán là Ví MoMo thành công", Toast.LENGTH_SHORT);
                    toast.show();
                    String str = "Ví MoMo";

                    Intent intent = new Intent(PaymentMethodFragment.this, CheckoutActivity.class);

                    intent.putExtra("payment",str);

                    setResult(Activity.RESULT_FIRST_USER, intent);
                    finish();
//                    startActivity(intent);
                }
                else if(checkedId == R.id.rad_zalopay){
                    Toast toast = Toast.makeText(PaymentMethodFragment.this, "Bạn đã áp dụng phương thức thanh toán là ví ZaloPay thành công", Toast.LENGTH_SHORT);
                    toast.show();
                    String str = "ZaloPay";

                    Intent intent = new Intent(PaymentMethodFragment.this, CheckoutActivity.class);

                    intent.putExtra("payment",str);
                    setResult(Activity.RESULT_FIRST_USER, intent);
                    finish();
//                    startActivity(intent);
                }
                else {
                    Toast toast = Toast.makeText(PaymentMethodFragment.this, "Bạn đã áp dụng phương thức thanh toán là ví ShopeePay thành công", Toast.LENGTH_SHORT);
                    toast.show();
                    String str = "ShopeePay";

                    Intent intent = new Intent(PaymentMethodFragment.this, CheckoutActivity.class);

                    intent.putExtra("payment",str);
                    setResult(Activity.RESULT_FIRST_USER, intent);
                    finish();
//                    startActivity(intent);
                }
            }
        });

    }

    private void addEvents() {
        imv_paymentbackcheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}