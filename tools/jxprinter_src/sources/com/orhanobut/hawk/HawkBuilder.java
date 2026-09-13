package com.orhanobut.hawk;

import android.content.Context;
import com.google.gson.Gson;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class HawkBuilder {
    private static final String STORAGE_TAG_DO_NOT_CHANGE = "Hawk2";
    private Context context;
    private Converter converter;
    private Storage cryptoStorage;
    private Encryption encryption;
    private LogInterceptor logInterceptor;
    private Parser parser;
    private Serializer serializer;

    public HawkBuilder(Context context) {
        HawkUtils.checkNull("Context", context);
        this.context = context.getApplicationContext();
    }

    public void build() {
        Hawk.build(this);
    }

    public Converter getConverter() {
        if (this.converter == null) {
            this.converter = new HawkConverter(getParser());
        }
        return this.converter;
    }

    public Encryption getEncryption() {
        if (this.encryption == null) {
            ConcealEncryption concealEncryption = new ConcealEncryption(this.context);
            this.encryption = concealEncryption;
            if (!concealEncryption.init()) {
                this.encryption = new NoEncryption();
            }
        }
        return this.encryption;
    }

    public LogInterceptor getLogInterceptor() {
        if (this.logInterceptor == null) {
            this.logInterceptor = new LogInterceptor() { // from class: com.orhanobut.hawk.HawkBuilder.1
                @Override // com.orhanobut.hawk.LogInterceptor
                public void onLog(String str) {
                }
            };
        }
        return this.logInterceptor;
    }

    public Parser getParser() {
        if (this.parser == null) {
            this.parser = new GsonParser(new Gson());
        }
        return this.parser;
    }

    public Serializer getSerializer() {
        if (this.serializer == null) {
            this.serializer = new HawkSerializer(getLogInterceptor());
        }
        return this.serializer;
    }

    public Storage getStorage() {
        if (this.cryptoStorage == null) {
            this.cryptoStorage = new SharedPreferencesStorage(this.context, STORAGE_TAG_DO_NOT_CHANGE);
        }
        return this.cryptoStorage;
    }

    public HawkBuilder setConverter(Converter converter) {
        this.converter = converter;
        return this;
    }

    public HawkBuilder setEncryption(Encryption encryption) {
        this.encryption = encryption;
        return this;
    }

    public HawkBuilder setLogInterceptor(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
        return this;
    }

    public HawkBuilder setParser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public HawkBuilder setSerializer(Serializer serializer) {
        this.serializer = serializer;
        return this;
    }

    public HawkBuilder setStorage(Storage storage) {
        this.cryptoStorage = storage;
        return this;
    }
}
