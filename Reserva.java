package Gerenciamento_de_Reserva;

import java.time.LocalDate;

public class Reserva {
	private String cpfHospede;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String tipoQuarto;
    private boolean ativa;

    public Reserva(String cpfHospede, LocalDate dataEntrada, LocalDate dataSaida, String tipoQuarto) {
        this.cpfHospede = cpfHospede;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.tipoQuarto = tipoQuarto;
        this.ativa = true;  
    }

	public String getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(String cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public boolean isAtiva() {
		return ativa;
	}
	 public void cancelar() {
	        this.ativa = false;
	    }
	
	

}
