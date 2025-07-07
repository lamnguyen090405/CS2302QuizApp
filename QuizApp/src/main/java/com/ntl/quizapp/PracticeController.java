/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ntl.quizapp;

import com.ntl.pojo.Question;
import com.ntl.utils.Configs;
import com.ntl.utils.MyAlert;
import com.ntl.utils.MyStage;
import java.net.URL;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {

    @FXML
    private TextField txtNum;
    @FXML
    private Text txtContent;
    @FXML
    private VBox vBoxChoices;
    private List<Question> questions;
    private int currentIndex = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void start(ActionEvent event) throws SQLException {
        try {
            int num = Integer.parseInt(this.txtNum.getText());
            questions = Configs.questionService.getQuestions(num);
            loadQuestion();
        } catch (InputMismatchException ex) {
            MyAlert.getInstance().showMsg("Số câu hỏi không hợp lệ", Alert.AlertType.WARNING);

        }
    }

    public void check(ActionEvent event) {
        Question q = this.questions.get(this.currentIndex);

        for (int i = 0; i < q.getChoices().size(); i++) {
            if (q.getChoices().get(i).isCorrect()) {
                HBox h = (HBox) vBoxChoices.getChildren().get(i);
                if(((RadioButton)h.getChildren().get(0)).isSelected())
                {
                    MyAlert.getInstance().showMsg("CORRECT!");
                }else MyAlert.getInstance().showMsg("INCORRECT!");
                break;
            }
        }

//        for(var c : vBoxChoices.getChildren()){
//            HBox h = (HBox) c;
//            ((RadioButton)h.getChildren().get(0)).isSelected();
//        }
    }

    public void next(ActionEvent event) {
        if (this.currentIndex < this.questions.size()) {
            this.currentIndex++;
            loadQuestion();
        }
    }

    private void loadQuestion() {
        Question q = this.questions.get(currentIndex);
        this.txtContent.setText(q.getContent());
        ToggleGroup group = new ToggleGroup();
        vBoxChoices.getChildren().clear();
        for (var c : q.getChoices()) {
            HBox h = new HBox();

            RadioButton rdo = new RadioButton();
            rdo.setToggleGroup(group);

            Text txt = new Text(c.getContent());

            h.getChildren().addAll(rdo, txt);

            this.vBoxChoices.getChildren().add(h);
        }
    }
}
