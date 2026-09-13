package org.apache.xmlbeans;

import E4.a;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class QNameSet implements QNameSetSpecification, Serializable {
    public static final QNameSet ALL;
    public static final QNameSet EMPTY;
    public static final QNameSet LOCAL;
    public static final QNameSet NONLOCAL;
    private static final long serialVersionUID = 1;
    private final Set<QName> _excludedQNames;
    private final Set<QName> _includedQNames;
    private final Set<String> _includedURIs;
    private final boolean _inverted;

    static {
        Set set = Collections.EMPTY_SET;
        EMPTY = new QNameSet(null, set, set, set);
        ALL = new QNameSet(set, null, set, set);
        LOCAL = new QNameSet(null, Collections.singleton(""), set, set);
        NONLOCAL = new QNameSet(Collections.singleton(""), null, set, set);
    }

    private QNameSet(Set<String> set, Set<String> set2, Set<QName> set3, Set<QName> set4) {
        if (set2 != null && set == null) {
            this._inverted = false;
            this._includedURIs = set2;
            this._excludedQNames = set3;
            this._includedQNames = set4;
            return;
        }
        if (set == null || set2 != null) {
            throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
        }
        this._inverted = true;
        this._includedURIs = set;
        this._excludedQNames = set4;
        this._includedQNames = set3;
    }

    public static QNameSet forArray(QName[] qNameArr) {
        if (qNameArr == null) {
            throw new IllegalArgumentException("includedQNames cannot be null");
        }
        Set set = Collections.EMPTY_SET;
        return new QNameSet(null, set, set, new HashSet(Arrays.asList(qNameArr)));
    }

    public static QNameSet forSets(Set<String> set, Set<String> set2, Set<QName> set3, Set<QName> set4) {
        if ((set != null) == (set2 != null)) {
            throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
        }
        if (set == null && set2.isEmpty() && set4.isEmpty()) {
            return EMPTY;
        }
        if (set2 == null && set.isEmpty() && set3.isEmpty()) {
            return ALL;
        }
        if (set == null && set2.size() == 1 && set2.contains("") && set4.isEmpty() && set3.isEmpty()) {
            return LOCAL;
        }
        return (set2 == null && set.size() == 1 && set.contains("") && set3.isEmpty() && set4.isEmpty()) ? NONLOCAL : new QNameSet(minSetCopy(set), minSetCopy(set2), minSetCopy(set3), minSetCopy(set4));
    }

    public static QNameSet forSpecification(QNameSetSpecification qNameSetSpecification) {
        return qNameSetSpecification instanceof QNameSet ? (QNameSet) qNameSetSpecification : forSets(qNameSetSpecification.excludedURIs(), qNameSetSpecification.includedURIs(), qNameSetSpecification.excludedQNamesInIncludedURIs(), qNameSetSpecification.includedQNamesInExcludedURIs());
    }

    public static QNameSet forWildcardNamespaceString(String str, String str2) {
        return forSpecification(new QNameSetBuilder(str, str2));
    }

    private boolean isDisjointImpl(QNameSetSpecification qNameSetSpecification, QNameSetSpecification qNameSetSpecification2) {
        Set<String> setIncludedURIs = qNameSetSpecification.includedURIs();
        Set<String> setIncludedURIs2 = qNameSetSpecification2.includedURIs();
        if (setIncludedURIs2 != null) {
            if (!Collections.disjoint(setIncludedURIs, setIncludedURIs2)) {
                return false;
            }
        } else if (!qNameSetSpecification2.excludedURIs().containsAll(setIncludedURIs)) {
            return false;
        }
        return (qNameSetSpecification.includedQNamesInExcludedURIs().stream().anyMatch(new a(qNameSetSpecification2, 8)) || qNameSetSpecification2.includedQNamesInExcludedURIs().stream().anyMatch(new a(qNameSetSpecification, 8))) ? false : true;
    }

    private static <T> Set<T> minSetCopy(Set<T> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        return set.size() == 1 ? Collections.singleton(set.iterator().next()) : new HashSet(set);
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

    public static QNameSet singleton(QName qName) {
        Set set = Collections.EMPTY_SET;
        return new QNameSet(null, set, set, Collections.singleton(qName));
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
        QNameSet qNameSet = EMPTY;
        if (this == qNameSet) {
            return ALL;
        }
        if (this == ALL) {
            return qNameSet;
        }
        QNameSet qNameSet2 = LOCAL;
        if (this == qNameSet2) {
            return NONLOCAL;
        }
        return this == NONLOCAL ? qNameSet2 : new QNameSet(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean isAll() {
        return this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
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
        return !this._inverted && this._includedURIs.isEmpty() && this._includedQNames.isEmpty();
    }

    public String toString() {
        StringBuilder sbR = androidx.collection.a.r("QNameSet");
        sbR.append(this._inverted ? "-(" : "+(");
        Iterator<String> it = this._includedURIs.iterator();
        while (it.hasNext()) {
            androidx.collection.a.x(sbR, "+*@", it.next(), ", ");
        }
        for (QName qName : this._excludedQNames) {
            sbR.append(ProcessIdUtil.DEFAULT_PROCESSID);
            sbR.append(prettyQName(qName));
            sbR.append(", ");
        }
        for (QName qName2 : this._includedQNames) {
            sbR.append("+");
            sbR.append(prettyQName(qName2));
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
}
