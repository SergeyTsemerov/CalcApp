package ru.geekbrains.calcapp.domain;

import android.widget.TextView;

import ru.geekbrains.calcapp.R;

public class Calculation {

    private double firstNumber;
    private double secondNumber;
    private int actionButton;

    private State state;

    StringBuilder inputElement = new StringBuilder();

    public Calculation() {
        state = State.firstInput;
    }

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

            if (id == R.id.dotButton) {
                if (inputElement.length() > 0) {
                    inputElement.append(".");
                } else {
                    inputElement.append("0.");
                }
            }
        }
    }

    public void operationButtonPressed(int id) {
        if (R.id.equalsButton == id && state == State.secondInput && inputElement.length() > 0) {
            secondNumber = Double.parseDouble(inputElement.toString());
            state = State.result;
            inputElement.setLength(0);
            if (actionButton == R.id.additionButton)
                inputElement.append(firstNumber + secondNumber);

            if (actionButton == R.id.subtractButton)
                inputElement.append(firstNumber - secondNumber);

            if (actionButton == R.id.multiplyButton)
                inputElement.append(firstNumber * secondNumber);

            if (actionButton == R.id.divideButton)
                inputElement.append(firstNumber / secondNumber);

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
