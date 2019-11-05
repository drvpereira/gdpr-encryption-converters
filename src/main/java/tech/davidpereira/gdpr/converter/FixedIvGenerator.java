package tech.davidpereira.gdpr.converter;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;

public class FixedIvGenerator implements BytesKeyGenerator {

    private final String iv;

    public FixedIvGenerator(String iv) {
        this.iv = iv;
    }

    @Override
    public int getKeyLength() {
        return 16;
    }

    @Override
    public byte[] generateKey() {
        return Base64.decode(iv);
    }

}
