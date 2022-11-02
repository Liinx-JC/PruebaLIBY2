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

import datos.ListLibre;
import datos.ListLibreAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaLibro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaLibro extends Fragment implements SearchView.OnQueryTextListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SearchView buscar;
    RecyclerView recyclerLibreria;
    ArrayList<ListLibre> libro;
    ListLibreAdapter adapter;

    public ListaLibro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaLibro.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaLibro newInstance(String param1, String param2) {
        ListaLibro fragment = new ListaLibro();
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
        libro = new ArrayList<>();
        View vista= inflater.inflate(R.layout.fragment_lista_libro, container, false);
        //relacionamos el recyclerview por su id
        recyclerLibreria = (RecyclerView) vista.findViewById(R.id.recyclerId);
        //relacionamos el searchView por su id
        buscar=(SearchView) vista.findViewById(R.id.filtro);
        recyclerLibreria.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ListLibreAdapter(libro,getContext());
        recyclerLibreria.setAdapter(adapter);
        //declaramos un metodo
        init();
        buscar.setOnQueryTextListener(this);
        return vista;
    }

    //implementamos el metodo para nombrar los atributos que llevara la lista
    public void init(){
        libro.add(new ListLibre("ContraPunto","(51) 247 1106", "contrapunto.cl", R.drawable.ic_menu_gallery));
        libro.add(new ListLibre("ContraPunto","(51) 247 1106", "contrapunto.cl", R.mipmap.ic_launcher));
        libro.add(new ListLibre("ContraPunto","(51) 247 1106", "contrapunto.cl",R.drawable.contrapunto));
        libro.add(new ListLibre("ContraPunto","(51) 247 1106", "contrapunto.cl",R.drawable.contrapunto));

    }

    //metodos despues de implementar SearchView.OnQueryTextListener en la clase
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }
}