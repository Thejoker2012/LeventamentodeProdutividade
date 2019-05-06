package br.com.uniagro.leventamentodeprodutividade;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Avaliacao extends AppCompatActivity {

    //private String[] fazendaNomes = new String[]{"Bayer (Delta Pine)","Bayer (Cachoeira Dourada)","Bayer (Planta)"};
    private String[] talhaoNomes = new String[]{"Campo 1","Campo 2","Campo 3","Campo 4","Campo 5","Campo 6","Campo 7","Campo 8","Campo 9","Campo 10","Campo 11","Campo 12","Campo 13","Campo 14","Campo 15","Campo 16"};
    private String[] variedadeNomes = new String[]{"DP 1552","DP 1536","DP 1228","DP 1540","DP 1742"};
    private String[] espacamento = new String[]{"0.90","1","50"};

    private int[] imgFazendas;
    private int[] imgTalhao;
    private int[] imgVariedades;

    private Spinner sp;

    //Irá Adicionar uma imagens ao item selecionado ca combo box;
    //private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avaliacao);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        Date data = new Date();
        String dataFormatada = dateFormat.format(data);

        TextView Data = findViewById(R.id.EdtData);
        Data.setText(dataFormatada);

        //Comando utilizado para não ratacionar a tela
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ArrayAdapter<CharSequence> adapter;
        ArrayAdapter<CharSequence> adapter1;
        ArrayAdapter<CharSequence> adapter2;
        ArrayAdapter<CharSequence> adapter3;
        ArrayAdapter<CharSequence> adapter4;

        adapter4 = ArrayAdapter.createFromResource(this,R.array.Empresas, R.layout.support_simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        adapter = ArrayAdapter.createFromResource(this,R.array.Fazendas, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        adapter1 = ArrayAdapter.createFromResource(this,R.array.Talhoes, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        adapter2 = ArrayAdapter.createFromResource(this,R.array.Variedades, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        adapter3 = ArrayAdapter.createFromResource(this,R.array.Espacamento, R.layout.support_simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //iv = (ImageView) findViewById();

        sp = (Spinner) findViewById(R.id.EmpresaSpinner);
        sp.setAdapter(adapter4);

        sp = (Spinner) findViewById(R.id.FazendaSpinner);
        sp.setAdapter(adapter);

        sp = (Spinner) findViewById(R.id.TalhaoSpinner);
        sp.setAdapter(adapter1);

        sp = (Spinner) findViewById(R.id.VariedadeSpinner);
        sp.setAdapter(adapter2);

        sp = (Spinner) findViewById(R.id.EspacamentoSpinner);
        sp.setAdapter(adapter3);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //iv.setImageResource(imgFazenda[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void showElementos(View view){

        String nome = (String) sp.getSelectedItem() ;
        long id = sp.getSelectedItemId();
        int posicao = sp.getSelectedItemPosition();

        Toast.makeText(this," Fazenda: "+nome+" Id: "+id+" Posição: "+posicao,Toast.LENGTH_LONG).show();
    }
}
