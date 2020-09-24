package bin;

import java.nio.charset.StandardCharsets;

public class Utils {

	// takes 16 numbers seperated by spaces
   static public byte[] tokenize(String s){
      String[] tokens = s.split(" ");
      byte[] result = new byte[16];
      result[0] = (byte) Integer.parseInt(tokens[15]);
      for (int i=0; i<15; i++)
         result[i+1] = (byte) Integer.parseInt(tokens[i]);
      return result;
   }

	static public String encode(byte[] state){
      return new String(state, StandardCharsets.UTF_8);
   }

}
