package com.example.a3erparcial_leandromorales;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;

/*Aplique la lógica para registrar libros en la biblioteca de la universidad.
* Se necesita los atributos que se crearán a continuación.
* La clase necesita constructores, uno con imagen y otro sin imagen (Por si no se consigue la imagen de la portada del libro)
* Getters para obtener los datos de un objeto para ponerlos en una lista layout*/

public class Libro implements Parcelable {

    //Atributos (aplicando encapsulamiento)

    private int id;
    private String nombre;
    private String autor;
    private String categoria;
    private String descripcion;
    private String fechaPublicacion;
    private int edicion;

    //Constructores

    public Libro(int id, String nombre, String autor, String categoria, String descripcion, String fechaPublicacion, int edicion) {
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

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public int getEdicion() {
        return edicion;
    }

    //En caso de ser necesario --> toString


    @Override
    public String toString() {
        return "Libro:\n" +
                "id:" + id + "\n"+
                "nombre:" + nombre + "\n"+
                "autor:" + autor +"\n"+
                "categoria:" + categoria +"\n"+
                "descripcion:" + descripcion +"\n"+
                "fechaPublicacion:" + fechaPublicacion +"\n"+
                "edicion:" + edicion + "\n";
    }

    //Para el funcionamiento de parcel

    protected Libro(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        autor = in.readString();
        categoria = in.readString();
        descripcion = in.readString();
        fechaPublicacion = in.readString();
        edicion = in.readInt();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nombre);
        parcel.writeString(autor);
        parcel.writeString(categoria);
        parcel.writeString(descripcion);
        parcel.writeString(fechaPublicacion);
        parcel.writeInt(edicion);
    }
}