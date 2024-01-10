package com.driver;
import java.util.*;
public class solution {
    public String rearrange(String str){
        int n=str.length();
        if(n==0)
            return "";
        int[]count= new int[26];
        for(char c:str.toCharArray()){
            int i=c-'A';
            if(i<0||i>26)
                return "";
            count[i]++;
        }
        char max_ch=getmaxchar(count);
        int ct=count[max_ch-'A'];
        if(ct>(n+1)/2)
            return "";
        String res="";
        int ind=0;
       for(int i=0;i<n;i++)
           res+=' ';
        while(ct>0){
            res=res.substring(0,ind)+max_ch+res.substring(ind+1);
            ind+=2;
            ct--;
        }
        count[max_ch-'A']=0;
        for(int i=0;i<26;i++){
            while(count[i]>0){
                ind=ind>=n?1:ind;
                res=res.substring(0,ind)+((char)((int)'A'+i))+res.substring(ind+1);
                count[i]--;
                ind+=2;
            }
        }
        return res;
    }

    private char getmaxchar(int[] count) {
        char c='a';
        int max=0;
        for(int i=0;i<26;i++){
            if(count[i]>max){
                max=count[i];
                c=(char)((int)'A'+i);
            }
        }
        return c;
    }
}