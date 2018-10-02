import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import java.util.Date;
import java.time.LocalDate;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.util.Scanner;

public class Shelter extends Application {

    Stage window;
    AnchorPane layout;

    ComboBox<String> Type;
    ComboBox<String> Breed;
    ComboBox<String> aBreed;
    ComboBox<String> aType;
    ComboBox<String> fBreed;
    ComboBox<String> fType;
    ComboBox<String> lGender;
    ComboBox<String> fGender;
    ComboBox<String> lostLocation;
    ComboBox<String> foundLocation;
    ComboBox<String> rLocation;
    ListView<String> listViewType;
    ListView<String> listViewBreed;
    ListView<String> listViewLocation;
    TableView tableLost;
    TableView tableFound;
    TextField addType, addBreed, addLocation;
    TextField nameField, ageField, phoneField, emailField, aNameField, aAgeField;
    TextField fNameField, fAgeField, descArea;

    ObservableList<String> types = FXCollections.observableArrayList("");
    ObservableList<String> breeds = FXCollections.observableArrayList("");
    ObservableList<String> locations = FXCollections.observableArrayList("");

    public static AnimalList aList;
    //public Animal animal;
    public Person person;
    public static ObservableList<Animal> lAnimal;
    public static ObservableList<Animal> fAnimal;

    public static void main(String[] args) {
        launch(args);
    }   

