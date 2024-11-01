package Gerenciamento_de_Hospede;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import Gerenciamento_de_Quartos.Quartos;
import Gerenciamento_de_Quartos.Gerenciar_Quartos;
import exception.QuartoIndisponivelException;

public class Checkin_Checkout {
    private Map<String, String> registrosCheckIn;
    private Gerenciar_Quartos gerenciarQuartos; 

    public Checkin_Checkout(Gerenciar_Quartos gq) {
        this.registrosCheckIn = new HashMap<>();
        this.gerenciarQuartos = gerenciarQuartos; 
    }

    public void checkIn(String numeroQuarto, String cpfHospede) throws QuartoIndisponivelException {
        if (numeroQuarto.isEmpty() || cpfHospede.isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos obrigatórios.");
        }

        if (!validarCpf(cpfHospede)) {
            throw new IllegalArgumentException("CPF inválido. O formato esperado é 000.000.000-00.");
        }
        
        Quartos quarto = gerenciarQuartos.buscarPorId(numeroQuarto);
        if (quarto != null && quarto.getStatus().equalsIgnoreCase("disponível")) {
            quarto.setStatus("ocupado");
            registrosCheckIn.put(cpfHospede, numeroQuarto);
            System.out.println("Check-in realizado com sucesso para o hóspede " + cpfHospede + " no quarto " + numeroQuarto);
        } else {
            throw new QuartoIndisponivelException("Check-in não pode ser realizado. Quarto " + numeroQuarto + " não está disponível.");
        }
    }

    public void checkOut(String cpfHospede, String dataCheckIn, String dataCheckOut) throws QuartoIndisponivelException {
        if (cpfHospede.isEmpty() || dataCheckIn.isEmpty() || dataCheckOut.isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos obrigatórios.");
        }
        
        String numeroQuarto = registrosCheckIn.remove(cpfHospede);
        if (numeroQuarto != null) {
            Quartos quarto = gerenciarQuartos.buscarPorId(numeroQuarto);
            if (quarto != null) {
                int dias = calcularDias(dataCheckIn, dataCheckOut);
                double valorTotal = quarto.getDiaria() * dias;
                quarto.setStatus("disponível");
                System.out.println("Check-out realizado com sucesso para o hóspede " + cpfHospede + ". Valor total da estadia: R$ " + valorTotal);
            } else {
                System.out.println("Operação falhou: Quarto não encontrado.");
            }
        } else {
            System.out.println("Operação falhou: Hóspede não encontrado para check-out.");
        }
    }

    private int calcularDias(String dataCheckIn, String dataCheckOut) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate checkInDate = LocalDate.parse(dataCheckIn, formatter);
        LocalDate checkOutDate = LocalDate.parse(dataCheckOut, formatter);
        return (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    private boolean validarCpf(String cpf) {
        
        return Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", cpf);
    }

    public void listarQuartosDisponiveisPorTipo(String tipo) {
        gerenciarQuartos.listarQuartosDisponiveisPorTipo(tipo);
    }
}
