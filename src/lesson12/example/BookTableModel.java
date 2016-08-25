package lesson12.example;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {

    private int columnCount = 4;
    private ArrayList<String []> dataArrayList;

    public BookTableModel() {
        dataArrayList = new ArrayList<String []>();
        for(int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0: return "#id";
            case 1: return "title";
            case 2: return "isbn";
            case 3: return "description";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String [] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }

    public void addDate(String  []row) {
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
    }
}
