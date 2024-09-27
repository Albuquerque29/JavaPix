class Usuario {
    private String nomeCompleto;
    private String cpf;
    private String senha;

    public Usuario(String nomeCompleto, String cpf, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}
