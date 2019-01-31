package models;
// Generated Jan 10, 2019 3:43:57 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ItemOutwardMaster generated by hbm2java
 */
public class ItemOutwardMaster  implements java.io.Serializable {


     private Long outwardMasterIndex;
     private PersonMaster personMaster;
     private Date date;
     private String remark;
     private String payment;
     private Set itemOutwardDetailses = new HashSet(0);

    public ItemOutwardMaster() {
    }

	
    public ItemOutwardMaster(PersonMaster personMaster, Date date, String remark) {
        this.personMaster = personMaster;
        this.date = date;
        this.remark = remark;
    }
    public ItemOutwardMaster(PersonMaster personMaster, Date date, String Payment, Set itemOutwardDetailses) {
       this.personMaster = personMaster;
       this.date = date;
       this.payment = payment;
       this.itemOutwardDetailses = itemOutwardDetailses;
    }
   
    public Long getOutwardMasterIndex() {
        return this.outwardMasterIndex;
    }
    
    public void setOutwardMasterIndex(Long outwardMasterIndex) {
        this.outwardMasterIndex = outwardMasterIndex;
    }
    public PersonMaster getPersonMaster() {
        return this.personMaster;
    }
    
    public void setPersonMaster(PersonMaster personMaster) {
        this.personMaster = personMaster;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Set getItemOutwardDetailses() {
        return this.itemOutwardDetailses;
    }
    
    public void setItemOutwardDetailses(Set itemOutwardDetailses) {
        this.itemOutwardDetailses = itemOutwardDetailses;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

}


