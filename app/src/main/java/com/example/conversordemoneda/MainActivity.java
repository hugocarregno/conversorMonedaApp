package com.example.conversordemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText dolar;
    private EditText euro;
    private RadioButton aDolar;
    private RadioButton aEuro;
    private EditText convertido;
    private Button convertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dolar = findViewById(R.id.etDollars);
        euro = findViewById(R.id.etEuros);
        aDolar = findViewById(R.id.rbDollar);
        aEuro = findViewById(R.id.rbEuro);
        convertido = findViewById(R.id.etConvertido);
        convertir = findViewById(R.id.btConvert);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!dolar.getText().toString().isEmpty() && aEuro.isChecked()){
                    double dolares = Double.parseDouble(dolar.getText().toString());
                    double resultado = 0.91 * dolares;
                    convertido.setText(resultado+"€");
                }else if(!euro.getText().toString().isEmpty() && aDolar.isChecked()){
                    double euros = Double.parseDouble(euro.getText().toString());
                    double resultado =  euros * 1.10;
                    convertido.setText(resultado+"$");
                }else{
                    Toast.makeText(getApplicationContext(),"Para convertir ingrese monto y conversion correspondiente",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
