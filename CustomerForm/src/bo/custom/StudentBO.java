package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    boolean addCustomer(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, Exception;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException, Exception;
    boolean updateCustomer(StudentDTO studentDTO) throws SQLException, ClassNotFoundException, Exception;
    StudentDTO searchCustomer(String  id) throws SQLException, ClassNotFoundException, Exception;
    ArrayList<StudentDTO> getAllCustomers() throws SQLException, ClassNotFoundException, Exception;

}
