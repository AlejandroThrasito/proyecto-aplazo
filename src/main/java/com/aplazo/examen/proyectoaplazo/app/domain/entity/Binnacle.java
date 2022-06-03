package com.aplazo.examen.proyectoaplazo.app.domain.entity;

import com.aplazo.examen.proyectoaplazo.app.web.model.InputSimpleInterestModel;
import com.aplazo.examen.proyectoaplazo.app.web.model.OutputSimpleInterestModel;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "binnacle")
@TypeDefs({
        @TypeDef(name = "jsonA",typeClass = JsonType.class)
})
public class Binnacle {
    @Id
    @Setter
    @Column(name = "id_binnacle")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "jsonA")
    @Column(columnDefinition = "json")
    private InputSimpleInterestModel request;
    @Type(type = "jsonA")
    @Column(columnDefinition = "json")
    private List<OutputSimpleInterestModel> response;
    @Column(name = "date_register")
    private LocalDateTime dateRegister;

    @Tolerate
    private Binnacle(){}
}
