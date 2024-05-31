package com.mirea.kt.practice2_10;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PhoneListActivity extends AppCompatActivity {
    private static final String TAG = "PhoneListActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        PhoneDatabaseHelper dbHelper = new PhoneDatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        List<Phone> phones = new ArrayList<>();
        Cursor cursor = db.query("phones", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String model = cursor.getString(cursor.getColumnIndex("model"));
            String serialNumber = cursor.getString(cursor.getColumnIndex("serial_number"));
            int price = cursor.getInt(cursor.getColumnIndex("price"));

            phones.add(new Phone(model, serialNumber, price));
        }
        cursor.close();
        db.close();

        PhoneAdapter adapter = new PhoneAdapter(phones);
        recyclerView.setAdapter(adapter);

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
