package Gerenciamento_de_Quartos;

import java.util.ArrayList;
import java.util.List;
import exception.QuartoIndisponivelException;
import Interface.Gerenciador;

public class Gerenciar_Quartos implements Gerenciador<Quartos> {
	private List<Quartos> quartos;

	public Gerenciar_Quartos() {
		this.quartos = new ArrayList<>();
		inicializarQuartosPredefinidos(); 
	}

	private void inicializarQuartosPredefinidos() {
		for (int i = 1; i <= 20; i++) {
			String tipo = (i % 3 == 0) ? "suíte luxo" : (i % 2 == 0) ? "casal" : "solteiro";
			String numero = String.format("%03d", i);
			Quartos quarto = new Quartos(numero, tipo, (tipo.equals("suíte luxo") ? 4 : 2), 150.0 + (50.0 * (i % 3)),
					"disponível");
			quartos.add(quarto);
		}
	}

	@Override
	public void cadastrar(Quartos quarto) {
		quartos.add(quarto);
		System.out.println("Quarto " + quarto.getNumero() + " cadastrado com sucesso!");
	}

	@Override
	public Quartos buscarPorId(String numero) throws QuartoIndisponivelException {
		for (Quartos quarto : quartos) {
			if (quarto.getNumero().equals(numero)) {
				return quarto;
			}
		}
		throw new QuartoIndisponivelException("Quarto com número " + numero + " não encontrado.");
	}

	public Quartos buscarPrimeiroDisponivelPorTipo(String tipo) throws QuartoIndisponivelException {
		for (Quartos quarto : quartos) {
			if (quarto.getTipo().equalsIgnoreCase(tipo) && quarto.getStatus().equalsIgnoreCase("disponível")) {
				return quarto;
			}
		}
		throw new QuartoIndisponivelException("Não há quartos disponíveis do tipo " + tipo);
	}

	@Override
	public void editar(Quartos quarto) throws QuartoIndisponivelException {
		Quartos existente = buscarPorId(quarto.getNumero());
		existente.setStatus(quarto.getStatus());
		System.out.println("Status do quarto atualizado com sucesso!");
	}

	@Override
	public void exibirTodos() {
		System.out.println("Lista de Quartos:");
		for (Quartos quarto : quartos) {
			System.out.println(quarto);
		}
	}

	public void listarQuartosDisponiveisPorTipo(String tipo) {
		System.out.println("Quartos disponíveis do tipo: " + tipo);
		for (Quartos quarto : quartos) {
			if (quarto.getTipo().equalsIgnoreCase(tipo) && quarto.getStatus().equalsIgnoreCase("disponível")) {
				System.out.println(quarto);
			}
		}
	}

	public void listarQuartosDisponiveis() {
		System.out.println("Quartos disponíveis:");
		for (Quartos quarto : quartos) {
			if (quarto.getStatus().equalsIgnoreCase("disponível")) {
				System.out.println(quarto);
			}
		}
	}
}
