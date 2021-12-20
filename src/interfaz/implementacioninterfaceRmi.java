/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Usuario
 */
public class implementacioninterfaceRmi extends UnicastRemoteObject implements InterfaceRmi {
    public implementacioninterfaceRmi() throws RemoteException{
        
    }

    @Override
    public double sumar(double n1, double n2) throws RemoteException {
       return n1+n2;
    }

    @Override
    public double restar(double n1, double n2) throws RemoteException {
       return n1-n2;
    }

    @Override
    public double multiplicar(double n1, double n2) throws RemoteException {
    return n1*n2;
    }

    @Override
    public double dividir(double n1, double n2) throws RemoteException {
        return n1/n2;
    }
}
