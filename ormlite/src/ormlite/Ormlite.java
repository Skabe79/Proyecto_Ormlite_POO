/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ormlite;

import appIventario.FrameInventario;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.util.ArrayList;

/**
 *
 * @author skabe
 */
public class Ormlite {
    private static String usuario;
    private static String password;
    public static void main(String[] args){
        FrameInventario.main(args);
    }
    public static void insertar(Producto producto)throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, usuario, password)) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            TableUtils.createTableIfNotExists(connectionSource, Producto.class);
            productoDao.create(producto);
        }
    }
    public static Producto consutarPorCodigo(String id) throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        Producto resBusqueda;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "")) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            TableUtils.createTableIfNotExists(connectionSource, Producto.class);
            resBusqueda = productoDao.queryForId(id);
        }
        return resBusqueda;
    }
    public static void actulizarProducto(String id,String nom, String des, String stock, String precio) throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "")) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            
            TableUtils.createTableIfNotExists(connectionSource, Producto.class);
            Producto resBusqueda= productoDao.queryForId(id);
            resBusqueda.setNombre(nom);
            resBusqueda.setDescricion(des);
            resBusqueda.setStock(stock);
            resBusqueda.setPrecio(precio);
            resBusqueda.update();
        }
    }
    public static ArrayList <Producto> consutarTodo() throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        ArrayList <Producto> listaProductos;
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "")) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            TableUtils.createTableIfNotExists(connectionSource, Producto.class);
            listaProductos = (ArrayList <Producto>) productoDao.queryForAll();
        }
        return listaProductos;
    }
    public static void eliminarUno(String id)throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        // instantiate the dao
        try ( // create a connection source to our database
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "")) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            TableUtils.createTableIfNotExists(connectionSource, Producto.class);
            Producto resBusqueda = productoDao.queryForId(id); 
            resBusqueda.delete();
        }
    }
    public static void eliminarTabla()throws Exception{
        String databaseUrl;
        databaseUrl = "jdbc:mysql://localhost/Inventario";
        // instantiate the dao
        try ( // create a connection source to our database
                ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl, "root", "")) {
            // instantiate the dao
            Dao<Producto, String> productoDao = DaoManager.createDao(connectionSource, Producto.class);
            TableUtils.dropTable(connectionSource, Producto.class, true);
        }
    }
    public static boolean revisarUsuario(){
        return ("Montes137924568&".equals(password) && "Montes".equals(usuario)) || ("yosoysucio100".equals(password) && "ElSucio".equals(usuario));
    }
    /**
     * @return the usuario
     */
    public static String getUsuario() {
        return usuario;
    }

    /**
     * @param aUsuario the usuario to set
     */
    public static void setUsuario(String aUsuario) {
        usuario = aUsuario;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }
    
}
