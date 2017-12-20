package jcis4110;
import java.util.Scanner;

class BasketballPlayer{
    private String name;
    private int number;
    private String position;
    private String team;
    private int weight;
    private int yearsPro;
    private double gamesPlayed;

    public static Scanner input = new Scanner(System.in);
    public static double points;
    public static double rebounds;

    public BasketballPlayer(){}

    public BasketballPlayer(String nme, int num, String pos, String tm,
                            int yrsPro, int wght, double gmesPlyed){
        name = nme;
        number = num;
        position = pos;
        team = tm;
        weight = wght;
        yearsPro = yrsPro;
        gamesPlayed = gmesPlyed;
    }

    public void setName(String nme){
        name = nme;
    }

    public void setNumber(int num){
        number = num;
    }

    public void setPosition(String pos){
        position = pos;
    }

    public void setTeam(String tm){
        team = tm;
    }

    public void setYearsPro(int yrsPro){
        yearsPro = yrsPro;
    }

    public void setWeight(int wght){
        weight = wght;
    }

    public void setGamesPlayed(int gp){
        gamesPlayed = gp;
    }

    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public String getPosition(){
        return position;
    }

    public String getTeam(){
        return team;
    }

    public int getYearsPro(){
        return yearsPro;
    }

    public int getWeight(){
        return weight;
    }

    public double getGamesPlayed(){
        return gamesPlayed;
    }

    public void calculateShootingPercentage(String givenName){
        double fgAttempts, fgMade, fgPercentage, threeAttempts, threeMade, threePercentage, ftAttempts,
                ftMade, ftPercentage, tsAttempts, tsPercentage, fgEffective;

        System.out.println("How many field goals has " + givenName + " attempted?: ");
        fgAttempts = input.nextDouble();
        System.out.println("How many field goals has the " + givenName + " made?: ");
        fgMade = input.nextDouble();

        System.out.println("How many three point shots has " + givenName + " attempted?: ");
        threeAttempts = input.nextDouble();
        System.out.println("How many three point shots has " + givenName + " made?: ");
        threeMade = input.nextDouble();


        System.out.println("How many free throws has " + givenName + " attempted?: ");
        ftAttempts = input.nextDouble();
        System.out.println("How many free throws has " + givenName + " made?: ");
        ftMade = input.nextDouble();

        if(points == 0.0) {
            System.out.println("\nWe also need the points scored in order to calculate True Shooting Percentage.");
            System.out.println("\nHow many points has " + givenName + " scored?");
            points = input.nextDouble();
        }

        while(fgMade > fgAttempts || threeMade > threeAttempts || ftMade > ftAttempts){
            if(fgMade > fgAttempts){
                System.out.println("You cannot have more made shots than there are attempts.");
                System.out.println("How many field goals has " + givenName + " attempted?: ");
                fgAttempts = input.nextDouble();
                System.out.println("How many field goals has the " + givenName + " made?: ");
                fgMade = input.nextDouble();
            }
            if(threeMade > threeAttempts){
                System.out.println("You cannot have more made shots than there are attempts.");
                System.out.println("How many three point shots has " + givenName + " attempted?: ");
                threeAttempts = input.nextDouble();
                System.out.println("How many three point shots has" + givenName + " made?: ");
                threeMade = input.nextDouble();
            }
            if(ftMade > ftAttempts){
                System.out.println("You cannot have more made shots than there are attempts.");
                System.out.println("How many free throws has " + givenName + " attempted?: ");
                ftAttempts = input.nextDouble();
                System.out.println("How many free throws has " + givenName + " made?: ");
                ftMade = input.nextDouble();
            }
        }

        fgPercentage = (fgMade/fgAttempts) * 100;
        ftPercentage = (ftMade/ftAttempts) * 100;
        threePercentage = (threeMade/threeAttempts) * 100;
        tsAttempts = fgAttempts + 0.44 * ftAttempts;
        tsPercentage = (points/(2*tsAttempts))*100;
        fgEffective = ((fgMade + 0.5*threeMade)/fgAttempts)*100;

        System.out.println("\nThe following are " + givenName + "'s shooting statistics." + "\nField Goal Percentage: "
                + fgPercentage + "%\nFree Throw Percentage: " + ftPercentage + "%\nThree Point Percentage: "
                + threePercentage + "%\nTrue Shooting Percentage: " + tsPercentage + "%\nEffective Field Goal Percentage: "
                + fgEffective + "%");
    }

