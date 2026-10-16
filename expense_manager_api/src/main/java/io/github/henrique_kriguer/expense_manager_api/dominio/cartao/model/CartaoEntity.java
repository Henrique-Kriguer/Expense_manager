package io.github.henrique_kriguer.expense_manager_api.dominio.cartao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "cartao")
@Getter@Setter
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    @Column(name = "codigo")
    private UUID id;

    @Column(name = "cartao_nome",nullable = false, length = 30)
    private String cartaoName;

    @Column(name = "bandeira")
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDateTime.now());
    }
}
