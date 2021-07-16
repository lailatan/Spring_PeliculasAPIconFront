package com.example.spring_peliculasapiconfront;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PeliculaSearch {
    @JsonProperty("Search")
    private List<Pelicula> search;

    public PeliculaSearch() {
    }

    public List<Pelicula> getSearch() {
        return search;
    }

    public void setSearch(List<Pelicula> search) {
        this.search = search;
    }


    @Override
    public String toString() {
        return "PeliculaSearch{" +
                "search=" + search +
                '}';
    }
}
