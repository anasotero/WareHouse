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

        // Configurando os dados
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Transporte"));
        entries.add(new PieEntry(30f, "Estoque"));
        entries.add(new PieEntry(20f, "Distribuição"));
        entries.add(new PieEntry(10f, "Outros"));

        PieDataSet dataSet = new PieDataSet(entries, "Categorias");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate(); // Atualiza o gráfico

        // Personalizações opcionais
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
    }
}