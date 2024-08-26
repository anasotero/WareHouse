package com.example.teste;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class TelaProduto extends AppCompatActivity {

    private ArrayList<String> listaProdutos;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_produto);

        listaProdutos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaProdutos);

        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        CardView btnAddProduto = findViewById(R.id.cardAddProduto);
        btnAddProduto.setOnClickListener(v -> {
            ConstraintLayout parentLayout = findViewById(R.id.containerTelaProduto);
            View myView = View.inflate(TelaProduto.this, R.layout.add_produto, null);
            parentLayout.addView(myView);

            CardView botaoOk = myView.findViewById(R.id.botaoOk);
            botaoOk.setOnClickListener(i -> {

                EditText etNomeProduto = myView.findViewById(R.id.et_nome_produto);
                EditText etQtdProduto = myView.findViewById(R.id.et_qtd_produto);
                EditText etValor = myView.findViewById(R.id.et_valor);

                String nomeProduto = etNomeProduto.getText().toString();
                String qtdProdutoString = etQtdProduto.getText().toString();
                int qtdProduto = Integer.parseInt(qtdProdutoString);
                String valorString = etValor.getText().toString();
                float valor = Float.parseFloat(valorString);

                String produtoInfo = "Nome: " + nomeProduto + "\nQuantidade: " + qtdProduto + "\nValor: R$ " + valor;

                listaProdutos.add(produtoInfo);
                adapter.notifyDataSetChanged();

                parentLayout.removeView(myView);
            });

            CardView botaoCancelar = myView.findViewById(R.id.botaoCancel);
            botaoCancelar.setOnClickListener(i -> parentLayout.removeView(myView));
        });

        CardView btnGeraGrafico = findViewById(R.id.cardGraficos);
        btnGeraGrafico.setOnClickListener(i -> {

            ConstraintLayout parentLayout = findViewById(R.id.containerTelaProduto);
            View myView = View.inflate(TelaProduto.this, R.layout.seletor_grafico, null);
            parentLayout.addView(myView);

            CardView btnPizza = myView.findViewById(R.id.cardPizza);
            CardView btnDonut = myView.findViewById(R.id.cardDonut);
            CardView btnBarras = myView.findViewById(R.id.cardBarras);
            CardView btnLinhas = myView.findViewById(R.id.cardLinhas);

            btnPizza.setOnClickListener(j -> {
                Intent intent = new Intent(TelaProduto.this, TelaGraficoPizza.class);
                intent.putStringArrayListExtra("listaProdutos", listaProdutos);
                startActivity(intent);
            });

            btnDonut.setOnClickListener(j -> {
                Intent intent = new Intent(TelaProduto.this, TelaGraficoRosca.class);
                intent.putStringArrayListExtra("listaProdutos", listaProdutos);
                startActivity(intent);
            });

            btnBarras.setOnClickListener(j -> {
                Intent intent = new Intent(TelaProduto.this, TelaGraficoBarras.class);
                intent.putStringArrayListExtra("listaProdutos", listaProdutos);
                startActivity(intent);
            });

            btnLinhas.setOnClickListener(j -> {
                Intent intent = new Intent(TelaProduto.this, TelaGraficoLinhas.class);
                intent.putStringArrayListExtra("listaProdutos", listaProdutos);
                startActivity(intent);
            });


        });
    }
}
