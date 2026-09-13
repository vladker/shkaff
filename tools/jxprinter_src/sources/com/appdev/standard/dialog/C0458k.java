package com.appdev.standard.dialog;

import androidx.fragment.app.DialogFragment;
import com.idlefish.flutterboost.EventListener;
import java.util.Map;

/* JADX INFO: renamed from: com.appdev.standard.dialog.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0458k implements EventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2648a;
    public final /* synthetic */ DialogFragment b;

    public /* synthetic */ C0458k(DialogFragment dialogFragment, int i5) {
        this.f2648a = i5;
        this.b = dialogFragment;
    }

    @Override // com.idlefish.flutterboost.EventListener
    public final void onEvent(String str, Map map) {
        switch (this.f2648a) {
            case 0:
                C0462o.b((C0462o) this.b, map);
                break;
            default:
                C0463p.b((C0463p) this.b, map);
                break;
        }
    }
}
