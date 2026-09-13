package org.apache.xmlbeans.impl.store;

import java.io.Serializable;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1456q implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7438a = 1;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Serializable d;

    public /* synthetic */ C1456q(Cursor cursor, String str, XmlOptions xmlOptions) {
        this.b = cursor;
        this.c = str;
        this.d = xmlOptions;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7438a) {
            case 0:
                return this.b.lambda$setAttributeText$40((QName) this.d, this.c);
            default:
                return this.b.lambda$execQuery$47(this.c, (XmlOptions) this.d);
        }
    }

    public /* synthetic */ C1456q(Cursor cursor, QName qName, String str) {
        this.b = cursor;
        this.d = qName;
        this.c = str;
    }
}
