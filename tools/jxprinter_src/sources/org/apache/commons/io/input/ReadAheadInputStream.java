package org.apache.commons.io.input;

import A3.AbstractC0157z;
import com.google.common.primitives.UnsignedBytes;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ReadAheadInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ThreadLocal<byte[]> oneByte = ThreadLocal.withInitial(new androidx.emoji2.text.flatbuffer.a(3));
    private ByteBuffer activeBuffer;
    private final Condition asyncReadComplete;
    private boolean endOfStream;
    private final ExecutorService executorService;
    private boolean isClosed;
    private boolean isReading;
    private boolean isUnderlyingInputStreamBeingClosed;
    private final AtomicBoolean isWaiting;
    private boolean readAborted;
    private ByteBuffer readAheadBuffer;
    private Throwable readException;
    private boolean readInProgress;
    private final boolean shutdownExecutorService;
    private final ReentrantLock stateChangeLock;
    private final InputStream underlyingInputStream;

    public ReadAheadInputStream(InputStream inputStream, int i5) {
        this(inputStream, i5, newExecutorService(), true);
    }

    private void checkReadException() throws IOException {
        if (this.readAborted) {
            Throwable th = this.readException;
            if (!(th instanceof IOException)) {
                throw new IOException(this.readException);
            }
            throw ((IOException) th);
        }
    }

    private void closeUnderlyingInputStreamIfNecessary() {
        this.stateChangeLock.lock();
        boolean z6 = false;
        try {
            this.isReading = false;
            if (this.isClosed && !this.isUnderlyingInputStreamBeingClosed) {
                z6 = true;
            }
            this.stateChangeLock.unlock();
            if (z6) {
                try {
                    this.underlyingInputStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (Throwable th) {
            this.stateChangeLock.unlock();
            throw th;
        }
    }

    private boolean isEndOfStream() {
        return (this.activeBuffer.hasRemaining() || this.readAheadBuffer.hasRemaining() || !this.endOfStream) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readAsync$1(byte[] bArr) {
        this.stateChangeLock.lock();
        try {
            if (this.isClosed) {
                this.readInProgress = false;
                this.stateChangeLock.unlock();
                return;
            }
            this.isReading = true;
            this.stateChangeLock.unlock();
            int length = bArr.length;
            int i5 = 0;
            int i6 = 0;
            do {
                try {
                    i6 = this.underlyingInputStream.read(bArr, i5, length);
                    if (i6 > 0) {
                        i5 += i6;
                        length -= i6;
                        if (length <= 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    try {
                        if (th instanceof Error) {
                            throw th;
                        }
                        this.stateChangeLock.lock();
                        try {
                            this.readAheadBuffer.limit(i5);
                            if (i6 < 0 || (th instanceof EOFException)) {
                                this.endOfStream = true;
                            } else {
                                this.readAborted = true;
                                this.readException = th;
                            }
                            this.readInProgress = false;
                            signalAsyncReadComplete();
                            this.stateChangeLock.unlock();
                            closeUnderlyingInputStreamIfNecessary();
                            return;
                        } catch (Throwable th2) {
                            this.stateChangeLock.unlock();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        this.stateChangeLock.lock();
                        try {
                            this.readAheadBuffer.limit(i5);
                            if (i6 < 0 || (th instanceof EOFException)) {
                                this.endOfStream = true;
                            } else {
                                this.readAborted = true;
                                this.readException = th;
                            }
                            this.readInProgress = false;
                            signalAsyncReadComplete();
                            this.stateChangeLock.unlock();
                            closeUnderlyingInputStreamIfNecessary();
                            throw th3;
                        } catch (Throwable th4) {
                            this.stateChangeLock.unlock();
                            throw th4;
                        }
                    }
                }
            } while (!this.isWaiting.get());
            this.stateChangeLock.lock();
            try {
                this.readAheadBuffer.limit(i5);
                if (i6 < 0) {
                    this.endOfStream = true;
                }
                this.readInProgress = false;
                signalAsyncReadComplete();
                this.stateChangeLock.unlock();
                closeUnderlyingInputStreamIfNecessary();
            } catch (Throwable th5) {
                this.stateChangeLock.unlock();
                throw th5;
            }
        } catch (Throwable th6) {
            this.stateChangeLock.unlock();
            throw th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$static$0() {
        return new byte[1];
    }

    private static ExecutorService newExecutorService() {
        return Executors.newSingleThreadExecutor(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "commons-io-read-ahead");
        thread.setDaemon(true);
        return thread;
    }

    private void readAsync() {
        this.stateChangeLock.lock();
        try {
            byte[] bArrArray = this.readAheadBuffer.array();
            if (!this.endOfStream && !this.readInProgress) {
                checkReadException();
                this.readAheadBuffer.position(0);
                this.readAheadBuffer.flip();
                this.readInProgress = true;
                this.stateChangeLock.unlock();
                this.executorService.execute(new W2.b(this, bArrArray, 26));
                return;
            }
            this.stateChangeLock.unlock();
        } catch (Throwable th) {
            this.stateChangeLock.unlock();
            throw th;
        }
    }

    private void signalAsyncReadComplete() {
        this.stateChangeLock.lock();
        try {
            this.asyncReadComplete.signalAll();
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    private long skipInternal(long j6) throws IOException {
        waitForAsyncReadComplete();
        if (isEndOfStream()) {
            return 0L;
        }
        if (available() >= j6) {
            int iRemaining = ((int) j6) - this.activeBuffer.remaining();
            this.activeBuffer.position(0);
            this.activeBuffer.flip();
            ByteBuffer byteBuffer = this.readAheadBuffer;
            byteBuffer.position(byteBuffer.position() + iRemaining);
            swapBuffers();
            readAsync();
            return j6;
        }
        long jAvailable = available();
        this.activeBuffer.position(0);
        this.activeBuffer.flip();
        this.readAheadBuffer.position(0);
        this.readAheadBuffer.flip();
        long jSkip = this.underlyingInputStream.skip(j6 - jAvailable);
        readAsync();
        return jAvailable + jSkip;
    }

    private void swapBuffers() {
        ByteBuffer byteBuffer = this.activeBuffer;
        this.activeBuffer = this.readAheadBuffer;
        this.readAheadBuffer = byteBuffer;
    }

    private void waitForAsyncReadComplete() throws IOException {
        this.stateChangeLock.lock();
        try {
            try {
                this.isWaiting.set(true);
                while (this.readInProgress) {
                    this.asyncReadComplete.await();
                }
                this.isWaiting.set(false);
                this.stateChangeLock.unlock();
                checkReadException();
            } catch (InterruptedException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException(e.getMessage());
                interruptedIOException.initCause(e);
                throw interruptedIOException;
            }
        } catch (Throwable th) {
            this.isWaiting.set(false);
            this.stateChangeLock.unlock();
            throw th;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        this.stateChangeLock.lock();
        try {
            return (int) Math.min(2147483647L, ((long) this.activeBuffer.remaining()) + ((long) this.readAheadBuffer.remaining()));
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003e */
    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void close() throws java.io.IOException {
        /*
            r5 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r5.stateChangeLock
            r0.lock()
            boolean r0 = r5.isClosed     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto Lf
            java.util.concurrent.locks.ReentrantLock r0 = r5.stateChangeLock
            r0.unlock()
            return
        Lf:
            r0 = 1
            r5.isClosed = r0     // Catch: java.lang.Throwable -> L19
            boolean r1 = r5.isReading     // Catch: java.lang.Throwable -> L19
            if (r1 != 0) goto L1b
            r5.isUnderlyingInputStreamBeingClosed = r0     // Catch: java.lang.Throwable -> L19
            goto L1c
        L19:
            r0 = move-exception
            goto L57
        L1b:
            r0 = 0
        L1c:
            java.util.concurrent.locks.ReentrantLock r1 = r5.stateChangeLock
            r1.unlock()
            boolean r1 = r5.shutdownExecutorService
            if (r1 == 0) goto L56
            java.util.concurrent.ExecutorService r1 = r5.executorService     // Catch: java.lang.Throwable -> L3e java.lang.InterruptedException -> L40
            r1.shutdownNow()     // Catch: java.lang.Throwable -> L3e java.lang.InterruptedException -> L40
            java.util.concurrent.ExecutorService r1 = r5.executorService     // Catch: java.lang.Throwable -> L3e java.lang.InterruptedException -> L40
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L3e java.lang.InterruptedException -> L40
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.awaitTermination(r3, r2)     // Catch: java.lang.Throwable -> L3e java.lang.InterruptedException -> L40
            if (r0 == 0) goto L56
            java.io.InputStream r0 = r5.underlyingInputStream
            r0.close()
            return
        L3e:
            r1 = move-exception
            goto L4e
        L40:
            r1 = move-exception
            java.io.InterruptedIOException r2 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = r1.getMessage()     // Catch: java.lang.Throwable -> L3e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3e
            r2.initCause(r1)     // Catch: java.lang.Throwable -> L3e
            throw r2     // Catch: java.lang.Throwable -> L3e
        L4e:
            if (r0 == 0) goto L55
            java.io.InputStream r0 = r5.underlyingInputStream
            r0.close()
        L55:
            throw r1
        L56:
            return
        L57:
            java.util.concurrent.locks.ReentrantLock r1 = r5.stateChangeLock
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.io.input.ReadAheadInputStream.close():void");
    }

    @Override // java.io.InputStream
    public int read() {
        byte b;
        if (this.activeBuffer.hasRemaining()) {
            b = this.activeBuffer.get();
        } else {
            byte[] bArr = oneByte.get();
            if (read(bArr, 0, 1) == -1) {
                return -1;
            }
            b = bArr[0];
        }
        return b & UnsignedBytes.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public long skip(long j6) {
        if (j6 <= 0) {
            return 0L;
        }
        if (j6 <= this.activeBuffer.remaining()) {
            ByteBuffer byteBuffer = this.activeBuffer;
            byteBuffer.position(byteBuffer.position() + ((int) j6));
            return j6;
        }
        this.stateChangeLock.lock();
        try {
            return skipInternal(j6);
        } finally {
            this.stateChangeLock.unlock();
        }
    }

    public ReadAheadInputStream(InputStream inputStream, int i5, ExecutorService executorService) {
        this(inputStream, i5, executorService, false);
    }

    private ReadAheadInputStream(InputStream inputStream, int i5, ExecutorService executorService, boolean z6) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.stateChangeLock = reentrantLock;
        this.isWaiting = new AtomicBoolean(false);
        this.asyncReadComplete = reentrantLock.newCondition();
        if (i5 > 0) {
            Objects.requireNonNull(executorService, "executorService");
            this.executorService = executorService;
            Objects.requireNonNull(inputStream, "inputStream");
            this.underlyingInputStream = inputStream;
            this.shutdownExecutorService = z6;
            this.activeBuffer = ByteBuffer.allocate(i5);
            this.readAheadBuffer = ByteBuffer.allocate(i5);
            this.activeBuffer.flip();
            this.readAheadBuffer.flip();
            return;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "bufferSizeInBytes should be greater than 0, but the value is "));
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return 0;
        }
        if (!this.activeBuffer.hasRemaining()) {
            this.stateChangeLock.lock();
            try {
                waitForAsyncReadComplete();
                if (!this.readAheadBuffer.hasRemaining()) {
                    readAsync();
                    waitForAsyncReadComplete();
                    if (isEndOfStream()) {
                        this.stateChangeLock.unlock();
                        return -1;
                    }
                }
                swapBuffers();
                readAsync();
                this.stateChangeLock.unlock();
            } catch (Throwable th) {
                this.stateChangeLock.unlock();
                throw th;
            }
        }
        int iMin = Math.min(i6, this.activeBuffer.remaining());
        this.activeBuffer.get(bArr, i5, iMin);
        return iMin;
    }
}
