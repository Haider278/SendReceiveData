package com.example.sentandrecivedata;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.sentandrecivedata.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    ActivityResultBinding resultBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resultBinding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(resultBinding.getRoot());
        Intent receivedIntent = getIntent();
        resultBinding.content.setText(receivedIntent.getStringExtra("myString"));

        //
        resultBinding.sendToActivity1.setOnClickListener(view -> {
            Intent intent=getIntent();
            intent.putExtra("myData","I from Activity Result");
            setResult(RESULT_OK,intent);
            finish();
        });


    }

}