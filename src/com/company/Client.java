package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    //Atributos
    private String name;
    private int telephoneNumber;
    private String address;

    //Metodos
    public Client (String name, int telephoneNumber, String address){
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Client (){

    }

    public String getName (){
        return this.name;
    }

    public static void checkClient (String name, ArrayList<Client> clientList){  //busca un cliente y si no esta lo crea
        Scanner entry = new Scanner(System.in);
        int flag = -1;
        String addressOfNewClient;
        int i = 0, telephoneOfNewClient;
        while (i < clientList.size() && flag == -1){
            if (clientList.get(i).getName().equals(name)){
                flag = i;
            }
            i++;
        }
        if (flag == -1){
            System.out.println("The client does not exist");
            System.out.println("Creating the new client: ");
            System.out.println("Name: "+name);
            System.out.print("Address: ");
            addressOfNewClient = entry.nextLine();
            System.out.print("Telephone number: ");
            telephoneOfNewClient = entry.nextInt();
            Client newClient = new Client(name, telephoneOfNewClient, addressOfNewClient);
            clientList.add(newClient);
        }else{
            System.out.println("The client already exists");
        }
    }
}
