/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exercise13truthzafrajulian;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author TRUTH
 */
public class InitialScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Label notFoundAlert;
    @FXML Label subject;
    @FXML Label units;
    @FXML Label grade;
    @FXML ImageView logo;
    @FXML Button nextButton;
    @FXML Button prevButton;
    @FXML TextField searchBar;
    @FXML Button searchButton;
    
    int index;
    Subject displayedSubject;
    
    Subject math = new Subject("Math", "math.png", 4, 1.75);
    Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
    Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
    Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
    Subject cs = new Subject("CS", "computer science.png", 1, 1.5);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        index = 0;
        displayedSubject = Subject.searchSubject(index);
        
        update();
    }    
    public void update(){
        nextButton.setDisable(false);
        prevButton.setDisable(false);
        if(index == Subject.getListLength() - 1){
            nextButton.setDisable(true);
        }
        if(index == 0){
            prevButton.setDisable(true);
        }
        
        notFoundAlert.setVisible(false);
        subject.setText(displayedSubject.getName());
        units.setText(Double.toString(displayedSubject.getUnits()));
        grade.setText(Double.toString(displayedSubject.getGrade()));
        Image img = new Image(main.class.getResourceAsStream(displayedSubject.getImgFileName()));
        logo.setImage(img);
    }
    
    @FXML private void searchSubjectButton(){
        String searched = searchBar.getText();
        
        try{
            displayedSubject = Subject.searchSubject(searched);
            index = Subject.getSubjectIndex(displayedSubject);
            update();
        }
        catch (NullPointerException e){
            notFoundAlert.setVisible(true);
        }
    }
    @FXML private void nextSubject(){
        index++;
        displayedSubject = Subject.searchSubject(index);
        
        update();
    }
    @FXML private void prevSubject(){
        index--;
        displayedSubject = Subject.searchSubject(index);
        
        update();
    }
}
