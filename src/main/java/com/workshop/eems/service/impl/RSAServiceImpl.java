package com.workshop.eems.service.impl;

import com.workshop.eems.service.RSAService;
import com.workshop.eems.util.RSAUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Service("rsaServiceImpl")
public class RSAServiceImpl implements RSAService {
    private static final String PRIVATE_KEY_ATTRIBUTE_NAME = "privateKey";

    @Transactional(readOnly = true)
    public RSAPublicKey generateKey(HttpServletRequest request) {
        Assert.notNull(request);
        KeyPair keyPair = RSAUtils.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        HttpSession session = request.getSession();
        session.setAttribute(PRIVATE_KEY_ATTRIBUTE_NAME, privateKey);
        return publicKey;
    }

    @Transactional(readOnly = true)
    public void removePrivateKey(HttpServletRequest request) {
        Assert.notNull(request);
        HttpSession session = request.getSession();
        session.removeAttribute(PRIVATE_KEY_ATTRIBUTE_NAME);
    }

    @Transactional(readOnly = true)
    public String decryptParameter(String name, HttpServletRequest request) {
        Assert.notNull(request);
        if (name != null) {
            HttpSession session = request.getSession();
            RSAPrivateKey privateKey = (RSAPrivateKey) session.getAttribute
                    (PRIVATE_KEY_ATTRIBUTE_NAME);
            String parameter = request.getParameter(name);
            if (privateKey != null && StringUtils.isNotEmpty(parameter)) {
                return RSAUtils.decrypt(privateKey, parameter);
            }
        }
        return null;
    }

}