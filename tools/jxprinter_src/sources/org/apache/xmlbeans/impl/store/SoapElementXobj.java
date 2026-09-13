package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.Node;
import org.apache.xmlbeans.impl.soap.SOAPElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class SoapElementXobj extends ElementXobj implements SOAPElement, Node {
    public SoapElementXobj(Locale locale, QName qName) {
        super(locale, qName);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addAttribute(Name name, String str) {
        return DomImpl._soapElement_addAttribute(this, name, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addChildElement(SOAPElement sOAPElement) {
        return DomImpl._soapElement_addChildElement(this, sOAPElement);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addNamespaceDeclaration(String str, String str2) {
        return DomImpl._soapElement_addNamespaceDeclaration(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addTextNode(String str) {
        return DomImpl._soapElement_addTextNode(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void detachNode() {
        DomImpl._soapNode_detachNode(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Iterator<Name> getAllAttributes() {
        return DomImpl._soapElement_getAllAttributes(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public String getAttributeValue(Name name) {
        return DomImpl._soapElement_getAttributeValue(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Iterator<SOAPElement> getChildElements() {
        return DomImpl._soapElement_getChildElements(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Name getElementName() {
        return DomImpl._soapElement_getElementName(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public String getEncodingStyle() {
        return DomImpl._soapElement_getEncodingStyle(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Iterator<String> getNamespacePrefixes() {
        return DomImpl._soapElement_getNamespacePrefixes(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public String getNamespaceURI(String str) {
        return DomImpl._soapElement_getNamespaceURI(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public SOAPElement getParentElement() {
        return DomImpl._soapNode_getParentElement(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public String getValue() {
        return DomImpl._soapNode_getValue(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Iterator<String> getVisibleNamespacePrefixes() {
        return DomImpl._soapElement_getVisibleNamespacePrefixes(this);
    }

    @Override // org.apache.xmlbeans.impl.store.ElementXobj, org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new SoapElementXobj(locale, this._name);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void recycleNode() {
        DomImpl._soapNode_recycleNode(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public boolean removeAttribute(Name name) {
        return DomImpl._soapElement_removeAttribute(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public void removeContents() {
        DomImpl._soapElement_removeContents(this);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public boolean removeNamespaceDeclaration(String str) {
        return DomImpl._soapElement_removeNamespaceDeclaration(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public void setEncodingStyle(String str) {
        DomImpl._soapElement_setEncodingStyle(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void setParentElement(SOAPElement sOAPElement) {
        DomImpl._soapNode_setParentElement(this, sOAPElement);
    }

    @Override // org.apache.xmlbeans.impl.soap.Node
    public void setValue(String str) {
        DomImpl._soapNode_setValue(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addChildElement(Name name) {
        return DomImpl._soapElement_addChildElement(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public Iterator<SOAPElement> getChildElements(Name name) {
        return DomImpl._soapElement_getChildElements(this, name);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addChildElement(String str) {
        return DomImpl._soapElement_addChildElement(this, str);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addChildElement(String str, String str2) {
        return DomImpl._soapElement_addChildElement(this, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.soap.SOAPElement
    public SOAPElement addChildElement(String str, String str2, String str3) {
        return DomImpl._soapElement_addChildElement(this, str, str2, str3);
    }
}
