module com.juegocaballo.caballo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.juegocaballo.caballo to javafx.fxml;
    exports com.juegocaballo.caballo;
}