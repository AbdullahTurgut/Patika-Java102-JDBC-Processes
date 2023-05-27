package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private final String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private final String user = "postgres";
    private final String password = "password";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        // VERİTABANI İŞLEMLERİ İÇİN Statement sınıfı kullanacağız
        Statement st = null;
        String sql = "SELECT * FROM student";
        // ekleme için sql sorguları -> String statement & prepareStatement
        String insertSql = "INSERT INTO student(student_name,student_class) " +
                "VALUES('Asya',4)";
        String prSql = "INSERT INTO student(student_name,student_class)" +
                "VALUES (?,?)"; // soru işaretli kısmı kullanıcadan preparedStatement ile alabiliriz

        // Güncelleme için sql sorguları -> statement & prepareStatement
        String updateSql = "UPDATE student SET student_name = 'Alcor Turgut' WHERE id = 1 ";
        String updatePrs = "UPDATE student SET student_name = ? WHERE id = ? "; // soru işaretlerine değer atayabiliriz

        // Silme işlemleri için sql sorguları -> statement & prepareStatement
        String deleteSql = "DELETE FROM student WHERE id = 3"; // statement için
        String deletePrs = "DELETE FROM student WHERE id = ?"; // preparedStatement için


        try {
            conn = DriverManager.getConnection(url, user, password);

            // ############ VERİTABANI SİLME İŞLEMLERİ ##############
            // statement ile silme işlemi
            st = conn.createStatement();
            st.executeUpdate(deleteSql);

            // preparedStatement ile Silme işlemi
            PreparedStatement prDel = conn.prepareStatement(deletePrs);
            prDel.setInt(1, 1);
            prDel.executeUpdate();
            st.close();
            prDel.close();
            conn.close();
            // conn objesi üzerinden statement oluşturmamız gerekiyor
//            st = conn.createStatement();

            // ########### VERİTABANI GÜNCELLEME İŞLEMİ ###############
            st = conn.createStatement();
            st.executeUpdate(updateSql); // statement ile update işlemi

            // PrepareStatement ile Güncelleme
            PreparedStatement prUpdate = conn.prepareStatement(updatePrs);
            prUpdate.setString(1,"Goetia Turgut"); // 1. ? student_name temsil eder
            prUpdate.setInt(2,1); // 2. ? id temsil eder
            prUpdate.executeUpdate();
            prUpdate.close();


            // ############### VERİTABANI EKLEME İŞLEMLERİ ##################
            // INSERT (ekleme yapma)
            st.executeUpdate(insertSql); // Statement ve executeUpdate()  methodu ile

            // PreparedStatement ile ekleme yapma
            PreparedStatement prInsert = conn.prepareStatement(prSql);
            prInsert.setString(1,"Eray");
            prInsert.setInt(2,5);
            prInsert.executeUpdate();
            prInsert.close();

            //veri çekmek için executeQuery("sql sorgusu örneğin")
            ResultSet data = st.executeQuery(sql); // geriye bir ResultSet döndürüyor
            while (data.next()) {
                // veriyi çekmek için
                System.out.println("ID : " + data.getInt("id")); // bu bize 1 ve 2 vermeli şuan 2 veri var
                System.out.println("Ad : " + data.getString("student_name")); // name VARCHAR bu yüzden String
                System.out.println("Sınıf No : " + data.getInt("student_class"));
                System.out.println("#############");
            }
//            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}