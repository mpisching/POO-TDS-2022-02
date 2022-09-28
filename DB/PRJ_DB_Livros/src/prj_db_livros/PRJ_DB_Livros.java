/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prj_db_livros;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author mpisc
 */
public class PRJ_DB_Livros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        estabelecerConexao();
    }
    
    public static void estabelecerConexao() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_livros2?"
                + "useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "admin";
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Sucesso na conexão!!!");
        } catch (Exception ex) {
            System.out.println("Não foi possível estabelecer a conexão com o BD");
        }
    }
    
}
