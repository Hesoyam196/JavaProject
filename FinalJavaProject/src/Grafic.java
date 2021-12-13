import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;
import javax.swing.*;
import java.awt.*;

public class Grafic {
    public static void draw(String[] countries, double[] values) {
        CategoryDataset dataset = createDataset(countries, values);
        JFreeChart freeChart = createChart(dataset);
        JFrame frame = new JFrame("Среднее количество студентов по странам");
        frame.getContentPane().add(new ChartPanel(freeChart));
        frame.setSize(1200,900);
        frame.show();
    }

    public static JFreeChart createChart(CategoryDataset categoryDataset) {
        JFreeChart jfreechart = ChartFactory.createBarChart ("Среднее количество студентов по странам",
                "Country","Students average", categoryDataset,
                PlotOrientation.VERTICAL, true, false, false);

        CategoryPlot  plot = (CategoryPlot) jfreechart.getPlot();
        plot.setBackgroundPaint (Color.decode("#F5FADE"));

        // Подписи
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions (CategoryLabelPositions.createUpRotationLabelPositions (Math.PI / 4));
        domainAxis.setLabelFont (new Font (" ", Font.BOLD, 14));
        domainAxis.setTickLabelFont (new Font (" ", Font.BOLD, 14));

        // Свойства столбца
        BarRenderer renderer = new BarRenderer();
        renderer.setBaseOutlinePaint(Color.BLACK);
        renderer.setDrawBarOutline(true);
        renderer.setSeriesPaint(0, Color.decode("#577DAD"));

        // Отрисовка значений
        renderer.setIncludeBaseInRange(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont (new Font (" ", Font.BOLD, 12));
        renderer.setBasePositiveItemLabelPosition (new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
        plot.setRenderer(renderer);
        return jfreechart;
    }

    public static CategoryDataset createDataset(String[] countries, double[] values) {
        String [] rowKeys = {"Среднее количество студентов"};
        return DatasetUtilities.createCategoryDataset(rowKeys, countries, new double[][]{values});
    }
}
