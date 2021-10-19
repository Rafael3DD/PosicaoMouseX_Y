
package click;

import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

public class Tela extends javax.swing.JFrame {

    public Tela() {
        initComponents();
    }
    
    //metodo para gravar os dados no documento .txt
    public String gravar(String x, String y){
        try{
            FileWriter fw = new FileWriter("coordenada.txt", true);
            PrintWriter pw = new PrintWriter(fw);
                           
            pw.println("klick(" + x +","+y+")"+";");
            pw.println("-------------------------------------------");
            pw.flush();
            pw.close();
            fw.close();
   
        }catch(Exception e){
            return null;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cord_y = new javax.swing.JLabel();
        cord_x = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabela.setForeground(new java.awt.Color(255, 0, 0));
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "X", "Y"
            }
        ));
        tabela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        cord_y.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cord_y.setForeground(new java.awt.Color(0, 0, 204));
        cord_y.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cord_y.setText("Y");

        cord_x.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cord_x.setForeground(new java.awt.Color(255, 0, 0));
        cord_x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cord_x.setText("X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cord_x, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cord_y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cord_x, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(cord_y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaKeyPressed
        //após clicar na tecla "e" é executado 
        if (evt.getKeyCode() ==  KeyEvent.VK_E) {
        System.out.println("("+MouseInfo.getPointerInfo().getLocation().x+", "+MouseInfo.getPointerInfo().getLocation().y+")");
        double mousex = MouseInfo.getPointerInfo().getLocation().getX();
        double mousey = MouseInfo.getPointerInfo().getLocation().getY();
        cord_x.setText(""+(long)mousex); 
        cord_y.setText(""+(long)mousey);
        
        //grava na tabela os dados
        DefaultTableModel dados = (DefaultTableModel) tabela.getModel();
        Object [] dados_tabela ={
        cord_x.getText(),
        cord_y.getText()
               
        
        };
      dados.addRow(dados_tabela);
      
      //chama a gravação no documento
      gravar(cord_x.getText(), cord_y.getText());
        }
    }//GEN-LAST:event_tabelaKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cord_x;
    private javax.swing.JLabel cord_y;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
