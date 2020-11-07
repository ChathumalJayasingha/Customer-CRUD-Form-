package dao;

import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    
    private static DAOFactory daoFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        return daoFactory==null? daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOType{
        CUSTOMER
    }
    public  SuperDAO getDAOType(DAOType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return (SuperDAO) new StudentDAOImpl();
            default:
                return null;
        }
    }
    
}
