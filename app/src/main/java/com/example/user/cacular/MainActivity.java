package com.example.user.cacular;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import java.lang.*;



public class MainActivity extends ActionBarActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myfindViewById();
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
        if(signTV.getText().toString().equals("+")) {
            tmp += Float.parseFloat(oldTV.getText().toString());
        }else if(signTV.getText().toString().equals("-")) {
            tmp = Float.parseFloat(oldTV.getText().toString()) - tmp;
        }else if(signTV.getText().toString().equals("*")) {
            tmp =  Float.parseFloat(oldTV.getText().toString()) * tmp;
        }else if(signTV.getText().toString().equals("/")) {
            tmp =  Float.parseFloat(oldTV.getText().toString()) / tmp;
        }
        tmpS = String.valueOf(tmp);
        if (tmpS.indexOf(".0")==tmpS.length()-2){
            tmpS.substring(0,tmpS.length()-2);
        }
        return tmpS;
    }

    private void myfindViewById(){
        TV = (TextView) findViewById(R.id.textView);
        newTV = (TextView) findViewById(R.id.textView1);
        signTV = (TextView) findViewById(R.id.textView2);
        oldTV = (TextView) findViewById(R.id.textView3);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0= (Button) findViewById(R.id.button0);
        btn00 = (Button) findViewById(R.id.button00);
        btnAC = (Button) findViewById(R.id.buttonAC);
        btnC = (Button) findViewById(R.id.buttonC);
        btnBack = (Button) findViewById(R.id.buttonBack);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnSubtrct = (Button) findViewById(R.id.buttonSubtrct);
        btnPro = (Button) findViewById(R.id.buttonPro);
        btnDiv = (Button) findViewById(R.id.buttonDiv);
        btnDot = (Button) findViewById(R.id.buttonDot);
        btnEqu= (Button) findViewById(R.id.buttonEqu);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
     @Override
   public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case R.id.action_settings:
                TV.setText("");
                addMyfragment();
                break;
            case R.id.action_quit:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
    //*
   public void addMyfragment(){
       FragmentManager fragmentManager = getFragmentManager();
       FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       SettingFragment sf = new SettingFragment();
       fragmentTransaction.replace(R.id.container,sf);
       fragmentTransaction.commit();
   }/**/
}
