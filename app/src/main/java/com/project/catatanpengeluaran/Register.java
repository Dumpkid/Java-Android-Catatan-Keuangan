package com.project.catatanpengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class Register extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);
        EditText etUsernameReg = findViewById(R.id.etUsernameReg);
        EditText etPasswordReg = findViewById(R.id.etPasswordReg);
        EditText etPasswordRegCount = findViewById(R.id.etPasswordRegCount);
        Button btRegistrasi = findViewById(R.id.btRegistrasi);


        btRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsernameReg.getText().toString().trim();
                String password = etPasswordReg.getText().toString().trim();
                String passwordcount = etPasswordRegCount.getText().toString().trim();

                ContentValues values = new ContentValues();

                if(!password.equals(passwordcount)){
                    Toast.makeText(Register.this,"Password not match", Toast.LENGTH_SHORT);
                }else if(password.equals("") || username.equals("")){
                    Toast.makeText(Register.this,"Username and Password Cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    values.put(DBHelper.row_username, username);
                    values.put(DBHelper.row_password, password);
                    dbHelper.insertData(values);

                    Toast.makeText(Register.this,"Register Successful", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });
    }
}