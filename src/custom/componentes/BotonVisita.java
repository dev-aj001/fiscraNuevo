/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom.componentes;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author jairi
 */
public class BotonVisita extends JButton{
    
    private int visitas;
    private String hora;
    private Date fecha;
    private final Color sinActividad = Color.decode("#EFF0F5");
    private final Color conActividad = Color.decode("#53EFE6");
    private final Color saturado = Color.decode("#E6655C");

    
    public BotonVisita() {
        super();
        this.hora = "00";
        this.hora = hora+":00";
        setText(this.hora);
        setStatus(0);
        this.visitas = 0;
    }

    public void setStatus(int e){
        switch (e) {
            case -1 -> setEnabled(false);
            case 0 -> setBackground(sinActividad);
            case 1 -> setBackground(conActividad);
            case 2 -> setBackground(saturado);
            default -> throw new AssertionError();
        }
    }

    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
        setText(hora);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
