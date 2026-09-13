package p119v;

import com.appdev.standard.page.printerlabel.widget.BaseTableView;
import com.appdev.standard.page.printerlabel.widget.BaseTextView;
import kotlin.jvm.internal.Y;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements BaseTableView.onSelectChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f8755a;

    public i(j jVar) {
        this.f8755a = jVar;
    }

    @Override // com.appdev.standard.page.printerlabel.widget.BaseTableView.onSelectChangedListener
    public final void onChanged(BaseTextView baseTextView, String str) {
        if (Y.f(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length == 2) {
            Integer numValueOf = Integer.valueOf(strArrSplit[0].split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]);
            j jVar = this.f8755a;
            jVar.d = numValueOf;
            jVar.e = Integer.valueOf(strArrSplit[1].split(ParameterizedMessage.ERROR_MSG_SEPARATOR)[0]);
        }
    }
}
