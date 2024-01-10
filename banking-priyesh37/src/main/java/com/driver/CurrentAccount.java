package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

     public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }


    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name,balance);
        this.tradeLicenseId=tradeLicenseId;
        setMinBalance(5000);
        if (balance<getMinBalance()){
            throw  new minbalException("Insufficient Balance");
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        char[]ch=tradeLicenseId.toCharArray();
        boolean f=false;
       for(int i=0;i<ch.length-1;i++){
           if(ch[i]==ch[i+1]){
               f=true;
               break;
           }
       }


        if(f){
           solution obj=new solution();
           String str= obj.rearrange(this.tradeLicenseId);
           if(str==""){
               throw new exceptions("Valid License can not be generated");
           }
           this.tradeLicenseId=str;
       }



    }

}
