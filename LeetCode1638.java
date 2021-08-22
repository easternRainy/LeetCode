class LeetCode1638 {
    public int countSubstrings(String s, String t) {
        int result = 0;
        
        
        for(int i=0; i<s.length(); i++) {
            
            
            for(int j=0; j<t.length(); j++) {
                int m = i;
                int n = j;
                
                int diff = 0;
                while(m < s.length() && n < t.length()) {
                    //System.out.println(s.charAt(m) + " " + t.charAt(n));
                    if (s.charAt(m) == t.charAt(n)) {
                        m = m + 1;
                        n = n + 1;  
                        if (diff == 1) {
                            //System.out.println("Adding");
                            result += 1;
                        }
                        continue;
                    } 
                    
                    
                    diff = diff + 1;
                    
                    if (diff == 1) {
                        //System.out.println("Adding");
                        result = result + 1;
                        m = m + 1;
                        n = n + 1;
                        continue;
                    }
                                            
                    if (diff > 1) {
                        diff = 0;
                        break;
                    }                    
                }
            }
        }
        
        return result;
    }
}