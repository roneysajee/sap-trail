package com.roney.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roney.sample.entity.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Integer> {

}
