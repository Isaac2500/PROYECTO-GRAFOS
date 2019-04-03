
package grafo;

import java.awt.Graphics;

/**
 *
 * @author USUARIO
 */
public class vertice {

    private int x, y;
    private String nombre;
    public final static int diam = 60;

    public vertice(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }

    public void pintar(Graphics g) {

        g.drawOval(this.x - diam / 2, this.y - diam / 2, diam, diam);
        g.drawString(nombre, x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return this.nombre;
    }

}
