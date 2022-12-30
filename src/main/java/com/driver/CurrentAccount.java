package com.driver;

import java.util.Objects;

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
      super(name,balance,5000);
       if(balance==5000)
       {
           System.out.println(" it is default money");
       }
       else if(balance >5000)
       {
           throw new Exception("Insufficient Balance");
       }
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String res = check(tradeLicenseId);

        if (Objects.equals(res, ""))
            throw new Exception("Valid License can not be generated");


    }

    public String check(String stree){

        int Number = stree.length();
        if (Number == 0)
            return "";

        int[] freq = new int[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = 0;
        }
        for (char cher : stree.toCharArray()) {
            freq[(int)cher - (int)'a']++;
        }

        char charmax = getMaxCountChar(freq);
        int maxCount = freq[(int)charmax - (int)'a'];

        // check if the result is possible or not
        if (maxCount > (Number + 1) / 2)
            return "";

        String res = "";
        for (int i = 0; i < Number; i++) {
            res += ' ';
        }

        int index = 0;
        // filling the most frequently occurring char in the
        // even indices
        while (maxCount > 0) {
            res = res.substring(0, index) + charmax+ res.substring(index + 1);
            index = index + 2;
            maxCount--;
        }
        freq[(int)charmax - (int)'a'] = 0;

        // now filling the other Chars, first filling the
        // even positions and then the odd positions
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                index = (index >= Number) ? 1 : index;
                res = res.substring(0, index)
                        + (char)((int)'a' + i)
                        + res.substring(index + 1);
                index += 2;
                freq[i]--;
            }
        }
        return res;
    }


    public char getMaxCountChar(int[] count)
    {
        int max = 0;
        char ch = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)((int)'a' + i);
            }
        }
        return ch;
    }

}


