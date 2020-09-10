package com.example.mybirdwatcher;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;


public class AddBird extends AppCompatActivity {

    EditText name_input, location_input, date_input;
    Button confirm_button, choose_button;
    byte[] image;
    ImageView birdImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bird);

            birdImage = (ImageView) findViewById(R.id.bird_imageView);
            name_input = findViewById(R.id.name_input);
            location_input = findViewById(R.id.location_input);
            date_input = findViewById(R.id.date_input);

            confirm_button = findViewById(R.id.add_button);
            choose_button = findViewById(R.id.chooseimagebutton);

        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper myDB = new DatabaseHelper(AddBird.this);
                myDB.addBird(name_input.getText().toString().trim(),
                        location_input.getText().toString().trim(),
                       date_input.getText().toString().trim());

            }
        });
    }
}

