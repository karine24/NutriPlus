package pucminas.br.nutriplus;

public class Alimento {
    private String nome;
    private boolean selecionado;
    private double carboidratos;
    private double proteinas;
    private double lipideos;
    private double fibraAlimentar;
    private double energia;

    public Alimento(String nome,
                    double carboidratos,
                    double proteinas,
                    double lipideos,
                    double fibraAlimentar,
                    double energia) {
        this.nome = nome;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.lipideos = lipideos;
        this.fibraAlimentar = fibraAlimentar;
        this.energia = energia;
        this.selecionado = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getLipideos() {
        return lipideos;
    }

    public void setLipideos(double lipideos) {
        this.lipideos = lipideos;
    }

    public double getFibraAlimentar() {
        return fibraAlimentar;
    }

    public void setFibraAlimentar(double fibraAlimentar) {
        this.fibraAlimentar = fibraAlimentar;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
}
