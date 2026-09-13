package com.google.firebase.sessions;

import E3.g;
import X3.W;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;
import p089p4.AbstractC1519d;
import p089p4.C1518c;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionDataSerializer implements Serializer<SessionData> {
    private final SessionGenerator sessionGenerator;

    public SessionDataSerializer(SessionGenerator sessionGenerator) {
        E.f(sessionGenerator, "sessionGenerator");
        this.sessionGenerator = sessionGenerator;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, g<? super SessionData> gVar) throws CorruptionException {
        try {
            C1518c c1518c = AbstractC1519d.Default;
            String strDecodeToString = W.decodeToString(L3.c.readBytes(inputStream));
            c1518c.getSerializersModule();
            return (SessionData) c1518c.decodeFromString(SessionData.Companion.serializer(), strDecodeToString);
        } catch (Exception e) {
            throw new CorruptionException("Cannot parse session data", e);
        }
    }

    @Override // androidx.datastore.core.Serializer
    public /* bridge */ /* synthetic */ Object writeTo(SessionData sessionData, OutputStream outputStream, g gVar) {
        return writeTo2(sessionData, outputStream, (g<? super Q>) gVar);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    public SessionData getDefaultValue() {
        return new SessionData(this.sessionGenerator.generateNewSession(null), (Time) null, (Map) null, 6, (AbstractC1107v) null);
    }

    /* JADX INFO: renamed from: writeTo, reason: avoid collision after fix types in other method */
    public Object writeTo2(SessionData sessionData, OutputStream outputStream, g<? super Q> gVar) throws IOException {
        outputStream.write(W.encodeToByteArray(AbstractC1519d.Default.encodeToString(SessionData.Companion.serializer(), sessionData)));
        return Q.INSTANCE;
    }
}
