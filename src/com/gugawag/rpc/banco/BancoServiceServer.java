package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        contas = new ArrayList<>();

        // Defina as contas iniciais aqui
        adicionarConta("1", 100.0);
        adicionarConta("2", 156.0);
        adicionarConta("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.getOrDefault(conta, 0.0);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(String conta, double saldo) throws RemoteException {
        // Adicione a nova conta à lista de contas e ao mapa de saldoContas
        contas.add(new Conta(conta, saldo));
        saldoContas.put(conta, saldo);
        System.out.println("Conta cadastrada: " + conta);
    }
}
