package com.solidarizacao.model;

public class SolicitacaoCaixa {
    private String nome, cep, rua, complemento, bairro, cidade, uf;
    private String rede, telefone, email, itensColeta, outroProduto, observacao;
    private int numero, quantidadeCaixas;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

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

    public String getItensColeta() { return itensColeta; }
    public void setItensColeta(String itensColeta) { this.itensColeta = itensColeta; }

    public String getOutroProduto() { return outroProduto; }
    public void setOutroProduto(String outroProduto) { this.outroProduto = outroProduto; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getQuantidadeCaixas() { return quantidadeCaixas; }
    public void setQuantidadeCaixas(int quantidadeCaixas) { this.quantidadeCaixas = quantidadeCaixas; }
}
