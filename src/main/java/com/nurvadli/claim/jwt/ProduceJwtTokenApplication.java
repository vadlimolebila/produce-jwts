package com.nurvadli.claim.jwt;

import com.sun.deploy.net.proxy.ProxyUnavailableException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Nurvadli
 */
public class ProduceJwtTokenApplication {

    public static void main(String[] args) {
        new ProduceJwtTokenApplication();
    }

    public ProduceJwtTokenApplication() {
        Scanner scan = new Scanner(System.in);
        int process= 0;
        while (true) {
            if( process > 0) {
                System.out.print("You want to continue? y/n : ");
                String choose = scan.nextLine();
                if ("y".equalsIgnoreCase(choose)){
                    System.exit(0);
                }
            }
            System.out.println("=== PRODUCE JWT TOKEN ===");
            System.out.println("1. Insert your Client ID:");
            System.out.print("Client ID : ");
            String clientId = scan.nextLine();
            System.out.println("1. Insert your Audience:");
            System.out.print("Audience : ");
            String audience = scan.nextLine();
            System.out.println("1. Insert your Private Key:");
            System.out.print("Private Key : ");
            String privateKey = scan.nextLine();

            if (!"".equals(clientId) && !"".equals(audience) && !"".equals(privateKey)) {
                String jwt = generateJwtToken(privateKey, clientId, audience);
                System.out.println("TOKEN : " + jwt);
            }
            process++;
        }
    }

    public String generateJwtToken(String pk, String clientId, String audience) {
        String token= "";
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(pk));
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            token = Jwts.builder().setSubject("nurvadli")
                    .setExpiration(new Date(2020, 6, 16))
                    .setIssuer(clientId)
                    .setAudience(audience)
                    .claim("groups", new String[]{"user", "admin"})
                    // RS256 with privateKey
                    .signWith(SignatureAlgorithm.RS256, privateKey).compact();
        } catch (InvalidKeySpecException ike) {
            ike.printStackTrace();
        } catch (NoSuchAlgorithmException nsae) {
            nsae.printStackTrace();
        }
        return token;
    }
}
