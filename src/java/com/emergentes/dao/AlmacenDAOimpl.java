
package com.emergentes.dao;

//la clase que va implementar

import com.emergentes.modelo.Almacen;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class AlmacenDAOimpl extends ConexionBD implements AlmacenDAO{
 
    public void insert(Almacen almacen) throws Exception {
        
        try {
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement("INSERT into productos (descripcion,stock) values (?, ?)");
        ps.setString(1, almacen.getDescripcion());
        ps.setInt(2, almacen.getStock());
        ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        
    }

    public void update(Almacen almacen) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE productos set descripcion = ?, stock = ? WHERE id = ?");
            ps.setString(1, almacen.getDescripcion());
            ps.setInt(2, almacen.getStock());
            ps.setInt(3, almacen.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }

    public void delete(int id) throws Exception {
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM productos where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
    }


    public Almacen getById(int id) throws Exception {
        Almacen almc = new Almacen();
       
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                almc.setId(rs.getInt("id"));
                almc.setDescripcion(rs.getString("descripcion"));
                almc.setStock(rs.getInt("stock"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar();
        }
        return almc;    
    }


    public List<Almacen> getAll() throws Exception {
        List<Almacen> lista = null;
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Almacen>();
            while(rs.next()){
                Almacen almc = new Almacen();
                almc.setId(rs.getInt("id"));
                almc.setDescripcion(rs.getString("descripcion"));
                almc.setStock(rs.getInt("stock"));
                lista.add(almc);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        } finally{
            this.desconectar();
        }
        return lista;
    }
    
}
