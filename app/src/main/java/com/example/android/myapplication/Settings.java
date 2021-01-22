package com.example.android.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;


public class Settings extends AppCompatActivity {

    private EditText editName;
    private EditText editSurname;
    private EditText editAge;
    private EditText editEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initView();

        Account account = getIntent().getExtras().getParcelable(MainActivity.YOUR_ACCOUNT);
        if (account != null) {
            populateView(account);
        }
    }

    private void populateView(@NonNull Account account){
        editName.setText(account.getName());
        editSurname.setText(account.getSurname());
        editAge.setText(String.format(Locale.getDefault(), "%d", account.getAge()));
        editEmail.setText(account.geteMail());

    }

    private void initView() {
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(v -> {

            Intent intentResult = new Intent();
            intentResult.putExtra(MainActivity.YOUR_ACCOUNT, createAccount());
            setResult(RESULT_OK, intentResult);

            finish();
        });

        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editAge = findViewById(R.id.editAge);
        editEmail = findViewById(R.id.editEmail);
    }

    private Account createAccount() {
        return new Account(
                editName.getText().toString(), editSurname.getText().toString(),
                Integer.parseInt(editAge.getText().toString()),
                editEmail.getText().toString());
    }
}