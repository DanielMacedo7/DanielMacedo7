package Util;


// DEPENDENCIAS NECESSÁRIAS PARA IMPORTAR O BANCO DE DADOS...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoBancoDeDados {
    
  // 4 - ATRIBUTOS PRINCIPAIS NECESSÁRIOS PARA UMA CONEXÃO COM O BANCO DE DADOS
   public static final String DRIVER = "com.mysql.jdbc.Driver"; 
   public static final String URL = "jdbc.mysql://localhost:3306/meuapp";
   public static final String USER = "root";
   public static final String PASS = "";
   
   
   // CONEXÃO COM O BANCO DE DADOS
   public static Connection getConnection(){   
    try{   // TRATAMENTO DE ERROS
        Class.forName(DRIVER);
   return DriverManager.getConnection(URL, USER, PASS);    
    } catch (Exception ex){
        throw new RuntimeException("Erro Na Conexão Com o Banco De Dados" , ex);
       
   }    
}
   
   
// FECHAMENTO DA CONEXÃO COM O BANCO DE DADOS....   
public static void closeConnection (Connection connection, PreparedStatement statement){   
 try{
   if(connection != null){  
     connection.close();
   }  
   
   if(statement != null){
     statement.close();  
   }
     
   
 } catch (Exception ex){   
     throw new RuntimeException("", ex);
    
    
 } 
    
       
 } 

public static void closeConnection (Connection connection, PreparedStatement statement, ResultSet resultSet){   
 try{
   if(connection != null){  
     connection.close();
   }  
   
   if(statement != null){
     statement.close();  
   }
   
   if(resultSet != null){
    resultSet.close();
   }
   
 } catch (Exception ex){   
     throw new RuntimeException("", ex);
    
    
 } 
    
     
   
 } 
   
}


