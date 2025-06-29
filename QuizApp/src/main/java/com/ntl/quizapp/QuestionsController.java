/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntl.quizapp;

import com.ntl.pojo.Category;
import com.ntl.pojo.Choice;
import com.ntl.pojo.Level;
import com.ntl.pojo.Question;
import com.ntl.services.CategoryServices;
import com.ntl.services.LevelServices;
import com.ntl.services.QuestionServices;
import com.ntl.utils.MyAlert;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
  @FXML private VBox vboxChoices;
  @FXML private ComboBox<Category> cbCates;
  @FXML private ComboBox<Level> cbLevels;
  @FXML private TextArea txtContent;
  @FXML private ToggleGroup toggleChoice = new ToggleGroup();
  
  private static final CategoryServices cateService = new CategoryServices();
  private static final LevelServices levelService = new LevelServices();
  private static final QuestionServices questionService = new QuestionServices();
  
    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
           
            this.cbCates.setItems(FXCollections.observableList(cateService.getCates()));
            this.cbLevels.setItems(FXCollections.observableArrayList(levelService.getLevels()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }   
    
    public void handleMoreChoices(ActionEvent event)
    {
        HBox h = new HBox();
        h.getStyleClass().add("MENU");
        
        RadioButton r = new RadioButton();
        r.setToggleGroup(toggleChoice); 
        
        TextField txt = new TextField();
        
        h.getChildren().addAll(r,txt);
        this.vboxChoices.getChildren().add(h);
    }
 
    public void handleQuestion(ActionEvent event)
    {
      try {
          Question.Builder b = new Question.Builder(this.txtContent.getText(), this.cbCates.getSelectionModel().getSelectedItem(),
                  this.cbLevels.getSelectionModel().getSelectedItem());
          
          for(var c : this.vboxChoices.getChildren())
          {
              HBox h = (HBox)c;
              Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(), 
                      ((RadioButton)h.getChildren().get(0)).isSelected());
              
              b.addChoices(choice);
          }
          
          Question q = b.build();
          questionService.addQuestion(q);
          MyAlert.getInstance().showMsg("Thêm câu hỏi thành công");
      }
      catch(SQLException ex){
        MyAlert.getInstance().showMsg("Thêm câu hỏi thất bại");
      }
      catch (Exception ex) {
          MyAlert.getInstance().showMsg("Dữ liệu không hợp lệ!");
      }
    }
}
