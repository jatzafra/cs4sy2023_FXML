/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package exercise13truthzafrajulian;

import java.net.URL;
import java.util.ArrayList;
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
    @FXML Label subject;
    @FXML Label units;
    @FXML Label grade;
    @FXML ImageView logo;
    @FXML Button nextButton;
    @FXML Button prevButton;
    @FXML TextField searchBar;
    @FXML Button searchButton;
    
    Subject math = new Subject("Math", "math.png", 4, 1.75);
    Subject bio = new Subject("Biology", "biology.png", 3, 2.0);
    Subject chem = new Subject("Chemistry", "chemistry.png", 3, 1.5);
    Subject physics = new Subject("Physics", "physics.png", 3, 1.75);
    Subject cs = new Subject("CS", "computer science.png", 1, 1.5);
    
    int index;
    Subject displayedSubject;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        index = 0;
        displayedSubject = Subject.getSubjectList().get(index);
        
        update();
    }    
    public void update(){
        subject.setText(displayedSubject.getName());
        units.setText(Double.toString(displayedSubject.getUnits()));
        grade.setText(Double.toString(displayedSubject.getGrade()));
        Image img = new Image(main.class.getResourceAsStream(displayedSubject.getImgFileName()));
        logo.setImage(img);
    }
    
    @FXML private void searchSubject(){
        String searched = searchBar.getText();
        ArrayList<Subject> subjects = Subject.getSubjectList();
        
        for(Subject subj : subjects){
            if(searched.equals(subj.getName())){
                displayedSubject = subj;
                
                update();
            }
        }
    }
    @FXML private void nextSubject(){
        if(index == Subject.getSubjectList().size()-1){
            return;
        }
        displayedSubject = Subject.getSubjectList().get(++index);
        
        update();
    }
    @FXML private void prevSubject(){
        if(index == 0){
            return;
        }
        displayedSubject = Subject.getSubjectList().get(--index);
        
        update();
    }
}
