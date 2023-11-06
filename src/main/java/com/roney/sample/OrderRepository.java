package com.roney.sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roney.sample.entity.CustomerOrder;
import com.roney.sample.entity.SiteUser;

@Repository
public interface OrderRepository extends JpaRepository<CustomerOrder, Integer> {
	public List<CustomerOrder> findAllByUser(SiteUser user);
}
