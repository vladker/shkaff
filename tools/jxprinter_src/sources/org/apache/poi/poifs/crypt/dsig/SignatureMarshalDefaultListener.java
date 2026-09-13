package org.apache.poi.poifs.crypt.dsig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.poifs.crypt.dsig.facets.SignatureFacet;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SignatureMarshalDefaultListener implements SignatureMarshalListener {
    private static final String OBJECT_TAG = "Object";
    private static final Set<String> IGNORE_NS = new HashSet(Arrays.asList(null, "http://www.w3.org/2000/xmlns/", SignatureFacet.XML_DIGSIG_NS));
    private static final List<String> DIRECT_NS = Arrays.asList("http://schemas.openxmlformats.org/package/2006/digital-signature", SignatureFacet.MS_DIGSIG_NS);

    private static void forEachElement(NodeList nodeList, Consumer<Element> consumer) {
        int length = nodeList.getLength();
        for (int i5 = 0; i5 < length; i5++) {
            Node nodeItem = nodeList.item(i5);
            if (nodeItem instanceof Element) {
                consumer.accept((Element) nodeItem);
            }
        }
    }

    private void getAllNamespaces(DocumentTraversal documentTraversal, Element element, Map<String, String> map, Map<String, String> map2) {
        map2.clear();
        NodeIterator nodeIteratorCreateNodeIterator = documentTraversal.createNodeIterator(element, 1, (NodeFilter) null, false);
        while (true) {
            try {
                Element element2 = (Element) nodeIteratorCreateNodeIterator.nextNode();
                if (element2 == null) {
                    nodeIteratorCreateNodeIterator.detach();
                    return;
                }
                setPrefix(element2, map, map2);
                NamedNodeMap attributes = element2.getAttributes();
                int length = attributes.getLength();
                for (int i5 = 0; i5 < length; i5++) {
                    setPrefix(attributes.item(i5), map, map2);
                }
            } catch (Throwable th) {
                nodeIteratorCreateNodeIterator.detach();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleElement$2(DocumentTraversal documentTraversal, Map map, Map map2, Element element) {
        forEachElement(element.getChildNodes(), new h(this, documentTraversal, map, map2, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$null$1(DocumentTraversal documentTraversal, Map map, Map map2, Element element) {
        getAllNamespaces(documentTraversal, element, map, map2);
        map2.forEach(new c(element, 3));
    }

    private void setPrefix(Node node, Map<String, String> map, Map<String, String> map2) {
        String namespaceURI = node.getNamespaceURI();
        String str = map.get(namespaceURI);
        if (IGNORE_NS.contains(namespaceURI)) {
            return;
        }
        if (str != null) {
            node.setPrefix(str);
        }
        if (DIRECT_NS.contains(namespaceURI)) {
            setXmlns(node, str, namespaceURI);
        } else {
            map2.put(namespaceURI, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setXmlns(Node node, String str, String str2) {
        if (!(node instanceof Element) || str2.equals(node.getParentNode().getNamespaceURI())) {
            return;
        }
        Element element = (Element) node;
        StringBuilder sb = new StringBuilder(Sax2Dom.XMLNS_PREFIX);
        sb.append(str == null ? "" : ParameterizedMessage.ERROR_MSG_SEPARATOR.concat(str));
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", sb.toString(), str2);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureMarshalListener
    public void handleElement(SignatureInfo signatureInfo, Document document, EventTarget eventTarget, EventListener eventListener) {
        forEachElement(document.getElementsByTagName(OBJECT_TAG), new h(this, (DocumentTraversal) document, signatureInfo.getSignatureConfig().getNamespacePrefixes(), new HashMap(), 0));
    }
}
