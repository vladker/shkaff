package com.google.gson;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l6) {
            return l6 == null ? JsonNull.INSTANCE : new JsonPrimitive(l6);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l6) {
            return l6 == null ? JsonNull.INSTANCE : new JsonPrimitive(l6.toString());
        }
    };

    public abstract JsonElement serialize(Long l6);
}
