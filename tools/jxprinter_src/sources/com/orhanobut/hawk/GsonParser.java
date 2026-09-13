package com.orhanobut.hawk;

import android.text.TextUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonParser implements Parser {
    private final Gson gson;

    public GsonParser(Gson gson) {
        this.gson = gson;
    }

    @Override // com.orhanobut.hawk.Parser
    public <T> T fromJson(String str, Type type) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (T) this.gson.fromJson(str, type);
    }

    @Override // com.orhanobut.hawk.Parser
    public String toJson(Object obj) {
        return this.gson.toJson(obj);
    }
}
