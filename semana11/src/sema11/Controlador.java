//Jeisson David Infante Leal 
package sema11;
import com.sun.jmx.snmp.BerDecoder;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements  ActionListener{
    private Modelo modelo;
    private Vista vista;
    
    //arrayLista de tipo niño
    ArrayList<Niños> lista = new ArrayList<Niños>();
   
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.registar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.buscar.addActionListener(this);
    }
    
    public void ver(){
        vista.setTitle("Registro de niños y niñas menores de 7 años en una guarderia.");
        vista.setBounds(100, 100, 720, 600);
        vista.setVisible(true);
        vista.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //registrar
        if(vista.registar == e.getSource()){
            //darle a la clase niños los datos en el contructor
             Niños ni = new Niños((String)vista.tip.getSelectedItem(), 
             vista.nom.getText(), vista.ape.getText(),
             vista.nac.getText(), Integer.parseInt(vista.eda.getText()) 
             );
             lista.add(ni);
             //paso la lista al modelo
             modelo.setLista(lista);
             vista.tab.setModel(new DefaultTableModel(
              modelo.poner(), vista.columnNames
             ));
             //promedio de edades
             vista.pro.setText(modelo.prom()+"");
             
             //sumar niños y niñas
             if(vista.registar == e.getSource() && (String)vista.tip.getSelectedItem() == "Niño"){
                 modelo.nC("Niño");
                 vista.nc.setText(modelo.numCaninos()+"");
              }
              if(vista.registar == e.getSource() && (String)vista.tip.getSelectedItem() == "Niña"){
                  modelo.nF("Niña");
                  vista.cf.setText(modelo.numFelinos()+"");
              }
              
             
              
              
              //limpio
              vista.nom.setText("");
              vista.ape.setText("");
              vista.eda.setText(0+"");
              vista.nac.setText("");
              
              vista.bu.setText("");
              vista.tip.select(0);
        }
        //evento para el boton eliminar
        if(vista.eliminar == e.getSource()){
            vista.tab.addMouseListener(new MouseAdapter() {
            DefaultTableModel model = new DefaultTableModel();
            
            //pasar a modelo los valores de el campo que se clickeo
             public void mouseClicked(MouseEvent e) {
                int i = vista.tab.getSelectedRow();
                modelo.setGenero((vista.tab.getValueAt(i, 0).toString()));
                modelo.setNombre(vista.tab.getValueAt(i, 1).toString());
                modelo.setEdad(vista.tab.getValueAt(i, 2).toString());
                modelo.setRaza(vista.tab.getValueAt(i, 3).toString());
                modelo.setColor(vista.tab.getValueAt(i,4).toString());
              }
           });
            
            
             modelo.eliminar();   
           
            if(modelo.verificar() == true){
               vista.tab.setModel(new DefaultTableModel(
               modelo.actualizar(),vista.columnNames
               ));
                 vista.pro.setText(modelo.prom2()+"");
                 vista.nc.setText(modelo.numCaninos()+"");
                 vista.cf.setText(modelo.numFelinos()+"");
             }
        }
        //evento de buscar
        if(vista.buscar == e.getSource()){
             String nom = vista.bu.getText();
             if(!nom.isEmpty()){
                 nom.replace(" ","");
                 try {
                     modelo.buscar(nom);
                     vista.dataBase.setText(modelo.rNombre()+'\n'+
                             "Precio del cuidado por día: "+ modelo.ponPrecio()
                             +'\n'+"El servicio comprende:"+'\n'+modelo.ponServi());
                 } catch (IOException ex) {
                     Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        }
    }
}
