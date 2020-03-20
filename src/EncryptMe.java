
import static Ciphers.Hill.*;
import static Ciphers.Playfair.*;
import static Ciphers.Vernem.*;
import static Ciphers.Vigenere.*;
import com.sun.management.OperatingSystemMXBean;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Raju
 */
public class EncryptMe extends javax.swing.JFrame {

    /**
     * Creates new form EncryptMe
     */
    public EncryptMe() {
        initComponents();
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        bean.getProcessCpuLoad();
    }
    private char table[][] = new char[5][5];
    float vigernecpu, vernemcpu, playfaircpu, hillcpu;
    float vigernememory, vernemmemory, playfairmemory, hillmemory;

    /*memory usage*/
    public static float memoryUsage() {

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        double memoryUsedMB = (memoryUsed * 0.000001);
//        System.out.println("total memory: " + memoryMax / (double) (1024L * 1024L) + " MB");
        float a = (float) (memoryUsedMB);
        System.out.println("memoryUsed: " + a + " MB");

        return a;
    }

    public static float CPUusage() {
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double b = bean.getProcessCpuLoad() * 100;
        float c = (float)(b);
        System.out.println(c);
        return c;
//            System.out.println(bean.getSystemCpuLoad());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        enterkey = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        playfaircipher = new javax.swing.JRadioButton();
        hillcipher = new javax.swing.JRadioButton();
        viginerecipher = new javax.swing.JRadioButton();
        vernemcipher = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        plaintext = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        decryptedplaintext = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ciphertext = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        creategraph = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EncryptMe");
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 72)); // NOI18N
        jLabel1.setText("Encryption");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("PlainText");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Key ");

        enterkey.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        enterkey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterkeyActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CipherText");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Decrypt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Decrypted PlainText");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Encryption Method", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(51, 51, 51))); // NOI18N

        buttonGroup1.add(playfaircipher);
        playfaircipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        playfaircipher.setText("PlayFair Cipher");

        buttonGroup1.add(hillcipher);
        hillcipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hillcipher.setText("Hill Cipher");

        buttonGroup1.add(viginerecipher);
        viginerecipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viginerecipher.setText("Viginerne Cipher");

        buttonGroup1.add(vernemcipher);
        vernemcipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vernemcipher.setText("Vernem Cipher");
        vernemcipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vernemcipherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hillcipher, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viginerecipher)
                    .addComponent(playfaircipher)
                    .addComponent(vernemcipher))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(hillcipher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playfaircipher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vernemcipher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viginerecipher)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        plaintext.setColumns(20);
        plaintext.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        plaintext.setRows(5);
        jScrollPane1.setViewportView(plaintext);

        decryptedplaintext.setEditable(false);
        decryptedplaintext.setColumns(20);
        decryptedplaintext.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        decryptedplaintext.setRows(5);
        jScrollPane2.setViewportView(decryptedplaintext);

        ciphertext.setEditable(false);
        ciphertext.setColumns(20);
        ciphertext.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        ciphertext.setRows(5);
        jScrollPane3.setViewportView(ciphertext);

        jButton3.setText("Choose a File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        creategraph.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        creategraph.setText("Create Graph");
        creategraph.setEnabled(false);
        creategraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creategraphActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Store");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(51, 51, 51)
                                .addComponent(enterkey, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(creategraph, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterkey, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(creategraph, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1252, 903));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Encryption
        String plain = plaintext.getText();
        String key = enterkey.getText();
        String cipher = "";
        key = key.toLowerCase();
        plain = plain.replaceAll("\\s", "");
        plain = plain.toLowerCase();
        if (viginerecipher.isSelected()) {
            key = vigenerekeyGenerate(key, plain.length());
            cipher = vigenereEncrpytion(plain, key);
            vigernememory = memoryUsage();
            vigernecpu = CPUusage();

        } else if (vernemcipher.isSelected()) {

            if (key.length() != plain.length()) {
                JOptionPane.showMessageDialog(null, "Length of key must be Equal to plaintext length,\nEnter Key Again");

            } else {
                cipher = vernemEncrpytion(plain, key);
                vernemmemory = memoryUsage();
                vernemcpu = CPUusage();
            }

        } else if (playfaircipher.isSelected()) {

            playfairmemory = memoryUsage();
            //check if plaintext length is odd
            if (plain.length() % 2 != 0) {
                plain = plain.concat("x");
            }
            //generating key and table matrix
            key = playfairkeyGenerate(key);

            String table_elements = table(key);
            table = matrix(table_elements);

            //encryption
            cipher = playfairEncryption(plain, table);

            playfaircpu = CPUusage();

        } else if (hillcipher.isSelected()) {
            if (plain.length() % 2 != 0) {
                plain = plain.concat("x");
            }
            int hill_key[][] = new int[2][2];
            if (!isKeySquare(key.length())) {
                JOptionPane.showMessageDialog(null, "Enter a perfect Square letters word,\nEnter Key Again");

            } else {
                hill_key = hillKeyGeneration(key);
                int determinant = hill_key[0][0] * hill_key[1][1] - hill_key[0][1] * hill_key[1][0];

                if (determinant == 0) {
//                hill_key = hillKeyGeneration(key);
//                determinant = hill_key[0][0] * hill_key[1][1] - hill_key[0][1] * hill_key[1][0];
                    JOptionPane.showMessageDialog(null, "Not a Valid Key ");
                    JOptionPane.showInputDialog("Enter Key Again");
                } else {
                    cipher = hillEncryption(hill_key, plain);
                    hillmemory = memoryUsage();
                    hillcpu = CPUusage();
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a Encryption Method");
        }

        ciphertext.setText(cipher);
        if (vigernecpu >0 && vernemcpu > 0 && playfaircpu >0 && hillcpu >0) {
            creategraph.setEnabled(true);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Decryption
        String cipher = ciphertext.getText();
        String key = enterkey.getText();
        String plain = "";

        key = key.toLowerCase();
        plain = cipher.toLowerCase();

        if (viginerecipher.isSelected()) {
            key = vigenerekeyGenerate(key, cipher.length());
            plain = vigenereDecrpytion(cipher, key);
        } else if (vernemcipher.isSelected()) {
            key = vigenerekeyGenerate(key, cipher.length());
            plain = vernemDecrpytion(cipher, key);
        } else if (playfaircipher.isSelected()) {

            //decryption
            plain = playfairDecryption(cipher, table);

        } else if (hillcipher.isSelected()) {
            int hill_key[][] = new int[2][2];

            hill_key = hillKeyGeneration(key);
            int determinant = hill_key[0][0] * hill_key[1][1] - hill_key[0][1] * hill_key[1][0];
            hill_key = adjacentHillKey(hill_key);
            plain = hillDecryption(hill_key, cipher, determinant);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a Encryption Method");
        }

        decryptedplaintext.setText(plain);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vernemcipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vernemcipherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vernemcipherActionPerformed

    private void enterkeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterkeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterkeyActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Using this process to invoke the contructor,

        JFileChooser ch = new JFileChooser();
        ch.showOpenDialog(null);
        File f = ch.getSelectedFile();
        String filename = f.getAbsolutePath();
        FileReader reader;
        try {
            reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            plaintext.read(br, null);
            br.close();
            plaintext.requestFocus();

        } catch (FileNotFoundException e) {
            try {
                File myFile = new File(filename);
                if (myFile.createNewFile()) {
                    System.out.println("File created" + myFile.getName());
                } else {
                    System.out.println("File not created");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void creategraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creategraphActionPerformed
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        data.addValue(vigernecpu, "CPU Usage", "vigerne Cipher");
        data.addValue(vernemcpu, "CPU Usage", "vernem Cipher");
        data.addValue(playfaircpu, "CPU Usage", "playfair Cipher");
        data.addValue(hillcpu, "CPU Usage", "hill Cipher");

        data.addValue(vernemmemory, "Memory Usage", "vernem Cipher");
        data.addValue(vigernememory, "Memory Usage", "vigerne Cipher");
        data.addValue(playfairmemory, "Memory Usage", "playfair Cipher");
        data.addValue(hillmemory, "Memory Usage", "hill Cipher");

//        data.addValue(memoryMax / (double) (1024 * 1024), "Memory", "Tota Memory");
        // create a chart... 
        JFreeChart jchart = ChartFactory.createBarChart3D("Memory And CPU Consumtion", "Time", "Scale", data, PlotOrientation.VERTICAL, true, true, false);
        // create and display a frame...
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);

        ChartFrame frame = new ChartFrame("Performance", jchart);
        frame.pack();
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setSize(500,500);
        frame.setVisible(true);


    }//GEN-LAST:event_creategraphActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String file = JOptionPane.showInputDialog("Enter filename");
        try {
            FileWriter fr = new FileWriter(file + ".txt");
            fr.write(ciphertext.getText());
            fr.close();
            JOptionPane.showMessageDialog(null, "Data Inserted To file");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Data Not Inserted To file");

        }

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(EncryptMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptMe().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea ciphertext;
    private javax.swing.JButton creategraph;
    private javax.swing.JTextArea decryptedplaintext;
    private javax.swing.JTextField enterkey;
    private javax.swing.JRadioButton hillcipher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea plaintext;
    private javax.swing.JRadioButton playfaircipher;
    private javax.swing.JRadioButton vernemcipher;
    private javax.swing.JRadioButton viginerecipher;
    // End of variables declaration//GEN-END:variables
}
