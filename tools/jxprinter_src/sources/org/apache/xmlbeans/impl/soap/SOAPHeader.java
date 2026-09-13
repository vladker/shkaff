package org.apache.xmlbeans.impl.soap;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SOAPHeader extends SOAPElement {
    SOAPHeaderElement addHeaderElement(Name name);

    Iterator examineAllHeaderElements();

    Iterator examineHeaderElements(String str);

    Iterator examineMustUnderstandHeaderElements(String str);

    Iterator extractAllHeaderElements();

    Iterator extractHeaderElements(String str);
}
