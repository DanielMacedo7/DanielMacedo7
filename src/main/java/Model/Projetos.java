package Model;


import java.util.Date;

public class Projetos {
          
 //ATRIBUTOS    
 private int ID;   
 private String Nome;   
 private String Descricao;
 private Date DataCriacao;
 private Date DataAtualizacao;       

    // MÉTODO CONSTRUTOR
    public Projetos(int ID, String Nome, String Descricao, Date DataCriacao, Date DataAtualizacao) {
        this.ID = ID;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.DataCriacao = DataCriacao;
        this.DataAtualizacao = DataAtualizacao;
    }
      
    // MÉTODOS ACESSORES ( GETTERS E SETTER)

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataCriacao() {
        return DataCriacao;
    }

    public void setDataCriacao(Date DataCriacao) {
        this.DataCriacao = DataCriacao;
    }

    public Date getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(Date DataAtualizacao) {
        this.DataAtualizacao = DataAtualizacao;
    }

    @Override
    public String toString() {
        return "Projetos{" + "ID=" + ID + ", Nome=" + Nome + ", Descricao=" + Descricao + ", DataCriacao=" + DataCriacao + ", DataAtualizacao=" + DataAtualizacao + '}';
    }
    
    
    
}
