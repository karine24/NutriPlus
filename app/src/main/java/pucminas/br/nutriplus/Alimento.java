package pucminas.br.nutriplus;

import java.io.Serializable;

public class Alimento implements Serializable {
    private String nome;
    private Double caboidrato;
    private Double proteina;
    private Double lipidios;
    private Double fibraAlimentar;
    private Double energia;
    private boolean selecionado;

    public Alimento(String nome,
                    Double caboidrato,
                    Double proteina,
                    Double lipidios,
                    Double fibraAlimentar,
                    Double energia) {
        this.nome = nome;
        this.caboidrato = caboidrato;
        this.proteina = proteina;
        this.lipidios = lipidios;
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

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Double getCaboidrato() {
        return caboidrato;
    }

    public void setCaboidrato(Double caboidrato) {
        this.caboidrato = caboidrato;
    }

    public Double getProteina() {
        return proteina;
    }

    public void setProteina(Double proteina) {
        this.proteina = proteina;
    }

    public Double getLipidios() {
        return lipidios;
    }

    public void setLipidios(Double lipidios) {
        this.lipidios = lipidios;
    }

    public Double getFibraAlimentar() {
        return fibraAlimentar;
    }

    public void setFibraAlimentar(Double fibraAlimentar) {
        this.fibraAlimentar = fibraAlimentar;
    }

    public Double getEnergia() {
        return energia;
    }

    public void setEnergia(Double energia) {
        this.energia = energia;
    }
}
