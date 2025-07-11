package com.solidarizacao.model;

public class SolicitarCaixa {
    private String nome;
    private String cep;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String rede;
    private String telefone;
    private String email;
    private int quantidadeCaixas;
    private String itens;
    private String outro;
    private String observacao;
    private String campanha;
    private String dataInicio;
    private String dataFim;
    
    // getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    
    public String getRede() { return rede; }
    public void setRede(String rede) { this.rede = rede; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public int getQuantidadeCaixas() { return quantidadeCaixas; }
    public void setQuantidadeCaixas(int quantidadeCaixas) { this.quantidadeCaixas = quantidadeCaixas; }
    
    public String getItens() { return itens; }
    public void setItens(String itens) { this.itens = itens; }
    
    public String getOutro() { return outro; }
    public void setOutro(String outro) { this.outro = outro; }
    
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    
    public String getCampanha() { return campanha; }
    public void setCampanha(String campanha) { this.campanha = campanha; }
    
    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }
    
    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }
    
    public void setOutroProduto(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setItensColeta(String join) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getItensColeta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getOutroProduto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}