package compilador;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.showMessageDialog;

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
        
        //Set Console Invisible
        consolePanel.setVisible(false);
    }

    public void paintFunctions(String[] func, Color cor) {
        try {
            Document code = codeText.getDocument();
            String codePart = code.getText(0, code.getLength());
            int pos = 0;
            for (int i = 0; i < func.length; i++) {
                while ((pos = codePart.indexOf(func[i], pos)) >= 0) {
                    Color color = Color.BLUE;
                    StyledDocument doc = codeText.getStyledDocument();
                    Style style = codeText.addStyle("FuncStyle", null);
                    StyleConstants.setForeground(style, cor);
                    StyleConstants.setBold(style, rootPaneCheckingEnabled);
                    doc.setCharacterAttributes(pos, func[i].length(), style, true);

                    pos += func[i].length();
                }
            }
        } catch (Exception e) {

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
        topPanel = new javax.swing.JPanel();
        btNewFile = new javax.swing.JLabel();
        btOpenFile = new javax.swing.JLabel();
        btSaveFile = new javax.swing.JLabel();
        btCompile = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codeText = new javax.swing.JTextPane();
        consolePanel = new javax.swing.JPanel();
        consolePanelTop = new javax.swing.JPanel();
        lblConsole = new javax.swing.JLabel();
        lblCloseConsole = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtConsole = new javax.swing.JTextArea();

        SaveFile.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        SaveFile.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compiler - New File");

        topPanel.setBackground(new java.awt.Color(0, 102, 204));

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
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSaveFileMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSaveFileMouseEntered(evt);
            }
        });

        btCompile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compilador/img/compileProgram2.png"))); // NOI18N
        btCompile.setToolTipText("Compile Program");
        btCompile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        btCompile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCompileMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCompileMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCompileMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
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
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCompile)
                    .addComponent(btSaveFile)
                    .addComponent(btOpenFile)
                    .addComponent(btNewFile))
                .addGap(25, 25, 25))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        codeText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeTextKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(codeText);

        consolePanel.setBackground(new java.awt.Color(255, 255, 255));
        consolePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(141, 141, 141)));

        consolePanelTop.setBackground(new java.awt.Color(141, 141, 141));

        lblConsole.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblConsole.setForeground(new java.awt.Color(255, 255, 255));
        lblConsole.setText("Console");

        lblCloseConsole.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCloseConsole.setForeground(new java.awt.Color(255, 255, 255));
        lblCloseConsole.setText("X");
        lblCloseConsole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseConsoleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout consolePanelTopLayout = new javax.swing.GroupLayout(consolePanelTop);
        consolePanelTop.setLayout(consolePanelTopLayout);
        consolePanelTopLayout.setHorizontalGroup(
            consolePanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consolePanelTopLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lblConsole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCloseConsole)
                .addGap(6, 6, 6))
        );
        consolePanelTopLayout.setVerticalGroup(
            consolePanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consolePanelTopLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(consolePanelTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsole)
                    .addComponent(lblCloseConsole))
                .addGap(3, 3, 3))
        );

        jScrollPane3.setBorder(null);

        txtConsole.setEditable(false);
        txtConsole.setColumns(20);
        txtConsole.setRows(5);
        jScrollPane3.setViewportView(txtConsole);

        javax.swing.GroupLayout consolePanelLayout = new javax.swing.GroupLayout(consolePanel);
        consolePanel.setLayout(consolePanelLayout);
        consolePanelLayout.setHorizontalGroup(
            consolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consolePanelTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(consolePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0))
        );
        consolePanelLayout.setVerticalGroup(
            consolePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consolePanelLayout.createSequentialGroup()
                .addComponent(consolePanelTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(consolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(consolePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTextKeyPressed
        unPaintNoFunctions();
    }//GEN-LAST:event_codeTextKeyPressed

    private void btNewFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNewFileMouseClicked
        file = null;
        codeText.setText("");
        setTitle("Compiler - New File");
        consolePanel.setVisible(false);
        txtConsole.setText("");
    }//GEN-LAST:event_btNewFileMouseClicked

    private void btOpenFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btOpenFileMouseClicked
        int status = OpenFile.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION) {
            file = OpenFile.getSelectedFile();
            try {
                Scanner sn = new Scanner(new FileInputStream(file));
                StringBuilder buffer = new StringBuilder();
                while (sn.hasNext()) {
                    buffer.append(sn.nextLine()).append("\n");
                }
                codeText.setText(buffer.toString());
                setTitle("Compiler - " + file.getName());
                consolePanel.setVisible(false);
                txtConsole.setText("");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GICompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Erro ao abrir o arquivo.");
        }
    }//GEN-LAST:event_btOpenFileMouseClicked

    private void btSaveFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveFileMouseClicked
        if (file != null) {
            try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.write(codeText.getText());
                printWriter.close();

            } catch (FileNotFoundException ex) {
                Logger.getLogger(GICompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            int Status = SaveFile.showSaveDialog(rootPane);
            if (Status == JFileChooser.APPROVE_OPTION) {
                String fileName = JOptionPane.showInputDialog("File name", "none.txt");
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }
                File f = new File(SaveFile.getSelectedFile().getAbsolutePath() + "\\" + fileName);
                if (f.exists()) {
                    JOptionPane.showMessageDialog(rootPane, "File already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
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
            } else {
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

    private void lblCloseConsoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseConsoleMouseClicked
        consolePanel.setVisible(false);
    }//GEN-LAST:event_lblCloseConsoleMouseClicked

    private void btCompileMouseClicked(java.awt.event.MouseEvent evt) {
        String[] output = op.compileCode(codeText.getText());

        //Checagem se existe um arquivo base para salvar no mesmo diretório
        if (file == null) {
            showMessageDialog(null, "Salve o arquivo antes!");
        } else {

            try {
                //Salva os 3 arquivos ".bin" no formato: nomedoarquivo#.bin, sendo # o identificador da parte do código binário
                for (int i = 0; i < 3; i++) {
                    FileOutputStream fstream = new FileOutputStream(file.getAbsolutePath().split("\\.")[0] + Integer.toString(i) + ".bin", false);
                    Scanner scn = new Scanner(output[i]);
                    while (scn.hasNextLine()) {
                        String line = scn.nextLine();                        
                        fstream.write(Integer.parseInt(line, 2));
                    }
                    fstream.close();
                }
                //Scanner[] files = {new Scanner(output[0]), new Scanner(output[1]), new Scanner(output[2])};
                Scanner f1 = new Scanner(output[0]);
                Scanner f2 = new Scanner(output[1]);
                Scanner f3 = new Scanner(output[2]);
                int i = 0;
                
                while (f1.hasNextLine()) {
                    if (i == 0){
                        txtConsole.setText(String.format("%02d", i) + "- " + f1.nextLine() + " " + f2.nextLine() + " " + f3.nextLine());
                        i += 1;
                    }
                    else {
                        txtConsole.setText(txtConsole.getText() + "\n" + String.format("%02d", i) + "- " + f1.nextLine() + " " + f2.nextLine() + " " + f3.nextLine());
                        i += 1;
                    }       
                }
                
                consolePanel.setVisible(true);


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                showMessageDialog(null, "Compilação terminada, cheque o diretório do arquivo-fonte");
            }
        }
    }

    private static byte[] getUtf8Bytes(String s) {
        // Always specify encoding and not rely on default!
        return s.getBytes(StandardCharsets.UTF_8);
    }

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
    private javax.swing.JPanel consolePanel;
    private javax.swing.JPanel consolePanelTop;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCloseConsole;
    private javax.swing.JLabel lblConsole;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTextArea txtConsole;
    // End of variables declaration//GEN-END:variables
    RegAndOpCodes op = new RegAndOpCodes();
    private final String[] functionsToColor = {"ADD", "ADI", "SUB", "SUBI", "AND", "ANDI", "OR", "ORI",
            "EOR", "EORI", "NOT", "INC", "DEC", "MUL", "MULI", "SHL",
            "SHR", "MOV", "LDI", "IN", "OUT", "JMP", "RJMP", "BRL",
            "BRLE", "BRE", "BRNE", "BRGE", "BRG", "BRZ", "NOP", "RESET"};
    private final String[] regs = {"R0", "R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "XL", "XH"};
    private File file = null;
}
