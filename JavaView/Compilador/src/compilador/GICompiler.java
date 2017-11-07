package compilador;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class GICompiler extends javax.swing.JFrame {

    public GICompiler() {
        initComponents();
        
        //Run the thread to check funtions on the program.
        codeChanges codechanges = new codeChanges(this);
        Runnable runnable = codechanges;
        Thread thread = new Thread(runnable);
        thread.start();
        
        //Set the open file to just open txt files.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        OpenFile.setFileFilter(filter);
        
        //Set the window location to the center of the screen.
        this.setLocationRelativeTo(null);
    }
    
    public void paintFunctions(String [] func, Color cor) {
        try {
            Document code = codeText.getDocument();
            String codePart = code.getText(0, code.getLength());
            int pos = 0;
            for (int i = 0; i < func.length; i++) {
                while ((pos = codePart.indexOf(func[i], pos)) >= 0){
                        Color color = Color.BLUE;
                        StyledDocument doc = codeText.getStyledDocument();
                        Style style = codeText.addStyle("FuncStyle", null);
                        StyleConstants.setForeground(style, cor);
                        StyleConstants.setBold(style, rootPaneCheckingEnabled);
                        doc.setCharacterAttributes(pos, func[i].length(), style, true);
                   
                        pos += func[i].length();
                }
            }           
        }
        catch (Exception e){
            
        }
    }
    
    public void unPaintNoFunctions() {
        StyledDocument code = codeText.getStyledDocument();
        Style style = codeText.addStyle("defaut", null);
        code.setCharacterAttributes(0, codeText.getDocument().getLength(), style, true);
        
    }

    public String[] getFunctionsToColor() {
        return functionsToColor;
    }

    public String[] getRegs() {
        return regs;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OpenFile = new javax.swing.JFileChooser();
        SaveFile = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        btNewFile = new javax.swing.JLabel();
        btOpenFile = new javax.swing.JLabel();
        btSaveFile = new javax.swing.JLabel();
        btCompile = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codeText = new javax.swing.JTextPane();

        SaveFile.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        SaveFile.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiler - New File");

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        btNewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/img/newFileIcon2.png"))); // NOI18N
        btNewFile.setToolTipText("New File");
        btNewFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btNewFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNewFileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btNewFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btNewFileMouseExited(evt);
            }
        });

        btOpenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/img/openFileIcon2.png"))); // NOI18N
        btOpenFile.setToolTipText("Open File");
        btOpenFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btOpenFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btOpenFileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btOpenFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btOpenFileMouseExited(evt);
            }
        });

        btSaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/img/saveFileIcon2.png"))); // NOI18N
        btSaveFile.setToolTipText("Save File");
        btSaveFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btSaveFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSaveFileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSaveFileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSaveFileMouseExited(evt);
            }
        });

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/img/compileProgram2.png"))); // NOI18N
        btCompile.setToolTipText("Compile Program");
        btCompile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btCompile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCompileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCompileMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btNewFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btOpenFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSaveFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCompile)
                .addContainerGap(637, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCompile)
                    .addComponent(btSaveFile)
                    .addComponent(btOpenFile)
                    .addComponent(btNewFile))
                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        codeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeTextKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(codeText);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTextKeyPressed
        unPaintNoFunctions();
        //paintFunctions(functionsToColor, Color.blue);
        //paintFunctions(regs, Color.GREEN);
    }//GEN-LAST:event_codeTextKeyPressed

    private void btNewFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewFileMouseClicked
        file = null;
        codeText.setText("");
        setTitle("Compiler - New File");
    }//GEN-LAST:event_btNewFileMouseClicked

    private void btOpenFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOpenFileMouseClicked
        int status = OpenFile.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION) {
            file = OpenFile.getSelectedFile();
            try {
                Scanner sn = new Scanner(new FileInputStream(file));
                String buffer = "";
                while (sn.hasNext()) {
                    buffer += sn.nextLine() + "\n";
                }
                codeText.setText(buffer);
                setTitle("Compiler - " + file.getName());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GICompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            System.out.println("Erro ao abrir o arquivo.");
        }
    }//GEN-LAST:event_btOpenFileMouseClicked

    private void btSaveFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveFileMouseClicked
        if(file != null) {
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.write(codeText.getText());
                printWriter.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GICompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            int Status = SaveFile.showOpenDialog(rootPane);
            if(Status == JFileChooser.APPROVE_OPTION) {
                String fileName = JOptionPane.showInputDialog("File name", "none.txt");
                if (!fileName.contains(".txt")){
                    fileName += ".txt";
                }
                File f = new File(SaveFile.getSelectedFile() + "\\" + fileName);
                if (f.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "File already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    try {
                        f.createNewFile();
                        PrintWriter printWriter = new PrintWriter(f);
                        printWriter.write(codeText.getText());
                        printWriter.close();
                        setTitle("Compiler - " + fileName);
                        file = f;
                    } catch (IOException ex) {
                        Logger.getLogger(GICompiler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } 
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Error occured", "Can't save file", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btSaveFileMouseClicked

    private void btSaveFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveFileMouseEntered
        btSaveFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 180, 240), 1, true));
    }//GEN-LAST:event_btSaveFileMouseEntered

    private void btSaveFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveFileMouseExited
        btSaveFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
    }//GEN-LAST:event_btSaveFileMouseExited

    private void btCompileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCompileMouseEntered
        btCompile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 180, 240), 1, true));
    }//GEN-LAST:event_btCompileMouseEntered

    private void btCompileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCompileMouseExited
        btCompile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
    }//GEN-LAST:event_btCompileMouseExited

    private void btOpenFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOpenFileMouseEntered
        btOpenFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 180, 240), 1, true));
    }//GEN-LAST:event_btOpenFileMouseEntered

    private void btOpenFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOpenFileMouseExited
        btOpenFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
    }//GEN-LAST:event_btOpenFileMouseExited

    private void btNewFileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewFileMouseEntered
        btNewFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(120, 180, 240), 1, true));
    }//GEN-LAST:event_btNewFileMouseEntered

    private void btNewFileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewFileMouseExited
        btNewFile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 204), 1, true));
    }//GEN-LAST:event_btNewFileMouseExited

    
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
            java.util.logging.Logger.getLogger(GICompiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GICompiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GICompiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GICompiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GICompiler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser OpenFile;
    private javax.swing.JFileChooser SaveFile;
    private javax.swing.JLabel btCompile;
    private javax.swing.JLabel btNewFile;
    private javax.swing.JLabel btOpenFile;
    private javax.swing.JLabel btSaveFile;
    private javax.swing.JTextPane codeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    private final String[] functionsToColor = {"ADD", "ADI", "SUB", "SUBI", "AND", "ANDI", "OR", "ORI",
                                          "EOR", "EORI", "NOT", "INC", "DEC", "MUL", "MULI", "SHL",
                                          "SHR", "MOV", "LDI", "IN", "OUT", "JMP", "RJMP", "BRL",
                                          "BRLE", "BRE", "BRNE", "BRGE", "BRG", "BRZ", "NOP", "RESET"};
    private final String[] regs = {"ra", "rb", "rc", "rd", "re", "rf", "rg", "rh", "ri", "rj", "xl", "xh"};
    private File file = null;
}
