package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
    public BankAccount(String name, double balance, double minBalance) {

        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

     public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

       if(9*digits<sum)
            throw new accountExcpetion("Account Number can not be generated");
         String ans="";
        int nn=0;
        int sum1=sum;
        int curr =digits;
        while(curr>0&&sum1>0){
            if(sum1>9){
                ans+='9';
                sum1-=9;
                nn+=9;
            }
            else{
                ans+=String.valueOf(sum1);
                nn+=sum1;
                sum1=0;
            }
            curr--;
        }

         if(nn!=sum)
            throw new accountExcpetion("Account Number can not be generated");
        while(curr>0){
            ans+='0';
            curr--;
        }

        return ans;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        
            if(balance-amount<minBalance){
                  throw  new minbalException("Insufficient Balance");
              }
              else{
                  balance-=amount;
              }
        

    }

}