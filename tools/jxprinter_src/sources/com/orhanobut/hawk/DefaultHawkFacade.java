package com.orhanobut.hawk;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultHawkFacade implements HawkFacade {
    private final Converter converter;
    private final Encryption encryption;
    private final LogInterceptor logInterceptor;
    private final Serializer serializer;
    private final Storage storage;

    public DefaultHawkFacade(HawkBuilder hawkBuilder) {
        Encryption encryption = hawkBuilder.getEncryption();
        this.encryption = encryption;
        this.storage = hawkBuilder.getStorage();
        this.converter = hawkBuilder.getConverter();
        this.serializer = hawkBuilder.getSerializer();
        LogInterceptor logInterceptor = hawkBuilder.getLogInterceptor();
        this.logInterceptor = logInterceptor;
        logInterceptor.onLog("Hawk.init -> Encryption : ".concat(encryption.getClass().getSimpleName()));
    }

    private void log(String str) {
        this.logInterceptor.onLog(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean contains(String str) {
        return this.storage.contains(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public long count() {
        return this.storage.count();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean delete(String str) {
        return this.storage.delete(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean deleteAll() {
        return this.storage.deleteAll();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> T get(String str) {
        String strDecrypt;
        log(AbstractC0157z.n("Hawk.get -> key: ", str));
        T t6 = null;
        if (str == null) {
            log("Hawk.get -> null key, returning null value ");
            return null;
        }
        String str2 = (String) this.storage.get(str);
        log(AbstractC0157z.n("Hawk.get -> Fetched from storage : ", str2));
        if (str2 == null) {
            log("Hawk.get -> Fetching from storage failed");
            return null;
        }
        DataInfo dataInfoDeserialize = this.serializer.deserialize(str2);
        log("Hawk.get -> Deserialized");
        if (dataInfoDeserialize == null) {
            log("Hawk.get -> Deserialization failed");
            return null;
        }
        try {
            strDecrypt = this.encryption.decrypt(str, dataInfoDeserialize.cipherText);
            try {
                log("Hawk.get -> Decrypted to : " + strDecrypt);
            } catch (Exception e) {
                e = e;
                log("Hawk.get -> Decrypt failed: " + e.getMessage());
            }
        } catch (Exception e6) {
            e = e6;
            strDecrypt = null;
        }
        if (strDecrypt == null) {
            log("Hawk.get -> Decrypt failed");
            return null;
        }
        try {
            t6 = (T) this.converter.fromString(strDecrypt, dataInfoDeserialize);
            log("Hawk.get -> Converted to : " + t6);
            return t6;
        } catch (Exception unused) {
            log("Hawk.get -> Converter failed");
            return t6;
        }
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean isBuilt() {
        return true;
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> boolean put(String str, T t6) {
        HawkUtils.checkNull("Key", str);
        log("Hawk.put -> key: " + str + ", value: " + t6);
        if (t6 == null) {
            log("Hawk.put -> Value is null. Any existing value will be deleted with the given key");
            return delete(str);
        }
        String string = this.converter.toString(t6);
        log(AbstractC0157z.n("Hawk.put -> Converted to ", string));
        if (string == null) {
            log("Hawk.put -> Converter failed");
            return false;
        }
        String strEncrypt = null;
        try {
            strEncrypt = this.encryption.encrypt(str, string);
            log("Hawk.put -> Encrypted to  " + strEncrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (strEncrypt == null) {
            log("Hawk.put -> Encryption failed");
            return false;
        }
        String strSerialize = this.serializer.serialize(strEncrypt, t6);
        log(AbstractC0157z.n("Hawk.put -> Serialized to", strSerialize));
        if (strSerialize == null) {
            log("Hawk.put -> Serialization failed");
            return false;
        }
        if (this.storage.put(str, strSerialize)) {
            log("Hawk.put -> Stored successfully");
            return true;
        }
        log("Hawk.put -> Store operation failed");
        return false;
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public void destroy() {
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> T get(String str, T t6) {
        T t7 = (T) get(str);
        return t7 == null ? t6 : t7;
    }
}
