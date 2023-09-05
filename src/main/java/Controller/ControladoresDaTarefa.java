package Controller;

// DEPENDENCIA NECESSÁRIA PARA IMPLEMENTAR OS MÉTODOS NO CONTROLLER...
import Model.Tarefas;
import Util.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControladoresDaTarefa {
    
  //FUNÇÃO DE INSERIR NO BANCO DE DADOS..  
  public void save(Tarefas tarefas){  
      
   String sql = "INSERT INTO tarefas (IDPROJETO"   
           + "NOME,"
           + "DESCRICAO,"
           + "COMPLETED,"
           + "NOTAS,"
           + "PRAZO,"
           + "DATACRIACAO,"
           + "DATAATUALIZACAO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
           
      Connection connection = null;  
      PreparedStatement statement = null;
      
      try{
      
      connection = ConexaoBancoDeDados.getConnection();
      statement = connection.prepareStatement(sql);
  
      statement.setInt(1,tarefas.getIDPROEJTO());
      statement.setString(2, tarefas.getNOME());
      statement.setString(3, tarefas.getDESCRICAO());
      statement.setBoolean(4, tarefas.isCOMPLETED());
      statement.setString(5, tarefas.getNOTAS());
      statement.setDate(6, new Date(tarefas.getPRAZO().getTime()));
      statement.setDate(7, new Date(tarefas.getDATACRIACAO().getTime()));
      statement.setDate(8, new Date(tarefas.getDataAtualizacao().getTime()));
      statement.execute();
      
    } catch (SQLException ex){
        throw new RuntimeException("Erro ao salvar Tarefa" + ex.getMessage(), ex);
    }finally{   
        ConexaoBancoDeDados.closeConnection(connection, statement);
          
      }
  }   
    
  // FUNÇÃO DE ATUALIZAR NO BANCO DE DADOS....
    public void update(Tarefas tarefas){
      
     String sql = "UPDATE tarefas SET"   
             + "IDPROJETO = ?, "
             + "NOME = ?, "
             + "DESCRICAO = ?, "
             + "COMPLETED = ?, "
             + "NOTAS = ?, "
             + "PRAZO = ?, "
             + "DATACRIACAO = ?, "
             + "DataAtualizacao, "
             + "WHERE ID = ?";
     
        
     Connection connection = null;   
     PreparedStatement  statement =  null;
        
    try{    
        
    connection = ConexaoBancoDeDados.getConnection();
    statement = connection.prepareStatement(sql);
    
    statement.setInt(1, tarefas.getIDPROEJTO());
    statement.setString(2, tarefas.getNOME());
    statement.setString(3, tarefas.getDESCRICAO());
    statement.setBoolean(4, tarefas.isCOMPLETED());
    statement.setString(5, tarefas.getNOTAS());
    statement.setDate(6, new Date(tarefas.getPRAZO().getTime()));
    statement.setDate(7, new Date(tarefas.getDATACRIACAO().getTime()));
    statement.setDate(8, new Date(tarefas.getDataAtualizacao().getTime()));    
    statement.execute();
        
        
        
    } catch (SQLException ex){      
     throw new RuntimeException("Erro ao atualizar os Dados" + ex.getMessage(), ex);   
    }finally{
        
     ConexaoBancoDeDados.closeConnection(connection, statement);
        
        
  }
    
 } 
    
  // FUNÇÃO DELETE NO BANCO DE DADOS...
  public void RemoveById(int TarefasID) throws SQLException{
      
   String sql = "DELETE FROM tarefas WHERE ID = ?";  
   
   Connection connection = null;
   PreparedStatement statement = null;
      
   try{
    connection = ConexaoBancoDeDados.getConnection();   
    statement = connection.prepareStatement(sql);
    statement.setInt (1, TarefasID);
    statement.execute();
       
       
   } catch (SQLException e){
     throw new SQLException ("Erro ao Deletar Tarefa");  
   }finally{
    ConexaoBancoDeDados.closeConnection(connection, statement);
   }
      
  }
    
  public List<Tarefas> getAll(int IDPROJETO){
      
   String sql = "SELECT * FROM tarefas WHERE IDPROJETO = ?";
   
   Connection connection = null;
   PreparedStatement statement = null;
   ResultSet resultSet = null;
   
   // LISTA DE TAREFAS QUE SERÁ DEVOLVIDA QUANDO A CHAMADA DO MÉTODO ACONTECER.
   List<Tarefas> tarefa = new ArrayList<Tarefas>();
   
   try{
       
   connection = ConexaoBancoDeDados.getConnection();
   statement = connection.prepareStatement(sql);
   statement.setInt(1, IDPROJETO);    
   resultSet = statement.executeQuery();// VAI NOS DEVOLVER O VALOR SETADO NA PESQUISA DO BANCO DE DADOS
       
   while(resultSet.next()){
       
       // ESSA PARTE DO CÓDIGO VAI BUSCAR AS TAREFAS NO BANCO
       Tarefas tarefas = new Tarefas();    
  tarefas.setID(resultSet.getInt("ID"));
  tarefas.setIDPROEJTO(resultSet.getInt("IDPROJETO"));
  tarefas.setDESCRICAO(resultSet.getString("DESCRICAO"));
  tarefas.setCOMPLETED(resultSet.getBoolean("COMPLETED"));     
  tarefas.setNOTAS(resultSet.getString("NOTAS"));     
  tarefas.setPRAZO(resultSet.getDate("PRAZO"));     
  tarefas.setDATACRIACAO(resultSet.getDate("DATACRIACAO"));    
  tarefas.setDataAtualizacao(resultSet.getDate("DATAATUALIZACAO"));       
  Tarefas.add(tarefa);   
       
       
   }
         
       
   } catch (SQLException ex){     
       throw new RuntimeException ("Erro ao fazer pesquisa das tarefas!" + ex.getMessage(), ex);
   }finally{    
       ConexaoBancoDeDados.closeConnection(connection, statement, resultSet);
      
    // LISTA DE TAREFAS QUE FOI CRIADA E CARREGADA DO BANCO DE DADOS...
    return tarefa;   
  }
 }
}
