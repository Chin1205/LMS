package biz.global77.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "budget_request")
@Getter
@Setter
@NoArgsConstructor
public class BudgetRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "length_of_stay", nullable = false)
    private String lengthOfStay;

    @Column(name = "cost_of_bond", nullable = false)
    private String costOfBond;

    @Column(name = "name_request", nullable = false)
    private String nameRequest;

    @Column(name = "request_details")
    private String requestDetails;
}
