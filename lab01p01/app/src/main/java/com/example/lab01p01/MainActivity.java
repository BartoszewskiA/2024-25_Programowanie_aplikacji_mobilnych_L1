package com.example.lab01p01;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText01, editText02, editText03;
    TextView textView_wynik;

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
        editText01 = findViewById(R.id.editText01);
        editText02 = findViewById(R.id.editText02);
        editText03 = findViewById(R.id.editText03);
        textView_wynik = findViewById(R.id.textView_wynik);
    }

    public void licz(View view) {
//        double a = Double.parseDouble(editText01.getText().toString());
//        double b = Double.parseDouble(editText02.getText().toString());
//        double c = Double.parseDouble(editText03.getText().toString());
        double a=0,b=0,c=0;
        try {
            a = Double.parseDouble(editText01.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Nalezy wypełnic pole \"a\"", Toast.LENGTH_SHORT).show();
            editText01.setHint("Wpisza liczbę");
            return;
        }
        try {
            b = Double.parseDouble(editText02.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Nalezy wypełnic pole \"b\"", Toast.LENGTH_SHORT).show();
            editText02.setHint("Wpisza liczbę");
            return;
        }
        try {
            c = Double.parseDouble(editText03.getText().toString());
        } catch (Exception e)
        {
            Toast.makeText(this, "Nalezy wypełnic pole \"c\"", Toast.LENGTH_SHORT).show();
            editText03.setHint("Wpisza liczbę");
            return;
        }


        double delta = b * b - 4 * a * c;
        textView_wynik.setText("Delta="+delta);

        if(delta>0)
        {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x1 = Math.round(x1 * 1000.0) / 1000.0;
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = Math.round(x2 * 1000.0) / 1000.0;
            textView_wynik.setText(textView_wynik.getText().toString()+"\nx1="+x1+"\nx2="+x2);
            return;
        }
        if(delta==0) {
            double x0 = -b / (2 * a);
            x0 = Math.round(x0 * 1000.0) / 1000.0;
            textView_wynik.setText(textView_wynik.getText().toString()+"\nx0="+x0);
            return;
        }
        textView_wynik.setText(textView_wynik.getText().toString()+"\nBrak rozwiązań");
    }

    public void kasuj(View view) {
        editText01.setText("");
        editText02.setText("");
        editText03.setText("");
        textView_wynik.setText("");
    }
}