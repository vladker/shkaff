package org.apache.xmlbeans.impl.xpath.saxon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.dom.DOMNodeWrapper;
import net.sf.saxon.om.Item;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.om.SequenceTool;
import net.sf.saxon.sxpath.IndependentContext;
import net.sf.saxon.sxpath.XPathDynamicContext;
import net.sf.saxon.sxpath.XPathEvaluator;
import net.sf.saxon.sxpath.XPathExpression;
import net.sf.saxon.sxpath.XPathVariable;
import net.sf.saxon.tree.wrapper.VirtualNode;
import net.sf.saxon.value.DateTimeValue;
import net.sf.saxon.value.GDateValue;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.store.Cur;
import org.apache.xmlbeans.impl.xpath.Path;
import org.apache.xmlbeans.impl.xpath.XPath;
import org.apache.xmlbeans.impl.xpath.XPathEngine;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SaxonXPath implements Path {
    private String contextVar;
    private String defaultNS;
    private final Map<String, String> namespaceMap;
    private String path;

    public SaxonXPath(String str, String str2, Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.namespaceMap = map2;
        this.path = str;
        this.contextVar = str2;
        this.defaultNS = map.get(XPath._DEFAULT_ELT_NS);
        map2.putAll(map);
        map2.remove(XPath._DEFAULT_ELT_NS);
    }

    private static Node getUnderlyingNode(VirtualNode virtualNode) {
        Object underlyingNode = virtualNode;
        while (underlyingNode instanceof VirtualNode) {
            underlyingNode = ((VirtualNode) underlyingNode).getUnderlyingNode();
        }
        return (Node) underlyingNode;
    }

    @Override // org.apache.xmlbeans.impl.xpath.Path
    public XPathEngine execute(Cur cur, XmlOptions xmlOptions) {
        return new SaxonXPathEngine(this, cur);
    }

    public List selectNodes(Object obj) {
        try {
            Node node = (Node) obj;
            Configuration configuration = new Configuration();
            IndependentContext independentContext = new IndependentContext(configuration);
            String str = this.defaultNS;
            if (str != null) {
                independentContext.setDefaultElementNamespace(str);
            }
            this.namespaceMap.forEach(new a(independentContext, 0));
            NodeInfo nodeInfoUnravel = configuration.unravel(new DOMSource(node));
            XPathEvaluator xPathEvaluator = new XPathEvaluator(configuration);
            xPathEvaluator.setStaticContext(independentContext);
            XPathVariable xPathVariableDeclareVariable = independentContext.declareVariable("", this.contextVar);
            XPathExpression xPathExpressionCreateExpression = xPathEvaluator.createExpression(this.path);
            XPathDynamicContext xPathDynamicContextCreateDynamicContext = xPathExpressionCreateExpression.createDynamicContext((Item) null);
            xPathDynamicContextCreateDynamicContext.setContextItem(nodeInfoUnravel);
            xPathDynamicContextCreateDynamicContext.setVariable(xPathVariableDeclareVariable, nodeInfoUnravel);
            List<DOMNodeWrapper> listEvaluate = xPathExpressionCreateExpression.evaluate(xPathDynamicContextCreateDynamicContext);
            ArrayList arrayList = new ArrayList(listEvaluate.size());
            for (DOMNodeWrapper dOMNodeWrapper : listEvaluate) {
                if (dOMNodeWrapper instanceof DOMNodeWrapper) {
                    arrayList.add(getUnderlyingNode(dOMNodeWrapper));
                } else if (dOMNodeWrapper instanceof NodeInfo) {
                    arrayList.add(dOMNodeWrapper.getStringValue());
                } else if (dOMNodeWrapper instanceof GDateValue) {
                    arrayList.add(dOMNodeWrapper);
                } else if (dOMNodeWrapper instanceof DateTimeValue) {
                    arrayList.add(dOMNodeWrapper);
                } else {
                    arrayList.add(SequenceTool.convertToJava(dOMNodeWrapper));
                }
            }
            return arrayList;
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public List selectPath(Object obj) {
        return selectNodes(obj);
    }
}