    public void start(Stage mainStage) throws Exception {
        fileInputSerial();
        if(aList == null) 
            aList = new AnimalList();
        window = mainStage;
        window.setTitle("Animal Shelter");

        //File menu
        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(new MenuItem("Load"));
        fileMenu.getItems().add(new MenuItem("Save"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        TabPane tabPane = new TabPane();

        //Welcome Tab - Tab One
        AnchorPane anchorPaneOne = new AnchorPane();
        Tab tab = new Tab();
        tab.setContent(anchorPaneOne);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tab.setText("Welcome");
        tabPane.getTabs().add(tab);

        //Lost Tab - Tab Two
        AnchorPane anchorPaneTwo = new AnchorPane();
        Tab tabTwo = new Tab();
        tabTwo.setContent(anchorPaneTwo);
        tabTwo.setText("Lost");
        tabPane.getTabs().add(tabTwo);

        Label title = new Label("Owner Details");
        title.setLayoutY(20);
        title.setLayoutX(250);
        title.setFont(Font.font ("Verdana", 30));

        Label label1 = new Label("Name:");
        nameField = new TextField(); 
        label1.setLayoutY(85);
        label1.setLayoutX(100);
        nameField.setLayoutY(80);
        nameField.setLayoutX(160);

        Label label2 = new Label("Address:");
        ageField = new TextField();
        label2.setLayoutY(115);
        label2.setLayoutX(100);
        ageField.setLayoutY(110);
        ageField.setLayoutX(160);

        Label label3 = new Label("Phone:");
        phoneField = new TextField();
        label3.setLayoutY(85);
        label3.setLayoutX(380);
        phoneField.setLayoutY(80);
        phoneField.setLayoutX(420);

        Label labelemail = new Label("Email:");
        emailField = new TextField();
        labelemail.setLayoutY(115);
        labelemail.setLayoutX(380);
        emailField.setLayoutY(110);
        emailField.setLayoutX(420);

        Label titleAnimal = new Label("Animal Details");
        titleAnimal.setLayoutY(195);
        titleAnimal.setLayoutX(250);
        titleAnimal.setFont(Font.font ("Verdana", 30));

        Label label4 = new Label("Name:");
        aNameField = new TextField();
        label4.setLayoutY(255);
        label4.setLayoutX(100);
        aNameField.setLayoutY(250);
        aNameField.setLayoutX(160);

        Label label8 = new Label("Age:");
        aAgeField = new TextField();
        label8.setLayoutY(285);
        label8.setLayoutX(100);
        aAgeField.setLayoutY(280);
        aAgeField.setLayoutX(160);

        Label label9 = new Label("Breed:");
        label9.setLayoutY(315);
        label9.setLayoutX(100);
        aBreed = new ComboBox();
        aBreed.setLayoutY(310);
        aBreed.setLayoutX(160);
        aBreed.setPrefWidth(150);

        Label label10 = new Label("Animal Type:");
        label10.setLayoutY(345);
        label10.setLayoutX(100);
        aType = new ComboBox();
        aType.setLayoutY(340);
        aType.setLayoutX(180);
        aType.setPrefWidth(130);

        Label label11 = new Label("Date Lost:");
        label11.setLayoutY(255);
        label11.setLayoutX(380);

        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutY(250);
        datePicker.setLayoutX(450);

        Label label12 = new Label("Gender:"); 
        label12.setLayoutY(295);
        label12.setLayoutX(380);
        lGender = new ComboBox();
        lGender.setLayoutY(290);
        lGender.setLayoutX(450);
        lGender.getItems().addAll("Male", "Female");

        /*ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Male");
        button1.setToggleGroup(group);
        //button1.setSelected(true);
        RadioButton button2 = new RadioButton("Female");
        button2.setToggleGroup(group);
        button1.setLayoutY(295);
        button1.setLayoutX(470);
        button2.setLayoutY(295);
        button2.setLayoutX(530);*/

        Label label13 = new Label("Description:");
        label13.setLayoutY(330);
        label13.setLayoutX(380);

        descArea = new TextField();
        descArea.setLayoutY(330);
        descArea.setLayoutX(460);

        Button buttonUpload = new Button("Upload Image");
        buttonUpload.setLayoutY(375);
        buttonUpload.setLayoutX(100);
        buttonUpload.setPrefWidth(210);

        Label label24 = new Label("Location:");
        label24.setLayoutY(375);
        label24.setLayoutX(380);

        lostLocation = new ComboBox();
        lostLocation.setLayoutY(370);
        lostLocation.setLayoutX(460);
        lostLocation.setPrefWidth(110);

        Button buttonLostSubmit = new Button("Submit to Lost");
        buttonLostSubmit.setLayoutY(500);
        buttonLostSubmit.setLayoutX(350);
        buttonLostSubmit.setPrefWidth(250);
        buttonLostSubmit.setPrefHeight(50);

        /*String gender = "";
        if(button1.isSelected() && !button2.isSelected()) {
        gender = "Female"; 
        }
        else if(button2.isSelected() && !button1.isSelected()) {
        gender = "Male";
        }*/

        //boolean bvar = Boolean.parseBoolean(gender);

        ObservableList lostInfo = FXCollections.observableArrayList();
        tableLost = new TableView(lostInfo);
        tableLost.setEditable(false);

        TableColumn<Animal,String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(60);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("oName"));
        TableColumn<Animal,String> addressNameCol = new TableColumn<>("Address");
        addressNameCol.setMinWidth(60);
        addressNameCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        TableColumn<Animal,String> phoneCol = new TableColumn<>("Phone");
        phoneCol.setMinWidth(60);
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
        TableColumn<Animal,String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(60);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Animal,String> aNameCol = new TableColumn<>("Animal Name");
        aNameCol.setMinWidth(90);
        aNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Animal,String> aAgeCol = new TableColumn<>("Animal Age");
        aAgeCol.setMinWidth(55);
        aAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Animal,String> aBreedCol = new TableColumn<>("Breed");
        aBreedCol.setMinWidth(55);
        aBreedCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        TableColumn<Animal,String> aAnimalCol = new TableColumn<>("Animal Type");
        aAnimalCol.setMinWidth(60);
        aAnimalCol.setCellValueFactory(new PropertyValueFactory<>("aType"));
        TableColumn<Animal,String> dateLostCol = new TableColumn<>("Date Lost");
        dateLostCol.setMinWidth(50);
        dateLostCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Animal,String> genderCol = new TableColumn<>("Gender");
        genderCol.setMinWidth(40);
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Animal,String> descCol = new TableColumn<>("Description");
        descCol.setMinWidth(90);
        descCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        tableLost.getColumns().addAll(nameCol, addressNameCol, phoneCol, emailCol, aNameCol, aAgeCol, aBreedCol, aAnimalCol, dateLostCol, genderCol, descCol);
        tableLost.setLayoutY(60);
        tableLost.setLayoutX(690);

        buttonLostSubmit.setOnAction((event) -> {
                boolean sex;
                if(lGender.getValue() == "Male") {
                    sex = true;
                }
                else {
                    sex = false;
                }
                Animal lostAnimal = new Animal(aAgeField.getText(), aType.getValue(), sex, descArea.getText(), aBreed.getValue(), aNameField.getText());
                Person ownerDetails = new Person(nameField.getText(), ageField.getText(), phoneField.getText(), emailField.getText());
                Lost lost = new Lost(datePicker.getValue(), addLocation.getText(), ownerDetails); 
                addLostTable(lostAnimal, ownerDetails, lost);
                fileOutputSerial(aList);
            });

        lAnimal = FXCollections.observableArrayList(aList.getLostAnimalList());
        tableLost.setItems(lAnimal);   

        Button buttonViewLost = new Button("View");
        buttonViewLost.setLayoutY(500);
        buttonViewLost.setLayoutX(690);
        buttonViewLost.setPrefWidth(100);

        Button buttonEditLost = new Button("Edit");
        buttonEditLost.setLayoutY(500);
        buttonEditLost.setLayoutX(810);
        buttonEditLost.setPrefWidth(100);

        Button buttonRemoveLost = new Button("Remove");
        buttonRemoveLost.setOnAction(event ->
                deleteButtonClicked()
        );

        buttonRemoveLost.setLayoutY(500);
        buttonRemoveLost.setLayoutX(930);
        buttonRemoveLost.setPrefWidth(100);

        anchorPaneTwo.getChildren().addAll(title, label1, nameField, label2, ageField, label3, phoneField, labelemail, emailField, titleAnimal, label4, aNameField, tableLost, label8, aAgeField, label9, aBreed, label10, aType, label11, datePicker, label12, lGender, label13, descArea, buttonUpload, buttonViewLost, buttonEditLost, buttonRemoveLost, label24, lostLocation, buttonLostSubmit);

        //Found Tab - Tab Three
        AnchorPane anchorPaneThree = new AnchorPane();
        Tab tabThree = new Tab();
        tabThree.setContent(anchorPaneThree);
        tabThree.setText("Found");
        tabPane.getTabs().add(tabThree);

        Label titleFAnimal = new Label("Animal Details");
        titleFAnimal.setLayoutY(20);
        titleFAnimal.setLayoutX(130);
        titleFAnimal.setFont(Font.font ("Verdana", 30));

        Label label14 = new Label("Name:");
        fNameField = new TextField();
        label14.setLayoutY(85);
        label14.setLayoutX(100);
        fNameField.setLayoutY(80);
        fNameField.setLayoutX(200);

        Label label15 = new Label("Age:");
        fAgeField = new TextField();
        label15.setLayoutY(115);
        label15.setLayoutX(100);
        fAgeField.setLayoutY(110);
        fAgeField.setLayoutX(200);

        Label label16 = new Label("Date Found:");
        label16.setLayoutY(145);
        label16.setLayoutX(100);
        DatePicker datePickerFound = new DatePicker();
        datePickerFound.setLayoutY(140);
        datePickerFound.setLayoutX(200);

        Label label17 = new Label("Upload Image:");
        label17.setLayoutY(175);
        label17.setLayoutX(100);
        Button buttonFoundUpload = new Button("Add Image");
        buttonFoundUpload.setLayoutY(170);
        buttonFoundUpload.setLayoutX(200);
        buttonFoundUpload.setPrefWidth(175);

        Label label18 = new Label("Gender:");
        label18.setLayoutY(210);
        label18.setLayoutX(100);
        fGender = new ComboBox();
        fGender.setLayoutY(205);
        fGender.setLayoutX(200);
        fGender.getItems().addAll("Male", "Female");

        /*ToggleGroup groupFound = new ToggleGroup();
        RadioButton button1F = new RadioButton("Male");
        button1.setToggleGroup(groupFound);
        //button1.setSelected(true);
        RadioButton button2F = new RadioButton("Female");
        button2F.setToggleGroup(group);
        button1F.setLayoutY(210);
        button1F.setLayoutX(200);
        button2F.setLayoutY(210);
        button2F.setLayoutX(280);*/

        Label label19 = new Label("Breed:");
        label19.setLayoutY(245);
        label19.setLayoutX(100);
        fBreed = new ComboBox();
        fBreed.setLayoutY(240);
        fBreed.setLayoutX(200);
        fBreed.setPrefWidth(175);

        Label label20 = new Label("Animal Type:");
        label20.setLayoutY(275);
        label20.setLayoutX(100);
        fType = new ComboBox();
        fType.setLayoutY(270);
        fType.setLayoutX(200);
        fType.setPrefWidth(175);

        Label label25 = new Label("Location:");
        label25.setLayoutY(325);
        label25.setLayoutX(100);

        foundLocation = new ComboBox();
        foundLocation.setLayoutY(320);
        foundLocation.setLayoutX(200);
        foundLocation.setPrefWidth(110);

        Button buttonAddToFound = new Button("Add to Found");
        buttonAddToFound.setLayoutY(360);
        buttonAddToFound.setLayoutX(100);
        buttonAddToFound.setPrefWidth(275);

        ObservableList foundInfo = FXCollections.observableArrayList();
        tableFound = new TableView(lostInfo);
        tableLost.setEditable(false);

        TableColumn<Animal,String> idFCol = new TableColumn<>("ID");
        idFCol.setMinWidth(30);
        idFCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn<Animal,String> nameFCol = new TableColumn<>("Name");
        nameFCol.setMinWidth(60);
        nameFCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Animal,String> ageFCol = new TableColumn<>("Age");
        ageFCol.setMinWidth(60);
        ageFCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Animal,String> dateFoundCol = new TableColumn<>("Date Found");
        dateFoundCol.setMinWidth(60);
        dateFoundCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TableColumn<Animal,String> aAnimalFCol = new TableColumn<>("Animal Type");
        aAnimalFCol.setMinWidth(80);
        aAnimalFCol.setCellValueFactory(new PropertyValueFactory<>("aType"));
        TableColumn<Animal,String> aBreedFCol = new TableColumn<>("Breed");
        aBreedFCol.setMinWidth(60);
        aBreedFCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        TableColumn<Animal,String> genderFCol = new TableColumn<>("Gender");
        genderFCol.setMinWidth(60);
        genderFCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        TableColumn<Animal,String> descFCol = new TableColumn<>("Description");
        descFCol.setMinWidth(100);
        descFCol.setCellValueFactory(new PropertyValueFactory<>("description"));     
        tableFound.getColumns().addAll(idFCol, nameFCol, ageFCol, aAnimalFCol, aBreedFCol, dateFoundCol, genderFCol, descFCol);
        tableFound.setLayoutY(60);
        tableFound.setLayoutX(600);

        buttonAddToFound.setOnAction((event) -> {
                boolean sex;
                if(fGender.getValue() == "Male") {
                    sex = true;
                }
                else {
                    sex = false;
                }
                Animal foundAnimal = new Animal(fNameField.getText(), fAgeField.getText(), sex, fBreed.getValue(), fType.getValue());
                Person ownerDetails = new Person(nameField.getText(), ageField.getText(), phoneField.getText(), emailField.getText());
                Found found = new Found(datePicker.getValue(), addLocation.getText(), ownerDetails); 
                addFoundTable(foundAnimal, ownerDetails, found);
                fileOutputSerial(aList);
            });

        fAnimal = FXCollections.observableArrayList(aList.getFoundAnimalList());
        tableFound.setItems(fAnimal);

        Button buttonViewFound = new Button("View");
        buttonViewFound.setLayoutY(500);
        buttonViewFound.setLayoutX(600);
        buttonViewFound.setPrefWidth(100);

        Button buttonEditFound = new Button("Edit");
        buttonEditFound.setLayoutY(500);
        buttonEditFound.setLayoutX(720);
        buttonEditFound.setPrefWidth(100);

        Button buttonRemoveFound = new Button("Remove");
        buttonRemoveFound.setOnAction(event ->
                fdeleteButtonClicked()
        );

        buttonRemoveFound.setLayoutY(500);
        buttonRemoveFound.setLayoutX(840);
        buttonRemoveFound.setPrefWidth(100);

        anchorPaneThree.getChildren().addAll(titleFAnimal, label14, fNameField, label15, fAgeField, label16, datePickerFound, label17, buttonFoundUpload, label18, fGender, label19, fBreed, label20, fType, buttonAddToFound, tableFound, buttonViewFound, buttonEditFound, label25, foundLocation, buttonRemoveFound);

        //Adopt Tab - Tab Four
        AnchorPane anchorPaneFive = new AnchorPane();
        Tab tabFive = new Tab();
        tabFive.setContent(anchorPaneFive);
        tabFive.setText("Adopt");
        tabPane.getTabs().add(tabFive);

        ObservableList adoptInfo = FXCollections.observableArrayList();
        TableView tableAdopt = new TableView(lostInfo);
        tableLost.setEditable(false);
        TableColumn aAdoptNameCol = new TableColumn("Animal Name");
        TableColumn aAdoptAgeCol = new TableColumn("Age");
        TableColumn aAdoptGenderCol = new TableColumn("Gender"); 
        TableColumn aAdoptTypeCol = new TableColumn("Animal Type");
        TableColumn aAdoptBreedCol = new TableColumn("Breed");
        TableColumn aAdoptDecriptionCol = new TableColumn("Description");

        tableAdopt.getColumns().addAll(aAdoptNameCol, aAdoptAgeCol, aAdoptGenderCol, aAdoptTypeCol, aAdoptBreedCol, aAdoptDecriptionCol);
        tableAdopt.setLayoutY(60);
        tableAdopt.setLayoutX(200);
        tableAdopt.setPrefWidth(1000);

        Button buttonViewAdopt = new Button("View");
        buttonViewAdopt.setLayoutY(500);
        buttonViewAdopt.setLayoutX(200);
        buttonViewAdopt.setPrefWidth(150);

        Button buttonAdopt = new Button("Adopt");
        buttonAdopt.setLayoutY(500);
        buttonAdopt.setLayoutX(370);
        buttonAdopt.setPrefWidth(150);

        anchorPaneFive.getChildren().addAll(tableAdopt, buttonViewAdopt, buttonAdopt);

        //Reports Tab - Tab Five
        AnchorPane anchorPaneSix = new AnchorPane();
        Tab tabSix = new Tab();
        tabSix.setContent(anchorPaneSix);
        tabSix.setText("Reports");
        tabPane.getTabs().add(tabSix);

        Label label26 = new Label("Choose Location");
        label26.setLayoutY(60);
        label26.setLayoutX(100);

        rLocation = new ComboBox();
        rLocation.setLayoutY(60);
        rLocation.setLayoutX(200);
        rLocation.setPrefWidth(110);

        anchorPaneSix.getChildren().addAll(label26, rLocation);

        //Tab - Maintenance
        AnchorPane anchorPaneSeven= new AnchorPane();
        Tab tabSeven = new Tab();
        tabSeven.setContent(anchorPaneSeven);
        tabSeven.setText("Maintenance");
        tabPane.getTabs().add(tabSeven);

        Label label5 = new Label("Add Animal Type:");
        addType = new TextField();
        label5.setLayoutY(65);
        label5.setLayoutX(60);
        addType.setLayoutY(60);
        addType.setLayoutX(165);

        Label label6 = new Label("Add Animal Breed:");
        addBreed = new TextField();
        label6.setLayoutY(135);
        label6.setLayoutX(60);
        addBreed.setLayoutY(130);
        addBreed.setLayoutX(165);

        Label label7 = new Label("Add Location:");
        addLocation = new TextField();
        label7.setLayoutY(65);
        label7.setLayoutX(750);
        addLocation.setLayoutY(60);
        addLocation.setLayoutX(840);

        listViewType = new ListView<String>(types);
        listViewType.setLayoutY(60);
        listViewType.setLayoutX(440);
        listViewType.setPrefWidth(120);
        listViewType.setPrefHeight(300);

        listViewBreed = new ListView<String>(breeds);
        listViewBreed.setLayoutY(60);
        listViewBreed.setLayoutX(600);
        listViewBreed.setPrefWidth(120);
        listViewBreed.setPrefHeight(300);

        listViewLocation = new ListView<String>(locations);
        listViewLocation.setLayoutY(60);
        listViewLocation.setLayoutX(1000);
        listViewLocation.setPrefWidth(120);
        listViewLocation.setPrefHeight(300);

        Button buttonLocation = new Button("Add Location");
        buttonLocation.setLayoutY(90);
        buttonLocation.setLayoutX(840);

        buttonLocation.setOnAction((event) -> {
                addLocation(addLocation.getText());
                fileWriteLocations();
            });

        Type = new ComboBox();
        Type.setLayoutY(60);
        Type.setLayoutX(320);
        Type.setPrefWidth(110);

        Button buttonType = new Button("Add Type");
        buttonType.setLayoutY(90);
        buttonType.setLayoutX(165);

        buttonType.setOnAction((event) -> {
                addType(addType.getText());
                fileWriteTypes();
            });

        Breed = new ComboBox();
        Breed.setLayoutY(130);
        Breed.setLayoutX(320);
        Breed.setPrefWidth(110);

        Button buttonBreed = new Button("Add Breed");
        buttonBreed.setLayoutY(160);
        buttonBreed.setLayoutX(165);

        buttonBreed.setOnAction((event) -> {
                addBreed(addBreed.getText());
                fileWriteBreeds();
            });

        anchorPaneSeven.getChildren().addAll(label5, addType, label6, addBreed, listViewType, listViewBreed, buttonType, buttonBreed, Type, Breed, listViewLocation, buttonLocation, label7, addLocation);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        fileLoadTypes();
        fileLoadBreeds();
        fileLoadLocations();

        //Sets the Scene's size and makes it visable
        layout = new AnchorPane(); 
        layout.getChildren().addAll(tabPane, menuBar);
        layout.setTopAnchor(tabPane, 25.0);        
        layout.setRightAnchor(tabPane, 0.0);        
        layout.setLeftAnchor(tabPane, 0.0);
        layout.setRightAnchor(menuBar, 0.0); 
        layout.setLeftAnchor(menuBar, 0.0);
        Scene scene = new Scene(layout, 400, 300);
        window.setScene(scene);
        window.show();

        window.setMaximized(true);
    }

    public static void fileOutputSerial(AnimalList aList) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("animal-list.txt"));
            output.writeObject(aList);
            output.flush();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    public static void fileInputSerial() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("animal-list.txt"));
            aList = (AnimalList)input.readObject();
            input.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
        catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void fileWriteTypes() {
        try {
            PrintWriter dataFile = new PrintWriter("Animal-Types.txt");
            dataFile.println(types);
            dataFile.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void fileLoadTypes() {
        try {
            File file = new File("Animal-Types.txt");
            Scanner keyboard = new Scanner(file);
            addType(keyboard.nextLine());
            keyboard.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void fileWriteBreeds() {
        try {
            PrintWriter dataFile = new PrintWriter("Animal-Breeds.txt");
            dataFile.println(breeds);
            dataFile.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void fileLoadBreeds() {
        try {
            File file = new File("Animal-Breeds.txt");
            Scanner keyboard = new Scanner(file);
            addBreed(keyboard.nextLine());
            keyboard.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void fileWriteLocations() {
        try {
            PrintWriter dataFile = new PrintWriter("Animal-Locations.txt");
            dataFile.println(locations);
            dataFile.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void fileLoadLocations() {
        try {
            File file = new File("Animal-Locations.txt");
            Scanner keyboard = new Scanner(file);
            addLocation(keyboard.nextLine());
            keyboard.close();
        }
        catch(Exception ex) {
            System.out.println("File does not exist!");
        }
    }

    public void addLostTable(Animal lostAnimal, Person ownerDetails, Lost lost) {
        lostAnimal.setAnimalCat(lost);
        aList.add(lostAnimal); 
        lAnimal = FXCollections.observableArrayList(aList.getLostAnimalList());
        tableLost.setItems(lAnimal);
    }

    public void addFoundTable(Animal foundAnimal, Person ownerDetails, Found found) {
        foundAnimal.setAnimalCat(found);
        aList.add(foundAnimal); 
        fAnimal = FXCollections.observableArrayList(aList.getFoundAnimalList());
        tableFound.setItems(fAnimal);
    }

    public void addLocation(String location) {
        //Breed.getItems().addAll(breed);
        listViewLocation.getItems().addAll(location);
        lostLocation.getItems().addAll(location);
        foundLocation.getItems().addAll(location);
        rLocation.getItems().addAll(location);
        addLocation.clear();
    }

    public void addBreed(String breed) {
        Breed.getItems().addAll(breed);
        aBreed.getItems().addAll(breed);
        fBreed.getItems().addAll(breed);
        listViewBreed.getItems().addAll(breed);
        addBreed.clear();
    }

    public void addType(String type) {
        Type.getItems().addAll(type);
        aType.getItems().addAll(type);
        fType.getItems().addAll(type);
        listViewType.getItems().addAll(type);
        addType.clear();
    }

    public void deleteButtonClicked(){
        ObservableList<Animal> animalSelected, allAnimals;
        allAnimals = tableLost.getItems();
        animalSelected = tableLost.getSelectionModel().getSelectedItems();
        animalSelected.forEach(allAnimals::remove);
    }

    public void fdeleteButtonClicked(){
        ObservableList<Animal> animalSelected, allAnimals;
        allAnimals = tableFound.getItems();
        animalSelected = tableFound.getSelectionModel().getSelectedItems();
        animalSelected.forEach(allAnimals::remove);
    }
}