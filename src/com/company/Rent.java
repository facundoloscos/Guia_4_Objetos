package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Rent {
    //Atributos
    public static ArrayList<Movie> movieList = new ArrayList<Movie>();
    public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
    public static ArrayList<Client> clientList = new ArrayList<Client>();

    //Metodos
    public static void printMovieList (ArrayList<Movie> movieList){
        for (int i=0; i<movieList.size();i++){
            System.out.println(movieList.get(i).toString());
        }
    }

    public static void printTicketList (ArrayList<Ticket> ticketList){  //metodo auxiliar que use para probar cosas
        for (int i=0; i<ticketList.size();i++){
            System.out.println(ticketList.get(i).toString());
        }
    }

    public static void printMoviesRentedToday (ArrayList<Ticket> ticketList){  //pelis alquiladas hoy
        LocalDate today = LocalDate.now();
        for (int i=0; i<ticketList.size(); i++){
            if (ticketList.get(i).getRentDay().equals(today)){
                System.out.println(ticketList.get(i).getMovieTitle());
            }
        }
    }

    public static void printMoviesToBeReturnedToday (ArrayList<Ticket> ticketList){  //pelis que deben ser devueltas hoy
        LocalDate today = LocalDate.now();
        for (int i=0; i<ticketList.size(); i++){
            if (ticketList.get(i).getReturnDay().equals(today)){
                System.out.println(ticketList.get(i).getMovieTitle());
            }
        }
    }

    public static void printLastTenMoviesRentedFromClient (String name, ArrayList<Ticket> ticketList){  //ultimas 10 pelis de un cliente
        int i = ticketList.size();
        int j = 0;
        while (i > 0 && j < 10){
            if (ticketList.get(i).getClientName().equals(name)){
                System.out.println(ticketList.get(i).getMovieTitle());
                j++;
            }
            i--;
        }
    }

    public static String knowMostRentedMovies (ArrayList<Movie> movieList){  //peli mas alquilada
        String movie = "Movie more rented is: ";
        int aux = 0;
        for (int i=0; i<movieList.size(); i++){
                if (movieList.get(i).getTimesRented() > movieList.get(aux).getTimesRented()){
                    aux = i;
                }
        }
        return movie + movieList.get(aux).getTitle();
    }

    public static void printMoviesMostRentedAccordingToGenre (Genre genre, ArrayList<Movie> movieList){  //pelis mas alquiladas segun un genero
        ArrayList<Movie> auxMovieList = new ArrayList<Movie>();
        int j = 0;
        for (int i=0; i<movieList.size(); i++){           //paso todas las peliculas de un genero a un arreglo auxiliar
            if (movieList.get(i).getGenre().equals(genre)){
                auxMovieList.add(j, movieList.get(i));
                j++;
            }
        }
        Collections.sort(auxMovieList, new Comparator<Movie>() {  //sobreescribo el metodo de comparacion para poder usarlo
            @Override                                             //y mostrar los datos ordenados de mayor a menor
            public int compare(Movie o1, Movie o2) {
                return new Integer(o2.getTimesRented()).compareTo(new Integer(o1.getTimesRented()));
            }
        });
        printMovieList(auxMovieList);
    }
}
