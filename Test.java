package testpack1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Test {

	public static void main(String[] args) {

		// instantiate class

		Lift lift1 = new Lift(1, 6, 0, 4);
		Lift lift2 = new Lift(4, 7, 1, 3);
		Lift lift3 = new Lift(2, 8, 0, 5);

		// lift1.move(5);

		// add and sort arraylist

		ArrayList<Lift> palace = new ArrayList<Lift>();

		palace.add(lift1);
		palace.add(lift2);
		palace.add(lift3);

		System.out.println(palace);

		palace.sort(null);

		System.out.println(palace);

		// serialization

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

		JFrame fr = new JFrame("Flow Layout");

		fr.setLayout(new FlowLayout());
		JTextArea text = new JTextArea("ready to go", 2, 10);
		text.setEditable(false);

		JButton but1 = new JButton("1");
		JButton but2 = new JButton("2");
		JButton but3 = new JButton("3");
		JButton but4 = new JButton("4");
		JButton but5 = new JButton("5");
		JButton but6 = new JButton("6");

		ActionListener listen = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String s = e.getActionCommand();
				s.getClass();
				String message = lift1.move(Integer.valueOf(s));
				text.setText(s + " floor");
				text.setText(message);
			}
		};
		but1.addActionListener(listen);
		but2.addActionListener(listen);
		but3.addActionListener(listen);
		but4.addActionListener(listen);
		but5.addActionListener(listen);
		but6.addActionListener(listen);

		fr.add(but1);
		fr.add(but2);
		fr.add(but3);
		fr.add(but4);
		fr.add(but5);
		fr.add(but6);

		fr.add(text);
		fr.setSize(500, 300);
		fr.pack();
		fr.setVisible(true);

	}
}
