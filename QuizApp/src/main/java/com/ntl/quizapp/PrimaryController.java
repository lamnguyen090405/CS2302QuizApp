package com.ntl.quizapp;

import com.ntl.utils.MyAlert;
import com.ntl.utils.MyStage;
import com.ntl.utils.theme.DarkThemeFactory;
import com.ntl.utils.theme.DefaultThemeFactory;
import com.ntl.utils.theme.LightThemeFactory;
import com.ntl.utils.theme.Theme;
import com.ntl.utils.theme.ThemeManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{
        @FXML private ComboBox<Theme> cbThemes;
        
        public void handleTheme(ActionEvent event)
        {
                this.cbThemes.getSelectionModel().getSelectedItem().updateTheme();
//            switch(this.cbThemes.getSelectionModel().getSelectedItem())
//            {
//                case DARK:
//                    ThemeManager.setThemeFactory(new DarkThemeFactory());
//                    break;
//                case LIGHT:
//                    ThemeManager.setThemeFactory(new LightThemeFactory());
//                    break;
//                case DEFAULT:
//                   ThemeManager.setThemeFactory(new DefaultThemeFactory());
//                    break;
//            }
            ThemeManager.applyTheme(this.cbThemes.getScene());
        }
        
        
        public void handleQuestionManagement(ActionEvent event) throws IOException
        {
//            MyAlert.getInstance().showMsg("Question Management: coming soon...");
//            Scene scene = new Scene(new FXMLLoader(App.class.getResource("questions.fxml")).load());
//             
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.setTitle("Quiz App");
//            stage.show();
            MyStage.getInstance().showStage("questions.fxml");
        }
        
        public void handlePractice(ActionEvent event) throws IOException
        {
            MyStage.getInstance().showStage("practice.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
}
