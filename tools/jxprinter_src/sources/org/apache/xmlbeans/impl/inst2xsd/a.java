package org.apache.xmlbeans.impl.inst2xsd;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.common.PrefixResolver;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements PrefixResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XmlCursor f7364a;

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public final String getNamespaceForPrefix(String str) {
        return this.f7364a.namespaceForPrefix(str);
    }
}
