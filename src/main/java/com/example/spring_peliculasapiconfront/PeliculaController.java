package com.example.spring_peliculasapiconfront;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Controller
public class PeliculaController {

    @GetMapping
    //@GetMapping("{nombre}")
    //public String buscarPeliculas(Model modelo,@PathVariable String nombre){

    public String buscarPeliculas(Model modelo, @RequestParam Optional<String> q){
        String query = q.orElse(null);
        List<Pelicula> resultado=null;
        if (query!=null && !query.isEmpty()) {
            RestTemplate apiPelis = new RestTemplate();
            String apikey = "1b3bb77c";
            String url = "http://www.omdbapi.com/?apikey=" + apikey + "&s=" + query;

            resultado = (apiPelis.getForObject(url, PeliculaSearch.class)).getSearch();
        }
        modelo.addAttribute("pelis", resultado);
        modelo.addAttribute("q", query);
        return "index";
    }
}
