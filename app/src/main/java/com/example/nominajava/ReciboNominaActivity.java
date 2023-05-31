package com.example.nominajava;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


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
        btnCalcular.setOnClickListener(v -> calcular());
        btnLimpiar.setOnClickListener(v -> limpiar());
        btnRegresar.setOnClickListener(v -> regresar());
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



    @SuppressLint("NonConstantResourceId")
    private void calcular() {
        int puesto = rgPuesto.getCheckedRadioButtonId();
        if (txtHorasExtra.getText().toString().isEmpty() || txtHorasNormal.getText().toString().isEmpty() || puesto == -1) {
            Toast.makeText(getApplicationContext(), "Datos Requeridos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (puesto == R.id.rdbPuesto1) {
            reciboNomina.setPuesto(1);
        } else if (puesto == R.id.rdbPuesto2) {
            reciboNomina.setPuesto(2);
        } else if (puesto == R.id.rdbPuesto3) {
            reciboNomina.setPuesto(3);
        }

        reciboNomina.setHorasTrabExtras(Double.parseDouble(txtHorasExtra.getText().toString()));
        reciboNomina.setHorasTrabNormal(Double.parseDouble(txtHorasNormal.getText().toString()));

        String subtotal = String.format("%.3f", reciboNomina.calcularSubtotal());
        String impuesto = String.format("%.3f", reciboNomina.calcularImpuesto());
        String total = String.format("%.3f", reciboNomina.calcularTotal());
        lblSubtotal.setText("Subtotal: " + subtotal + " MXN");
        lblImpuesto.setText("Impuesto: " + impuesto + " MXN");
        lblTotal.setText("Total a pagar: " + total + " MXN");
    }

    private void limpiar() {
        rgPuesto.clearCheck();
        txtHorasExtra.getText().clear();
        txtHorasNormal.getText().clear();
        lblSubtotal.setText("Subtotal");
        lblImpuesto.setText("Impuesto");
        lblTotal.setText("Total a Pagar");
        txtHorasNormal.requestFocus();
    }

    private void regresar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Nomina");
        confirmar.setMessage("¿Desea Regresar?");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // No hacer nada
            }
        });
        confirmar.show();
    }
}