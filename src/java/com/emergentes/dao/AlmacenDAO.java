
package com.emergentes.dao;

import com.emergentes.modelo.Almacen;
import java.util.List;

/**
 *
 * @author HUANCA CORI ROGER
 */
public interface AlmacenDAO {
    public void insert(Almacen almacen) throws Exception;//lanza un error en caso de existir un error
    public void update(Almacen almacen) throws Exception;//le pasamos un objeto de tipo Almacen
    public void delete(int id) throws Exception;
    public Almacen getById(int id) throws Exception;
    public List<Almacen> getAll() throws Exception;//paar tener todos registros de la tabla
    
}
