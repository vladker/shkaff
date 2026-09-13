package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface QNameFactory {
    QName getQName(String str, String str2);

    QName getQName(String str, String str2, String str3);

    QName getQName(char[] cArr, int i5, int i6, char[] cArr2, int i7, int i8);

    QName getQName(char[] cArr, int i5, int i6, char[] cArr2, int i7, int i8, char[] cArr3, int i9, int i10);
}
