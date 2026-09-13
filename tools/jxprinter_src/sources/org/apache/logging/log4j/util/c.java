package org.apache.logging.log4j.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements BiConsumer, TriConsumer {
    @Override // org.apache.logging.log4j.util.BiConsumer
    public void accept(Object obj, Object obj2) {
        PropertiesUtil.Environment.lambda$new$0((String) obj, (String) obj2);
    }

    @Override // org.apache.logging.log4j.util.TriConsumer
    public void accept(Object obj, Object obj2, Object obj3) {
        ((StringMap) obj3).putValue((String) obj, obj2);
    }
}
