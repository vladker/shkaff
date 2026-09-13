package p009b0;

import android.content.Context;
import com.appdev.standard.api.PrinterLabelApi;
import com.appdev.standard.api.pto.TemplateElementPto;
import com.library.base.util.http.Http;
import p038g2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public final PrinterLabelApi d;

    public c(Context context) {
        super(context);
        this.d = (PrinterLabelApi) Http.createApi(PrinterLabelApi.class);
    }

    public final void a(TemplateElementPto templateElementPto, String str) {
        this.d.publishTemplatePto(templateElementPto).b(new b(this, str, 0));
    }
}
