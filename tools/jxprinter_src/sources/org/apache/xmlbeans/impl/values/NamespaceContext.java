package org.apache.xmlbeans.impl.values;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.xml.stream.StartElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class NamespaceContext implements PrefixResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAP = 3;
    private static final int RESOLVER = 5;
    private static final int START_ELEMENT = 4;
    private static final int TYPE_STORE = 1;
    private static final int XML_OBJECT = 2;
    private static ThreadLocal tl_namespaceContextStack = new ThreadLocal();
    private int _code = 3;
    private Object _obj;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class NamespaceContextStack {
        NamespaceContext current;
        ArrayList<NamespaceContext> stack;

        private NamespaceContextStack() {
            this.stack = new ArrayList<>();
        }

        public final void pop() {
            this.current = (NamespaceContext) androidx.collection.a.e(this.stack, 1);
            ArrayList<NamespaceContext> arrayList = this.stack;
            arrayList.remove(arrayList.size() - 1);
        }

        public final void push(NamespaceContext namespaceContext) {
            this.stack.add(this.current);
            this.current = namespaceContext;
        }
    }

    public NamespaceContext(Map map) {
        this._obj = map;
    }

    public static void clearThreadLocals() {
        tl_namespaceContextStack.remove();
    }

    public static PrefixResolver getCurrent() {
        return getNamespaceContextStack().current;
    }

    private static NamespaceContextStack getNamespaceContextStack() {
        NamespaceContextStack namespaceContextStack = (NamespaceContextStack) tl_namespaceContextStack.get();
        if (namespaceContextStack != null) {
            return namespaceContextStack;
        }
        NamespaceContextStack namespaceContextStack2 = new NamespaceContextStack();
        tl_namespaceContextStack.set(namespaceContextStack2);
        return namespaceContextStack2;
    }

    public static void pop() {
        NamespaceContextStack namespaceContextStack = getNamespaceContextStack();
        namespaceContextStack.pop();
        if (namespaceContextStack.stack.size() == 0) {
            tl_namespaceContextStack.set(null);
        }
    }

    public static void push(NamespaceContext namespaceContext) {
        getNamespaceContextStack().push(namespaceContext);
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        if (str != null && str.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        int i5 = this._code;
        if (i5 == 1) {
            return ((TypeStore) this._obj).getNamespaceForPrefix(str);
        }
        if (i5 == 2) {
            Object invocationHandler = this._obj;
            if (Proxy.isProxyClass(invocationHandler.getClass())) {
                invocationHandler = Proxy.getInvocationHandler(invocationHandler);
            }
            if (invocationHandler instanceof TypeStoreUser) {
                return ((TypeStoreUser) invocationHandler).get_store().getNamespaceForPrefix(str);
            }
            XmlCursor xmlCursorNewCursor = ((XmlObject) this._obj).newCursor();
            if (xmlCursorNewCursor != null) {
                try {
                    if (xmlCursorNewCursor.currentTokenType() == XmlCursor.TokenType.ATTR) {
                        xmlCursorNewCursor.toParent();
                    }
                    String strNamespaceForPrefix = xmlCursorNewCursor.namespaceForPrefix(str);
                    xmlCursorNewCursor.close();
                    return strNamespaceForPrefix;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
        } else if (i5 != 3) {
            if (i5 == 4) {
                return ((StartElement) this._obj).getNamespaceUri(str);
            }
            if (i5 != 5) {
                return null;
            }
            return ((PrefixResolver) this._obj).getNamespaceForPrefix(str);
        }
        return (String) ((Map) this._obj).get(str);
    }

    public NamespaceContext(TypeStore typeStore) {
        this._obj = typeStore;
    }

    public NamespaceContext(XmlObject xmlObject) {
        this._obj = xmlObject;
    }

    public NamespaceContext(StartElement startElement) {
        this._obj = startElement;
    }

    public NamespaceContext(PrefixResolver prefixResolver) {
        this._obj = prefixResolver;
    }
}
