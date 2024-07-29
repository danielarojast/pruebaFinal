package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService <RQ,RS,ID> {
    public RS create(RQ request);

    public RS update(ID id, RQ request);

    public void delete(ID id);

    public Page<RS> findAll(int page, int size);
    
}
 