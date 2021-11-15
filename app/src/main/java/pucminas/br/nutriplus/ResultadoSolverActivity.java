package pucminas.br.nutriplus;

import static android.os.AsyncTask.execute;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.ojalgo.OjAlgoUtils;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResultadoSolverActivity extends AppCompatActivity implements OptimisationResult {
    // Create a new model.
    ExpressionsBasedModel model = new ExpressionsBasedModel();
    TextView resultadoSolverTexto;
    String resultadoTexto = "";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_solver);

        resultadoSolverTexto = findViewById(R.id.resultadoSolverTexto);
        progressBar = findViewById(R.id.progressBar);

        ExecutorService executorService = Executors.newFixedThreadPool(8);

        double energiaMaxima = getIntent().getDoubleExtra("energiaMaxima", 2000.0);
        List<Alimento> alimentos = (ArrayList<Alimento>)getIntent().getSerializableExtra("alimentosEscolhidos");

        BasicLogger.debug();
        BasicLogger.debug(ResultadoSolverActivity.class);
        BasicLogger.debug(OjAlgoUtils.getTitle());
        BasicLogger.debug(OjAlgoUtils.getDate());
        BasicLogger.debug();

        Expression proteina = model.addExpression("Proteina").lower(60.0);
        Expression carboidrato = model.addExpression("Carboidrato").lower(310.0);
        Expression lipidios = model.addExpression("Lipidios").lower(60.0);
        Expression fibraAlimentar = model.addExpression("Fibra alimentar").lower(25.0);
        Expression calorias = model.addExpression("Calorias").upper(energiaMaxima);


        for(Alimento alimento : alimentos) {
            Variable variable = model.addVariable(alimento.getNome()).lower(0).upper(3);
            proteina.set(variable, alimento.getProteina());
            carboidrato.set(variable, alimento.getCaboidrato());
            lipidios.set(variable, alimento.getLipidios());
            fibraAlimentar.set(variable, alimento.getFibraAlimentar());
            calorias.set(variable, alimento.getEnergia());
            variable.integer(true);
        }

        OptimisationResult optimisationResult = this;

        // Solve the problem - maximise the cost
        ((App)getApplication()).threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Optimisation.Result result = model.maximise();
                optimisationResult.onReceiveResult(result);
            }
        });
    }

    @Override
    public void onReceiveResult(Optimisation.Result result) {
        // Print the result, and the model
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                BasicLogger.debug();
                BasicLogger.debug(result);
                BasicLogger.debug();
                BasicLogger.debug(model);
                BasicLogger.debug();

                if(result.getState().isSuccess()) {
                    resultadoTexto += "Alimentos/Quantidade escolhidos para sua dieta:\n\n\n";
                    model.variables().filter(variable -> variable.getValue().compareTo(BigDecimal.ZERO) > 0).forEach(variable -> {
                        resultadoTexto += variable.getName() + " " + variable.getValue() + "\n\n";
                    });
                    resultadoSolverTexto.setText(resultadoTexto);
                } else {
                    resultadoSolverTexto.setText("Não foi possível encontrar um resultado ótimo.");
                }
            }
        });

    }
}

interface OptimisationResult {
    void onReceiveResult(Optimisation.Result result);
}