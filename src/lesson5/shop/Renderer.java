package lesson5.shop;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Renderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


        if (row%2 == 0) {
            cell.setBackground(new Color(165, 207, 203));
        } else {
            cell.setBackground(Color.LIGHT_GRAY);
        }
        if (isSelected) {
            cell.setBackground(Color.blue);
        }

        if (value == null) return cell;

        try {
            if(value.equals("оплачен")) {
                cell.setBackground(Color.GREEN);
            }
            if(value.equals("не оплачен")) {
                cell.setBackground(Color.RED);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return cell;
    }
}
