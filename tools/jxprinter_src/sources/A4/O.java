package A4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f63a = Logger.getLogger("okio.Okio");

    public static final f0 appendingSink(File file) {
        kotlin.jvm.internal.E.f(file, "<this>");
        return N.sink(new FileOutputStream(file, true));
    }

    public static final AbstractC0180x asResourceFileSystem(ClassLoader classLoader) {
        kotlin.jvm.internal.E.f(classLoader, "<this>");
        return new B4.n(classLoader, true);
    }

    public static final C0174q cipherSink(f0 f0Var, Cipher cipher) {
        kotlin.jvm.internal.E.f(f0Var, "<this>");
        kotlin.jvm.internal.E.f(cipher, "cipher");
        return new C0174q(N.buffer(f0Var), cipher);
    }

    public static final r cipherSource(h0 h0Var, Cipher cipher) {
        kotlin.jvm.internal.E.f(h0Var, "<this>");
        kotlin.jvm.internal.E.f(cipher, "cipher");
        return new r(N.buffer(h0Var), cipher);
    }

    public static final D hashingSink(f0 f0Var, Mac mac) {
        kotlin.jvm.internal.E.f(f0Var, "<this>");
        kotlin.jvm.internal.E.f(mac, "mac");
        return new D(f0Var, mac);
    }

    public static final F hashingSource(h0 h0Var, Mac mac) {
        kotlin.jvm.internal.E.f(h0Var, "<this>");
        kotlin.jvm.internal.E.f(mac, "mac");
        return new F(h0Var, mac);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        kotlin.jvm.internal.E.f(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? X3.b0.contains((CharSequence) message, (CharSequence) "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static final AbstractC0180x openZip(AbstractC0180x abstractC0180x, V zipPath) {
        kotlin.jvm.internal.E.f(abstractC0180x, "<this>");
        kotlin.jvm.internal.E.f(zipPath, "zipPath");
        return B4.t.openZip$default(zipPath, abstractC0180x, null, 4, null);
    }

    public static final f0 sink(File file) {
        kotlin.jvm.internal.E.f(file, "<this>");
        return sink$default(file, false, 1, null);
    }

    public static /* synthetic */ f0 sink$default(File file, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z6 = false;
        }
        return N.sink(file, z6);
    }

    public static final h0 source(InputStream inputStream) {
        kotlin.jvm.internal.E.f(inputStream, "<this>");
        return new H(inputStream, new k0());
    }

    public static final D hashingSink(f0 f0Var, MessageDigest digest) {
        kotlin.jvm.internal.E.f(f0Var, "<this>");
        kotlin.jvm.internal.E.f(digest, "digest");
        return new D(f0Var, digest);
    }

    public static final F hashingSource(h0 h0Var, MessageDigest digest) {
        kotlin.jvm.internal.E.f(h0Var, "<this>");
        kotlin.jvm.internal.E.f(digest, "digest");
        return new F(h0Var, digest);
    }

    public static final f0 sink(OutputStream outputStream) {
        kotlin.jvm.internal.E.f(outputStream, "<this>");
        return new T(outputStream, new k0());
    }

    public static final h0 source(Socket socket) throws IOException {
        kotlin.jvm.internal.E.f(socket, "<this>");
        g0 g0Var = new g0(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.E.e(inputStream, "getInputStream()");
        return g0Var.source(new H(inputStream, g0Var));
    }

    public static final f0 sink(Socket socket) throws IOException {
        kotlin.jvm.internal.E.f(socket, "<this>");
        g0 g0Var = new g0(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.E.e(outputStream, "getOutputStream()");
        return g0Var.sink(new T(outputStream, g0Var));
    }

    public static final h0 source(File file) {
        kotlin.jvm.internal.E.f(file, "<this>");
        return new H(new FileInputStream(file), k0.NONE);
    }

    public static final f0 sink(File file, boolean z6) {
        kotlin.jvm.internal.E.f(file, "<this>");
        return N.sink(new FileOutputStream(file, z6));
    }

    public static final h0 source(Path path, OpenOption... options) throws IOException {
        kotlin.jvm.internal.E.f(path, "<this>");
        kotlin.jvm.internal.E.f(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.E.e(inputStreamNewInputStream, "newInputStream(this, *options)");
        return N.source(inputStreamNewInputStream);
    }

    public static final f0 sink(Path path, OpenOption... options) throws IOException {
        kotlin.jvm.internal.E.f(path, "<this>");
        kotlin.jvm.internal.E.f(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(options, options.length));
        kotlin.jvm.internal.E.e(outputStreamNewOutputStream, "newOutputStream(this, *options)");
        return N.sink(outputStreamNewOutputStream);
    }
}
