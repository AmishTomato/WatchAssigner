package WatchAssignment;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.List;

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

public class Controller {

    private Assigner assigner;

    private ObservableList<Sailor> sailors;
    private ObservableList<Watch>  firstWatches;
    private ObservableList<Watch> secondWatches;

    /* List Views */
    @FXML
    private ListView sailorListView;
    @FXML
    private ListView firstWatchListView;
    @FXML
    private ListView secondListView;

    /* Buttons */
    @FXML
    private Button loadBtn;
    @FXML
    private Button assignBtn;

    /* Menu Stuff */


    public void initialize(){
        try {
            assigner = new Assigner("Random_Names_Text.txt");
            assigner.assignWatches();
            populateListViews();
        }catch (IOException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void populateListViews(){
        sailors =  assigner.getSailorList();
        getWatches();
        sailorListView.setItems(sailors);
        firstWatchListView.setItems(firstWatches);
        secondListView.setItems(secondWatches);
    }

    private void getWatches(){
        for(int i=0; i<sailors.size(); i++){
            firstWatches.add(sailors.get(i).getWatch1());
            secondWatches.add(sailors.get(i).getWatch2());
        }
    }


}
