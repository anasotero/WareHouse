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

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(1000, "Pasta de dente"));
        entries.add(new PieEntry(2500, "Xampú"));
        entries.add(new PieEntry(2200, "Condicionador"));
        entries.add(new PieEntry(500, "Sabonete"));
        entries.add(new PieEntry(3100, "Enxaguante bucal"));

        PieDataSet dataSet = new PieDataSet(entries, "Produtos");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
    }
}
