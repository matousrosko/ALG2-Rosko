/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import static utils.DateConvertor.unixToSimpleDate;

/**
 * Book stored in the library
 * @author Matouš
 */
public class Book implements Comparable<Book>{
    //data
    private String name;
    private String author;
    private int code;
    private int pages;
    private long publicationDate;
    
    //constructor
    public Book(String name, String author, int code, int pages, long publicationDate){
        this.name = name;
        this.author = author;
        this.code = code;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }
    
    //getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getCode() {
        return code;
    }

    public int getPages() {
        return pages;
    }

    public long getPublicationDate() {
        return publicationDate;
    }
    
    //methods
    @Override
    public String toString() {
        return "\n" + name + ", " + author + ", kod " + code + ", " + pages + " stran, " + unixToSimpleDate(publicationDate);
    }

    @Override
    public int compareTo(Book o) {
        return this.getPages() - o.getPages();
    }
}
