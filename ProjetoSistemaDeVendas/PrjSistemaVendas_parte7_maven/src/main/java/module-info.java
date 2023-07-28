module br.edu.ifsc.fln.mainapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    
    opens br.edu.ifsc.fln.mainapp to javafx.fxml;
    exports br.edu.ifsc.fln.mainapp;
}
