package com.example.startactivityforresultexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    EditText edit_1, edit_2;
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        edit_1 = (EditText) findViewById(R.id.num_1);
        edit_2 = (EditText) findViewById(R.id.num_2);
        btn_result = (Button) findViewById(R.id.btn_result);

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_1.getText().toString().equals(""))
                    edit_1.setText("0");
                if(edit_2.getText().toString().equals(""))
                    edit_2.setText("0");
                int num1 = Integer.parseInt(edit_1.getText().toString());
                int num2 = Integer.parseInt(edit_2.getText().toString());
                int result = num1 + num2;

                Intent intent = new Intent();
                intent.putExtra("result", "연산 결과는 " + result + " 입니다.");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}