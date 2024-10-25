package com.cassiomacielgomes.projeto08;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText edit_precoAlcool, edit_precoGasolina;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edit_precoAlcool = findViewById(R.id.edit_precoAlcool);
        edit_precoGasolina = findViewById(R.id.edit_precoGasolina);
        text_resultado = findViewById(R.id.text_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularPreco(View view) {
        String precoAlcool = edit_precoAlcool.getText().toString();
        String precoGasolina = edit_precoAlcool.getText().toString();
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool/valorGasolina;
            if(resultado>=0.7){
                text_resultado.setText("Melhor utilizar gasolina.");
            }else{
                text_resultado.setText("Melhor utilizar Álcool.");
            }

        }else {
            text_resultado.setText("Preencha os campos corretamente para obter seu resultado.");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        boolean camposValidados = true; // campos são verdadeiros
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }
        return camposValidados;
    }
}