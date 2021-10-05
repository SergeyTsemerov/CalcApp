package ru.geekbrains.calcapp.domain;

import android.widget.TextView;

import ru.geekbrains.calcapp.R;

public class Calculation {

    private double firstNumber;
    private double secondNumber;
    private int actionButton;
    boolean allowDots = true;

    private AppState appState;

    StringBuilder inputElement = new StringBuilder();

    public Calculation() {
        appState = AppState.firstInput;
    }

    public void buttonPressed(int id) {

        if (appState == AppState.operationInput) {
            appState = AppState.secondInput;
            inputElement.setLength(0);
        }

        if (appState == AppState.result) {
            appState = AppState.firstInput;
            inputElement.setLength(0);
        }

        if (inputElement.length() < 12) {
            if (id == R.id.numberZeroButton) {
                if (inputElement.length() != 0) {
                    inputElement.append("0");
                }
            }
            if (id == R.id.numberOneButton)
                inputElement.append("1");

            if (id == R.id.numberTwoButton)
                inputElement.append("2");

            if (id == R.id.numberThreeButton)
                inputElement.append("3");

            if (id == R.id.numberFourButton)
                inputElement.append("4");

            if (id == R.id.numberFiveButton)
                inputElement.append("5");

            if (id == R.id.numberSixButton)
                inputElement.append("6");

            if (id == R.id.numberSevenButton)
                inputElement.append("7");

            if (id == R.id.numberEightButton)
                inputElement.append("8");

            if (id == R.id.numberNineButton)
                inputElement.append("9");

            if (id == R.id.dotButton && allowDots) {
                if (inputElement.length() > 0 && appState == AppState.firstInput) {
                    inputElement.append(".");
                } else if (inputElement.length() > 0 && appState == AppState.secondInput) {
                    inputElement.append(".");
                } else {
                    inputElement.append("0.");
                }
                allowDots = false;
            }
        }
    }

    public void operationButtonPressed(int id) {
        if (R.id.equalsButton == id && appState == AppState.secondInput && inputElement.length() > 0) {
            secondNumber = Double.parseDouble(inputElement.toString());
            appState = AppState.result;
            inputElement.setLength(0);

            if (actionButton == R.id.additionButton) {
                allowDots = true;
                inputElement.append(firstNumber + secondNumber);
            }

            if (actionButton == R.id.subtractButton) {
                allowDots = true;
                inputElement.append(firstNumber - secondNumber);
            }

            if (actionButton == R.id.multiplyButton) {
                allowDots = true;
                inputElement.append(firstNumber * secondNumber);
            }

            if (actionButton == R.id.divideButton) {
                allowDots = true;
                inputElement.append(firstNumber / secondNumber);
            }

        } else if (inputElement.length() > 0 && appState == AppState.firstInput && id != R.id.equalsButton) {
            allowDots = true;
            firstNumber = Double.parseDouble(inputElement.toString());
            appState = AppState.operationInput;
            actionButton = id;
        }
    }

    public void allClearPressed(TextView textView) {
        inputElement.delete(0, 12);
        textView.setText("");
        allowDots = true;
    }

    public String getText() {
        return inputElement.toString();
    }
}
