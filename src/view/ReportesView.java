package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window;

import javax.imageio.ImageIO;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

//-------------

import controller.ReportesController;
import model.dao.ComprasDao;
import model.vo.ComprasVo;
import model.vo.CasaCampestreVo;
import model.vo.LiderVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportesView extends JFrame{
    private JPanel contentPane;
    private JTable table;

    public ReportesView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 739, 580);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 222, 179));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel;

        try {
            BufferedImage imagen = ImageIO.read(new File("./logo-Minvivienda.png"));
            lblNewLabel = new JLabel(new ImageIcon(imagen));
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        } catch (IOException ex) {
            lblNewLabel = new JLabel("Ministerio de Vivienda");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
        }
        lblNewLabel.setBounds(166, 11, 367, 100);
        contentPane.add(lblNewLabel);



        JLabel lblNewLabel_1 = new JLabel("!Bienvenido! Con esta aplicacion podrás consultar informes a partir de la base de datos. ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(36, 126, 561, 38);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Generar Informes");
        btnNewButton.setBounds(269, 219, 147, 33);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Salir");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp);
                win.dispose();
            }
        });
        btnNewButton_1.setBounds(269, 415, 147, 33);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Primer Informe");
        btnNewButton_2.setBounds(269, 175, 146, 33);
        btnNewButton_2.setVisible(false);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Segundo Informe");
        btnNewButton_3.setBounds(269, 219, 147, 33);
        btnNewButton_3.setVisible(false);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Tercer Informe");
        btnNewButton_4.setBounds(269, 263, 147, 33);
        btnNewButton_4.setVisible(false);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Atras");
        btnNewButton_5.setVisible(false);
        btnNewButton_5.setBounds(36, 479, 147, 38);
        contentPane.add(btnNewButton_5);



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_5.setVisible(true);
                btnNewButton.setVisible(false);
                btnNewButton_2.setVisible(true);
                btnNewButton_3.setVisible(true);
                btnNewButton_4.setVisible(true);
                lblNewLabel_1.setText("Selecciona el informe que deseas consultar.");
                btnNewButton_1.setLocation(535,480);

            }
        });

        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButton_5.setVisible(false);
                btnNewButton.setVisible(true);
                btnNewButton_2.setVisible(false);
                btnNewButton_3.setVisible(false);
                btnNewButton_4.setVisible(false);
                lblNewLabel_1.setText("!Bienvenido! Con esta aplicacion podrás consultar informes a partir de la base de datos.");
                btnNewButton_1.setBounds(269, 415, 147, 33);

            }
        });

        table = new JTable();

//        mostrar primer informe
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {primerInforme();}
        });

        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {segundoInforme();}
        });

        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tercerInforme();
            }
        });


        try {
            JLabel lblNewLabel_2 = new JLabel();
            BufferedImage imagen = ImageIO.read(new File("./logo-mision.png"));
            lblNewLabel_2 = new JLabel(new ImageIcon(imagen));
            lblNewLabel_2.setBounds(181, 219, 324, 166);
            contentPane.add(lblNewLabel_2);
        } catch (IOException ex) {
        }
    }
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void primerInforme(){

        List<LiderVo> reporte;
        try{
            var consulta= new ReportesController();
            reporte=consulta.primerInforme();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Ciudad");
            for(LiderVo elemento:reporte){
                Object [] fila = new Object[4];
                fila[0]=elemento.getId_lider();
                fila[1]=elemento.getNombre();
                fila[2]=elemento.getPrimerApellido();
                fila[3]=elemento.getCiudad();
                model.addRow(fila);
            }
            table.setModel(model);
            JFrame f = new JFrame();
            f.setSize(640, 480);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }

    public void segundoInforme(){

        List<CasaCampestreVo> reporte;
        try{
            var consulta= new ReportesController();
            reporte=consulta.segundoInforme();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Proyecto");
            model.addColumn("Constructora");
            model.addColumn("# Habitaciones");
            model.addColumn("Ciudad");
            for(CasaCampestreVo elemento:reporte){
                Object [] fila = new Object[4];
                fila[0]=elemento.getId_proyecto();
                fila[1]=elemento.getConstructora();
                fila[2]=elemento.getN_habitaciones();
                fila[3]=elemento.getCiudad();
                model.addRow(fila);
            }
            table.setModel(model);
            JFrame f = new JFrame();
            f.setSize(640, 480);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }

    public void tercerInforme(){

        List<ComprasVo> reporte;
        try{
            var consulta= new ReportesController();
            reporte=consulta.tercerInforme();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Compra");
            model.addColumn("Constructora");
            model.addColumn("Banco Vinculaado");
            for(ComprasVo elemento:reporte){
                Object [] fila = new Object[3];
                fila[0]=elemento.getId_compra();
                fila[1]=elemento.getConstructora();
                fila[2]=elemento.getBanco();
                model.addRow(fila);
            }
            table.setModel(model);
            JFrame f = new JFrame();
            f.setSize(640, 480);
            f.add(new JScrollPane(table));
            f.setVisible(true);
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }

}