package org.apache.xmlbeans.soap;

import H4.b;
import androidx.collection.a;
import androidx.webkit.ProxyConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class SOAPArrayType {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private int[] _dimensions;
    private int[] _ranks;
    private QName _type;

    public SOAPArrayType(String str, PrefixResolver prefixResolver) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            throw new XmlValueOutOfRangeException();
        }
        String strCollapse = XmlWhitespace.collapse(str.substring(0, iIndexOf), 3);
        int iIndexOf2 = strCollapse.indexOf(58);
        String namespaceForPrefix = prefixResolver.getNamespaceForPrefix(iIndexOf2 >= 0 ? strCollapse.substring(0, iIndexOf2) : "");
        if (namespaceForPrefix == null) {
            throw new XmlValueOutOfRangeException();
        }
        this._type = QNameHelper.forLNS(strCollapse.substring(iIndexOf2 + 1), namespaceForPrefix);
        initDimensions(str, iIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int collapseDimString(String str) {
        String strCollapse = XmlWhitespace.collapse(str, 3);
        try {
            if (!ProxyConfig.MATCH_ALL_SCHEMES.equals(strCollapse) && !strCollapse.isEmpty()) {
                return Integer.parseInt(strCollapse);
            }
            return -1;
        } catch (Exception unused) {
            throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
        }
    }

    private void initDimensions(String str, int i5) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = -1;
        while (i5 >= 0) {
            iIndexOf = str.indexOf(93, i5);
            if (iIndexOf < 0) {
                throw new XmlValueOutOfRangeException();
            }
            arrayList.add(str.substring(i5 + 1, iIndexOf));
            i5 = str.indexOf(91, iIndexOf);
        }
        if (!XmlWhitespace.isAllSpace(str.substring(iIndexOf + 1))) {
            throw new XmlValueOutOfRangeException();
        }
        this._ranks = new int[arrayList.size() - 1];
        for (int i6 = 0; i6 < this._ranks.length; i6++) {
            String str2 = (String) arrayList.get(i6);
            int i7 = 0;
            for (int i8 = 0; i8 < str2.length(); i8++) {
                char cCharAt = str2.charAt(i8);
                if (cCharAt == ',') {
                    i7++;
                } else if (!XmlWhitespace.isSpace(cCharAt)) {
                    throw new XmlValueOutOfRangeException();
                }
            }
            this._ranks[i6] = i7 + 1;
        }
        this._dimensions = internalParseCommaIntString((String) a.e(arrayList, 1));
    }

    private static int[] internalParseCommaIntString(String str) {
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i5);
            if (iIndexOf < 0) {
                arrayList.add(str.substring(i5));
                return arrayList.stream().mapToInt(new O4.a(0)).toArray();
            }
            arrayList.add(str.substring(i5, iIndexOf));
            i5 = iIndexOf + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soap11DimensionString$0(int i5) {
        return i5 >= 0 ? Integer.toString(i5) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$soap12DimensionString$1(int i5) {
        return i5 >= 0 ? Integer.toString(i5) : "";
    }

    public static SOAPArrayType newSoap12Array(QName qName, String str) {
        String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
        int[] iArr = new int[strArrSplit.length];
        for (int i5 = 0; i5 < strArrSplit.length; i5++) {
            String str2 = strArrSplit[i5];
            if (i5 == 0 && str2.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                iArr[i5] = -1;
            } else {
                try {
                    iArr[i5] = Integer.parseInt(strArrSplit[i5]);
                } catch (Exception unused) {
                    throw new XmlValueOutOfRangeException();
                }
            }
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._ranks = EMPTY_INT_ARRAY;
        sOAPArrayType._type = qName;
        sOAPArrayType._dimensions = iArr;
        return sOAPArrayType;
    }

    public boolean containsNestedArrays() {
        return this._ranks.length > 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SOAPArrayType)) {
            return false;
        }
        SOAPArrayType sOAPArrayType = (SOAPArrayType) obj;
        return this._type.equals(sOAPArrayType._type) && Arrays.equals(this._ranks, sOAPArrayType._ranks) && Arrays.equals(this._dimensions, sOAPArrayType._dimensions);
    }

    public int[] getDimensions() {
        int[] iArr = this._dimensions;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public QName getQName() {
        return this._type;
    }

    public int[] getRanks() {
        int[] iArr = this._ranks;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    public int hashCode() {
        int iHashCode = this._type.hashCode();
        int[] iArr = this._dimensions;
        return iHashCode + iArr.length + this._ranks.length + (iArr.length != 0 ? iArr[0] : 0);
    }

    public boolean isSameRankAs(SOAPArrayType sOAPArrayType) {
        return Arrays.equals(this._ranks, sOAPArrayType._ranks) && this._dimensions.length == sOAPArrayType._dimensions.length;
    }

    public SOAPArrayType nestedArrayType() {
        if (!containsNestedArrays()) {
            throw new IllegalStateException();
        }
        SOAPArrayType sOAPArrayType = new SOAPArrayType();
        sOAPArrayType._type = this._type;
        int[] iArr = new int[this._ranks.length - 1];
        sOAPArrayType._ranks = iArr;
        System.arraycopy(this._ranks, 0, iArr, 0, iArr.length);
        int[] iArr2 = this._ranks;
        int[] iArr3 = new int[iArr2[iArr2.length - 1]];
        sOAPArrayType._dimensions = iArr3;
        Arrays.fill(iArr3, -1);
        return sOAPArrayType;
    }

    public String soap11DimensionString() {
        return soap11DimensionString(this._dimensions);
    }

    public String soap12DimensionString(int[] iArr) {
        return (String) IntStream.of(iArr).mapToObj(new b(6)).collect(Collectors.joining(" "));
    }

    public String soap11DimensionString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i5 : this._ranks) {
            sb.append('[');
            for (int i6 = 1; i6 < i5; i6++) {
                sb.append(',');
            }
            sb.append(']');
        }
        sb.append((String) IntStream.of(iArr).mapToObj(new b(5)).collect(Collectors.joining(",", "[", "]")));
        return sb.toString();
    }

    public SOAPArrayType(QName qName, String str) {
        int iIndexOf = str.indexOf(91);
        if (iIndexOf < 0) {
            this._type = qName;
            this._ranks = EMPTY_INT_ARRAY;
            String[] strArrSplit = XmlWhitespace.collapse(str, 3).split(" ");
            for (int i5 = 0; i5 < strArrSplit.length; i5++) {
                if (strArrSplit[i5].equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                    this._dimensions[i5] = -1;
                } else {
                    try {
                        this._dimensions[i5] = Integer.parseInt(strArrSplit[i5]);
                    } catch (Exception unused) {
                        throw new XmlValueOutOfRangeException();
                    }
                }
            }
            return;
        }
        this._type = qName;
        initDimensions(str, iIndexOf);
    }

    public SOAPArrayType(SOAPArrayType sOAPArrayType, int[] iArr) {
        this._type = sOAPArrayType._type;
        int[] iArr2 = new int[sOAPArrayType._ranks.length + 1];
        this._ranks = iArr2;
        int[] iArr3 = sOAPArrayType._ranks;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        int[] iArr4 = this._ranks;
        iArr4[iArr4.length - 1] = sOAPArrayType._dimensions.length;
        int[] iArr5 = new int[iArr.length];
        this._dimensions = iArr5;
        System.arraycopy(iArr, 0, iArr5, 0, iArr.length);
    }

    private SOAPArrayType() {
    }
}
