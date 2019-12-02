/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ormlite;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.misc.BaseDaoEnabled;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author skabe
 */
@DatabaseTable(tableName = "productos")
public class Producto extends BaseDaoEnabled{
    @DatabaseField(id=true, canBeNull = false)
    private String codigoProducto;
    @DatabaseField
    private String nombre;
    @DatabaseField
    private String descripcion;
    @DatabaseField
    private String stock;
    @DatabaseField
    private String precio;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombre, String descripcion, String stock, String precio) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * @return the codigoProducto
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descricion
     */
    public String getDescricion() {
        return descripcion;
    }

    /**
     * @param descripcion the descricion to set
     */
    public void setDescricion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the stock
     */
    public String getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
