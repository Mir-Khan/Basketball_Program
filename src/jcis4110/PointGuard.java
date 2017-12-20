package jcis4110;
import java.awt.*;
import java.util.Scanner;

public class PointGuard extends BasketballPlayer {
    private String typeOfPtGrd;
    public Scanner input = new Scanner(System.in);

    public PointGuard(){ }
    public PointGuard(String pg,String nme, int num, String pos, String tm, int yrsPro, int wght, double gmesPlyed){
        super(nme, num, pos, tm, yrsPro, wght, gmesPlyed);
        typeOfPtGrd = pg;
    }

    public void setTypeOfPtGrd(String type){
        typeOfPtGrd = type;
    }

    public String getTypeOfPtGrd() {
        return typeOfPtGrd;
    }

    public void calculateAssistTORatio(String nameGiven){
        double assists, turnovers, astTORatio;

        System.out.println("\nHow many assists does " + nameGiven + " have?: ");
        assists = input.nextDouble();

        System.out.println("How many turnovers has " + nameGiven + " committed?: ");
        turnovers = input.nextDouble();

        astTORatio = assists/turnovers;

        System.out.println(nameGiven + "'s assist to turnover ratio is: " + astTORatio);
    }

    public void calculateFoulsStealsRatio(String nameGiven){
        double fouls, steals, flsStlsRatio;

        System.out.println("\nHow many steals does " + nameGiven + " have?: ");
        steals = input.nextDouble();

        System.out.println("How many fouls does " + nameGiven + " have?: ");
        fouls = input.nextDouble();

        flsStlsRatio = steals/fouls;

        System.out.println(nameGiven + "'s steals to fouls ratio is: " + flsStlsRatio);
    }

    public void calculatePointsPerGame(String nameGiven, double gmes){
        double points, ppg;

        System.out.println("\nHow many steals does " + nameGiven + " have?: ");
        points = input.nextDouble();

        ppg = points/gmes;

        System.out.println(nameGiven + "'s points per game is: " + ppg);
    }

    public void receiveDataPG(){

        String posit = "Point Guard";
        String nme, tem, response, type = null;
        int no,yrs,wgt, choice;
        double gp;

        System.out.println("This program calculates statistics for a point guard in the NBA. Please enter some data" +
                " so we can get started.");
        System.out.println("\nPlease enter the player's name: ");
        nme = input.nextLine();
        System.out.println("\nPlease enter the player's team: ");
        tem = input.nextLine();
        System.out.println("\nPlease enter the player's number: ");
        no = input.nextInt();
        System.out.println("\nPlease enter the amount of years " + nme + " has been a professional player: ");
        yrs = input.nextInt();
        System.out.println("\nPlease enter the player's weight: ");
        wgt = input.nextInt();
        System.out.println("\nPlease enter the amount of games the player has participated in (either for their career or season): ");
        gp = input.nextDouble();

        System.out.println("This is your player's information. Is this correct? (Y/N): ");
        System.out.println("Name: " + nme + "\nPosition: " + posit + "\nTeam: " + tem + "\nNumber: " + no + "\nYears Pro: "
                + yrs + "\nWeight: " + wgt + "lbs. \nGames Played: " + gp);
        response = input.next();

        while(response.equalsIgnoreCase("N")){
            System.out.println("\nPlease enter the player's name: ");
            nme = input.nextLine();
            System.out.println("\nPlease enter the player's team: ");
            tem = input.nextLine();
            System.out.println("\nPlease enter the player's number: ");
            no = input.nextInt();
            System.out.println("\nPlease enter the amount of years " + nme + " has been a professional player: ");
            yrs = input.nextInt();
            System.out.println("\nPlease enter the player's weight: ");
            wgt = input.nextInt();
            System.out.println("\nPlease enter the amount of games the player has participated in (either for their career or season): ");
            gp = input.nextDouble();
        }

        System.out.println("There are different archetypes of point guards. Which one does your player fit into?:" +
                "\n1. Passing" +
                "\n2. Defender" +
                "\n3. Sharpshooter" +
                "\n4. Slasher");

        choice = input.nextInt();
        
        while(choice > 4 || choice < 1){
            System.out.println("That's an invalid entry. Please input your choice: ");
            choice = input.nextInt();
        }

        switch(choice){
            case 1: type = "Passing";
                break;
            case 2: type = "Defender";
                break;
            case 3: type = "Sharpshooter";
                break;
            case 4: type = "Slasher";
                break;
        }

        PointGuard dataHolder = new PointGuard(type,nme,no,posit,tem,yrs,wgt,gp);

        System.out.println("\nKeep in mind that these stats are calculated for " + gp + " when entering the following " +
                "data");

        if (type.equalsIgnoreCase("Passing")){
            System.out.println("A passing point guard is a point guard that can assist his teammate without committing " +
                    "a turnover in the process. Thus the assists to turnover ratio is a good indicator of a passing " +
                    "point guard's skill level.");

            dataHolder.calculateAssistTORatio(nme);
        } else if (type.equalsIgnoreCase("Defender")){

            System.out.print("A defending point guard's most relevant stat is the steal to fouls ratio, " +
                    "which determines their ability to force a turnover and gain posession of the ball from the other team.");

            dataHolder.calculateFoulsStealsRatio(nme);
        } else if (type.equalsIgnoreCase("Sharpshooter")){

            System.out.println("For a sharpshooting point guard, their shooting statistics are the most relevant " +
                    "statistic they have.");

            dataHolder.calculateShootingPercentage(nme);
        } else if (type.equalsIgnoreCase("Slasher")){
            System.out.println("For a slasher point guard, their most important job is to get points. Thus their most " +
                    "important statistic are their points per game.");
            dataHolder.calculatePointsPerGame(nme, gp);
        }
    }

    public static void main(String args[]){
        PointGuard player1 = new PointGuard();
        player1.receiveDataPG();
    }
}

