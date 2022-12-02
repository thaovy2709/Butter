package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gautruc.adapter.ProductAdapter;
import com.gautruc.database.DatabaseHelper;
import com.gautruc.model.product;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuSreenActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<product> arr;
    ProductAdapter adapter;
    DatabaseHelper dbHelper;
    LinearLayout llpromption;
    TextView catName;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sreen);
        
        getSupportActionBar().hide();

        gv = (GridView) findViewById(R.id.gv_productList);
        arr = new ArrayList<>();
        adapter = new ProductAdapter(this,R.layout.item_product, arr);
        gv.setAdapter(adapter);
        llpromption = (LinearLayout) findViewById(R.id.ll_promotion);
        catName = (TextView) findViewById(R.id.txt_catName);

        dbHelper = new DatabaseHelper(MenuSreenActivity.this,"Product.sqlite",null,1);

        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Promotion(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh VARCHAR(200), name VARCHAR(200), rate VARCHAR(200), price REAL, oldprice REAL)");

        dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'dailycookie', 'Daily Cookie', '5.0', '35.000', '40.000')");

        Cursor dataProduct = dbHelper.GetData("SELECT * FROM Promotion");
        while (dataProduct.moveToNext()) {
            String name = dataProduct.getString(1);
            String rate = dataProduct.getString(2);
            Double price = dataProduct.getDouble(3);
            Double oldprice = dataProduct.getDouble(4);
            String hinhanh = dataProduct.getString(5);

            int Id = dataProduct.getInt(0);

            arr.add(new product(Id, name, rate, price, oldprice, hinhanh));
        }
        adapter.notifyDataSetChanged();

//        llpromption.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapter = new ProductAdapter(MenuSreenActivity.this,R.layout.item_product, arr);
//                gv.setAdapter(adapter);
//                if (((gv != null) && (gv.equals("Khuyến mãi"))) || ((catName != null) && (catName.equals("Khuyến mãi")))){
//                    Cursor dataProduct = dbHelper.GetData("SELECT * FROM Promotion");
//                    while (dataProduct.moveToNext()) {
//                        String name = dataProduct.getString(1);
//                        String rate = dataProduct.getString(2);
//                        Double price = dataProduct.getDouble(3);
//                        Double oldprice = dataProduct.getDouble(4);
//
//                        int Id = dataProduct.getInt(0);
//
//                        arr.add(new product(Id, name, oldprice, price, rate));
//                    }
//                    adapter.notifyDataSetChanged();
//                }
//            }
//        });
    }
}

