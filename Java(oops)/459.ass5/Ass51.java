import java.util.*;

public class Ass51
{
    public static void main(String[] args) {
        String gn;
        boolean flag, gFlag;
        String[] arrA= new String[14];
        String[] arrB= new String[14];
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter game to be played:");
        gn= sc.next();
        System.out.println("************************************************************************************");
        gn= gn.toUpperCase();
        flag= (gn.equals("CRICKET"))? true: false;
        gFlag= (gn.equals("CRICKET")||gn.equals("BASKETBALL")||gn.equals("FOOTBALL"))? true:false;
        if(gFlag)
        {
            System.out.println("Enter three names of players of teamA:");
            arrA[0] = sc.next();
            arrA[1] = sc.next();
            arrA[2] = sc.next();
            System.out.println("Enter reg. matches won, played, respectively by teamA:");
            arrA[3] = sc.next();
            arrA[4] = sc.next();
            arrA[5] = Double.toString(Double.parseDouble(arrA[3]) / Double.parseDouble(arrA[4]));
            System.out.println("Enter Nat. matches won, played, respectively by teamA:");
            arrA[6] = sc.next();
            arrA[7] = sc.next();
            arrA[8] = Double.toString(Double.parseDouble(arrA[5]) / Double.parseDouble(arrA[6]));
            System.out.println("Enter Inter. matches won, played, respectively by teamA:");
            arrA[9] = sc.next();
            arrA[10] = sc.next();
            arrA[11] = Double.toString(Double.parseDouble(arrA[9]) / Double.parseDouble(arrA[10]));
            System.out.println("Enter Total wiclets/goals of teamA:");
            arrA[12] = sc.next();
            if (flag) {
                System.out.println("Enter Total runs of teamA:");
                arrA[13] = sc.next();
            }
            System.out.println("************************************************************************************");

            System.out.println("Enter three names of players of teamB:");
            arrB[0] = sc.next();
            arrB[1] = sc.next();
            arrB[2] = sc.next();
            System.out.println("Enter reg. matches won, played, respectively by teamB:");
            arrB[3] = sc.next();
            arrB[4] = sc.next();
            arrB[5] = Double.toString(Double.parseDouble(arrA[3]) / Double.parseDouble(arrA[4]));
            System.out.println("Enter Nat. matches won, played, respectively by teamB:");
            arrB[6] = sc.next();
            arrB[7] = sc.next();
            arrB[8] = Double.toString(Double.parseDouble(arrA[5]) / Double.parseDouble(arrA[6]));
            System.out.println("Enter Inter. matches won, played, respectively by teamB:");
            arrB[9] = sc.next();
            arrB[10] = sc.next();
            arrB[11] = Double.toString(Double.parseDouble(arrA[9]) / Double.parseDouble(arrA[10]));
            System.out.println("Enter Total wiclets/goals of teamB:");
            arrB[12] = sc.next();
            if (flag) {
                System.out.println("Enter Total runs of teamB:");
                arrB[13] = sc.next();
            } else {
                arrA[13] = "";
                arrB[13] = "";
            }
            System.out.println("************************************************************************************");
            if (gn.equals("FOOTBALL")) {
                Football gamePlay = new Football(gn);
                gamePlay.playGame(arrA, arrB);
            } else if (gn.equals("CRICKET")) {
                Cricket gamePlay = new Cricket(gn);
                gamePlay.playGame(arrA, arrB);
            } else if (gn.equals("BASKETBALL")) {
                Basketball gamePlay = new Basketball(gn);
                gamePlay.playGame(arrA, arrB);
            }
        }
        else
        {
            System.out.println("Check the spelling or u may have given wrong option for game!\nExiting...........................");
        }
        sc.close();
    }
}

interface Players {
    public void setName(String[] nm);
    public String[] getName();
    public void setStats(String[] obj, boolean forRun);
    public Double[] getStats(boolean forRun);
}

interface Game
{
    public void playGame(String[] teamA, String[] teamB);
}

