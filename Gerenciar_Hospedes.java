package Gerenciamento_de_Hospede;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Gerenciamento_de_Quartos.Gerenciar_Quartos;
import Gerenciamento_de_Quartos.Quartos;
import exception.ClienteNaoEncontradoException;
import exception.QuartoIndisponivelException;
import Interface.Gerenciador;

public class Gerenciar_Hospedes implements Gerenciador<Hospede> {
    private List<Hospede> hospedes;
    private Gerenciar_Quartos gerenciarQuartos; 

    public Gerenciar_Hospedes(Gerenciar_Quartos gerenciarQuartos) {
        this.hospedes = new ArrayList<>();
        this.gerenciarQuartos = gerenciarQuartos; 
    }

    @Override
    public void cadastrar(Hospede hospede) {
        hospedes.add(hospede);
        System.out.println("Hóspede " + hospede.getNome() + " cadastrado com sucesso!");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Escolha o tipo de quarto para o hóspede (casal, solteiro, suíte luxo): ");
        String tipoQuarto = sc.nextLine();
        
        try {
           
            Quartos quarto = gerenciarQuartos.buscarPrimeiroDisponivelPorTipo(tipoQuarto);
            if (quarto != null) {
                quarto.setStatus("ocupado");
                System.out.println("Quarto " + quarto.getNumero() + " do tipo " + tipoQuarto + " atribuído ao hóspede " + hospede.getNome() + ".");
            } else {
                System.out.println("Nenhum quarto disponível do tipo " + tipoQuarto + ". Escolha outro tipo ou tente novamente mais tarde.");
            }
        } catch (QuartoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public Hospede buscarPorId(String cpf) throws ClienteNaoEncontradoException {
        for (Hospede hospede : hospedes) {
            if (hospede.getCpf().equals(cpf)) {
                return hospede;
            }
        }
        throw new ClienteNaoEncontradoException("Hóspede com CPF " + cpf + " não encontrado.");
    }

    @Override
    public void editar(Hospede hospede) throws ClienteNaoEncontradoException {
        Hospede existente = buscarPorId(hospede.getCpf());
        Scanner sc = new Scanner(System.in);
        System.out.print("Novo nome (atual: " + existente.getNome() + "): ");
        existente.setNome(sc.nextLine());
        System.out.println("Informações do hóspede atualizadas com sucesso!");
    }

    @Override
    public void exibirTodos() {
        System.out.println("Lista de Hóspedes:");
        for (Hospede hospede : hospedes) {
            System.out.println(hospede);
        }
    }
}

