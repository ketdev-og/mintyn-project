package com.example.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class MintynOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NonNull
    @Column(unique = true)
    private String orderId;

    @NonNull
    private Long totalPrice;

    @NonNull
    private String customerName;

    @NonNull
    private String customerPhone;


    @ManyToMany(cascade =  CascadeType.ALL)
    private Set<MintynProduct> products;

}
