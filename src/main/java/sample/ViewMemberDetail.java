package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.MemberModel;

/**
 * FXML Controller class
 *
 * @author jwright
 */
public class ViewMemberDetail implements Initializable {

    private Member selectedPerson;

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private ImageView avatar;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/MemberManager.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    @FXML
    void onSave(ActionEvent event) {
//        MemberModel model = new MemberModel(txtUserName.getText(), txtFullName.getText(), txtPassword.getText(),txtAvatar.getText(), );
//
//        Member member = new Member();
//
//        model.update()

    }
//    @FXML private Label lastNameLabel;
//    @FXML private Label birthdayLabel;
//    @FXML private Label ageLabel;
//    @FXML private ImageView photo;

    /**
     * This method accepts a person to initialize the view
//     * @param person
     */
    public void initData(Member member)
    {
        selectedPerson = member;
        txtUserName.setText(selectedPerson.getUsername());
        txtPassword.setText(selectedPerson.getPassword());
        txtFullName.setText(selectedPerson.getFullname());
        txtAvatar.setText(selectedPerson.getAvatar());
        avatar.setImage(new Image(selectedPerson.getAvatar()));

//        lastNameLabel.setText(selectedPerson.getLastName());
//        birthdayLabel.setText(selectedPerson.getBirthday().toString());
//        ageLabel.setText(Integer.toString(selectedPerson.getAge()));
//        photo.setImage(new Image(selectedPerson.getPhoto()));
    }


    /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }



}
