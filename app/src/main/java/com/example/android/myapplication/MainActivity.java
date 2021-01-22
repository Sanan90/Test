package com.example.android.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String YOUR_ACCOUNT = "YOUR_ACCOUNT";
    private EditText txtname;
    private Account account = new Account();
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        Button btn_to_browser = findViewById(R.id.btn_to_browser);
        btn_to_browser.setOnClickListener(v -> {
            String url = "https://geekbrains.ru/lessons/110324";
            Uri uri = Uri.parse(url);
            Intent browser = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(browser);
        });

        Button btnGreetings = findViewById(R.id.btnGreetings);
        txtname = findViewById(R.id.textName);
        final TextView textHello = findViewById(R.id.textHello);
        btnGreetings.setOnClickListener(v -> {
            String name = txtname.getText().toString();
            String sayHello = getString(R.string.greetings) + name;
            textHello.setText(sayHello);
        });

        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(v -> {

            Intent intent = new Intent(this, Settings.class);
            populateAccount();
            intent.putExtra(YOUR_ACCOUNT, account);
            startActivityForResult(intent, REQUEST_CODE_SETTING_ACTIVITY);
        });
    }

    private void populateAccount() {
        account.setName(txtname.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            account = data.getParcelableExtra(YOUR_ACCOUNT);
            populateAccount();
        }
    }
}