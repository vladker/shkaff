package org.apache.xmlbeans.impl.store;

import java.util.Hashtable;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class DocumentXobj extends NodeXobj implements Document {
    private Hashtable<String, DomImpl.Dom> _idToElement;

    public DocumentXobj(Locale locale) {
        super(locale, 1, 9);
    }

    public void addIdElement(String str, DomImpl.Dom dom) {
        if (this._idToElement == null) {
            this._idToElement = new Hashtable<>();
        }
        this._idToElement.put(str, dom);
    }

    @Override // org.w3c.dom.Document
    public Node adoptNode(Node node) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public Attr createAttribute(String str) {
        return DomImpl._document_createAttribute(this, str);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttributeNS(String str, String str2) {
        return DomImpl._document_createAttributeNS(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public CDATASection createCDATASection(String str) {
        return DomImpl._document_createCDATASection(this, str);
    }

    @Override // org.w3c.dom.Document
    public Comment createComment(String str) {
        return DomImpl._document_createComment(this, str);
    }

    @Override // org.w3c.dom.Document
    public DocumentFragment createDocumentFragment() {
        return DomImpl._document_createDocumentFragment(this);
    }

    @Override // org.w3c.dom.Document
    public Element createElement(String str) {
        return DomImpl._document_createElement(this, str);
    }

    @Override // org.w3c.dom.Document
    public Element createElementNS(String str, String str2) {
        return DomImpl._document_createElementNS(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public EntityReference createEntityReference(String str) {
        return DomImpl._document_createEntityReference(this, str);
    }

    @Override // org.w3c.dom.Document
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return DomImpl._document_createProcessingInstruction(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public Text createTextNode(String str) {
        return DomImpl._document_createTextNode(this, str);
    }

    @Override // org.w3c.dom.Document
    public DocumentType getDoctype() {
        return DomImpl._document_getDoctype(this);
    }

    @Override // org.w3c.dom.Document
    public Element getDocumentElement() {
        return DomImpl._document_getDocumentElement(this);
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.w3c.dom.Document
    public Element getElementById(String str) {
        Xobj xobj;
        Hashtable<String, DomImpl.Dom> hashtable = this._idToElement;
        if (hashtable == null || (xobj = (Xobj) hashtable.get(str)) == 0) {
            return null;
        }
        if (!isInSameTree(xobj)) {
            this._idToElement.remove(str);
        }
        return (Element) xobj;
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String str) {
        return DomImpl._document_getElementsByTagName(this, str);
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return DomImpl._document_getElementsByTagNameNS(this, str, str2);
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return DomImpl._document_getImplementation(this);
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public Node importNode(Node node, boolean z6) {
        return DomImpl._document_importNode(this, node, z6);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new DocumentXobj(locale);
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    public void removeIdElement(String str) {
        Hashtable<String, DomImpl.Dom> hashtable = this._idToElement;
        if (hashtable != null) {
            hashtable.remove(str);
        }
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node node, String str, String str2) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean z6) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String str) {
        throw new RuntimeException("DOM Level 3 Not implemented");
    }
}
