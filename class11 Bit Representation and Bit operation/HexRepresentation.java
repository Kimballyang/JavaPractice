package laiofferClass11;

public class HexRepresentation {
	//Assumptions: number >= 0
	public String hex(int number){
		String prefix = "0x";
		//handle the special case of 0 first.
		if(number == 0){
			return prefix +"0";
		}
		// using StringBuilder so append operation is more efficient
		StringBuilder sb = new StringBuilder();
		while (number > 0){
			int rem = number % 16;
			if (rem < 10){
				sb.append((char)('0' + rem));
			}else{
				sb.append((char) (rem - 10 +'A'));
			}
			number >>>= 4;
		}
		//reverse it at last so in all complexity is O(n).
		return prefix + sb.reverse().toString();
	}
	

}
