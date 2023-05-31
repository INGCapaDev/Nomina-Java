package com.example.nominajava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class MainActivity extends AppCompatActivity {
    private Button btnEntrar;
    private Button btnSalir;
    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrar();
            }
        });
    }

    private void iniciarComponentes(){
        btnEntrar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
        txtNombre = findViewById(R.id.txtNombre);
    }
    private void ingresar() {
        if (txtNombre.getText().toString().isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Nombre Requerido", Toast.LENGTH_SHORT).show();
            return;
        }
        String strNombre = txtNombre.getText().toString();
        Intent intent = new Intent(MainActivity.this, ReciboNominaActivity.class);
        intent.putExtra("strNombre", strNombre);
        startActivity(intent);
    }

    private void cerrar() {
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("Nomina");
        confirmar.setMessage("¿ Desea Salir ?");
        confirmar.setPositiveButton("Confirmar", (dialog, which) -> finish());
        confirmar.setNegativeButton("Cancelar", (dialog, which) -> {}).show();
    }
}
