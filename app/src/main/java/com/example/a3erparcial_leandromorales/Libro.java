package com.example.a3erparcial_leandromorales;

import java.io.Serializable;
import java.util.Date;

/*Aplique la lógica para registrar libros en la biblioteca de la universidad.
* Se necesita los atributos que se crearán a continuación.
* La clase necesita constructores, uno con imagen y otro sin imagen (Por si no se consigue la imagen de la portada del libro)
* Getters para obtener los datos de un objeto para ponerlos en una lista layout*/

public class Libro implements Serializable {

    //Atributos (aplicando encapsulamiento)

    private int id;
    private String nombre;
    private String autor;
    private String categoria;
    private String descripcion;
    private Date fechaPublicacion;
    private int edicion;
    private int imagen;

    //Constructores (aplicando polimorfismo)


    public Libro(int id, String nombre, String autor, String categoria, String descripcion, Date fechaPublicacion, int edicion, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
        this.imagen = imagen;
    }

    public Libro(int id, String nombre, String autor, String categoria, String descripcion, Date fechaPublicacion, int edicion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaPublicacion = fechaPublicacion;
        this.edicion = edicion;
    }

    //Getters


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getEdicion() {
        return edicion;
    }

    public int getImagen() {
        return imagen;
    }
}
