package com.alekseyb.test1_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalcButton(View view) {
        EditText resText = findViewById(R.id.Result);
        EditText op1 = findViewById(R.id.Operand1);
        EditText op2 = findViewById(R.id.Operand2);
        ToggleButton opr1 = findViewById(R.id.PlusButton);
        ToggleButton opr2 = findViewById(R.id.MinusButton);
        ToggleButton opr3 = findViewById(R.id.MultButton);
        ToggleButton opr4 = findViewById(R.id.DivideButton);
        String sOp1 = op1.getText().toString();
        String sOp2 = op2.getText().toString();
        Double dOp1, dOp2;

        if ( sOp1.isEmpty() || sOp2.isEmpty() )
            return;
        dOp1 = Double.parseDouble(sOp1);
        dOp2 = Double.parseDouble(sOp2);
        if (opr1.isChecked()) resText.setText(Double.toString(dOp1+dOp2));
        if (opr2.isChecked()) resText.setText(Double.toString(dOp1-dOp2));
        if (opr3.isChecked()) resText.setText(Double.toString(dOp1*dOp2));
        if (opr4.isChecked()) if (dOp2 != 0) resText.setText(Double.toString(dOp1/dOp2)); else resText.setText("Нельзя делить на ноль!");
    }

    public void onClickOperatorButton(View view) {
        // обработка нажатия клавиши действия
        ToggleButton currTgButton = (ToggleButton) view;
        ToggleButton tgButton1 = findViewById(R.id.PlusButton);
        ToggleButton tgButton2 = findViewById(R.id.MinusButton);
        ToggleButton tgButton3 = findViewById(R.id.MultButton);
        ToggleButton tgButton4 = findViewById(R.id.DivideButton);
        if (currTgButton.isChecked()) {
            tgButton1.setChecked(false);
            tgButton2.setChecked(false);
            tgButton3.setChecked(false);
            tgButton4.setChecked(false);
        }
        currTgButton.setChecked(true);
    }
}
