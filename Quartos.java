package Gerenciamento_de_Quartos;

public class Quartos {
    private String numero;
    private String tipo; // "casal", "solteiro", or "suíte luxo"
    private int capacidade;
    private double diaria;
    private String status;

    public Quartos(String numero, String tipo, int capacidade, double diaria, String status) {
        this.numero = numero;
        setTipo(tipo); // Validates and sets the room type
        this.capacidade = capacidade;
        this.diaria = diaria;
        this.status = status;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("casal") || tipo.equalsIgnoreCase("solteiro") || tipo.equalsIgnoreCase("suíte luxo")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de quarto inválido. Use: 'casal', 'solteiro', ou 'suíte luxo'.");
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getDiaria() {
        return diaria;
    }

    public void setDiaria(double diaria) {
        this.diaria = diaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quarto Número =" + numero + ", Tipo =" + tipo + ", Capacidade =" + capacidade
                + ", Diária =" + diaria + ", Status =" + status ;
    }
}
