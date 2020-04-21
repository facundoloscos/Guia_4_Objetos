package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // DATOS CARGADOS PARA PROBAR COSAS //
        Movie matrix = new Movie("Matrix", 1999, 136, Rate.PG_13, "USA", "Nice special effects", 3, Genre.Action);
        Movie joker = new Movie("Joker", 2019, 122, Rate.R, "USA", "Psicological drama", 1, Genre.Drama);
        Movie AA = new Movie("Forrest Gump", 1994, 142, Rate.PG_13, "USA", "Life of a man", 4, Genre.Drama);
        Client pepe = new Client("Pepe", 4519999, "Luro 3333");
        Client ana = new Client("Ana", 4999999, "Colon 4444");

        Rent.movieList.add(matrix);
        Rent.movieList.add(joker);
        Rent.movieList.add(AA);
        Rent.clientList.add(pepe);
        Rent.clientList.add(ana);

        /////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////PROGRAMA COMO RECIBIRIA EL CLIENTE (ROBERTO)///////////////////////////////

        Scanner entry = new Scanner(System.in);
        int option;

        do{

            System.out.println("---Chose action---");
            System.out.println("01- Check movie and stock");
            System.out.println("02- Rent a movie");
            System.out.println("03- Return a movie");
            System.out.println("04- Check movies rented today");
            System.out.println("05- Check movies to be returned today");
            System.out.println("06- Ten last movies rented of a client");
            System.out.println("07- Most rented movies");
            System.out.println("08- Look for movies according to genre");
            System.out.println("09- Check information of a movie");
            System.out.println("00- Exit");

            option = entry.nextInt();

            switch (option){
                case 0:
                    break;
                case 1:
                    entry.nextLine();   //limpio buffer
                    System.out.print("Movie to be checked: ");
                    String movieToCheck = entry.nextLine();
                    System.out.println(Movie.checkMovieToKnowStock(movieToCheck, Rent.movieList));
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                case 2:
                    entry.nextLine();  //limpio buffer
                    System.out.print("Movie to rent: ");
                    String movieToRent = entry.nextLine();
                    if (Movie.checkMovie(movieToRent, Rent.movieList) != -1){  //compruebo que la pelicula este en el video store
                        int index = Movie.checkMovie(movieToRent, Rent.movieList);  //guardo el indice donde se encuentra la pelicula
                        if (Movie.checkStock(movieToRent, Rent.movieList)){  //compruebo si hay stock de la pelicula elegida
                            System.out.print("Client who wants to rent: ");
                            String clientToRent = entry.nextLine();
                            Client.checkClient(clientToRent, Rent.clientList);
                            Ticket lastTicket = new Ticket(clientToRent, movieToRent);
                            Rent.ticketList.add(lastTicket);
                            Rent.movieList.get(index).setStock(Rent.movieList.get(index).getStock() - 1);  //resto uno al stock
                            Rent.movieList.get(index).oneMoreRent();
                            System.out.println("Movie rented, press anything to continue...");
                            entry.nextLine();
                        }else{
                            System.out.println("Sorry, we have no stock of that movie today");
                            System.out.println("Press anything to continue...");
                            entry.nextLine();
                        }
                    }else{
                        System.out.println("Sorry, we do not have that movie");
                        System.out.println("Press anything to continue...");
                        entry.nextLine();
                    }
                    break;
                case 3:
                    entry.nextLine();  //limpio buffer
                    System.out.print("Movie returned: ");
                    String movieReturned = entry.nextLine();
                    int returnedIndex = Movie.checkMovie(movieReturned, Rent.movieList);  //indice de la pelicula devuelta
                    Rent.movieList.get(returnedIndex).setStock(Rent.movieList.get(returnedIndex).getStock() + 1);  //sumo uno al stock
                    break;
                case 4:
                    System.out.println("Movies rented today:");
                    Rent.printMoviesRentedToday(Rent.ticketList);
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                case 5:
                    System.out.println("Movies to be returned today:");
                    Rent.printMoviesToBeReturnedToday(Rent.ticketList);
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                case 6:
                    entry.nextLine();  //limpio buffer
                    System.out.println("Name of the client: ");
                    String clientLastTenMovies = entry.nextLine();
                    Rent.printLastTenMoviesRentedFromClient(clientLastTenMovies, Rent.ticketList);
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                case 7:
                    System.out.println("Most rented movie:");
                    System.out.println(Rent.knowMostRentedMovies(Rent.movieList));
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                case 8:
                    Rent.printMoviesMostRentedAccordingToGenre(Genre.Drama, Rent.movieList);
                    break;
                case 9:
                    entry.nextLine();  //limpio buffer
                    System.out.print("Movie: ");
                    String movieToSeeInfo = entry.nextLine();
                    int info = Movie.checkMovie(movieToSeeInfo, Rent.movieList);
                    System.out.println(Rent.movieList.get(info).toString());
                    System.out.println("Press anything to continue...");
                    entry.nextLine();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 0);
    }

}

