package com.example.supermarket;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.supermarket.DatabaseHelper;
import com.example.supermarket.R;
import com.example.supermarket.RatingActivity;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput, addressInput;
    private Button saveButton, rateButton;
    private DatabaseHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameInput);
        addressInput = findViewById(R.id.addressInput);
        saveButton = findViewById(R.id.saveButton);
        rateButton = findViewById(R.id.rateButton);
        dbHelper = new DatabaseHelper(this);

        saveButton.setOnClickListener(view -> saveSupermarket());
        rateButton.setOnClickListener(view -> openRatingActivity());
    }

    private void saveSupermarket() {
        String name = nameInput.getText().toString().trim();
        String address = addressInput.getText().toString().trim();

        if (!name.isEmpty() && !address.isEmpty()) {
            dbHelper.insertSupermarket(name, address);
            Toast.makeText(this, "Supermarket saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void openRatingActivity() {
        startActivity(new Intent(MainActivity.this, RatingActivity.class));
    }
}
