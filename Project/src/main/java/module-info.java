module com.example.cmpe313 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    // requires org.kordamp.bootstrapfx.core;
    opens com.example.cmpe313 to javafx.fxml;
    exports com.example.cmpe313;
}