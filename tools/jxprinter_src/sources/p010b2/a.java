package p010b2;

import Y1.c;
import Y1.d;
import Y1.f;
import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f1086a;

    public a(Context context) {
        super(context, f.Dialog);
        setContentView(d.dialog_loading);
        setCanceledOnTouchOutside(false);
        this.f1086a = (TextView) findViewById(c.loading_text);
    }
}
