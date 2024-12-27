package com.broadridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.broadridge.entity.CommunicationTemplate;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationTemplate, Long> {

}
