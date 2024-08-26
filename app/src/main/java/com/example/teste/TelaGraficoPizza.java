package com.example.teste;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class TelaGraficoPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_grafico_pizza);

        PieChart pieChart = findViewById(R.id.pieChart);

        // Recuperando o ArrayList de strings
        ArrayList<String> listaProdutos = getIntent().getStringArrayListExtra("listaProdutos");

        // Lista de entradas para o gráfico
        List<PieEntry> entries = new ArrayList<>();

        if (listaProdutos != null && !listaProdutos.isEmpty()) {
            for (String produto : listaProdutos) {
                try {
                    // Exemplo de string: "Nome: Produto1, Quantidade: 5, Valor: R$ 10.0"
                    String[] partes = produto.split(", ");

                    // Extraindo o nome
                    String nome = partes[0].split(": ")[1];

                    // Extraindo o valor
                    String valorString = partes[2].split(": ")[1].replace("R$ ", "").replace(",", ".");
                    float valor = Float.parseFloat(valorString);

                    // Adicionando entrada ao gráfico
                    entries.add(new PieEntry(valor, nome));
                } catch (Exception e) {
                    e.printStackTrace();  // Para depurar possíveis erros de parsing
                }
            }
        }

        // Configurando o conjunto de dados do gráfico
        PieDataSet dataSet = new PieDataSet(entries, "Produtos");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
    }
}
