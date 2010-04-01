package org.saintandreas.ui.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;

public class TableSizingControlAdapter extends ControlAdapter {
    private final Table table;
    public TableSizingControlAdapter(Table table) {
        this.table = table;
    }
    
    public void controlResized(ControlEvent e) {
        Composite c = (Composite) e.getSource();
        Rectangle area = c.getClientArea();
        Point preferredSize = table.computeSize(SWT.DEFAULT, SWT.DEFAULT);
        int width = area.width - 2*table.getBorderWidth();
        if (preferredSize.y > area.height + table.getHeaderHeight()) {
          // Subtract the scrollbar width from the total column width
          // if a vertical scrollbar will be required
          Point vBarSize = table.getVerticalBar().getSize();
          width -= vBarSize.x;
        }
        for (int i = 0; i < table.getColumnCount() - 1; ++i) {
            width -= (table.getColumn(i).getWidth() + 5);
        }
        table.getColumn(table.getColumnCount() - 1).setWidth(width);
        
//        Point oldSize = circuitTable.getSize();
//
//        for (int colWidth : CIRCUIT_COLUMN_WIDTHS) {
//            area.width -= colWidth;
//        }
//        
//        circuitTable.getColumns()[2].setWidth(Math.max(0, area.width));
//        area.width - width2;
//        
//        if (oldSize.x > area.width) {
//          column1.setWidth(width/3);
//          column2.setWidth(width - column1.getWidth());
//          table.setSize(area.width, area.height);
//        } else {
//          // table is getting bigger so make the table 
//          // bigger first and then make the columns wider
//          // to match the client area width
//          table.setSize(area.width, area.height);
//          column1.setWidth(width/3);
//          column2.setWidth(width - column1.getWidth());
//        }
//    }
    }

}
