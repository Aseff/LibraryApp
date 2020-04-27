/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryapp;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author asefn
 */
public interface InterfaceForEveryClass {
     //Numune  interface -i daha yaxsi basa dusmek ucun 
    //Tutaq ki bu method bazadan select edir.
   // public List<SchoolData> getschooldataForStatement() throws Exception;
    public abstract int getCountOfRows() throws Exception;
    //public List<SchoolData> getschooldataForSearch(String name, String surname) throws Exception;

//    public  boolean update(SchoolData schooldata) throws Exception;
//    public  SchoolData getById(int id) throws SQLException, ClassNotFoundException;

    


 
}
