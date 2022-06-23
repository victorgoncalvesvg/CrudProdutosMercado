/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import br.com.controle.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 201920222
 */
public class ManterProduto extends DAO{
    public void inserir(Produto p) throws Exception {
        abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String existe = "select codigo, nomeProduto, valor, quantidade FROM produto where nomeProduto=?";
        ps = (PreparedStatement) con.prepareStatement(existe);
        ps.setString(1, p.getNomeProduto());
        ResultSet tr = ps.executeQuery();
        if (tr.next()) {
            JOptionPane.showMessageDialog(null, "O Produto j? foi cadastrado!");
        } else {
            String query = "INSERT INTO produto (codigo, nomeProduto, valor, quantidade) values(null,?,?,?)";
            ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, p.getNomeProduto());
            ps.setDouble(2, p.getValor());
            ps.setInt(3, p.getQuantidade());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Produto Inserido com sucesso!");
        }

        fecharBanco();
    }

    public void deletarProduto(Produto p) throws Exception {
        abrirBanco();
        String query = "delete from produto where codigo=?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setInt(1, p.getCodigo());
        ps.execute();
        JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
        fecharBanco();
    }

    public void PesquisarRegistroCodigo(Produto p) throws Exception {
        try {
            abrirBanco();
            String query = "select codigo, nomeProduto, valor, quantidade FROM produto where codigo=?";
            ps = (PreparedStatement) con.prepareStatement(query);
            
                ps.setInt(1, p.getCodigo());
         
            ResultSet tr = ps.executeQuery();
            if (tr.next()) {
                p.setCodigo(tr.getInt("codigo"));
                p.setNomeProduto(tr.getString("nomeProduto"));
                p.setValor(tr.getDouble("valor"));
                p.setQuantidade(tr.getInt("quantidade"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
    
    
    public void PesquisarRegistroNome(Produto p) throws Exception {
        try {
            abrirBanco();
            String query = "select codigo, nomeProduto, valor, quantidade FROM produto WHERE nomeProduto like %?%";
            ps = (PreparedStatement) con.prepareStatement(query);

                 ps.setString(1, p.getNomeProduto());  
           
                ResultSet tr = ps.executeQuery();
            if (tr.next()) {
                p.setCodigo(tr.getInt("codigo"));
                p.setNomeProduto(tr.getString("nomeProduto"));
                p.setValor(tr.getDouble("valor"));
                p.setQuantidade(tr.getInt("quantidade"));
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado! ");
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
           
    public ArrayList<Produto> PesquisarTudo() throws Exception {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            abrirBanco();
            String query = "select codigo, nomeProduto, valor, quantidade FROM produto";
            ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet tr = ps.executeQuery();
            Produto p;
            while (tr.next()) {
                p = new Produto();
                p.setCodigo(tr.getInt("codigo"));
                p.setNomeProduto(tr.getString("nomeProduto"));
                p.setValor(tr.getDouble("valor"));
                p.setQuantidade(tr.getInt("quantidade"));
                produtos.add(p);
            }
            fecharBanco();
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
        return produtos;
    }

    public void editarProduto(Produto p) throws Exception {
        abrirBanco();
        //JOptionPane.showMessageDialog(null, a.getNome()+ a.getEmail() + a.getIdade());
        String query = "UPDATE produto set codigo = ?, nomeProduto = ?, valor = ? where quantidade = ?";
        ps = (PreparedStatement) con.prepareStatement(query);
        ps.setInt(1, p.getCodigo());
        ps.setString(2, p.getNomeProduto());
        ps.setDouble(3, p.getValor());
        ps.setInt(4, p.getQuantidade());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Produto Alterado com sucesso!");
        fecharBanco();
    }
}
