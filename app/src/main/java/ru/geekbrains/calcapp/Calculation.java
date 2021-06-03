package ru.geekbrains.calcapp;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.TextView;

public class Calculation {

    private double firstNumber;
    private double secondNumber;
    private int actionButton;
    private TextView textView;

    private State state;

    private enum State {
        firstInput,
        secondInput,
        operationInput,
        result
    }

    StringBuilder inputElement = new StringBuilder();

    public Calculation() {
        state = State.firstInput;
    }

    @SuppressLint("NonConstantResourceId")
    public void buttonPressed(int id) {

        if (state == State.operationInput) {
            state = State.secondInput;
            inputElement.setLength(0);
        }

        if (state == State.result) {
            state = State.firstInput;
            inputElement.setLength(0);
        }

        if (inputElement.length() < 12) {
            switch (id) {
                case R.id.numberZeroButton:
                    if (inputElement.length() != 0) {
                        inputElement.append("0");
                    }
                    break;
                case R.id.numberOneButton:
                    inputElement.append("1");
                    break;
                case R.id.numberTwoButton:
                    inputElement.append("2");
                    break;
                case R.id.numberThreeButton:
                    inputElement.append("3");
                    break;
                case R.id.numberFourButton:
                    inputElement.append("4");
                    break;
                case R.id.numberFiveButton:
                    inputElement.append("5");
                    break;
                case R.id.numberSixButton:
                    inputElement.append("6");
                    break;
                case R.id.numberSevenButton:
                    inputElement.append("7");
                    break;
                case R.id.numberEightButton:
                    inputElement.append("8");
                    break;
                case R.id.numberNineButton:
                    inputElement.append("9");
                    break;
                case R.id.dotButton:
                    if (inputElement.length() > 0) {
                        inputElement.append(".");
                    } else {
                        inputElement.append("0.");
                    }
                    break;
            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void operationButtonPressed(int id) {
        if (R.id.equalsButton == id && state == State.secondInput && inputElement.length() > 0) {
            secondNumber = Double.parseDouble(inputElement.toString());
            state = State.result;
            inputElement.setLength(0);
            switch (actionButton) {
                case R.id.additionButton:
                    inputElement.append(firstNumber + secondNumber);
                    break;
                case R.id.subtractButton:
                    inputElement.append(firstNumber - secondNumber);
                    break;
                case R.id.multiplyButton:
                    inputElement.append(firstNumber * secondNumber);
                    break;
                case R.id.divideButton:
                    inputElement.append(firstNumber / secondNumber);
                    break;
            }
        } else if (inputElement.length() > 0 && state == State.firstInput && id != R.id.equalsButton) {
            firstNumber = Double.parseDouble(inputElement.toString());
            state = State.operationInput;
            actionButton = id;
        }
    }

    public void allClearPressed(TextView textView) {
        inputElement.delete(0, 12);
        textView.setText("");
    }

    public String getText() {
        return inputElement.toString();
    }
}
