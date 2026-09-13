package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class AndroidWebkitLibraryPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b, ByteBuffer buffer) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        if (b == -127) {
            Long l6 = (Long) readValue(buffer);
            if (l6 == null) {
                return null;
            }
            return FileChooserMode.Companion.ofRaw((int) l6.longValue());
        }
        if (b == -126) {
            Long l7 = (Long) readValue(buffer);
            if (l7 == null) {
                return null;
            }
            return ConsoleMessageLevel.Companion.ofRaw((int) l7.longValue());
        }
        if (b == -125) {
            Long l8 = (Long) readValue(buffer);
            if (l8 == null) {
                return null;
            }
            return OverScrollMode.Companion.ofRaw((int) l8.longValue());
        }
        if (b == -124) {
            Long l9 = (Long) readValue(buffer);
            if (l9 == null) {
                return null;
            }
            return SslErrorType.Companion.ofRaw((int) l9.longValue());
        }
        if (b != -123) {
            return super.readValueOfType(b, buffer);
        }
        Long l10 = (Long) readValue(buffer);
        if (l10 == null) {
            return null;
        }
        return MixedContentMode.Companion.ofRaw((int) l10.longValue());
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.E.f(stream, "stream");
        if (obj instanceof FileChooserMode) {
            stream.write(129);
            writeValue(stream, Integer.valueOf(((FileChooserMode) obj).getRaw()));
            return;
        }
        if (obj instanceof ConsoleMessageLevel) {
            stream.write(130);
            writeValue(stream, Integer.valueOf(((ConsoleMessageLevel) obj).getRaw()));
            return;
        }
        if (obj instanceof OverScrollMode) {
            stream.write(131);
            writeValue(stream, Integer.valueOf(((OverScrollMode) obj).getRaw()));
        } else if (obj instanceof SslErrorType) {
            stream.write(132);
            writeValue(stream, Integer.valueOf(((SslErrorType) obj).getRaw()));
        } else if (!(obj instanceof MixedContentMode)) {
            super.writeValue(stream, obj);
        } else {
            stream.write(133);
            writeValue(stream, Integer.valueOf(((MixedContentMode) obj).getRaw()));
        }
    }
}
