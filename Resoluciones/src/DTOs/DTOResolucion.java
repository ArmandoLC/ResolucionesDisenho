/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOs;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Armando
 */
public class DTOResolucion {

    private int nResolucion;
    private Date fecha;
    private String nombreCoordinador;
    private String nombreDirectorEscuela;
    private String nombreDirectorAdmYReg;
    private ArrayList<String> listaResueltos;

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

    public ArrayList<String> getListaResueltos() {
        return listaResueltos;
    }

    public void setListaResueltos(ArrayList<String> listaResueltos) {
        this.listaResueltos = listaResueltos;
    }
    
    
    
}
