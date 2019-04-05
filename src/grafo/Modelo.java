package grafo;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Modelo extends JPanel {

    private ArrayList<vertice> arrayVertices;
    private ArrayList<arista> arrayAristas;
    private Point p1, p2;
    private vertice moververtice;
    private int indexvertice;

    public Modelo(){

        this.arrayVertices = new ArrayList<>();
        this.arrayAristas = new ArrayList<>();

    }
    public void paint(Graphics g) {

        super.paint(g);
        for (vertice vertices : arrayVertices) {
            vertices.pintar(g);
        }

        for (arista aristas : arrayAristas) {
            aristas.pintar(g);
        }
    }

    public void mousepresionado(MouseEvent me) {

        int cont = 0;
        for (vertice vertex : arrayVertices) {

            if (new Rectangle(vertex.getX() - vertex.diam / 2, vertex.getY() - vertex.diam / 2, vertice.diam, vertice.diam).contains(me.getPoint())) {

                moververtice = vertex;
                indexvertice = cont;
                break;
            }
            cont++;
        }
    }

    public void mouseliberado(){

        moververtice = null;
        indexvertice = -1;
    }

    public boolean validarVertice(Point p){

      Rectangle vert = new Rectangle(p.x-vertice.diam/2,p.y - vertice.diam/2,vertice.diam,vertice.diam);
      for(vertice vertex : arrayVertices){

        if(new Rectangle(vertex.getX()-vertice.diam/2,vertex.getY() - vertice.diam/2,vertice.diam,vertice.diam).intersects(vert)) {
          return true;
        }
      }
      return false;
    }
    public void clickIzquierdo(MouseEvent me){

        String nombre ="";
        if(!validarVertice(me.getPoint())){
          nombre = JOptionPane.showInputDialog("Ingresar nombre del vertice");
          this.arrayVertices.add(new vertice(me.getX(), me.getY(), nombre));
        }else{
          JOptionPane.showMessageDialog(null, "No puedes insertar un vertice en ese punto","Error al pintar",JOptionPane.ERROR_MESSAGE);
        }

        repaint();

    }

    public void clickDerecho(MouseEvent me){

        for (vertice vertex : arrayVertices) {

                if (new Rectangle(vertex.getX() - vertex.diam / 2, vertex.getY() - vertex.diam / 2, vertice.diam, vertice.diam).contains(me.getPoint())) {
                    if (p1 == null) {

                        p1 = new Point(vertex.getX(), vertex.getY());
                    } else {

                        p2 = new Point(vertex.getX(), vertex.getY());
                        //String nombre = JOptionPane.showInputDialog(null, "Ingresar valor en la arista");
                        this.arrayAristas.add(new arista(p1.x, p1.y, p2.x, p2.y/*,nombre*/));
                        repaint();
                        p1 = null;
                        p2 = null;
                    }

                }

            }
    }
/*
    public void arrastrar(MouseEvent me){

        if (moververtice != null) {

            this.arrayVertices.set(indexvertice, new vertice(me.getX(), me.getY(), moververtice.getNombre()));
            int iari = 0;
            for (arista edge : arrayAristas) {

                if (new Rectangle(edge.getX1() - vertice.diam / 2, edge.getY1() - vertice.diam / 2, vertice.diam, vertice.diam).contains(me.getPoint())) {

                    this.arrayAristas.set(iari, new arista(me.getX(), me.getY(), edge.getX2(), edge.getY2()));
                } else if (new Rectangle(edge.getX2() - vertice.diam / 2, edge.getY2() - vertice.diam / 2, vertice.diam, vertice.diam).contains(me.getPoint())) {

                    this.arrayAristas.set(iari, new arista(edge.getX1(), edge.getY1(), me.getX(), me.getY()));
                }
                iari++;
            }
        }
        repaint();
    }
*/
}
