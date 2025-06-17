module com.ntl.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires lombok;
    
    opens com.ntl.quizapp to javafx.fxml;
    exports com.ntl.quizapp;
}
