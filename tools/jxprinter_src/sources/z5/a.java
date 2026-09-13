package z5;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.AbstractC1620s;
import retrofit2.InterfaceC1621t;
import retrofit2.u0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends AbstractC1620s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f9137a;

    public a(Gson gson) {
        this.f9137a = gson;
    }

    @Override // retrofit2.AbstractC1620s
    public final InterfaceC1621t requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, u0 u0Var) {
        TypeToken<?> typeToken = TypeToken.get(type);
        Gson gson = this.f9137a;
        return new b(gson, gson.getAdapter(typeToken));
    }

    @Override // retrofit2.AbstractC1620s
    public final InterfaceC1621t responseBodyConverter(Type type, Annotation[] annotationArr, u0 u0Var) {
        TypeToken<?> typeToken = TypeToken.get(type);
        Gson gson = this.f9137a;
        return new c(gson, gson.getAdapter(typeToken));
    }
}
