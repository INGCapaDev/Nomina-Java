package com.example.nomina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class ReciboNominaActivity extends AppCompatActivity {
    private TextView lblNumRecibo;
    private TextView lblNombre;
    private EditText txtHorasNormal;
    private EditText txtHorasExtra;
    private RadioGroup rgPuesto;
    private RadioButton rdbPuesto1;
    private RadioButton rdbPuesto2;
    private RadioButton rdbPuesto3;
    private TextView lblSubtotal;
    private TextView lblImpuesto;
    private TextView lblTotal;
    private Button btnCalcular;
    private Button btnLimpiar;
    private Button btnRegresar;
    private ReciboNomina reciboNomina = new ReciboNomina(0, "Nombre", 0.0, 0.0, 1, 0.16);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibo_nomina);
        iniciarComponentes();
    }

    private void iniciarComponentes(){
        lblNumRecibo = findViewById(R.id.lblNumRecibo);
        lblNombre = findViewById(R.id.lblNombre);
        txtHorasNormal = findViewById(R.id.txtHorasNormal);
        txtHorasExtra = findViewById(R.id.txtHorasExtra);
        rdbPuesto1 = findViewById(R.id.rdbPuesto1);
        rdbPuesto2 = findViewById(R.id.rdbPuesto2);
        rdbPuesto3 = findViewById(R.id.rdbPuesto3);
        lblSubtotal = findViewById(R.id.lblSubtotal);
        lblImpuesto = findViewById(R.id.lblImpuesto);
        lblTotal = findViewById(R.id.lblTotal);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnRegresar = findViewById(R.id.btnRegresar);
        rgPuesto = findViewById(R.id.rgPuesto);

        int numeroRecibo = (int) (Math.floor(Math.random() * 10000) + 1);
        String strNombre = getIntent().getStringExtra("strNombre").toString();
        lblNombre.setText("Nombre: " + strNombre);
        lblNumRecibo.setText("Numero de Recibo: " + numeroRecibo);
        reciboNomina.setNumRecibo(numeroRecibo);
        reciboNomina.setNombre(strNombre);


    }
}