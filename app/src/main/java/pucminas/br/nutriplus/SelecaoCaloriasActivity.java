package pucminas.br.nutriplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelecaoCaloriasActivity extends AppCompatActivity {

    private EditText caloriasTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_calorias);

        Button buttonProximo = findViewById(R.id.buttonProximo);
        caloriasTela = findViewById(R.id.edit_calorias);

        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaAlimentos = new Intent(SelecaoCaloriasActivity.this, SelecaoAlimentosActivity.class);
                telaAlimentos.putExtra("caloria", caloriasTela.getText().toString());
                startActivity(telaAlimentos);
            }
        });
    }
}