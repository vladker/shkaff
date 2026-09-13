package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1441b implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7410a;
    public final /* synthetic */ Cursor b;

    public /* synthetic */ C1441b(int i5, Cursor cursor) {
        this.f7410a = i5;
        this.b = cursor;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7410a) {
            case 0:
                return Boolean.valueOf(this.b._toPrevAttribute());
            case 1:
                return Boolean.valueOf(this.b._pop());
            case 2:
                return this.b._toFirstContentToken();
            case 3:
                return this.b._newInputStream();
            case 4:
                return Boolean.valueOf(this.b._toNextSelection());
            case 5:
                return this.b._prevTokenType();
            case 6:
                return this.b._xmlText();
            case 7:
                return Boolean.valueOf(this.b._isEnddoc());
            case 8:
                return this.b._getObject();
            case 9:
                return Boolean.valueOf(this.b._isEnd());
            case 10:
                return Boolean.valueOf(this.b._isText());
            case 11:
                return Boolean.valueOf(this.b._isContainer());
            case 12:
                return this.b._documentProperties();
            case 13:
                return this.b._getTextValue();
            case 14:
                return this.b._toEndToken();
            case 15:
                return Boolean.valueOf(this.b._isProcinst());
            case 16:
                return Boolean.valueOf(this.b._toPrevSibling());
            case 17:
                return this.b._getChars();
            case 18:
                return this.b._newDomNode();
            case 19:
                return Boolean.valueOf(this.b._hasNextSelection());
            case 20:
                return Boolean.valueOf(this.b.___toNextSibling());
            case 21:
                return Boolean.valueOf(this.b._removeXml());
            case 22:
                return Boolean.valueOf(this.b._hasPrevToken());
            case 23:
                return this.b._getDocChangeStamp();
            case 24:
                return Boolean.valueOf(this.b._removeXmlContents());
            case 25:
                return this.b._getDomNode();
            case 26:
                return Boolean.valueOf(this.b._isComment());
            case 27:
                return Boolean.valueOf(this.b._toFirstAttribute());
            case 28:
                return Boolean.valueOf(this.b._isAttr());
            default:
                return Integer.valueOf(this.b._getSelectionCount());
        }
    }
}
