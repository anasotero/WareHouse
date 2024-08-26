package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class TelaGraficoRosca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_grafico_rosca);

        // Referência ao HorizontalBarChart do layout
        HorizontalBarChart horizontalBarChart = findViewById(R.id.horizontalBarChart);

        // Lista de entradas para o gráfico de barras horizontais
        List<BarEntry> entries = new ArrayList<>();

        // Dados predefinidos
        entries.add(new BarEntry(0, 1000, "Pasta de dente"));
        entries.add(new BarEntry(1, 2500, "Xampú"));
        entries.add(new BarEntry(2, 2200, "Condicionador"));
        entries.add(new BarEntry(3, 500, "Sabonete"));
        entries.add(new BarEntry(4, 3100, "Enxaguante bucal"));

        // Configuração do DataSet para o gráfico de barras horizontais
        BarDataSet dataSet = new BarDataSet(entries, "Produtos");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(ColorTemplate.COLORFUL_COLORS[1]); // Configura a cor do texto dos valores
        dataSet.setValueTextSize(10f); // Configura o tamanho do texto dos valores

        // Configuração dos dados do gráfico de barras horizontais
        BarData barData = new BarData(dataSet);
        horizontalBarChart.setData(barData);
        horizontalBarChart.invalidate();  // Atualiza o gráfico

        // Configurações adicionais do gráfico
        horizontalBarChart.getDescription().setEnabled(false);
        horizontalBarChart.setDrawGridBackground(true); // Exibe o plano de fundo do grid
        horizontalBarChart.setDrawBorders(true); // Desenha bordas ao redor do gráfico

        // Configurações do eixo Y
        horizontalBarChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(new String[] {
                "Pasta de dente", "Xampú", "Condicionador", "Sabonete", "Enxaguante bucal"
        }));
        horizontalBarChart.getXAxis().setGranularity(1f); // Define a granularidade do eixo X
        horizontalBarChart.getXAxis().setLabelRotationAngle(45); // Rotaciona os rótulos do eixo X para melhor visualização

        // Configurações do eixo X (vertical)
        horizontalBarChart.getAxisLeft().setGranularityEnabled(true);
        horizontalBarChart.getAxisLeft().setAxisMinimum(0f); // Define o valor mínimo do eixo Y
    }
}
