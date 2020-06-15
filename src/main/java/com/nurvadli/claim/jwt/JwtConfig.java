package com.nurvadli.claim.jwt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author Nurvadli
 */
public class JwtConfig {

//    private PrivateKey getPrivateKey(String privateKeyString) {
//        try {
//            String privateKeyString = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("private_key.pem").toURI())));
//            privateKeyString = privateKeyString
//                    .replaceAll("\\n", "")
//                    .replace("-----BEGIN PRIVATE KEY-----", "")
//                    .replace("-----END PRIVATE KEY-----", "");
//
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
//            return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
//
//        } catch (InvalidKeySpecException ike) {
//            ike.printStackTrace();
//        } catch (NoSuchAlgorithmException nsae) {
//            nsae.printStackTrace();
//        } catch (URISyntaxException use) {
//            use.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return null;
//    }
//
//    private RSAPublicKey getPublicKey() {
//        try {
//            String publicKeyContent = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("public_key.pem").toURI())));
//            publicKeyContent = publicKeyContent
//                    .replaceAll("\\n", "")
//                    .replace("-----BEGIN PUBLIC KEY-----", "")
//                    .replace("-----END PUBLIC KEY-----", "");
//
//            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyContent));
//            return (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
//
//        } catch (InvalidKeySpecException ike) {
//            ike.printStackTrace();
//        } catch (NoSuchAlgorithmException nsae) {
//            nsae.printStackTrace();
//        } catch (URISyntaxException use) {
//            use.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return null;
//    }
}
