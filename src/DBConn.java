import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
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

        try {
            conn = DriverManager.getConnection(url, user, password);
            // toplu bir ekleme yapıldığında bir yerde hata varsa if bloğu gibi işlemleri kaydeder ekleme yapma
            // setAutoCommit(false) commit() ve rollback() kullanımı
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("INSERT INTO student(student_name,student_class) VALUES (?,?)");

            pr.setString(1,"John");
            pr.setInt(2,2);
            pr.executeUpdate();

            if(true){
                throw new SQLException(); // bu şekilde john eklenir doe eklenmez
            }
            pr.setString(1,"Doe");
            pr.setInt(2,3);
            pr.executeUpdate();


            conn.commit();
            pr.close();
            conn.close();
//            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return conn;
    }
}
