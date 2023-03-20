package com.orders.mintyn_order.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.Set;

import static com.orders.mintyn_order.utils.Helpers.genRandomId;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MintynProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Column(unique = true)
    private String productId = genRandomId("PRD");

    @NonNull
    private String description;

    @NonNull
    private Long price;

    @NonNull
    private Long quantity;

    @JsonBackReference
    @ManyToMany(mappedBy = "products")
    private Set<MintynOrder> orders;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
