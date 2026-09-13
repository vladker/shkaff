package com.orhanobut.hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface HawkFacade {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class EmptyHawkFacade implements HawkFacade {
        private void throwValidation() {
            throw new IllegalStateException("Hawk is not built. Please call build() and wait the initialisation finishes.");
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean contains(String str) {
            throwValidation();
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public long count() {
            throwValidation();
            return 0L;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean delete(String str) {
            throwValidation();
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean deleteAll() {
            throwValidation();
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public void destroy() {
            throwValidation();
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> T get(String str) {
            throwValidation();
            return null;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public boolean isBuilt() {
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> boolean put(String str, T t6) {
            throwValidation();
            return false;
        }

        @Override // com.orhanobut.hawk.HawkFacade
        public <T> T get(String str, T t6) {
            throwValidation();
            return null;
        }
    }

    boolean contains(String str);

    long count();

    boolean delete(String str);

    boolean deleteAll();

    void destroy();

    <T> T get(String str);

    <T> T get(String str, T t6);

    boolean isBuilt();

    <T> boolean put(String str, T t6);
}