class Team implements Players
{
    private String[] name;
    private double matchWonReg, matchPlayReg;
    private double matchWonNat, matchPlayNat;
    private double matchWonInt, matchPlayInt;
    private double regStat, natStat, intStat;
    private double totalGoalorWicket, totalRun;

    Team()
    {
        name= new String[3];
    }
    public void setName(String[] nm)
    {
        this.name[0]= nm[0];
        this.name[1] = nm[1];
        this.name[2] = nm[2];
    }

    public String[] getName()
    {
        return this.name;
    }

    public void setStats(String[] obj, boolean forRun)
    {
        this.matchWonReg= Double.parseDouble(obj[0]);
        this.matchPlayReg= Double.parseDouble(obj[1]);
        this.regStat= Double.parseDouble(obj[2]);
        this.matchWonNat= Double.parseDouble(obj[3]);
        this.matchPlayNat= Double.parseDouble(obj[4]);
        this.natStat= Double.parseDouble(obj[5]);
        this.matchWonInt= Double.parseDouble(obj[6]);
        this.matchPlayInt= Double.parseDouble(obj[7]);
        this.intStat= Double.parseDouble(obj[8]);
        this.totalGoalorWicket= Double.parseDouble(obj[9]);
        if(forRun)
        {
            this.totalRun = Double.parseDouble(obj[10]);
        }
    }

    public Double[] getStats(boolean forRun)
    {
        Double[] arr;
        if(forRun)
        {
            arr= new Double[11];
        }
        else
        {
            arr = new Double[10];
        }
        arr[0] = this.matchWonReg;
        arr[1]= this.matchPlayReg;
        arr[2] = this.regStat;
        arr[3]= this.matchWonNat;
        arr[4]= this.matchPlayNat;
        arr[5]= this.natStat;
        arr[6]= this.matchWonInt;
        arr[7]= this.matchPlayInt;
        arr[8]= this.intStat;
        arr[9] = this.totalGoalorWicket;
        if(forRun)
        {
            arr[10]= this.totalRun;
        }
        return arr;
    }
} 

class Cricket implements Game
{
    private String gName;
    Cricket(String nm)
    {
        this.gName= nm;
    }

    public void playGame(String[] teamA, String[] teamB)
    {
        Team tA = new Team();
        tA.setName(Arrays.copyOfRange(teamA, 0, 3));
        tA.setStats(Arrays.copyOfRange(teamA, 3, 14), true);

        Team tB = new Team();
        tA.setName(Arrays.copyOfRange(teamB, 0, 3));
        tA.setStats(Arrays.copyOfRange(teamB, 3, 14), true);
        Double[] arrA = tA.getStats(true);
        Double[] arrB = tB.getStats(true);
        displayStats(arrA, arrB);
    }

