package sample;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;
import java.time.format.DateTimeFormatter;



import java.time.LocalDate;

public class Main extends Application {
    public static ServiceBook serviceBook;

    @Override
    public void start(Stage primaryStage) {
        //serviceBook = new ServiceBook();

        primaryStage.setTitle("Service Book");
        primaryStage.show();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));

        Scene scene = new Scene(grid, 500 ,450);
        primaryStage.setScene(scene);

        Text sceneTitle = new Text("Service Book");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
        HBox hbTitle = new HBox(10);
        grid.add(sceneTitle,0,0,2,1);

        Button servicesButton = new Button("Show all services");
        grid.add(servicesButton,0,1);
        Button showLastServiceButton = new Button("Show last service");
        grid.add(showLastServiceButton,1,1);
        Button addServiceButton = new Button("Add a new service");
        grid.add(addServiceButton,2,1);

        Button addButton = new Button("Add");
        grid.add(addButton,3,12,2,1);
        addButton.setVisible(false);

        Button backButton = new Button("Back");
        grid.add(backButton,3,1,1,1);
        backButton.setVisible(false);

        TextArea textArea = new TextArea();
        textArea.setMinWidth(200);
        textArea.setMinHeight(200);
        grid.add(textArea,0,5,9,20);
        textArea.setVisible(false);

        DatePicker datePicker = new DatePicker();
        grid.add(datePicker,1,7,2,1);
        datePicker.setPromptText("date...");
        datePicker.setVisible(false);

        TextField serviceNameArea = new TextField();
        grid.add(serviceNameArea,1,9,2,1);
        serviceNameArea.setMaxWidth(175);
        serviceNameArea.setPromptText("service name...");
        serviceNameArea.setVisible(false);

        TextField mileagesArea = new TextField();
        grid.add(mileagesArea,1,11,2,1);
        mileagesArea.setMaxWidth(175);
        mileagesArea.setPromptText("mileages...");
        mileagesArea.setVisible(false);

        Label dateLabel = new Label("Date:");
        grid.add(dateLabel,0,7,2,1);
        dateLabel.setVisible(false);

        Label serviceLabel = new Label("Service:");
        grid.add(serviceLabel,0,9,2,1);
        serviceLabel.setVisible(false);

        Label mileageLabel = new Label("Mileage:");
        grid.add(mileageLabel,0,11,2,1);
        mileageLabel.setVisible(false);


        addServiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                datePicker.setVisible(true);
                backButton.setVisible(true);
                addButton.setVisible(true);
                textArea.setText("");
                textArea.setVisible(false);
                mileagesArea.setVisible(true);
                serviceNameArea.setVisible(true);
                dateLabel.setVisible(true);
                mileageLabel.setVisible(true);
                serviceLabel.setVisible(true);
            }
        });
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LocalDate local = datePicker.getValue();
                Date date = new Date();
                date.setDay(local.getDayOfMonth());
                date.setMonth(local.getMonthValue());
                date.setYear(local.getYear());

                Service service = new Service();
                service.setMileage(Integer.parseInt(mileagesArea.getText()));
                service.setDate(date);
                service.setService(serviceNameArea.getText());
                serviceBook.addService(service);
                mileagesArea.setText("");
                datePicker.setValue(null);
                serviceNameArea.setText("");

            }
        });
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                textArea.setVisible(false);
                backButton.setVisible(false);
                addButton.setVisible(false);
                datePicker.setVisible(false);
                mileagesArea.setVisible(false);
                serviceNameArea.setVisible(false);
                dateLabel.setVisible(false);
                mileageLabel.setVisible(false);
                serviceLabel.setVisible(false);

            }
        });
        showLastServiceButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                textArea.setVisible(true);
                textArea.setText("");
                textArea.appendText("Last service date: " + serviceBook.getDateOfLastService().toString());
                backButton.setVisible(true);
                datePicker.setVisible(false);
                mileagesArea.setVisible(false);
                serviceNameArea.setVisible(false);
                dateLabel.setVisible(false);
                mileageLabel.setVisible(false);
                serviceLabel.setVisible(false);
            }
        });
        servicesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    textArea.setVisible(true);
                    textArea.setText("");
                for (Service allService : serviceBook.getAllServices()) {
                    textArea.appendText(allService.toString() + "\n");
                }
                backButton.setVisible(true);
                datePicker.setVisible(false);
                mileagesArea.setVisible(false);
                serviceNameArea.setVisible(false);
                dateLabel.setVisible(false);
                mileageLabel.setVisible(false);
                serviceLabel.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {

        serviceBook = new ServiceBook();

        Date date1 = new Date(2,11,2018);
        Date date2 = new Date(28,7,2017);
        Date date3 = new Date(11,9,2019);
        Date date4 = new Date(4,2,2011);
        Date date5 = new Date(24,12,2018);



        Service service1 = new Service(10,date1,"Service 1");
        Service service2 = new Service(12,date2,"Service 2");
        Service service3 = new Service(2,date3,"Service 3");
        Service service4 = new Service(4,date4,"Service 4");

        ServiceBook book1 = serviceBook;


        book1.addService(service1);
        book1.addService(service2);
        book1.addService(service3);
        book1.addService(service4);

        book1.getNumberOfServices();
        book1.getAllServiceMileages();
        book1.getDateOfLastService();

        launch(args);
    }
}