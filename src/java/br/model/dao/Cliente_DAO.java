/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model.dao;

import br.model.Conexao;
import br.model.entity.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cliente_DAO {

    public void Inserir(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO CLIENTE ( nome, idade, endereco, bairro,  cidade, estado, referencia, cpf, rg, sexo, estado_civil, email, telefone, celular, numero_cartao, bandeira_cartao, loggin, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setString(3, contato.getEndereco());
            sql.setString(4, contato.getBairro());
            sql.setString(5, contato.getCidade());
            sql.setString(6, contato.getEstado());
            sql.setString(7, contato.getReferencia());
            sql.setString(8, contato.getCpf());
            sql.setString(9, contato.getRg());
            sql.setString(10, contato.getSexo());
            sql.setString(11, contato.getEstado_civil());
            sql.setString(12, contato.getEmail());
            sql.setString(13, contato.getTelefone());
            sql.setString(14, contato.getCelular());
            sql.setString(15, contato.getNumero_cartao());
            sql.setString(16, contato.getBandeira_cartao());
            sql.setString(17, contato.getLoggin());
            sql.setString(18, contato.getSenha());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Cliente get(Cliente cliente) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, cliente.getId());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    cliente.setNome(resultado.getString("NOME"));
                    cliente.setIdade(Integer.parseInt(resultado.getString("IDADE")));
                    cliente.setEndereco(resultado.getString("ENDERECO"));
                    cliente.setBairro(resultado.getString("BAIRRO"));
                    cliente.setCidade(resultado.getString("CIDADE"));
                    cliente.setEstado(resultado.getString("ESTADO"));
                    cliente.setReferencia(resultado.getString("REFERENCIA"));
                    cliente.setCpf(resultado.getString("CPF"));
                    cliente.setRg(resultado.getString("RG"));
                    cliente.setSexo(resultado.getString("SEXO"));
                    cliente.setEstado_civil(resultado.getString("ESTADO_CIVIL"));
                    cliente.setEmail(resultado.getString("EMAIL"));
                    cliente.setTelefone(resultado.getString("TELEFONE"));
                    cliente.setCelular(resultado.getString("CELULAR"));
                    cliente.setNumero_cartao(resultado.getString("NUMERO_CARTAO"));
                    cliente.setBandeira_cartao(resultado.getString("BANDEIRA_CARTAO"));
                    cliente.setLoggin(resultado.getString("LOGGIN"));
                    cliente.setSenha(resultado.getString("SENHA"));
                }
            }
            return cliente;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE CLIENTE SET nome= ?, idade= ?, endereco= ?, referencia = ?, bairro= ?,  cidade= ?, estado= ?, cpf= ?, rg= ?, sexo= ?, estado_civil= ?, email= ?, telefone= ?, celular = ?, numero_cartao= ?, bandeira_cartao= ?, loggin= ?, senha= ?  WHERE ID = ? ");
            sql.setString(1, contato.getNome());
            sql.setInt(2, contato.getIdade());
            sql.setString(3, contato.getEndereco());
            sql.setString(4, contato.getBairro());
            sql.setString(5, contato.getCidade());
            sql.setString(6, contato.getEstado());
            sql.setString(7, contato.getReferencia());
            sql.setString(8, contato.getCpf());
            sql.setString(9, contato.getRg());
            sql.setString(10, contato.getSexo());
            sql.setString(11, contato.getEstado_civil());
            sql.setString(12, contato.getEmail());
            sql.setString(13, contato.getTelefone());
            sql.setString(14, contato.getCelular());
            sql.setString(15, contato.getNumero_cartao());
            sql.setString(16, contato.getBandeira_cartao());
            sql.setString(17, contato.getLoggin());
            sql.setString(18, contato.getSenha());
            sql.setInt(19, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Cliente contato) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM CLIENTE WHERE ID = ? ");
            sql.setInt(1, contato.getId());
            sql.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Cliente> Listar() {
        ArrayList<Cliente> meusContatos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM CLIENTE";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Cliente cliente;
                    cliente = new Cliente(Integer.parseInt(resultado.getString("id")),
                            resultado.getString("NOME"),
                            Integer.parseInt(resultado.getString("IDADE")),
                            resultado.getString("ENDERECO"),
                            resultado.getString("BAIRRO"),
                            resultado.getString("CIDADE"),
                            resultado.getString("ESTADO"),
                            resultado.getString("REFERENCIA"),
                            resultado.getString("CPF"),
                            resultado.getString("RG"),
                            resultado.getString("SEXO"),
                            resultado.getString("ESTADO_CIVIL"),
                            resultado.getString("EMAIL"),
                            resultado.getString("TELEFONE"),
                            resultado.getString("CELULAR"),
                            resultado.getString("NUMERO_CARTAO"),
                            resultado.getString("BANDEIRA_CARTAO"),
                            resultado.getString("LOGGIN"),
                            resultado.getString("SENHA"));
                    meusContatos.add(cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexao.closeConexao();
        }
        return meusContatos;

    }

}
