package org.apache.xmlbeans.impl.xpath;

import java.util.Map;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XPath {
    public static final String _DEFAULT_ELT_NS = "$xmlbeans!default_uri";
    public static final String _NS_BOUNDARY = "$xmlbeans!ns_boundary";
    private final boolean _sawDeepDot;
    final Selector _selector;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Selector {
        final XPathStep[] _paths;

        public Selector(XPathStep[] xPathStepArr) {
            this._paths = xPathStepArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class XPathCompileException extends XmlException {
        public XPathCompileException(XmlError xmlError) {
            super(xmlError.toString(), (Throwable) null, xmlError);
        }
    }

    public XPath(Selector selector, boolean z6) {
        this._selector = selector;
        this._sawDeepDot = z6;
    }

    public static XPath compileXPath(String str) {
        return compileXPath(str, "$this", null);
    }

    public boolean sawDeepDot() {
        return this._sawDeepDot;
    }

    public static XPath compileXPath(String str, String str2) {
        return compileXPath(str, str2, null);
    }

    public static XPath compileXPath(String str, Map<String, String> map) {
        return compileXPath(str, "$this", map);
    }

    public static XPath compileXPath(String str, String str2, Map<String, String> map) {
        return new XPathCompilationContext(map, str2).compile(str);
    }
}
