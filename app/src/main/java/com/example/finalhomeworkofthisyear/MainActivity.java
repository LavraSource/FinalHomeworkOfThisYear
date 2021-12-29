package com.example.finalhomeworkofthisyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c, d;
    TextView maint, sect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        maint = findViewById(R.id.maint);
        sect = findViewById(R.id.sect);
    }

    public void solve(View view) {
        int numa= Integer.parseInt(a.getText().toString());
        int numb= Integer.parseInt(b.getText().toString());
        int numc= Integer.parseInt(c.getText().toString());
        int numd= Integer.parseInt(d.getText().toString());
        myThread t= new myThread(numb,numc,numd);
        t.start();
        double discriminant = numb*numb - 4*numa*numc;
        double x1 = (-numb+Math.sqrt(discriminant))/2*numa;
        double x2 = (-numb-Math.sqrt(discriminant))/2*numa;
        String result;
        if(discriminant==0){
            result = Double.toString((-numb) / 2 * numa);
        }
        if(discriminant>0){
            result = Double.toString(x1)+", "+Double.toString(x2);
        } else {
            result="None";
        }
        maint.setText("Основной поток: " +result);

    }
    class myThread extends Thread{
        int a1, b2, c3;
        public myThread(int a,int b,int c){
            this.a1 =a;
            this.b2 =b;
            this.c3 =c;
        }
        @Override
        public void run() {
            super.run();
            double discriminant = b2 * b2 - 4* a1 * c3;
            double x1 = (-b2 +Math.sqrt(discriminant))/2* a1;
            double x2 = (-b2 -Math.sqrt(discriminant))/2* a1;
            String result;
            if(discriminant==0){
                result = Double.toString((-b2) / 2 * a1);
            }
            if(discriminant>0){
                result = Double.toString(x1)+", "+Double.toString(x2);
            } else {
                result="None";
            }
            sect.setText("Дополнительный поток: " +result);
        }
    }
}