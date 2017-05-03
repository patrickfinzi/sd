import java.util.logging.Level;
import java.util.logging.Logger;

class sd extends Thread{
	static String str = "abcdefghijklmnopqrstuvwxyz-abcdefghijklmnopqrstuvwxyz-abcdefghijklmnopqrstuvwxyz";
	static char[] nova_str = new char[str.length()];
	static int pos=0;

	public void run(){
		//nova_str[pos]=Character.toUpperCase(str.charAt(pos));		
		if(pos<str.length()){
			nova_str[pos]=Character.toUpperCase(str.charAt(pos));	
                	//System.out.println(str.charAt(pos)+" -> "+ nova_str[pos]);
                }	
	}

	public static void main(String args[]){
		int i;
		sd vet[] = new sd[30];
		for(i=0;i<vet.length;i++){
			vet[i]=new sd();
		}		
		for(i=0;i<vet.length;i++){
			if(pos>=30)			
				vet[i].run();
			else
				vet[i].start();
			if(i==29 && pos<80)
				i=0;
			if(pos==str.length()-1)
				i=100;
			pos++;
		}
		String str2 = new String(sd.nova_str);
		System.out.printf(sd.str);
		System.out.println("\n");
		System.out.printf(str2);
		System.out.println("\n");
	}
}
