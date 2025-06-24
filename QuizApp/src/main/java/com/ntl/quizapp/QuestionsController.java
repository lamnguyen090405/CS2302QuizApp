/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntl.quizapp;

import com.ntl.pojo.Category;
import com.ntl.pojo.Level;
import com.ntl.pojo.Question;
import com.ntl.services.CategoryServices;
import com.ntl.services.LevelServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
  private static final CategoryServices cateService = new CategoryServices();
  private static final LevelServices levelService = new LevelServices();
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
        TextField txt = new TextField();
        
        h.getChildren().addAll(r,txt);
        this.vboxChoices.getChildren().add(h);
    }
 
    public void handleQuestion(ActionEvent event)
    {
        
    }
}
