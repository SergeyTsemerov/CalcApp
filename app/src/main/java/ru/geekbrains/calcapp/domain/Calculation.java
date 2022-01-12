package ru.geekbrains.calcapp.domain;

import android.widget.TextView;

import java.text.DecimalFormat;

import ru.geekbrains.calcapp.R;

public class Calculation {

    private static final String DECIMAL_FORMAT = "0.0000";
    private static final int INPUT_LENGTH_ZERO = 0;
    private static final int MAX_INPUT_LENGTH = 12;
    private static final String NUMBER_ZERO = "0";
    private static final String NUMBER_ONE = "1";
    private static final String NUMBER_TWO = "2";
    private static final String NUMBER_THREE = "3";
    private static final String NUMBER_FOUR = "4";
    private static final String NUMBER_FIVE = "5";
    private static final String NUMBER_SIX = "6";
    private static final String NUMBER_SEVEN = "7";
    private static final String NUMBER_EIGHT = "8";
    private static final String NUMBER_NINE = "9";
    private static final String DOT = ".";
    private static final String ZERO_WITH_DOT = "0.";
    private static final String EMPTY_STRING = "";


    private double firstNumber;
    private double secondNumber;
    private int actionButton;
    boolean allowDots = true;
    private static final DecimalFormat decimalFormat = new DecimalFormat(DECIMAL_FORMAT);

    private AppState appState;

    StringBuilder inputElement = new StringBuilder();

    public Calculation() {
        appState = AppState.firstInput;
    }

    public void buttonPressed(int id) {

        if (appState == AppState.operationInput) {
            appState = AppState.secondInput;
            inputElement.setLength(INPUT_LENGTH_ZERO);
        }

        if (appState == AppState.result) {
            appState = AppState.firstInput;
            inputElement.setLength(INPUT_LENGTH_ZERO);
        }

        if (inputElement.length() < MAX_INPUT_LENGTH) {
            if (id == R.id.numberZeroButton) {
                if (inputElement.length() != INPUT_LENGTH_ZERO) {
                    inputElement.append(NUMBER_ZERO);
                }
            }
            if (id == R.id.numberOneButton)
                inputElement.append(NUMBER_ONE);

            if (id == R.id.numberTwoButton)
                inputElement.append(NUMBER_TWO);

            if (id == R.id.numberThreeButton)
                inputElement.append(NUMBER_THREE);

            if (id == R.id.numberFourButton)
                inputElement.append(NUMBER_FOUR);

            if (id == R.id.numberFiveButton)
                inputElement.append(NUMBER_FIVE);

            if (id == R.id.numberSixButton)
                inputElement.append(NUMBER_SIX);

            if (id == R.id.numberSevenButton)
                inputElement.append(NUMBER_SEVEN);

            if (id == R.id.numberEightButton)
                inputElement.append(NUMBER_EIGHT);

            if (id == R.id.numberNineButton)
                inputElement.append(NUMBER_NINE);

            if (id == R.id.dotButton && allowDots) {
                if (inputElement.length() > INPUT_LENGTH_ZERO && appState == AppState.firstInput) {
                    inputElement.append(DOT);
                } else if (inputElement.length() > 0 && appState == AppState.secondInput) {
                    inputElement.append(DOT);
                } else {
                    inputElement.append(ZERO_WITH_DOT);
                }
                allowDots = false;
            }
        }
    }

    public void operationButtonPressed(int id) {
        if (R.id.equalsButton == id && appState == AppState.secondInput && inputElement.length() > 0) {
            secondNumber = Double.parseDouble(inputElement.toString());
            appState = AppState.result;
            inputElement.setLength(INPUT_LENGTH_ZERO);

            if (actionButton == R.id.additionButton) {
                allowDots = true;
                inputElement.append(decimalFormat.format(firstNumber + secondNumber));
            }

            if (actionButton == R.id.subtractButton) {
                allowDots = true;
                inputElement.append(decimalFormat.format(firstNumber - secondNumber));
            }

            if (actionButton == R.id.multiplyButton) {
                allowDots = true;
                inputElement.append(decimalFormat.format(firstNumber * secondNumber));
            }

            if (actionButton == R.id.divideButton) {
                allowDots = true;
                inputElement.append(decimalFormat.format(firstNumber / secondNumber));
            }

        } else if (inputElement.length() > INPUT_LENGTH_ZERO && appState == AppState.firstInput && id != R.id.equalsButton) {
            allowDots = true;
            firstNumber = Double.parseDouble(inputElement.toString());
            appState = AppState.operationInput;
            actionButton = id;
        }
    }

    public void allClearPressed(TextView textView) {
        inputElement.delete(INPUT_LENGTH_ZERO, MAX_INPUT_LENGTH);
        textView.setText(EMPTY_STRING);
        allowDots = true;
    }

    public String getText() {
        return inputElement.toString();
    }
}
