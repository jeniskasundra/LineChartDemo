package com.example.tops.linechart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LineChart chart, charttwo,chartMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        charttwo = (LineChart) findViewById(R.id.chartTwo);
        chart = (LineChart) findViewById(R.id.chart);
        chartMain=(LineChart) findViewById(R.id.mainChart);
        loadFirstChart();
        loadSecondChar();
    }

    private void loadFirstChart() {
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getDescription().setEnabled(false);

        chart.getLegend().setEnabled(false);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setGranularity(1f);
        leftAxis.setDrawGridLines(false);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);
        rightAxis.setDrawGridLines(false);



        // add x lables
        final String[] time = new String[]{"12:00", "13:00", "14:00", "15:00", "16:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00"};
        final ArrayList<String> xLabel = new ArrayList<>();
        for(int i=0; i<time.length; i++)
        {
            xLabel.add(time[(int) i]);
        }
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xLabel.get((int)value);
            }
        });

        //values for datainput Dataset1 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.RED);
        lDataSet1.setCircleColor(Color.RED);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);

        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet>();
        chart.setData(new LineData(dataSets));


        //on Scoll manage

        chartMain.setOnChartGestureListener(new CoupleChartGestureListener(
                chartMain, new Chart[]{chart,charttwo}));

        chart.invalidate();
    }

    private void loadSecondChar() {

        charttwo.getAxisLeft().setDrawLabels(false);
        charttwo.getAxisRight().setDrawLabels(false);
        charttwo.getXAxis().setDrawLabels(false);
        charttwo.setDrawBorders(false);
        charttwo.getDescription().setEnabled(false);


        charttwo.getXAxis().setDrawGridLines(false);
        charttwo.getAxisLeft().setDrawGridLines(false);
        charttwo.getAxisRight().setDrawGridLines(false);



        charttwo.getLegend().setEnabled(false);

        // enable scaling and dragging
        charttwo.setDragEnabled(true);
        charttwo.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = charttwo.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = charttwo.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = charttwo.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawAxisLine(false);

        // hide legend
        Legend legend = charttwo.getLegend();
        legend.setEnabled(false);

        charttwo.invalidate();


//values for datainput Dataset2 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));


        // Union from xAxisOne and xAxisTwo
        //  String[] xAxis = new String[] {"0", "1", "2", "3", "4", "5", "6", "8", "9"};

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.BLUE);
        lDataSet1.setCircleColor(Color.BLUE);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);
        charttwo.setData(new LineData(dataSets));

        //on Scoll manage

        chartMain.setOnChartGestureListener(new CoupleChartGestureListener(
                charttwo, new Chart[]{chart,charttwo}));
    }
}
