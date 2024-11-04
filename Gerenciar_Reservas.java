package Gerenciamento_de_Reserva;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import exception.ReservaInvalidaException;
import Interface.Gerenciador;

public class Gerenciar_Reservas implements Gerenciador<Reserva> {
    private List<Reserva> reservas;

    public Gerenciar_Reservas() {
        this.reservas = new ArrayList<>();
    }

    @Override
    public void cadastrar(Reserva reserva) throws ReservaInvalidaException {
        if (!verificarDisponibilidade(reserva.getDataEntrada(), reserva.getDataSaida(), reserva.getTipoQuarto())) {
            throw new ReservaInvalidaException("Reserva inválida: Quarto indisponível para as datas selecionadas.");
        }
        reservas.add(reserva);
        System.out.println("Reserva criada com sucesso!");
    }

    @Override
    public Reserva buscarPorId(String cpfHospede) throws ReservaInvalidaException {
        for (Reserva reserva : reservas) {
            if (reserva.getCpfHospede().equals(cpfHospede)) {
                return reserva;
            }
        }
        throw new ReservaInvalidaException("Reserva não encontrada para o hóspede com CPF " + cpfHospede);
    }

    @Override
    public void editar(Reserva reserva) throws ReservaInvalidaException {
        Reserva existente = buscarPorId(reserva.getCpfHospede());
        existente.setDataEntrada(reserva.getDataEntrada());
        existente.setDataSaida(reserva.getDataSaida());
        existente.setTipoQuarto(reserva.getTipoQuarto());
        System.out.println("Reserva atualizada com sucesso!");
    }

    @Override
    public void exibirTodos() {
        System.out.println("Lista de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    private boolean verificarDisponibilidade(LocalDate dataEntrada, LocalDate dataSaida, String tipoQuarto) {
        for (Reserva reserva : reservas) {
            if (reserva.isAtiva() && reserva.getTipoQuarto().equals(tipoQuarto) &&
                dataEntrada.isBefore(reserva.getDataSaida()) && dataSaida.isAfter(reserva.getDataEntrada())) {
                return false;
            }
        }
        return true;
    }
}
