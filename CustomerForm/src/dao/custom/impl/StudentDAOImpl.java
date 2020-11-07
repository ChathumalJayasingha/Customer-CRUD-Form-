package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws SQLException, ClassNotFoundException {
        String sql="insert into customer values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql, student.getId(), student.getName(), student.getAddress(), student.getSalary());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        String sql="delete from customer where id=?";
        return CrudUtil.executeUpdate(sql,s);
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {
        String sql="update customer set name=?,address=?,salary=? where id=?";
        return CrudUtil.executeUpdate(sql, student.getName(), student.getAddress(), student.getSalary(), student.getId());
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException {
        String sql="select * from customer where id=?";
        return (Student) CrudUtil.executeQuery(sql,s);
    }

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        String sql="select * from customer ";
        ArrayList<Student> studentArrayList =new ArrayList<>();
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        while (resultSet.next()){
            Student student =new Student(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
            studentArrayList.add(student);
        }return studentArrayList;

    }
}
