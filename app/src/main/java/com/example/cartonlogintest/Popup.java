package com.example.cartonlogintest;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Popup extends AppCompatActivity {

    Button addItem;
    EditText nameText, quantityText, labelText, priceText;
    String name, label, quantity;
    static Item temp;
    double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        nameText = findViewById(R.id.itemName);
        quantityText = findViewById(R.id.quantity);
        labelText = findViewById(R.id.itemLabel);
        priceText = findViewById(R.id.itemPrice);

        addItem = findViewById(R.id.buttonAdd);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height * .8));

        WindowManager.LayoutParams  params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        addItem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                name = nameText.getText().toString();
                label = labelText.getText().toString();
                quantity = quantityText.getText().toString();
                price = Double.parseDouble(priceText.getText().toString());
                if(name != null){
                    System.out.println("HERE3");
                    temp = new Item(name,price,label,quantity);
                }
            }
        });
        getWindow().setAttributes(params);
    }

    public static Item getItem(){
        System.out.println("HERE");
        System.out.println(temp == null);
        return temp;
    }
}