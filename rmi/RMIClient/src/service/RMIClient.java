package service;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            IBanqueRemote stub = (IBanqueRemote) Naming.lookup("rmi://localhost:1099/BK");
            System.out.println(stub.conversion(150));
            System.out.println(stub.getServerDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
