//Jeisson David Infante Leal 
package sema11;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Modelo {
    private ArrayList<Niños> lista;
    private ArrayList<Niños> listBusqueda;
    private String genero = "";
    private String nombre = "";
    private String edad = "";
    private String raza = "";
    private String color = "";
    private String texto = "";
    private String ali;
    private String nC, nF, dato;
    private double caninos, felino, can=0,fel=0, e=0,e1=0;
    private double prom = 0.0, prom2=0.0, precio;
    private boolean v, verificar;
    private int tamL;

    public boolean isVerificar() {
        return verificar;
    }

    public void setVerificar(boolean verificar) {
        this.verificar = verificar;
    }
    public ArrayList<Niños> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Niños> lista) {
        this.lista = lista;
    }
    public void nC(String nc){
        this.nC = nc;
        if(nC.equals("Niño")){
            setCaninos(1);
        }
    }
    
    public void nF(String nf) {
        this.nF = nf;
        if(nF.equals("Niña")){
            setFelino(1);
        }
    }
    
    public String[][] poner() {
        String a;
        String matriz[][] = new String[lista.size()][5];
             for(int i=0;i<lista.size();i++){
                
                 if(lista.get(i).getEdad() > 84){
                    
                    matriz[i][0] = lista.get(i).getTipo();
                    matriz[i][1] = lista.get(i).getNombre();
                    matriz[i][2] = lista.get(i).getRaza();
                    matriz[i][3] = lista.get(i).getEdad()+"";
                    matriz[i][4] = lista.get(i).getColor();
                    ed(lista.get(i).getEdad());
                    tamL(lista.size());
                    listBusqueda = lista;
                    a = lista.get(i).getNombre()+":"
                         +" "+ lista.get(i).getRaza()
                         +" "+ lista.get(i).getTipo()
                         +" "+ lista.get(i).getEdad()+"Meses."
                         +" "+ lista.get(i).getColor()+"En verificación por superar edad permitida.";
                    almacena(a); 
                 }else{
                    matriz[i][0] = lista.get(i).getTipo();
                    matriz[i][1] = lista.get(i).getNombre();
                    matriz[i][2] = lista.get(i).getRaza();
                    matriz[i][3] = lista.get(i).getEdad()+"";
                    matriz[i][4] = lista.get(i).getColor();
                    ed(lista.get(i).getEdad());
                    tamL(lista.size());
                    listBusqueda = lista;
                    a = lista.get(i).getNombre()+":"
                         +" "+ lista.get(i).getRaza()
                         +" "+ lista.get(i).getTipo()
                         +" "+ lista.get(i).getEdad()+"Meses"
                         +" "+ lista.get(i).getColor();
                    almacena(a);   
                 }
            }
             System.out.println();
        return matriz;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String gen) {
        this.genero = gen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCaninos() {
        return caninos;
    }

    public void setCaninos(int caninos) {
        this.caninos = caninos;
    }

    public double getFelino() {
        return felino;
    }

    public void setFelino(int felino) {
        this.felino = felino;
    }

    public double numCaninos() {
          can += caninos;   
          this.caninos = 0;
        return can;
    }

    public double numFelinos() {
         fel += felino;   
         this.felino = 0;
       return fel;
    }

    public void eliminar() {
       for (int i = 0; i < lista.size(); i++) {
                   if(nombre == lista.get(i).getNombre()){
                       String op = JOptionPane.showInputDialog(null, "Seguro que quiere eliminar de la lista a"+ lista.get(i).getNombre()+"? (si/no)");
                       if(op.equalsIgnoreCase("si")){
                           ed1(lista.get(i).getEdad());
                           if(genero.equals("Niño")){
                                setCaninos(-1);
                           }
                           if(genero.equals("Niña")){
                               setFelino(-1);
                           }
                          
                            lista.remove(i);   
                            setVerificar(true);
                       }
                    }
            }
    }
    
    public String[][] actualizar() {
        String matriz[][] = new String[lista.size()][5];
         for (int i = 0; i < lista.size(); i++) {
            matriz[i][0] = lista.get(i).getTipo();
            matriz[i][1] = lista.get(i).getNombre();
            matriz[i][2] = lista.get(i).getRaza();
            matriz[i][3] = lista.get(i).getEdad()+"";
            matriz[i][4] = lista.get(i).getColor();
         }
         
         return matriz;
    }    
    public double prom() {
        prom = e/lista.size();
        this.e=0;
        this.e1=0;
        return prom;
    }
    
    public double prom2() {
        prom2 = ((prom * tamL)-e1)/lista.size();
        return prom2;
    }
    
    public int tamL(int tma) {
        this.tamL = tma;
        return tamL;
    }
    
    public void ed1(double e1){
        this.e1 += e1;
    }
    
    public void ed(double e){
        this.e += e;
    }
    public void buscar(String nom)throws IOException{
        nom.replace(" ","");
        for (int i = 0; i < listBusqueda.size(); i++) {
            if(nom.replace(" ","").equals(listBusqueda.get(i).getNombre().replace(" ",""))){
                    FileReader archivo = null;
                    Properties p = new Properties();
                    String ruta = this.getClass().getResource("/ninos.txt").getFile();//aunque el archivo se crea en los src de la app, aveces java no encuentra el archivo
                    archivo = new FileReader(ruta);
                    p.load(archivo);
                    String n = nom;
		    n(p.getProperty(n));
                    precio(lista.get(i).getColor());
                    servicios(lista.get(i).getEdad());
            }
        }
    }
    
    public void n(String ni) {
        this.dato = ni;
    }
    
    public String rNombre() {
        return this.dato;
    }

    public boolean verificar() {
        v = verificar;
        return v;
    }
    
    public void almacena(String anim) {  
        try {
            FileWriter archivo = new FileWriter("src"+File.separator+"ninos.txt", true);
            try(BufferedWriter almacen  = new BufferedWriter(archivo)){
                almacen.write(anim);
                almacen.write('\n');
                anim=" ";
                almacen.close();
            }
            archivo.close();
         } catch (IOException ex) {
            ex.printStackTrace();
         }  
    }
    
    public void precio(String nac) {
        if(nac.equalsIgnoreCase("Colombiano") || nac.equalsIgnoreCase("Colombiana")){
            this.precio = 50000.0;
        }else{
            this.precio = 85000.0;
        }
    }
      
    public double ponPrecio() {
        return precio;
    }
    
    public void servicios(double ed) {
        if(ed <= 24){
           this.ali = "Alimentacion:"+'\n'+"Desayuno"+'\n'+"Almuerzo"+'\n'+"Comida."+
                  '\n'+"Cuidados: Cambio de pañales"+'\n'+"Enseñarle a caminar"+'\n'+"Atención permanente."+
                  '\n'+"Generación de habitos."+
                   '\n'+"Socialización con más niños.";   
        }
        if(ed > 24){
           this.ali = "Alimentacion:"+'\n'+"Desayuno"+'\n'+"Almuerzo"+'\n'+"Comida."+
                  '\n'+"Cuidados: Generar habitos alimenticios"+'\n'+"Atención permanente."+
                   '\n'+"Socialización con más niños.";   
        }
        if( ed > 60){
              this.ali = "Alimentacion:"+'\n'+"Desayuno"+'\n'+"Almuerzo"+'\n'+"Comida"+
                  '\n'+"Cuidados: Asesoria de materias academicas, Atención permanente"+
                  '\n'+"Generación de habitos alimenticios, Normas básicas."; 
        }
    }
    public String ponServi() {
        return ali;
    }
    
}
