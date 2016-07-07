package hospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Hospital {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner (System.in);
        int escolha;
        ArrayList<Pacientes> paciente = new ArrayList<>();
        importarPaciente(paciente);
        ArrayList<Receitas> receita = new ArrayList<>();
        importarReceita(receita);
        do{
            System.out.println("|====================================|");
            System.out.println("|         1. Cadastrar Paciente      |");
            System.out.println("|------------------------------------|");
            System.out.println("|         2. Cadastrar Receita       |");
            System.out.println("|------------------------------------|");
            System.out.println("|         3. Excluir Paciente        |");
            System.out.println("|------------------------------------|");
            System.out.println("|         4. Excluir Receita         |");
            System.out.println("|------------------------------------|");
            System.out.println("|         5. Listar Pacientes        |");
            System.out.println("|------------------------------------|");
            System.out.println("|         6. Listar Receitas         |");
            System.out.println("|------------------------------------|");
            System.out.println("|         7. Consultar Paciente      |");
            System.out.println("|------------------------------------|");
            System.out.println("|         8. Consultar Receitas      |");
            System.out.println("|------------------------------------|");
            System.out.println("|         0. Encerrar Programa       |");
            System.out.println("|====================================|");
            System.out.println("Digite a opção: ");
            escolha = input.nextInt();
        
            switch(escolha){
                case 1: incluirPacientes(paciente);
                break;
                case 2: incluirReceitas(receita);
                break;
                case 3: excluirPacientes(paciente);
                break;
                case 4: excluirReceitas(receita);
                break;
                case 5: listarPacientes(paciente);
                break;
                case 6: listarReceitas(receita);
                break;
                case 7: pesquisarPacientes(paciente);
                break;
                case 8: pesquisarReceitas(receita);
                break;
            }
        }while(escolha!=0);
        exportarPacientes(paciente);
        exportarReceitas(receita);
    }
    
    public static void importarPaciente(ArrayList<Pacientes>paciente){
        
            try (FileReader arq = new FileReader("paciente.txt")) {
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                while(linha!=null){
                    Pacientes p = new Pacientes();
                    paciente.add(p);
                    linha = lerArq.readLine();
                }
            
        }catch(IOException err){
            System.err.printf("Erro na abertura do arquivo",err.getMessage());
        }
    } 
        
    public static void importarReceita(ArrayList<Receitas>receita){
        
            try (FileReader arq2 = new FileReader("receita.txt")) {
                BufferedReader lerArq2 = new BufferedReader(arq2);
                String linha = lerArq2.readLine();
                while(linha!=null){
                    Receitas r = new Receitas();
                    receita.add(r);
                    linha = lerArq2.readLine();
                }
            
        }
        catch(IOException err){
            System.err.printf("Erro na abertura do arquivo",err.getMessage()); 
        }
    }        
    public static void exportarPacientes(ArrayList<Pacientes>paciente) throws IOException{
        FileWriter arq = null;
        try {
            arq = new FileWriter("paciente.txt");
        } 
        catch (IOException e) {
            
        }
        if (arq == null){
            System.out.println("ta errado esta nulo");
        }
        try (PrintWriter gravarArq = new PrintWriter(arq)) {
            int p = paciente.size();
            for (int i = 0; i < p; i++) {
                gravarArq.printf(paciente.get(i).toString());
                gravarArq.printf("\r\n");
            }
        }
    }
    public static void exportarReceitas(ArrayList<Receitas>receita) throws IOException{
        FileWriter arq2 = null;
        try {
            arq2 = new FileWriter("receita.txt");
        } 
        catch (IOException e) {
        }
        try (PrintWriter gravArq2 = new PrintWriter(arq2)) {
            int r = receita.size();
            for (int j = 0; j < r; j++) {
                gravArq2.printf(receita.get(j).toString());
                gravArq2.printf("\r\n");
            }
        }
    }
    public static void incluirPacientes(ArrayList<Pacientes>paciente){
        Scanner input = new Scanner(System.in);
        String nome, idade, telefone;
        System.out.printf("Informe o nome do Paciente: \n");
        nome = input.nextLine();
        System.out.printf("Informe a idade: \n");
        idade = input.nextLine();
        System.out.printf("informe o Telefone: \n");
        telefone = input.nextLine();
        Pacientes p = new Pacientes();
        p.setNome(nome);
        p.setIdade(idade);
        p.setTelefone(telefone);
        paciente.add(p);
        try {
            exportarPacientes(paciente);
        } 
        catch (IOException ex) {
            Logger.getLogger(Pacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void incluirReceitas(ArrayList<Receitas>receita){
        Scanner input = new Scanner(System.in);
        String nome, cdMedico, medicamento, doenca, descricaoMedicamento;
        System.out.printf("Informe o nome do Paciente: \n");
        nome = input.nextLine();
        System.out.printf("Informe o Cd. do Medico: \n");
        cdMedico = input.nextLine();
        System.out.printf("Informe o medicamento a ser utilizado: \n");
        medicamento = input.nextLine();
        System.out.printf("Informe a Doença: \n");
        doenca = input.nextLine();
        System.out.printf("Informe a o modo de utilização do Medicamento: \n");
        descricaoMedicamento = input.nextLine();
        Receitas r = new Receitas();
        r.setNome(nome);
        r.setCdMedico(cdMedico);
        r.setMedicamento(medicamento);
        r.setDoenca(doenca);
        r.setDescricaoMedicamento(descricaoMedicamento);
        
        receita.add(r);
        try {
            exportarReceitas(receita);
        } catch (IOException ex) {
                Logger.getLogger(Receitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void excluirPacientes(ArrayList<Pacientes>paciente){
        Scanner input = new Scanner(System.in);
        int i;
        listarPacientes(paciente);
        System.out.printf("\nInforme o indice da posição a ser excluida\n");
        i = input.nextInt(); 
        try{
            paciente.remove(i);
        }catch(IndexOutOfBoundsException err){
            System.out.printf("\nErro: Posição inválida(%s).\n", err.getMessage());    
        }
    }
    public static void excluirReceitas(ArrayList<Receitas>receita){
        Scanner input = new Scanner(System.in);
        int i;
        listarReceitas(receita);
        System.out.printf("\nInforme o indice da posição a ser excluida\n");
        i = input.nextInt(); 
        try{
            receita.remove(i);
        }catch(IndexOutOfBoundsException err){
            System.out.printf("\nErro: Posição inválida(%s).\n", err.getMessage());    
        }
    }
    public static void listarPacientes(ArrayList<Pacientes>paciente){
        System.out.printf("\nListando os Pacientes\n");
        int i, n = paciente.size();
        for (i=0;i<n;i++){
            System.out.printf("Posição %d- %s\n",i,paciente.get(i));
        }
        System.out.printf("--------------------------------------------------\n");
    }
    public static void listarReceitas(ArrayList<Receitas>receita){
        System.out.printf("\nListando as Receitas\n");
        int i, n = paciente.size();
        for (i=0;i<n;i++){
            System.out.printf("Posição %d- %s\n",i,receita.get(i));
        }
        System.out.printf("--------------------------------------------------\n");
    }
    public static void pesquisarPacientes(ArrayList<Pacientes>paciente){
        Scanner input = new Scanner(System.in); 
        String f;
        System.out.printf("\nInforme o nome do paciente\n");
        f = input.nextLine();
        
        String dados[];
        int i, n = paciente.size();
        for(i = 0;i<n;i++){
            
            System.out.println("\nNome....:%s\n"+paciente.get(i).getNome());
            System.out.println("\nidade....:%d\n"+paciente.get(i).getIdade());
            System.out.println("\nTelefone:%d\n"+paciente.get(i).getTelefone());
            
        }    
    }
    public static void pesquisarReceitas(ArrayList<Receitas>receita){
        Scanner input = new Scanner(System.in); 
        String s;
        System.out.printf("\nInforme o nome do paciente\n");
        s = input.nextLine();
        String dados[];
        int i, n = receita.size();
        for(i = 0;i<n;i++){
                System.out.println("\nNome....:%s\n"+receita.get(i).getNome());
                System.out.println("\ncdMedico....:%s\n="+receita.get(i).getCdMedico());
                System.out.println("\nmedicamento:%s\n"+receita.get(i).getMedicamento());
                System.out.println("\ndoenca:%s\n"+receita.get(i).getDoenca());
                System.out.println("\ndescricaoMedicamento:%s\n"+receita.get(i).getDescricaoMedicamento());
        }
    }
}
