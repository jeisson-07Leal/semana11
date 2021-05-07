//Jeisson David Infante Leal
package sema11;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame{
    JPanel p1; 
    Choice tip;
    JLabel nombre, apellidos, edad, nacionalidad, prom, numC, numF, bus;
    JLabel tipo;
    JButton registar, eliminar, buscar;
    JTable tab;
    JTextField nom, eda, ape, nac, pro , nc ,cf, bu;
    JScrollPane sc;
    DefaultTableModel dtm;
    JTextArea info,dataBase;
    String[] columnNames = {"Genero", "Nombre", "Apellidos","Edad(meses)","Nacionalidad"};
  public Vista(){
      
      
      p1= new JPanel();
      p1.setLayout(null);
      p1.setBackground(Color.cyan);
      
      nombre = new JLabel("1er Nombre:"); 
      nombre.setBounds(20,70,120,40);
      Font fuente = new Font("Arial", 3, 13);
      nombre.setFont(fuente);
      nombre.setForeground(Color.BLACK);
      
      apellidos = new JLabel("Apellidos:");
      apellidos.setBounds(20,106,120,40);
      
      edad = new JLabel("Edad(meses):");
      edad.setBounds(20,150,120,40);
      
      nacionalidad = new JLabel("Nacionalidad:");
      nacionalidad.setBounds(20,190,120,40);
      
      prom = new JLabel("Promedio edad de los niñ@s(meses):");
      prom.setBounds(20,420,220,40);
      
      numC = new JLabel("Número de niños:");
      numC.setBounds(20,455,120,40);
      
      numF = new JLabel("Número de niñas:");
      numF.setBounds(20,495,120,40);
      
      
      
      bus = new JLabel("Escriba el nombre como esta en la tabla:");
      bus.setBounds(160,365,250,40);
      
      tipo=new JLabel("Genero:");
      tipo.setBounds(20, 40, 80, 20);
      
      tip=new Choice();
      tip.setBounds(102, 40, 140, 60);
      tip.addItem("Seleccionar");
      tip.addItem("Niño");
      tip.addItem("Niña");
      
      registar = new JButton("Registrar");
      registar.setBounds(20,240,220,30);
      registar.setBackground(Color.green);


        Object[][] datos = {
           {null, null, null,null,null},
           {null, null, null,null,null},
           {null, null, null,null,null},
           {null, null, null,null,null},
           {null, null, null,null,null}};

         dtm = new DefaultTableModel(datos, columnNames);
         final JTable table = new JTable(dtm);

         //table.setPreferredScrollableViewportSize(new Dimension(250, 100));
         JScrollPane scrollPane = new JScrollPane(table);
         add(scrollPane);
      
      tab = new JTable(dtm);
      sc = new JScrollPane(tab);
      sc.setBounds(20,280,650,80);
     
      tab.setBounds(20,280,650,80);
       
      eliminar = new JButton("Eliminar");
      eliminar.setBounds(20,370,120,30);
      
      buscar = new JButton("Imprimir en pantalla");
      buscar.setBounds(500,370,160,30);
      
      nom = new JTextField(40);
      nom.setBounds(102,74,140,30);
      
      eda = new JTextField(40);
      eda.setBounds(102,154,140,30);
      
      ape = new JTextField(40);
      ape.setBounds(102,114,140,30);
      
      nac = new JTextField(40);
      nac.setBounds(102,195,140,30);
      
      pro = new JTextField(40);
      pro.setBounds(230,425,120,30);
      pro.setEditable(false);
      pro.setBackground(Color.white);
      
      nc = new JTextField(40);
      nc.setBounds(230,460,120,30);
      nc.setEditable(false);
      nc.setBackground(Color.white);
      
      cf = new JTextField(40);
      cf.setBounds(230,500,120,30);
      cf.setEditable(false);
      cf.setBackground(Color.white);
      
      
      bu = new JTextField(40);
      bu.setBounds(400,370,90,30);
      
      info = new JTextArea("*Importante:"+ '\n'+ "para eliminar un niñ@ "
              + "de click sobre su nombre, " + '\n'+"seguido de esto click sobre el botón eliminar.");
      info.setOpaque(true);
      info.setEditable(false);
      info.setBounds(410,450,280,50);
      
      dataBase = new JTextArea();
      dataBase.setEditable(false);
      dataBase.setBounds(260, 40, 400, 200);
      
      //añadir al panel
      add(p1); 
      p1.add(tipo);
      p1.add(tip);
      p1.add(nombre);
      p1.add(apellidos);
      p1.add(edad);
      p1.add(nacionalidad);
      p1.add(registar);
      p1.add(eliminar);
      p1.add(bus);
      p1.add(buscar);
      p1.add(prom);
      p1.add(numC);
      p1.add(numF);
      p1.add(nom);
      p1.add(eda);
      p1.add(ape);
      p1.add(nac);
      p1.add(bu);
      p1.add(cf);
      p1.add(nc);
      p1.add(pro);
      p1.add(sc);
      p1.add(info);
      p1.add(dataBase);
  }
   
}
