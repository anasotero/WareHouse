package com.example.teste;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class TelaGraficoLinhas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_grafico_linha);

        // Referência ao LineChart do layout
        LineChart lineChart = findViewById(R.id.lineChart);

        // Lista de entradas para o gráfico de linhas
        List<Entry> entries = new ArrayList<>();

        // Dados predefinidos
        entries.add(new Entry(0, 1000, "Pasta de dente"));
        entries.add(new Entry(1, 2500, "Xampú"));
        entries.add(new Entry(2, 2200, "Condicionador"));
        entries.add(new Entry(3, 500, "Sabonete"));
        entries.add(new Entry(4, 3100, "Enxaguante bucal"));

        // Configuração do DataSet para o gráfico de linhas
        LineDataSet dataSet = new LineDataSet(entries, "Produtos");
        dataSet.setColor(ColorTemplate.COLORFUL_COLORS[0]); // Configura a cor da linha
        dataSet.setValueTextColor(ColorTemplate.COLORFUL_COLORS[1]); // Configura a cor do texto dos valores
        dataSet.setValueTextSize(10f); // Configura o tamanho do texto dos valores

        // Configuração dos dados do gráfico de linhas
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();  // Atualiza o gráfico

        // Configurações adicionais do gráfico
        lineChart.getDescription().setEnabled(false);
        lineChart.setDrawGridBackground(true); // Exibe o plano de fundo do grid
        lineChart.setDrawBorders(true); // Desenha bordas ao redor do gráfico
    }
}