    void displayStats(Double[] teamA, Double[] teamB)
    {
        String aStatswon= "", bStatswon="";

        if (teamA[0] > teamB[0]) {
            aStatswon += "Reg. matches won: " + Double.toString(teamA[0] - teamB[0]);
        } else {
            bStatswon += "Reg. matches won: " + Double.toString(teamB[0] - teamA[0]);
        }

        if (teamA[2] > teamB[2]) {
            aStatswon += "\nReg. winning stats: " + Double.toString(teamA[2] - teamB[2]);
        } else {
            bStatswon += "\nReg. winning stats: " + Double.toString(teamB[2] - teamA[2]);
        }

        if (teamA[3] > teamB[3]) {
            aStatswon += "\nNat. matches won: " + Double.toString(teamA[3] - teamB[3]);
        } else {
            bStatswon += "\nNat. matches won: " + Double.toString(teamB[3] - teamA[3]);
        }

        if (teamA[5] > teamB[5]) {
            aStatswon += "\nNat. winning stats: " + Double.toString(teamA[5] - teamB[5]);
        } else {
            bStatswon += "\nNat. winning stats: " + Double.toString(teamB[5] - teamA[5]);
        }

        if (teamA[6] > teamB[6]) {
            aStatswon += "\nInter. matches won: " + Double.toString(teamA[6] - teamB[6]);
        } else {
            bStatswon += "\nInter. matches won: " + Double.toString(teamB[6] - teamA[6]);
        }

        if (teamA[8] > teamB[8]) {
            aStatswon += "\nInter. winning stats: " + Double.toString(teamA[8] - teamB[8]);
        } else {
            bStatswon += "\nInter. winning stats: " + Double.toString(teamB[8] - teamA[8]);
        }

        if (teamA[9] > teamB[9]) {
            aStatswon += "\nTotal wickets/goals: " + Double.toString(teamA[9] - teamB[9]);
        } else {
            bStatswon += "\nTotal wickets/goals: " + Double.toString(teamB[9] - teamA[9]);
        }

        if (teamA[10] > teamB[10]) {
            aStatswon += "\nTotal runs: " + Double.toString(teamA[10] - teamB[10]);
        } else {
            bStatswon += "\nTotal runs: " + Double.toString(teamB[10] - teamA[10]);
        }    
        System.out.println("The Game being played between teams is "+ this.gName);
        System.out.println("************************************************************************************");
        
        if(aStatswon.equals(""))
        {
            System.out.println("Nothing is better of team A wrt to team B");
        }
        else
        {
            System.out.println("The Stats of team A: ");
            System.out.println("************************************************************************************");
            System.out.println(aStatswon+"\n more with respect to team B");    
        }
        System.out.println("************************************************************************************");

        if(bStatswon.equals(""))
        {
            System.out.println("Nothing is better of team B wrt to team A");
        }
        else
        {
            System.out.println("The Stats of team B: ");
            System.out.println("************************************************************************************");
            System.out.println(bStatswon+"\n more with respect to team A");    
        }
        
    }
}

class Football implements Game
{
    protected String gName;
    Football(String nm)
    {
        this.gName= nm;
    }

    public void playGame(String[] teamA, String[] teamB)
    {
        Team tA= new Team();
        tA.setName(Arrays.copyOfRange(teamA, 0, 3));
        tA.setStats(Arrays.copyOfRange(teamA, 3, 13), false);

        Team tB = new Team();
        tA.setName(Arrays.copyOfRange(teamB, 0, 3));
        tA.setStats(Arrays.copyOfRange(teamB, 3, 13), false);
        
        Double[] arrA= tA.getStats(false);
        Double[] arrB = tB.getStats(false);
        displayStats(arrA, arrB);
    }

    void displayStats(Double[] teamA, Double[] teamB)
    {
        String aStatswon= "", bStatswon="";

        if (teamA[0] > teamB[0]) {
            aStatswon += "Reg. matches won: " + Double.toString(teamA[0] - teamB[0]);
        } else {
            bStatswon += "Reg. matches won: " + Double.toString(teamB[0] - teamA[0]);
        }

        if (teamA[2] > teamB[2]) {
            aStatswon += "\nReg. winning stats: " + Double.toString(teamA[2] - teamB[2]);
        } else {
            bStatswon += "\nReg. winning stats: " + Double.toString(teamB[2] - teamA[2]);
        }

        if (teamA[3] > teamB[3]) {
            aStatswon += "\nNat. matches won: " + Double.toString(teamA[3] - teamB[3]);// harsh
        } else {
            bStatswon += "\nNat. matches won: " + Double.toString(teamB[3] - teamA[3]);
        }

        if (teamA[5] > teamB[5]) {
            aStatswon += "\nNat. winning stats: " + Double.toString(teamA[5] - teamB[5]);
        } else {
            bStatswon += "\nNat. winning stats: " + Double.toString(teamB[5] - teamA[5]);
        }

        if (teamA[6] > teamB[6]) {
            aStatswon += "\nInter. matches won: " + Double.toString(teamA[6] - teamB[6]);
        } else {
            bStatswon += "\nInter. matches won: " + Double.toString(teamB[6] - teamA[6]);
        }

        if (teamA[8] > teamB[8]) {
            aStatswon += "\nInter. winning stats: " + Double.toString(teamA[8] - teamB[8]);
        } else {
            bStatswon += "\nInter. winning stats: " + Double.toString(teamB[8] - teamA[8]);
        }

        if (teamA[9] > teamB[9]) {
            aStatswon += "\nTotal wickets/goals: " + Double.toString(teamA[9] - teamB[9]);
        } else {
            bStatswon += "\nTotal wickets/goals: " + Double.toString(teamB[9] - teamA[9]);
        }
        System.out.println("The Game being played between teams is "+ this.gName);
        System.out.println("************************************************************************************");

        if(aStatswon.equals(""))
        {
            System.out.println("Nothing is better of team A wrt to team B");
        }
        else
        {
            System.out.println("The Stats of team A: ");
            System.out.println("************************************************************************************");
            System.out.println(aStatswon+"\n more with respect to team B");    
        }
        System.out.println("************************************************************************************");

        if(bStatswon.equals(""))
        {
            System.out.println("Nothing is better of team B wrt to team A");
        }
        else
        {
            System.out.println("The Stats of team B: ");
            System.out.println("************************************************************************************");
            System.out.println(bStatswon+"\n more with respect to team A");    
        }
    }
}

