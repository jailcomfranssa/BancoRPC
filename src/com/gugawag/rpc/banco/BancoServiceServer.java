package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    List<Conta> c;


    public BancoServiceServer() throws RemoteException {
        super();
        c = new ArrayList<Conta>();
        c.add(new Conta("1", 100.0));
        c.add(new Conta("2", 156.0));
        c.add(new Conta("3", 950.0));
    }
    @Override
    public double saldo(String conta) throws RemoteException {
        for (Conta c: c) {
            if(c.getNumConta().equals(conta)){
                return c.getSaldo();
            }
        }
        return 0.0;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return c.size();
    }

    @Override
    public void adicionarConta(String numConta, double saldo) throws RemoteException {
        Conta novaConta = new Conta(numConta, saldo);
        c.add(novaConta);

    }



}
