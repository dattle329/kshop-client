package com.vti.finalexam.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "accessory")
public class Accessory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "status_damaged", length = 50, nullable = false)
    private String statusDamaged;

    @Column(name = "repair_status", length = 50, nullable = false)
    private String repairStatus;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "license_plate", referencedColumnName = "license_plate", nullable = false),
            @JoinColumn(name = "repair_date", referencedColumnName = "repair_date", nullable = false)
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}
