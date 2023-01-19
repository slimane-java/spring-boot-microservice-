package com.example.demoServer1.service.mfa;

import com.example.demoServer1.dao.MfaRepo;
import com.example.demoServer1.entity.MfaEntity;
import lombok.RequiredArgsConstructor;
//import lombok.var;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MfaServiceImpl implements MfaService{

    private final MfaRepo mfaRepo;


    @Override
    public MfaEntity createAndSend(MfaEntity mfaDto) {

        String mfaValue = "";
        return null;
    }

    @Override
    public MfaEntity findMfa(String mfaToken) {
        return null;
    }

    @Override
    public void resendMfa(String mfaToken) {

    }

    @Override
    public void removeMfa(String mfaToken) {

    }
}
