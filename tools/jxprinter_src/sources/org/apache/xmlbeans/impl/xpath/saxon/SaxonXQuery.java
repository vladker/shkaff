package org.apache.xmlbeans.impl.xpath.saxon;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathException;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DOMNodeWrapper;
import net.sf.saxon.dom.DocumentWrapper;
import net.sf.saxon.dom.NodeOverNodeInfo;
import net.sf.saxon.ma.map.HashTrieMap;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.query.DynamicQueryContext;
import net.sf.saxon.query.StaticQueryContext;
import net.sf.saxon.query.XQueryExpression;
import net.sf.saxon.str.StringView;
import net.sf.saxon.type.BuiltInAtomicType;
import net.sf.saxon.value.AnyURIValue;
import net.sf.saxon.value.BigDecimalValue;
import net.sf.saxon.value.BigIntegerValue;
import net.sf.saxon.value.BooleanValue;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.DateValue;
import net.sf.saxon.value.DoubleValue;
import net.sf.saxon.value.DurationValue;
import net.sf.saxon.value.FloatValue;
import net.sf.saxon.value.GDayValue;
import net.sf.saxon.value.GMonthDayValue;
import net.sf.saxon.value.GMonthValue;
import net.sf.saxon.value.GYearMonthValue;
import net.sf.saxon.value.GYearValue;
import net.sf.saxon.value.HexBinaryValue;
import net.sf.saxon.value.Int64Value;
import net.sf.saxon.value.ObjectValue;
import net.sf.saxon.value.QNameValue;
import net.sf.saxon.value.SaxonDuration;
import net.sf.saxon.value.SaxonXMLGregorianCalendar;
import net.sf.saxon.value.StringValue;
import net.sf.saxon.value.TimeValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlDate;
import org.apache.xmlbeans.XmlDecimal;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlFloat;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlRuntimeException;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlTokenSource;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.store.Cursor;
import org.apache.xmlbeans.impl.store.Locale;
import org.apache.xmlbeans.impl.xpath.XQuery;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SaxonXQuery implements XQuery {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SaxonXQuery.class);
    private Cur _cur;
    private XmlOptions _options;
    private long _version;
    private final Configuration config;
    private final String contextVar;
    private final XQueryExpression xquery;

    public SaxonXQuery(String str, String str2, Integer num, XmlOptions xmlOptions) {
        this._options = xmlOptions;
        Configuration configuration = new Configuration();
        this.config = configuration;
        StaticQueryContext staticQueryContextNewStaticQueryContext = configuration.newStaticQueryContext();
        Map<String, String> loadAdditionalNamespaces = xmlOptions.getLoadAdditionalNamespaces();
        if (loadAdditionalNamespaces != null) {
            staticQueryContextNewStaticQueryContext.getClass();
            loadAdditionalNamespaces.forEach(new a(staticQueryContextNewStaticQueryContext, 1));
        }
        this.contextVar = str2;
        try {
            this.xquery = staticQueryContextNewStaticQueryContext.compileQuery(str.substring(0, num.intValue()) + " declare variable $" + str2 + " external;" + str.substring(num.intValue()));
        } catch (TransformerException e) {
            throw new XmlRuntimeException(e);
        }
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
        return obj instanceof Date ? XmlDate.type : XmlAnySimpleType.type;
    }

    private Cur loadNode(Locale locale, Node node) {
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
        try {
            loadNodeHelper(locale, node, curLoadContext);
            Cur curFinish = curLoadContext.finish();
            Locale.associateSourceName(curFinish, this._options);
            Locale.autoTypeDocument(curFinish, null, this._options);
            return curFinish;
        } catch (Exception e) {
            throw new XmlRuntimeException(e.getMessage(), e);
        }
    }

    private void loadNodeHelper(Locale locale, Node node, Locale.LoadContext loadContext) {
        if (node.getNodeType() == 2) {
            loadContext.attr(new QName(node.getNamespaceURI(), node.getLocalName(), node.getPrefix()), node.getNodeValue());
        } else {
            locale.loadNode(node, loadContext);
        }
    }

    private static Item objectToItem(Object obj, Configuration configuration) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return BooleanValue.get(((Boolean) obj).booleanValue());
        }
        if (obj instanceof byte[]) {
            return new HexBinaryValue((byte[]) obj);
        }
        if (obj instanceof Byte) {
            return new Int64Value(((Byte) obj).byteValue(), BuiltInAtomicType.BYTE, false);
        }
        if (obj instanceof Float) {
            return new FloatValue(((Float) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new DoubleValue(((Double) obj).doubleValue());
        }
        if (obj instanceof Integer) {
            return new Int64Value(((Integer) obj).intValue(), BuiltInAtomicType.INT, false);
        }
        if (obj instanceof Long) {
            return new Int64Value(((Long) obj).longValue(), BuiltInAtomicType.LONG, false);
        }
        if (obj instanceof Short) {
            return new Int64Value(((Short) obj).shortValue(), BuiltInAtomicType.SHORT, false);
        }
        if (obj instanceof String) {
            return new StringValue((String) obj);
        }
        if (obj instanceof BigDecimal) {
            return new BigDecimalValue((BigDecimal) obj);
        }
        if (obj instanceof BigInteger) {
            return new BigIntegerValue((BigInteger) obj);
        }
        if (obj instanceof SaxonDuration) {
            return ((SaxonDuration) obj).getDurationValue();
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            return new DurationValue(duration.getSign() >= 0, duration.getYears(), duration.getMonths(), duration.getDays(), duration.getHours(), duration.getMinutes(), duration.getSeconds(), 0);
        }
        if (obj instanceof SaxonXMLGregorianCalendar) {
            return ((SaxonXMLGregorianCalendar) obj).toCalendarValue();
        }
        if (!(obj instanceof XMLGregorianCalendar)) {
            if (obj instanceof QName) {
                QName qName = (QName) obj;
                return new QNameValue(qName.getPrefix(), qName.getNamespaceURI(), qName.getLocalPart());
            }
            if (obj instanceof URI) {
                return new AnyURIValue(obj.toString());
            }
            if (!(obj instanceof Map)) {
                return new ObjectValue(obj);
            }
            HashTrieMap hashTrieMap = new HashTrieMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                hashTrieMap.initialPut(objectToItem(entry.getKey(), configuration), objectToItem(entry.getValue(), configuration));
            }
            return hashTrieMap;
        }
        QName xMLSchemaType = ((XMLGregorianCalendar) obj).getXMLSchemaType();
        if (xMLSchemaType.equals(DatatypeConstants.DATETIME)) {
            return DateTimeValue.makeDateTimeValue(StringView.tidy(obj.toString()), configuration.getConversionRules()).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.DATE)) {
            return DateValue.makeDateValue(StringView.tidy(obj.toString()), configuration.getConversionRules()).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.TIME)) {
            return TimeValue.makeTimeValue(StringView.tidy(obj.toString())).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.GYEAR)) {
            return GYearValue.makeGYearValue(StringView.tidy(obj.toString()), configuration.getConversionRules()).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.GYEARMONTH)) {
            return GYearMonthValue.makeGYearMonthValue(StringView.tidy(obj.toString()), configuration.getConversionRules()).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.GMONTH)) {
            String string = obj.toString();
            if (string.endsWith("--")) {
                string = androidx.collection.a.g(2, 0, string);
            }
            return GMonthValue.makeGMonthValue(StringView.tidy(string)).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.GMONTHDAY)) {
            return GMonthDayValue.makeGMonthDayValue(StringView.tidy(obj.toString())).asAtomic();
        }
        if (xMLSchemaType.equals(DatatypeConstants.GDAY)) {
            return GDayValue.makeGDayValue(StringView.tidy(obj.toString())).asAtomic();
        }
        throw new AssertionError("Unknown Gregorian date type");
    }

    @Override // org.apache.xmlbeans.impl.xpath.XQuery
    public XmlCursor cursorExecute(Cur cur, XmlOptions xmlOptions) {
        Cursor cursor;
        this._version = cur.getLocale().version();
        this._cur = cur.weakCur(this);
        this._options = xmlOptions;
        List<Object> listExecQuery = execQuery(this._cur.getDom(), XmlOptions.maskNull(xmlOptions).getXqueryVariables());
        Locale locale = Locale.getLocale(this._cur.getLocale().getSchemaTypeLoader(), this._options);
        locale.enter();
        Cur.CurLoadContext curLoadContext = new Cur.CurLoadContext(locale, this._options);
        int i5 = 0;
        while (true) {
            cursor = null;
            try {
                try {
                    if (i5 >= listExecQuery.size()) {
                        break;
                    }
                    loadNodeHelper(locale, (Node) listExecQuery.get(i5), curLoadContext);
                    i5++;
                } catch (XmlException e) {
                    LOG.atInfo().withThrowable(e).log("Can't autotype document");
                    locale.exit();
                }
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        Cur curFinish = curLoadContext.finish();
        Locale.associateSourceName(cur, this._options);
        Locale.autoTypeDocument(cur, null, this._options);
        Cursor cursor2 = new Cursor(curFinish);
        locale.exit();
        cursor = cursor2;
        release();
        return cursor;
    }

    public List<Object> execQuery(Object obj, Map<String, Object> map) {
        try {
            Node node = (Node) obj;
            DocumentWrapper documentWrapper = new DocumentWrapper(node.getNodeType() == 9 ? (Document) node : node.getOwnerDocument(), (String) null, this.config);
            DOMNodeWrapper dOMNodeWrapperWrap = documentWrapper.wrap(node);
            DynamicQueryContext dynamicQueryContext = new DynamicQueryContext(this.config);
            dynamicQueryContext.setContextItem(dOMNodeWrapperWrap);
            dynamicQueryContext.setParameter(new StructuredQName("", (String) null, this.contextVar), dOMNodeWrapperWrap);
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    StructuredQName structuredQName = new StructuredQName("", (String) null, entry.getKey());
                    Object value = entry.getValue();
                    if (value instanceof XmlTokenSource) {
                        dynamicQueryContext.setParameter(structuredQName, documentWrapper.wrap(((XmlTokenSource) value).getDomNode()));
                    } else {
                        try {
                            dynamicQueryContext.setParameter(structuredQName, objectToItem(value, this.config));
                        } catch (XPathException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            List<Object> listEvaluate = this.xquery.evaluate(dynamicQueryContext);
            ListIterator<Object> listIterator = listEvaluate.listIterator();
            while (listIterator.hasNext()) {
                Object next = listIterator.next();
                if (next instanceof NodeInfo) {
                    listIterator.set(NodeOverNodeInfo.wrap((NodeInfo) next));
                }
            }
            return listEvaluate;
        } catch (TransformerException e6) {
            throw new RuntimeException("Error binding " + this.contextVar, e6);
        }
    }

    @Override // org.apache.xmlbeans.impl.xpath.XQuery
    public XmlObject[] objectExecute(Cur cur, XmlOptions xmlOptions) {
        Cur curLoadNode;
        this._version = cur.getLocale().version();
        this._cur = cur.weakCur(this);
        this._options = xmlOptions;
        List<Object> listExecQuery = execQuery(this._cur.getDom(), XmlOptions.maskNull(xmlOptions).getXqueryVariables());
        XmlObject[] xmlObjectArr = new XmlObject[listExecQuery.size()];
        for (int i5 = 0; i5 < listExecQuery.size(); i5++) {
            Locale locale = Locale.getLocale(this._cur.getLocale().getSchemaTypeLoader(), this._options);
            locale.enter();
            Object obj = listExecQuery.get(i5);
            try {
                try {
                    if (obj instanceof Node) {
                        curLoadNode = loadNode(locale, (Node) obj);
                    } else {
                        curLoadNode = locale.load("<xml-fragment/>").tempCur();
                        curLoadNode.setValue(obj.toString());
                        Locale.autoTypeDocument(curLoadNode, getType(obj), null);
                        xmlObjectArr[i5] = curLoadNode.getObject();
                    }
                    xmlObjectArr[i5] = curLoadNode.getObject();
                    locale.exit();
                    curLoadNode.release();
                } catch (XmlException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                locale.exit();
                throw th;
            }
        }
        release();
        return xmlObjectArr;
    }

    public void release() {
        Cur cur = this._cur;
        if (cur != null) {
            cur.release();
            this._cur = null;
        }
    }
}
