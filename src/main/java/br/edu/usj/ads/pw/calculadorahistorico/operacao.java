package br.edu.usj.ads.pw.calculadorahistorico;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class operacao {
    
    @Id
    Long id;

    String descricao;



}
