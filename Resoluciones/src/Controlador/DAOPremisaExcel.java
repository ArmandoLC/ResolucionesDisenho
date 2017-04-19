/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DTOs.DTOCurso;
import DTOs.DTOPersona;
import DTOs.DTOferta;
import java.io.File;
import java.util.ArrayList;
import jxl.Sheet;
import jxl.Workbook;

/**
 *
 * @author Armando
 */
public class DAOPremisaExcel implements IDAOPremisa {

    private String ruta;

    @Override
    public ArrayList<DTOPersona> ConsultarCarteraDocente() throws Exception {
        ArrayList<DTOPersona> carteraDocente = new ArrayList<DTOPersona>();
        
        try {
            File f = new File(ruta);

            Workbook book = Workbook.getWorkbook(f);
            Sheet sheet = book.getSheet("PROFESORES");
            int rows = sheet.getRows();
            
            for (int i = 0; i < rows; i++) {
                DTOPersona dtoPersona = new DTOPersona();
                dtoPersona.setId(sheet.getCell(0, i).getContents());
                dtoPersona.setNombre(sheet.getCell(1, i).getContents());
                dtoPersona.setCorreo(sheet.getCell(2, i).getContents());
                dtoPersona.setTelefono(sheet.getCell(3, i).getContents());

                carteraDocente.add(dtoPersona);
                dtoPersona = null;
                System.gc();
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo de cartera docente: ");
            System.out.println(e.getMessage());
        }
        return carteraDocente;
    }

    @Override
    public ArrayList<DTOCurso> ConsultarPlanEstudios() {
        ArrayList<DTOCurso> planEstudios = new ArrayList<DTOCurso>();
        
        try {
            File f = new File(ruta);

            Workbook book = Workbook.getWorkbook(f);
            Sheet sheet = book.getSheet("PLAN");
            int rows = sheet.getRows();
            
            for (int i = 0; i < rows; i++) {
                DTOCurso dtoCurso = new DTOCurso();
                dtoCurso.setId(sheet.getCell(0, i).getContents());
                dtoCurso.setNombre(sheet.getCell(1, i).getContents());
                dtoCurso.setCreditos(Integer.parseInt(sheet.getCell(2, i).getContents()));

                planEstudios.add(dtoCurso);
                dtoCurso = null;
                System.gc();
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo del plan de estudios: ");
            System.out.println(e.getMessage());
        }
        return planEstudios;
    }

    @Override
    public ArrayList<DTOferta> ConsultarOfertaAcademica() {
        ArrayList<DTOferta> ofertaAcad = new ArrayList<DTOferta>();
        
        try {
            File f = new File(ruta);

            Workbook book = Workbook.getWorkbook(f);
            Sheet sheet = book.getSheet("OFERTA");
            int rows = sheet.getRows();
            
            for (int i = 0; i < rows; i++) {
                DTOferta dtoOferta = new DTOferta();
                dtoOferta.setPeriodo(sheet.getCell(0, i).getContents());
                dtoOferta.setIdCurso(sheet.getCell(1, i).getContents());
                dtoOferta.setnGrupo(Integer.parseInt(sheet.getCell(2, i).getContents()));
                dtoOferta.setIdProfesor(sheet.getCell(3, i).getContents());
                dtoOferta.setHorario(sheet.getCell(4, i).getContents());
                dtoOferta.setAula(sheet.getCell(5, i).getContents());

                ofertaAcad.add(dtoOferta);
                dtoOferta = null;
                System.gc();
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo de oferta académica: ");
            System.out.println(e.getMessage());
        }
        return ofertaAcad;
    }

    @Override
    public ArrayList<String> ConsultarSituaciones() {
        ArrayList<String> situaciones = new ArrayList<String>();
        
        try {
            File f = new File(ruta);

            Workbook book = Workbook.getWorkbook(f);
            Sheet sheet = book.getSheet("SITUACIONES");
            int rows = sheet.getRows();
            for (int i = 0; i < rows; i++) {
                situaciones.add(sheet.getCell(0, i).getContents());
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar el archivo de situaciones: ");
            System.out.println(e.getMessage());
        }
        return situaciones;
    }

}
