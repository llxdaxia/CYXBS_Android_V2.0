package com.mredrock.cyxbs.model.rest;

import com.alibaba.fastjson.JSON;
import com.mredrock.cyxbs.model.BuildConfig;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import retrofit.converter.ConversionException;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

/**
 * Created by david on 15/4/13.
 * email: yangcheng0816@gmail.com
 */
public class FastjsonConverter implements Converter {
    private String charset;
    private static final int BUFFER_SIZE = 0x400; // 1024

    public FastjsonConverter() {
        this("UTF-8");
    }

    public FastjsonConverter(String charset) {
        this.charset = charset;
    }

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        String charset = this.charset;
        String result;
        if (body.mimeType() != null) {
            charset = MimeUtil.parseCharset(body.mimeType(), charset);
        }
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(body.in(), charset);
            StringBuilder sb = new StringBuilder();
            char[] buf = new char[BUFFER_SIZE];
            for (; ; ) {
                int res = isr.read(buf, 0, buf.length);
                if (res < 0) {
                    break;
                }
                sb.append(buf, 0, res);
            }
            result = sb.toString();
            if (BuildConfig.DEBUG) {
                Logger.json(result);
            }
            return JSON.parseObject(result, type);
        } catch (IOException e) {
            throw new ConversionException(e);
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    @Override
    public TypedOutput toBody(Object o) {
        try {
            return new JsonTypedOutPut(JSON.toJSONString(o).getBytes(charset), charset);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private static class JsonTypedOutPut implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        public JsonTypedOutPut(byte[] jsonBytes, String encode) {
            this.jsonBytes = jsonBytes;
            this.mimeType = "application/json; charset=" + encode;
        }

        @Override
        public String fileName() {
            return null;
        }

        @Override
        public String mimeType() {
            return mimeType;
        }

        @Override
        public long length() {
            return jsonBytes.length;
        }

        @Override
        public void writeTo(OutputStream out) throws IOException {
            out.write(jsonBytes);
        }
    }
}
