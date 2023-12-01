/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom.clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jairi
 */
public class Funciones {
    
    public static String rolToString(int rol) {
        return rol==0?"Empleado":"Gerente";
    }
    
    public static String estatusUsuarioToString(int estatus){
        return estatus==0?"Activo":"Inactivo";
    }
    
    public static String estatusPacienteToString(int estatus){
        switch (estatus) {
            case 0:
                return "Activo";
            case 1:
                return "Baja";
            case 2:
                return "Rechazado";
            default:
                throw new AssertionError();
        }
    }
    
    public static String estatusActividadToString(int prioridad){
        switch (prioridad) {
            case 0:
                return "Asignada";
            case 1:
                return "Cancelada";
            case 2:
                return "Reagendada";
            case 3:
                return "Incumplida";
            case 4:
                return "Cumplida";
            default:
                throw new AssertionError();
        }
    }
    
    
    public static String prioridadToString(int prioridad){
        switch (prioridad) {
            case 0:
                return "Sin prioridad";
            case 1:
                return "Baja";
            case 2:
                return "Media";
            case 3:
                return "Alta";
            default:
                throw new AssertionError();
        }
    }
    
    public static String sexoToString(int sex){
        switch (sex) {
            case 0:
                return "Sin especificar";
            case 1:
                return "Hombre";
            case 2:
                return "Mujer";
            default:
                throw new AssertionError();
        }
    }
    
    public static String formatedFecha(Date fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        return fecha!=null?formato.format(fecha):"";
    }
    
    public static Date fechaMasMes(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        // Sumar un mes
        calendar.add(Calendar.MONTH, 1);
        // Obtener la nueva fecha después de sumar un mes
        Date nuevaFecha = calendar.getTime();
        return nuevaFecha;
    }
    
    public static Date fechaMenosDia(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        // Sumar un mes
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        // Obtener la nueva fecha después de sumar un mes
        Date nuevaFecha = calendar.getTime();
        return nuevaFecha;
    }
    
    public static Date fechaMenosMes(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        // Sumar un mes
        calendar.add(Calendar.MONTH, -1);
        // Obtener la nueva fecha después de sumar un mes
        Date nuevaFecha = calendar.getTime();
        return nuevaFecha;
    }
    
    public static int obtenerDiferenciaMeses(Date fechaInicio, Date fechaFin) {
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(fechaInicio);

        Calendar calendarFin = Calendar.getInstance();
        calendarFin.setTime(fechaFin);

        int diffYears = calendarFin.get(Calendar.YEAR) - calendarInicio.get(Calendar.YEAR);
        int diffMonths = calendarFin.get(Calendar.MONTH) - calendarInicio.get(Calendar.MONTH);

        return diffYears * 12 + diffMonths;
    }
}
