package com.emergentes.utiles;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Test {

    public static void main(String[] args){
        ConexionBD c = new ConexionBD();
        c.conectar();
        /*
        ConexionBD c = new ConexionBD();
        
        c.conectar();*/
        // Prueba de adicion 
        /*
        AvisoDAO dao = new AvisoDAOimpl();
        Aviso avi = new Aviso();
        
        avi.setTitulo("Urgente");
        avi.setContenido("Vendo motocicleta Honda 350cc");
        
        try {
            dao.insert(avi);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        // Pruba de listado
        /*
        AvisoDAO dao = new AvisoDAOimpl();
        List<Aviso> lista = null;
        try {
            lista = dao.getAll();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Aviso a : lista){
            System.out.println("Titulo: " + a.getTitulo() + ": "+ a.getContenido());
        }*/
        // Prueba de obtención de un registro
        /*AvisoDAO dao = new AvisoDAOimpl();
        try {
        Aviso avi = dao.getById(2);
            System.out.println(avi.toString());
        } catch(Exception e){
            System.out.println("Erro al recuperar un registro " + e.getMessage());
        }*/
                   
    }
}
