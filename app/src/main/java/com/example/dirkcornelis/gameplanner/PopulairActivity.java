package com.example.dirkcornelis.gameplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.List;

public class PopulairActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_populair);

        PieChart chart = findViewById(R.id.chart);

        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(18.8f, "Stellaris"));
        entries.add(new PieEntry(26.7f, "TABG"));
        entries.add(new PieEntry(24.0f, "Stick Fight"));
        entries.add(new PieEntry(18.8f, "PUBG"));

//        PieDataSet set = new PieDataSet(entries, "test");
//        PieData data = new PieData(set);
//        chart.setData(data);
//        chart.invalidate();
    }
}
