package com.mirea.kt.practice2_10;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private PhoneDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new PhoneDatabaseHelper(this);
        EditText modelEditText = findViewById(R.id.modelEditText);
        EditText serialNumberEditText = findViewById(R.id.serialNumberEditText);
        EditText priceEditText = findViewById(R.id.priceEditText);
        Button saveButton = findViewById(R.id.saveButton);
        Button viewButton = findViewById(R.id.viewButton);

        saveButton.setOnClickListener(v -> {
            String model = modelEditText.getText().toString();
            String serialNumber = serialNumberEditText.getText().toString();
            String priceText = priceEditText.getText().toString();

            if (TextUtils.isEmpty(model) || TextUtils.isEmpty(serialNumber) || TextUtils.isEmpty(priceText)) {
                Toast.makeText(MainActivity.this, R.string.error_empty_fields, Toast.LENGTH_SHORT).show();
                return;
            }

            int price;
            try {
                price = Integer.parseInt(priceText);
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, R.string.error_invalid_price, Toast.LENGTH_SHORT).show();
                return;
            }

            if (price < 0) {
                Toast.makeText(MainActivity.this, R.string.error_negative_price, Toast.LENGTH_SHORT).show();
                return;
            }

            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("model", model);
            values.put("serial_number", serialNumber);
            values.put("price", price);

            long newRowId = db.insert("phones", null, values);
            if (newRowId != -1) {
                Toast.makeText(MainActivity.this, R.string.phone_saved, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, R.string.error_saving_phone, Toast.LENGTH_SHORT).show();
            }

            db.close();
        });

        viewButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PhoneListActivity.class);
            startActivity(intent);
        });

        Log.d(TAG, "onCreate: Activity created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: Activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: Activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: Activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: Activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity destroyed");
    }
}
