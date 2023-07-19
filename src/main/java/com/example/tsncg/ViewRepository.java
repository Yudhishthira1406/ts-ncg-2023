package com.example.tsncg;


import com.example.tsncg.ViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<ViewEntity, Long> {
    
}
