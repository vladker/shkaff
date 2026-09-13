package A4;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class g0 extends C0164g {
    private final Socket socket;

    public g0(Socket socket) {
        kotlin.jvm.internal.E.f(socket, "socket");
        this.socket = socket;
    }

    @Override // A4.C0164g
    public final void l() {
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (!N.isAndroidGetsocknameError(e)) {
                throw e;
            }
            O.f63a.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e);
        } catch (Exception e6) {
            O.f63a.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e6);
        }
    }

    @Override // A4.C0164g
    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
