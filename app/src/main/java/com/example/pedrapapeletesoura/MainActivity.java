package com.example.pedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedra(View view){
        this.itemSelecionado("pedra");
    }

    public void papel(View view){
        this.itemSelecionado("papel");
    }

    public void tesoura(View view){
        this.itemSelecionado("tesoura");
    }

    public void itemSelecionado(String escolhaUsuario){
        ImageView imageResultado = (ImageView) findViewById(R.id.imagemResult);
        TextView result = (TextView) findViewById(R.id.textrsult);

        System.out.println(escolhaUsuario);

        String[] opcoes = {"pedra","papel","tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch ( escolhaApp ){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")

        ){
            result.setText("Você perdeu !");
        }
        else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){
            result.setText("Você Ganhou !");
        }
        else{
            result.setText("Empatamos!");
        }
    }
}
