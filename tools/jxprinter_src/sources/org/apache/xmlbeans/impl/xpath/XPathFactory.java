package org.apache.xmlbeans.impl.xpath;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.saxon.SaxonXPath;
import org.apache.xmlbeans.impl.xpath.saxon.SaxonXQuery;
import org.apache.xmlbeans.impl.xpath.xmlbeans.XmlbeansXPath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XPathFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int USE_SAXON = 4;
    private static final int USE_XMLBEANS = 1;
    private static final Map<String, WeakReference<Path>> _xmlbeansPathCache = new WeakHashMap();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static String compilePath(String str, XmlOptions xmlOptions) {
        getCompiledPath(str, xmlOptions);
        return str;
    }

    public static synchronized String compileQuery(String str, XmlOptions xmlOptions) {
        getCompiledQuery(str, xmlOptions);
        return str;
    }

    public static XmlCursor cursorExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).cursorExecute(cur, xmlOptions);
    }

    public static Path getCompiledPath(String str, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        return getCompiledPath(str, xmlOptionsMaskNull, getCurrentNodeVar(xmlOptionsMaskNull));
    }

    public static Path getCompiledPathSaxon(String str, String str2, Map<String, String> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        try {
            XPath.compileXPath(str, str2, map);
        } catch (XPath.XPathCompileException unused) {
        }
        int i5 = Integer.parseInt(map.getOrDefault(XPath._NS_BOUNDARY, "0"));
        map.remove(XPath._NS_BOUNDARY);
        return new SaxonXPath(str.substring(i5), str2, map);
    }

    private static Path getCompiledPathXmlBeans(String str, String str2, Map<String, String> map) {
        try {
            XmlbeansXPath xmlbeansXPath = new XmlbeansXPath(str, str2, XPath.compileXPath(str, str2, map));
            _xmlbeansPathCache.put(str, new WeakReference<>(xmlbeansXPath));
            return xmlbeansXPath;
        } catch (XPath.XPathCompileException unused) {
            return null;
        }
    }

    public static synchronized XQuery getCompiledQuery(String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, getCurrentNodeVar(xmlOptions), xmlOptions);
    }

    public static String getCurrentNodeVar(XmlOptions xmlOptions) {
        String xqueryCurrentNodeVar = XmlOptions.maskNull(xmlOptions).getXqueryCurrentNodeVar();
        if (xqueryCurrentNodeVar == null) {
            return "this";
        }
        if (xqueryCurrentNodeVar.startsWith("$")) {
            throw new IllegalArgumentException("Omit the '$' prefix for the current node variable");
        }
        return xqueryCurrentNodeVar;
    }

    public static XmlObject[] objectExecQuery(Cur cur, String str, XmlOptions xmlOptions) {
        return getCompiledQuery(str, xmlOptions).objectExecute(cur, xmlOptions);
    }

    public static synchronized XQuery getCompiledQuery(String str, String str2, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull;
        Object orDefault;
        String str3;
        try {
            xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
            HashMap map = new HashMap();
            try {
                XPath.compileXPath(str, str2, map);
                orDefault = map.getOrDefault(XPath._NS_BOUNDARY, "0");
            } catch (XPath.XPathCompileException unused) {
                orDefault = map.getOrDefault(XPath._NS_BOUNDARY, "0");
            } finally {
                Integer.parseInt((String) map.getOrDefault(XPath._NS_BOUNDARY, "0"));
            }
            str3 = (String) orDefault;
        } catch (Throwable th) {
            throw th;
        }
        return new SaxonXQuery(str, str2, Integer.valueOf(Integer.parseInt(str3)), xmlOptionsMaskNull);
    }

    public static Path getCompiledPath(String str, XmlOptions xmlOptions, String str2) {
        char c;
        WeakReference<Path> weakReference;
        if (xmlOptions.isXPathUseSaxon()) {
            c = 4;
        } else {
            c = xmlOptions.isXPathUseXmlBeans() ? (char) 1 : (char) 5;
        }
        int i5 = c & 4;
        HashMap map = i5 != 0 ? new HashMap() : null;
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.readLock().lock();
        int i6 = c & 1;
        if (i6 != 0) {
            try {
                weakReference = _xmlbeansPathCache.get(str);
            } catch (Throwable th) {
                lock.readLock().unlock();
                throw th;
            }
        } else {
            weakReference = null;
        }
        Path compiledPathXmlBeans = weakReference != null ? weakReference.get() : null;
        if (compiledPathXmlBeans != null) {
            reentrantReadWriteLock.readLock().unlock();
            return compiledPathXmlBeans;
        }
        reentrantReadWriteLock.readLock().unlock();
        reentrantReadWriteLock.writeLock().lock();
        if (i6 != 0) {
            try {
                WeakReference<Path> weakReference2 = _xmlbeansPathCache.get(str);
                if (weakReference2 != null) {
                    compiledPathXmlBeans = weakReference2.get();
                }
                if (compiledPathXmlBeans == null) {
                    compiledPathXmlBeans = getCompiledPathXmlBeans(str, str2, map);
                }
            } catch (Throwable th2) {
                lock.writeLock().unlock();
                throw th2;
            }
        }
        if (compiledPathXmlBeans == null && i5 != 0) {
            compiledPathXmlBeans = getCompiledPathSaxon(str, str2, map);
        }
        if (compiledPathXmlBeans == null) {
            StringBuilder sb = new StringBuilder();
            if (i6 != 0) {
                sb.append(" Trying XmlBeans path engine...");
            }
            if (i5 != 0) {
                sb.append(" Trying Saxon path engine...");
            }
            throw new RuntimeException(sb.toString() + " FAILED on " + str);
        }
        reentrantReadWriteLock.writeLock().unlock();
        return compiledPathXmlBeans;
    }
}
