package WatchAssignment;

/**
 * Created by Ben Halligan
 * 5/10/2018
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * Ben Halligan wrote this file.  As long as you retain this notice you
 * can do whatever you want with this stuff. If we meet some day, and you think
 * this stuff is worth it, you can buy me a beer in return.   Poul-Henning Kamp
 * ----------------------------------------------------------------------------
 **/


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Assigner {

    private final Object[][] ASSIGNMENTS = { // Watch Name, number of posts
            {"A_ROVE",8}, {"B-1 PERIM", 8}, {"B-ROVE", 8}, {"BEQ QD", 4}, {"CGI", 3}, {"ESCORT1", 3}, {"ESCORT2",3},
            {"G-1 PERIM",8}, {"GAMEROOM", 3}, {"NFAS MESS", 4}, {"NFAS PHONE", 4}, {"NPS MESS", 4}, {"NPS PHONE", 4},
            {"PAD1", 3},{"PAD2",3},{"PAD3",4},{"PAD4",3},{"PAD5",4}, {"PERIM", 8}, {"WEIGHTROOM",4}
    };

    private final int OPEN_POSITIONS = 93;

    private final Watch EXTRA = new Watch("EXTRA");
    private final Watch CLEAN = new Watch("CLEAN");

    private int nvm;

    private Scanner in;
    private FileWriter writer;

    private ArrayList<Watch> watches =  new ArrayList<>();
    private ArrayList<Sailor> sailors = new ArrayList<>();

    public Assigner(){
        nvm =1;
    }

    /**
     * Assigns Watches to sailors
     */
    public void assignWatches(){
        for(int h=0; h<sailors.size(); h++){
            sailors.get(h).addFirstWatch(getWatch());
        }
        for(int t=0; t<sailors.size(); t++){
            sailors.get(t).addSecondWatch(getWatch());
        }
    }


    /**
     * Prints sailors with assigned Watches
     */
    public void printAll(){
        String[] temp;
        for(int x=0; x<sailors.size(); x++){
            temp = sailors.get(x).getWatches();
            System.out.println(temp[0]+" "+temp[1]+" | "+temp[2]);
        }
    }

    public void loadFile(File file)throws IOException{
        String filename = file.getName();
        inputFile(filename);
        populateWatches();
        System.out.println("Number of Watches: "+watches.size());
    }

    public void writeFile() throws IOException{
        writer = new FileWriter(new File("Assignments.txt"));
        String[] out;
        for(int n=0; n<sailors.size(); n++){
            out = sailors.get(n).getWatches();
            writer.write(out[0]+" "+out[1]+" | "+out[2]+"\n");
        }
        writer.close();
    }

    public void printNames(){
        for(int i=0; i<sailors.size(); i++){
            System.out.println(sailors.get(i).getName());
        }
    }
    public void printWatches(){
        for (int w=0; w<ASSIGNMENTS.length; w++){
            System.out.println(ASSIGNMENTS[w][0]+" with "+ASSIGNMENTS[w][1]+" watches");
        }
    }

    public ObservableList<Sailor> getSailorList(){
        ObservableList<Sailor> out = FXCollections.observableList(sailors);
        return out;
    }



    private Watch getWatch(){
        int index = getRandom();
        if (index ==0 || watches.isEmpty()){
            if(nvm%2==0){
                ++nvm;
                return CLEAN;
            }else{
                ++nvm;
                return EXTRA;
            }
        }else if(index<watches.size()) {
            Watch temp = watches.get(index);
            watches.remove(temp);
            return temp;
        }else {
            return getWatch();
        }
    }

    private int getRandom(){
        return (int)Math.round(Math.random()*watches.size());
    }

    private void inputFile(String filename)throws IOException{
        in = new Scanner(new File(filename));
        while (in.hasNextLine()){
            sailors.add(new Sailor(in.nextLine()));
        }
        in.close();
    }

    private void populateWatches(){
        for(int i=0; i<ASSIGNMENTS.length; i++){
            String watch = ""+ASSIGNMENTS[i][0];
            int number = (int)ASSIGNMENTS[i][1];
            for(int j=0; j<number; j++) {
                watches.add(new Watch(watch));
            }
        }
    }


}
