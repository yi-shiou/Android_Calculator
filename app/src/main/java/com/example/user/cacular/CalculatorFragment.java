package com.example.user.cacular;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by npes87184 on 2015/8/26.
 */
public class CalculatorFragment extends Fragment {



    private View v;
    private Button btn1 =null;
    private Button btn2 =null;
    private Button btn3 =null;
    private Button btn4 =null;
    private Button btn5 =null;
    private Button btn6 =null;
    private Button btn7 =null;
    private Button btn8 =null;
    private Button btn9 =null;
    private Button btn0 =null;
    private Button btn00 =null;
    private Button btnAC =null;
    private Button btnC =null;
    private Button btnBack =null;
    private Button btnPlus =null;
    private Button btnSubtrct =null;
    private Button btnPro =null;
    private Button btnDiv =null;
    private Button btnDot =null;
    private Button btnEqu =null;
    private TextView newTV = null;
    private TextView oldTV = null;
    private TextView signTV = null;
    private TextView TV = null;
    String tmpS;
    float tmp;
    //  boolean N = true; // is nature num
    boolean hasNewTV =false; // .

    public static CalculatorFragment newInstance(int index) {
        CalculatorFragment calculatorFragment = new CalculatorFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("home", index);
        calculatorFragment.setArguments(args);

        return calculatorFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        v = inflater.inflate(R.layout.activity_main, container, false);
        myfindViewById();
        return v;
    }

    private Button.OnClickListener bltisener = new Button.OnClickListener() {
        @Override
        public void onClick(View V) {
            switch (V.getId()){
                case R.id.buttonBack :
                    if(newTV.getText().toString().length()==1) {
                        newTV.setText("0");
                    }
                    else {
                        newTV.setText(newTV.getText().toString().substring(0, newTV.getText().toString().length()-1));
                    }
                    break;
                case R.id.buttonC:
                    newTV.setText("0");
                    break;
                case R.id.buttonAC:
                    newTV.setText("0");
                    oldTV.setText("0");
                    signTV.setText(null);
                    hasNewTV = false;
                    break;
                case R.id.buttonPlus:
                    if (hasNewTV){
                        oldTV.setText(count());
                        newTV.setText("0");
                        hasNewTV = false;
                    }
                    signTV.setText("+");
                    break;
                case R.id.buttonSubtrct:
                    if (hasNewTV){
                        oldTV.setText(count());
                        newTV.setText("0");
                        hasNewTV = false;
                    }
                    signTV.setText("-");
                    break;
                case R.id.buttonPro:
                    if (hasNewTV){
                        oldTV.setText(count());
                        newTV.setText("0");
                        hasNewTV = false;
                    }
                    signTV.setText("*");
                    break;
                case R.id.buttonDiv:
                    if (hasNewTV){
                        oldTV.setText(count());
                        newTV.setText("0");
                        hasNewTV = false;
                    }
                    signTV.setText("/");
                    break;
                case R.id.buttonEqu:
                    newTV.setText(count());
                    oldTV.setText("0");
                    signTV.setText("Ans");
                    hasNewTV = true;
                    break;
                case R.id.buttonDot:
                    if(!newTV.getText().toString().contains(".")){
                        newTV.setText(newTV.getText().toString() + ".");
                    }
                    break;
                case R.id.button00:
                    bltisener.onClick(btn0);
                    bltisener.onClick(btn0);
                    break;
                default:
                    if(signTV.getText().toString().equals("Ans")){
                        bltisener.onClick(btnAC); //AC
                    }
                    if (newTV.getText().toString().equals("0")){
                        newTV.setText(((Button)V).getText().toString());
                    }else {
                        newTV.setText(newTV.getText().toString() + ((Button)V).getText().toString());
                    }
                    hasNewTV = true;

            }

        }
    };

    private String count(){
        tmp = Float.parseFloat(newTV.getText().toString());
        if(!signTV.getText().toString().equals("")) {
            switch(signTV.getText().toString().toCharArray()[0]) {
                case '+':
                    tmp += Float.parseFloat(oldTV.getText().toString());
                    break;
                case '-':
                    tmp = Float.parseFloat(oldTV.getText().toString()) - tmp;
                    break;
                case '*':
                    tmp *=  Float.parseFloat(oldTV.getText().toString());
                    break;
                case '/':
                    tmp =  Float.parseFloat(oldTV.getText().toString()) / tmp;
                    break;
            }
        }
        tmpS = String.valueOf(tmp);
        if (tmpS.indexOf(".0")==tmpS.length()-2){
            tmpS.substring(0,tmpS.length()-2);
        }
        return tmpS;
    }

    private void myfindViewById(){
        TV = (TextView) v.findViewById(R.id.textView);
        newTV = (TextView) v.findViewById(R.id.textView1);
        signTV = (TextView) v.findViewById(R.id.textView2);
        oldTV = (TextView) v.findViewById(R.id.textView3);
        btn1 = (Button) v.findViewById(R.id.button1);
        btn2 = (Button) v.findViewById(R.id.button2);
        btn3 = (Button) v.findViewById(R.id.button3);
        btn4 = (Button) v.findViewById(R.id.button4);
        btn5 = (Button) v.findViewById(R.id.button5);
        btn6 = (Button) v.findViewById(R.id.button6);
        btn7 = (Button) v.findViewById(R.id.button7);
        btn8 = (Button) v.findViewById(R.id.button8);
        btn9 = (Button) v.findViewById(R.id.button9);
        btn0= (Button) v.findViewById(R.id.button0);
        btn00 = (Button) v.findViewById(R.id.button00);
        btnAC = (Button) v.findViewById(R.id.buttonAC);
        btnC = (Button) v.findViewById(R.id.buttonC);
        btnBack = (Button) v.findViewById(R.id.buttonBack);
        btnPlus = (Button) v.findViewById(R.id.buttonPlus);
        btnSubtrct = (Button) v.findViewById(R.id.buttonSubtrct);
        btnPro = (Button) v.findViewById(R.id.buttonPro);
        btnDiv = (Button) v.findViewById(R.id.buttonDiv);
        btnDot = (Button) v.findViewById(R.id.buttonDot);
        btnEqu= (Button) v.findViewById(R.id.buttonEqu);
        btn1.setOnClickListener(bltisener);
        btn2.setOnClickListener(bltisener);
        btn3.setOnClickListener(bltisener);
        btn4.setOnClickListener(bltisener);
        btn5.setOnClickListener(bltisener);
        btn6.setOnClickListener(bltisener);
        btn7.setOnClickListener(bltisener);
        btn8.setOnClickListener(bltisener);
        btn9.setOnClickListener(bltisener);
        btn0.setOnClickListener(bltisener);
        btn00.setOnClickListener(bltisener);
        btnAC.setOnClickListener(bltisener);
        btnC.setOnClickListener(bltisener);
        btnBack.setOnClickListener(bltisener);
        btnPlus.setOnClickListener(bltisener);
        btnSubtrct.setOnClickListener(bltisener);
        btnPro.setOnClickListener(bltisener);
        btnDiv.setOnClickListener(bltisener);
        btnDot.setOnClickListener(bltisener);
        btnEqu.setOnClickListener(bltisener);
    }

}
