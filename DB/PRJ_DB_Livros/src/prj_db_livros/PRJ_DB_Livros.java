/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prj_db_livros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mpisc
 */
public class PRJ_DB_Livros {

    private static Connection con = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        estabelecerConexao();
       // Livro livro = new Livro();
        Livro livro = novoLivro();
        inserir(livro);
        //livro.setId(5);
        //livro.setTitulo("Os mistérios do além");
        //livro.setAutor("Desconhecido");
        //PRJ_DB_Livros.atualizar(livro);
        livro.setId(13);
        remover(livro);
        try {
            List<Livro> livros = findAll();
            print(livros);
        } catch (Exception ex) {
            System.out.println("Livros não encontrados!!");
        }
        //remover(9);
    }
    
    public static void print(List<Livro> livros) {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }
    
    public static void remover(Livro livro) {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "delete from LIVRO where id = ?";
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setInt(1, livro.getId());
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados!!!\n" + 
                    e.getMessage());
        }
    }    
    
    public static void remover(int id) {
        PreparedStatement pstm = null;
        try {
            final String SQL_DELETE = "delete from LIVRO where id = ?";
            pstm = con.prepareStatement(SQL_DELETE);
            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println("Exclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados!!!\n" + 
                    e.getMessage());
        }
    }    
    
    private static void inserir(Livro livro) {
        //método para salvar o livro no BD
        PreparedStatement pstm = null;
        try {
            final String SQL_INSERT
                    = "insert into LIVRO (TITULO, AUTOR) "
                    + "values (?,?)";
            pstm = con.prepareStatement(SQL_INSERT);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.executeUpdate();
            System.out.println("Inclusão realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println(
                    "Erro ao inserir dados!!!\n" + e.getMessage());
        }
    }

    public static void atualizar(Livro livro) {
        PreparedStatement pstm = null;
        try {
            final String SQL_UPDATE
                    = "UPDATE LIVRO SET titulo = ?, autor = ? "
                    + "WHERE id = ?";
            pstm = con.prepareStatement(SQL_UPDATE);
            pstm.setString(1, livro.getTitulo());
            pstm.setString(2, livro.getAutor());
            pstm.setInt(3, livro.getId());
            pstm.executeUpdate();
            System.out.println("atualização realizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados!!!\n"
                    + e.getMessage());
        }
    }

    public static Livro novoLivro() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("**** Novo Livro ****");
        System.out.print("Título.....: ");
        String titulo = entrada.nextLine();
        System.out.print("Autor......: ");
        String autor = entrada.nextLine();
        Livro livro = new Livro(titulo, autor);
        return livro;
    }

    public static void estabelecerConexao() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_livros2?"
                + "useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "admin";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Sucesso na conexão!!!");
        } catch (Exception ex) {
            System.out.println("Não foi possível estabelecer a conexão com o BD");
        }
    }
    
    public static List<Livro> findAll() throws Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_STATEMENT =
                "Select ID, TITULO, AUTOR " +
                " from LIVRO";
        try {
            stmt = con.prepareStatement(SQL_STATEMENT);
            rs = stmt.executeQuery();
            return carregarMultiplosResultados(rs);
        }catch(SQLException sqle){
            throw new Exception(sqle);
        } catch(Exception e){
            throw new Exception(e);
        } finally{}
    }
    
    public static List<Livro> carregarMultiplosResultados(ResultSet rs)
                throws Exception {
        List<Livro> resultList = new ArrayList<>();
        while (rs.next()) {
            Livro dto = new Livro();
            carregarVO(dto, rs);
            resultList.add(dto);
        }
        return resultList;    
    }

    private static void carregarVO(Livro dto, ResultSet rs) throws Exception{
        dto.setId(rs.getInt("ID"));
        dto.setTitulo(rs.getString("TITULO"));
        dto.setAutor(rs.getString("AUTOR"));
    }

}
