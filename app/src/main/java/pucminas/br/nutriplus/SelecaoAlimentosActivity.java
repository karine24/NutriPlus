package pucminas.br.nutriplus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelecaoAlimentosActivity extends AppCompatActivity {

    private SelecaoAlimentosAdapter selecaoAlimentosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listagem_alimentos);
        Button entrarButton = findViewById(R.id.btn_proximo);

        double energiaMaxima = getIntent().getDoubleExtra("caloria", 2000.0);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_ingredientes);

        selecaoAlimentosAdapter = new SelecaoAlimentosAdapter();
        recyclerView.setAdapter(selecaoAlimentosAdapter);
        selecaoAlimentosAdapter.setList(IngredientesUtil.pegueMeusIngredientes());

        entrarButton.setOnClickListener(view -> {
            Intent intent = new Intent(SelecaoAlimentosActivity.this, ResultadoSolverActivity.class);
            intent.putExtra("energiaMaxima", energiaMaxima);
            intent.putExtra("alimentosEscolhidos", (ArrayList) selecaoAlimentosAdapter.getSelectedAliments());
            startActivity(intent);
        });
    }
}
