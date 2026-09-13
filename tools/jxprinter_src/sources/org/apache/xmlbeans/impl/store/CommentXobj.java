package org.apache.xmlbeans.impl.store;

import org.w3c.dom.Comment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class CommentXobj extends NodeXobj implements Comment {
    public CommentXobj(Locale locale) {
        super(locale, 4, 8);
    }

    @Override // org.w3c.dom.CharacterData
    public void appendData(String str) {
        DomImpl._characterData_appendData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void deleteData(int i5, int i6) {
        DomImpl._characterData_deleteData(this, i5, i6);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public NodeList getChildNodes() {
        return DomImpl._emptyNodeList;
    }

    @Override // org.w3c.dom.CharacterData
    public String getData() {
        return DomImpl._characterData_getData(this);
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.Node
    public Node getFirstChild() {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.store.NodeXobj, org.w3c.dom.NodeList, org.w3c.dom.CharacterData
    public int getLength() {
        return DomImpl._characterData_getLength(this);
    }

    @Override // org.w3c.dom.CharacterData
    public void insertData(int i5, String str) {
        DomImpl._characterData_insertData(this, i5, str);
    }

    @Override // org.apache.xmlbeans.impl.store.Xobj
    public Xobj newNode(Locale locale) {
        return new CommentXobj(locale);
    }

    @Override // org.w3c.dom.CharacterData
    public void replaceData(int i5, int i6, String str) {
        DomImpl._characterData_replaceData(this, i5, i6, str);
    }

    @Override // org.w3c.dom.CharacterData
    public void setData(String str) {
        DomImpl._characterData_setData(this, str);
    }

    @Override // org.w3c.dom.CharacterData
    public String substringData(int i5, int i6) {
        return DomImpl._characterData_substringData(this, i5, i6);
    }
}
