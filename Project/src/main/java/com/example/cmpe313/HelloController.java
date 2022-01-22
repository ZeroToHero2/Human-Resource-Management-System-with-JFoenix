package com.example.cmpe313;

import java.io.*;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelloController implements Initializable {
    public static final String INVENTORYURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Inventory.txt";
    public static final String DEPARTMENTURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Department.txt";
    public static final String EDUCATIONURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Education.txt";
    public static final String EMPLOYEEURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\EmployeeNames.txt";
    public static final String EXAMURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Exam.txt";
    public static final String LECTUREURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Lecture.txt";
    public static final String CERTIFICATEURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\Certificate.txt";
    public static final String ENTRUSTEDGADGETURL = "C:\\Users\\BAHADIR\\Desktop\\CMPE 313\\Term project\\CMPE EnSON\\src\\main\\java\\com\\example\\cmpe313\\database\\entrustedGadgets.txt";
    static Scanner scan;


    public static List<String> reader(String url) {
        List<String> inputList = new ArrayList<String>();//hata düzeltimi

        try {
            scan = new Scanner(new File(url));
            while (scan.hasNextLine()) {
                String input = scan.nextLine();

                inputList.add(input);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    @FXML
    ListView<String> inventoryList;
    @FXML
    ListView<String> certificateList;
    @FXML
    ListView<String> lessonList;
    @FXML
    ListView<String> educationsList;
    @FXML
    TextField departmentName;
    @FXML
    TextField departmentBudget;
    @FXML
    TextField employeeOfDepartment;
    @FXML
    TextField surnameOfEmployee;
    @FXML
    TextField nameOfEmployee;
    @FXML
    TextField phoneNumberEmployee;
    @FXML
    TextField salaryOfEmployee;
    @FXML
    TextField emailOfEmployee;
    @FXML
    TextField wantedGadgetName;
    @FXML
    TextField wantedGadgetPrice;
    @FXML
    TextField wantedGadgetUsageReason;
    @FXML
    TextField speicalNotesForWantedGadget;
    @FXML
    Button confirmBudgetChange;
    @FXML
    Button confirmSalaryButton;
    @FXML
    JFXTextField newSalary;
    @FXML
    JFXTextField newBudget;
    @FXML
    TableView<Employee> employeeList1;
    @FXML
    TableColumn<Employee, String> nameList1;
    @FXML
    TableColumn<Employee, String> surnameList1;
    @FXML
    TableColumn<Employee, String> contactInfo1;
    @FXML
    TableView<Employee> employeeList2;
    @FXML
    TableColumn<Employee, String> nameList2;
    @FXML
    TableColumn<Employee, String> surnameList2;
    @FXML
    TableColumn<Employee, String> salaryList2;
    @FXML
    TableView<Employee> employeeList3;
    @FXML
    TableColumn<Employee, String> nameList3;
    @FXML
    TableColumn<Employee, String> surnameList3;
    @FXML
    TableColumn<Employee, String> salaryList3;
    @FXML
    TableColumn<Employee, String> phoneNumberList3;
    @FXML
    TableColumn<Employee, String> eMailList3;
    @FXML
    TableView<Department> departmantList1;
    @FXML
    TableColumn<Department, String> dNameList1;
    @FXML
    TableColumn<Department, String> numberOfWorker1;
    @FXML
    TableColumn<Department, String> budgetList1;
    @FXML
    TableView<Department> departmantList2;
    @FXML
    TableColumn<Department, String> dNameList2;
    @FXML
    TableColumn<Department, String> numberOfWorker2;
    @FXML
    TableColumn<Department, String> budgetList2;
    @FXML
    TableView<Employee> employeeList4;
    @FXML
    TableColumn<Employee, String> nameList4;
    @FXML
    TableColumn<Employee, String> surnameList4;
    @FXML
    TableColumn<Employee, String> contactInfo4;
    @FXML
    ListView<String> entrustedGadgetList;
    @FXML
    TextField selectGadgetEmployee;
    @FXML
    JFXDatePicker date;
    @FXML
    TextField educationThatWeWantToAdd;
    @FXML
    TextField newExam;
    @FXML
    TableView<Exam> examList1;
    @FXML
    TableView<Exam> examList2;
    @FXML
    TableColumn<Exam, String> examName1;
    @FXML
    TableColumn<Exam, Double> minimumPassingGrade1;
    @FXML
    TableColumn<Exam, String> examName2;
    @FXML
    TableColumn<Exam, Double> minimumPassingGrade2;
    @FXML
    TableColumn<Exam, Double> gradeOfEmployee;
    @FXML
    TextField nameOfExam;
    @FXML
    TextField passGradeOfExam;
    @FXML
    JFXComboBox<String> placeForExam;
    @FXML
    JFXDatePicker examDate;
    @FXML
    JFXTextField promotions;
    @FXML
    TableColumn<Employee, Double> newPromotion;
    @FXML
    TextField grade;
    @FXML
    private TableView<Employee> lastList;

    @FXML
    private TableColumn<Employee, String> lastNameList;

    @FXML
    private TableColumn<Employee, String> lastSurnameList;

    @FXML
    private TableColumn<Employee, String> lastEmailList;

    @FXML
    private TableColumn<Employee, String> lastPhoneNumberList;

    @FXML
    private TableColumn<Employee, String> lastSalaryList;

    @FXML
    private TableColumn<Employee, String> lastPromotionList;

    ObservableList<Employee> emplyeeList = FXCollections.observableArrayList();
    ObservableList<Department> departmantList = FXCollections.observableArrayList();
    ObservableList<Exam> doneExamList = FXCollections.observableArrayList();
    ObservableList<Exam> unDoneExamList = FXCollections.observableArrayList();

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void warningPopUp(String pop) {
        Stage window = new Stage();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setTitle("Warning");
        a.setHeaderText("Warning");
        a.setContentText(pop);
        a.show();
        /*Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Warning!");
        window.setMinWidth(250);
        Label text = new Label();
        text.setText(pop);
        text.setAlignment(Pos.CENTER);
        VBox box = new VBox();
        box.getChildren().add(text);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box, 400, 100);
        Scene scene = new Scene(box, 400, 100);
        window.setScene(scene);
        window.show();*/
    }

    public static void confirmationPopUp(String pop) {
        Stage window = new Stage();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setTitle("Message");
        a.setHeaderText("System Message:");
        a.setContentText(pop);
        a.show();
      /*  window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Warning!");
        window.setMinWidth(250);
        Label text = new Label();
        text.setText(pop);
        text.setAlignment(Pos.CENTER);
        VBox box = new VBox();
        box.getChildren().add(text);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box, 400, 100);
        window.setScene(scene);
        window.show();*/
    }

    public static void AreYouSurePopUp(String pop) {
        Stage window = new Stage();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation");
        a.setHeaderText("Are You sure?");
        a.setContentText(pop);
        a.show();
    }

    public static void ErrorPopUp(String pop) {
        Stage window = new Stage();
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText("An Error Occured");
        a.setContentText(pop);
        a.show();
    }

    public List<Inventory> fillInventoryList() {

        List<Inventory> list = new ArrayList<Inventory>();
        List<String> returnedList = reader(INVENTORYURL);

        for (int i = 0; i < returnedList.size(); i++) {

            list.add(new Inventory(returnedList.get(i)));
        }
        return list;
    }

    public void fillEmployeeList() {
        List<String> returnedList = reader(EMPLOYEEURL);
        System.out.println(returnedList.size());
        for (int i = 0; i < returnedList.size(); i++) {
            String[] input = returnedList.get(i).split(" ");
            Employee x = new Employee(input[0], input[1], input[2], input[3], input[4]);
            emplyeeList.add(x);
        }

    }

    public void fillDepartmenList() {
        List<String> returnedList = reader(DEPARTMENTURL);
        for (int i = 0; i < returnedList.size(); i++) {
            String[] input = returnedList.get(i).split(" ");

            Department x = new Department(input[0], input[1], input[2]);
            departmantList.add(x);
        }
    }

    public List<String> fillCertificateList() {
        List<String> returnedList = reader(CERTIFICATEURL);
        return returnedList;
    }

    public List<String> fillEducationList() {
        List<String> returnedList = reader(EDUCATIONURL);
        return returnedList;
    }

    public List<String> fillLessonList() {
        List<String> returnedList = reader(LECTUREURL);
        return returnedList;
    }

    public List<String> fillEntrustedGadget() {
        List<String> list = reader(ENTRUSTEDGADGETURL);
        return list;
    }

    public void fillExamList() {
        List<String> returnedList = reader(EXAMURL);
        for (int i = 0; i < returnedList.size(); i++) {
            String[] input = returnedList.get(i).split(" ");

            if (input[1].equals("-1")) {
                int grade = Integer.parseInt(input[1]);
                int pass = Integer.parseInt(input[2]);

                Exam x = new Exam(input[0], grade, pass);
                unDoneExamList.add(x);
            } else {
                int grade = Integer.parseInt(input[1]);
                int pass = Integer.parseInt(input[2]);

                Exam x = new Exam(input[0], grade, pass);
                doneExamList.add(x);
            }
        }
    }

    //private double x = 0, y = 0;
    @FXML
    private AnchorPane sideBar;

    public void initialize(URL arg0, ResourceBundle arg1) {

        String places[] = {"IELTS/Ankara", "CCNA", "Meeting Room"};
        placeForExam.getItems().addAll(places);

        nameList1.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        surnameList1.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        contactInfo1.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));

        nameList2.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        surnameList2.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        salaryList2.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));

        dNameList1.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        budgetList1.setCellValueFactory(new PropertyValueFactory<Department, String>("budgetOfDeparment"));
        numberOfWorker1.setCellValueFactory(new PropertyValueFactory<Department, String>("numberOfEmployee"));

        dNameList2.setCellValueFactory(new PropertyValueFactory<Department, String>("name"));
        budgetList2.setCellValueFactory(new PropertyValueFactory<Department, String>("budgetOfDeparment"));
        numberOfWorker2.setCellValueFactory(new PropertyValueFactory<Department, String>("numberOfEmployee"));

        nameList3.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        surnameList3.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        salaryList3.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        phoneNumberList3.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        eMailList3.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));

        nameList4.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        surnameList4.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        contactInfo4.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));

        examName1.setCellValueFactory(new PropertyValueFactory<Exam, String>("examName"));
        minimumPassingGrade1.setCellValueFactory(new PropertyValueFactory<Exam, Double>("passGrade"));
        examName2.setCellValueFactory(new PropertyValueFactory<Exam, String>("examName"));
        minimumPassingGrade2.setCellValueFactory(new PropertyValueFactory<Exam, Double>("passGrade"));
        gradeOfEmployee.setCellValueFactory(new PropertyValueFactory<Exam, Double>("gainedGrade"));

        newPromotion.setCellValueFactory(new PropertyValueFactory<Employee, Double>("promotion"));

        lastNameList.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        lastSurnameList.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        lastSalaryList.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        lastPhoneNumberList.setCellValueFactory(new PropertyValueFactory<Employee, String>("phoneNumber"));
        lastEmailList.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        lastPromotionList.setCellValueFactory(new PropertyValueFactory<Employee, String>("promotion"));
        List<Inventory> inventoryList1 = fillInventoryList();
        for (int i = 0; i < inventoryList1.size(); i++)
            inventoryList.getItems().add(inventoryList1.get(i).gadgetName);

        fillEmployeeList();
        employeeList1.setItems(emplyeeList);
        employeeList2.setItems(emplyeeList);
        employeeList3.setItems(emplyeeList);
        employeeList4.setItems(emplyeeList);
        lastList.setItems(emplyeeList);

        fillDepartmenList();
        departmantList1.setItems(departmantList);
        departmantList2.setItems(departmantList);

        fillExamList();
        examList1.setItems(unDoneExamList);
        examList2.setItems(doneExamList);
        List<String> certificateList1 = fillCertificateList();
        for (int m = 0; certificateList1.size() > m; m++) {
            certificateList.getItems().add(certificateList1.get(m));
        }
        List<String> lessonList1 = fillCertificateList();
        for (int m = 0; lessonList1.size() > m; m++) {
            lessonList.getItems().add(lessonList1.get(m));
        }
        List<String> educationsList1 = fillEducationList();
        for (int m = 0; educationsList1.size() > m; m++) {
            educationsList.getItems().add(educationsList1.get(m));
        }
        List<String> entrustedGadgetList1 = fillEntrustedGadget();
        for (int m = 0; entrustedGadgetList1.size() > m; m++) {
            entrustedGadgetList.getItems().add(entrustedGadgetList1.get(m));
        }
    }

    public void addEmployee(ActionEvent e) {
        System.out.println("Employee Added");
        String name = "";
        String surname = "";
        String salary = "";
        String phoneNumber = "";
        String email = "";

        name = nameOfEmployee.getText();
        surname = surnameOfEmployee.getText();
        salary = salaryOfEmployee.getText();
        phoneNumber = phoneNumberEmployee.getText();
        email = emailOfEmployee.getText();

        if (!name.equals("") && !surname.equals("") && !salary.equals("") && !phoneNumber.equals("") && !email.equals("")) {
            try {
                int m = Integer.parseInt(salary);
                int l = Integer.parseInt(phoneNumber);
                Employee emp = new Employee(name, surname, salary, phoneNumber, email);
                emplyeeList.add(emp);
            } catch (Exception B) {
                ErrorPopUp("Please be sure that phoneNumber and salary are numeric!");
            }

        } else {
            warningPopUp("Please be sure that you filled all the parts!");
        }


    }

    public void deleteEmployee(ActionEvent e) {

        boolean control = false;
        for (int m = 0; employeeList3.getItems().size() > m; m++) {
            if (employeeList3.getSelectionModel().isSelected(m) == true) control = true;
        }
        if (control) {
            System.out.println("Employee Deleted");
            Employee unwanted = employeeList3.getSelectionModel().getSelectedItem();
            emplyeeList.remove(unwanted);
        } else {
            warningPopUp("Please select a Employee to Delete");
        }

    }


    @FXML
    public void addDepartment(ActionEvent e) {
        System.out.println("Department Added");
        String name = "";
        String Budget = "";
        String EmployeeNumber = "";

        name = departmentName.getText();
        Budget = departmentBudget.getText();
        EmployeeNumber = employeeOfDepartment.getText();

        if ((!name.equals("") && !Budget.equals("") && !EmployeeNumber.equals(""))) {
            try {
                int m = Integer.parseInt(Budget);
                int l = Integer.parseInt(EmployeeNumber);
                Department dep = new Department(name, Budget, EmployeeNumber);
                departmantList.add(dep);
            } catch (Exception a) {
                ErrorPopUp("Please be sure that Budget and employee number are numeric!");
            }
        } else {
            warningPopUp("Please fill all the parts!");
        }


    }

    @FXML
    public void deleteDepartment(ActionEvent e) {
        boolean control = false;
        for (int m = 0; departmantList2.getItems().size() > m; m++) {
            if (departmantList2.getSelectionModel().isSelected(m) == true) {
                control = true;
            }
        }
        if (control) {
            System.out.println("Employee Deleted");
            Department unwanted = departmantList2.getSelectionModel().getSelectedItem();
            departmantList.remove(unwanted);
        } else {
            warningPopUp("Please select a Departmant to Delete");
        }

    }

    @FXML
    public void popForInventoryManagment() {
        String name = wantedGadgetName.getText();
        String budget = wantedGadgetPrice.getText();
        String reson = wantedGadgetUsageReason.getText();
        String note = speicalNotesForWantedGadget.getText();

        if (!name.equals("") && !budget.equals("") && !reson.equals("") && !note.equals("")) {
            try {
                ///POP UP YAPPPPP...
                int s = Integer.parseInt(budget);
                Stage window = new Stage();

                window.initModality(Modality.APPLICATION_MODAL);
                window.setTitle("Confirming Request");

                window.setMinWidth(250);
                Label text = new Label();
                text.setText("You are requesting a gadget. Are you sure?");
                text.setAlignment(Pos.CENTER);
                Button buttonYes = new Button("Yes");

                Button buttonNo = new Button("No");
                buttonNo.setOnAction(e -> window.close());
                buttonYes.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent actionEvent) {
                        wantedGadgetName.setText("");
                        wantedGadgetPrice.setText("");
                        wantedGadgetUsageReason.setText("");
                        speicalNotesForWantedGadget.setText("");
                        window.close();
                    }
                });
                VBox inside = new VBox();
                HBox deep = new HBox();
                deep.getChildren().addAll(buttonYes, buttonNo);

                deep.setMargin(deep.getChildren().get(0), new Insets(10, 10, 10, 10));
                deep.setMargin(deep.getChildren().get(1), new Insets(10, 10, 10, 10));

                deep.setHgrow(deep.getChildren().get(0), Priority.ALWAYS);
                deep.setHgrow(deep.getChildren().get(1), Priority.ALWAYS);

                inside.getChildren().addAll(text, deep);

                inside.setMargin(inside.getChildren().get(0), new Insets(10, 10, 10, 10));

                inside.setVgrow(inside.getChildren().get(0), Priority.ALWAYS);
                inside.setVgrow(inside.getChildren().get(1), Priority.ALWAYS);

                inside.setAlignment(Pos.CENTER);
                deep.setAlignment(Pos.CENTER);
                Scene scene = new Scene(inside, 400, 100);
                window.setScene(scene);
                window.show();
            } catch (Exception b) {
                ErrorPopUp("Please be sure that budget is numeric");
            }

        } else {
            warningPopUp("Please be sure that all parts of the gadget request were done!");
        }
    }

    @FXML
    public void confirmSalary() {
        String theNewSalary = newSalary.getText();

        boolean control = false;
        for (int m = 0; employeeList2.getItems().size() > m; m++) {
            if (employeeList2.getSelectionModel().isSelected(m) == true) control = true;
        }
        System.out.println(control);
        if (theNewSalary.equals("") && control) {
            AreYouSurePopUp("You didn't enter the salary that you want to change.");

        } else if (control) {
            try {
                //Deneme kısmı olmazsa catchlicek.
                int m = Integer.parseInt(theNewSalary);

                int employee = employeeList2.getSelectionModel().getFocusedIndex();
                System.out.println(employee);
                emplyeeList.get(employee).setSalary(theNewSalary + "TL");
                System.out.println(emplyeeList.get(employee).getSalary());
                employeeList1.refresh();
                employeeList2.refresh();
                employeeList3.refresh();
                employeeList4.refresh();
                lastList.refresh();
            } catch (Exception e) {
                ErrorPopUp("You must enter a number!");
            }
        } else {
            warningPopUp("Please Select an Employee!");
        }

        System.out.println("Salary");
    }

    @FXML
    public void confirmBudget() {
        String theNewBudget = newBudget.getText();
        System.out.println(theNewBudget);
        boolean control = false;
        for (int m = 0; departmantList1.getItems().size() > m; m++) {
            if (departmantList1.getSelectionModel().isSelected(m) == true) control = true;
        }
        if (theNewBudget.equals("") && control) {
            warningPopUp("You didn't enter the budget that you want to change.");

        } else if (control) {
            try {
                int m = Integer.parseInt(theNewBudget);

                int employee = departmantList1.getSelectionModel().getFocusedIndex();
                System.out.println(employee);
                departmantList.get(employee).setBudgetOfDeparment(theNewBudget + "TL");
                System.out.println(departmantList.get(employee).getBudgetOfDeparment());
                departmantList1.refresh();
                departmantList2.refresh();
            } catch (Exception e) {
                ErrorPopUp("You must enter a number!");
            }
        } else {
            warningPopUp("Please select a Departmant");
        }
        System.out.println("Salary");
        System.out.println("Budget");
    }


    @FXML
    public void confirmPromotion() {

        Employee emp = employeeList2.getSelectionModel().getSelectedItem();

        if (emp != null) {
            try {
                double prom = Double.parseDouble(promotions.getText());

                emplyeeList.get(employeeList2.getSelectionModel().getSelectedIndex()).setPromotion(promotions.getText() + " TL");
                employeeList2.refresh();
                employeeList1.refresh();
                employeeList4.refresh();
                employeeList3.refresh();
                lastList.refresh();

            } catch (Exception dd) {
                ErrorPopUp("Please be sure that you entered the promotion numeric!");

            }
        } else {
            warningPopUp("Please select an employee!");
        }

    }


    @FXML
    public void regivingEntrustedGadget() {
        String selected = entrustedGadgetList.getSelectionModel().getSelectedItem();
        boolean isSelected = false;
        for (int m = 0; entrustedGadgetList.getItems().size() > m; m++) {
            if (entrustedGadgetList.getItems().get(m).equals(selected)) {
                entrustedGadgetList.getItems().remove(m);
                isSelected = true;
                break;
            }
        }
        if (!isSelected) {
            warningPopUp("Please Select a Gadget to Reclaim it.");
        }
    }

    @FXML
    public void entrustingGadget() {
        String chosenGadget = inventoryList.getSelectionModel().getSelectedItem();
        String mail = selectGadgetEmployee.getText();

        LocalDate dateOfDeadLine = date.getValue();

        if ((!mail.equals("")) && (!chosenGadget.equals("")) && (!dateOfDeadLine.equals(""))) {
            inventoryList.getItems().remove(inventoryList.getSelectionModel().getSelectedIndex());

        } else {
            AreYouSurePopUp("Please be sure that you chosed gadget and date.\nAlso be sure that you entered your e-mail");
        }
    }

    @FXML
    public void assignEducation() {
        Employee chosen = employeeList4.getSelectionModel().getSelectedItem();
        String education = educationsList.getSelectionModel().getSelectedItem();

        if ((chosen != null) && (education != null)) {

            educationsList.getItems().remove(educationsList.getSelectionModel().getSelectedIndex());


        } else if (education != null) {
            warningPopUp("Please choose an Employee!");
        } else if (chosen != null && (educationsList.getItems().size() != 0)) {
            warningPopUp("Please choose an Education!");
        } else if (educationsList.getItems().size() != 0) {
            warningPopUp("Please select employee and the education that you want to assign");
        } else {
            ErrorPopUp("All educations are finished. Please add education to HRM.");
        }

    }

    @FXML
    public void addEducation() {

        String education = educationThatWeWantToAdd.getText();

        if (education.equals("")) {
            warningPopUp("Please enter an education!");
        } else {
            educationsList.getItems().add(education);
        }
    }

    @FXML
    public void addExam() {
        String name = nameOfExam.getText();
        String minimumPassingGrade = passGradeOfExam.getText();
        if (!name.equals("") && !minimumPassingGrade.equals("")) {
            try {
                double min = Double.parseDouble(minimumPassingGrade);

                Exam x = new Exam(name, min);
                unDoneExamList.add(x);
                examList1.refresh();
                examList2.refresh();
            } catch (Exception c) {
                warningPopUp("Be sure that you entered passing grade a numeric number!");
            }

        } else {
            ErrorPopUp("Fill all exam informations!");
            //  warningPopUp("Fill all exam informations!");
        }
    }

    @FXML
    public void assignExam() {
        Exam exam = examList1.getSelectionModel().getSelectedItem();
        Employee employee = employeeList1.getSelectionModel().getSelectedItem();

        String place = placeForExam.getValue();
        if (examDate.getValue() != null) {
            int year = examDate.getValue().getYear();
            int month = examDate.getValue().getMonthValue();
            int day = examDate.getValue().getDayOfMonth();
        }


        if ((exam != null) && (employee != null) && (examDate.getValue() != null) && (!place.equals("")) && (!place.equals("Place"))) {

            unDoneExamList.remove(exam);

        } else if (exam == null) {
            warningPopUp("Please be sure that you chose Exam");
        } else if (employee == null) {
            warningPopUp("Please be sure that you chose Employee");
        } else if (examDate.getValue() != null) {
            warningPopUp("Please be sure that you chose date");
        } else if ((place == null) || (place.equals("Place"))) {
            warningPopUp("Please be sure that you entered a Place");
        } /*else if ((place.equals("")) || examDate.getValue() == null) {

        }*/ else {
            //ErrorPopUp("There is a systemic problem. Please call the HelpCenter");
            ErrorPopUp("Please be sure that you selected a Date");
        }

    }

    @FXML
    public void assignGrade() {
        Employee employee = lastList.getSelectionModel().getSelectedItem();
        String gradeOfEmployee = grade.getText();
        System.out.println(gradeOfEmployee);
        if (employee == null) {
            warningPopUp("Please choose an Employee!");
        } else if (gradeOfEmployee.equals("")) {
            warningPopUp("Please enter a Grade");
        } else {
            try {
                int x = Integer.parseInt(gradeOfEmployee);
                grade.setText("");
                confirmationPopUp("Employee Graded");
            } catch (Exception ee) {
                ErrorPopUp("Please enter a valid grade.");
            }

        }

    }

    @FXML
    public void giveCertificate() {
        Exam e = examList2.getSelectionModel().getSelectedItem();

        if (e != null) {
            examList2.getItems().remove(e);
        } else {
            warningPopUp("Please select a finished exam");
        }

    }

    @FXML
    public void resignTheSameExam() {
        Exam e = examList2.getSelectionModel().getSelectedItem();

        if (e != null) {
            examList2.getItems().remove(e);
        } else {
            warningPopUp("Please select a finished exam");
        }
    }


}



