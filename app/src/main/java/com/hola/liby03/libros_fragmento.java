package com.hola.liby03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

import datos.Libros;
import datos.LibrosAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link libros_fragmento#newInstance} factory method to
 * create an instance of this fragment.
 */
public class libros_fragmento extends Fragment implements SearchView.OnQueryTextListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SearchView buscar2;
    RecyclerView recyclerLibro;
    ArrayList<Libros> saga;
    LibrosAdapter adapter;


    public libros_fragmento() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment libros_fragmento.
     */
    // TODO: Rename and change types and number of parameters
    public static libros_fragmento newInstance(String param1, String param2) {
        libros_fragmento fragment = new libros_fragmento();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        saga = new ArrayList<>();
        View vista= inflater.inflate(R.layout.fragment_libros_fragmento, container, false);
        //relacionamos el recyclerview por su id
        recyclerLibro = (RecyclerView) vista.findViewById(R.id.recyclerLibros);
        //relacionamos el searchView por su id
        buscar2=(SearchView) vista.findViewById(R.id.filtrado);
        recyclerLibro.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new LibrosAdapter(saga,getContext());
        recyclerLibro.setAdapter(adapter);
        //declaramos el metodo
        cinder();
        buscar2.setOnQueryTextListener(this);
        return vista;
    }

    //Declaramos los atributos que se mostraran en la lista
    public void cinder(){
        saga.add(new Libros(R.drawable.contrapunto,"La Seleccion", "Kiera Cass"));
        saga.add(new Libros(R.drawable.seleccionpart3,"Cinder", "Mariza Meyer"));
        saga.add(new Libros(R.drawable.contrapunto,"Hush hush", "Kiera Cass"));
        saga.add(new Libros(R.drawable.seleccionpart3,"Maze Runner", "Kiera Cass"));
        saga.add(new Libros(R.drawable.contrapunto,"Cress", "Mariza Meyer"));
    }

    //metodos despues de implementar SearchView.OnQueryTextListener en la clase

    @Override
    public boolean onQueryTextSubmit(String s) {
        adapter.filtrado2(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}