
package hospital;

public class Pacientes {
    private String nome;
    private String idade;
    private String telefone;
     

   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   

    
    @Override
    public String toString(){
        return nome + ":" + idade + ":" + telefone;
    }

   
        
    
}
