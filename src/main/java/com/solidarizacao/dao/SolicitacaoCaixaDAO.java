package com.solidarizacao.dao;

import com.solidarizacao.model.SolicitacaoCaixa;
import java.sql.*;

public class SolicitacaoCaixaDAO {
    public void salvar(SolicitacaoCaixa s) throws Exception {
        Connection conn = Conexao.getConnection();
        String sql = "INSERT INTO solicitacao_caixa (nome, cep, rua, numero, complemento, bairro, cidade, uf, rede, telefone, email, quantidade_caixas, itens_coleta, outro_produto, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, s.getNome());
        ps.setString(2, s.getCep());
        ps.setString(3, s.getRua());
        ps.setInt(4, s.getNumero());
        ps.setString(5, s.getComplemento());
        ps.setString(6, s.getBairro());
        ps.setString(7, s.getCidade());
        ps.setString(8, s.getUf());
        ps.setString(9, s.getRede());
        ps.setString(10, s.getTelefone());
        ps.setString(11, s.getEmail());
        ps.setInt(12, s.getQuantidadeCaixas());
        ps.setString(13, s.getItensColeta());
        ps.setString(14, s.getOutroProduto());
        ps.setString(15, s.getObservacao());

        ps.executeUpdate();
        conn.close();
    }
}
