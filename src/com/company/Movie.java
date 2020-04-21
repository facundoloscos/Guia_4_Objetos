package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;

enum Genre {
    Action, Adventure, Comedy, Drama, Horror, Documentary;
}
enum Rate {
    G, PG, PG_13, R, NC_17, UNRATED;
}

public class Movie {
    //Atributos
    private String title;
    private int releaseDate;
    private int duration;
    private Rate rate;
    private String country;
    private String description;
    private int stock;
    private Genre genre;
    private int timesRented = 0;

    //Metodos
    public Movie (String title, int releaseDate, int duration, Rate rate, String country, String description, int stock, Genre genre){
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.rate = rate;
        this.country = country;
        this.description = description;
        this.stock = stock;
        this.genre = genre;
    }

    public Movie (){

    }

    public String getTitle (){
        return this.title;
    }

    public int getStock (){
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTimesRented() {
        return timesRented;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", duration=" + duration +
                ", rate='" + rate + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", genre='" + genre + '\'' +
                '}';
    }

    public static int checkMovie (String title, ArrayList<Movie> movieList){  //checkea si una peli esta y devuelve su ubicacion
        int flag = -1;
        int i = 0;
        while (i < movieList.size() && flag == -1){
            if (movieList.get(i).getTitle().equals(title)){
                flag = i;
            }
            i++;
        }
        return flag;
    }

    public static boolean checkStock (String title, ArrayList<Movie> movieList){  //devuelve true si una peli esta en stock
        boolean isStock = false;                                                  //caso contrario false
        int flag = checkMovie(title, movieList);
        if (flag != -1){
            if (movieList.get(flag).getStock() > 0){
                isStock = true;
            }
        }
        return isStock;
    }

    public static String checkMovieToKnowStock (String title, ArrayList<Movie> movieList){  //otro metodo para ver si una peli esta
        int exist = -1;                                                                     //y cuanto stock hay
        String isTheMovie = "The movie is in our collection";
        int i = 0;
        while (i < movieList.size() && exist == -1){
            if (movieList.get(i).getTitle().equals(title)){
                exist = i;
            }
            i++;
        }
        if (exist == -1){
            isTheMovie = "The movie is not in our collection";
        }else{
            isTheMovie += " and we have in stock "+movieList.get(exist).getStock()+" copies right now";
        }
        return isTheMovie;
    }

    public void oneMoreRent (){
        this.timesRented++;
    }

}
