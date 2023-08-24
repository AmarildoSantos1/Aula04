import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

class Pessoa {
    private String nome;
    private int idade;
    private String endereco;
    private String email;
    private String telefone;

    
    public Pessoa(String nome, int idade, String endereco, String email, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}

public class Main {
    public static void main(String[] args) {
        
        String nome = "João"; 
        int idade = 25; 
        String endereco = "Rua A, 123"; 
        String email = "joao@example.com"; 
        String telefone = "(99) 1234-5678"; 

       
        Pessoa pessoa = new Pessoa(nome, idade, endereco, email, telefone);

        
        JSONObject pessoaJSON = new JSONObject();
        pessoaJSON.put("nome", pessoa.getNome());
        pessoaJSON.put("idade", pessoa.getIdade());
        pessoaJSON.put("endereco", pessoa.getEndereco());
        pessoaJSON.put("email", pessoa.getEmail());
        pessoaJSON.put("telefone", pessoa.getTelefone());

        
        try (FileWriter file = new FileWriter("pessoa.json")) {
            file.write(pessoaJSON.toJSONString());
            file.flush();
            System.out.println("Dados salvos com sucesso em pessoa.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
