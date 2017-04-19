/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class Resolucion {
    private int nResolucion;
    private Date fecha;
    private String nombreCoordinador;
    private String nombreDirectorEscuela;
    private String nombreDirectorAdmYReg;
    private ArrayList<String> listaResultados;

    public Resolucion(int nResolucion, Date fecha, String nombreCoordinador, String nombreDirectorEscuela, String nombreDirectorAdmYReg, ArrayList<String> listaResultados) {
        this.nResolucion = nResolucion;
        this.fecha = fecha;
        this.nombreCoordinador = nombreCoordinador;
        this.nombreDirectorEscuela = nombreDirectorEscuela;
        this.nombreDirectorAdmYReg = nombreDirectorAdmYReg;
        this.listaResultados = listaResultados;
    }

      
    
    public int getnResolucion() {
        return nResolucion;
    }

    public void setnResolucion(int nResolucion) {
        this.nResolucion = nResolucion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public String getNombreDirectorEscuela() {
        return nombreDirectorEscuela;
    }

    public void setNombreDirectorEscuela(String nombreDirectorEscuela) {
        this.nombreDirectorEscuela = nombreDirectorEscuela;
    }

    public String getNombreDirectorAdmYReg() {
        return nombreDirectorAdmYReg;
    }

    public void setNombreDirectorAdmYReg(String nombreDirectorAdmYReg) {
        this.nombreDirectorAdmYReg = nombreDirectorAdmYReg;
    }

    public ArrayList<String> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(ArrayList<String> listaResultados) {
        this.listaResultados = listaResultados;
    }

    @Override
    public String toString() {
        return "Resolucion{" + "nResolucion=" + nResolucion + ", fecha=" + fecha + ", nombreCoordinador=" + nombreCoordinador + ", nombreDirectorEscuela=" + nombreDirectorEscuela + ", nombreDirectorAdmYReg=" + nombreDirectorAdmYReg + ", listaResultados=" + listaResultados + '}';
    }
    
}
