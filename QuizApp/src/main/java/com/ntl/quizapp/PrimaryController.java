package com.ntl.quizapp;

import com.ntl.utils.MyAlert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {
        public void handleQuestionManagement(ActionEvent event) throws IOException
        {
//            MyAlert.getInstance().showMsg("Question Management: coming soon...");
            Scene scene = new Scene(new FXMLLoader(App.class.getResource("questions.fxml")).load());
             
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Quiz App");
            stage.show();
        }
        
        public void handlePractice(ActionEvent event)
        {
            MyAlert.getInstance().showMsg("Practice: coming soon...");
        }
        
        public void handleTest(ActionEvent event)
        {
            MyAlert.getInstance().showMsg("Test: coming soon...");
        }
    
        public void handleSignUp(ActionEvent event)
        {
            MyAlert.getInstance().showMsg("Sign up: coming soon...");
        }
        
        public void handleSignIn(ActionEvent event)
        {
            MyAlert.getInstance().showMsg("Sign in: coming soon...");
        }
    
}
