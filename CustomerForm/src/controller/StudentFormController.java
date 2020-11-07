package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StudentFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;
    public Label txtTime;

    StudentBO customerBO= (StudentBO) BOFactory.getInstance().getBO(BOFactory.BOType.CUSTOMER);

    public void initialize(){
       // generateDate();
    }

    public void generateDate(){

    }


    public void btnAdd(ActionEvent actionEvent)  {
        String id = txtId.getText();
        String name = txtName.getText();
         String address = txtAddress.getText();
         String salary = txtSalary.getText();
        StudentDTO studentDTO =new StudentDTO(id,name,address,salary);

        boolean b = false;
        try {
            b = customerBO.addCustomer(studentDTO);

            if (b){
                new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
            }else{
                new Alert(Alert.AlertType.NONE,"Not Added").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.INFORMATION,e.getMessage()).show();
        }

    }
}
