/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpgconsistencychecker;

import javax.swing.JFileChooser;

/**
 *
 * @author APerrett
 */
public class DirectoryChooser extends javax.swing.JFrame {
    public final String NEW_LINE = "\n"; // need for outputField
    /**
     * Creates new form DirectoryChooser
     */
    public DirectoryChooser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        userSpecifiedDirectory = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputField = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        outputField.setColumns(20);
        outputField.setRows(5);
        jScrollPane1.setViewportView(outputField);

        jButton1.setText("Choose Directory");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        // Sets file chooser to start at the correct place
        userSpecifiedDirectory.setCurrentDirectory(FolderCrawler.DEFAULT_DIRECTORY);
        userSpecifiedDirectory.setDialogTitle("Select Target Directory");
        // Allows the file chooser to return if a file is not selected
        userSpecifiedDirectory.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = userSpecifiedDirectory.showOpenDialog(this);
        
        if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION ){
            FolderCrawler userFolder = new FolderCrawler(userSpecifiedDirectory.getSelectedFile());
 //           FolderCrawler.setUserDirectory(userSpecifiedDirectory.getSelectedFile());
            JpgFilesList jpgs = new JpgFilesList(userFolder);
            /* Note that use .getSelectedFile() to return the directory
            * rather than the .getSelectedDirectory() which returns the parent
            */
            outputField.setText("User Directory : " + FolderCrawler.getUserDirectory() + NEW_LINE);
            outputField.append("File Name        Size" + NEW_LINE);
            outputField.append(jpgs.toString());
            outputField.append(NEW_LINE + "There are " + userFolder.getNumOfReadable() + " readable files." + NEW_LINE);
            outputField.append("of which " + userFolder.getNumOfJpgs() + " are .jpgs " + NEW_LINE);
            outputField.append("and " + userFolder.getNumOfZeroByte() + " are zero bytes");
        }    
    }                                        

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
            java.util.logging.Logger.getLogger(DirectoryChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DirectoryChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DirectoryChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DirectoryChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DirectoryChooser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea outputField;
    private javax.swing.JFileChooser userSpecifiedDirectory;
    // End of variables declaration                   
}