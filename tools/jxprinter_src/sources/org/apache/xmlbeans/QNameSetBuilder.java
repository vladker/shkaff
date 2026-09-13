package org.apache.xmlbeans;

import androidx.collection.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class QNameSetBuilder implements QNameSetSpecification, Serializable {
    private static final String[] EMPTY_STRINGARRAY = new String[0];
    private static final long serialVersionUID = 1;
    private Set<QName> _excludedQNames;
    private Set<QName> _includedQNames;
    private Set<String> _includedURIs;
    private boolean _inverted;

    public QNameSetBuilder() {
        this._inverted = false;
        this._includedURIs = new HashSet();
        this._excludedQNames = new HashSet();
        this._includedQNames = new HashSet();
    }

    private void addAllImpl(Set<String> set, Set<String> set2, Set<QName> set3, Set<QName> set4) {
        boolean z6 = set2 != null;
        Set<String> set5 = z6 ? set2 : set;
        Iterator<QName> it = this._excludedQNames.iterator();
        while (it.hasNext()) {
            QName next = it.next();
            if ((set5.contains(nsFromName(next)) ^ z6) && !set4.contains(next)) {
                it.remove();
            }
        }
        for (QName qName : set4) {
            if (!this._includedURIs.contains(nsFromName(qName)) && !this._includedQNames.contains(qName)) {
                this._excludedQNames.add(qName);
            }
        }
        for (QName qName2 : set3) {
            if (this._includedURIs.contains(nsFromName(qName2))) {
                this._excludedQNames.remove(qName2);
            } else {
                this._includedQNames.add(qName2);
            }
        }
        if (!z6) {
            removeAllMatchingFirstOnly(set, this._includedURIs, this._includedQNames);
            this._includedURIs.addAll(set);
            return;
        }
        removeAllMatchingNeither(set2, this._includedURIs, this._includedQNames);
        Iterator<String> it2 = this._includedURIs.iterator();
        while (it2.hasNext()) {
            if (!set2.contains(it2.next())) {
                it2.remove();
            }
        }
        for (String str : set2) {
            if (this._includedURIs.contains(str)) {
                this._includedURIs.remove(str);
            } else {
                this._includedURIs.add(str);
            }
        }
        Set<QName> set6 = this._excludedQNames;
        this._excludedQNames = this._includedQNames;
        this._includedQNames = set6;
        this._inverted = !this._inverted;
    }

    private void addImpl(QName qName) {
        if (this._includedURIs.contains(nsFromName(qName))) {
            this._excludedQNames.remove(qName);
        } else {
            this._includedQNames.add(qName);
        }
    }

    private void addNamespaceImpl(String str) {
        if (this._includedURIs.contains(str)) {
            removeAllMatchingNs(str, this._excludedQNames);
        } else {
            removeAllMatchingNs(str, this._includedQNames);
            this._includedURIs.add(str);
        }
    }

    private boolean isDisjointImpl(QNameSetSpecification qNameSetSpecification, QNameSetSpecification qNameSetSpecification2) {
        Set<String> setIncludedURIs = qNameSetSpecification.includedURIs();
        Set<String> setIncludedURIs2 = qNameSetSpecification2.includedURIs();
        if (setIncludedURIs2 != null) {
            Iterator<String> it = setIncludedURIs.iterator();
            while (it.hasNext()) {
                if (setIncludedURIs2.contains(it.next())) {
                    return false;
                }
            }
        } else {
            Set<String> setExcludedURIs = qNameSetSpecification2.excludedURIs();
            Iterator<String> it2 = setIncludedURIs.iterator();
            while (it2.hasNext()) {
                if (!setExcludedURIs.contains(it2.next())) {
                    return false;
                }
            }
        }
        Iterator<QName> it3 = qNameSetSpecification.includedQNamesInExcludedURIs().iterator();
        while (it3.hasNext()) {
            if (qNameSetSpecification2.contains(it3.next())) {
                return false;
            }
        }
        if (setIncludedURIs.size() <= 0) {
            return true;
        }
        Iterator<QName> it4 = qNameSetSpecification2.includedQNamesInExcludedURIs().iterator();
        while (it4.hasNext()) {
            if (qNameSetSpecification.contains(it4.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    private static String nsFromName(QName qName) {
        String namespaceURI = qName.getNamespaceURI();
        return namespaceURI == null ? "" : namespaceURI;
    }

    private String prettyQName(QName qName) {
        if (qName.getNamespaceURI() == null) {
            return qName.getLocalPart();
        }
        return qName.getLocalPart() + "@" + qName.getNamespaceURI();
    }

    private void removeAllImpl(Set<String> set, Set<String> set2, Set<QName> set3, Set<QName> set4) {
        boolean z6 = set2 != null;
        Set<String> set5 = z6 ? set2 : set;
        Iterator<QName> it = this._includedQNames.iterator();
        while (it.hasNext()) {
            QName next = it.next();
            if (set5.contains(nsFromName(next)) ^ z6) {
                if (!set4.contains(next)) {
                    it.remove();
                }
            } else if (set3.contains(next)) {
                it.remove();
            }
        }
        for (QName qName : set3) {
            if (this._includedURIs.contains(nsFromName(qName))) {
                this._excludedQNames.add(qName);
            }
        }
        for (QName qName2 : set4) {
            if (this._includedURIs.contains(nsFromName(qName2)) && !this._excludedQNames.contains(qName2)) {
                this._includedQNames.add(qName2);
            }
        }
        if (z6) {
            removeAllMatchingFirstOnly(this._includedURIs, set2, this._excludedQNames);
        } else {
            removeAllMatchingBoth(this._includedURIs, set, this._excludedQNames);
        }
        Iterator<String> it2 = this._includedURIs.iterator();
        while (it2.hasNext()) {
            if (set5.contains(it2.next()) ^ z6) {
                it2.remove();
            }
        }
    }

    private static void removeAllMatchingBoth(Set<String> set, Set<String> set2, Set<QName> set3) {
        Iterator<QName> it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName(it.next());
            if (set.contains(strNsFromName) && set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingFirstOnly(Set<String> set, Set<String> set2, Set<QName> set3) {
        Iterator<QName> it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName(it.next());
            if (set.contains(strNsFromName) && !set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingNeither(Set<String> set, Set<String> set2, Set<QName> set3) {
        Iterator<QName> it = set3.iterator();
        while (it.hasNext()) {
            String strNsFromName = nsFromName(it.next());
            if (!set.contains(strNsFromName) && !set2.contains(strNsFromName)) {
                it.remove();
            }
        }
    }

    private static void removeAllMatchingNs(String str, Set<QName> set) {
        Iterator<QName> it = set.iterator();
        while (it.hasNext()) {
            if (str.equals(nsFromName(it.next()))) {
                it.remove();
            }
        }
    }

    private void removeImpl(QName qName) {
        if (this._includedURIs.contains(nsFromName(qName))) {
            this._excludedQNames.add(qName);
        } else {
            this._includedQNames.remove(qName);
        }
    }

    private void removeNamespaceImpl(String str) {
        if (!this._includedURIs.contains(str)) {
            removeAllMatchingNs(str, this._includedQNames);
        } else {
            removeAllMatchingNs(str, this._excludedQNames);
            this._includedURIs.remove(str);
        }
    }

    private static String[] splitList(String str) {
        if (str.length() == 0) {
            return EMPTY_STRINGARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (true) {
            if (i5 < str.length() && isSpace(str.charAt(i5))) {
                i5++;
            } else {
                if (i5 >= str.length()) {
                    return (String[]) arrayList.toArray(EMPTY_STRINGARRAY);
                }
                int i6 = i5;
                while (i6 < str.length() && !isSpace(str.charAt(i6))) {
                    i6++;
                }
                arrayList.add(str.substring(i5, i6));
                i5 = i6;
            }
        }
    }

    public void add(QName qName) {
        if (this._inverted) {
            removeImpl(qName);
        } else {
            addImpl(qName);
        }
    }

    public void addAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            removeAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        } else {
            addAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        }
    }

    public void addNamespace(String str) {
        if (this._inverted) {
            removeNamespaceImpl(str);
        } else {
            addNamespaceImpl(str);
        }
    }

    public void clear() {
        this._inverted = false;
        this._includedURIs.clear();
        this._excludedQNames.clear();
        this._includedQNames.clear();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean contains(QName qName) {
        boolean zContains;
        if (this._includedURIs.contains(nsFromName(qName))) {
            zContains = !this._excludedQNames.contains(qName);
        } else {
            zContains = this._includedQNames.contains(qName);
        }
        return zContains ^ this._inverted;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean containsAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted || qNameSetSpecification.excludedURIs() == null) {
            return inverse().isDisjoint(qNameSetSpecification);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<QName> excludedQNamesInIncludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._includedQNames : this._excludedQNames);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<String> excludedURIs() {
        if (this._inverted) {
            return Collections.unmodifiableSet(this._includedURIs);
        }
        return null;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<QName> includedQNamesInExcludedURIs() {
        return Collections.unmodifiableSet(this._inverted ? this._excludedQNames : this._includedQNames);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<String> includedURIs() {
        if (this._inverted) {
            return null;
        }
        return this._includedURIs;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet intersect(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.restrict(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet inverse() {
        return QNameSet.forSets(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    public void invert() {
        this._inverted = !this._inverted;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isAll() {
        return this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isDisjoint(QNameSetSpecification qNameSetSpecification) {
        if (!this._inverted || qNameSetSpecification.excludedURIs() == null) {
            return this._inverted ? isDisjointImpl(qNameSetSpecification, this) : isDisjointImpl(this, qNameSetSpecification);
        }
        return false;
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isEmpty() {
        return !this._inverted && this._includedURIs.size() == 0 && this._includedQNames.size() == 0;
    }

    public void remove(QName qName) {
        if (this._inverted) {
            addImpl(qName);
        } else {
            removeImpl(qName);
        }
    }

    public void removeAll(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            addAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        } else {
            removeAllImpl(qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs());
        }
    }

    public void removeNamespace(String str) {
        if (this._inverted) {
            addNamespaceImpl(str);
        } else {
            removeNamespaceImpl(str);
        }
    }

    public void restrict(QNameSetSpecification qNameSetSpecification) {
        if (this._inverted) {
            addAllImpl(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
        } else {
            removeAllImpl(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
        }
    }

    public QNameSet toQNameSet() {
        return QNameSet.forSpecification(this);
    }

    public String toString() {
        StringBuilder sbR = a.r("QNameSetBuilder");
        sbR.append(this._inverted ? "-(" : "+(");
        Iterator<String> it = this._includedURIs.iterator();
        while (it.hasNext()) {
            sbR.append("+*@");
            sbR.append(it.next());
            sbR.append(", ");
        }
        Iterator<QName> it2 = this._excludedQNames.iterator();
        while (it2.hasNext()) {
            sbR.append(ProcessIdUtil.DEFAULT_PROCESSID);
            sbR.append(prettyQName(it2.next()));
            sbR.append(", ");
        }
        Iterator<QName> it3 = this._includedQNames.iterator();
        while (it3.hasNext()) {
            sbR.append("+");
            sbR.append(prettyQName(it3.next()));
            sbR.append(", ");
        }
        int iLastIndexOf = sbR.lastIndexOf(", ");
        if (iLastIndexOf > 0) {
            sbR.setLength(iLastIndexOf);
        }
        sbR.append(')');
        return sbR.toString();
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public QNameSet union(QNameSetSpecification qNameSetSpecification) {
        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder(this);
        qNameSetBuilder.addAll(qNameSetSpecification);
        return qNameSetBuilder.toQNameSet();
    }

    public QNameSetBuilder(QNameSetSpecification qNameSetSpecification) {
        Set<String> setIncludedURIs = qNameSetSpecification.includedURIs();
        if (setIncludedURIs != null) {
            this._inverted = false;
            this._includedURIs = new HashSet(setIncludedURIs);
            this._excludedQNames = new HashSet(qNameSetSpecification.excludedQNamesInIncludedURIs());
            this._includedQNames = new HashSet(qNameSetSpecification.includedQNamesInExcludedURIs());
            return;
        }
        this._inverted = true;
        this._includedURIs = new HashSet(qNameSetSpecification.excludedURIs());
        this._excludedQNames = new HashSet(qNameSetSpecification.includedQNamesInExcludedURIs());
        this._includedQNames = new HashSet(qNameSetSpecification.excludedQNamesInIncludedURIs());
    }

    public QNameSetBuilder(Set<String> set, Set<String> set2, Set<QName> set3, Set<QName> set4) {
        if (set2 != null && set == null) {
            this._inverted = false;
            this._includedURIs = new HashSet(set2);
            this._excludedQNames = new HashSet(set3);
            this._includedQNames = new HashSet(set4);
            return;
        }
        if (set != null && set2 == null) {
            this._inverted = true;
            this._includedURIs = new HashSet(set);
            this._excludedQNames = new HashSet(set4);
            this._includedQNames = new HashSet(set3);
            return;
        }
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    public QNameSetBuilder(String str, String str2) {
        this();
        String[] strArrSplitList = splitList(str == null ? "##any" : str);
        for (int i5 = 0; i5 < strArrSplitList.length; i5++) {
            String str3 = strArrSplitList[i5];
            if (str3.startsWith("##")) {
                if (str3.equals("##other")) {
                    if (str2 != null) {
                        QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
                        qNameSetBuilder.addNamespace(str2);
                        qNameSetBuilder.addNamespace("");
                        qNameSetBuilder.invert();
                        addAll(qNameSetBuilder);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (str3.equals("##any")) {
                    clear();
                    invert();
                } else {
                    if (strArrSplitList[i5].equals("##targetNamespace")) {
                        if (str2 == null) {
                            throw new IllegalArgumentException();
                        }
                        str3 = str2;
                    } else if (strArrSplitList[i5].equals("##local")) {
                        str3 = "";
                    }
                    addNamespace(str3);
                }
            } else {
                addNamespace(str3);
            }
        }
    }
}
