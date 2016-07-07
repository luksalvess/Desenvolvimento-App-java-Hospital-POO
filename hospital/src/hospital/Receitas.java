package hospital;
public class Receitas{
    private String nome;
    private String cdMedico;
    private String medicamento;
    private String doenca;
    private String descricaoMedicamento;
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCdMedico() {
        return cdMedico;
    }

    public void setCdMedico(String cdMedico) {
        this.cdMedico = cdMedico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDoenca() {
        return doenca;
    }

    public void setDoenca(String doenca) {
        this.doenca = doenca;
    }

    public String getDescricaoMedicamento() {
        return descricaoMedicamento;
    }

    public void setDescricaoMedicamento(String descricaoMedicamento) {
        this.descricaoMedicamento = descricaoMedicamento;
    }

    
    @Override
    public String toString(){
        return nome + ":" + cdMedico + ":" + medicamento + ":" + doenca + ":" + descricaoMedicamento;
    }

    
}
