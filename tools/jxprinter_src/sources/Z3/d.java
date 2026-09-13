package Z3;

import A3.AbstractC0157z;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final c getUuid(ByteBuffer byteBuffer) {
        E.f(byteBuffer, "<this>");
        if (byteBuffer.position() + 15 >= byteBuffer.limit()) {
            throw new BufferUnderflowException();
        }
        long jReverseBytes = byteBuffer.getLong();
        long jReverseBytes2 = byteBuffer.getLong();
        if (E.a(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
            jReverseBytes = Long.reverseBytes(jReverseBytes);
            jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
        }
        return c.Companion.fromLongs(jReverseBytes, jReverseBytes2);
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, int i5, c uuid) {
        ByteBuffer byteBufferPutLong;
        E.f(byteBuffer, "<this>");
        E.f(uuid, "uuid");
        long j6 = uuid.f899a;
        long j7 = uuid.b;
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "Negative index: "));
        }
        if (i5 + 15 >= byteBuffer.limit()) {
            StringBuilder sbT = AbstractC0157z.t(i5, "Not enough capacity to write a uuid at index: ", ", with limit: ");
            sbT.append(byteBuffer.limit());
            sbT.append(Chars.SPACE);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        if (E.a(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
            byteBuffer.putLong(i5, j6);
            byteBufferPutLong = byteBuffer.putLong(i5 + 8, j7);
        } else {
            byteBuffer.putLong(i5, Long.reverseBytes(j6));
            byteBufferPutLong = byteBuffer.putLong(i5 + 8, Long.reverseBytes(j7));
        }
        E.e(byteBufferPutLong, "toLongs(...)");
        return byteBufferPutLong;
    }

    public static final c secureRandomUuid() {
        byte[] bArr = new byte[16];
        a.INSTANCE.getInstance().nextBytes(bArr);
        return e.uuidFromRandomBytes(bArr);
    }

    public static final Object serializedUuid(c uuid) {
        E.f(uuid, "uuid");
        long j6 = uuid.f899a;
        long j7 = uuid.b;
        g gVar = new g();
        gVar.f900a = j6;
        gVar.b = j7;
        return gVar;
    }

    public static final UUID toJavaUuid(c cVar) {
        E.f(cVar, "<this>");
        return new UUID(cVar.f899a, cVar.b);
    }

    public static final c toKotlinUuid(UUID uuid) {
        E.f(uuid, "<this>");
        return c.Companion.fromLongs(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final c getUuid(ByteBuffer byteBuffer, int i5) {
        E.f(byteBuffer, "<this>");
        if (i5 >= 0) {
            if (i5 + 15 < byteBuffer.limit()) {
                long jReverseBytes = byteBuffer.getLong(i5);
                long jReverseBytes2 = byteBuffer.getLong(i5 + 8);
                if (E.a(byteBuffer.order(), ByteOrder.LITTLE_ENDIAN)) {
                    jReverseBytes = Long.reverseBytes(jReverseBytes);
                    jReverseBytes2 = Long.reverseBytes(jReverseBytes2);
                }
                return c.Companion.fromLongs(jReverseBytes, jReverseBytes2);
            }
            StringBuilder sbT = AbstractC0157z.t(i5, "Not enough bytes to read a uuid at index: ", ", with limit: ");
            sbT.append(byteBuffer.limit());
            sbT.append(Chars.SPACE);
            throw new IndexOutOfBoundsException(sbT.toString());
        }
        throw new IndexOutOfBoundsException(AbstractC0157z.k(i5, "Negative index: "));
    }

    public static final ByteBuffer putUuid(ByteBuffer byteBuffer, c uuid) {
        ByteBuffer byteBufferPutLong;
        E.f(byteBuffer, "<this>");
        E.f(uuid, "uuid");
        long j6 = uuid.f899a;
        long j7 = uuid.b;
        if (byteBuffer.position() + 15 < byteBuffer.limit()) {
            if (E.a(byteBuffer.order(), ByteOrder.BIG_ENDIAN)) {
                byteBuffer.putLong(j6);
                byteBufferPutLong = byteBuffer.putLong(j7);
            } else {
                byteBuffer.putLong(Long.reverseBytes(j6));
                byteBufferPutLong = byteBuffer.putLong(Long.reverseBytes(j7));
            }
            E.e(byteBufferPutLong, "toLongs(...)");
            return byteBufferPutLong;
        }
        throw new BufferOverflowException();
    }
}
