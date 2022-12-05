package com.gautruc.butter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gautruc.adapter.ProductAdapter;
import com.gautruc.database.DatabaseHelper;
import com.gautruc.model.product;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuScreenActivity extends AppCompatActivity {

    GridView gv;
    ArrayList<product> arr;
    ProductAdapter adapter;
    DatabaseHelper dbHelper;
    LinearLayout llpromotion, llcookie, llcandy, llbread, llcake, lldrink;
    TextView catName;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);


//        getSupportActionBar().hide();


        linkView();
        createData();
        loadInitial();
        addEvents();
//        dbHelper = new DatabaseHelper(MenuSreenActivity.this,"Product.sqlite",null,1);
//
//        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Promotion(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
//        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Cookie(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
//
////        dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'dailycookie', 'Daily Cookie', '5.0', 35000, 40000)");
////        dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'brownsugar', 'Brown Sugar', '4.5', 10000, 12000)");
////        dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'cookiecoffee', 'Cookie Coffee', '4.7', 40000, 50000)");.
//        if (dbHelper.getNumOfRows("Promotion") == 0) {
//            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'dailycookie', 'Daily Cookie', '5.0', 35000, 40000)");
//            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'brownsugar', 'Brown Sugar', '4.5', 10000, 12000)");
//            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'cookiecoffee', 'Cookie Coffee', '4.6', 40000, 50000)");
//        }

//        dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'browniecookie1', 'Brownie Cookie', '5.0', 50000, null)");

//        Cursor dataProduct = dbHelper.GetData("SELECT * FROM Promotion");
//        while (dataProduct.moveToNext()) {
//            String hinhanh = dataProduct.getString(1);
//            String name = dataProduct.getString(2);
//            String rate = dataProduct.getString(3);
//            int price = dataProduct.getInt(4);
//            int oldprice = dataProduct.getInt(5);
//
//            int Id = dataProduct.getInt(0);
//
//            arr.add(new product(Id, hinhanh, name, rate, price, oldprice));
//        }
//        adapter.notifyDataSetChanged();

