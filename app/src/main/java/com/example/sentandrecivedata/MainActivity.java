package com.example.sentandrecivedata;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sentandrecivedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        //
        mainBinding.sendToActivity.setOnClickListener(view -> sendDataToResultActivity());
        //
        mainBinding.openForReceived.setOnClickListener(view -> receivedDataFromResult());
    }

    private void receivedDataFromResult() {
        Intent intentForResult=new Intent(this,ResultActivity.class);
        activityResultLauncher.launch(intentForResult);
    }

    private void sendDataToResultActivity() {
        Intent sendIntent = new Intent(this, ResultActivity.class);
        sendIntent.putExtra("myString", "I am from main activity");
        startActivity(sendIntent);

    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts
            .StartActivityForResult(), result -> {
        if(result.getResultCode()== Activity.RESULT_OK){
            mainBinding.contentFromResult.setText(result.getData().getStringExtra("myData"));
        }

    });
}
