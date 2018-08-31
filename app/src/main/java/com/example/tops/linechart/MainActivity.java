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
    LineChart chart, chartTwo,chartThree,chartFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chart = (LineChart) findViewById(R.id.chart);
        chartTwo = (LineChart) findViewById(R.id.chartTwo);
        chartThree = (LineChart) findViewById(R.id.chartThree);
        chartFour = (LineChart) findViewById(R.id.chartFour);

        loadFirstChart();
        loadSecondChar();
        loadThirdChart();
        loadFourthChart();
    }

    private void loadFirstChart() {
        chart.getAxisLeft().setDrawLabels(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setGranularity(1f);
        leftAxis.setEnabled(false);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);



        // add x lables
        final String[] time = new String[]{"12:00", "13:00", "14:00", "15:00", "16:00", "17:00","18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00"};
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
        xAxis.setGranularity(1f);

        //values for datainput Dataset1 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));
        dataset1.add(new Entry(7f, 1));
        dataset1.add(new Entry(8f, 2));
        dataset1.add(new Entry(9f, 3));
        dataset1.add(new Entry(10f, 2));
        dataset1.add(new Entry(11f, 4));
        dataset1.add(new Entry(12f, 5));
        dataset1.add(new Entry(13f, 1));
        dataset1.add(new Entry(14f, 2));
        dataset1.add(new Entry(15f, 3));
        dataset1.add(new Entry(16f, 2));
        dataset1.add(new Entry(17f, 4));
        dataset1.add(new Entry(18f, 5));

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.RED);
        lDataSet1.setCircleColor(Color.RED);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);

        ArrayList<LineDataSet> lines = new ArrayList<LineDataSet>();
        chart.setData(new LineData(dataSets));


        //on Scoll manage

        chart.setOnChartGestureListener(new CoupleChartGestureListener(
                chart, new Chart[]{chartTwo,chartThree,chartFour}));

        chart.invalidate();
    }

    private void loadSecondChar() {

        chartTwo.getAxisLeft().setDrawLabels(false);
        chartTwo.getAxisRight().setDrawLabels(false);
        chartTwo.getXAxis().setDrawLabels(false);
        chartTwo.setDrawBorders(false);
        chartTwo.getDescription().setEnabled(false);
        chartTwo.setDoubleTapToZoomEnabled(false);


        chartTwo.getXAxis().setDrawGridLines(false);
        chartTwo.getAxisLeft().setDrawGridLines(false);
        chartTwo.getAxisRight().setDrawGridLines(false);



        chartTwo.getLegend().setEnabled(false);

        // enable scaling and dragging
        chartTwo.setDragEnabled(true);
        chartTwo.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = chartTwo.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = chartTwo.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = chartTwo.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawAxisLine(false);

        // hide legend
        Legend legend = chartTwo.getLegend();
        legend.setEnabled(false);

        chartTwo.invalidate();


//values for datainput Dataset2 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));
        dataset1.add(new Entry(7f, 1));
        dataset1.add(new Entry(8f, 2));
        dataset1.add(new Entry(9f, 3));
        dataset1.add(new Entry(10f, 2));
        dataset1.add(new Entry(11f, 4));
        dataset1.add(new Entry(12f, 5));
        dataset1.add(new Entry(13f, 1));
        dataset1.add(new Entry(14f, 2));
        dataset1.add(new Entry(15f, 3));
        dataset1.add(new Entry(16f, 2));
        dataset1.add(new Entry(17f, 4));
        dataset1.add(new Entry(18f, 5));



        // Union from xAxisOne and xAxisTwo
        //  String[] xAxis = new String[] {"0", "1", "2", "3", "4", "5", "6", "8", "9"};

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.BLUE);
        lDataSet1.setCircleColor(Color.BLUE);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);
        chartTwo.setData(new LineData(dataSets));

        //on Scoll manage

        chartTwo.setOnChartGestureListener(new CoupleChartGestureListener(
                chartTwo, new Chart[]{chart,chartThree,chartFour}));
    }


    private void loadThirdChart() {

        chartThree.getAxisLeft().setDrawLabels(false);
        chartThree.getAxisRight().setDrawLabels(false);
        chartThree.getXAxis().setDrawLabels(false);
        chartThree.setDrawBorders(false);
        chartThree.getDescription().setEnabled(false);
        chartThree.setDoubleTapToZoomEnabled(false);


        chartThree.getXAxis().setDrawGridLines(false);
        chartThree.getAxisLeft().setDrawGridLines(false);
        chartThree.getAxisRight().setDrawGridLines(false);



        chartThree.getLegend().setEnabled(false);

        // enable scaling and dragging
        chartThree.setDragEnabled(true);
        chartThree.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = chartThree.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = chartThree.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = chartThree.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawAxisLine(false);

        // hide legend
        Legend legend = chartThree.getLegend();
        legend.setEnabled(false);

        chartThree.invalidate();


//values for datainput Dataset2 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));
        dataset1.add(new Entry(7f, 1));
        dataset1.add(new Entry(8f, 2));
        dataset1.add(new Entry(9f, 3));
        dataset1.add(new Entry(10f, 2));
        dataset1.add(new Entry(11f, 4));
        dataset1.add(new Entry(12f, 5));
        dataset1.add(new Entry(13f, 1));
        dataset1.add(new Entry(14f, 2));
        dataset1.add(new Entry(15f, 3));
        dataset1.add(new Entry(16f, 2));
        dataset1.add(new Entry(17f, 4));
        dataset1.add(new Entry(18f, 5));



        // Union from xAxisOne and xAxisTwo
        //  String[] xAxis = new String[] {"0", "1", "2", "3", "4", "5", "6", "8", "9"};

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.GREEN);
        lDataSet1.setCircleColor(Color.GREEN);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);
        chartThree.setData(new LineData(dataSets));

        //on Scoll manage

        chartThree.setOnChartGestureListener(new CoupleChartGestureListener(
                chartThree, new Chart[]{chart,chartTwo,chartFour}));
    }

    private void loadFourthChart() {

        chartFour.getAxisLeft().setDrawLabels(false);
        chartFour.getAxisRight().setDrawLabels(false);
        chartFour.getXAxis().setDrawLabels(false);
        chartFour.setDrawBorders(false);
        chartFour.getDescription().setEnabled(false);
        chartFour.setDoubleTapToZoomEnabled(false);


        chartFour.getXAxis().setDrawGridLines(false);
        chartFour.getAxisLeft().setDrawGridLines(false);
        chartFour.getAxisRight().setDrawGridLines(false);



        chartFour.getLegend().setEnabled(false);

        // enable scaling and dragging
        chartFour.setDragEnabled(true);
        chartFour.setScaleEnabled(true);

        // remove axis
        YAxis leftAxis = chartFour.getAxisLeft();
        leftAxis.setEnabled(false);
        YAxis rightAxis = chartFour.getAxisRight();
        rightAxis.setEnabled(false);

        XAxis xAxis = chartFour.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawAxisLine(false);

        // hide legend
        Legend legend = chartFour.getLegend();
        legend.setEnabled(false);

        chartFour.invalidate();


//values for datainput Dataset2 at your axisone positions
        ArrayList<Entry> dataset1 = new ArrayList<Entry>();
        dataset1.add(new Entry(1f, 1));
        dataset1.add(new Entry(2f, 2));
        dataset1.add(new Entry(3f, 3));
        dataset1.add(new Entry(4f, 2));
        dataset1.add(new Entry(5f, 4));
        dataset1.add(new Entry(6f, 5));
        dataset1.add(new Entry(7f, 1));
        dataset1.add(new Entry(8f, 2));
        dataset1.add(new Entry(9f, 3));
        dataset1.add(new Entry(10f, 2));
        dataset1.add(new Entry(11f, 4));
        dataset1.add(new Entry(12f, 5));
        dataset1.add(new Entry(13f, 1));
        dataset1.add(new Entry(14f, 2));
        dataset1.add(new Entry(15f, 3));
        dataset1.add(new Entry(16f, 2));
        dataset1.add(new Entry(17f, 4));
        dataset1.add(new Entry(18f, 5));



        // Union from xAxisOne and xAxisTwo
        //  String[] xAxis = new String[] {"0", "1", "2", "3", "4", "5", "6", "8", "9"};

        LineDataSet lDataSet1 = new LineDataSet(dataset1, "DataSet1");
        lDataSet1.setColor(Color.YELLOW);
        lDataSet1.setCircleColor(Color.YELLOW);
        lDataSet1.setDrawHighlightIndicators(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(lDataSet1);
        chartFour.setData(new LineData(dataSets));

        //on Scoll manage

        chartFour.setOnChartGestureListener(new CoupleChartGestureListener(
                chartFour, new Chart[]{chart,chartTwo,chartThree}));
    }
}
