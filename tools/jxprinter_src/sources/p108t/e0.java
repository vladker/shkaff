package p108t;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends StandardMessageCodec {
    public static final e0 INSTANCE = new e0();

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b, ByteBuffer buffer) {
        E.f(buffer, "buffer");
        if (b == -127) {
            Integer num = (Integer) readValue(buffer);
            if (num != null) {
                return Z.Companion.ofRaw(num.intValue());
            }
            return null;
        }
        if (b == -126) {
            Object value = readValue(buffer);
            List<? extends Object> list = value instanceof List ? (List) value : null;
            if (list != null) {
                return C1770b.Companion.fromList(list);
            }
            return null;
        }
        if (b == -125) {
            Object value2 = readValue(buffer);
            List<? extends Object> list2 = value2 instanceof List ? (List) value2 : null;
            if (list2 != null) {
                return b0.Companion.fromList(list2);
            }
            return null;
        }
        if (b == -124) {
            Object value3 = readValue(buffer);
            List<? extends Object> list3 = value3 instanceof List ? (List) value3 : null;
            if (list3 != null) {
                return d0.Companion.fromList(list3);
            }
            return null;
        }
        if (b == -123) {
            Object value4 = readValue(buffer);
            List<? extends Object> list4 = value4 instanceof List ? (List) value4 : null;
            if (list4 != null) {
                return C1772d.Companion.fromList(list4);
            }
            return null;
        }
        if (b != -122) {
            return super.readValueOfType(b, buffer);
        }
        Object value5 = readValue(buffer);
        List<? extends Object> list5 = value5 instanceof List ? (List) value5 : null;
        if (list5 != null) {
            return C1775g.Companion.fromList(list5);
        }
        return null;
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        E.f(stream, "stream");
        if (obj instanceof Z) {
            stream.write(129);
            writeValue(stream, Integer.valueOf(((Z) obj).f8526a));
            return;
        }
        if (obj instanceof C1770b) {
            stream.write(130);
            writeValue(stream, ((C1770b) obj).toList());
            return;
        }
        if (obj instanceof b0) {
            stream.write(131);
            writeValue(stream, ((b0) obj).toList());
            return;
        }
        if (obj instanceof d0) {
            stream.write(132);
            writeValue(stream, ((d0) obj).toList());
        } else if (obj instanceof C1772d) {
            stream.write(133);
            writeValue(stream, ((C1772d) obj).toList());
        } else if (!(obj instanceof C1775g)) {
            super.writeValue(stream, obj);
        } else {
            stream.write(134);
            writeValue(stream, ((C1775g) obj).toList());
        }
    }
}
