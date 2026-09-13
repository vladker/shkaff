package org.apache.xmlbeans.impl.xpath;

import A3.AbstractC0157z;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class XPathCompilationContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int _column;
    private final String _currentNodeVar;
    private String _expr;
    private final Map<String, String> _externalNamespaces;
    private boolean _lastDeepDot;
    private int _line;
    protected final Map<String, String> _namespaces = new HashMap();
    private int _offset;
    private boolean _sawDeepDot;

    public XPathCompilationContext(Map<String, String> map, String str) {
        this._currentNodeVar = str == null ? "$this" : str;
        this._externalNamespaces = map == null ? new HashMap<>() : map;
    }

    private XPathStep addStep(boolean z6, boolean z7, QName qName, XPathStep xPathStep) {
        XPathStep xPathStep2 = new XPathStep(z6, z7, qName);
        if (xPathStep == null) {
            return xPathStep2;
        }
        XPathStep xPathStep3 = xPathStep;
        while (true) {
            XPathStep xPathStep4 = xPathStep3._next;
            if (xPathStep4 == null) {
                xPathStep3._next = xPathStep2;
                xPathStep2._prev = xPathStep3;
                return xPathStep;
            }
            xPathStep3 = xPathStep4;
        }
    }

    private void computeBacktrack(XPathStep xPathStep) {
        XPathStep xPathStep2;
        while (xPathStep != null) {
            XPathStep xPathStep3 = xPathStep._next;
            while (xPathStep3 != null && !xPathStep3._deep) {
                xPathStep3 = xPathStep3._next;
            }
            if (xPathStep._deep) {
                int i5 = 0;
                XPathStep xPathStep4 = xPathStep;
                int i6 = 0;
                while (xPathStep4 != xPathStep3 && xPathStep4._name != null && !xPathStep4.isWild() && !xPathStep4._attr) {
                    i6++;
                    xPathStep4 = xPathStep4._next;
                }
                int i7 = i6 + 1;
                Object[] objArr = new QName[i7];
                int[] iArr = new int[i7];
                XPathStep xPathStep5 = xPathStep;
                for (int i8 = 0; i8 < i6; i8++) {
                    objArr[i8] = xPathStep5._name;
                    xPathStep5 = xPathStep5._next;
                }
                objArr[i6] = getAnyQName();
                iArr[0] = -1;
                int i9 = 0;
                int i10 = -1;
                while (i9 < i6) {
                    while (i10 > -1 && !objArr[i9].equals(objArr[i10])) {
                        i10 = iArr[i10];
                    }
                    i9++;
                    i10++;
                    iArr[i9] = objArr[i9].equals(objArr[i10]) ? iArr[i10] : i10;
                }
                for (XPathStep xPathStep6 = xPathStep; xPathStep6 != xPathStep4; xPathStep6 = xPathStep6._next) {
                    xPathStep6._hasBacktrack = true;
                    xPathStep6._backtrack = xPathStep;
                    for (int i11 = iArr[i5]; i11 > 0; i11--) {
                        xPathStep6._backtrack = xPathStep6._backtrack._next;
                    }
                    i5++;
                }
                if (i6 > 1) {
                    xPathStep2 = xPathStep;
                    for (int i12 = iArr[i6 - 1]; i12 > 0; i12--) {
                        xPathStep2 = xPathStep2._next;
                    }
                } else {
                    xPathStep2 = xPathStep;
                }
                if (xPathStep4 != xPathStep3 && xPathStep4._attr) {
                    xPathStep4._hasBacktrack = true;
                    xPathStep4._backtrack = xPathStep2;
                    xPathStep4 = xPathStep4._next;
                }
                if (xPathStep4 != xPathStep3 && xPathStep4._name == null) {
                    xPathStep4._hasBacktrack = true;
                    xPathStep4._backtrack = xPathStep2;
                }
                xPathStep._hasBacktrack = true;
                xPathStep._backtrack = xPathStep;
            } else {
                while (xPathStep != xPathStep3) {
                    xPathStep._hasBacktrack = true;
                    xPathStep = xPathStep._next;
                }
            }
            xPathStep = xPathStep3;
        }
    }

    private QName getAnyQName() {
        return new QName("", "");
    }

    private XPath.XPathCompileException newError(String str) {
        return new XPath.XPathCompileException(XmlError.forLocation(str, 0, null, this._line, this._column, this._offset));
    }

    private boolean parseWhitespace() {
        boolean z6 = false;
        while (isWhitespace()) {
            advance();
            z6 = true;
        }
        return z6;
    }

    private boolean tokenize(String... strArr) {
        int length = 0;
        for (String str : strArr) {
            while (isWhitespace(length)) {
                length++;
            }
            if (!startsWith(str, length)) {
                return false;
            }
            length += str.length();
        }
        advance(length);
        return true;
    }

    private String tokenizeNCName() throws XPath.XPathCompileException {
        parseWhitespace();
        if (!isNCNameStart()) {
            throw newError("Expected non-colonized name");
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) currChar());
        while (true) {
            advance();
            if (!isNCName()) {
                return sb.toString();
            }
            sb.append((char) currChar());
        }
    }

    private void tokenizePath(ArrayList<XPathStep> arrayList) throws XPath.XPathCompileException {
        this._lastDeepDot = false;
        XPathStep xPathStep = tokenizeSteps();
        computeBacktrack(xPathStep);
        arrayList.add(xPathStep);
        if (this._lastDeepDot) {
            this._sawDeepDot = true;
            XPathStep xPathStepAddStep = null;
            while (xPathStep != null) {
                XPathStep xPathStep2 = xPathStep._next;
                xPathStepAddStep = addStep(xPathStep._deep, (xPathStep2 != null && xPathStep2._next == null) || xPathStep._attr, xPathStep._name, xPathStepAddStep);
                xPathStep = xPathStep._next;
            }
            computeBacktrack(xPathStepAddStep);
            arrayList.add(xPathStepAddStep);
        }
    }

    private QName tokenizeQName() throws XPath.XPathCompileException {
        if (tokenize(ProxyConfig.MATCH_ALL_SCHEMES)) {
            return getAnyQName();
        }
        String str = tokenizeNCName();
        if (tokenize(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
            return new QName(lookupPrefix(str), tokenize(ProxyConfig.MATCH_ALL_SCHEMES) ? "" : tokenizeNCName());
        }
        return new QName(lookupPrefix(""), str);
    }

    private String tokenizeQuotedUri() throws XPath.XPathCompileException {
        int i5;
        if (tokenize("\"")) {
            i5 = 34;
        } else {
            if (!tokenize("'")) {
                throw newError("Expected quote (\" or ')");
            }
            i5 = 39;
        }
        StringBuilder sb = new StringBuilder();
        while (currChar() != -1) {
            if (currChar() == i5) {
                advance();
                if (currChar() != i5) {
                    return sb.toString();
                }
            }
            sb.append((char) currChar());
            advance();
        }
        throw newError("Path terminated in URI literal");
    }

    private XPath.Selector tokenizeSelector() throws XPath.XPathCompileException {
        ArrayList<XPathStep> arrayList = new ArrayList<>();
        tokenizePath(arrayList);
        while (tokenize("|")) {
            tokenizePath(arrayList);
        }
        return new XPath.Selector((XPathStep[]) arrayList.toArray(new XPathStep[0]));
    }

    private XPathStep tokenizeSteps() throws XPath.XPathCompileException {
        boolean z6;
        boolean z7;
        if (tokenize(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            throw newError("Absolute paths unsupported");
        }
        if (tokenize("$", this._currentNodeVar, "//") || tokenize(Consts.DOT, "//")) {
            z6 = true;
        } else {
            if (!tokenize("$", this._currentNodeVar, PackagingURIHelper.FORWARD_SLASH_STRING) && !tokenize(Consts.DOT, PackagingURIHelper.FORWARD_SLASH_STRING) && (tokenize("$", this._currentNodeVar) || tokenize(Consts.DOT))) {
                return addStep(false, false, null, null);
            }
            z6 = false;
        }
        XPathStep xPathStepAddStep = null;
        loop0: while (true) {
            z7 = false;
            while (true) {
                if (!tokenize("attribute", "::") && !tokenize("@")) {
                    if (tokenize(Consts.DOT)) {
                        z7 = z7 || z6;
                    } else {
                        tokenize("child", "::");
                        xPathStepAddStep = addStep(z6, false, tokenizeQName(), xPathStepAddStep);
                        z6 = false;
                    }
                    if (!tokenize("//")) {
                        if (!tokenize(PackagingURIHelper.FORWARD_SLASH_STRING)) {
                            break loop0;
                        }
                        if (z7) {
                            z6 = true;
                        }
                    } else {
                        break;
                    }
                } else {
                    xPathStepAddStep = addStep(z6, true, tokenizeQName(), xPathStepAddStep);
                    break loop0;
                }
            }
            z6 = true;
        }
        this._lastDeepDot = z7;
        if (z7) {
            this._lastDeepDot = true;
            xPathStepAddStep = addStep(true, false, getAnyQName(), xPathStepAddStep);
        }
        return addStep(false, false, null, xPathStepAddStep);
    }

    private XPath tokenizeXPath() throws XPath.XPathCompileException {
        while (true) {
            if (tokenize("declare", "namespace")) {
                if (!parseWhitespace()) {
                    throw newError("Expected prefix after 'declare namespace'");
                }
                String str = tokenizeNCName();
                if (!tokenize("=")) {
                    throw newError("Expected '='");
                }
                String str2 = tokenizeQuotedUri();
                if (this._namespaces.containsKey(str)) {
                    throw newError(AbstractC0157z.n("Redefinition of namespace prefix: ", str));
                }
                this._namespaces.put(str, str2);
                if (this._externalNamespaces.containsKey(str)) {
                    throw newError(AbstractC0157z.n("Redefinition of namespace prefix: ", str));
                }
                this._externalNamespaces.put(str, str2);
                tokenize(";");
                this._externalNamespaces.put(XPath._NS_BOUNDARY, Integer.toString(this._offset));
            } else {
                if (!tokenize("declare", "default", "element", "namespace")) {
                    if (!this._namespaces.containsKey("")) {
                        this._namespaces.put("", "");
                    }
                    XPath.Selector selector = tokenizeSelector();
                    parseWhitespace();
                    if (currChar() == -1) {
                        return new XPath(selector, this._sawDeepDot);
                    }
                    throw newError("Unexpected char '" + ((char) currChar()) + "'");
                }
                String str3 = tokenizeQuotedUri();
                if (this._namespaces.containsKey("")) {
                    throw newError("Redefinition of default element namespace");
                }
                this._namespaces.put("", str3);
                if (this._externalNamespaces.containsKey(XPath._DEFAULT_ELT_NS)) {
                    throw newError("Redefinition of default element namespace : ");
                }
                this._externalNamespaces.put(XPath._DEFAULT_ELT_NS, str3);
                if (!tokenize(";")) {
                    throw newError("Default Namespace declaration must end with ;");
                }
                this._externalNamespaces.put(XPath._NS_BOUNDARY, Integer.toString(this._offset));
            }
        }
    }

    public void advance() {
        if (this._offset < this._expr.length()) {
            char cCharAt = this._expr.charAt(this._offset);
            int i5 = this._offset;
            this._offset = i5 + 1;
            this._column++;
            if (cCharAt == '\r' || cCharAt == '\n') {
                this._line++;
                this._column = 1;
                if (i5 + 2 < this._expr.length()) {
                    char cCharAt2 = this._expr.charAt(this._offset + 1);
                    if ((cCharAt2 == '\r' || cCharAt2 == '\n') && cCharAt != cCharAt2) {
                        this._offset++;
                    }
                }
            }
        }
    }

    public XPath compile(String str) {
        this._offset = 0;
        this._line = 1;
        this._column = 1;
        this._expr = str;
        return tokenizeXPath();
    }

    public int currChar() {
        return currChar(0);
    }

    public boolean isNCName() {
        return currChar() != -1 && XMLChar.isNCName(currChar());
    }

    public boolean isNCNameStart() {
        return currChar() != -1 && XMLChar.isNCNameStart(currChar());
    }

    public boolean isWhitespace() {
        return isWhitespace(0);
    }

    public String lookupPrefix(String str) throws XPath.XPathCompileException {
        if (this._namespaces.containsKey(str)) {
            return this._namespaces.get(str);
        }
        if (this._externalNamespaces.containsKey(str)) {
            return this._externalNamespaces.get(str);
        }
        switch (str != null ? str : "") {
            case "fn":
                return "http://www.w3.org/2002/11/xquery-functions";
            case "xs":
                return "http://www.w3.org/2001/XMLSchema";
            case "xdt":
                return "http://www.w3.org/2003/11/xpath-datatypes";
            case "xml":
                return "http://www.w3.org/XML/1998/namespace";
            case "xsi":
                return "http://www.w3.org/2001/XMLSchema-instance";
            case "local":
                return "http://www.w3.org/2003/11/xquery-local-functions";
            default:
                throw newError(AbstractC0157z.n("Undefined prefix: ", str));
        }
    }

    public boolean startsWith(String str, int i5) {
        if (this._offset + i5 >= this._expr.length()) {
            return false;
        }
        return this._expr.startsWith(str, this._offset + i5);
    }

    public int currChar(int i5) {
        if (this._offset + i5 >= this._expr.length()) {
            return -1;
        }
        return this._expr.charAt(this._offset + i5);
    }

    public boolean isWhitespace(int i5) {
        int iCurrChar = currChar(i5);
        return iCurrChar == 32 || iCurrChar == 9 || iCurrChar == 10 || iCurrChar == 13;
    }

    public void advance(int i5) {
        while (true) {
            int i6 = i5 - 1;
            if (i5 <= 0) {
                return;
            }
            advance();
            i5 = i6;
        }
    }

    private void processNonXpathDecls() {
    }
}
