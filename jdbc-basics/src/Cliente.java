import java.util.Date;

public class Cliente {
    String cpf;
    String nome;
    String endereco1;
    String endereco2;
    String bairro;
    String cidade;
    String estado;
    String cep;
    Integer idade;
    Integer primeiraCompra;
    String  dataNascimento;

    Cliente(String cpf, String nome, String endereco1, String endereco2, String bairro, String cidade, String estado, String cep, Integer idade,
          Integer primeiraCompra, String  dataNascimento){
        this.cpf = cpf;
        this.nome = nome;
        this.endereco1 = endereco1;
        this.endereco2 = endereco2;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.idade = idade;
        this.primeiraCompra = primeiraCompra;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getPrimeiraCompra() {
        return primeiraCompra;
    }

    public void setPrimeiraCompra(Integer primeiraCompra) {
        this.primeiraCompra = primeiraCompra;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
    }

    public String getEndereco1() {
        return endereco1;
    }

    public void setEndereco1(String endereco1) {
        this.endereco1 = endereco1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
