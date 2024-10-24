package com.ssafy.sandbox.email.repository;

import com.ssafy.sandbox.email.domain.EmailCode;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmailCodeRepository extends CrudRepository<EmailCode, String> {

    Optional<EmailCode> findEmailCodeByEmail(String email);
}
