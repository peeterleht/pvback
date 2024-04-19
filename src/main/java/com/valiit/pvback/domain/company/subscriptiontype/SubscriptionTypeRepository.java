package com.valiit.pvback.domain.company.subscriptiontype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionTypeRepository extends JpaRepository<SubscriptionType, Integer> {

    @Override
    Optional<SubscriptionType> findById(Integer integer);
}