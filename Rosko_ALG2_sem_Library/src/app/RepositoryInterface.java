/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.text.ParseException;
import java.util.Comparator;

/**
 * interface
 * @author Matouš
 */
public interface RepositoryInterface {
    
    /**
     * reads data from a file
     */
    void readData();
    
    /**
     * writes data into a file (creates a new file)
     */
    void writeData();
    
    /**
     * sorts books in a list
     * @param c property by which the book will be sorted
     */
    void sort(Comparator<Book> c);
    
    /**
     * adds a book to a repository
     * @param name name of the book
     * @param author author of the book
     * @param code ID code of the book
     * @param pages number of pages
     * @param publicationDate book's date of publication
     * @throws ParseException 
     */
    void addBook(String name, String author, int code, int pages, String publicationDate) throws ParseException ;
    
    /**
     * removes a book from a repository
     * @param code ID code of the book
     * @return whether the book was found in the repository
     */
    boolean remBook(int code);
    
}
