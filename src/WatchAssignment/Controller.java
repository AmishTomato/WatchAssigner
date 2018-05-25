package WatchAssignment;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    @FXML
    private MenuBar menuBar;

    @FXML
    private Menu file;
    @FXML
    private MenuItem open;
    @FXML
    private MenuItem save;
    @FXML
    private MenuItem exit;

    @FXML
    private Menu edit;
    @FXML
    private MenuItem delete;

    @FXML
    private Menu help;
    @FXML
    private MenuItem about;


    public Controller(){
        // default constructor
    }

    @FXML
    public void initialize(){
        try {
            assigner = new Assigner("Random_Names_Text.txt");
            setMenuBar();
            setListViews();
            assigner.assignWatches();
            populateListViews();
        }catch (IOException ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void setMenuBar(){
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // open file
            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // save to txt file
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // delete
            }
        });
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Created by: Ben Halligan\nVersion: 1.0.0");
            }
        });
    }

    private void setBtn(){
        loadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // open file Option to select text file
            }
        });
        assignBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                assigner.assignWatches();
            }
        });
    }

    private void setListViews(){
        sailorListView = new ListView<String>();
        firstWatchListView = new ListView<String>();
        secondListView = new ListView<String>();
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
