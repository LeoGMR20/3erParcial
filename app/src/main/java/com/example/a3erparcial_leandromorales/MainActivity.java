package com.example.a3erparcial_leandromorales;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.a3erparcial_leandromorales.databinding.ActivityMainBinding;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Atributos

    private ActivityMainBinding binding;
    private ArrayList<String> opcCategoria = new ArrayList<>();
    private ArrayList<Libro> libros;
    private static int idL = 3;
    private Libro libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        popularSpinner();
        popularListaLibros();
        
        //Eventos botones

        //Registros
        binding.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });
        binding.btnVerRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    pasarOtraPantalla();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void popularListaLibros() {
        libros = new ArrayList<>();

        //Libros por defecto

        Libro libro1 = new Libro(0,
                "Cálculo 1 - Modo Fácil",
                "Pedro Ibañez Robledo",
                "Matemática",
                "Libro de cálculo 1 para principiantes",
                "18/06/2010",
                1);
        Libro libro2 = new Libro(1,
                "Historias de terror desde un hospital",
                "Mariel Lima Cheverria",
                "No definida",
                "Libro que habla de experiencias aterradoras desde un hospital",
                "25/01/2005",
                4);
        Libro libro3 = new Libro(2,
                "Java - Android Studio",
                "Uriel Parra Lerma",
                "Programación",
                "Libro acerca de el uso del Lenguaje de programación\n" +
                        "Java en el IDE de Android Studio",
                "18/09/2016",
                2);
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);
    }

    private void popularSpinner() {
        opcCategoria = new ArrayList<>(Arrays.asList("No definida","Matemática","Física","Biología","Programación","Informática","Arquitectura"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opcCategoria
        );
        binding.spCategoria.setAdapter(adaptador);
    }

    private void obtenerInformacion() {

        //Validaciones

        try {
            if(binding.etNombre.getText().toString().isEmpty() ||
                    binding.etAutor.getText().toString().isEmpty() ||
                    binding.etDescripcion.getText().toString().isEmpty() ||
                    binding.etEdicion.getText().toString().isEmpty() ||
                    binding.etFechaPublicacion.getText().toString().isEmpty()) {
                Toast.makeText(this, "Ingrese todos los datos requeridos", Toast.LENGTH_LONG).show();
            }
            else if(binding.etNombre.getText().toString().length() < 3) {
                Toast.makeText(this,"El nombre ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
            }
            else if(binding.etAutor.getText().toString().length() < 3) {
                Toast.makeText(this,"El nombre del autor ingresado es demasiado pequeño",Toast.LENGTH_LONG).show();
            }
            else if(Integer.parseInt(binding.etEdicion.getText().toString()) == 0) {
                Toast.makeText(this,"Edición ingresada no válida",Toast.LENGTH_LONG).show();
            }
            else {
                libro = new Libro(idL,
                        binding.etNombre.getText().toString(),
                        binding.etAutor.getText().toString(),
                        binding.spCategoria.getSelectedItem().toString(),
                        binding.etDescripcion.getText().toString(),
                        binding.etFechaPublicacion.getText().toString(),
                        Integer.parseInt(binding.etEdicion.getText().toString()));
                Toast.makeText(this, "Se registró el libro correctamente", Toast.LENGTH_LONG).show();
                libros.add(libro);
                idL++;
                limpiar();
            }
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiar() {
        binding.etNombre.setText("");
        binding.etDescripcion.setText("");
        binding.etAutor.setText("");
        binding.etEdicion.setText("");
        binding.etFechaPublicacion.setText("");
        binding.spCategoria.setSelection(0);
    }

    private void pasarOtraPantalla() {
        Intent intencionLibros = new Intent(this, ListaActivity.class);
        //Use parceable ya que es una herramiento más eficiente (según vi en Internet),
        //y tenía el temor que me saliera error al momento de pasar la lista entre actividades
        intencionLibros.putParcelableArrayListExtra("listaLibros", libros);
        startActivity(intencionLibros);
    }
}