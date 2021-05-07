
package ejecutar;

import sema11.Controlador;
import sema11.Modelo;
import sema11.Vista;

public class UsoAPP {
        public static void main(String[] args) {
           Vista vista=new Vista();
           Modelo modelo=new Modelo();
          Controlador controlador=new Controlador(modelo,vista);
          controlador.ver();
    }
}
