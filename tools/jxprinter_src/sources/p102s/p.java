package p102s;

import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import java.util.ArrayList;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    public final void setTable(ArrayList<PrinterLabelTableView> table) {
        E.f(table, "table");
        r.curTable = table;
    }
}
