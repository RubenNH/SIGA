package mx.edu.utez.aweb.pokemonapp.controller.pokemon;

import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.service.pokemon.ServicePokemon;
import mx.edu.utez.aweb.pokemonapp.utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletPokemon",
        urlPatterns = {
                "/get-pokemons",
                "/add-pokemon",
                "/create-pokemon",
                "/save-pokemon",
                "/get-pokemon"
        })
public class ServletPokemon extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPokemon");
    String action;
    String urlRedirect = "/get-pokemons";
    ServicePokemon servicePokemon = new ServicePokemon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-pokemons":
                List<BeanPokemon> pokemons = servicePokemon.getAll();
                System.out.println(pokemons.size());
                request.setAttribute("pokemons", pokemons);
                urlRedirect = "/views/Estudiantes/index.jsp";
                break;
            case "/create-pokemon":
                urlRedirect = "/views/Estudiantes/Solicitar.jsp";
                break;
            case "/get-pokemon":
                String id = request.getParameter("id");
                id= (id==null) ? "0" : id;
                try {
                    BeanPokemon pokemon = servicePokemon.getPokemon(Long.parseLong(id));
                    request.setAttribute("pokemon", pokemon);
                    urlRedirect = "/views/pokemon/Update.jsp";
                }catch (Exception e){
                    urlRedirect = "/get-pokemons";
                }
                break;
            case "/save-pokemon":
                String nombre2 = request.getParameter("name");
                String type2 = request.getParameter("type");
                String health2 = request.getParameter("health");
                String estatura2 = request.getParameter("estatura");
                String damage2 = request.getParameter("damage");
                String peso2 = request.getParameter("peso");
                String id2 = request.getParameter("id");
                BeanPokemon pokemon2 = new BeanPokemon();
                pokemon2.setName(nombre2);
                pokemon2.setPower(Double.parseDouble(damage2));
                pokemon2.setWeight(Double.parseDouble(peso2));
                pokemon2.setHeight(Double.parseDouble(estatura2));
                pokemon2.setHealth(Double.parseDouble(health2));
                pokemon2.setPokemonType(type2);
                break;
            default:
                request.setAttribute("pokemons", servicePokemon.getAll());
                urlRedirect = "/get-pokemons";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action) {
            case "/add-pokemon":
                String nombre = request.getParameter("name");
                String type = request.getParameter("type");
                String health = request.getParameter("health");
                String estatura = request.getParameter("estatura");
                String damage = request.getParameter("damage");
                String peso = request.getParameter("peso");
                BeanPokemon pokemon = new BeanPokemon();
                pokemon.setName(nombre);
                pokemon.setPower(Double.parseDouble(damage));
                pokemon.setWeight(Double.parseDouble(peso));
                pokemon.setHeight(Double.parseDouble(estatura));
                pokemon.setHealth(Double.parseDouble(health));
                pokemon.setPokemonType(type);
                ResultAction result = servicePokemon.save(pokemon);
                urlRedirect = "/get-pokemons?result="+
                    result.isResult()+"&message="+result.getMessage()
                +"&status="+result.getStatus();
                break;
            default:
                urlRedirect = "/get-pokemons";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
