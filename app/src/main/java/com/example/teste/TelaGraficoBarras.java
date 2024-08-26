package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class TelaGraficoBarras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_grafico_barra);

        // Referência ao BarChart do layout
        BarChart barChart = findViewById(R.id.barChart);

        // Lista de entradas para o gráfico de barras
        List<BarEntry> entries = new ArrayList<>();

        // Dados predefinidos
        entries.add(new BarEntry(0, 1000, "Pasta de dente"));
        entries.add(new BarEntry(1, 2500, "Xampú"));
        entries.add(new BarEntry(2, 2200, "Condicionador"));
        entries.add(new BarEntry(3, 500, "Sabonete"));
        entries.add(new BarEntry(4, 3100, "Enxaguante bucal"));

        // Configuração do DataSet para o gráfico de barras
        BarDataSet dataSet = new BarDataSet(entries, "Produtos");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextSize(10f); // Define o tamanho do texto dos valores

        // Configuração dos dados do gráfico de barras
        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();  // Atualiza o gráfico

        // Configurações adicionais do gráfico
        barChart.getDescription().setEnabled(false); // Desativa a descrição
        barChart.setFitBars(true);  // Ajusta as barras para se encaixarem no gráfico
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(new String[] {"Pasta de dente", "Xampú", "Condicionador", "Sabonete", "Enxaguante bucal"})); // Configura os rótulos do eixo X
        barChart.getXAxis().setGranularity(1f); // Define a granularidade do eixo X
        barChart.getXAxis().setLabelRotationAngle(45); // Rotaciona os rótulos do eixo X para melhor visualização
    }
}
