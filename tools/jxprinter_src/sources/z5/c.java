package z5;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import okhttp3.W;
import retrofit2.InterfaceC1621t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class c implements InterfaceC1621t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f9139a;
    public final TypeAdapter b;

    public c(Gson gson, TypeAdapter typeAdapter) {
        this.f9139a = gson;
        this.b = typeAdapter;
    }

    @Override // retrofit2.InterfaceC1621t
    public Object convert(W w6) {
        JsonReader jsonReaderNewJsonReader = this.f9139a.newJsonReader(w6.b());
        try {
            Object obj = this.b.read(jsonReaderNewJsonReader);
            if (jsonReaderNewJsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            w6.close();
            return obj;
        } catch (Throwable th) {
            w6.close();
            throw th;
        }
    }
}
