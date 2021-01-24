public class LeetCode393 {
    public boolean validUtf8(int[] data) {


        for(int i=0; i<data.length; ) {
            int curr = data[i];
            System.out.println(curr);

            int numHead = checkHead(curr);

            if (numHead == 0) {
                i++;
                continue;
            }

            if(numHead == 1) {
                return false;
            }

            if (i + numHead > data.length) {
                return false;
            }



            if (numHead >= 0 && numHead <=4) {
                for (int j=i+1; j<i+numHead; j++) {
                    if (checkFollow(data[j]) == false) {
                        return false;
                    }
                }
            } else {
                return false;
            }

            i += numHead;

        }

        return true;
    }

    public int checkHead(int num) {
        // check how many ones in head byte
        int mask = 1<<7;
        int number = 0;
        while((num & mask) > 0) {
            number++;
            mask = mask >> 1;
        }

        return number;
    }

    public boolean checkFollow(int num) {
        // check if it is a valid following byte
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;

        if ((num & mask1) > 0 && (num & mask2) == 0) {
            return true;
        } else {
            return false;
        }
    }
}

