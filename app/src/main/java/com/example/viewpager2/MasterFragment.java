package com.example.viewpager2;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.*;

public class MasterFragment extends Fragment {

    int contador_fragments;
    static String ARG_CONTADOR = "parameter";
    int COLOR_MAP[] = {R.color.verde, R.color.rojo, R.color.naranja, R.color.celeste, R.color.amarillo, R.color.teal_700};
    String nombres[] = {"Primo", "Perfecto", "Par o Impar", "Signo", "Cuadrado", "Cubo"};
    // nosotros generaremos fragments, no se crearan del ide.

    public MasterFragment() {
        // Required empty public constructor
    }

    public static MasterFragment newInstance(int contador){
        MasterFragment fragment = new MasterFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CONTADOR, contador);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            contador_fragments = getArguments().getInt(ARG_CONTADOR);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(ContextCompat.getColor(getContext(), COLOR_MAP[contador_fragments]));
        TextView tvCounter = view.findViewById(R.id.tvCounter);
        //tvCounter.setText("Fragment Nro: " + contador_fragments);
        tvCounter.setText(nombres[contador_fragments]);

        EditText etNro = view.findViewById(R.id.etNumero);
        Button btAccion = view.findViewById(R.id.btAction);
        btAccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Accion: " + nombres[contador_fragments], Toast.LENGTH_LONG).show();
                try {
                    NumericOps ops = new NumericOps(Integer.parseInt(etNro.getText().toString()));
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(nombres[contador_fragments]);
                    if (nombres[contador_fragments].equals("Primo")) {
                        if (ops.isPrime())
                            builder.setMessage(ops.getN() + " es primo");
                        else
                            builder.setMessage(ops.getN() + " no es primo");
                    } else if (nombres[contador_fragments].equals("Perfecto")) {
                        if (ops.isPerfect())
                            builder.setMessage(ops.getN() + " es perfecto");
                        else
                            builder.setMessage(ops.getN() + " no es perfecto");
                    } else if (nombres[contador_fragments].equals("Par o Impar")) {
                        if (ops.isOdd())
                            builder.setMessage(ops.getN() + " es par");
                        else
                            builder.setMessage(ops.getN() + " es impar");
                    } else if (nombres[contador_fragments].equals("Signo")) {
                        builder.setMessage(ops.getN() + " es " + ops.sign());
                    } else if (nombres[contador_fragments].equals("Cuadrado")) {
                        builder.setMessage(ops.getN() + "^2 = " + ops.square());
                    } else if (nombres[contador_fragments].equals("Cubo")) {
                        builder.setMessage(ops.getN() + "^3 = " + ops.cube());
                    }
                    builder.setPositiveButton("Aceptar", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();           
                }
                catch(Exception e){
                    Toast.makeText(getContext(), "ERROR: Debe ingresar un número", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}