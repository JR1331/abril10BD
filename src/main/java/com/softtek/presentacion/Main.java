package com.softtek.presentacion;

import com.softtek.modelo.Producto;
import com.softtek.persistencia.AccesoProducto;
import com.softtek.persistencia.Conexion;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Conexion c1 = new Conexion();
        Scanner sc = new Scanner(System.in);
        try{
            c1.abrirConexion();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        AccesoProducto ap = new AccesoProducto();
        try {
            System.out.println(ap.obtenerTodos());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Introduce en numero de id del producto");
        int id = sc.nextInt();
        try {
            System.out.println(ap.obtenerUno(id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Producto p2 = new Producto();
        System.out.println("id del producto");
        p2.setIdProducto(sc.nextInt());
        System.out.println("nombre del producto");
        p2.setNombreProducto(sc.next());
        System.out.println("Precio unitario del producto");
        p2.setPrecioUnitario(sc.nextDouble());
        System.out.println("El producto esta descontinuado");
        p2.setDiscontinuado(sc.nextInt());
        System.out.println(ap.añadir(p2));

        /*System.out.println("Id del producto a borrar");
        id= sc.nextInt();
        System.out.println(ap.eliminar(id));
        */
        System.out.println("Id del producto a updatear");
        id= sc.nextInt();
        System.out.println(ap.modificar(id));
        System.out.println(ap.obtenerUno(id));
        sc.close();
    }
}
