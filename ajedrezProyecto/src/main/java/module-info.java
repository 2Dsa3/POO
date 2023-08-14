module ec.edu.espol.ajedrezproyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.ajedrezproyecto to javafx.fxml;
    exports ec.edu.espol.ajedrezproyecto;
}
