package org.apache.poi.poifs.crypt.dsig.services;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import javax.xml.crypto.Data;
import javax.xml.crypto.OctetStreamData;
import javax.xml.crypto.XMLCryptoContext;
import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.TransformException;
import javax.xml.crypto.dsig.TransformService;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import org.apache.jcp.xml.dsig.internal.dom.ApacheNodeSetData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.util.SuppressForbidden;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RelationshipTransformService extends TransformService {
    private static final Logger LOG = LogManager.getLogger((Class<?>) RelationshipTransformService.class);
    public static final String TRANSFORM_URI = "http://schemas.openxmlformats.org/package/2006/RelationshipTransform";
    private final List<String> sourceIds;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @SuppressForbidden("new Provider(String,String,String) is not available in Java 8")
    public static final class POIXmlDsigProvider extends Provider {
        private static final String NAME = "POIXmlDsigProvider";
        static final long serialVersionUID = 1;

        private POIXmlDsigProvider() {
            super(NAME, 1.0d, NAME);
            put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform", RelationshipTransformService.class.getName());
            put("TransformService.http://schemas.openxmlformats.org/package/2006/RelationshipTransform MechanismType", "DOM");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class RelationshipTransformParameterSpec implements TransformParameterSpec {
        List<String> sourceIds = new ArrayList();

        public void addRelationshipReference(String str) {
            this.sourceIds.add(str);
        }

        public boolean hasSourceIds() {
            return !this.sourceIds.isEmpty();
        }
    }

    public RelationshipTransformService() {
        LOG.atDebug().log("constructor");
        this.sourceIds = new ArrayList();
    }

    public static synchronized void registerDsigProvider() {
        if (Security.getProvider("POIXmlDsigProvider") == null) {
            Security.addProvider(new POIXmlDsigProvider());
        }
    }

    public AlgorithmParameterSpec getParameterSpec() {
        LOG.atDebug().log("getParameterSpec");
        return null;
    }

    public void init(TransformParameterSpec transformParameterSpec) throws InvalidAlgorithmParameterException {
        LOG.atDebug().log("init(params)");
        if (!(transformParameterSpec instanceof RelationshipTransformParameterSpec)) {
            throw new InvalidAlgorithmParameterException();
        }
        this.sourceIds.addAll(((RelationshipTransformParameterSpec) transformParameterSpec).sourceIds);
    }

    public boolean isFeatureSupported(String str) {
        LOG.atDebug().log("isFeatureSupported(feature)");
        return false;
    }

    public void marshalParams(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) {
        LOG.atDebug().log("marshallParams(parent,context)");
        Element element = (Element) ((DOMStructure) xMLStructure).getNode();
        Document ownerDocument = element.getOwnerDocument();
        for (String str : this.sourceIds) {
            Element elementCreateElementNS = ownerDocument.createElementNS("http://schemas.openxmlformats.org/package/2006/digital-signature", "mdssi:RelationshipReference");
            elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:mdssi", "http://schemas.openxmlformats.org/package/2006/digital-signature");
            elementCreateElementNS.setAttribute("SourceId", str);
            element.appendChild(elementCreateElementNS);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.crypto.dsig.TransformException */
    public Data transform(Data data, XMLCryptoContext xMLCryptoContext) throws TransformException {
        Logger logger = LOG;
        logger.atDebug().log("transform(data,context)");
        logger.atDebug().log("data java type: {}", data.getClass().getName());
        OctetStreamData octetStreamData = (OctetStreamData) data;
        logger.atDebug().log("URI: {}", octetStreamData.getURI());
        try {
            Element documentElement = DocumentHelper.readDocument(octetStreamData.getOctetStream()).getDocumentElement();
            NodeList childNodes = documentElement.getChildNodes();
            TreeMap treeMap = new TreeMap();
            for (int length = childNodes.getLength() - 1; length >= 0; length--) {
                Node nodeItem = childNodes.item(length);
                if (PackageRelationship.RELATIONSHIP_TAG_NAME.equals(nodeItem.getLocalName())) {
                    Element element = (Element) nodeItem;
                    String attribute = element.getAttribute(PackageRelationship.ID_ATTRIBUTE_NAME);
                    if (this.sourceIds.contains(attribute)) {
                        String attribute2 = element.getAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME);
                        if (attribute2 == null || attribute2.isEmpty()) {
                            element.setAttribute(PackageRelationship.TARGET_MODE_ATTRIBUTE_NAME, "Internal");
                        }
                        treeMap.put(attribute, element);
                    }
                }
                documentElement.removeChild(nodeItem);
            }
            Iterator it = treeMap.values().iterator();
            while (it.hasNext()) {
                documentElement.appendChild((Element) it.next());
            }
            LOG.atDebug().log("# Relationship elements: {}", Unbox.box(treeMap.size()));
            return new ApacheNodeSetData(new XMLSignatureInput(documentElement));
        } catch (Exception e) {
            throw new TransformException(e.getMessage(), e);
        }
    }

    public void init(XMLStructure xMLStructure, XMLCryptoContext xMLCryptoContext) throws InvalidAlgorithmParameterException {
        Logger logger = LOG;
        logger.atDebug().log("init(parent,context)");
        logger.atDebug().log("parent java type: {}", xMLStructure.getClass().getName());
        try {
            if (u5.c.f8747j0.parse(((DOMStructure) xMLStructure).getNode(), POIXMLTypeLoader.DEFAULT_XML_OPTIONS) == 0) {
                throw null;
            }
            throw new ClassCastException();
        } catch (XmlException e) {
            throw new InvalidAlgorithmParameterException(e);
        }
    }

    public Data transform(Data data, XMLCryptoContext xMLCryptoContext, OutputStream outputStream) {
        LOG.atDebug().log("transform(data,context,os)");
        return null;
    }
}
