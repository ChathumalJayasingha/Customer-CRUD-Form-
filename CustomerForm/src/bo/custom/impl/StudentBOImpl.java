package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO =(StudentDAO) DAOFactory.getInstance().getDAOType(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(StudentDTO studentDTO) throws Exception {
        Student student =new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getSalary());
        return studentDAO.add(student);
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(StudentDTO studentDTO) throws Exception {
        Student student =new Student(studentDTO.getId(), studentDTO.getName(), studentDTO.getAddress(), studentDTO.getSalary());
        return studentDAO.update(student);
    }

    @Override
    public StudentDTO searchCustomer(String id)throws Exception{
        Student search = studentDAO.search(id);
         return new StudentDTO(search.getId(),search.getName(),search.getAddress(),search.getSalary());


    }

    @Override
    public ArrayList<StudentDTO> getAllCustomers() throws Exception{
        ArrayList<Student> all = studentDAO.getAll();

        ArrayList<StudentDTO> studentDTOArrayList =new ArrayList<>();

        for (Student student :all){
            StudentDTO studentDTO =new StudentDTO(student.getId(), student.getName(), student.getAddress(), student.getSalary());
            studentDTOArrayList.add(studentDTO);
        }return studentDTOArrayList;
    }
}
