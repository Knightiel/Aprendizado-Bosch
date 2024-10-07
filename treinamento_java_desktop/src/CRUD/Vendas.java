/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package CRUD;

import CONEXAO_BANCO.Banco_dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sog7jvl
 */
public class Vendas extends javax.swing.JDialog {

    /**
     * Creates new form Vendas
     */
    public Vendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    Banco_dados bd = new Banco_dados();
    
    private void pesquisaCliente(){
        if(bd.getConnection()){
            try{
                String query = "select * from cliente where nome_cli like ?";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                smtp.setString(1,"%"+jTNomeCliente.getText()+"%");
                ResultSet rs = smtp.executeQuery();
                while(rs.next()){
                    String add1 = rs.getString("id_cliente");
                    jTCodigoCliente.setText(add1);
                    String add2 = rs.getString("nome_cli");
                    jTNomeCliente.setText(add2);
                    String add3 = rs.getString("cpf_cli");
                    jTCpfCliente.setText(add3);
                }
                smtp.close();
                bd.conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao pesquisar" + e.toString());
            }
        }
    }

    private void venda(){
        if(bd.getConnection()){
            try{
                String query = "insert vendas(fk_cliente) values(?)";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                smtp.setString(1, jTCodigoCliente.getText());
                smtp.executeUpdate();
                smtp.close();
                bd.conexao.close();
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro na venda" + erro.toString());
            }
        }
    }
    
    private void pesquisaProduto(){
        if(bd.getConnection()){
            try{
                String query = "select * from produto where id_produto like ?";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                smtp.setString(1,"%"+jTCodigoProduto.getText()+"%");
                ResultSet rs = smtp.executeQuery();
                while(rs.next()){
                    String add1 = rs.getString("id_produto");
                    jTCodigoCliente.setText(add1);
                    String add2 = rs.getString("descricao_produto");
                    jTProduto.setText(add2);
                    String add3 = rs.getString("valor_unitario");
                    jTPrecoUnitario.setText(add3);
                }
                smtp.close();
                bd.conexao.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao pesquisar" + e.toString());
            }
        }
    }
    
    private void idVenda(){
        if(bd.getConnection()){
            try{
                String query = "select max(id_vendas) as id_vendas from vendas";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                ResultSet rs = smtp.executeQuery();
                while(rs.next()){
                    String add1 = rs.getString("id_vendas");
                    jTNotaFiscal.setText(add1);
                }
                smtp.close();
                bd.conexao.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
            }
        }
    }
    float quantidade, valor, total;
    private void calcularProduto(){
        quantidade = Float.parseFloat(jTQuantidade.getText());
        valor = Float.parseFloat(jTPrecoUnitario.getText());
        total = quantidade*valor;
        jTValorTotal.setText(String.valueOf(total));
    }
    
    private void adicionarItensVendas(){
        if(bd.getConnection()){
            try{
                String query = "insert produto_has_vendas(fk_vendas, fk_produto, quantidade, "
                        + "valor_unitario, total) values (?,?,?,?,?)";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                smtp.setString(1, jTNotaFiscal.getText());
                smtp.setString(2, jTCodigoProduto.getText());
                smtp.setString(3, jTQuantidade.getText());
                smtp.setString(4, jTPrecoUnitario.getText());
                smtp.setString(5, jTValorTotal.getText());
                smtp.executeUpdate();
                smtp.close();
                bd.conexao.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro: " + e.toString());
            }
        }
    }
    
