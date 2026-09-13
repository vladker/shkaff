package org.apache.poi.poifs.crypt.dsig;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.DocumentTraversal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7154a;
    public final /* synthetic */ SignatureMarshalDefaultListener b;
    public final /* synthetic */ DocumentTraversal c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ Map e;

    public /* synthetic */ h(SignatureMarshalDefaultListener signatureMarshalDefaultListener, DocumentTraversal documentTraversal, Map map, Map map2, int i5) {
        this.f7154a = i5;
        this.b = signatureMarshalDefaultListener;
        this.c = documentTraversal;
        this.d = map;
        this.e = map2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7154a) {
            case 0:
                this.b.lambda$handleElement$2(this.c, this.d, (HashMap) this.e, (Element) obj);
                break;
            default:
                this.b.lambda$null$1(this.c, this.d, this.e, (Element) obj);
                break;
        }
    }
}
