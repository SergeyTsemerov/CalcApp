package ru.geekbrains.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(MainActivity.theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button defaultTheme = findViewById(R.id.default_theme);
        initThemeButton(defaultTheme, R.style.Theme_CalcApp);
        Button anotherTheme = findViewById(R.id.another_theme);
        initThemeButton(anotherTheme, R.style.AnotherTheme);

    }

    private void initThemeButton(View button, int codeStyle) {
        button.setOnClickListener(view -> {
            MainActivity.setDefaultTheme(codeStyle);
            recreate();
        });
    }
}