    private void consultarNF(){
        if(bd.getConnection()){
            try{
                String query = "select produto_has_vendas.fk_produto, produto.descricao_produto, produto_has_vendas.valor_unitario,"
                                +" produto_has_vendas.quantidade, produto_has_vendas.total from produto_has_vendas inner join"
                                +" produto on produto_has_vendas.fk_produto = produto.id_produto where produto_has_vendas.fk_vendas = ?";
                PreparedStatement smtp = bd.conexao.prepareStatement(query);
                smtp.setString(1, jTNotaFiscal.getText());
                ResultSet rs;
                rs = smtp.executeQuery();
                DefaultTableModel model = (DefaultTableModel)jTablePesquisa.getModel();
                model.setNumRows(0);
                while(rs.next()){
                    model.addRow(new Object[]{
                        rs.getString("fk_produto"),
                        rs.getString("descricao_produto"),
                        rs.getString("valor_unitario"),
                        rs.getString("quantidade"),
                        rs.getString("total"),
                    });
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de pesquisa: " + erro.toString());
            }
        }
    }
    
    private void somaNF(){
        if(bd.getConnection()){
            try{
                String query = "select sum(total) as total from produto_has_vendas where fk_vendas = ?";
                PreparedStatement smtp = bd.conexao.prepareCall(query);
                smtp.setString(1, jTNotaFiscal.getText());
                ResultSet rs = smtp.executeQuery();
                if(rs.next()){
                    String add1 = rs.getString("total");
                    jTSoma.setText(add1);
                }
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão: " + erro);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTCodigoCliente = new javax.swing.JTextField();
        jTCpfCliente = new javax.swing.JTextField();
        jTNomeCliente = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTValorTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTProduto = new javax.swing.JTextField();
        jTPrecoUnitario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTCodigoProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTNotaFiscal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePesquisa = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTSoma = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("MÓDULO DE VENDAS");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabel2.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel2.setText("Código Cliente:");

        jLabel4.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel3.setText("Nome:");

        jTNomeCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTNomeClienteCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da Nota Fiscal"));

        jLabel9.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel9.setText("Quantidade:");

        jLabel6.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel6.setText("Código Produto:");

        jLabel8.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel8.setText("Preço Unitário");

        jLabel10.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel10.setText("Valor Total:");

        jTQuantidade.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTQuantidadeCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel5.setText("Nota Fiscal");

        jTCodigoProduto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTCodigoProdutoCaretUpdate(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bosch Office Sans", 1, 14)); // NOI18N
        jLabel7.setText("Produto:");

        jButton1.setText("INICIAR VENDA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADICIONAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTPrecoUnitario, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTCodigoProduto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTNotaFiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTPrecoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablePesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Valor Unitário", "Quantidade", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(jTablePesquisa);

        jLabel11.setFont(new java.awt.Font("Bosch Office Sans", 1, 12)); // NOI18N
        jLabel11.setText("DESCRIÇÃO DE PRODUTOS VENDIDOS");

        jLabel12.setFont(new java.awt.Font("Bosch Office Sans", 3, 18)); // NOI18N
        jLabel12.setText("VALOR TOTAL:");

        jLabel13.setFont(new java.awt.Font("Bosch Office Sans", 3, 18)); // NOI18N
        jLabel13.setText("R$");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/carrinho-de-compras.png"))); // NOI18N
        jButton3.setText("Nova Venda");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cancelar.png"))); // NOI18N
        jButton4.setText("Cancelar");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/book.png"))); // NOI18N
        jButton5.setText("Finalizar Venda");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(384, 384, 384))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jTSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jTSoma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(67, 67, 67))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNomeClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTNomeClienteCaretUpdate
        pesquisaCliente();
    }//GEN-LAST:event_jTNomeClienteCaretUpdate

    private void jTCodigoProdutoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTCodigoProdutoCaretUpdate
        pesquisaProduto();
    }//GEN-LAST:event_jTCodigoProdutoCaretUpdate

    private void jTQuantidadeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTQuantidadeCaretUpdate
        calcularProduto();
    }//GEN-LAST:event_jTQuantidadeCaretUpdate

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        adicionarItensVendas();
        consultarNF();
        somaNF();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        venda();     
        idVenda();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Tela_pagamento pgto = new Tela_pagamento(null, true);
        pgto.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Vendas dialog = new Vendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCodigoCliente;
    private javax.swing.JTextField jTCodigoProduto;
    private javax.swing.JTextField jTCpfCliente;
    private javax.swing.JTextField jTNomeCliente;
    private javax.swing.JTextField jTNotaFiscal;
    private javax.swing.JTextField jTPrecoUnitario;
    private javax.swing.JTextField jTProduto;
    private javax.swing.JTextField jTQuantidade;
    private javax.swing.JTextField jTSoma;
    private javax.swing.JTextField jTValorTotal;
    private javax.swing.JTable jTablePesquisa;
    // End of variables declaration//GEN-END:variables
}
