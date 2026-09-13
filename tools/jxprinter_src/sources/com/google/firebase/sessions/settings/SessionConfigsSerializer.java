package com.google.firebase.sessions.settings;

import E3.g;
import L3.c;
import X3.W;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p089p4.AbstractC1519d;
import p089p4.C1518c;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionConfigsSerializer implements Serializer<SessionConfigs> {
    public static final SessionConfigsSerializer INSTANCE = new SessionConfigsSerializer();
    private static final SessionConfigs defaultValue = new SessionConfigs(null, null, null, null, null);

    private SessionConfigsSerializer() {
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, g<? super SessionConfigs> gVar) throws CorruptionException {
        try {
            C1518c c1518c = AbstractC1519d.Default;
            String strDecodeToString = W.decodeToString(c.readBytes(inputStream));
            c1518c.getSerializersModule();
            return (SessionConfigs) c1518c.decodeFromString(SessionConfigs.Companion.serializer(), strDecodeToString);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session configs", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public /* bridge */ /* synthetic */ Object writeTo(SessionConfigs sessionConfigs, OutputStream outputStream, g gVar) {
        return writeTo2(sessionConfigs, outputStream, (g<? super Q>) gVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    public SessionConfigs getDefaultValue() {
        return defaultValue;
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(SessionConfigs sessionConfigs, OutputStream outputStream, g<? super Q> gVar) throws IOException {
        outputStream.write(W.encodeToByteArray(AbstractC1519d.Default.encodeToString(SessionConfigs.Companion.serializer(), sessionConfigs)));
        return Q.INSTANCE;
    }
}
