package org.apache.xmlbeans.impl.common;

import java.util.Stack;
import java.util.Vector;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Sax2Dom extends DefaultHandler implements ContentHandler, LexicalHandler {
    public static final String EMPTYSTRING = "";
    public static final String XMLNS_PREFIX = "xmlns";
    public static final String XMLNS_STRING = "xmlns:";
    public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    public static final String XML_PREFIX = "xml";
    private Document _document;
    private Node _root;
    private Stack<Node> _nodeStk = new Stack<>();
    private Vector<String> _namespaceDecls = null;

    public Sax2Dom() {
        this._root = null;
        this._document = null;
        Document documentCreateDocument = DocumentHelper.createDocument();
        this._document = documentCreateDocument;
        this._root = documentCreateDocument;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i5, int i6) {
        Node nodePeek = this._nodeStk.peek();
        if (nodePeek != this._document) {
            nodePeek.appendChild(this._document.createTextNode(new String(cArr, i5, i6)));
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i5, int i6) {
        Node nodePeek = this._nodeStk.peek();
        Comment commentCreateComment = this._document.createComment(new String(cArr, i5, i6));
        if (commentCreateComment != null) {
            nodePeek.appendChild(commentCreateComment);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endDocument() {
        this._nodeStk.pop();
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        this._nodeStk.pop();
    }

    public Node getDOM() {
        return this._root;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) {
        Node nodePeek = this._nodeStk.peek();
        ProcessingInstruction processingInstructionCreateProcessingInstruction = this._document.createProcessingInstruction(str, str2);
        if (processingInstructionCreateProcessingInstruction != null) {
            nodePeek.appendChild(processingInstructionCreateProcessingInstruction);
        }
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startDocument() {
        this._nodeStk.push(this._root);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) {
        Element elementCreateElementNS = this._document.createElementNS(str, str3);
        Vector<String> vector = this._namespaceDecls;
        if (vector != null) {
            int size = vector.size();
            for (int i5 = 0; i5 < size; i5 += 2) {
                int i6 = i5 + 1;
                String strElementAt = this._namespaceDecls.elementAt(i5);
                if (strElementAt == null || strElementAt.equals("")) {
                    elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", XMLNS_PREFIX, this._namespaceDecls.elementAt(i6));
                } else {
                    elementCreateElementNS.setAttributeNS("http://www.w3.org/2000/xmlns/", XMLNS_STRING.concat(strElementAt), this._namespaceDecls.elementAt(i6));
                }
            }
            this._namespaceDecls.clear();
        }
        int length = attributes.getLength();
        for (int i7 = 0; i7 < length; i7++) {
            if (attributes.getLocalName(i7) == null) {
                elementCreateElementNS.setAttribute(attributes.getQName(i7), attributes.getValue(i7));
            } else {
                elementCreateElementNS.setAttributeNS(attributes.getURI(i7), attributes.getQName(i7), attributes.getValue(i7));
            }
        }
        this._nodeStk.peek().appendChild(elementCreateElementNS);
        this._nodeStk.push(elementCreateElementNS);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) {
        if (this._namespaceDecls == null) {
            this._namespaceDecls = new Vector<>(2);
        }
        this._namespaceDecls.addElement(str);
        this._namespaceDecls.addElement(str2);
    }

    public Sax2Dom(Node node) {
        this._root = null;
        this._document = null;
        this._root = node;
        if (node instanceof Document) {
            this._document = (Document) node;
        } else {
            if (node != null) {
                this._document = node.getOwnerDocument();
                return;
            }
            Document documentCreateDocument = DocumentHelper.createDocument();
            this._document = documentCreateDocument;
            this._root = documentCreateDocument;
        }
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void skippedEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i5, int i6) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) {
    }
}
