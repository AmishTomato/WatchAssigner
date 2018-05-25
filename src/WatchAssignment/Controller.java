package WatchAssignment;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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

    private FileChooser fileChooser = new FileChooser();

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

    }



}
