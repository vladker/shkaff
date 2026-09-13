package org.apache.xmlbeans.impl.xpath.saxon;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.GDateValue;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.DomImpl;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathExecutionContext;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SaxonXPathEngine extends XPathExecutionContext implements XPathEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Cur _cur;
    private SaxonXPath _engine;
    private final long _version;
    private final DateFormat xmlDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ROOT);
    private boolean _firstCall = true;

    public SaxonXPathEngine(SaxonXPath saxonXPath, Cur cur) {
        this._engine = saxonXPath;
        this._version = cur.getLocale().version();
        this._cur = cur.weakCur(this);
    }

    private SchemaType getType(Object obj) {
        if (obj instanceof Integer) {
            return XmlInteger.type;
        }
        if (obj instanceof Double) {
            return XmlDouble.type;
        }
        if (obj instanceof Long) {
            return XmlLong.type;
        }
        if (obj instanceof Float) {
            return XmlFloat.type;
        }
        if (obj instanceof BigDecimal) {
            return XmlDecimal.type;
        }
        if (obj instanceof Boolean) {
            return XmlBoolean.type;
        }
        if (obj instanceof String) {
            return XmlString.type;
        }
        if (obj instanceof GDateValue) {
            return XmlDate.type;
        }
        return obj instanceof DateTimeValue ? XmlDateTime.type : XmlAnySimpleType.type;
    }

    @Override // org.apache.xmlbeans.impl.xpath.XPathEngine
    public boolean next(Cur cur) {
        Cur curTempCur;
        String plainString;
        if (!this._firstCall) {
            return false;
        }
        this._firstCall = false;
        Cur cur2 = this._cur;
        if (cur2 != null && this._version != cur2.getLocale().version()) {
            throw new ConcurrentModificationException("Document changed during select");
        }
        List listSelectPath = this._engine.selectPath(this._cur.getDom());
        for (int i5 = 0; i5 < listSelectPath.size(); i5++) {
            Object obj = listSelectPath.get(i5);
            if (obj instanceof Node) {
                curTempCur = ((DomImpl.Dom) obj).tempCur();
            } else {
                Object obj2 = listSelectPath.get(i5);
                if (obj2 instanceof Date) {
                    plainString = this.xmlDateFormat.format((Date) obj2);
                } else if (obj2 instanceof GDateValue) {
                    plainString = ((GDateValue) obj2).getStringValue();
                } else if (obj2 instanceof DateTimeValue) {
                    plainString = ((DateTimeValue) obj2).getStringValue();
                } else {
                    plainString = obj2 instanceof BigDecimal ? ((BigDecimal) obj2).toPlainString() : obj2.toString();
                }
                try {
                    curTempCur = cur.getLocale().load("<xml-fragment/>").tempCur();
                    curTempCur.setValue(plainString);
                    org.apache.xmlbeans.impl.store.Locale.autoTypeDocument(curTempCur, getType(obj), null);
                    curTempCur.next();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            cur.addToSelection(curTempCur);
            curTempCur.release();
        }
        release();
        this._engine = null;
        return true;
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
