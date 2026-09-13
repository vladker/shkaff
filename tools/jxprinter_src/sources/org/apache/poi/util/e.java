package org.apache.poi.util;

import java.io.Serializable;
import java.util.function.Supplier;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.store.Cursor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7248a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Serializable d;

    public /* synthetic */ e(int i5, Enum[] enumArr, Enum r6) {
        this.b = i5;
        this.c = enumArr;
        this.d = r6;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7248a) {
            case 0:
                return GenericRecordUtil.lambda$safeEnum$0(this.b, (Enum[]) this.c, (Enum) this.d);
            default:
                return ((Cursor) this.c).lambda$toChild$35((QName) this.d, this.b);
        }
    }

    public /* synthetic */ e(Cursor cursor, QName qName, int i5) {
        this.c = cursor;
        this.d = qName;
        this.b = i5;
    }
}
