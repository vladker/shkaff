package p102s;

import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import java.util.ArrayList;
import p108t.B;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements B {
    public static final p Companion = new p();
    private static ArrayList<PrinterLabelTableView> curTable;

    public static final void setTable(ArrayList<PrinterLabelTableView> arrayList) {
        Companion.setTable(arrayList);
    }

    public final void c(boolean z6) {
        ArrayList<PrinterLabelTableView> arrayList = curTable;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                PrinterLabelTableView printerLabelTableView = arrayList.get(i5);
                i5++;
                printerLabelTableView.setSingleSelectMode(z6);
            }
        }
    }
}
