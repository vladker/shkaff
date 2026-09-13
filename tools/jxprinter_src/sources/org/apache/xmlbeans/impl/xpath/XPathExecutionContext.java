package org.apache.xmlbeans.impl.xpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XPathExecutionContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ATTRS = 4;
    public static final int DESCEND = 2;
    public static final int HIT = 1;
    private PathContext[] _paths;
    private final ArrayList<QName> _stack = new ArrayList<>();
    private XPath _xpath;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public final class PathContext {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private XPathStep _curr;
        private final List<XPathStep> _prev;

        private PathContext() {
            this._prev = new ArrayList();
        }

        private void backtrack() {
            XPathStep xPathStep = this._curr;
            if (xPathStep._hasBacktrack) {
                this._curr = xPathStep._backtrack;
                return;
            }
            this._curr = xPathStep._prev;
            while (true) {
                XPathStep xPathStep2 = this._curr;
                if (xPathStep2._deep) {
                    return;
                }
                int i5 = 0;
                while (!xPathStep2._deep) {
                    int i6 = i5 + 1;
                    if (xPathStep2.match(top(i5))) {
                        xPathStep2 = xPathStep2._prev;
                        i5 = i6;
                    } else {
                        this._curr = this._curr._prev;
                    }
                }
                return;
            }
        }

        private QName top(int i5) {
            return (QName) XPathExecutionContext.this._stack.get((XPathExecutionContext.this._stack.size() - 1) - i5);
        }

        public boolean attr(QName qName) {
            XPathStep xPathStep = this._curr;
            return xPathStep != null && xPathStep._attr && xPathStep.match(qName);
        }

        public int element(QName qName) {
            this._prev.add(this._curr);
            XPathStep xPathStep = this._curr;
            if (xPathStep == null) {
                return 0;
            }
            if (xPathStep._attr || !xPathStep.match(qName)) {
                do {
                    backtrack();
                    XPathStep xPathStep2 = this._curr;
                    if (xPathStep2 == null) {
                        return 0;
                    }
                    if (xPathStep2.match(qName)) {
                        this._curr = this._curr._next;
                        break;
                    }
                } while (!this._curr._deep);
                return this._curr._flags;
            }
            XPathStep xPathStep3 = this._curr._next;
            this._curr = xPathStep3;
            if (xPathStep3._name != null) {
                return xPathStep3._flags;
            }
            backtrack();
            XPathStep xPathStep4 = this._curr;
            if (xPathStep4 == null) {
                return 1;
            }
            return xPathStep4._flags | 1;
        }

        public void end() {
            List<XPathStep> list = this._prev;
            this._curr = list.remove(list.size() - 1);
        }

        public void init(XPathStep xPathStep) {
            this._curr = xPathStep;
            this._prev.clear();
        }

        public int start() {
            XPathStep xPathStep = this._curr;
            if (xPathStep._name != null) {
                return xPathStep._flags;
            }
            this._curr = null;
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PathContext lambda$init$0(int i5) {
        return new PathContext();
    }

    public final boolean attr(QName qName) {
        boolean zAttr = false;
        for (PathContext pathContext : this._paths) {
            zAttr |= pathContext.attr(qName);
        }
        return zAttr;
    }

    public final int element(QName qName) {
        this._stack.add(qName);
        int iElement = 0;
        for (PathContext pathContext : this._paths) {
            iElement |= pathContext.element(qName);
        }
        return iElement;
    }

    public final void end() {
        ArrayList<QName> arrayList = this._stack;
        arrayList.remove(arrayList.size() - 1);
        for (PathContext pathContext : this._paths) {
            pathContext.end();
        }
    }

    public final void init(XPath xPath) {
        if (this._xpath != xPath) {
            this._xpath = xPath;
            PathContext[] pathContextArr = new PathContext[xPath._selector._paths.length];
            this._paths = pathContextArr;
            Arrays.setAll(pathContextArr, new IntFunction() { // from class: org.apache.xmlbeans.impl.xpath.a
                @Override // java.util.function.IntFunction
                public final Object apply(int i5) {
                    return this.f7460a.lambda$init$0(i5);
                }
            });
        }
        this._stack.clear();
        int i5 = 0;
        while (true) {
            PathContext[] pathContextArr2 = this._paths;
            if (i5 >= pathContextArr2.length) {
                return;
            }
            pathContextArr2[i5].init(xPath._selector._paths[i5]);
            i5++;
        }
    }

    public final int start() {
        int iStart = 0;
        for (PathContext pathContext : this._paths) {
            iStart |= pathContext.start();
        }
        return iStart;
    }
}