//        llpromotion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                arr.clear();
//                Cursor dataProduct = dbHelper.GetData("SELECT * FROM Promotion");
//                while (dataProduct.moveToNext()) {
//                    String hinhanh = dataProduct.getString(1);
//                    String name = dataProduct.getString(2);
//                    String rate = dataProduct.getString(3);
//                    int price = dataProduct.getInt(4);
//                    int oldprice = dataProduct.getInt(5);
//
//                    int Id = dataProduct.getInt(0);
//
//                    arr.add(new product(Id, hinhanh, name, rate, price, oldprice));
//                }
//                adapter.notifyDataSetChanged();
//
//            }
//        });
//
//        llcookie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MenuSreenActivity.this, OngoingScreenActivity.class);
//                startActivity(intent);
//            }
//        });

    }



    private void linkView() {
        gv = (GridView) findViewById(R.id.gv_productList);
        llpromotion = (LinearLayout) findViewById(R.id.ll_promotion);
        llcookie = (LinearLayout) findViewById(R.id.ll_cookie);
        llcandy = (LinearLayout) findViewById(R.id.ll_candy);
        llbread = (LinearLayout) findViewById(R.id.ll_bread);
        llcake = (LinearLayout) findViewById(R.id.ll_cake);
        lldrink = (LinearLayout) findViewById(R.id.ll_drink);
        catName = (TextView) findViewById(R.id.txt_catName);
        btnAdd = (Button) findViewById(R.id.btn_add);
    }

    private void loadInitial() {
        arr = new ArrayList<>();

        arr = loadTable("Promotion");
        adapter = new ProductAdapter(this,R.layout.item_product, arr);
        gv.setAdapter(adapter);
    }

    private void createData() {
        dbHelper = new DatabaseHelper(MenuScreenActivity.this,"Product.sqlite",null,1);

        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Promotion(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Cookie(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Candy(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Bread(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Cake(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");
        dbHelper.QuerryData("CREATE TABLE IF NOT EXISTS Drink(Id INTEGER PRIMARY KEY AUTOINCREMENT, hinhanh BLOB, name VARCHAR(200), rate VARCHAR(200),  price INTEGER, oldprice INTEGER)");

//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='Daily Cookie'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='brownsugar'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='cutewormchocolate'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='croissant'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='Cookie Oatmeal'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='Brown Sugar'");
//        dbHelper.QuerryData("DELETE FROM Promotion WHERE name='Cookie Coffee'");
//        dbHelper.QuerryData("DELETE FROM Cookie WHERE name='Cookie Coffee'");
//        dbHelper.QuerryData("DELETE FROM Cookie WHERE name='Brownie Cookie'");


        if (dbHelper.getNumOfRows("Promotion") == 0) {
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'dailycookie', 'Daily Cookie', '5.0', 35000, 40000)");
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'brownsugar', 'Brown Sugar', '4.5', 10000, 12000)");
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'cutewormchocolate', 'Cuteworm Chocolate', '5.0', 45000, 55000)");
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'croissant', 'Croissant', '4.9', 25000, 35000)");
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'cookiecoffee', 'Cookie Coffee', '4.9', 40000, 50000)");
            dbHelper.QuerryData("INSERT INTO Promotion VALUES(null, 'coldbrewmocha', 'Cold brew mocha', '4.8', 50000, 65000)");
        }
        if (dbHelper.getNumOfRows("Cookie") == 0){
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'cookieoatmeal1', 'Cookie Oatmeal', '4.8', 50000, null)");
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'dailycookie7', 'Daily Cookie', '5.0', 40000, null)");
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'cookiepeanutoatmeal2', 'Cookie peanut oatmeal', '4.9', 55000, null)");
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'browniecookieicecream1', 'Brownie Ice-cream', '4.9', 50000, null)");
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'browniecookie2', 'Brownie Cookie', '4.8', 50000, null)");
            dbHelper.QuerryData("INSERT INTO Cookie VALUES(null, 'cookiecoffee3', 'Cookie Coffee', '4.9', 50000, null)");
        }
        if (dbHelper.getNumOfRows("Candy") == 0){
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'pinkpop1', 'Pink Pop', '4.7', 10000, null)");
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'greenpop1', 'Green Pop', '4.8', 10000, null)");
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'lollipop1', 'Lollipop', '5.0', 12000, null)");
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'brownsugarpop2', 'Brown sugar', '5.0', 15000, null)");
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'mashmallow1', 'Marshmallow', '5.0', 20000, null)");
            dbHelper.QuerryData("INSERT INTO Candy VALUES(null, 'silverpop1', 'Silver Pop', '4.9', 15000, null)");
        }
        if (dbHelper.getNumOfRows("Bread") == 0){
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'croissant1', 'Croissant', '5.0', 35000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'brioche1', 'Brioche', '4.7', 35000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'raisinbread1', 'Raisin Bread', '4.5', 30000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'toastlava1', 'Toast Lava Salted Egg', '5.0', 60000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'croissanttrungmuoi1', 'Croissant Salt Egg', '4.9', 40000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'multigrainbread1', 'Multi Grain Bread', '4.5', 35000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'chocolatepretzelpastry1', 'Chocolate Pretzel', '4.6', 55000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'toastmango1', 'Toast Mango', '4.9', 65000, null)");
            dbHelper.QuerryData("INSERT INTO Bread VALUES(null, 'toaststrawberry1', 'Toast Strawberry', '4.7', 65000, null)");
        }

        if (dbHelper.getNumOfRows("Cake") == 0){
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'cuteworm1', 'Cuteworm Chocolate', '5.0', 55000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'oreocheese1', 'Oreo Cheese', '4.9', 48000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'limecheese1', 'Lime Cheese', '4.8', 48000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'avocadobutter2', 'Avocado Butter', '5.0', 50000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'daisy1', 'Daisy', '4.9', 250000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'higanbana1', 'Higanbana', '4.7', 330000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'butterflies1', 'Butterflies', '4.5', 395000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'ceredwen1', 'Ceridwen', '4.7', 395000, null)");
            dbHelper.QuerryData("INSERT INTO Cake VALUES(null, 'blackberries1', 'Blackberries', '4.8', 330000, null)");
        }

        if (dbHelper.getNumOfRows("Drink") == 0){
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'thaimilktea1', 'Thai milk tea', '4.9', 55000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'blackteamacchiato1', 'Black tea macchiato', '5.0', 45000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'matchalatte3', 'Matcha Latte', '4.9', 47000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'cheryolongicetea1', 'Cherry Olong Ice tea', '4.9', 65000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'jasmineteamacchiato', 'Jasmine tea macchiato', '4.6', 45000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'trathachbuoi2', 'Calamansi Iced tea', '4.8', 45000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'icemilkcoffee3', 'Iced milk coffee', '5.0', 40000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'icedcofee1', 'Iced coffee', '4.8', 35000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'coldbrewlatte2', 'Cold brew latte', '4.9', 45000, null)");
            dbHelper.QuerryData("INSERT INTO Drink VALUES(null, 'coldbrewmocha1', 'Cold brew mocha', '4.8', 65000, null)");
        }

    }

    private ArrayList<product> loadTable(String tableName){
        ArrayList<product> list = new ArrayList<>();
        Cursor dataProduct = dbHelper.GetData("SELECT * FROM " + tableName);
        while (dataProduct.moveToNext()) {
            String hinhanh = dataProduct.getString(1);
            String name = dataProduct.getString(2);
            String rate = dataProduct.getString(3);
            int price = dataProduct.getInt(4);
            int oldprice = dataProduct.getInt(5);

            int Id = dataProduct.getInt(0);

            list.add(new product(Id, hinhanh, name, rate, price, oldprice));
        }
        return list;
    };

    private void addEvents() {

        llpromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                arr = new ArrayList<>();
//                Cursor dataProduct = dbHelper.GetData("SELECT * FROM Promotion");
//                while (dataProduct.moveToNext()) {
//                    String hinhanh = dataProduct.getString(1);
//                    String name = dataProduct.getString(2);
//                    String rate = dataProduct.getString(3);
//                    int price = dataProduct.getInt(4);
//                    int oldprice = dataProduct.getInt(5);
//
//                    int Id = dataProduct.getInt(0);
//
//                    arr.add(new product(Id, hinhanh, name, rate, price, oldprice));
//                }
//                adapter.notifyDataSetChanged();
                catName.setText("Khuyến mãi");
                arr = new ArrayList<>();
                arr = loadTable("Promotion");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

        llcookie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catName.setText("Bánh quy");
                arr = new ArrayList<>();
                arr = loadTable("Cookie");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

        llcandy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catName.setText("Kẹo");
                arr.clear();
                arr = new ArrayList<>();
                arr = loadTable("Candy");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

        llbread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catName.setText("Bánh mì");
                arr.clear();
                arr = new ArrayList<>();
                arr = loadTable("Bread");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

        llcake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catName.setText("Bánh kem");
                arr.clear();
                arr = new ArrayList<>();
                arr = loadTable("Cake");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

        lldrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catName.setText("Thức uống");
                arr.clear();
                arr = new ArrayList<>();
                arr = loadTable("Drink");
                adapter = new ProductAdapter(MenuScreenActivity.this,R.layout.item_product, arr);
                gv.setAdapter(adapter);
            }
        });

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(MenuScreenActivity.this, MenuScreenWithCartActivity.class);
//                startActivity(intent3);
//            }
//        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MenuScreenActivity.this,ProductDetailActivity.class);
                startActivity(intent);
            }
        });

    }

}

