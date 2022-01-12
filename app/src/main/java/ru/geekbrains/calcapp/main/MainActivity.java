package ru.geekbrains.calcapp.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import ru.geekbrains.calcapp.R;
import ru.geekbrains.calcapp.databinding.ActivityMainBinding;
import ru.geekbrains.calcapp.domain.Calculation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    Calculation calculation;

    private final int[] numberButtonIds = new int[]{R.id.numberZeroButton, R.id.numberOneButton,
            R.id.numberTwoButton, R.id.numberThreeButton,
            R.id.numberFourButton, R.id.numberFiveButton, R.id.numberSixButton,
            R.id.numberSevenButton, R.id.numberEightButton,
            R.id.numberNineButton, R.id.dotButton};

    private final int[] operationButtonIds = new int[]{R.id.multiplyButton, R.id.divideButton,
            R.id.additionButton, R.id.subtractButton,
            R.id.equalsButton};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        calculation = new Calculation();
        initView();
    }

    private void initView() {
        buttonClickListeners();
    }

    @Override
    public void onClick(View view) {

        TextView resultView = binding.outputScreen;

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

    private void buttonClickListeners() {
        binding.allClearButton.setOnClickListener(this);

        for (int numberButtonId : numberButtonIds) {
            findViewById(numberButtonId).setOnClickListener(this);
        }

        for (int operationButtonId : operationButtonIds) {
            findViewById(operationButtonId).setOnClickListener(this);
        }
    }
}