package ru.geekbrains.calcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.geekbrains.calcapp.domain.Calculation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultView;
    Calculation calculation;

    private final int[] numberButtonIds = new int[]{R.id.numberZeroButton, R.id.numberOneButton, R.id.numberTwoButton, R.id.numberThreeButton,
            R.id.numberFourButton, R.id.numberFiveButton, R.id.numberSixButton, R.id.numberSevenButton, R.id.numberEightButton,
            R.id.numberNineButton, R.id.dotButton};

    private final int[] operationButtonIds = new int[]{R.id.multiplyButton, R.id.divideButton, R.id.additionButton, R.id.subtractButton,
            R.id.equalsButton};

    static int theme = R.style.Theme_CalcApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        calculation = new Calculation();
        initView();
    }

    public static void setDefaultTheme(int theme) {
        MainActivity.theme = theme;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            this.startActivity(intent);
        }
        return true;
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.allClearButton) {
            calculation.allClearPressed(resultView);
        }

        for (int numberButtonId : numberButtonIds) {
            if (view.getId() == numberButtonId) {
                calculation.buttonPressed(view.getId());
                resultView.setText(calculation.getText());
            }
        }

        for (int operationButtonId : operationButtonIds) {
            if (view.getId() == operationButtonId) {
                calculation.operationButtonPressed(view.getId());
                resultView.setText(calculation.getText());
            }
        }
    }

    private void initView() {
        resultView = findViewById(R.id.outputScreen);
        buttonClickListeners();
    }

    private void buttonClickListeners() {
        Button allClearBtn = findViewById(R.id.allClearButton);
        allClearBtn.setOnClickListener(this);

        for (int numberButtonId : numberButtonIds) {
            findViewById(numberButtonId).setOnClickListener(this);
        }

        for (int operationButtonId : operationButtonIds) {
            findViewById(operationButtonId).setOnClickListener(this);
        }
    }
}