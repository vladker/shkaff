package org.apache.xmlbeans.impl.xpath.xmlbeans;

import java.util.ConcurrentModificationException;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class XmlbeansXPathEngine extends XPathExecutionContext implements XPathEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private final long _version;

    public XmlbeansXPathEngine(XPath xPath, Cur cur) {
        this._version = cur.getLocale().version();
        Cur curWeakCur = cur.weakCur(this);
        this._cur = curWeakCur;
        curWeakCur.push();
        init(xPath);
        int iStart = start();
        if ((iStart & 1) != 0) {
            cur.addToSelection();
        }
        doAttrs(iStart, cur);
        if ((iStart & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
            release();
        }
    }

    private void advance(Cur cur) {
        if (this._cur.isFinish()) {
            if (this._cur.isAtEndOfLastPush()) {
                release();
                return;
            } else {
                end();
                this._cur.next();
                return;
            }
        }
        if (!this._cur.isElem()) {
            do {
                this._cur.next();
            } while (!this._cur.isContainerOrFinish());
            return;
        }
        int iElement = element(this._cur.getName());
        if ((iElement & 1) != 0) {
            cur.addToSelection(this._cur);
        }
        doAttrs(iElement, cur);
        if ((iElement & 2) == 0 || !Locale.toFirstChildElement(this._cur)) {
            end();
            this._cur.skip();
        }
    }

    private void doAttrs(int i5, Cur cur) {
        if ((i5 & 4) == 0 || !this._cur.toFirstAttr()) {
            return;
        }
        do {
            if (attr(this._cur.getName())) {
                cur.addToSelection(this._cur);
            }
        } while (this._cur.toNextAttr());
        this._cur.toParent();
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public boolean next(Cur cur) {
        Cur cur2 = this._cur;
        if (cur2 != null && this._version != cur2.getLocale().version()) {
            throw new ConcurrentModificationException("Document changed during select");
        }
        int iSelectionCount = cur.selectionCount();
        while (this._cur != null) {
            advance(cur);
            if (iSelectionCount != cur.selectionCount()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public void release() {
        Cur cur = this._cur;
        if (cur != null) {
            cur.release();
            this._cur = null;
        }
    }
}
