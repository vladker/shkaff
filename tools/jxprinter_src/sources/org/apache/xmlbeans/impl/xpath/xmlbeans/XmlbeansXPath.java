package org.apache.xmlbeans.impl.xpath.xmlbeans;

import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.Path;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.apache.xmlbeans.impl.xpath.XPathFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlbeansXPath implements Path {
    private final XPath _compiledPath;
    private final String _currentVar;
    private final String _pathKey;

    public XmlbeansXPath(String str, String str2, XPath xPath) {
        this._pathKey = str;
        this._currentVar = str2;
        this._compiledPath = xPath;
    }

    @Override // org.apache.xmlbeans.impl.xpath.Path
    public XPathEngine execute(Cur cur, XmlOptions xmlOptions) {
        return (!cur.isContainer() || this._compiledPath.sawDeepDot()) ? XPathFactory.getCompiledPathSaxon(this._pathKey, this._currentVar, null).execute(cur, XmlOptions.maskNull(xmlOptions)) : new XmlbeansXPathEngine(this._compiledPath, cur);
    }
}
