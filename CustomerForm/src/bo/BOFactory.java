package bo;

import bo.custom.impl.StudentBOImpl;

public class BOFactory {
        private static BOFactory boFactory;

        private BOFactory(){}

        public static BOFactory getInstance(){
            return boFactory==null?boFactory=new BOFactory():boFactory;
        }
        public enum BOType{
            CUSTOMER
        }
        public SuperBO getBO(BOType boType){
            switch (boType){
                case CUSTOMER:
                    return new StudentBOImpl();
                default:
                    return null;
            }
        }

}
