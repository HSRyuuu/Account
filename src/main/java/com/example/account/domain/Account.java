package com.example.account.domain;

import com.example.account.type.AccountStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private AccountUser accountUser;
    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private Long balance;//잔액

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
