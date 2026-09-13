package org.apache.poi.sl.extractor;

import java.util.LinkedList;
import java.util.function.Consumer;
import org.apache.poi.xddf.usermodel.text.XDDFFont;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7185a;
    public final /* synthetic */ LinkedList b;

    public /* synthetic */ b(LinkedList linkedList, int i5) {
        this.f7185a = i5;
        this.b = linkedList;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        LinkedList linkedList;
        Object obj2;
        switch (this.f7185a) {
            case 0:
                linkedList = this.b;
                obj2 = (String) obj;
                break;
            default:
                linkedList = this.b;
                obj2 = (XDDFFont) obj;
                break;
        }
        linkedList.add(obj2);
    }
}
