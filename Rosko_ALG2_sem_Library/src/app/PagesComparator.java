/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Comparator;

/**
 * compares books by the number of pages
 * @author Matouš
 */
public class PagesComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o2.getPages() - o1.getPages();
    }

}
