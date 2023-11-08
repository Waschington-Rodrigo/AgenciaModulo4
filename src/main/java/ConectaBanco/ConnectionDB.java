
package ConectaBanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private static final String USERNAME = "root";

    private static final String PASSWORD = "050621";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenciaviagem";


    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }
    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();
        
        if(con !=null){
            System.out.println("COnexão obtida com sucesso");
            con.close();
        }
        

}
}
