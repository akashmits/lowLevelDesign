package glance;

import java.util.HashMap;

public class RateLimitConfig {
    public static void main(String [] arg){

        HashMap<String,Integer> rateLimitConfig= new HashMap<>();
        //rateLimitConfig.put("RewardTeam",3);
        rateLimitConfig.put("UPI",3);
        rateLimitConfig.put("totalUserLimit",0);

        UserRateLimit userRateLimitConfig= new UserRateLimit(rateLimitConfig);

        try {
            userRateLimitConfig.checkRateLimit(1, "RewardTeam");
           userRateLimitConfig.checkRateLimit(1, "UPI");

            userRateLimitConfig.checkRateLimit(1, "RewardTeam");
            userRateLimitConfig.checkRateLimit(1, "UPI");
            userRateLimitConfig.checkRateLimit(1, "RewardTeam");
            userRateLimitConfig.checkRateLimit(1, "UPI");
            userRateLimitConfig.checkRateLimit(1, "RewardTeam");
            userRateLimitConfig.checkRateLimit(1, "UPI");

        }catch(Exception ex){
          System.out.println("Exception received :"+ex.getMessage());
        }




    }
}
