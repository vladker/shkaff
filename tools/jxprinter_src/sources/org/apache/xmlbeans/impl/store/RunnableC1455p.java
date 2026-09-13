package org.apache.xmlbeans.impl.store;

import java.io.Serializable;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC1455p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7437a;
    public final /* synthetic */ Cursor b;
    public final /* synthetic */ Serializable c;
    public final /* synthetic */ String d;

    public /* synthetic */ RunnableC1455p(Cursor cursor, String str, XmlOptions xmlOptions) {
        this.f7437a = 2;
        this.b = cursor;
        this.d = str;
        this.c = xmlOptions;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7437a) {
            case 0:
                this.b.lambda$insertElementWithText$60((QName) this.c, this.d);
                break;
            case 1:
                this.b.lambda$insertAttributeWithValue$68((QName) this.c, this.d);
                break;
            default:
                this.b.lambda$selectPath$20(this.d, (XmlOptions) this.c);
                break;
        }
    }

    public /* synthetic */ RunnableC1455p(Cursor cursor, QName qName, String str, int i5) {
        this.f7437a = i5;
        this.b = cursor;
        this.c = qName;
        this.d = str;
    }
}