    public void calculateReboundStatistics(String givenName){
        double defenseRebounds, offenseRebounds, defRebndPercent, offRebndPercent;

        if (rebounds == 0.0) {
            System.out.println("\nPlease enter the total amount of rebounds: ");
            rebounds = input.nextDouble();
        }
        System.out.println("\nPlease enter the amount of defensive rebounds: ");
        defenseRebounds = input.nextDouble();

        offenseRebounds = rebounds - defenseRebounds;
        defRebndPercent = (defenseRebounds/rebounds) * 100;
        offRebndPercent = (offenseRebounds/rebounds) * 100;

        System.out.println("\nThe following is " + givenName + "'s rebound statistics: " + "\nTotal Defensive Rebounds: "
                + defenseRebounds +"\nTotal Offensive Rebounds: " + offenseRebounds + "\nDefensive Rebounds Percentage: "
                + defRebndPercent + "%" + "\nOffensive Rebound Percentage: " + offRebndPercent + "%");
    }

    public void calculatePerGame(String givenName, double givenGp){
        double steals, assists, blocks, turnovers, ppg, rpg, spg, apg, bpg, tpg;

        System.out.println("How many points has " + givenName + " scored?");
        points = input.nextDouble();

        System.out.println("How many rebounds does " + givenName + " have?");
        rebounds = input.nextDouble();

        System.out.println("How many steals does " + givenName + " have?");
        steals = input.nextDouble();

        System.out.println("How many assists does " + givenName + " have?");
        assists = input.nextDouble();

        System.out.println("How many blocks does " + givenName + " have?");
        blocks = input.nextDouble();

        System.out.println("How many turnovers does " + givenName + " have?");
        turnovers = input.nextDouble();

        ppg = points/givenGp;
        rpg = rebounds/givenGp;
        spg = steals/givenGp;
        apg = assists/givenGp;
        bpg = blocks/givenGp;
        tpg = turnovers/givenGp;

        System.out.println("These are " + givenName + " per game statistics:" + "\nPoints per game: " + ppg +
                "\nRebounds per game: " + rpg + "\nSteals per game: " + spg + "\nAssists per game: " + apg +
                "\nBlocks per game: " + bpg + "\nTurnovers per game: " + tpg);
    }

    public void mainMenu(String givenName, double givenGp){
        BasketballPlayer menu = new BasketballPlayer();
        int choice;
        System.out.println("What would you like to know about " + givenName +
                "? \nPlease enter the number next to the desired choice: ");
        System.out.println("\n1. All statistics \n2. Shooting percentages \n3. Rebound percentages " +
                "\n4. Per game statistics \n5. Terminate the program");
        choice = input.nextInt();

        while(choice < 1 || choice > 5){
            System.out.println("\n Please enter a valid choice: ");
            choice = input.nextInt();
        }

        if (choice != 5) {
            System.out.println("Please remember the number of games played is " + givenGp +
                    " when entering the subsequent data.");
        }
        switch(choice){
            case 1: menu.calculatePerGame(givenName, givenGp);
                    menu.calculateReboundStatistics(givenName);
                    menu.calculateShootingPercentage(givenName);
                break;
            case 2: menu.calculateShootingPercentage(givenName);
                break;
            case 3: menu.calculateReboundStatistics(givenName);
                break;
            case 4: menu.calculatePerGame(givenName, givenGp);
                break;
            case 5: break;
        }

    }

    public void receiveData(){
        String nme, posit, tem, response;
        int no,yrs,wgt;
        double gp;

        System.out.println("This program calculates various statistics for a professional basketball player. " +
                "\nBut before that is done we need certain data points. " +
                "\nPlease enter data when prompted for either one season or for a player's entire career.");

        System.out.println("\nPlease enter the player's name: ");
        nme = input.nextLine();
        System.out.println("\nPlease enter the player's position: ");
        posit = input.nextLine();
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
            System.out.println("\nPlease enter the player's position: ");
            posit = input.nextLine();
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

        BasketballPlayer given = new BasketballPlayer(nme,no,posit,tem,yrs,wgt,gp);
        given.mainMenu(nme,gp);
    }

    public static void main(String args[]){
        BasketballPlayer run = new BasketballPlayer();
        run.receiveData();
    }
}
