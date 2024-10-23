package com.isabellemoreira.projeto04;

import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity<integer> extends AppCompatActivity {
//cria uma variavel que nn pode ser modificada (const)
    private static final int NUMERO_MAXIMO = 60;
    private static final int QUANTIDADE_SORTEADA = 6;

    //boas praticas pra criar constante é colocar em letra maiuscula
    //final = const
    //ela pertence diretamente a esse método e ao main activitiy

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
    }
    public void sortearNumero(View view){
        //ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Integer> numeros = new ArrayList<>();

                //integer = numeros inteiros]
        //Integer = Wrapper
        //Adicionando numeros de 1 a 60
        for (int i = 1; i <= NUMERO_MAXIMO; i++){ //i++ i = 1+1
            numeros.add(i);
        }
        //Embaralhando os numeros
        Collections.shuffle(numeros);

        StringBuilder resultado = new StringBuilder("Números sorteados: \n");
        //pegar os números do Array
        for(int i = 0; i <QUANTIDADE_SORTEADA; i++){
            resultado.append(numeros.get(i)).append(" ");
        }
        //exibir resultado
        TextView resultadosTextView = findViewById(R.id.resultadoSorteio);
        resultadosTextView.setText(resultado.toString());
    }
}
 