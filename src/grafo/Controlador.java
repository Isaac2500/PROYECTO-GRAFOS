
package grafo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador implements MouseListener,MouseMotionListener{

    private Modelo mod;

    public Controlador(Modelo mod) {
        this.mod = mod;
        mod.addMouseListener(this);
        mod.addMouseMotionListener(this);

    }

    public void iniciarVista(){

        JFrame ventana = new JFrame();
        ventana.setTitle("Grafo");
        ventana.add(mod);
        ventana.setSize(1200,1000);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
 
    @Override
    public void mouseClicked(MouseEvent me) {

        if(me.getButton() == MouseEvent.BUTTON1) this.mod.clickIzquierdo(me);
        else if(me.getButton() == MouseEvent.BUTTON3) this.mod.clickDerecho(me);
    }

    @Override
    public void mousePressed(MouseEvent me) {

        this.mod.mousepresionado(me);
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        this.mod.mouseliberado();
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void mouseDragged(MouseEvent me) {

        this.mod.arrastrar(me);
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }
 
}
