package com.isabellemoreira.project02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    public void abreYoutube (View acessar){
        //a variavel abreYoutube é a mesma colocada no meu onClick
        //o public void me faz criar um método (função) vazio, ele é público pra poder ser acessado durante o meu código e pode ser chamado novamente.
        //View = Classe acessar = Variável para ela ser vista
//chamando a URL Para ela enxergar o meu vídeo
        Uri link = Uri.parse("");
        //parse = como se fosse o método "toString" em javascript, mas no caso afirma que dentro do parenteses deve-se ter uma string
//link = minha variavel, pois está em letra minuscula
        //ainda não entendi como uma variavel deve ser criada em Java, entretanto ela não precisa necessariamente de uma classe para ser criada, e sim estar dentro de um método (funtion)
        //agora criamos a condição de que caso o botão seja clicado, ele será acessado
Intent compartilha = new Intent(Intent.ACTION_VIEW, link);
        //intent é como a classe que vai me permitir comparilhar esse dado no Android?
        //acredito que o action view seja como adicionar uma propriedade igual o parse, mas para a ação poder ser vista dentro do que precisa ser vista
        if(compartilha.resolveActivity(getPackageManager()) != null){
            //se a minha variavel de classe Intent, o activity é oq permite o Android interagir com a tela que eu quero, eu acho. Não achei pra que funciona o "resolve"
            //tb ainda n sei para que o getpackagemanager funciona
        }
            startActivity(compartilha);
    }
}
//site pra imagem: pixabay; google fonts;iconfinder
//Abrir youtube
