package org.apache.xmlbeans.impl.store;

import java.util.List;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlDocumentProperties;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
final class DomSaver extends Saver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final boolean _isFrag;
    private Cur _nodeCur;
    private final XmlOptions _options;
    private final SchemaTypeLoader _stl;
    private SchemaType _type;

    public DomSaver(Cur cur, boolean z6, XmlOptions xmlOptions) {
        super(cur, xmlOptions);
        if (cur.isUserNode()) {
            this._type = cur.getUser().get_schema_type();
        }
        this._stl = cur._locale._schemaTypeLoader;
        this._options = xmlOptions;
        this._isFrag = z6;
    }

    private void emitTextValue(Saver.SaveCur saveCur) {
        saveCur.push();
        saveCur.next();
        if (saveCur.isText()) {
            this._nodeCur.next();
            this._nodeCur.insertChars(saveCur.getChars(), saveCur._offSrc, saveCur._cchSrc);
            this._nodeCur.toParent();
        }
        saveCur.pop();
    }

    private void ensureDoc() {
        if (this._nodeCur.isPositioned()) {
            return;
        }
        if (this._isFrag) {
            this._nodeCur.createDomDocFragRoot();
        } else {
            this._nodeCur.createDomDocumentRoot();
        }
        this._nodeCur.next();
    }

    private QName getQualifiedName(Saver.SaveCur saveCur, QName qName) {
        String namespaceURI = qName.getNamespaceURI();
        String uriMapping = namespaceURI.length() > 0 ? getUriMapping(namespaceURI) : "";
        return uriMapping.equals(qName.getPrefix()) ? qName : this._nodeCur._locale.makeQName(namespaceURI, qName.getLocalPart(), uriMapping);
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitComment(Saver.SaveCur saveCur) {
        ensureDoc();
        this._nodeCur.createComment();
        emitTextValue(saveCur);
        this._nodeCur.skip();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitDocType(String str, String str2, String str3) {
        ensureDoc();
        XmlDocumentProperties docProps = Locale.getDocProps(this._nodeCur, true);
        docProps.setDoctypeName(str);
        docProps.setDoctypePublicId(str2);
        docProps.setDoctypeSystemId(str3);
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public boolean emitElement(Saver.SaveCur saveCur, List<QName> list, List<String> list2) {
        if (Locale.isFragmentQName(saveCur.getName())) {
            this._nodeCur.moveTo(null, -2);
        }
        ensureDoc();
        this._nodeCur.createElement(getQualifiedName(saveCur, saveCur.getName()));
        this._nodeCur.next();
        iterateMappings();
        while (hasMapping()) {
            Cur cur = this._nodeCur;
            cur.createAttr(cur._locale.createXmlns(mappingPrefix()));
            this._nodeCur.next();
            this._nodeCur.insertString(mappingUri());
            this._nodeCur.toParent();
            this._nodeCur.skipWithAttrs();
            nextMapping();
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            this._nodeCur.createAttr(getQualifiedName(saveCur, list.get(i5)));
            this._nodeCur.next();
            this._nodeCur.insertString(list2.get(i5));
            this._nodeCur.toParent();
            this._nodeCur.skipWithAttrs();
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitFinish(Saver.SaveCur saveCur) {
        if (Locale.isFragmentQName(saveCur.getName())) {
            return;
        }
        this._nodeCur.next();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitProcinst(Saver.SaveCur saveCur) {
        ensureDoc();
        this._nodeCur.createProcinst(saveCur.getName().getLocalPart());
        emitTextValue(saveCur);
        this._nodeCur.skip();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitStartDoc(Saver.SaveCur saveCur) {
        ensureDoc();
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitText(Saver.SaveCur saveCur) {
        ensureDoc();
        Object chars = saveCur.getChars();
        int i5 = saveCur._cchSrc;
        if (i5 > 0) {
            this._nodeCur.insertChars(chars, saveCur._offSrc, i5);
            this._nodeCur.next();
        }
    }

    public Node saveDom() {
        Locale locale = Locale.getLocale(this._stl, this._options);
        locale.enter();
        try {
            this._nodeCur = locale.getCur();
            while (process()) {
            }
            while (!this._nodeCur.isRoot()) {
                this._nodeCur.toParent();
            }
            SchemaType schemaType = this._type;
            if (schemaType != null) {
                this._nodeCur.setType(schemaType);
            }
            Node node = (Node) this._nodeCur.getDom();
            this._nodeCur.release();
            this._nodeCur = null;
            return node;
        } finally {
            locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.store.Saver
    public void emitEndDoc(Saver.SaveCur saveCur) {
    }
}
