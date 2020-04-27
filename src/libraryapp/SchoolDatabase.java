package libraryapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SchoolDatabase extends ConnectionDatabase<SchoolData> implements InterfaceForEveryClass {

    @Override
    public List<SchoolData> getschooldataForStatement() throws Exception {
        List<SchoolData> result = new ArrayList<>();
        try (Connection con = connection()) {

            Statement state = con.createStatement();
            state.executeQuery("select*from school");
            ResultSet rs = state.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String surname = rs.getString("student_surname");
                String profile_description = rs.getString("student_description");

                result.add(new SchoolData(id, name, surname, profile_description));

            }
        }
        return result;

    }

    public static List<SchoolData> getALLStudents() throws Exception {
        List<SchoolData> result = new ArrayList<>();
        try (Connection con = connection()) {

            PreparedStatement state = con.prepareStatement("SELECT  student_id,student_name,student_surname,student_description from school" );
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int s_id = rs.getInt("student_id");
                String s_name = rs.getString("student_name");
                String s_surname = rs.getString("student_surname");
                String profile_description = rs.getString("student_description");

                result.add(new SchoolData(s_id, s_name, s_surname, profile_description));
            }

            return result;

        }

    }

    public static List<SchoolData> getschooldataForSearch(String name, String surname, Integer id, String profession) throws Exception {

        if (name == null && surname == null && id == null && profession == null) {
            return getALLStudents();
        }

        List<SchoolData> result = new ArrayList<>();
        try (Connection con = connection()) {

            PreparedStatement state = con.prepareStatement("select*from school where student_name like ? and student_surname like ?");
            state.setString(1, "%" + name + "%");
            state.setString(2, "%" + surname + "%");
            state.executeQuery();
            ResultSet rs = state.getResultSet();

            while (rs.next()) {
                int s_id = rs.getInt("student_id");
                String s_name = rs.getString("student_name");
                String s_surname = rs.getString("student_surname");
                String profile_description = rs.getString("student_description");

                result.add(new SchoolData(s_id, s_name, s_surname, profile_description));
            }
            System.out.println("name" + name);
            System.out.println("surname" + surname);
            System.out.println("id " + id);
            System.out.println("profession " + profession);

            List<SchoolData> listt = new ArrayList<>();
            for (SchoolData s : result) {
                System.out.println(s);
                if (((name == null || name.isEmpty()) || s.getName().toLowerCase().contains(name.toLowerCase()))
                        && ((surname == null || surname.isEmpty()) || s.getSurname().toLowerCase().equalsIgnoreCase(surname.toLowerCase()))
                        && ((id == null || id == 0) || s.getId() == id)
                        && ((profession == null || profession.isEmpty()) || s.getProfile_description().toLowerCase().equalsIgnoreCase(profession.toLowerCase()))) {
                    listt.add(s);
                }

            }
            return listt;

        }

    }

    @Override
    public List<SchoolData> getschooldataForPreparedStatement() throws Exception {
        List<SchoolData> result = new ArrayList<>();
        try (Connection con = connection()) {

            PreparedStatement state = con.prepareStatement("select*from school");
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("student_name");
                String surname = rs.getString("student_surname");
                result.add(new SchoolData(id, name, surname));

            }
        }

        return result;

    }

    public int getCountOfRows() throws Exception {
        int count = 0;
        ResultSet rs = null;
        try (Connection con = connection()) {
            PreparedStatement state = con.prepareStatement("select count(*) from school", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = state.executeQuery();
            rs.next();
            System.out.println("Table contains " + rs.getInt("count(*)") + " rows");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs.getInt("count(*)");
    }

    public static boolean update(SchoolData schooldata) throws Exception {

        try (Connection con = connection()) {

            // Statement state = con.createStatement();
            //state.executeUpdate("update school set student_name='" + schooldata.getName() + " 'where student_id= " + schooldata.getId());
            PreparedStatement state = con.prepareStatement("update school set student_name=?,student_surname=?,student_description=? where student_id=?");
            state.setString(1, schooldata.getName());
            state.setString(2, schooldata.getSurname());
            state.setString(3, schooldata.getProfile_description());
            state.setInt(4, schooldata.getId());
            state.executeUpdate();

            ResultSet rs = state.getResultSet();

        }
        return true;

    }

    public static int insertion(SchoolData schooldata) throws Exception {

        try (Connection con = connection()) {
            PreparedStatement state = con.prepareStatement("insert into school(student_name,student_surname,student_description) values(?,?,?)");
            //state.setInt(1, schooldata.getId());
            state.setString(1, schooldata.getName());
            state.setString(2, schooldata.getSurname());
            state.setString(3, schooldata.getProfile_description());

            return state.executeUpdate();

        }

    }

    public static int delete(int id) throws Exception {

        try (Connection con = connection()) {
            PreparedStatement state = con.prepareStatement("delete from school where student_id=?");
            state.setInt(1, id);
            return state.executeUpdate();

        }

    }
//    @Override
//    public List<SchoolData> getById(int id) throws SQLException, ClassNotFoundException {
//        List<SchoolData> result = new ArrayList<>();
//
//        try (Connection con = connection()) {
//            Statement state = con.createStatement();
//            state.execute("select*from school where student_id=" + id );
//            ResultSet rs = state.getResultSet();
//
//            while (rs.next()) {
//                int student_id = rs.getInt("student_id");
//                String student_name = rs.getString("student_name");
//                String student_surname = rs.getString("student_surname");
//                String student_description=rs.getString("student_description");
//                result.add(new SchoolData(student_id, student_name, student_surname,student_description));
//            }
//            return  result;
//
//        }
//    }
    //Numune  interface -i daha yaxsi basa dusmek ucun 
    //Tutaq ki bu method bazadan select edir.

}
