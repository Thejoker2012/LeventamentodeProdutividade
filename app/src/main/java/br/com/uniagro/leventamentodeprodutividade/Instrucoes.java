package br.com.uniagro.leventamentodeprodutividade;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Instrucoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instrucoes);

        //Comando utilizado para não ratacionar a tela
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Pegando referencia no XML
        Button btn = (Button) findViewById(R.id.iniciarAvaliacaoBtn);

        //Evento para o botão
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Instrucoes.this, Avaliacao.class);
                startActivity(i);
            }
        });

    }

}
