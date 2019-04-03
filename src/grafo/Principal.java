
package grafo;

/**
 *
 * @author USUARIO
 */
public class Principal {
    
    public static void main(String[] args) {
        
        Modelo mod = new Modelo();
        Controlador cont = new Controlador(mod);
        cont.iniciarVista();
        
    }
}
