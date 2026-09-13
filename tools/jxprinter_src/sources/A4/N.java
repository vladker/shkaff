package A4;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes4.dex */
public abstract class N {
    public static final f0 appendingSink(File file) {
        return O.appendingSink(file);
    }

    public static final AbstractC0180x asResourceFileSystem(ClassLoader classLoader) {
        return O.asResourceFileSystem(classLoader);
    }

    public static final f0 blackhole() {
        return P.blackhole();
    }

    public static final InterfaceC0170m buffer(f0 f0Var) {
        return P.buffer(f0Var);
    }

    public static final C0174q cipherSink(f0 f0Var, Cipher cipher) {
        return O.cipherSink(f0Var, cipher);
    }

    public static final r cipherSource(h0 h0Var, Cipher cipher) {
        return O.cipherSource(h0Var, cipher);
    }

    public static final D hashingSink(f0 f0Var, MessageDigest messageDigest) {
        return O.hashingSink(f0Var, messageDigest);
    }

    public static final F hashingSource(h0 h0Var, MessageDigest messageDigest) {
        return O.hashingSource(h0Var, messageDigest);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return O.isAndroidGetsocknameError(assertionError);
    }

    public static final AbstractC0180x openZip(AbstractC0180x abstractC0180x, V v6) {
        return O.openZip(abstractC0180x, v6);
    }

    public static final f0 sink(File file) {
        return O.sink(file);
    }

    public static final h0 source(File file) {
        return O.source(file);
    }

    public static final <T extends Closeable, R> R use(T t6, O3.l lVar) {
        return (R) P.use(t6, lVar);
    }

    public static final InterfaceC0171n buffer(h0 h0Var) {
        return P.buffer(h0Var);
    }

    public static final D hashingSink(f0 f0Var, Mac mac) {
        return O.hashingSink(f0Var, mac);
    }

    public static final F hashingSource(h0 h0Var, Mac mac) {
        return O.hashingSource(h0Var, mac);
    }

    public static final f0 sink(File file, boolean z6) {
        return O.sink(file, z6);
    }

    public static final h0 source(InputStream inputStream) {
        return O.source(inputStream);
    }

    public static final f0 sink(OutputStream outputStream) {
        return O.sink(outputStream);
    }

    public static final h0 source(Socket socket) {
        return O.source(socket);
    }

    public static final f0 sink(Socket socket) {
        return O.sink(socket);
    }

    public static final h0 source(Path path, OpenOption... openOptionArr) {
        return O.source(path, openOptionArr);
    }

    public static final f0 sink(Path path, OpenOption... openOptionArr) {
        return O.sink(path, openOptionArr);
    }
}
