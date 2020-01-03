package com.example.managermonster.backend;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BackendService {

//    private List<Employee> employees;
    private List<Monster> monsters;

    {
        // Init dummy data

        monsters = new ArrayList<>();
        monsters.add((new Monster("Great Beast", "1", "x", "-", "-", "x", "x", "R", "R", "x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/001.jpg")));
        monsters.add((new Monster("Hydra", "2", "x", "-", "-", "x", "x", "R", "R", "x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/002.jpg")));
        monsters.add((new Monster("Werewolf", "3","x","x","-","-","x","x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/003.jpg")));
        monsters.add((new Monster("Behemoth", "4",  "-","x", "-","x","R","x","R","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/004.jpg")));
        monsters.add((new Monster("Griffin", "5", "x","-","-","x","x","x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/005.jpg")));
        monsters.add((new Monster("Tyrannosaurus Rex", "6", "x","-","-","x","x",	"R","R","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/006.jpg")));
        monsters.add((new Monster("Cockatrice", "7", "x","x","-","-","x",	"x","x","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/007.jpg")));
        monsters.add((new Monster("Cyclops", "8", "-","-","x","x","R","R","x","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/008.jpg")));
        monsters.add((new Monster("Tengu", "9", "-","x","-","x","R",	"x","R","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/009.jpg")));
        monsters.add((new Monster("Triton", "10", "-","x","x","-","x","x","x","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/010.jpg")));
        monsters.add((new Monster("Kraken", "11", "-","x","x","-","R","x","x","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/011.jpg")));
        monsters.add((new Monster("Jotun Troll", "12", "-","-","x","x","R","R","x","x", "http://www.raumhafen.de/galerie/rubber_guys/mimp/012.jpg")));
        monsters.add((new Monster("The Monster", "13", "x","x","-","-","x","x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/013.jpg")));
        monsters.add((new Monster("Manticore", "14", "-","x","x","-","R",	"x","x","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/014.jpg")));
        monsters.add((new Monster("Karnak", "15", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/015.jpg")));
        monsters.add((new Monster("Coatlicue", "16", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/016.jpg")));
        monsters.add((new Monster("Bigfoot", "17", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/017.jpg")));
        monsters.add((new Monster("Baba Yaga", "18", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/018.jpg")));
        monsters.add((new Monster("Kali", "19", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/019.jpg")));
        monsters.add((new Monster("Catoblepas", "20", "x","x","-","-","x",	"x","R","R", "http://www.raumhafen.de/galerie/rubber_guys/mimp/020.jpg")));


//
    }
    public List<Monster> getMonsters() { return monsters;}
//    public List<Employee> getEmployees() {
//        return employees;
//    }
    public void addMonster(String monsterName, String monsterNumber, String lightOlive, String red, String yellow,
                           String darkPurple, String neonGreen, String lightRed, String chartreuse, String thistle,
                           String image){
        monsters.add((new Monster(monsterName, monsterNumber, lightOlive, red, yellow, darkPurple, neonGreen,
                lightRed, chartreuse, thistle, image)));
    }

}
