package org.apache.xmlbeans.impl.store;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.CDataBookmark;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaField;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlLocale;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.TypeStoreUser;
import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
import org.apache.xmlbeans.impl.xpath.XPathFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
abstract class Xobj implements TypeStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int INHIBIT_DISCONNECT = 1024;
    static final int STABLE_USER = 512;
    static final int VACANT = 256;
    int _bits;
    Bookmark _bookmarks;
    int _cchAfter;
    int _cchValue;
    CharNode _charNodesAfter;
    CharNode _charNodesValue;
    Cur _embedded;
    Xobj _firstChild;
    Xobj _lastChild;
    Locale _locale;
    QName _name;
    Xobj _nextSibling;
    int _offAfter;
    int _offValue;
    Xobj _parent;
    Xobj _prevSibling;
    Object _srcAfter;
    Object _srcValue;
    TypeStoreUser _user;

    public Xobj(Locale locale, int i5, int i6) {
        this._locale = locale;
        this._bits = (i6 << 4) + i5;
    }

    private static TypeStoreUser insertElement(QName qName, Xobj xobj, int i5) {
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj._locale.tempCur();
            curTempCur.moveTo(xobj, i5);
            curTempCur.createElement(qName);
            TypeStoreUser user = curTempCur.getUser();
            curTempCur.release();
            return user;
        } finally {
            xobj._locale.exit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TypeStoreUser lambda$array_setter$0(XmlObject xmlObject) {
        return (TypeStoreUser) xmlObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Xobj lambda$array_setter$1(TypeStore typeStore) {
        return (Xobj) typeStore;
    }

    private static void removeElement(Xobj xobj) {
        if (xobj == null) {
            throw new IndexOutOfBoundsException();
        }
        xobj._locale.enter();
        try {
            Cur curTempCur = xobj.tempCur();
            curTempCur.moveNode(null);
            curTempCur.release();
        } finally {
            xobj._locale.exit();
        }
    }

    private void setValue(String str) {
        int iPosAfter;
        Xobj xobj;
        if (str.length() <= 0) {
            return;
        }
        this._locale.notifyChange();
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr != null) {
            iPosAfter = xobjLastAttr.posAfter();
            xobj = xobjLastAttr;
        } else {
            iPosAfter = 1;
            xobj = this;
        }
        xobj.insertCharsHelper(iPosAfter, str, 0, str.length(), true);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_attribute_user(QName qName) {
        if (getAttr(qName) != null) {
            throw new IndexOutOfBoundsException();
        }
        this._locale.enter();
        try {
            return setAttr(qName, "").getUser();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser add_element_user(QName qName) {
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = null;
        boolean z6 = false;
        QNameSet qNameSet = null;
        for (Xobj xobj2 = this._lastChild; xobj2 != null; xobj2 = xobj2._prevSibling) {
            if (xobj2.isContainer()) {
                if (xobj2._name.equals(qName)) {
                    break;
                }
                if (!z6) {
                    qNameSet = this._user.get_element_ending_delimiters(qName);
                    z6 = true;
                }
                if (qNameSet == null || qNameSet.contains(xobj2._name)) {
                    xobj = xobj2;
                }
            }
        }
        return xobj == null ? insertElement(qName, this, -1) : insertElement(qName, xobj, 0);
    }

    public final Xobj appendXobj(Xobj xobj) {
        xobj._parent = this;
        Xobj xobj2 = this._lastChild;
        xobj._prevSibling = xobj2;
        if (xobj2 == null) {
            this._firstChild = xobj;
        } else {
            xobj2._nextSibling = xobj;
        }
        this._lastChild = xobj;
        return this;
    }

    public final void appendXobjs(Xobj xobj, Xobj xobj2) {
        Xobj xobj3 = this._lastChild;
        xobj._prevSibling = xobj3;
        if (xobj3 == null) {
            this._firstChild = xobj;
        } else {
            xobj3._nextSibling = xobj;
        }
        this._lastChild = xobj2;
        while (xobj != null) {
            xobj._parent = this;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void array_setter(XmlObject[] xmlObjectArr, QName qName) {
        this._locale.enter();
        try {
            int length = xmlObjectArr.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (XmlObject xmlObject : xmlObjectArr) {
                if (xmlObject == null) {
                    throw new IllegalArgumentException("Array element null");
                }
                if (xmlObject.isImmutable()) {
                    arrayList.add(null);
                    arrayList2.add(null);
                } else {
                    Xobj xobj = (Xobj) ((TypeStoreUser) xmlObject).get_store();
                    Locale locale = xobj._locale;
                    Locale locale2 = this._locale;
                    if (locale == locale2) {
                        arrayList.add(xobj.copyNode(locale2));
                    } else {
                        locale.enter();
                        try {
                            arrayList.add(xobj.copyNode(this._locale));
                            xobj._locale.exit();
                        } catch (Throwable th) {
                            xobj._locale.exit();
                            throw th;
                        }
                    }
                    arrayList2.add(xmlObject.schemaType());
                }
            }
            int iCount_elements = count_elements(qName);
            while (iCount_elements > length) {
                remove_element(qName, length);
                iCount_elements--;
            }
            while (length > iCount_elements) {
                add_element_user(qName);
                iCount_elements++;
            }
            ArrayList arrayList3 = new ArrayList();
            find_all_element_users(qName, arrayList3);
            List list = (List) arrayList3.stream().map(new m0(0)).map(new m0(21)).map(new m0(1)).collect(Collectors.toList());
            Cur curTempCur = tempCur();
            for (int i5 = 0; i5 < iCount_elements; i5++) {
                Xobj xobj2 = (Xobj) list.get(i5);
                if (xmlObjectArr[i5].isImmutable()) {
                    xobj2.getObject().set(xmlObjectArr[i5]);
                } else {
                    Cur.moveNodeContents(xobj2, null, true);
                    curTempCur.moveTo(xobj2);
                    curTempCur.next();
                    Cur.moveNodeContents((Xobj) arrayList.get(i5), curTempCur, true);
                    xobj2.change_type((SchemaType) arrayList2.get(i5));
                }
            }
            curTempCur.release();
            this._locale.exit();
        } catch (Throwable th2) {
            this._locale.exit();
            throw th2;
        }
    }

    public final boolean bitIsClear(int i5) {
        return (i5 & this._bits) == 0;
    }

    public final boolean bitIsSet(int i5) {
        return (i5 & this._bits) != 0;
    }

    public final int cchAfter() {
        return this._cchAfter;
    }

    public final int cchLeft(int i5) {
        if (isRoot() && i5 == 0) {
            return 0;
        }
        Xobj denormal = getDenormal(i5);
        int iPosTemp = posTemp();
        int iPosAfter = denormal.posAfter();
        if (iPosTemp < iPosAfter) {
            iPosAfter = 1;
        }
        return iPosTemp - iPosAfter;
    }

    public final int cchRight(int i5) {
        if (i5 <= 0) {
            return 0;
        }
        int iPosAfter = posAfter();
        return i5 < iPosAfter ? (iPosAfter - i5) - 1 : posMax() - i5;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser change_type(SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setType(schemaType, false);
            curTempCur.release();
            return getUser();
        } finally {
            this._locale.exit();
        }
    }

    public final void clearBit(int i5) {
        this._bits = (~i5) & this._bits;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String compute_default_text() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_default_attribute_text(this._name);
        }
        String str = user.get_default_element_text(this._name);
        if (str != null) {
            return str;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_default_text();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int compute_flags() {
        if (isRoot()) {
            return 0;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attributeflags(this._name);
        }
        int i5 = user.get_elementflags(this._name);
        if (i5 != -1) {
            return i5;
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return 0;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_elementflags();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    public final boolean contains(Cur cur) {
        return contains(cur._xobj, cur._pos);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy(SchemaTypeLoader schemaTypeLoader, SchemaType schemaType, XmlOptions xmlOptions) {
        XmlOptions xmlOptionsMaskNull = XmlOptions.maskNull(xmlOptions);
        SchemaType documentType = xmlOptionsMaskNull.getDocumentType();
        if (documentType == null) {
            documentType = schemaType == null ? XmlObject.type : schemaType;
        }
        Locale locale = locale();
        if (xmlOptionsMaskNull.isCopyUseNewSynchronizationDomain()) {
            locale = Locale.getLocale(schemaTypeLoader, xmlOptionsMaskNull);
        }
        Xobj xobjCreateDomDocumentRootXobj = Cur.createDomDocumentRootXobj(locale, (documentType.isDocumentType() || (documentType.isNoType() && (this instanceof DocumentXobj))) ? false : true);
        locale.enter();
        try {
            Cur curTempCur = xobjCreateDomDocumentRootXobj.tempCur();
            curTempCur.setType(schemaType);
            curTempCur.release();
            return xobjCreateDomDocumentRootXobj.copy_contents_from(this);
        } finally {
            locale.exit();
        }
    }

    public Xobj copyNode(Locale locale) {
        Xobj xobj = this;
        Xobj xobj2 = null;
        Xobj xobj3 = null;
        while (true) {
            xobj.ensureOccupancy();
            Xobj xobjNewNode = xobj.newNode(locale);
            xobjNewNode._srcValue = xobj._srcValue;
            xobjNewNode._offValue = xobj._offValue;
            xobjNewNode._cchValue = xobj._cchValue;
            xobjNewNode._srcAfter = xobj._srcAfter;
            xobjNewNode._offAfter = xobj._offAfter;
            xobjNewNode._cchAfter = xobj._cchAfter;
            for (Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
                CDataBookmark cDataBookmark = CDataBookmark.CDATA_BOOKMARK;
                if (xobj.hasBookmark(cDataBookmark.getKey(), bookmark._pos)) {
                    xobjNewNode.setBookmark(bookmark._pos, cDataBookmark.getKey(), cDataBookmark);
                }
            }
            if (xobj2 == null) {
                xobj3 = xobjNewNode;
            } else {
                xobj2.appendXobj(xobjNewNode);
            }
            Xobj xobjWalk = xobj.walk(this, true);
            if (xobjWalk == null) {
                xobj3._srcAfter = null;
                xobj3._offAfter = 0;
                xobj3._cchAfter = 0;
                return xobj3;
            }
            if (xobj == xobjWalk._parent) {
                xobj2 = xobjNewNode;
            } else {
                while (true) {
                    xobj = xobj._parent;
                    if (xobj != xobjWalk._parent) {
                        xobj2 = xobj2._parent;
                    }
                }
            }
            xobj = xobjWalk;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser copy_contents_from(TypeStore typeStore) {
        Xobj xobj = (Xobj) typeStore;
        if (xobj == this) {
            return getUser();
        }
        this._locale.enter();
        try {
            xobj._locale.enter();
            Cur curTempCur = tempCur();
            try {
                Cur curTempCur2 = xobj.tempCur();
                Map<String, String> allNamespaces = Locale.getAllNamespaces(curTempCur2, null);
                curTempCur2.release();
                if (isAttr()) {
                    Cur curTempCur3 = xobj.tempCur();
                    String textValue = Locale.getTextValue(curTempCur3);
                    curTempCur3.release();
                    curTempCur.setValue(textValue);
                } else {
                    disconnectChildrenUsers();
                    setBit(1024);
                    QName xsiTypeName = isContainer() ? getXsiTypeName() : null;
                    Xobj xobjCopyNode = xobj.copyNode(this._locale);
                    Cur.moveNodeContents(this, null, true);
                    curTempCur.next();
                    Cur.moveNodeContents(xobjCopyNode, curTempCur, true);
                    curTempCur.moveTo(this);
                    if (xsiTypeName != null) {
                        curTempCur.setXsiType(xsiTypeName);
                    }
                    clearBit(1024);
                }
                if (allNamespaces != null) {
                    if (!curTempCur.isContainer()) {
                        curTempCur.toParent();
                    }
                    Locale.applyNamespaces(curTempCur, allNamespaces);
                }
                curTempCur.release();
                xobj._locale.exit();
                Locale locale = this._locale;
                return getUser();
            } finally {
                curTempCur.release();
                xobj._locale.exit();
            }
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QName qName) {
        return this._locale.count(this, qName, null);
    }

    public void disconnectChildrenUsers() {
        Xobj xobjWalk = walk(this, this._user == null);
        while (xobjWalk != null) {
            Xobj xobjWalk2 = xobjWalk.walk(this, xobjWalk._user != null);
            xobjWalk.disconnectUser();
            xobjWalk = xobjWalk2;
        }
    }

    public void disconnectNonRootUsers() {
        Xobj xobj = this;
        while (xobj != null) {
            Xobj xobjWalk = xobj.walk(this, xobj._user != null);
            if (!xobj.isRoot()) {
                xobj.disconnectUser();
            }
            xobj = xobjWalk;
        }
    }

    public void disconnectUser() {
        if (this._user == null || inhibitDisconnect()) {
            return;
        }
        ensureOccupancy();
        this._user.disconnect_store();
        this._user = null;
    }

    public final int domType() {
        return (this._bits & 240) >> 4;
    }

    public void dump(PrintStream printStream, Object obj) {
        Cur.dump(printStream, this, obj);
    }

    public final void ensureOccupancy() {
        if (isVacant()) {
            clearBit(256);
            TypeStoreUser typeStoreUser = this._user;
            this._user = null;
            String strBuild_text = typeStoreUser.build_text(this);
            Locale locale = this._locale;
            long j6 = locale._versionAll;
            long j7 = locale._versionSansText;
            setValue(strBuild_text);
            this._locale._versionAll = j6;
            this._user = typeStoreUser;
        }
    }

    public final Xobj ensureParent() {
        Xobj xobj = this._parent;
        return xobj == null ? new DocumentFragXobj(this._locale).appendXobj(this) : xobj;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlObject[] exec_query(String str, XmlOptions xmlOptions) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            XmlObject[] xmlObjectArrObjectExecQuery = XPathFactory.objectExecQuery(curTempCur, str, xmlOptions);
            curTempCur.release();
            return xmlObjectArrObjectExecQuery;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public String fetch_text(int i5) {
        this._locale.enter();
        try {
            return getValueAsString(i5);
        } finally {
            this._locale.exit();
        }
    }

    public final Xobj findXmlnsForPrefix(String str) {
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsPrefix().equals(str)) {
                    return xobjFirstAttr;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QName qName, List<T> list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName)) {
                list.add((XmlObject) xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_attribute_user(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return null;
        }
        return attr.getUser();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QName qName, int i5) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && xobj._name.equals(qName) && (i5 = i5 - 1) < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean find_nil() {
        boolean z6 = false;
        if (isAttr()) {
            return false;
        }
        this._locale.enter();
        try {
            Xobj attr = getAttr(Locale._xsiNil);
            if (attr != null) {
                String valueAsString = attr.getValueAsString(3);
                if (valueAsString.equals("true") || valueAsString.equals("1")) {
                    z6 = true;
                }
            }
            return z6;
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.NamespaceManager
    public String find_prefix_for_nsuri(String str, String str2) {
        this._locale.enter();
        try {
            return prefixForNamespace(str, str2, true);
        } finally {
            this._locale.exit();
        }
    }

    public final Xobj firstAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        return this._firstChild;
    }

    public final Xobj getAttr(QName qName) {
        for (Xobj xobj = this._firstChild; xobj != null && xobj.isAttr(); xobj = xobj._nextSibling) {
            if (xobj._name.equals(qName)) {
                return xobj;
            }
        }
        return null;
    }

    public Object getChars(int i5, int i6, Cur cur) {
        Object chars = getChars(i5, i6);
        Locale locale = this._locale;
        cur._offSrc = locale._offSrc;
        cur._cchSrc = locale._cchSrc;
        return chars;
    }

    public String getCharsAfterAsString(int i5, int i6) {
        int i7 = i5 + this._cchValue + 2;
        if (i7 == posMax()) {
            i7 = -1;
        }
        return getCharsAsString(i7, i6, 1);
    }

    public String getCharsAsString(int i5, int i6, int i7) {
        if (cchRight(i5) == 0) {
            return "";
        }
        Object chars = getChars(i5, i6);
        if (i7 == 1) {
            Locale locale = this._locale;
            return CharUtil.getString(chars, locale._offSrc, locale._cchSrc);
        }
        Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i7);
        Locale locale2 = this._locale;
        scrubBuffer.scrub(chars, locale2._offSrc, locale2._cchSrc);
        return scrubBuffer.getResultAsString();
    }

    public Object getCharsHelper(int i5, int i6) {
        Object obj;
        int iPosAfter = posAfter();
        if (i5 >= iPosAfter) {
            obj = this._srcAfter;
            this._locale._offSrc = (this._offAfter + i5) - iPosAfter;
        } else {
            obj = this._srcValue;
            this._locale._offSrc = (this._offValue + i5) - 1;
        }
        this._locale._cchSrc = i6;
        return obj;
    }

    public String getCharsValueAsString(int i5, int i6) {
        return getCharsAsString(i5 + 1, i6, 1);
    }

    public final Xobj getDenormal(int i5) {
        Xobj xobj;
        Xobj xobjEnsureParent;
        int iPosMax;
        if (i5 != 0) {
            if (i5 == -1) {
                xobjEnsureParent = this._lastChild;
                if (xobjEnsureParent == null) {
                    i5 = posAfter() - 1;
                } else {
                    iPosMax = xobjEnsureParent.posMax();
                }
            }
            xobj = this;
            this._locale._posTemp = i5;
            return xobj;
        }
        xobjEnsureParent = this._prevSibling;
        if (xobjEnsureParent == null) {
            xobjEnsureParent = ensureParent();
            iPosMax = xobjEnsureParent.posAfter() - 1;
        } else {
            iPosMax = xobjEnsureParent.posMax();
        }
        int i6 = iPosMax;
        xobj = xobjEnsureParent;
        i5 = i6;
        this._locale._posTemp = i5;
        return xobj;
    }

    public abstract DomImpl.Dom getDom();

    public final int getDomZeroOneChildren() {
        CharNode charNode;
        if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null) {
            return 0;
        }
        Xobj xobj = this._lastChild;
        if (xobj != null && xobj.isAttr()) {
            Xobj xobj2 = this._lastChild;
            if (xobj2._charNodesAfter == null && xobj2._srcAfter == null && this._srcValue == null && this._charNodesValue == null) {
                return 0;
            }
        }
        Xobj xobj3 = this._firstChild;
        if (xobj3 == this._lastChild && xobj3 != null && !xobj3.isAttr() && this._srcValue == null && this._charNodesValue == null && this._firstChild._srcAfter == null) {
            return 1;
        }
        if (this._firstChild == null && this._srcValue != null && ((charNode = this._charNodesValue) == null || (charNode._next == null && charNode._cch == this._cchValue))) {
            return 1;
        }
        Xobj xobjLastAttr = lastAttr();
        Xobj xobj4 = xobjLastAttr == null ? null : xobjLastAttr._nextSibling;
        return (xobjLastAttr != null && xobjLastAttr._srcAfter == null && xobj4 != null && xobj4._srcAfter == null && xobj4._nextSibling == null) ? 1 : 2;
    }

    public final Cur getEmbedded() {
        this._locale.embedCurs();
        return this._embedded;
    }

    public Object getFirstChars() {
        ensureOccupancy();
        if (this._cchValue > 0) {
            return getChars(1, -1);
        }
        Xobj xobjLastAttr = lastAttr();
        if (xobjLastAttr != null && xobjLastAttr._cchAfter > 0) {
            return xobjLastAttr.getChars(xobjLastAttr.posAfter(), -1);
        }
        Locale locale = this._locale;
        locale._offSrc = 0;
        locale._cchSrc = 0;
        return null;
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String str) {
        return namespaceForPrefix(str, true);
    }

    public final Xobj getNormal(int i5) {
        Xobj xobjEnsureParent;
        if (i5 == posMax()) {
            Xobj xobj = this._nextSibling;
            if (xobj != null) {
                xobjEnsureParent = xobj;
                i5 = 0;
            } else {
                xobjEnsureParent = ensureParent();
                i5 = -1;
            }
        } else if (i5 == posAfter() - 1) {
            xobjEnsureParent = this;
            i5 = -1;
        } else {
            xobjEnsureParent = this;
        }
        this._locale._posTemp = i5;
        return xobjEnsureParent;
    }

    public final XmlObject getObject() {
        if (isUserNode()) {
            return (XmlObject) getUser();
        }
        return null;
    }

    public final QName getQName() {
        return this._name;
    }

    public final TypeStoreUser getUser() {
        if (this._user == null) {
            Xobj xobj = this._parent;
            TypeStoreUser typeStoreUserCreateTypeStoreUser = xobj == null ? ((TypeStoreUserFactory) XmlBeans.NO_TYPE).createTypeStoreUser() : xobj.getUser();
            TypeStoreUser typeStoreUserCreate_element_user = isElem() ? typeStoreUserCreateTypeStoreUser.create_element_user(this._name, getXsiTypeName()) : typeStoreUserCreateTypeStoreUser.create_attribute_user(this._name);
            this._user = typeStoreUserCreate_element_user;
            typeStoreUserCreate_element_user.attach_store(this);
        }
        return this._user;
    }

    public final QName getValueAsQName() {
        String strSubstring;
        String valueAsString = getValueAsString(3);
        int iIndexOf = valueAsString.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = valueAsString.substring(0, iIndexOf);
            valueAsString = valueAsString.substring(iIndexOf + 1);
        } else {
            strSubstring = "";
        }
        String strNamespaceForPrefix = namespaceForPrefix(strSubstring, true);
        if (strNamespaceForPrefix == null) {
            return null;
        }
        return new QName(strNamespaceForPrefix, valueAsString);
    }

    public String getValueAsString(int i5) {
        if (hasChildren()) {
            Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(i5);
            Cur curTempCur = tempCur();
            curTempCur.push();
            curTempCur.next();
            while (!curTempCur.isAtEndOfLastPush()) {
                if (curTempCur.isText()) {
                    scrubBuffer.scrub(curTempCur.getChars(-1), curTempCur._offSrc, curTempCur._cchSrc);
                }
                if (curTempCur.isComment() || curTempCur.isProcinst()) {
                    curTempCur.skip();
                } else {
                    curTempCur.next();
                }
            }
            String resultAsString = scrubBuffer.getResultAsString();
            curTempCur.release();
            return resultAsString;
        }
        Object firstChars = getFirstChars();
        if (i5 != 1) {
            Locale.ScrubBuffer scrubBuffer2 = Locale.getScrubBuffer(i5);
            Locale locale = this._locale;
            scrubBuffer2.scrub(firstChars, locale._offSrc, locale._cchSrc);
            return scrubBuffer2.getResultAsString();
        }
        Locale locale2 = this._locale;
        String string = CharUtil.getString(firstChars, locale2._offSrc, locale2._cchSrc);
        if (string.length() > 0) {
            Xobj xobjLastAttr = lastAttr();
            if (xobjLastAttr != null) {
                xobjLastAttr._srcAfter = string;
                xobjLastAttr._offAfter = 0;
                return string;
            }
            this._srcValue = string;
            this._offValue = 0;
        }
        return string;
    }

    public final String getXmlnsPrefix() {
        return Locale.xmlnsPrefix(this._name);
    }

    public final String getXmlnsUri() {
        return getValueAsString();
    }

    public final QName getXsiTypeName() {
        Xobj attr = getAttr(Locale._xsiType);
        if (attr == null) {
            return null;
        }
        return attr.getValueAsQName();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlLocale get_locale() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public Object get_root_object() {
        return this._locale;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaField get_schema_field() {
        if (isRoot()) {
            return null;
        }
        TypeStoreUser user = ensureParent().getUser();
        if (isAttr()) {
            return user.get_attribute_field(this._name);
        }
        TypeStoreVisitor typeStoreVisitorNew_visitor = user.new_visitor();
        if (typeStoreVisitorNew_visitor == null) {
            return null;
        }
        Xobj xobj = this._parent._firstChild;
        while (true) {
            if (xobj.isElem()) {
                typeStoreVisitorNew_visitor.visit(xobj._name);
                if (xobj == this) {
                    return typeStoreVisitorNew_visitor.get_schema_field();
                }
            }
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public SchemaTypeLoader get_schematypeloader() {
        return this._locale._schemaTypeLoader;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public QName get_xsi_type() {
        return getXsiTypeName();
    }

    public final boolean hasAttrs() {
        Xobj xobj = this._firstChild;
        return xobj != null && xobj.isAttr();
    }

    public final boolean hasBookmark(Object obj, int i5) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (bookmark._pos == i5 && obj == bookmark._key) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasChildren() {
        Xobj xobj = this._lastChild;
        return (xobj == null || xobj.isAttr()) ? false : true;
    }

    public final boolean hasTextEnsureOccupancy() {
        ensureOccupancy();
        return hasTextNoEnsureOccupancy();
    }

    public final boolean hasTextNoEnsureOccupancy() {
        if (this._cchValue > 0) {
            return true;
        }
        Xobj xobjLastAttr = lastAttr();
        return xobjLastAttr != null && xobjLastAttr._cchAfter > 0;
    }

    public final boolean inChars(int i5, Xobj xobj, int i6, int i7, boolean z6) {
        int i8;
        if (!z6) {
            i8 = 0;
        } else {
            if (xobj.isRoot() && i6 == 0) {
                return false;
            }
            xobj = xobj.getDenormal(i6);
            i6 = xobj.posTemp();
            i8 = 1;
        }
        return xobj == this && i6 >= i5 && i6 < (i5 + i7) + i8;
    }

    public final boolean inhibitDisconnect() {
        return bitIsSet(1024);
    }

    public final void insertCharsHelper(int i5, Object obj, int i6, int i7, boolean z6) {
        Xobj xobj;
        int iPosAfter = posAfter();
        if (i5 - (i5 < iPosAfter ? 1 : 2) < this._cchValue + this._cchAfter) {
            for (Cur embedded = getEmbedded(); embedded != null; embedded = embedded._next) {
                int i8 = embedded._pos;
                if (i8 >= i5) {
                    embedded._pos = i8 + i7;
                }
            }
            for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
                int i9 = bookmark._pos;
                if (i9 >= i5) {
                    bookmark._pos = i9 + i7;
                }
            }
        }
        CharUtil charUtil = this._locale.getCharUtil();
        if (i5 < iPosAfter) {
            this._srcValue = charUtil.insertChars(i5 - 1, this._srcValue, this._offValue, this._cchValue, obj, i6, i7);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z6) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.insertChars(i5 - iPosAfter, this._srcAfter, this._offAfter, this._cchAfter, obj, i6, i7);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z6 || (xobj = this._parent) == null) {
            return;
        }
        xobj.invalidateUser();
    }

    public final void insertXobj(Xobj xobj) {
        ensureParent();
        xobj._parent = this._parent;
        xobj._prevSibling = this._prevSibling;
        xobj._nextSibling = this;
        Xobj xobj2 = this._prevSibling;
        if (xobj2 != null) {
            xobj2._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj;
    }

    public final void insertXobjs(Xobj xobj, Xobj xobj2) {
        xobj._prevSibling = this._prevSibling;
        xobj2._nextSibling = this;
        Xobj xobj3 = this._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj;
        } else {
            this._parent._firstChild = xobj;
        }
        this._prevSibling = xobj2;
        while (xobj != this) {
            xobj._parent = this._parent;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QName qName, int i5) {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, qName, null, i5);
        if (xobjFindNthChildElem != null) {
            return insertElement(qName, xobjFindNthChildElem, 0);
        }
        if (i5 <= this._locale.count(this, qName, null) + 1) {
            return add_element_user(qName);
        }
        throw new IndexOutOfBoundsException();
    }

    public void invalidateNil() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_nilvalue();
        }
    }

    public final void invalidateSpecialAttr(Xobj xobj) {
        if (isAttr()) {
            if (this._name.equals(Locale._xsiType)) {
                Xobj xobj2 = this._parent;
                if (xobj2 != null) {
                    xobj2.disconnectNonRootUsers();
                }
                if (xobj != null) {
                    xobj.disconnectNonRootUsers();
                }
            }
            if (this._name.equals(Locale._xsiNil)) {
                Xobj xobj3 = this._parent;
                if (xobj3 != null) {
                    xobj3.invalidateNil();
                }
                if (xobj != null) {
                    xobj.invalidateNil();
                }
            }
        }
    }

    public final void invalidateUser() {
        TypeStoreUser typeStoreUser = this._user;
        if (typeStoreUser != null) {
            typeStoreUser.invalidate_value();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_nil() {
        if (isAttr()) {
            return;
        }
        this._locale.enter();
        try {
            if (this._user.build_nil()) {
                setAttr(Locale._xsiNil, "true");
            } else {
                removeAttr(Locale._xsiNil);
            }
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void invalidate_text() {
        this._locale.enter();
        try {
            if (isOccupied()) {
                if (hasTextNoEnsureOccupancy() || hasChildren()) {
                    TypeStoreUser typeStoreUser = this._user;
                    this._user = null;
                    Cur curTempCur = tempCur();
                    curTempCur.moveNodeContents(null, false);
                    curTempCur.release();
                    this._user = typeStoreUser;
                }
                setBit(256);
            }
        } finally {
            this._locale.exit();
        }
    }

    public final boolean isAttr() {
        return kind() == 3;
    }

    public final boolean isCharNodesAfterUsable() {
        if (this._srcAfter == null) {
            return false;
        }
        CharNode charNode = this._charNodesAfter;
        if (charNode != null && charNode._next == null && charNode._cch == this._cchAfter) {
            return true;
        }
        CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, charNode, this._cchAfter);
        this._charNodesAfter = charNodeUpdateCharNodes;
        return charNodeUpdateCharNodes != null;
    }

    public final boolean isCharNodesValueUsable() {
        if (isExistingCharNodesValueUsable()) {
            return true;
        }
        CharNode charNodeUpdateCharNodes = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue);
        this._charNodesValue = charNodeUpdateCharNodes;
        return charNodeUpdateCharNodes != null;
    }

    public final boolean isComment() {
        return kind() == 4;
    }

    public final boolean isContainer() {
        return Cur.kindIsContainer(kind());
    }

    public final boolean isElem() {
        return kind() == 2;
    }

    public final boolean isExistingCharNodesValueUsable() {
        CharNode charNode;
        return this._srcValue != null && (charNode = this._charNodesValue) != null && charNode._next == null && charNode._cch == this._cchValue;
    }

    public final boolean isFirstChildPtrDomUsable() {
        Xobj xobj = this._firstChild;
        if (xobj == null && this._srcValue == null && this._charNodesValue == null) {
            return true;
        }
        return xobj != null && !xobj.isAttr() && this._srcValue == null && this._charNodesValue == null;
    }

    public final boolean isInSameTree(Xobj xobj) {
        if (this._locale != xobj._locale) {
            return false;
        }
        Xobj xobj2 = this;
        while (xobj2 != xobj) {
            Xobj xobj3 = xobj2._parent;
            if (xobj3 == null) {
                while (xobj != this) {
                    Xobj xobj4 = xobj._parent;
                    if (xobj4 == null) {
                        return xobj == xobj2;
                    }
                    xobj = xobj4;
                }
                return true;
            }
            xobj2 = xobj3;
        }
        return true;
    }

    public final boolean isJustAfterEnd(Xobj xobj, int i5) {
        if (xobj.isRoot() && i5 == 0) {
            return false;
        }
        if (xobj == this) {
            return i5 == posAfter();
        }
        return xobj.getDenormal(i5) == this && xobj.posTemp() == posAfter();
    }

    public final boolean isNextSiblingPtrDomUsable() {
        return this._charNodesAfter == null && this._srcAfter == null;
    }

    public final boolean isNormal(int i5) {
        Xobj xobj;
        if (!isValid()) {
            return false;
        }
        if (i5 == -1 || i5 == 0) {
            return true;
        }
        if (i5 >= 0 && i5 < posMax()) {
            if (i5 >= posAfter()) {
                if (isRoot()) {
                    return false;
                }
                Xobj xobj2 = this._nextSibling;
                if ((xobj2 != null && xobj2.isAttr()) || (xobj = this._parent) == null || !xobj.isContainer()) {
                    return false;
                }
            }
            if (i5 != posAfter() - 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNormalAttr() {
        return isAttr() && !Locale.isXmlns(this._name);
    }

    public final boolean isOccupied() {
        return bitIsClear(256);
    }

    public final boolean isProcinst() {
        return kind() == 5;
    }

    public final boolean isRoot() {
        return kind() == 1;
    }

    public final boolean isStableUser() {
        return bitIsSet(512);
    }

    public final boolean isUserNode() {
        int iKind = kind();
        return iKind == 2 || iKind == 1 || (iKind == 3 && !isXmlns());
    }

    public final boolean isVacant() {
        return bitIsSet(256);
    }

    public final boolean isValid() {
        if (isVacant()) {
            return this._cchValue == 0 && this._user != null;
        }
        return true;
    }

    public final boolean isXmlns() {
        return isAttr() && Locale.isXmlns(this._name);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean is_attribute() {
        return isAttr();
    }

    public final int kind() {
        return this._bits & 15;
    }

    public final Xobj lastAttr() {
        Xobj xobj = this._firstChild;
        if (xobj == null || !xobj.isAttr()) {
            return null;
        }
        Xobj xobj2 = this._firstChild;
        while (true) {
            Xobj xobj3 = xobj2._nextSibling;
            if (xobj3 == null || !xobj3.isAttr()) {
                break;
            }
            xobj2 = xobj2._nextSibling;
        }
        return xobj2;
    }

    public final Locale locale() {
        return this._locale;
    }

    public final String namespaceForPrefix(String str, boolean z6) {
        if (str == null) {
            str = "";
        }
        if (str.equals("xml")) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if (str.equals(Sax2Dom.XMLNS_PREFIX)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
            for (Xobj xobj2 = xobj._firstChild; xobj2 != null && xobj2.isAttr(); xobj2 = xobj2._nextSibling) {
                if (xobj2.isXmlns() && xobj2.getXmlnsPrefix().equals(str)) {
                    return xobj2.getXmlnsUri();
                }
            }
        }
        if (z6 && str.length() == 0) {
            return "";
        }
        return null;
    }

    public abstract Xobj newNode(Locale locale);

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public XmlCursor new_cursor() {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            Cursor cursor = new Cursor(curTempCur);
            curTempCur.release();
            return cursor;
        } finally {
            this._locale.exit();
        }
    }

    public final Xobj nextAttr() {
        Xobj xobj = this._firstChild;
        if (xobj != null && xobj.isAttr()) {
            return this._firstChild;
        }
        Xobj xobj2 = this._nextSibling;
        if (xobj2 == null || !xobj2.isAttr()) {
            return null;
        }
        return this._nextSibling;
    }

    public final int nodeType() {
        return domType();
    }

    public final int posAfter() {
        return this._cchValue + 2;
    }

    public final int posMax() {
        return this._cchValue + 2 + this._cchAfter;
    }

    public final int posTemp() {
        return this._locale._posTemp;
    }

    public final String prefixForNamespace(String str, String str2, boolean z6) {
        if (str == null) {
            str = "";
        }
        if (str.equals("http://www.w3.org/XML/1998/namespace")) {
            return "xml";
        }
        if (str.equals("http://www.w3.org/2000/xmlns/")) {
            return Sax2Dom.XMLNS_PREFIX;
        }
        Xobj xobjEnsureParent = this;
        while (!xobjEnsureParent.isContainer()) {
            xobjEnsureParent = xobjEnsureParent.ensureParent();
        }
        if (str.length() == 0) {
            Xobj xobjFindXmlnsForPrefix = xobjEnsureParent.findXmlnsForPrefix("");
            if (xobjFindXmlnsForPrefix != null && xobjFindXmlnsForPrefix.getXmlnsUri().length() != 0) {
                if (!z6) {
                    return null;
                }
                xobjEnsureParent.setAttr(this._locale.createXmlns(null), "");
            }
            return "";
        }
        for (Xobj xobj = xobjEnsureParent; xobj != null; xobj = xobj._parent) {
            for (Xobj xobjFirstAttr = xobj.firstAttr(); xobjFirstAttr != null; xobjFirstAttr = xobjFirstAttr.nextAttr()) {
                if (xobjFirstAttr.isXmlns() && xobjFirstAttr.getXmlnsUri().equals(str) && xobjEnsureParent.findXmlnsForPrefix(xobjFirstAttr.getXmlnsPrefix()) == xobjFirstAttr) {
                    return xobjFirstAttr.getXmlnsPrefix();
                }
            }
        }
        if (!z6) {
            return null;
        }
        if (str2 != null && (str2.length() == 0 || str2.toLowerCase(java.util.Locale.ROOT).startsWith("xml") || xobjEnsureParent.findXmlnsForPrefix(str2) != null)) {
            str2 = null;
        }
        if (str2 == null) {
            String strSuggestPrefix = QNameHelper.suggestPrefix(str);
            int i5 = 1;
            str2 = strSuggestPrefix;
            while (xobjEnsureParent.findXmlnsForPrefix(str2) != null) {
                StringBuilder sbR = androidx.collection.a.r(strSuggestPrefix);
                sbR.append(i5);
                str2 = sbR.toString();
                i5++;
            }
        }
        for (Xobj xobj2 = xobjEnsureParent; !xobj2.isRoot() && !xobj2.ensureParent().isRoot(); xobj2 = xobj2._parent) {
        }
        xobjEnsureParent.setAttr(this._locale.createXmlns(str2), str);
        return str2;
    }

    public final boolean removeAttr(QName qName) {
        Xobj attr = getAttr(qName);
        if (attr == null) {
            return false;
        }
        Cur curTempCur = attr.tempCur();
        while (true) {
            curTempCur.moveNode(null);
            Xobj attr2 = getAttr(qName);
            if (attr2 == null) {
                curTempCur.release();
                return true;
            }
            curTempCur.moveTo(attr2);
        }
    }

    public final void removeCharsHelper(int i5, int i6, Xobj xobj, int i7, boolean z6, boolean z7) {
        Xobj xobj2;
        int i8;
        int i9;
        Cur embedded = getEmbedded();
        while (embedded != null) {
            Cur cur = embedded._next;
            int i10 = embedded._pos;
            if (i10 >= i5 && i10 < i5 + i6) {
                if (z6) {
                    embedded.moveToNoCheck(xobj, (i10 + i7) - i5);
                } else {
                    embedded.nextChars((i6 - i10) + i5);
                }
            }
            if (embedded._xobj == this && (i9 = embedded._pos) >= i5 + i6) {
                embedded._pos = i9 - i6;
            }
            embedded = cur;
        }
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            int i11 = bookmark._pos;
            if (i11 >= i5 && i11 < i5 + i6) {
                bookmark.moveTo(xobj, (i11 + i7) - i5);
            }
            if (bookmark._xobj == this && (i8 = bookmark._pos) >= i5 + i6) {
                bookmark._pos = i8 - i6;
            }
        }
        int iPosAfter = posAfter();
        CharUtil charUtil = this._locale.getCharUtil();
        if (i5 < iPosAfter) {
            this._srcValue = charUtil.removeChars(i5 - 1, i6, this._srcValue, this._offValue, this._cchValue);
            this._offValue = charUtil._offSrc;
            this._cchValue = charUtil._cchSrc;
            if (z7) {
                invalidateUser();
                invalidateSpecialAttr(null);
                return;
            }
            return;
        }
        this._srcAfter = charUtil.removeChars(i5 - iPosAfter, i6, this._srcAfter, this._offAfter, this._cchAfter);
        this._offAfter = charUtil._offSrc;
        this._cchAfter = charUtil._cchSrc;
        if (!z7 || (xobj2 = this._parent) == null) {
            return;
        }
        xobj2.invalidateUser();
    }

    public final void removeXobj() {
        Xobj xobj = this._parent;
        if (xobj != null) {
            if (xobj._firstChild == this) {
                xobj._firstChild = this._nextSibling;
            }
            if (xobj._lastChild == this) {
                xobj._lastChild = this._prevSibling;
            }
            Xobj xobj2 = this._prevSibling;
            if (xobj2 != null) {
                xobj2._nextSibling = this._nextSibling;
            }
            Xobj xobj3 = this._nextSibling;
            if (xobj3 != null) {
                xobj3._prevSibling = xobj2;
            }
            this._parent = null;
            this._prevSibling = null;
            this._nextSibling = null;
        }
    }

    public final void removeXobjs(Xobj xobj, Xobj xobj2) {
        if (this._firstChild == xobj) {
            this._firstChild = xobj2._nextSibling;
        }
        if (this._lastChild == xobj2) {
            this._lastChild = xobj._prevSibling;
        }
        Xobj xobj3 = xobj._prevSibling;
        if (xobj3 != null) {
            xobj3._nextSibling = xobj2._nextSibling;
        }
        Xobj xobj4 = xobj2._nextSibling;
        if (xobj4 != null) {
            xobj4._prevSibling = xobj3;
        }
        xobj._prevSibling = null;
        xobj2._nextSibling = null;
        while (xobj != null) {
            xobj._parent = null;
            xobj = xobj._nextSibling;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_attribute(QName qName) {
        this._locale.enter();
        try {
            if (!removeAttr(qName)) {
                throw new IndexOutOfBoundsException();
            }
            this._locale.exit();
        } catch (Throwable th) {
            this._locale.exit();
            throw th;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QName qName, int i5) {
        if (i5 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (!isContainer()) {
            throw new IllegalStateException();
        }
        Xobj xobj = this._firstChild;
        while (xobj != null && (!xobj.isElem() || !xobj._name.equals(qName) || (i5 = i5 - 1) >= 0)) {
            xobj = xobj._nextSibling;
        }
        removeElement(xobj);
    }

    public final Xobj setAttr(QName qName, String str) {
        Cur curTempCur = tempCur();
        if (curTempCur.toAttr(qName)) {
            curTempCur.removeFollowingAttrs();
        } else {
            curTempCur.next();
            curTempCur.createAttr(qName);
        }
        curTempCur.setValue(str);
        Xobj xobj = curTempCur._xobj;
        curTempCur.release();
        return xobj;
    }

    public final void setBit(int i5) {
        this._bits = i5 | this._bits;
    }

    public final Bookmark setBookmark(int i5, Object obj, Object obj2) {
        for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
            if (i5 == bookmark._pos && obj == bookmark._key) {
                if (obj2 == null) {
                    this._bookmarks = bookmark.listRemove(this._bookmarks);
                    return null;
                }
                bookmark._value = obj2;
                return bookmark;
            }
        }
        if (obj2 == null) {
            return null;
        }
        Bookmark bookmark2 = new Bookmark();
        bookmark2._xobj = this;
        bookmark2._pos = i5;
        bookmark2._key = obj;
        bookmark2._value = obj2;
        this._bookmarks = bookmark2.listInsert(this._bookmarks);
        return bookmark2;
    }

    public final void setName(QName qName) {
        Xobj xobj;
        if (this._name.equals(qName) && this._name.getPrefix().equals(qName.getPrefix())) {
            return;
        }
        this._locale.notifyChange();
        QName qName2 = this._name;
        this._name = qName;
        if (this instanceof NamedNodeXobj) {
            ((NamedNodeXobj) this)._canHavePrefixUri = true;
        }
        if (!isProcinst()) {
            if (!isAttr() || this._parent == null) {
                xobj = this;
            } else {
                QName qName3 = Locale._xsiType;
                xobj = (qName2.equals(qName3) || qName.equals(qName3)) ? this._parent : this;
                QName qName4 = Locale._xsiNil;
                if (qName2.equals(qName4) || qName.equals(qName4)) {
                    this._parent.invalidateNil();
                }
            }
            xobj.disconnectNonRootUsers();
        }
        Locale locale = this._locale;
        locale._versionAll++;
        locale._versionSansText++;
    }

    public void setStableType(SchemaType schemaType) {
        setStableUser(((TypeStoreUserFactory) schemaType).createTypeStoreUser());
    }

    public void setStableUser(TypeStoreUser typeStoreUser) {
        disconnectNonRootUsers();
        disconnectUser();
        this._user = typeStoreUser;
        typeStoreUser.attach_store(this);
        setBit(512);
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void store_text(String str) {
        this._locale.enter();
        TypeStoreUser typeStoreUser = this._user;
        this._user = null;
        try {
            Cur curTempCur = tempCur();
            curTempCur.moveNodeContents(null, false);
            if (str != null && str.length() > 0) {
                curTempCur.next();
                curTempCur.insertString(str);
            }
            curTempCur.release();
        } finally {
            this._user = typeStoreUser;
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser substitute(QName qName, SchemaType schemaType) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            curTempCur.setSubstitution(qName, schemaType);
            curTempCur.release();
            return getUser();
        } finally {
            this._locale.exit();
        }
    }

    public final Cur tempCur() {
        Cur curTempCur = this._locale.tempCur();
        curTempCur.moveTo(this);
        return curTempCur;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void validate(ValidatorListener validatorListener) {
        this._locale.enter();
        try {
            Cur curTempCur = tempCur();
            new Validate(curTempCur, validatorListener);
            curTempCur.release();
        } finally {
            this._locale.exit();
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public boolean validate_on_set() {
        return this._locale._validateOnSet;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void visit_elements(TypeStoreVisitor typeStoreVisitor) {
        throw new RuntimeException("Not implemeneted");
    }

    public final Xobj walk(Xobj xobj, boolean z6) {
        Xobj xobj2 = this._firstChild;
        if (xobj2 != null && z6) {
            return xobj2;
        }
        for (Xobj xobj3 = this; xobj3 != xobj; xobj3 = xobj3._parent) {
            Xobj xobj4 = xobj3._nextSibling;
            if (xobj4 != null) {
                return xobj4;
            }
        }
        return null;
    }

    public final boolean contains(Xobj xobj, int i5) {
        if (this == xobj) {
            return i5 == -1 || (i5 > 0 && i5 < posAfter());
        }
        if (this._firstChild == null) {
            return false;
        }
        while (xobj != null) {
            if (xobj == this) {
                return true;
            }
            xobj = xobj._parent;
        }
        return false;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public int count_elements(QNameSet qNameSet) {
        return this._locale.count(this, null, qNameSet);
    }

    public void dump(PrintStream printStream) {
        Cur.dump(printStream, this, this);
    }

    public void dump() {
        dump(System.out);
    }

    public Object getChars(int i5, int i6) {
        int iCchRight = cchRight(i5);
        if (i6 < 0 || i6 > iCchRight) {
            i6 = iCchRight;
        }
        if (i6 == 0) {
            Locale locale = this._locale;
            locale._offSrc = 0;
            locale._cchSrc = 0;
            return null;
        }
        return getCharsHelper(i5, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public <T extends XmlObject> void find_all_element_users(QNameSet qNameSet, List<T> list) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name)) {
                list.add((XmlObject) xobj.getUser());
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser find_element_user(QNameSet qNameSet, int i5) {
        for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
            if (xobj.isElem() && qNameSet.contains(xobj._name) && (i5 = i5 - 1) < 0) {
                return xobj.getUser();
            }
        }
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public void remove_element(QNameSet qNameSet, int i5) {
        if (i5 >= 0) {
            if (isContainer()) {
                Xobj xobj = this._firstChild;
                while (xobj != null && (!xobj.isElem() || !qNameSet.contains(xobj._name) || (i5 = i5 - 1) >= 0)) {
                    xobj = xobj._nextSibling;
                }
                removeElement(xobj);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.xmlbeans.impl.values.TypeStore
    public TypeStoreUser insert_element_user(QNameSet qNameSet, QName qName, int i5) {
        if (i5 >= 0) {
            if (isContainer()) {
                Xobj xobjFindNthChildElem = this._locale.findNthChildElem(this, null, qNameSet, i5);
                if (xobjFindNthChildElem == null) {
                    if (i5 <= this._locale.count(this, null, qNameSet) + 1) {
                        return add_element_user(qName);
                    }
                    throw new IndexOutOfBoundsException();
                }
                return insertElement(qName, xobjFindNthChildElem, 0);
            }
            throw new IllegalStateException();
        }
        throw new IndexOutOfBoundsException();
    }

    public String getValueAsString() {
        return getValueAsString(1);
    }
}
