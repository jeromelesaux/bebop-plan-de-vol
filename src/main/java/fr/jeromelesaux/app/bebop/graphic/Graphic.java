package fr.jeromelesaux.app.bebop.graphic;

import fr.jeromelesaux.app.bebop.entity.DetailsData;
import fr.jeromelesaux.app.bebop.entity.PUD;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by jlesaux on 13/11/15.
 * File ${FILE}
 */
public class Graphic {
    private static final Logger LOG = Logger.getLogger(Graphic.class.getName());

    public void generate(PUD pud,File fileout) throws IOException {
        LOG.info("Generating Graphic");
        String title = "Fly " + pud.getFormatedDate() + " of the bebop " + pud.getProductName() + " " + pud.getProductId();
        final XYSeries altitudeSeries = new XYSeries(ColumnConstants.ALTITUDE_METER);
        final XYSeries speedSeries = new XYSeries(ColumnConstants.SPEED);
        final XYSeries batteryLevel = new XYSeries(ColumnConstants.BATTERY_LEVEL);
        for (DetailsData data : pud.getDetailsData()) {
            final double minutes = data.getTime() / 6000;
            altitudeSeries.add(minutes,data.getAltitude());
            speedSeries.add(minutes,data.getSpeed());
            batteryLevel.add(minutes,data.getBatteryLevel());
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(altitudeSeries);


        final JFreeChart chart =  ChartFactory.createXYLineChart(title, "Time", "Altitude", dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final NumberAxis axis = new NumberAxis(ColumnConstants.ALTITUDE_METER);
        axis.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(0,axis);

        final NumberAxis axis2 = new NumberAxis(ColumnConstants.SPEED);
        axis2.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(1, axis2);
        plot.setDataset(1, new XYSeriesCollection(speedSeries));
        plot.mapDatasetToRangeAxis(1, 1);

        final NumberAxis axis3 = new NumberAxis(ColumnConstants.BATTERY_LEVEL);
        axis3.setAutoRangeIncludesZero(false);
        plot.setRangeAxis(2,axis3);
        plot.setDataset(2, new XYSeriesCollection(batteryLevel));
        plot.mapDatasetToRangeAxis(2, 2);

        final XYLineAndShapeRenderer renderer =new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(1, true);
        plot.setRenderer(0, renderer);


        final XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer();
        renderer2.setSeriesPaint(0, Color.BLACK);
        plot.setRenderer(1, renderer2);

        final XYLineAndShapeRenderer renderer3 = new XYLineAndShapeRenderer();
        renderer2.setSeriesPaint(0, Color.blue);
        plot.setRenderer(2, renderer3);

        //LOG.warning("Save into file " + fileout.getAbsolutePath());
        ChartUtilities.saveChartAsPNG(fileout, chart, 1200, 800);
    }

}


