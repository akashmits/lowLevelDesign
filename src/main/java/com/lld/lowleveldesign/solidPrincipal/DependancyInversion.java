package com.lld.lowleveldesign.solidPrincipal;

// abstractions should not depend upon details
// Instead, the details should depend upon abstractions



// in this class , problem is that details depend on implementation
public class DependancyInversion {

    public class  MysqlDatabase{
        public void saveUser(String user){
            System.out.println("Saved User :"+user);
        }
    }

    // here is the problem i am not able to inject mysql Database class test class, because this class tightly depend on MysqlDatabase class
    public class UserContoller{
        DependancyInversion.MysqlDatabase mysqlDatabase;
        public UserContoller(){
            mysqlDatabase= new MysqlDatabase();
        }
    }

    //solution
    public interface  Database{
        public void saveUser(String user);
    }
    public class  MysqlDatabase1 implements Database{
        public void saveUser(String user){
            System.out.println("Saved User :"+user);
        }
    }

    public class  OracleDatabase implements Database{
        public void saveUser(String user){
            System.out.println("Saved User :"+user);
        }
    }

    // here is the problem i am not able to inject mysql Database class test class, because this class tightly depend on MysqlDatabase class
    public class UserContoller1{
        DependancyInversion.Database mysqlDatabase;
        public UserContoller1(Database database){
            this.mysqlDatabase= database;
        }
    }

}
