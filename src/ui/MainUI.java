package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * @author Catherine Giovetti
 * @version 2021.11.21
 */
public class MainUI {
    private JPanel rootPanel;
    private JTable showTable;
    private JComboBox genreCombo;
    private JComboBox typeCombo;
    private JTextField minVotetTextField;
    private JButton episodeRatingsButton;
    private JButton IMDBPageButton;
    private JScrollPane JScrollPane;

    public MainUI() {
        createTable();
        createGenreCombo();
        createTypeCombo();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createTable() {
        Object[][] data = {
                {"Inception", 2010, 8.8, 1675116},
                {"Gladiator", 2000, 8.5, 1105488},
                {"Raiders of the Lost Ark", 1981, 8.5, 742380}
        };
        showTable.setModel(new DefaultTableModel(data,
                new String[] {"Title", "Year", "Rating", "NumVotes"}
        ));
        TableColumnModel columns = showTable.getColumnModel();
        columns. getColumn(0).setMinWidth(200);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columns.getColumn(1).setCellRenderer(centerRenderer);
        columns.getColumn(2).setCellRenderer(centerRenderer);
        columns.getColumn(3).setCellRenderer(centerRenderer);
    }
    private void createGenreCombo() {
        genreCombo.setModel(new DefaultComboBoxModel<String>(new String [] {"Action", "Fantasy",
                "Drama", "Romance", "Sci-Fi"}));
    }

    private void createTypeCombo() {
        typeCombo.setModel(new DefaultComboBoxModel<String>(new String [] {"movie", "tvSeries",
                "tvEpisode", "short"}));
    }
}
