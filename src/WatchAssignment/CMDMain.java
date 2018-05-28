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

import java.io.File;
import java.io.IOException;

public class CMDMain {
    public static void main(String[] args) {
        System.out.println("Watch Assinger V0.1.0");
        try {
            Assigner assigner = new Assigner();
            assigner.loadFile(new File("Random_Names_Text.txt"));
            assigner.assignWatches();
            assigner.printAll();
            assigner.writeFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
