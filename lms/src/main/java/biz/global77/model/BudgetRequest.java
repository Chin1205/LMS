package biz.global77.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "budget_request")
@Data
public class BudgetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 10)
    private String lengthOfStay;

    @NotBlank
    @Size(max = 10)
    private String costOfBond;

    @NotBlank
    @Size(max = 50)
    private String nameRequest;

    @NotBlank
    @Size(max = 255)
    private String requestDetails;

    @NotNull
    private boolean archived;
}
