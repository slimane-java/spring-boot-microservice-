package com.example.demoServer1.service.mfa;

import com.example.demoServer1.entity.MfaEntity;

public interface MfaService {
    MfaEntity createAndSend(MfaEntity mfaDto);

    MfaEntity findMfa(String mfaToken);

    void resendMfa(String mfaToken);

    void removeMfa(String mfaToken);

}
