package models;
// Generated Jan 16, 2019 6:25:18 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * GuardReturnMaster generated by hbm2java
 */
public class GuardReturnMaster  implements java.io.Serializable {


     private Long returnIndex;
     private Securityguard securityguard;
     private Date returnDate;
     private Set guardReturnDetails = new HashSet(0);

    public GuardReturnMaster() {
    }

	
    public GuardReturnMaster(Securityguard securityguard, Date returnDate) {
        this.securityguard = securityguard;
        this.returnDate = returnDate;
    }
    public GuardReturnMaster(Securityguard securityguard, Date returnDate, Set guardReturnDetails) {
       this.securityguard = securityguard;
       this.returnDate = returnDate;
       this.guardReturnDetails = guardReturnDetails;
    }
   
    public Long getReturnIndex() {
        return this.returnIndex;
    }
    
    public void setReturnIndex(Long returnIndex) {
        this.returnIndex = returnIndex;
    }
    public Securityguard getSecurityguard() {
        return this.securityguard;
    }
    
    public void setSecurityguard(Securityguard securityguard) {
        this.securityguard = securityguard;
    }
    public Date getReturnDate() {
        return this.returnDate;
    }
    
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    public Set getGuardReturnDetails() {
        return this.guardReturnDetails;
    }
    
    public void setGuardReturnDetails(Set guardReturnDetails) {
        this.guardReturnDetails = guardReturnDetails;
    }




}

