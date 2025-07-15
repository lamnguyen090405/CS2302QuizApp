/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntl.quizapp;

import com.ntl.pojo.Choice;
import com.ntl.pojo.Question;
import com.ntl.services.exam.BaseExamServices;
import com.ntl.services.exam.ExamTypes;
import com.ntl.services.exam.FixedExamServices;
import com.ntl.services.exam.SpecificExamServices;
import com.ntl.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class ExamController implements Initializable {

    @FXML
    private ComboBox<ExamTypes> cbTypes;
    @FXML
    private ListView<Question> lvQuestions;
    @FXML
    private TextField txtNum;
    
    private BaseExamServices exService;
    private List<Question> questions;
    private Map<Integer, Choice> results;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.txtNum.setVisible(false);
        this.cbTypes.getSelectionModel().selectedItemProperty().addListener((e) -> {
            if (this.cbTypes.getSelectionModel().getSelectedItem() == ExamTypes.SPECIFIC) {
                this.txtNum.setVisible(true);
            } else {
                this.txtNum.setVisible(false);
            }
        });
        
        this.cbTypes.setItems(FXCollections.observableArrayList(ExamTypes.values()));
    }    
    
    public void handleStart(ActionEvent event) throws SQLException {
        try {
            if (this.cbTypes.getSelectionModel().getSelectedItem() == ExamTypes.SPECIFIC) {
                this.exService = new SpecificExamServices(Integer.parseInt(this.txtNum.getText()));
            } else {
                this.exService = new FixedExamServices();
            }
            
            this.results = new HashMap<>();
            
            this.questions = exService.getQuestions();
            
            this.lvQuestions.setItems(FXCollections.observableList(questions));
            
            this.lvQuestions.setCellFactory(param -> new ListCell<Question>() {
                @Override
                protected void updateItem(Question question, boolean empty) {
                    super.updateItem(question, empty); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
                    
                    if (question == null || empty == true) {
                        this.setGraphic(null);
                    } else {
                        VBox v = new VBox(5);
                        v.setStyle("-fx-padding: 10; -fx-border-color: gray; -fx-border-width: 3;");
                        
                        Text t = new Text(question.getContent());
                        v.getChildren().add(t);
                        ToggleGroup g = new ToggleGroup();
                        for (var c : question.getChoices()) {
                            RadioButton r = new RadioButton(c.getContent());
                            r.setToggleGroup(g);
                            if(results.get(question.getId())==c)
                            {
                                r.setSelected(true);
                            }
                            
                            r.setOnAction(e -> {
                                if(r.isSelected())
                                    results.put(question.getId(),c);
                            });
                            
                            v.getChildren().add(r);
                        }
                        
                        this.setGraphic(v);
                    }
                }
            });
        } catch (InputMismatchException | NumberFormatException ex) {
            MyAlert.getInstance().showMsg("vui lòng nhập số lượng câu hỏi!", Alert.AlertType.WARNING);
        }
    }
    public void handleFinish(ActionEvent event) {
        int count = 0;
        for(var c : this.results.values()) {
            if(c.isCorrect() == true) {
                count++;
            }
        }
        
        MyAlert.getInstance().showMsg(String.format("Bạn làm đúng %d/%d",count,questions.size()), Alert.AlertType.INFORMATION);
    }
    
}
