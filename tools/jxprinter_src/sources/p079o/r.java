package p079o;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;
import p050j.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f6419a = new r();

    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws IOException {
        try {
            if (obj == null) {
                g6.f6325j.n();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringBuilder sb = new StringBuilder();
            try {
                char[] cArr = new char[2048];
                while (true) {
                    int i6 = characterStream.read(cArr, 0, 2048);
                    if (i6 < 0) {
                        String string = sb.toString();
                        characterStream.close();
                        g6.i(string);
                        return;
                    }
                    sb.append(cArr, 0, i6);
                }
            } catch (Exception e) {
                throw new d("read string from reader error", e);
            }
        } catch (SQLException e6) {
            throw new IOException("write clob error", e6);
        }
    }
}
