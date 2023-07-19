package com.example.tsncg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewEntity {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;
    @Column
    private String name;
    @Column
    private String chartType;
    @Column
    private String country;
    @Column
    private String indicator;
    @Column
    private String startDate;
    @Column
    private String endDate;


}