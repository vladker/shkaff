package org.apache.xmlbeans.impl.store;

import java.util.function.Function;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class m0 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7434a;

    public /* synthetic */ m0(int i5) {
        this.f7434a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7434a) {
            case 0:
                return Xobj.lambda$array_setter$0((XmlObject) obj);
            case 1:
                return Xobj.lambda$array_setter$1((TypeStore) obj);
            case 2:
                return Integer.valueOf(DomImpl.attributes_getLength((DomImpl.Dom) obj));
            case 3:
                return DomImpl.document_getDocumentElement((DomImpl.Dom) obj);
            case 4:
                return DomImpl.impl_saajCallback_ensureSoapTextNode((DomImpl.Dom) obj);
            case 5:
                return DomImpl.node_getParentNode((DomImpl.Dom) obj);
            case 6:
                return DomImpl.document_createDocumentFragment((DomImpl.Dom) obj);
            case 7:
                return DomImpl.node_getOwnerDocument((DomImpl.Dom) obj);
            case 8:
                return DomImpl.node_getPreviousSibling((DomImpl.Dom) obj);
            case 9:
                return DomImpl.node_getFirstChild((DomImpl.Dom) obj);
            case 10:
                return DomImpl.getXmlStreamReader((DomImpl.Dom) obj);
            case 11:
                return DomImpl.document_getDoctype((DomImpl.Dom) obj);
            case 12:
                return Boolean.valueOf(DomImpl.node_hasAttributes((DomImpl.Dom) obj));
            case 13:
                return DomImpl.impl_saajCallback_getSaajData((DomImpl.Dom) obj);
            case 14:
                return DomImpl.node_getNextSibling((DomImpl.Dom) obj);
            case 15:
                return Integer.valueOf(DomImpl.childNodes_getLength((DomImpl.Dom) obj));
            case 16:
                return DomImpl.getXmlCursor((DomImpl.Dom) obj);
            case 17:
                return DomImpl.attr_getOwnerElement((DomImpl.Dom) obj);
            case 18:
                return DomImpl.node_getLastChild((DomImpl.Dom) obj);
            case 19:
                return DomImpl.getXmlObject((DomImpl.Dom) obj);
            case 20:
                return DomImpl.node_getNodeValue((DomImpl.Dom) obj);
            default:
                return ((TypeStoreUser) obj).get_store();
        }
    }
}
