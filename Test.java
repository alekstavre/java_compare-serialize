package testpack1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		// instantiate class

		Lift lift1 = new Lift(3, 6, 0, 4);
		Lift lift2 = new Lift(4, 7, 1, 3);
		Lift lift3 = new Lift(2, 8, 0, 5);

		lift1.move(5);

		// add and sort arraylist

		ArrayList<Lift> palace = new ArrayList<Lift>();

		palace.add(lift1);
		palace.add(lift2);
		palace.add(lift3);

		System.out.println(palace);

		palace.sort(null);

		System.out.println(palace);

		// serialization
		
		System.out.println("before serialization: "+lift1.toString());
		
		File liftFile = new File("liftFile.txt");
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;

		try {
			fileOut = new FileOutputStream(liftFile);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(lift1);
			System.out.println("serialized!");
		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				out.close();
				fileOut.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		// deserialization

		FileInputStream fileIn = null;
		ObjectInputStream in = null;

		try {
			fileIn = new FileInputStream(liftFile);
			in = new ObjectInputStream(fileIn);
			System.out.println("deserialized!");
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				in.close();
				fileIn.close();

			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

		System.out.println("after deserialization: "+lift1.toString());
	}

}
