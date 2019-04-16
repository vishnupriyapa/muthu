package com.main.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="firstTable")
@SecondaryTables({
		@SecondaryTable(name="secondTable",pkJoinColumns={@PrimaryKeyJoinColumn(name="secId",referencedColumnName="id")}),
		@SecondaryTable(name="thirdTable",pkJoinColumns={@PrimaryKeyJoinColumn(name="thiId",referencedColumnName="id")}),
		@SecondaryTable(name="fourthTable",pkJoinColumns={@PrimaryKeyJoinColumn(name="fourId",referencedColumnName="id")})
})
public class Registration {
     @Id
     @GeneratedValue(strategy=GenerationType.AUTO)
private int id;   
private String firstName;  
private String lastName;   
@DateTimeFormat(pattern="dd-MM-yyyy")
private LocalDate dob;   
private String addressLine1;   
private String addressLine2;
     
     
     @Column(table="secondTable")
private String city;
     @Column(table="secondTable")
private String state;
     @Column(table="secondTable")
private int pincode;   
     @Column(table="secondTable")
private long mobileNo;     
     @Column(table="secondTable")
private String email;
     @Column(table="secondTable")
private String userName;
     @Column(table="secondTable")
private String password;
     
     @Column(table="thirdTable")
private long aadhar;
     @Column(table="thirdTable")
private String pan;
     @Column(table="thirdTable")
private String aadharProof;
     @Column(table="thirdTable")
private String panProof;
     @Column(table="thirdTable")
private String dobProof;
     @Column(table="thirdTable")
private String addressProof;
     @Column(table="fourthTable")
     private long accountNo;
     @Column(table="fourthTable")
     private String accountType;
     @Column(table="fourthTable")
     private long balance;
     @Column(table="fourthTable")
     private LocalDate createdDate;

public Registration(int id, String firstName, String lastName, LocalDate dob, String addressLine1, String addressLine2,
                                String city, String state, int pincode, long mobileNo, String email, long aadhar, String pan, String userName,
                                String password, String dobProof, String addressProof, String aadharProof, String panProof) {
                super();
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.dob = dob;
                this.addressLine1 = addressLine1;
                this.addressLine2 = addressLine2;
                this.city = city;
                this.state = state;
                this.pincode = pincode;
                this.mobileNo = mobileNo;
                this.email = email;
                this.aadhar = aadhar;
                this.pan = pan;
                this.userName = userName;
                this.password = password;
                this.dobProof = dobProof;
                this.addressProof = addressProof;
                this.aadharProof = aadharProof;
                this.panProof = panProof;
}
public Registration() {
                super();

}
public String getFirstName() {
                return firstName;
}
public void setFirstName(String firstName) {
                this.firstName = firstName;
}
public String getLastName() {
                return lastName;
}
public void setLastName(String lastName) {
                this.lastName = lastName;
}
public LocalDate getDob() {
                return dob;
}
public void setDob(LocalDate dob) {
                this.dob = dob;
}
public String getAddressLine1() {
                return addressLine1;
}
public void setAddressLine1(String addressLine1) {
                this.addressLine1 = addressLine1;
}
public String getAddressLine2() {
                return addressLine2;
}
public void setAddressLine2(String addressLine2) {
                this.addressLine2 = addressLine2;
}
public String getCity() {
                return city;
}
public void setCity(String city) {
                this.city = city;
}
public String getState() {
                return state;
}
public void setState(String state) {
                this.state = state;
}
public int getPincode() {
                return pincode;
}
public void setPincode(int pincode) {
                this.pincode = pincode;
}
public long getMobileNo() {
                return mobileNo;
}
public void setMobileNo(long mobileNo) {
                this.mobileNo = mobileNo;
}
public String getEmail() {
                return email;
}
public void setEmail(String email) {
                this.email = email;
}
public long getAadhar() {
                return aadhar;
}
public void setAadhar(long aadhar) {
                this.aadhar = aadhar;
}
public String getPan() {
                return pan;
}
public void setPan(String pan) {
                this.pan = pan;
}
public String getUserName() {
                return userName;
}
public void setUserName(String userName) {
                this.userName = userName;
}
public String getPassword() {
                return password;
}
public void setPassword(String password) {
                this.password = password;
}

public String getDobProof() {
                return dobProof;
}
public void setDobProof(String dobProof) {
                this.dobProof = dobProof;
}
public String getAddressProof() {
                return addressProof;
}
public void setAddressProof(String addressProof) {
                this.addressProof = addressProof;
}
public String getAadharProof() {
                return aadharProof;
}
public void setAadharProof(String aadharProof) {
                this.aadharProof = aadharProof;
}
public String getPanProof() {
                return panProof;
}
public void setPanProof(String panProof) {
                this.panProof = panProof;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public long getAccountNo() {
	return accountNo;
}
public void setAccountNo(long accountNo) {
	this.accountNo = accountNo;
}
public String getAccountType() {
	return accountType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public long getBalance() {
	return balance;
}
public void setBalance(long balance) {
	this.balance = balance;
}
public LocalDate getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(LocalDate createdDate) {
	this.createdDate = createdDate;
}

}

