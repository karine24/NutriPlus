package pucminas.br.nutriplus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelecaoAlimentosActivity extends AppCompatActivity {

    private int totalAlimentos = 34;
    private SelecaoAlimentosAdapter selecaoAlimentosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listagem_alimentos);

        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Bife contra filé", 0D, 24.7, 16.9, 0D, 249.6));
        alimentos.add(new Alimento("Acém picado", 2D, 14.4, 3.4, 0D, 96.8));
        alimentos.add(new Alimento("Carne moida refogada",  3.9, 6.8, 3.9, 0D, 77D));
//        nomesAlimentos.add("Filé de peito de frango");
//        nomesAlimentos.add("Lombo porco");
//        nomesAlimentos.add("Linguiça (porco)");
//        nomesAlimentos.add("Hamburguer bovino");
//        nomesAlimentos.add("Ovo de galinha");
//        nomesAlimentos.add("Feijão carioca cozido");
//        nomesAlimentos.add("Feijão preto cozido");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_Checkbox);

        selecaoAlimentosAdapter = new SelecaoAlimentosAdapter(new OnClickListener<Alimento>() {
            @Override
            public void onClick(Alimento T) {

            }
        });
        recyclerView.setAdapter(selecaoAlimentosAdapter);
        selecaoAlimentosAdapter.setList(alimentos);
    }
}
