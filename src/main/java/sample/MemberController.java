package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.MemberModel;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    private static MemberModel memberModel = new MemberModel();

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtRemainTIme;

    @FXML
    private TableColumn<Member, Image> avatarColnumn;

    @FXML
    private JFXTextField txtFullname;

    @FXML
    private TableView<Member> tableView;

    @FXML
    private TableColumn<Member, String> fullnameColnumn;

    @FXML
    private TableColumn<Member, String> remainTImeColnumn;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    void onSave(ActionEvent event) {
        int reMainTime1 = Integer.parseInt(txtRemainTIme.getText());
        String id = String.valueOf(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, reMainTime1); // adds one hour

        Long remainTime = cal.getTimeInMillis();

        Member member = new Member(
                txtUsername.getText(),
                txtPassword.getText(),
                txtFullname.getText(),
                txtAvatar.getText(),
                remainTime,
                id

        );

//        for (int i = 0; i < tableStudent.getItems().size(); i++) {
//            Student st = tableStudent.getItems().get(i);
//            if(st.getRollNumber().equals(student.getRollNumber())){
//                tableStudent.getItems().remove(i);
//            }
//        }

//        for (Student st :tableStudent.getItems()) {
//            if(st.getRollNumber().equals(student.getRollNumber())){
//                System.out.println(st.getRollNumber() + "  "+ student.getRollNumber());
//            }
//        }
        //Get all the items from the table as a list, then add the new person to
        //the list
        memberModel.add(member);
        tableView.refresh();
    }

    @FXML
    void onDeactive(ActionEvent event) {

        //this gives us the rows that were selected
        Member student = this.tableView.getSelectionModel().getSelectedItem();

        boolean a = memberModel.delete(student.getId());
        System.out.println(student.toString());
        //loop over the selected rows and remove the Person objects from the table
        if (a) tableView.getItems().remove(student);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableView.setRowFactory(tv -> {
            TableRow<Member> row = new TableRow<>();
            row.setOnMouseClicked(event -> {

                if (!row.isEmpty()) {
                    if (event.getClickCount() == 2) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/MemberDetail.fxml"));
                        Parent tableViewParent = null;
                        try {
                            tableViewParent = loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Scene tableViewScene = new Scene(tableViewParent);

                        //access the controller and call a method
                        ViewMemberDetail controller = loader.getController();
                        controller.initData(tableView.getSelectionModel().getSelectedItem());

                        //This line gets the Stage information
                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(tableViewScene);
                        window.show();

                        System.out.println("Double clicked");

                    }

//                    Member rowData = row.getItem();
//                    .setText(rowData.getRollNumber());
//                    nameTextFeild.setText(rowData.getName());
//                    avatarTextFeild.setText(rowData.getAvatar());
                }
            });

            return row;
        });
        //set up the columns in the table
        fullnameColnumn.setCellValueFactory(new PropertyValueFactory<Member, String>("fullname"));
        avatarColnumn.setCellValueFactory(new PropertyValueFactory<Member, Image>("imageAvatar"));
        remainTImeColnumn.setCellValueFactory(new PropertyValueFactory<Member, String>("txtRemainTime"));
        //load dummy data
        tableView.setItems(getMember());


//        //Update the table to allow for the first and last name fields
//        //to be editable
//        tableStudent.setEditable(true);
//        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        //This will allow the table to select multiple rows at once
//        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//
//        //Disable the detailed person view button until a row is selected
//        this.detailedPersonViewButton.setDisable(true);
    }

    public ObservableList<Member> getMember() {

        ArrayList<Member> list = memberModel.getMember();

        javafx.collections.ObservableList<Member> students = FXCollections.observableArrayList();
        for (Member member : list) {
            students.add(member);
        }

        return students;
    }

}
