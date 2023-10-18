package com.mitocode.service.impl;

import com.mitocode.service.IRegisterDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mitocode.model.RegisterDetail;
import com.mitocode.repository.IGenericRepository;
import com.mitocode.repository.IRegisterDetailRepository;


@Service
@RequiredArgsConstructor
public class RegisterDetailServiceImpl extends CRUDImpl<RegisterDetail, Integer> implements IRegisterDetailService {
    private final IRegisterDetailRepository repo;
    @Override
    protected IGenericRepository<RegisterDetail, Integer> getRepo() {
        return repo;
    }
}
