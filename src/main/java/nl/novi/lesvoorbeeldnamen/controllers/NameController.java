package nl.novi.lesvoorbeeldnamen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NameController {

    //attribute
    private List<String> names = new ArrayList<>();

    //constructor
    public NameController(){
        names.add("Gumball");
        names.add("Darwin");
    }

    //methodes
    @GetMapping(value = "/names")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getNames(){
        return names;
    }

    @GetMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getName(@PathVariable int id){
        return names.get(id);
    }

    @DeleteMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteName(@PathVariable int id){
        names.remove(id);
        return "deleted";
    }

    @PostMapping(value = "/names")
    @ResponseStatus(HttpStatus.CREATED)
    public String addNames(@RequestBody String name){
        names.add(name);
       return "added";
    }



}
