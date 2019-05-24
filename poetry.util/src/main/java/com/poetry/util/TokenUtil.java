package com.poetry.util;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {
    /**
     * token私钥
     */
    private static final String TOKEN_SECRET="5371f568a45e5ab1f442c38e0932aef24447139b" ;

    public static String createToken(Identity identity)  {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis=System.currentTimeMillis();
        Date now=new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(TOKEN_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //采用建造者模式定制化token属性
        JwtBuilder builder= Jwts.builder().setId(identity.getId())
                .setIssuedAt(now)
                .setSubject(identity.getId() + "," + identity.getUserName() + "," + identity.getRole())
                .setIssuer(identity.getIssuer())
                .signWith(signatureAlgorithm, signingKey);

        //设置失效时间戳
        long ttlmillis=identity.getDuration();
        if (ttlmillis>=0){
            long expMillis=nowMillis+ttlmillis;
            Date exp=new Date(expMillis);
            builder.setExpiration(exp);
            identity.setDuration(exp.getTime());
        }

        //生成token并序列化编码成一个URL安全的字符串
        return builder.compact();
    }

    public static Identity parseToken(String token)throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(TOKEN_SECRET))
                .parseClaimsJws(token).getBody();

        String[] subjectInfos=claims.getSubject().split(",");
        String id=subjectInfos[0];
        String userName=subjectInfos[1];
        String role=subjectInfos[2];

        Identity identity=new Identity();
        identity.setId(id);
        identity.setUserName(userName);
        identity.setRole(role);
        identity.setDuration(claims.getExpiration().getTime());

        return identity;
    }
}
