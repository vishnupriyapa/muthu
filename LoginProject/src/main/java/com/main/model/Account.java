package com.main.model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accId;
    @Column(name="TERM_TENURE")
    private int tenure;
    @Column(name="TERM_INTEREST")
    private float interest;
    @Column(name="TERM_MATURE")
    private Date matureDate;
    @Column(name="ACCOUNT_UPDATED_DATE")
    private Date updatedDate;
    @Column(name="TERM_AMOUNT")
    private long termAmt;
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private Registration register;
}
