package WatchAssignment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    private ObservableList<String> assignments;

    private FileChooser fileChooser = new FileChooser();

    private boolean fileLoaded;

    /* List Views */
    @FXML
    ListView<String> assignmentListView;

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
        fileLoaded = false;
        assigner = new Assigner();
        setUpFileMenu();
        setUpEditHelpMenu();
        setBtns();
    }

    private void setUpFileMenu(){
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Open previous assignment file

            }
        });
        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(fileLoaded == false){
                    loadFileAlert();
                }
                try {
                    assigner.writeFile();
                }catch (IOException err){
                    errorAlert(err);
                }
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    private void setUpEditHelpMenu(){
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Delete things
            }
        });
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert aboutpage = new Alert(Alert.AlertType.INFORMATION);
                aboutpage.setTitle("About");
                aboutpage.setHeaderText("Watch Assigner Version: v1.0.0");
                aboutpage.setContentText("Created by Ben Halligan\n5/12/2018-Present");
                aboutpage.show();
            }
        });
    }

    private void setBtns(){
        assignBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(fileLoaded) {
                    if(assigner.isEmptyWatches()){
                        assigner.populateWatches();
                    }
                    assigner.assignWatches();
                    populateListViews();
                }else{
                    loadFileAlert();
                }
            }
        });
        loadBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // load something
                fileChooser.setTitle("Choose File of Sailors");
                File file = fileChooser.showOpenDialog(new Stage());
                try {
                    assigner.loadFile(file);
                    fileLoaded = true;
                }catch (IOException ioerr){
                    errorAlert(ioerr);
                }
            }
        });
    }

    private void populateListViews(){
        ArrayList<Sailor> tempSailors = assigner.getSailors();
        List<String> listAssignments = new ArrayList<>();

        String[] assignment;

        for(int i=0; i<tempSailors.size(); ++i){
            assignment =  tempSailors.get(i).getWatches();
            listAssignments.add(i, assignment[0]+" "+assignment[1]+" | "+assignment[2]);
        }

        assignments = FXCollections.observableList(listAssignments);
        assignmentListView.setItems(assignments);
    }


    private void errorAlert(Exception error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("THERE WAS an Error...");
        alert.setHeaderText(error.getMessage());
        alert.setContentText(error.getStackTrace().toString());
        alert.show();
    }

    private void loadFileAlert(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("NO FILE LOADED");
        alert.setHeaderText("NO File of Sailors was loaded");
        alert.setContentText("Use Load Sailors button to load sailors");
        alert.show();
    }

}
