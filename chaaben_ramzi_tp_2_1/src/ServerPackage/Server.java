package ServerPackage;
import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[]args)  {
		try {
		System.out.println("je suis un serveur");
		ServerSocket serverSocket=new ServerSocket(1234);
		System.out.println("waiting");
		Socket socket=serverSocket.accept();
		System.out.println("connected");
		InputStream is = socket.getInputStream();
		OutputStream os=socket.getOutputStream();
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int nb1= Integer.parseInt(br.readLine());
		System.out.println(nb1);
		int nb2=Integer.parseInt(br.readLine());
		System.out.println(nb2);
		String op=br.readLine();
		System.out.println(op);
		int res=0;
		switch(op) {
		case "+":
			res=nb1+nb2;
			break;
		case "-":
			res=nb1-nb2;
			break;
		case "*":
			res=nb1*nb2;
			break;
		case "/":
			res= nb1/nb2;
			break;
		}
		PrintWriter pw= new PrintWriter(os,true);
		System.out.println(res);
		pw.println(Integer.toString(res));
		serverSocket.close();
	}catch(IOException e){
		e.printStackTrace();
	}
		}

	}