package com.example.casestudy2.model.contract;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = AttachService.class)
    private AttachService attachService;
    @ManyToOne(targetEntity = Contract.class)
    private Contract contract;

    private Integer contractDetailQuantity;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getContractDetailQuantity() {
        return contractDetailQuantity;
    }

    public void setContractDetailQuantity(Integer contractDetailQuantity) {
        this.contractDetailQuantity = contractDetailQuantity;
    }
}
