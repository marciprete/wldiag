package it.senape.wldiag.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
public class Util {

    public static ByteArrayOutputStream getFileAsByteArrayOS(InputStream is) throws IOException {
        final int BUFFER = 4096;
        int count;
        byte data[] = new byte[BUFFER];
        ByteArrayOutputStream dest = new ByteArrayOutputStream();
        while ((count = is.read(data, 0, BUFFER))
                != -1) {
            dest.write(data, 0, count);
        }
        return dest;
    }
}
