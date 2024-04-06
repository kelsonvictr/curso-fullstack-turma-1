package br.com.gerenciadordeprodutos.api.Costumer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Costumer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String cpf;

    private String email;

    @OneToOne(mappedBy = "costumer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private CostumerAddress address;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
