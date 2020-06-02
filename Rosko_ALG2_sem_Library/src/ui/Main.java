/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import app.AuthorComparator;
import app.NameComparator;
import app.PagesComparator;
import app.PublicationDateComparator;
import app.Repository;
import app.RepositoryInterface;
import audio.AudioMaster;
import audio.Source;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Matouš
 */
public class Main {

    //init
    public static Scanner sc = new Scanner(System.in);
    private static RepositoryInterface repository = new Repository();

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        //music
        AudioMaster.init();
        int music = AudioMaster.loadSound("./data/music.ogg");
        Source musicSource = new Source();
        musicSource.setVolume(0.2f); //sound 20%
        musicSource.setLooping(true);
        musicSource.play(music);

        //init
        int choice;
        repository.readData();

        //welcome message
        System.out.println("Vitejte v nasi e-knihovne");
        System.out.println("Cas prihlaseni: " + LocalTime.now());

        do {
            displayMenu();
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                choice = -1; // case: default
                sc.next(); //prevents infinite loop
            }
            switch (choice) {
                case 0:
                    break;
                case 1:
                    repository.sort(new PagesComparator());
                    System.out.println(repository);
                    break;
                case 2:
                    repository.sort(new PublicationDateComparator());
                    System.out.println(repository);
                    break;
                case 3:
                    repository.sort(new NameComparator());
                    System.out.println(repository);
                    break;
                case 4:
                    repository.sort(new AuthorComparator());
                    System.out.println(repository);
                    break;
                case 5:
                    addBook();
                    break;
                case 6:
                    remBook();
                    break;
                default:
                    System.out.println("Chybna volba");
            }
        } while (choice != 0);
        AudioMaster.cleanUp();
    }

    /**
     * displays menu prompts
     */
    public static void displayMenu() {
        System.out.println("");
        System.out.println("1. Vypsat seznam knih (setrideno podle poctu stran)");
        System.out.println("2. Vypsat seznam knih (setrideno podle data publikace)");
        System.out.println("3. Vypsat seznam knih (setrideno podle nazvu)");
        System.out.println("4. Vypsat seznam knih (setrideno podle autoru)");
        System.out.println("5. Pridat knihu");
        System.out.println("6. Odstranit knihu");
        System.out.println("0. Ukoncit program");
    }

    /**
     * replaces or adds a book to repository (with prompts for the user)
     */
    public static void addBook() {
        try {
            System.out.println("Pri zadavani nepouzivejte diakritiku");
            System.out.println("Zadejte nazev knihy");
            sc.nextLine(); // safeguard for enter button after inputing int value
            String name = sc.nextLine();
            System.out.println("Zadejte autora (jmeno prijmeni)");
            String author = sc.nextLine().replaceAll("\\d", "").trim();
            System.out.println("Zadejte kod");
            int code = sc.nextInt();
            System.out.println("Zadejte pocet stran");
            int pages = sc.nextInt();
            sc.nextLine(); // safeguard for enter button after inputing int value
            System.out.println("Zadejte datum publikace (fomat rok.den.mesic)");
            String publicationDate = sc.nextLine();
            repository.remBook(code); // book with the same code gets replaced if necessary
            repository.addBook(name, author, code, pages, publicationDate);
        } catch (ParseException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Zadany neplatne informace");
            sc.nextLine(); // safeguard for enter button after inputing int value
        }
    }

    /**
     * removes a book from repository (with prompts for the user)
     */
    public static void remBook() {
        try {
            System.out.println("Zadejte kod knihy");
            int code = sc.nextInt();
            if (repository.remBook(code)) { // removes book and returns boolean
                System.out.println("Kniha uspesne odstranena");
            } else {
                System.out.println("Kniha se zvolenym kodem nenalezena");
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Zadany neplatne informace");
            sc.nextLine(); // safeguard for enter button after inputing int value
        }
    }
}
