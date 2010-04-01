package org.saintandreas.ui.swt;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class TableUtil {
    
    public static TableItem getItemForEvent(Table table, MouseEvent event) {
        Rectangle clientArea = table.getClientArea();
        Point pt = new Point(event.x, event.y);
        int index = table.getTopIndex();
        while (index < table.getItemCount()) {
            boolean visible = false;
            TableItem item = table.getItem(index);
            for (int i = 0; i < table.getColumnCount(); i++) {
                Rectangle rect = item.getBounds(i);
                if (rect.contains(pt)) {
                    return item;
                }
                if (!visible && rect.intersects(clientArea)) {
                    visible = true;
                }
            }
            if (!visible) break;
            index++;
        }
        return null;
    }


}
