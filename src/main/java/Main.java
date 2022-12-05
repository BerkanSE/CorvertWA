public class Main {
    public static void main(String[] args) {
        String utf = "There was a system error. We’re on it, but you'll have to try again later.";

        // convert the input string to a character array
        char[] chars = utf.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++)
        {
            int unipoint = Character.codePointAt(chars, i);
            if ((unipoint < 32) || (unipoint > 127))
            {
                StringBuilder hexString = new StringBuilder();
                for (int k = 0; k < 4; k++) // 4 times to build a 4-digit hex
                {
                    hexString.insert(0, Integer.toHexString(unipoint % 16));
                    unipoint = unipoint / 16;
                }
                sb.append("\\u"+hexString);
            }
            else
            {
                sb.append(chars[i]);
            }
        }

        // display the ASCII encoded string
        System.out.println ("String s = " + sb.toString());
    }
}
