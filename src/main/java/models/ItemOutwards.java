package models;
// Generated Jan 4, 2019 5:42:06 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * ItemOutwards generated by hbm2java
 */
public class ItemOutwards  implements java.io.Serializable {


     private long outwardIndex;
     private ItemMaster itemMaster;
     private ItemInwards itemInwards;
     private PersonMaster personMaster;
     private double qty;
     private double sellingPrice;
     private Date date;
     private String remark;

    public ItemOutwards() {
    }

	
    public ItemOutwards(long outwardIndex, ItemMaster itemMaster, ItemInwards itemInwards, PersonMaster personMaster, double qty, double sellingPrice, Date date) {
        this.outwardIndex = outwardIndex;
        this.itemMaster = itemMaster;
        this.itemInwards = itemInwards;
        this.personMaster = personMaster;
        this.qty = qty;
        this.sellingPrice = sellingPrice;
        this.date = date;
    }
    public ItemOutwards(long outwardIndex, ItemMaster itemMaster, ItemInwards itemInwards, PersonMaster personMaster, double qty, double sellingPrice, Date date, String remark) {
       this.outwardIndex = outwardIndex;
       this.itemMaster = itemMaster;
       this.itemInwards = itemInwards;
       this.personMaster = personMaster;
       this.qty = qty;
       this.sellingPrice = sellingPrice;
       this.date = date;
       this.remark = remark;
    }
   
    public long getOutwardIndex() {
        return this.outwardIndex;
    }
    
    public void setOutwardIndex(long outwardIndex) {
        this.outwardIndex = outwardIndex;
    }
    public ItemMaster getItemMaster() {
        return this.itemMaster;
    }
    
    public void setItemMaster(ItemMaster itemMaster) {
        this.itemMaster = itemMaster;
    }
    public ItemInwards getItemInwards() {
        return this.itemInwards;
    }
    
    public void setItemInwards(ItemInwards itemInwards) {
        this.itemInwards = itemInwards;
    }
    public PersonMaster getPersonMaster() {
        return this.personMaster;
    }
    
    public void setPersonMaster(PersonMaster personMaster) {
        this.personMaster = personMaster;
    }
    public double getQty() {
        return this.qty;
    }
    
    public void setQty(double qty) {
        this.qty = qty;
    }
    public double getSellingPrice() {
        return this.sellingPrice;
    }
    
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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




}


