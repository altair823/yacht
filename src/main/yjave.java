/*
Latest update: 20-08-31 16:09

Current Version:
    Version 0.1
    Version 0.2

Contributor: altair823

Description:
    File which help to build this program at java not kotlin for make jar file.
 */


import rule.RuleHandler;

public class yjave {
    public static void main(String[] args) {

        RuleHandler.INSTANCE.gameStart();
        int var0 = 1;

        for(byte var1 = 12; var0 <= var1; ++var0) {
            RuleHandler.INSTANCE.turns();
        }

        RuleHandler.INSTANCE.end();

    }
}
