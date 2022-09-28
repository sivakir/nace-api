package com.app.nace.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "nace")
public class Nace {
    @Id
    @JsonProperty("Order")
    private Long id;
    @JsonProperty("Level")
    private Integer level;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Parent")
    private String parent;
    @JsonProperty("Description")
    private String descr;
    @JsonProperty("This item includes")
    private String fulldescr;
    @JsonProperty("This item also includes")
    private String includes;
    @JsonProperty("Rulings")
    private String rulings;
    @JsonProperty("This item excludes")
    private String excludes;
    @JsonProperty("Reference to ISIC Rev. 4")
    private String isicref;
}
