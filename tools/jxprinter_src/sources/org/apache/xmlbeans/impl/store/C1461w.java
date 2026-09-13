package org.apache.xmlbeans.impl.store;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.xmlbeans.impl.store.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C1461w implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7444a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1461w(Object obj, int i5) {
        this.f7444a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f7444a) {
            case 0:
                return ((Cursor) this.b)._currentTokenType();
            case 1:
                return Boolean.valueOf(((Cursor) this.b)._toLastChild());
            case 2:
                return Boolean.valueOf(((Cursor) this.b)._toFirstChild());
            case 3:
                return ((Cursor) this.b)._monitor();
            case 4:
                return Boolean.valueOf(((Cursor) this.b)._toLastAttribute());
            case 5:
                return ((Cursor) this.b)._newReader();
            case 6:
                return ((Cursor) this.b)._toPrevToken();
            case 7:
                return Boolean.valueOf(((Cursor) this.b)._isNamespace());
            case 8:
                return Boolean.valueOf(((Cursor) this.b)._hasNextToken());
            case 9:
                return Boolean.valueOf(((Cursor) this.b)._isAnyAttr());
            case 10:
                return Boolean.valueOf(((Cursor) this.b)._toParent());
            case 11:
                return Boolean.valueOf(((Cursor) this.b)._isStartdoc());
            case 12:
                return ((Cursor) this.b)._toNextToken();
            case 13:
                return ((Cursor) this.b)._newCursor();
            case 14:
                return Boolean.valueOf(((Cursor) this.b)._isFinish());
            case 15:
                return Boolean.valueOf(((Cursor) this.b)._toNextAttribute());
            case 16:
                return ((Cursor) this.b)._getName();
            case 17:
                return ((Cursor) this.b)._newXMLStreamReader();
            case 18:
                return Boolean.valueOf(((Cursor) this.b)._isStart());
            default:
                return ((DomImpl.ElementsNodeList) this.b).lambda$ensureElements$0();
        }
    }
}
