package AgendaContacteMngUI;

/* @author ionut */


import AgendaContacteMngUI.DlgEditAddContact;
import Contact.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ionut
 */
public class jfAgendaContacte extends javax.swing.JFrame {
    
    private Data allContact = new Data();
    private DefaultListModel<Contact> model = new DefaultListModel<>();
    private List<Contact> allContacte = allContact.getAllContact();
    
    private void enableFileOperations(boolean bEnable) {
        jmiDeschidere.setEnabled(bEnable);
        jmiSalvare.setEnabled(bEnable);
    }
    
    public jfAgendaContacte() {
        initComponents();
        
        
        jListaContacte.setModel(model);
        refreshModel(allContacte);
        }
    
    private void OnUpdateUI() {
        //OnUpdateUI_withCollections();
        OnUpdateUI_withStreams();
    }
    
    private void refreshModel(List<Contact> contacte) {
        model.clear();
        for (Contact p : contacte) {
            model.addElement(p);
        }
    }
    
    /**
     *
     */
    public void OnUpdateUI_withStreams() {
        String sFiltru = jtfFiltru.getText().trim();
        Comparator<Contact> comp = getComparator();
        
        List<Contact> persToDisplay = allContacte.stream()
                .filter(p -> p.getNume().toLowerCase().contains(sFiltru.toLowerCase()) || String.valueOf(p.getdataNasterii()).contains(sFiltru))
                .sorted(comp)
                .collect(Collectors.toList());

        refreshModel(persToDisplay);
    }
    
    private Comparator<Contact> getComparator() {
        Comparator<Contact> dupaNume = (p1, p2) -> p1.getNume().compareToIgnoreCase(p2.getNume());

        //Comparator<Persoana> dupaVarsta = (p1,p2)->p1.getVarsta() - p2.getVarsta();
        Comparator<Contact> dupaVarsta = (p1, p2) -> {
            if (Integer.parseInt(p1.getdataNasterii()) < Integer.parseInt(p2.getdataNasterii())) {
                return -1;
            } else if (p1.getdataNasterii() == p2.getdataNasterii()) {
                return 0;
            } else {
                return 1;
            }
        };
              return dupaNume;  }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbAdaugareContact = new javax.swing.JButton();
        jbStergereContactSelectat = new javax.swing.JButton();
        jbEditareContactSelectat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtfFiltru = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaContacte = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmFisier = new javax.swing.JMenu();
        jmiDeschidere = new javax.swing.JMenuItem();
        jmiSalvare = new javax.swing.JMenuItem();
        jmiIesire = new javax.swing.JMenuItem();
        jmAjutor = new javax.swing.JMenu();
        jmiInregistrare = new javax.swing.JMenuItem();
        jmiDespre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbAdaugareContact.setText("Adaugare Contact");
        jbAdaugareContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdaugareContactActionPerformed(evt);
            }
        });

        jbStergereContactSelectat.setText("Stergere Contact Selectat");
        jbStergereContactSelectat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbStergereContactSelectatActionPerformed(evt);
            }
        });

        jbEditareContactSelectat.setText("Editare Contact Selectat");
        jbEditareContactSelectat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditareContactSelectatActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtru:");

        jtfFiltru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfFiltruKeyReleased(evt);
            }
        });

        jScrollPane1.setViewportView(jListaContacte);

        jmFisier.setText("Fisier");

        jmiDeschidere.setText("Deschidere");
        jmiDeschidere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeschidereActionPerformed(evt);
            }
        });
        jmFisier.add(jmiDeschidere);

        jmiSalvare.setText("Salvare");
        jmFisier.add(jmiSalvare);

        jmiIesire.setText("Iesire");
        jmiIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiIesireActionPerformed(evt);
            }
        });
        jmFisier.add(jmiIesire);

        jMenuBar1.add(jmFisier);

        jmAjutor.setText("Ajutor");

        jmiInregistrare.setText("Inregistrare");
        jmAjutor.add(jmiInregistrare);

        jmiDespre.setText("Despre");
        jmAjutor.add(jmiDespre);

        jMenuBar1.add(jmAjutor);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbAdaugareContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbStergereContactSelectat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEditareContactSelectat)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfFiltru, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfFiltru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAdaugareContact)
                    .addComponent(jbStergereContactSelectat)
                    .addComponent(jbEditareContactSelectat)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiIesireActionPerformed
        System.exit(0); 
    }//GEN-LAST:event_jmiIesireActionPerformed

    private void jbAdaugareContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdaugareContactActionPerformed
        DlgEditAddContact dlgEditare = new DlgEditAddContact(this, true, false, null);
        dlgEditare.setVisible(true);
        if (dlgEditare.getContactIncapsulatCreatValid()== true) {
            Contact cAdd = dlgEditare.getContactEditat();
            if(allContact.adaugaContact(cAdd)){
                OnUpdateUI();
            }
        }
    }//GEN-LAST:event_jbAdaugareContactActionPerformed

    private void jtfFiltruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFiltruKeyReleased
        OnUpdateUI();        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFiltruKeyReleased

    private void jbStergereContactSelectatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbStergereContactSelectatActionPerformed
        int idxSel = jListaContacte.getSelectedIndex();
        if (idxSel >= 0) {
            Contact cSelectat = model.get(idxSel);
           int i = JOptionPane.showConfirmDialog(this, "Sigur doriti sa stergeti elementul selectat?");
           if(i==0)
            allContact.stergeContact(cSelectat);
            OnUpdateUI();
       }        
       
    }//GEN-LAST:event_jbStergereContactSelectatActionPerformed

    private void jbEditareContactSelectatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditareContactSelectatActionPerformed
        int idxSel = jListaContacte.getSelectedIndex();
        if (idxSel >= 0) {
            Contact cSelectat = model.get(idxSel);
            DlgEditAddContact dlgEditare = new DlgEditAddContact(this, true, true, cSelectat);
            dlgEditare.setVisible(true);
            if (dlgEditare.getContactIncapsulatCreatValid()== true) {
                Contact cEditat = dlgEditare.getContactEditat();
                allContact.modificaContact(cSelectat, cEditat);
                OnUpdateUI();
            }
        } else {
            JOptionPane.showMessageDialog(this, "nu ati selectat nici un contact");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbEditareContactSelectatActionPerformed

    private void jmiDeschidereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeschidereActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jmiDeschidereActionPerformed
    
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
            java.util.logging.Logger.getLogger(jfAgendaContacte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfAgendaContacte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfAgendaContacte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfAgendaContacte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfAgendaContacte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Contact> jListaContacte;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdaugareContact;
    private javax.swing.JButton jbEditareContactSelectat;
    private javax.swing.JButton jbStergereContactSelectat;
    private javax.swing.JMenu jmAjutor;
    private javax.swing.JMenu jmFisier;
    private javax.swing.JMenuItem jmiDeschidere;
    private javax.swing.JMenuItem jmiDespre;
    private javax.swing.JMenuItem jmiIesire;
    private javax.swing.JMenuItem jmiInregistrare;
    private javax.swing.JMenuItem jmiSalvare;
    private javax.swing.JTextField jtfFiltru;
    // End of variables declaration//GEN-END:variables
}
