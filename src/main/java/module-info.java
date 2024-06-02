module org.example.learning {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.material2;

    requires com.dlsc.formsfx;

    opens org.example.learning to javafx.fxml;
    exports org.example.learning;
}