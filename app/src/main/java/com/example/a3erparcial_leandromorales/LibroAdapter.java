package com.example.a3erparcial_leandromorales;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.a3erparcial_leandromorales.databinding.LibroItemBinding;

import java.util.ArrayList;

public class LibroAdapter extends BaseAdapter {

    //Atributos

    private ArrayList<Libro> libros;
    private LibroItemBinding librosBinding;
    private Context contexto;

    public LibroAdapter(ArrayList<Libro> libros, Context contexto) {
        this.libros = libros;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return this.libros.size();
    }

    @Override
    public Object getItem(int position) {
        return this.libros.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            ///Lo vas a dibujar de cero
            librosBinding = LibroItemBinding.inflate(LayoutInflater.from(this.contexto), parent, false);
            holder = new ViewHolder(librosBinding);
            convertView = holder.view;
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.binding.tvId.setText(String.valueOf(libros.get(position).getId()));
        holder.binding.tvNombre.setText(libros.get(position).getNombre());
        holder.binding.tvAutor.setText(libros.get(position).getAutor());
        holder.binding.tvDescripcion.setText(libros.get(position).getDescripcion());
        holder.binding.tvCategoria.setText(libros.get(position).getCategoria());
        holder.binding.tvFechaPublicacion.setText(libros.get(position).getFechaPublicacion());
        holder.binding.tvEdicion.setText(String.valueOf(libros.get(position).getEdicion()));
        return convertView;
    }

    public static class ViewHolder{
        private View view;
        private LibroItemBinding binding;

        public ViewHolder(LibroItemBinding binding){
            this.binding = binding;
            this.view = binding.getRoot();
        }
    }
}


