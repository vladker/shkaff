package z5;

import A4.C0169l;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.B;
import okhttp3.Q;
import retrofit2.InterfaceC1621t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements InterfaceC1621t {
    public static final B c = B.a("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f9138a;
    public final TypeAdapter b;

    public b(Gson gson, TypeAdapter typeAdapter) {
        this.f9138a = gson;
        this.b = typeAdapter;
    }

    @Override // retrofit2.InterfaceC1621t
    public Q convert(Object obj) throws IOException {
        C0169l c0169l = new C0169l();
        JsonWriter jsonWriterNewJsonWriter = this.f9138a.newJsonWriter(new OutputStreamWriter(c0169l.outputStream(), StandardCharsets.UTF_8));
        this.b.write(jsonWriterNewJsonWriter, obj);
        jsonWriterNewJsonWriter.close();
        return Q.create(c, c0169l.readByteString());
    }
}