class Basketball extends Football
{
    Basketball(String nm)
    {
        super(nm);
        this.gName= nm;
    }

    void displayStats(Double[] teamA, Double[] teamB)
    {
        String aStatswon= "", bStatswon="";

        if (teamA[0] > teamB[0]) {
            aStatswon += "Reg. matches won: " + Double.toString(teamA[0] - teamB[0]);
        } else {
            bStatswon += "Reg. matches won: " + Double.toString(teamB[0] - teamA[0]);
        }

        if (teamA[2] > teamB[2]) {
            aStatswon += "\nReg. winning stats: " + Double.toString(teamA[2] - teamB[2]);
        } else {
            bStatswon += "\nReg. winning stats: " + Double.toString(teamB[2] - teamA[2]);
        }

        if (teamA[3] > teamB[3]) {
            aStatswon += "\nNat. matches won: " + Double.toString(teamA[3] - teamB[3]);
        } else {
            bStatswon += "\nNat. matches won: " + Double.toString(teamB[3] - teamA[3]);
        }

        if (teamA[5] > teamB[5]) {
            aStatswon += "\nNat. winning stats: " + Double.toString(teamA[5] - teamB[5]);
        } else {
            bStatswon += "\nNat. winning stats: " + Double.toString(teamB[5] - teamA[5]);
        }

        if (teamA[6] > teamB[6]) {
            aStatswon += "\nInter. matches won: " + Double.toString(teamA[6] - teamB[6]);
        } else {
            bStatswon += "\nInter. matches won: " + Double.toString(teamB[6] - teamA[6]);
        }

        if (teamA[8] > teamB[8]) {
            aStatswon += "\nInter. winning stats: " + Double.toString(teamA[8] - teamB[8]);
        } else {
            bStatswon += "\nInter. winning stats: " + Double.toString(teamB[8] - teamA[8]);
        }

        if (teamA[9] > teamB[9]) {
            aStatswon += "\nTotal wickets/goals: " + Double.toString(teamA[9] - teamB[9]);
        } else {
            bStatswon += "\nTotal wickets/goals: " + Double.toString(teamB[9] - teamA[9]);
        }
        System.out.println("The Game being played between teams is "+ this.gName);
        System.out.println("************************************************************************************");

        if(aStatswon.equals(""))
        {
            System.out.println("Nothing is better of team A wrt to team B");
        }
        else
        {
            System.out.println("The Stats of team A: ");
            System.out.println("************************************************************************************");
            System.out.println(aStatswon+"\n more with respect to team B");    
        }
        System.out.println("************************************************************************************");

        if(bStatswon.equals(""))
        {
            System.out.println("Nothing is better of team B wrt to team A");
        }
        else
        {
            System.out.println("The Stats of team B: ");
            System.out.println("************************************************************************************");
            System.out.println(bStatswon+"\n more with respect to team A");    
        }
    }
}