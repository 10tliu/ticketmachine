/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tristan.parking.swingcient.gui;

import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tristan.parking.model.Entity;
import org.tristan.parking.swingcient.EntityListTableModel;
import org.tristan.parking.swingcient.ModelController;

/**
 *
 * @author cgallen
 */
public class ControlsJPanel extends javax.swing.JPanel {

    private static final Logger LOG = LoggerFactory.getLogger(ControlsJPanel.class);

    /**
     * Model controller allows data to be injected into the component
     */
    private ModelController m_modelController = null;

    private EntityListTableModel entityListTableModel = null;

    /**
     * constructor which gives model controller to component
     *
     * @param modelController
     */
    public ControlsJPanel(ModelController modelController) {
        this.m_modelController = modelController;
        entityListTableModel = modelController.getEntityListTableModel();
        initComponents();

        jTable1.setModel(entityListTableModel);

        // list selected action added to table
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

                // do some actions here, for example
                //Ignore extra events sent for selections
                if (event.getValueIsAdjusting()) {
                    return;
                }

                String entityIdstr = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
                LOG.debug("table row selected :" + entityIdstr);

                String field_A = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
                String field_B = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
                String field_C = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
                Entity entity = new Entity();
                entity.setField_A(field_A);
                entity.setField_B(field_B);
                entity.setField_C(field_C);
                try {
                    entity.setId(Integer.parseInt(entityIdstr));
                } catch (NumberFormatException ex) {

                }
                entityFieldsJPanel1.setModelEntity(entity);

            }
        });

    }

    /**
     * Creates new form EntityListJPanel
     */
    public ControlsJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entityFieldsJPanel1 = new org.tristan.parking.swingcient.gui.EntityFieldsJPanel();
        buttonPanel1 = new java.awt.Panel();
        findMatchingButton = new java.awt.Button();
        clearSearchButton = new java.awt.Button();
        reloadDataButton = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(entityFieldsJPanel1);

        buttonPanel1.setMaximumSize(new java.awt.Dimension(102, 34));
        buttonPanel1.setLayout(new javax.swing.BoxLayout(buttonPanel1, javax.swing.BoxLayout.Y_AXIS));

        findMatchingButton.setActionCommand("findMatching");
        findMatchingButton.setLabel("Find Matching");
        findMatchingButton.setName("find"); // NOI18N
        findMatchingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMatchingButtonActionPerformed(evt);
            }
        });
        buttonPanel1.add(findMatchingButton);

        clearSearchButton.setActionCommand("clearSearchButton");
        clearSearchButton.setLabel("Clear Search");
        clearSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearSearchButtonActionPerformed(evt);
            }
        });
        buttonPanel1.add(clearSearchButton);

        reloadDataButton.setActionCommand("reloadData");
        reloadDataButton.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        reloadDataButton.setLabel("Reload Source Data");
        reloadDataButton.setName("reloadData"); // NOI18N
        reloadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadDataButtonActionPerformed(evt);
            }
        });
        buttonPanel1.add(reloadDataButton);
        reloadDataButton.getAccessibleContext().setAccessibleName("");

        jPanel1.add(buttonPanel1);

        add(jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void clearSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearSearchButtonActionPerformed
        // TODO add your handling code here:

        LOG.debug("clearSearchButton selected ");
        Entity templateEntity = new Entity();
        entityFieldsJPanel1.setModelEntity(templateEntity);
        jTable1.clearSelection();
        // running query in seperate thread 
        SwingWorker worker = new SwingWorker<String, Void>() {
            @Override
            public String doInBackground() {
                // TODO do search for matching items
                m_modelController.findMatchingSearch(templateEntity);
                return null;
            }

            @Override
            public void done() {
            }
        };
        worker.execute();


    }//GEN-LAST:event_clearSearchButtonActionPerformed

    private void findMatchingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMatchingButtonActionPerformed
        // TODO add your handling code here:
        // see https://docs.oracle.com/javase/6/docs/api/javax/swing/SwingWorker.html
        LOG.debug("findMatchingButton selected ");
        Entity templateEntity = entityFieldsJPanel1.getModelEntity();
        jTable1.clearSelection();
        // running query in seperate thread 
        SwingWorker worker = new SwingWorker<String, Void>() {
            @Override
            public String doInBackground() {
                // now redisplay data
                m_modelController.findMatchingSearch(templateEntity);
                return null;
            }

            @Override
            public void done() {
            }
        };
        worker.execute();


    }//GEN-LAST:event_findMatchingButtonActionPerformed

    private void reloadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadDataButtonActionPerformed
        LOG.debug("reload data button selected ");
        // empty entity so load all data
        Entity templateEntity = new Entity();
        jTable1.clearSelection();
        // running query in seperate thread 
        SwingWorker worker = new SwingWorker<String, Void>() {
            @Override
            public String doInBackground() {
                // TODO reload source data
                m_modelController.forceReloadData();

                // now redisplay data
                m_modelController.findMatchingSearch(templateEntity);
                return null;
            }

            @Override
            public void done() {
            }
        };
        worker.execute();


    }//GEN-LAST:event_reloadDataButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Panel buttonPanel1;
    private java.awt.Button clearSearchButton;
    private org.tristan.parking.swingcient.gui.EntityFieldsJPanel entityFieldsJPanel1;
    private java.awt.Button findMatchingButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Button reloadDataButton;
    // End of variables declaration//GEN-END:variables
}
