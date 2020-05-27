/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static utils.DateConvertor.simpleDateToUnix;

/**
 * repository of library books
 * @author Matouš
 */
public class Repository implements RepositoryInterface {
    //data
    private List<Book> books = new ArrayList<>();

    //methods
    @Override
    public void readData() {
        try {
            String filePath = "data/data.txt";
            String[] bookData = new String[5];
            File bookFile = new File(filePath);
            Files.lines(bookFile.toPath()).forEach((t) -> { // checks each line
                if (t.equals("#/#")) { //separator
                    books.add(new Book(bookData[0],
                            bookData[1],
                            Integer.parseInt(bookData[2]),
                            Integer.parseInt(bookData[3]),
                            Long.parseLong(bookData[4])));
                } else {
                    String[] elements = t.split("=");
                    switch (elements[0]) { // elements[0] = Book property
                        case "name":
                            bookData[0] = elements[1];
                            break;
                        case "author":
                            bookData[1] = elements[1];
                            break;
                        case "code":
                            bookData[2] = elements[1];
                            break;
                        case "pages":
                            bookData[3] = elements[1];
                            break;
                        case "publicationDate":
                            bookData[4] = elements[1];
                            break;
                    }
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void writeData() {
        try {
            File f = new File("data/data.txt");
            f.createNewFile(); // former file gets rewritten
            try (FileWriter fw = new FileWriter("data/data.txt", false)) {
                for (Book book : books) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("name").append("=").append(book.getName()).append(System.getProperty("line.separator"))
                            .append("author").append("=").append(book.getAuthor()).append(System.getProperty("line.separator"))
                            .append("code").append("=").append(book.getCode()).append(System.getProperty("line.separator"))
                            .append("pages").append("=").append(book.getPages()).append(System.getProperty("line.separator"))
                            .append("publicationDate").append("=").append(book.getPublicationDate())
                            .append(System.getProperty("line.separator")).append("#/#").append(System.getProperty("line.separator"));
                    fw.write(sb.toString());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Repository.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sort(Comparator<Book> c) {
        books.sort(c);
    }

    @Override
    public void addBook(String name, String author, int code, int pages, String publicationDate) throws ParseException {
        books.add(new Book(name, author, code, pages, simpleDateToUnix(publicationDate)));
        writeData();
    }

    @Override
    public boolean remBook(int code) {
        for(Book book : books){
            if(book.getCode() == code){
                books.remove(book);
                writeData();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String part = books.toString();
        part = part.replace("[", "");
        part = part.replace("]", "");
        return part;
    }
    
    /*
    public static void main(String[] args) {
        Repository repository = new Repository();
        repository.readData();
        repository.writeData();
    }
    */
}
