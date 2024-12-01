package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    float buffer = 0;
    boolean newNum = true;
    char operation = ' ';
    String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result = findViewById(R.id.textviewResult);
        result.setText("0");
    }

    // Number button handler
    public void funcNumber(View view) {
        Button button = (Button) view;
        if (newNum) {
            currentInput = button.getText().toString();
            result.setText(currentInput);
            newNum = false;
        } else {
            currentInput += button.getText().toString();
            result.setText(currentInput);
        }
    }

    // Operator button handler (like +, -, *, /)
    public void funcAction(View view) {
        Button button = (Button) view;
        char currentOp = button.getText().charAt(0);

        if (!currentInput.isEmpty()) {
            if (operation == ' ') // If first operation
                buffer = Float.parseFloat(currentInput);
            else {
                evaluateOperation(); // Calculate the previous operation before doing the new one
            }
        }
        operation = currentOp;
        currentInput = "";  // Reset current input
        newNum = true;
    }

    // Calculate the current operation and update the result
    private void evaluateOperation() {
        float inputNum = Float.parseFloat(currentInput);
        switch (operation) {
            case '+':
                buffer += inputNum;
                break;
            case '-':
                buffer -= inputNum;
                break;
            case '*':
                buffer *= inputNum;
                break;
            case '/':
                if (inputNum != 0)
                    buffer /= inputNum;
                else {
                    result.setText("Error");
                    return;
                }
                break;
        }
        result.setText(String.valueOf(buffer));
    }

    // Equals button handler
    public void clickEquals(View view) {
        if (!currentInput.isEmpty()) {
            evaluateOperation();
            operation = ' ';
            currentInput = "";
            newNum = true;
        }
    }

    // Clear button handler
    public void clickAllClear(View view) {
        buffer = 0;
        newNum = true;
        currentInput = "";
        operation = ' ';
        result.setText("0");
    }

    // Delete button handler
    public void clickDelete(View view) {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            result.setText(currentInput.isEmpty() ? "0" : currentInput);
        }
    }

    // Negate button handler
    public void clickNegate(View view) {
        if (!currentInput.isEmpty()) {
            if (currentInput.charAt(0) == '-') {
                currentInput = currentInput.substring(1);
            } else {
                currentInput = "-" + currentInput;
            }
            result.setText(currentInput);
        }
    }

    // Percent button handler
    public void clickPercent(View view) {
        if (!currentInput.isEmpty()) {
            float num = Float.parseFloat(currentInput);
            num /= 100;
            currentInput = String.valueOf(num);
            result.setText(currentInput);
        }
    }

    // Decimal (dot) button handler
    public void clickDot(View view) {
        if (!currentInput.contains(".") && !currentInput.isEmpty()) {
            currentInput += ".";
            result.setText(currentInput);
        }
    }

    // Add button handler
    public void clickAdd(View view) {
        funcAction(view);
    }

    // Subtract button handler
    public void clickSubtract(View view) {
        funcAction(view);
    }

    // Multiply button handler
    public void clickMultiply(View view) {
        funcAction(view);
    }

    // Divide button handler
    public void clickDivide(View view) {
        funcAction(view);
    }

    // Number button handlers (1 to 9, 0)
    public void clickOne(View view) {
        funcNumber(view);
    }

    public void clickTwo(View view) {
        funcNumber(view);
    }

    public void clickThree(View view) {
        funcNumber(view);
    }

    public void clickFour(View view) {
        funcNumber(view);
    }

    public void clickFive(View view) {
        funcNumber(view);
    }

    public void clickSix(View view) {
        funcNumber(view);
    }

    public void clickSeven(View view) {
        funcNumber(view);
    }

    public void clickEight(View view) {
        funcNumber(view);
    }

    public void clickNine(View view) {
        funcNumber(view);
    }

    public void clickZero(View view) {
        funcNumber(view);
    }
}
