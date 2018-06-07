package com.example.elgrim.seasonal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint

fun dataPoint(a: Int, b: Int): DataPoint {
    return DataPoint(a.toDouble(), b.toDouble())
}

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val graph = findViewById<View>(R.id.graph) as GraphView
        val series = LineGraphSeries(arrayOf(dataPoint(0, 1), dataPoint(1, 5), dataPoint(2, 3)))
        series.color = R.color.colorPrimary
        graph.addSeries(series)
    }
}
