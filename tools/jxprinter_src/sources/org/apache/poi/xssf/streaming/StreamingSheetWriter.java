package org.apache.poi.xssf.streaming;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StreamingSheetWriter extends SheetDataWriter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) StreamingSheetWriter.class);
    private boolean closed;

    public StreamingSheetWriter() {
        this.closed = false;
        throw new RuntimeException("StreamingSheetWriter requires OutputStream");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this._out.flush();
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public File createTempFile() {
        throw new RuntimeException("Not supported with StreamingSheetWriter");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public Writer createWriter(File file) {
        throw new RuntimeException("Not supported with StreamingSheetWriter");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public boolean dispose() throws IOException {
        if (!this.closed) {
            this._out.close();
        }
        this.closed = true;
        return true;
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public InputStream getWorksheetXMLInputStream() {
        throw new RuntimeException("Not supported with StreamingSheetWriter");
    }

    public static Writer createWriter(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
    }

    public StreamingSheetWriter(OutputStream outputStream) {
        super(createWriter(outputStream));
        this.closed = false;
        LOG.atDebug().log("Preparing SXSSF sheet writer");
    }
}
