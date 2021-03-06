package pucminas.br.nutriplus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelecaoCaloriasActivity extends AppCompatActivity {

    private EditText caloriasTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_calorias);

        Button buttonProximo = findViewById(R.id.buttonProximo);
        caloriasTela = findViewById(R.id.edit_calorias);

        buttonProximo.setOnClickListener(view -> verifiqueAndProssiga());
    }

    private void verifiqueAndProssiga() {
        if (!caloriasTela.getText().toString().equals("")) {
            Intent telaAlimentos = new Intent(SelecaoCaloriasActivity.this, SelecaoAlimentosActivity.class);
            telaAlimentos.putExtra("caloria", Double.parseDouble(caloriasTela.getText().toString()));
            startActivity(telaAlimentos);
        } else {
            Toast.makeText(
                    SelecaoCaloriasActivity.this,
                    "Por favor! Digite um valor",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}