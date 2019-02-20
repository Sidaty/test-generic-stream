/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.generic.stream;

/**
 *
 * @author sidaty
 */
public class Boite<E> {

    private E element;

    public Boite() {
    }

    public Boite(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public boolean estVide() {
        return element == null;
    }

    public E getElementOuException() {
        if (estVide()) {
            throw new NullPointerException();
        }
        return element;
    }

}
