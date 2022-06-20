package com.example.a3erparcial_leandromorales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.a3erparcial_leandromorales.databinding.ActivityListaBinding;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    private ActivityListaBinding binding;
    private ArrayList<Libro> librosMostrar;
    private LibroAdapter miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        librosMostrar = getIntent().getParcelableArrayListExtra("listaLibros");
        miAdaptador = new LibroAdapter(librosMostrar,this);
        binding.lvLibros.setAdapter(miAdaptador);
    }
}