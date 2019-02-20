/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.generic.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static test.generic.stream.Boites.ofDouble;
import static test.generic.stream.Boites.ofFloat;

import static test.generic.stream.Boites.ofInt;
import static test.generic.stream.Boites.ofLong;

/**
 *
 * @author sidaty
 */
public class TestGenericStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        ofInt().add(47).add(328).add(14).add(28).show("Boites 1");
        ofLong().show("Boites 2");
        ofFloat().show("Boites 3");
        ofDouble().show("Boites 4");
    }
    
    
    
    private static void test2() {
        Boite<String> boite1 = new Boite("Piece 50F");
        Boite<Integer> boite2 = new Boite(50);
        Boite<Date> boite3 = new Boite(new Date());
        Boite<String> boite4 = new Boite();
        
        System.out.println(boite1.getElementOuException());
        System.out.println(boite2.getElementOuException());
        System.out.println(boite3.getElementOuException());
//        System.out.println(boite4.getElementOuException());
    }
    
    private static void test1() {
        List<String> listNoms = listeNom();
        
        for(String nom : listNoms) {
            System.out.println(nom + " : " + nom.length());
        }
    }
    
    private static List<String> listeNom() {
        List<String> listNoms = new ArrayList<>();
        listNoms.add("Traore");
        listNoms.add("Sidibe");
        listNoms.add("Diallo");
//        listNoms.add(2);
//        listNoms.add(2.4);
//        listNoms.add(new Date());
        
        return listNoms;
    }
    
    
}
