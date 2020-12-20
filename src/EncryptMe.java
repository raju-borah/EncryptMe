
import com.sun.management.OperatingSystemMXBean;
import java.awt.Color;
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

// custom package 'Ciphers' is created for the ciphers and classes are imported
import static Ciphers.Hill.*;
import static Ciphers.Playfair.*;
import static Ciphers.Vernem.*;
import static Ciphers.Vigenere.*;

/**
 *
 * @author Raju CS16MSIIT020
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
    float vigernecpu, vernemcpu, playfaircpu, hillcpu;
    double vigernememory, vernemmemory, playfairmemory, hillmemory;

    /*memory usage*/
    public static double memoryUsage() {

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memoryUsed = runtime.totalMemory() - runtime.freeMemory();
        double memoryUsedMB = (memoryUsed * .0000009);
//        System.out.println("total memory: " + memoryMax / (double) (1024L * 1024L) + " MB");
        System.out.println("memoryUsed: " + memoryUsedMB + " MB");

        return memoryUsedMB;
    }

    /*CPU Usages*/
    public static float CPUusage() {
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        double b = bean.getProcessCpuLoad() * 100;
        float c = (float) (b);
        System.out.println(c);
        return c;
    }

    /*checking plaintext length is even or not*/
    private static String evenlength(String p) {
        if (p.length() % 2 != 0) {
            p = p.concat("x");
        }
        return p;
    }

    /*checking text have special characters and numbers*/
    private boolean isAlphabates(String plain) {
        return plain != null && plain.matches("[a-zA-Z]*");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        OptionPanel = new javax.swing.JPanel();
        Methods = new javax.swing.JPanel();
        playfaircipher = new javax.swing.JRadioButton();
        hillcipher = new javax.swing.JRadioButton();
        viginerecipher = new javax.swing.JRadioButton();
        vernemcipher = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        creategraph = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        enterkey = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        plaintext = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ciphertext = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        decryptedplaintext = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EncryptMe");
        setBackground(new java.awt.Color(51, 51, 0));
        setName("EncryptMe"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        bg.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 72)); // NOI18N
        jLabel1.setText("ENCRYPT");

        OptionPanel.setBackground(new java.awt.Color(51, 51, 51));

        Methods.setBackground(new java.awt.Color(51, 51, 51));
        Methods.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 204, 204)), "Ciphers", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        Methods.setForeground(new java.awt.Color(255, 255, 255));
        Methods.setLayout(new java.awt.GridBagLayout());

        playfaircipher.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(playfaircipher);
        playfaircipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        playfaircipher.setForeground(new java.awt.Color(255, 255, 255));
        playfaircipher.setText("PlayFair Cipher");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 69, 0, 67);
        Methods.add(playfaircipher, gridBagConstraints);

        hillcipher.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(hillcipher);
        hillcipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        hillcipher.setForeground(new java.awt.Color(255, 255, 255));
        hillcipher.setText("Hill Cipher");
        hillcipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hillcipherActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(65, 69, 0, 67);
        Methods.add(hillcipher, gridBagConstraints);

        viginerecipher.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(viginerecipher);
        viginerecipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        viginerecipher.setForeground(new java.awt.Color(255, 255, 255));
        viginerecipher.setText("Viginerne Cipher");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 69, 65, 67);
        Methods.add(viginerecipher, gridBagConstraints);

        vernemcipher.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(vernemcipher);
        vernemcipher.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        vernemcipher.setForeground(new java.awt.Color(255, 255, 255));
        vernemcipher.setText("Vernem Cipher");
        vernemcipher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vernemcipherActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 69, 0, 67);
        Methods.add(vernemcipher, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Encrypt");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Decrypt");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        creategraph.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        creategraph.setText("Create Graph");
        creategraph.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        creategraph.setEnabled(false);
        creategraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creategraphActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setText("Store");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 72)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("MESSAGE");

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton6.setText("Clear All");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Developed by: Raju");
        jLabel7.setToolTipText("Developed by: Raju");

        javax.swing.GroupLayout OptionPanelLayout = new javax.swing.GroupLayout(OptionPanel);
        OptionPanel.setLayout(OptionPanelLayout);
        OptionPanelLayout.setHorizontalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OptionPanelLayout.createSequentialGroup()
                .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OptionPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(OptionPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addGroup(OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Methods, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(creategraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        OptionPanelLayout.setVerticalGroup(
            OptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Methods, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(creategraph, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 2, true));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Key ");

        enterkey.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        enterkey.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        enterkey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterkeyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("PlainText");

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("Choose a File");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        plaintext.setColumns(20);
        plaintext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        plaintext.setRows(5);
        plaintext.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        jScrollPane1.setViewportView(plaintext);

        ciphertext.setEditable(false);
        ciphertext.setColumns(20);
        ciphertext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ciphertext.setRows(5);
        ciphertext.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        jScrollPane3.setViewportView(ciphertext);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("CipherText");

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton5.setText("Choose a File");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        decryptedplaintext.setEditable(false);
        decryptedplaintext.setColumns(20);
        decryptedplaintext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        decryptedplaintext.setRows(5);
        decryptedplaintext.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        jScrollPane2.setViewportView(decryptedplaintext);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Decrypted PlainText");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(367, 367, 367)))
                    .addComponent(enterkey, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(enterkey, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(OptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(OptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(bg);

        setSize(new java.awt.Dimension(1297, 969));
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

        if (plain.isEmpty() || key.isEmpty()) {
            //checking key or plaintext is empty or not
            JOptionPane.showMessageDialog(null, "Key or Plaintext cannot be Empty");
        } else if (isAlphabates(plain) && isAlphabates(key)) {

            if (viginerecipher.isSelected()) {
                //generating key
                key = vigenerekeyGenerate(key, plain.length());

                //Encrypting the plaintext
                cipher = vigenereEncrpytion(plain, key);

                //calling the memoryUsage and CPUusage 
                vigernememory = memoryUsage();
                vigernecpu = CPUusage();

            } else if (vernemcipher.isSelected()) {

                if (key.length() != plain.length()) {
                    //checking plaintext and key length are same or not
                    JOptionPane.showMessageDialog(null, "Length of key must be Equal to plaintext length,\nEnter Key Again");
                } else {
                    //encrypting the plaintext
                    cipher = vernemEncrpytion(plain, key);

                    //calling the function for the memory and cpu usage
                    vernemmemory = memoryUsage();
                    vernemcpu = CPUusage();
                }

            } else if (playfaircipher.isSelected()) {
                //creating array 
                char table[][] = new char[5][5];
                //check if plaintext length is odd
                plain = evenlength(plain);

                //generating key and table matrix
                key = playfairkeyGenerate(key);
                String table_elements = table(key);
                table = matrix(table_elements);

                //encryption
                cipher = playfairEncryption(plain, table);

                //calling the function for the memory and cpu usage                
                playfairmemory = memoryUsage();
                playfaircpu = CPUusage();

            } else if (hillcipher.isSelected()) {
                //checking plaintext length is even or not
                plain = evenlength(plain);

                int hill_key[][] = new int[2][2];

                //checking the key is 2by2 matrix or not
                if (!isKeySquare(key.length())) {
                    JOptionPane.showMessageDialog(null, "Enter a 2 X 2 matrix key,\nEnter Key Again");

                } else {
                    //key generation and determinat evaluation
                    hill_key = hillKeyGeneration(key);
                    int determinant = hill_key[0][0] * hill_key[1][1] - hill_key[0][1] * hill_key[1][0];

                    if (determinant <= 0) {
                        JOptionPane.showMessageDialog(null, "Not a Valid Key ");
                        JOptionPane.showMessageDialog(null, "Enter Key Again");
                    } else {
                        //encryption
                        cipher = hillEncryption(hill_key, plain);
                        //cpu and memory usage
                        hillmemory = memoryUsage();
                        hillcpu = CPUusage();
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Please select a Encryption Method");
            }

            ciphertext.setText(cipher);
            //if all the variable are assigned with value then the CREATE GRAPGH button will be enabled
            if (vigernememory > 0 && vernemmemory > 0 && playfairmemory > 0 && hillmemory > 0) {
                creategraph.setEnabled(true);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Key And Plaintext \nwithout special char and numbers");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Decryption
        String cipher = ciphertext.getText();
        String key = enterkey.getText();
        String plain = "";
        key = key.toLowerCase();
        cipher = cipher.toLowerCase();
        cipher = cipher.replaceAll("\\s", "");

        if (cipher.isEmpty() && key.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Key or ciphertext cannot be Empty");
        } else if (cipher.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ciphertext Field cannot be Empty,\nPlease select a file");
        } else if (isAlphabates(cipher) && isAlphabates(key)) {

            if (viginerecipher.isSelected()) {
                //generating key and decryption
                key = vigenerekeyGenerate(key, cipher.length());
                plain = vigenereDecrpytion(cipher, key);
                vigernememory = memoryUsage();
                vigernecpu = CPUusage();
            } else if (vernemcipher.isSelected()) {
                if (key.length() != cipher.length()) {
                    JOptionPane.showMessageDialog(null, "Length of key must be Equal to ciphertext length,\nEnter Key Again");

                } else {
                    //decryption
                    plain = vernemDecrpytion(cipher, key);
                    vernemmemory = memoryUsage();
                    vernemcpu = CPUusage();
                }

            } else if (playfaircipher.isSelected()) {
                char table[][] = new char[5][5];
                //generating key and table matrix
                key = playfairkeyGenerate(key);
                String table_elements = table(key);
                table = matrix(table_elements);

                //decryption and cpu memory usage
                plain = playfairDecryption(cipher, table);
                playfairmemory = memoryUsage();
                playfaircpu = CPUusage();

            } else if (hillcipher.isSelected()) {
                int hill_key[][] = new int[2][2];
                if (!isKeySquare(key.length())) {
                    JOptionPane.showMessageDialog(null, "Enter a 2 X 2 matrix key,\nEnter Key Again");

                } else {
                    hill_key = hillKeyGeneration(key);
                    int determinant = hill_key[0][0] * hill_key[1][1] - hill_key[0][1] * hill_key[1][0];

                    if (determinant <= 0) {
                        JOptionPane.showMessageDialog(null, "Not a Valid Key ");
                        JOptionPane.showMessageDialog(null, "Enter Key Again");
                    } else {
                        //generating inverse key and decryption
                        hill_key = adjacentHillKey(hill_key);
                        plain = hillDecryption(hill_key, cipher, determinant);
                        hillmemory = memoryUsage();
                        hillcpu = CPUusage();
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Please select a Decryption Method");
            }

            decryptedplaintext.setText(plain);
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Key and ciphertext \nwithout special char and numbers");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void vernemcipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vernemcipherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vernemcipherActionPerformed

    private void creategraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creategraphActionPerformed
        //creating dataset for the graph
        DefaultCategoryDataset data = new DefaultCategoryDataset();

        data.addValue(vigernecpu, "CPU Usage", "vigerne Cipher");
        data.addValue(vernemcpu, "CPU Usage", "vernem Cipher");
        data.addValue(playfaircpu, "CPU Usage", "playfair Cipher");
        data.addValue(hillcpu, "CPU Usage", "hill Cipher");

        data.addValue(vigernememory, "Memory Usage", "vigerne Cipher");
        data.addValue(vernemmemory, "Memory Usage", "vernem Cipher");
        data.addValue(playfairmemory, "Memory Usage", "playfair Cipher");
        data.addValue(hillmemory, "Memory Usage", "hill Cipher");

        // create a chart... 
        JFreeChart jchart = ChartFactory.createBarChart3D("Memory And CPU Consumtion", "Ciphers", "Scale (CPU in percentage) & (Memory in MB)", data, PlotOrientation.VERTICAL, true, true, false);
        // create and display a frame
        CategoryPlot plot = jchart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        
        ChartFrame frame = new ChartFrame("Performance", jchart);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(900, 700);
        frame.setVisible(true);


    }//GEN-LAST:event_creategraphActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String plainfile = JOptionPane.showInputDialog("Enter filename for PlainText:");
        String cipherfile = JOptionPane.showInputDialog("Enter filename for CipherText:");

        if (JOptionPane.OK_CANCEL_OPTION == 2) {
            try {

                if (plainfile.isEmpty() | cipherfile.isEmpty() | plainfile.equals(cipherfile)) {
                    JOptionPane.showMessageDialog(null, "File not created.\nGiven filename for plaintext and ciphertext are same\nOR\nfilename not given");
                } else {
                    FileWriter fr = new FileWriter(plainfile + ".txt");
                    fr.write(plaintext.getText());
                    fr.close();

                    fr = new FileWriter(cipherfile + ".txt");
                    fr.write(ciphertext.getText());
                    fr.close();
                    JOptionPane.showMessageDialog(null, "File created");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Data Not Inserted To file");

            }
        } else {

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Using this process to invoke the contructor,
        try {
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(null);
            File f = ch.getSelectedFile();
            String filename = f.getAbsolutePath();
            FileReader reader;

            reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            plaintext.read(br, null);
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "File Not Found");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void enterkeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterkeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterkeyActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(null);
            File f = ch.getSelectedFile();
            String filename = f.getAbsolutePath();
            FileReader myreader;

            ciphertext.setEditable(true);
            myreader = new FileReader(filename);
            BufferedReader br = new BufferedReader(myreader);
            ciphertext.read(br, null);
            br.close();

        } catch (FileNotFoundException e) {
            ciphertext.setEditable(false);
            JOptionPane.showMessageDialog(null, "File Not Found");
        } catch (NullPointerException | IOException ex) {
            System.out.println(ex.getMessage());
            ciphertext.setEditable(false);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        enterkey.setText("");
        plaintext.setText("");
        ciphertext.setText("");
        decryptedplaintext.setText("");
        buttonGroup1.clearSelection();
        vigernecpu = vernemcpu = playfaircpu = hillcpu = 0;
        vigernememory = vernemmemory = playfairmemory = hillmemory = 0;
        creategraph.setEnabled(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void hillcipherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hillcipherActionPerformed
        // TODO add your handling code here:
        if (hillcipher.isSelected()) {
            JOptionPane.showMessageDialog(null, "Enter a 2x2 matrix key");
        }
    }//GEN-LAST:event_hillcipherActionPerformed

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
    private javax.swing.JPanel Methods;
    private javax.swing.JPanel OptionPanel;
    private javax.swing.JPanel bg;
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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea plaintext;
    private javax.swing.JRadioButton playfaircipher;
    private javax.swing.JRadioButton vernemcipher;
    private javax.swing.JRadioButton viginerecipher;
    // End of variables declaration//GEN-END:variables

}
