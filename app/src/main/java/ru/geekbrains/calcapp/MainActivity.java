package ru.geekbrains.calcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resultView; //поле ввода операции и вывода результата
    Calculation calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = new Calculation();
        initView();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.allClearButton:
                calculation.allClearPressed(resultView);
                break;
            case R.id.multiplyButton:
                calculation.operationButtonPressed(R.id.multiplyButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberSevenButton:
                calculation.buttonPressed(R.id.numberSevenButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberEightButton:
                calculation.buttonPressed(R.id.numberEightButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberNineButton:
                calculation.buttonPressed(R.id.numberNineButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.divideButton:
                calculation.operationButtonPressed(R.id.divideButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberFourButton:
                calculation.buttonPressed(R.id.numberFourButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberFiveButton:
                calculation.buttonPressed(R.id.numberFiveButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberSixButton:
                calculation.buttonPressed(R.id.numberSixButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.additionButton:
                calculation.operationButtonPressed(R.id.additionButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberOneButton:
                calculation.buttonPressed(R.id.numberOneButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberTwoButton:
                calculation.buttonPressed(R.id.numberTwoButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberThreeButton:
                calculation.buttonPressed(R.id.numberThreeButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.subtractButton:
                calculation.operationButtonPressed(R.id.subtractButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.numberZeroButton:
                calculation.buttonPressed(R.id.numberZeroButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.dotButton:
                calculation.buttonPressed(R.id.dotButton);
                resultView.setText(calculation.getText());
                break;
            case R.id.equalsButton:
                calculation.operationButtonPressed(R.id.equalsButton);
                resultView.setText(calculation.getText());
                break;

        }
    }

    private void initView(){
        resultView = findViewById(R.id.outputScreen);
        buttonClickListeners();
    }

    private void buttonClickListeners() {
        Button allClearBtn = findViewById(R.id.allClearButton);
        allClearBtn.setOnClickListener(this);
        Button multiplyBtn = findViewById(R.id.multiplyButton);
        multiplyBtn.setOnClickListener(this);
        Button numberSevenBtn = findViewById(R.id.numberSevenButton);
        numberSevenBtn.setOnClickListener(this);
        Button numberEightBtn = findViewById(R.id.numberEightButton);
        numberEightBtn.setOnClickListener(this);
        Button numberNineBtn = findViewById(R.id.numberNineButton);
        numberNineBtn.setOnClickListener(this);
        Button divideBtn = findViewById(R.id.divideButton);
        divideBtn.setOnClickListener(this);
        Button numberFourBtn = findViewById(R.id.numberFourButton);
        numberFourBtn.setOnClickListener(this);
        Button numberFiveBtn = findViewById(R.id.numberFiveButton);
        numberFiveBtn.setOnClickListener(this);
        Button numberSixBtn = findViewById(R.id.numberSixButton);
        numberSixBtn.setOnClickListener(this);
        Button additionBtn = findViewById(R.id.additionButton);
        additionBtn.setOnClickListener(this);
        Button numberOneBtn = findViewById(R.id.numberOneButton);
        numberOneBtn.setOnClickListener(this);
        Button numberTwoBtn = findViewById(R.id.numberTwoButton);
        numberTwoBtn.setOnClickListener(this);
        Button numberThreeBtn = findViewById(R.id.numberThreeButton);
        numberThreeBtn.setOnClickListener(this);
        Button subtractBtn = findViewById(R.id.subtractButton);
        subtractBtn.setOnClickListener(this);
        Button numberZeroBtn = findViewById(R.id.numberZeroButton);
        numberZeroBtn.setOnClickListener(this);
        Button dotBtn = findViewById(R.id.dotButton);
        dotBtn.setOnClickListener(this);
        Button equalsBtn = findViewById(R.id.equalsButton);
        equalsBtn.setOnClickListener(this);
    }
}