package org.apache.xmlbeans.impl.store;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class j0 implements Locale.SyncWrapFun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7428a = 0;
    public final /* synthetic */ XmlOptions b;
    public final /* synthetic */ SchemaType c;

    public /* synthetic */ j0(SchemaType schemaType, XmlOptions xmlOptions) {
        this.c = schemaType;
        this.b = xmlOptions;
    }

    @Override // org.apache.xmlbeans.impl.store.Locale.SyncWrapFun
    public final Object parse(Locale locale) {
        switch (this.f7428a) {
            case 0:
                return Locale.lambda$newSaxHandler$6(this.c, this.b, locale);
            default:
                return Locale.lambda$newInstance$0(this.b, this.c, locale);
        }
    }

    public /* synthetic */ j0(XmlOptions xmlOptions, SchemaType schemaType) {
        this.b = xmlOptions;
        this.c = schemaType;
    }
}
