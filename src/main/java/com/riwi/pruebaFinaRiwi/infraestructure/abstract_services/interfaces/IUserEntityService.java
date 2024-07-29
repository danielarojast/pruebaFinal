package com.riwi.pruebaFinaRiwi.infraestructure.abstract_services.interfaces;

import com.riwi.pruebaFinaRiwi.api.dto.requests.UserEntityRequest;
import com.riwi.pruebaFinaRiwi.api.dto.response.UserEntityResponse;

public interface IUserEntityService extends CrudService<UserEntityRequest, UserEntityResponse, String> {
    public UserEntityResponse findById(String id);
}
