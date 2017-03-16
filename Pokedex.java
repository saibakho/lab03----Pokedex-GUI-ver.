import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Pokedex
{
//= global objects ==========================================
	private static ArrayList<PokemonData> pokeList;
	private static int index;
	private static int pokeNum;
//= global objects ==========================================
	public static void main(String[] args) throws Exception
	{
		scanData("PokeDataBase");

		index = 0;

		// label
		JLabel pic = new JLabel();
		pic.setBounds(10, 10, 475, 475); 
		pic.setIcon(new ImageIcon("pic/" + pokeList.get(index).name + ".png"));

		JLabel idT = new JLabel("ID :", JLabel.CENTER);
		idT.setBounds(10, 495, 200, 60);
		idT.setFont(new Font("Consolas", Font.BOLD, 28));

		JLabel nameT = new JLabel("NAME :", JLabel.CENTER);
		nameT.setBounds(10, 565, 200, 60);
		nameT.setFont(new Font("Consolas", Font.BOLD, 28));
		
		JLabel typeT = new JLabel("TYPE :", JLabel.CENTER);
		typeT.setBounds(10, 635, 200, 60);
		typeT.setFont(new Font("Consolas", Font.BOLD, 28));

		JLabel idR = new JLabel(new String("" + pokeList.get(index).id), JLabel.CENTER);
		idR.setBounds(220, 495, 265, 60);
		idR.setFont(new Font("Consolas", Font.BOLD, 28));

		JLabel nameR = new JLabel(pokeList.get(index).name, JLabel.CENTER);
		nameR.setBounds(220, 565, 265, 60);
		nameR.setFont(new Font("Consolas", Font.BOLD, 28));
		
		JLabel typeR = new JLabel(pokeList.get(index).type, JLabel.CENTER);
		typeR.setBounds(220, 635, 265, 60);
		typeR.setFont(new Font("Consolas", Font.BOLD, 28));
		// buttons
		JButton prev = new JButton("Previous");
		prev.setBounds(10, 705, 232, 60);
		prev.setFont(new Font("Consolas", Font.BOLD, 28));
		prev.addActionListener (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					index = (index+pokeNum-1)%pokeNum;
					idR.setText(new String("" + pokeList.get(index).id));
					nameR.setText(pokeList.get(index).name);
					typeR.setText(pokeList.get(index).type);
					pic.setIcon(new ImageIcon("pic/" + pokeList.get(index).name + ".png"));
					}	}	);
		
		JButton next = new JButton("Next");
		next.setBounds(252, 705, 232, 60);
		next.setFont(new Font("Consolas", Font.BOLD, 28));
		next.addActionListener (
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					index = (index+1)%pokeNum;
					idR.setText(new String("" + pokeList.get(index).id));
					nameR.setText(pokeList.get(index).name);
					typeR.setText(pokeList.get(index).type);
					pic.setIcon(new ImageIcon("pic/" + pokeList.get(index).name + ".png"));
					}	}	);

		// frame
		JFrame frame = new JFrame("Pokedex");
		frame.setSize(515, 830);		// width, heigh
		frame.setLayout(null);		//using no layout managers
		frame.setVisible(true);		//making the frame visible

		frame.add(pic);		//adding button in JFrame
		frame.add(idT);
		frame.add(idR);
		frame.add(nameT);
		frame.add(typeT);
		frame.add(nameR);
		frame.add(typeR);
		frame.add(prev);
		frame.add(next);
//======================================================
	}
	private static void scanData(String filename) throws Exception
	{
		File file = new File(filename);
		Scanner fstream = new Scanner(file);
		pokeList = new ArrayList<PokemonData>();
		pokeNum = fstream.nextInt();

		for (int i = 0; i < pokeNum; i++) {
			PokemonData pokeTemp = new PokemonData("", "");

			pokeTemp.id = fstream.nextInt();
			System.out.println(pokeTemp.id);

			pokeTemp.name = fstream.next();
			System.out.println(pokeTemp.name);

			pokeTemp.type = fstream.next();
			System.out.println(pokeTemp.type);
			System.out.println("===================");
			pokeList.add(pokeTemp);
		}
	}
}

