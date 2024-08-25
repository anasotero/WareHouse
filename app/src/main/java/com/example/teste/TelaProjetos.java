package com.example.teste;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

public class TelaProjetos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_projetos);

        CardView btnPasta = findViewById(R.id.cardCriar);
        GridLayout containerPasta = findViewById(R.id.containerPasta);

        btnPasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog_criar_pasta, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(TelaProjetos.this);
                builder.setView(dialogView);

                Dialog dialog = builder.create();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();

                TextInputEditText campoNome = dialogView.findViewById(R.id.nomePastaInput);

                CardView botaoConfirmar = dialogView.findViewById(R.id.botaoConfirmar);
                botaoConfirmar.setOnClickListener(i -> {

                    String nomePasta = campoNome.getText().toString();

                    LayoutInflater pastaInflater = getLayoutInflater();
                    View pastaView = pastaInflater.inflate(R.layout.pasta, null);

                    TextView textNome = pastaView.findViewById(R.id.textNome);
                    textNome.setText(nomePasta);

                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = GridLayout.LayoutParams.WRAP_CONTENT;
                    params.height = GridLayout.LayoutParams.WRAP_CONTENT;
                    pastaView.setLayoutParams(params);

                    containerPasta.addView(pastaView);

                    dialog.dismiss();
                });

                CardView botaoCancelar = dialogView.findViewById(R.id.botaoCancelar);
                botaoCancelar.setOnClickListener(i -> {
                    dialog.dismiss();
                });
            }
        });

    }

}