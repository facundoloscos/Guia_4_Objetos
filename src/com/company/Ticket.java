package com.company;

import java.time.LocalDate;

public class Ticket {
    //Atributos
    private LocalDate rentDay = LocalDate.now();
    private LocalDate returnDay = rentDay.plusDays(2);
    private String clientName;
    private String movieTitle;

    //Metodos
    public Ticket (){

    }

    public Ticket (String clientName, String movieTitle){
        this.clientName = clientName;
        this.movieTitle = movieTitle;
    }

    public LocalDate getRentDay() {
        return rentDay;
    }

    public LocalDate getReturnDay() {
        return returnDay;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "rentDay=" + rentDay +
                ", returnDay=" + returnDay +
                ", clientName='" + clientName + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
