package pucminas.br.nutriplus;

import java.util.ArrayList;

public class IngredientesUtil {

    public static ArrayList<Alimento> pegueMeusIngredientes() {
        ArrayList<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento("Bife contra filé", 0D, 24.7, 16.9, 0D, 249.6));
        alimentos.add(new Alimento("Acém picado", 2D, 14.4, 3.4, 0D, 96.8));
        alimentos.add(new Alimento("Carne moida refogada", 3.9, 6.8, 3.9, 0D, 77D));
//        nomesAlimentos.add("Filé de peito de frango");
//        nomesAlimentos.add("Lombo porco");
//        nomesAlimentos.add("Linguiça (porco)");
//        nomesAlimentos.add("Hamburguer bovino");
//        nomesAlimentos.add("Ovo de galinha");
//        nomesAlimentos.add("Feijão carioca cozido");
//        nomesAlimentos.add("Feijão preto cozido");
        return alimentos;
    }

}
