package com.example.startactivityforresultexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int REQUEST_PLUS = 300;
    Button btn_plus;
    TextView tx_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_plus = (Button)findViewById(R.id.btn_plus);
        tx_result = (TextView)findViewById(R.id.tx_result);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                startActivityForResult(intent, REQUEST_PLUS);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_PLUS && resultCode == RESULT_OK) {
            tx_result.setText(data.getStringExtra("result"));
        }
    }
}

