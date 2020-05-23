/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rosko_calendar;

import java.util.Scanner;

/**
 *
 * @author Matouš
 */
public class Calendar {
    private int day;
    private int month;
    private int year;
    
    Calendar(int inputDay, int inputMonth, int inputYear){
        day = inputDay;
	month = inputMonth;
	year = inputYear;
    }
    
    private static final int[] MONTHSLENGTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] DAYSINWEEK = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    
    
    public int dayInWeek(int currentDay){
        int m = month;
        int y = year / 100;
        int r = year % 100;
	if (m == 1){
            m = 13;
	} else if (m == 2){
            m = 14;
	}
	int result = (currentDay + ((26 * (m + 1)) / 10) + r + (r / 4) + (y / 4) + (5 * y)) % 7;
        return result;
    }
    
    public static boolean isLeapYear(int year){
	return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static int yearLength(int year){
        return isLeapYear(year) ? (366) : (365);
    }
    
    /*public String displayCalendar(){
        StringBuilder display = new StringBuilder();
        
        display.append(month).append(". ").append(year).append("\n");
        display.append("Sa Su Mo Tu We Th Fr \n");
        
    }*/
    
    public String displayCalendar(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(day).append(". ").append(month).append(". ").append(year).append("\n");
        sb.append("Sun Mon Tue Wed Thu Fri Sat\n");
        for(int i = 1; i < dayInWeek(1); i++){
            sb.append("    ");
        }
        for(int i = 1; i <= MONTHSLENGTH[month-1]; i++){
            if(dayInWeek(i)%7==1 && i != 1){
                sb.append("\n");
            }
            if(i/10==0){
                sb.append(" ").append(i);
            }else{
                sb.append(i);
            }
            sb.append("  ");
        }
        return sb.toString();
    }
    
    public void nextMonth(){
	month++;
	if (month == 13){
            month = 1;
            year++;
	}
    }
    
    public void prevMonth(){
	month--;
	if (month == 1){
            month = 12;
            year--;
	}
    }
            
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
	System.out.println("Input date:");
        int currentDay = sc.nextInt();
        Calendar c = new Calendar(currentDay, sc.nextInt(), sc.nextInt());
        System.out.println("It is " + DAYSINWEEK[c.dayInWeek(currentDay)]);
        System.out.println("It " + (isLeapYear(c.year) ? "is" : "is not") + " a leap year");
        System.out.println(c.displayCalendar());
        System.out.println("Previous month: a    Next month: s    Quit: q");
        boolean isRunning = true;
        while(isRunning){
            switch(sc.next().charAt(0)){
                case 'a':
                    c.prevMonth();
                    System.out.println(c.displayCalendar());
                    System.out.println("Previous month: a    Next month: s    Quit: q");
                    break;
                case 's':
                    c.nextMonth();
                    System.out.println(c.displayCalendar());
                    System.out.println("Previous month: a    Next month: s    Quit: q");
                    break;
                case 'q':
                    isRunning = false;
                    break;
                default:
                    System.out.println("Entered unknown command.\n");
                    System.out.println("Previous month: a    Next month: s    Quit: q");
            }
        }
    }
    
}
