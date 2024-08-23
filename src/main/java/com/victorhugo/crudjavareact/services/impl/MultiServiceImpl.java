package com.victorhugo.crudjavareact.services.impl;

import com.victorhugo.crudjavareact.services.MultiService;

public class MultiServiceImpl implements MultiService {
    @Override
    public String fooService(String bar) {
        return "It worked";
    }
}
