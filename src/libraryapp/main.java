package libraryapp;

import java.sql.SQLException;
import libraryapp.SchoolDatabase;

public class main {

    public static void main(String[] args) throws Exception {
        // Database.update();
        // Database.delete();

        // burda biz eger iki classimiz varsa her class bir table ucundurse her defe onda biz gelib bu main mclassinda deyismeliyikki cagirmaq ucun . yeni ailidir main classin o birilerinden . Bunun ucun asagidakini kimi yaziriq
        //ASAGIDAKI BURDA BILMIRR KI main hansi calssi cagirmaq lazimdir
        
        InterfaceForEveryClass fdd = EachClassForMain.instance();
        
        
        //fdd.myawesomeCustom();
        //System.out.println(SchoolDatabase.getschooldataForStatement());  
        //Database.update(new SchoolData(3,"Cuska"));
        //Database.insertion(new SchoolData(7,"Ayxan"));
        //SchoolDatabase.delete(7);
        //System.out.println(SchoolDatabase.getschooldataForPreparedStatement());  
    }

}
