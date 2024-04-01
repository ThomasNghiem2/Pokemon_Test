import java.io.*;
import java.lang.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static java.lang.ProcessBuilder.*;

public class Map {

	private final MoveModel moveModel;
	private final Showvisible showvisible;
	boolean xCheck;
	boolean yCheck;

	public Map() {
		moveModel = new MoveModel();
		showvisible = new Showvisible(moveModel);
		//showvisible.getRndMoverButton().addActionListener(e-> movePlayer());
		showvisible.getMoveNorthButton().addActionListener(e-> {
			try {
				movePlayerUp(50);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		showvisible.getMoveEastButton().addActionListener(e-> {
			try {
				movePlayerRight(50);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		showvisible.getMoveSouthButton().addActionListener(e-> {
			try {
				movePlayerDown(50);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		showvisible.getMoveWestButton().addActionListener(e-> {
			try {
				movePlayerLeft(50);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	//move player to a random position (works fine)
	// private void movePlayer() {
	// 	final Random rnd = new Random();
	// 	moveModel.setPlayerX(rnd.nextInt(100));
	// 	moveModel.setPlayerY(rnd.nextInt(100));
	// 	showvisible.refresh();
	// }

	private void checkCollision(MoveModel obj1) throws IOException {
		if (obj1.playerX == obj1.computerX && obj1.playerY == obj1.computerY) {
			System.out.println("\033[H\033[2J");
			System.out.flush();
			ProcessBuilder pb = new ProcessBuilder("bash", "Game.sh");
			pb.inheritIO();
			pb.start();
		}
	}
	//Move player in the x direction to the East (positive) or west (negative 
	private void movePlayerLeft(final int distance) throws IOException {
		if (moveModel.getPlayerX() == moveModel.getSquareSize()/4) {
			return;
		}
		moveModel.setPlayerX(moveModel.getPlayerX()-distance);
		showvisible.refresh();
		checkCollision(moveModel);
		System.out.println(moveModel.playerX + ", " + moveModel.playerY + "\n" + moveModel.computerX + ", " + moveModel.computerY);
	}

	private void movePlayerRight(final int distance) throws IOException {
		if (moveModel.getPlayerX() == (moveModel.getSquareSize()/4 + 50*(moveModel.getBoardCols()-1))) {
			return;
		}
		moveModel.setPlayerX(moveModel.getPlayerX()+distance);
		showvisible.refresh();
		checkCollision(moveModel);
		System.out.println(moveModel.playerX + ", " + moveModel.playerY + "\n" + moveModel.computerX + ", " + moveModel.computerY);
	}

	private void movePlayerUp(final int distance) throws IOException {
		if (moveModel.getPlayerY() == moveModel.getSquareSize()/4) {
			return;
		}
		moveModel.setPlayerY(moveModel.getPlayerY()-distance);
		showvisible.refresh();
		checkCollision(moveModel);
		System.out.println(moveModel.playerX + ", " + moveModel.playerY + "\n" + moveModel.computerX + ", " + moveModel.computerY);
	}

	private void movePlayerDown(final int distance) throws IOException {
		if (moveModel.getPlayerY() == (moveModel.getSquareSize()/4 + 50*(moveModel.getBoardRows()-1))) {
			return;
		}
		moveModel.setPlayerY(moveModel.getPlayerY()+distance);
		showvisible.refresh();
		checkCollision(moveModel);
		System.out.println(moveModel.playerX + ", " + moveModel.playerY + "\n" + moveModel.computerX + ", " + moveModel.computerY);
	}

	public static void main(final String[] args) {
		new Map();
	}
}

class Showvisible {

	private final static int GAP = 2;
	MoveModel MoveModel;
	private MainPanel mainPanel;

	Showvisible(final MoveModel MoveModel){
		this.MoveModel = MoveModel;
		createAndShowGUI();
	}

	void refresh() {
		mainPanel.repaint();
	}

	private void createAndShowGUI() {
		final JFrame board = new JFrame("Single Player Game");
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new MainPanel();
		board.add(mainPanel);
		board.pack();
		board.setVisible(true);
	}

	//JButton getRndMoverButton() {   return mainPanel.getRndMoverButton();   }
	JButton getMoveNorthButton() { return mainPanel.getMoveNorthButton(); }
	JButton getMoveEastButton() { return mainPanel.getMoveEastButton(); }
	JButton getMoveSouthButton() { return mainPanel.getMoveSouthButton(); }
	JButton getMoveWestButton() { return mainPanel.getMoveWestButton(); }

	class MainPanel extends JPanel {

		private final BottomPanel bPanel;

		MainPanel() {
			setLayout(new BorderLayout(GAP,GAP));
			add(new TopPanel(), BorderLayout.PAGE_START);
			add(new BoardPanel(), BorderLayout.CENTER);
			bPanel = new BottomPanel();
			add(bPanel, BorderLayout.PAGE_START);
		}

		//JButton getRndMoverButton() {   return bPanel.getRndMoverButton();  }
		JButton getMoveNorthButton() { return bPanel.getMoveNorthButton(); }
		JButton getMoveEastButton() { return bPanel.getMoveEastButton(); }
		JButton getMoveSouthButton() { return bPanel.getMoveSouthButton(); }
		JButton getMoveWestButton() { return bPanel.getMoveWestButton(); }
		

	}

	class TopPanel extends JPanel {
		TopPanel() {
			setLayout(new FlowLayout(FlowLayout.CENTER));
			add(new JLabel("This is an amazing game "));
		}
	}

	class BoardPanel extends JPanel {

		Player player;
		Computer computer;

		BoardPanel()   {

			setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
			final GridLayout layout = new GridLayout(MoveModel.getBoardRows(),
					MoveModel.getBoardCols());
			setLayout(layout);

			for (int i = 0; i <MoveModel.getBoardRows(); i++)   {

				for (int j = 0; j < MoveModel.getBoardCols(); j++)  {
					add(new Tile());
				}
			}

			player = new Player();
			player.setBounds(new Rectangle(1000,1000, 1000,1000));
			computer = new Computer();
			computer.setBounds(new Rectangle(1000,1000, 1000,1000));
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			player.paint(g);
			computer.paint(g);
		}
	}

	class Tile extends JLabel {

		Tile() {
			setPreferredSize(new Dimension(MoveModel.getSquareSize(), MoveModel.getSquareSize()));
			setBorder(BorderFactory.createLineBorder(Color.GRAY, GAP));
		}
	}

	class Player extends JLabel{

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(MoveModel.getPlayerX(), MoveModel.getPlayerY(), MoveModel.getPlayerSize(),MoveModel.getPlayerSize());
		}
	}

	class Computer extends JLabel{
		
		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.fillRect(MoveModel.getComputerX(), MoveModel.getComputerY(), MoveModel.getPlayerSize(),MoveModel.getPlayerSize());
		}
	}

	class BottomPanel extends JPanel {

		//JButton rndMoveButton = new JButton("Random Move");
		JButton moveNorthButton =new JButton("Move North");
		JButton moveEastButton =new JButton("Move East");
		JButton moveSouthButton =new JButton("Move South");
		JButton moveWestButton =new JButton("Move West");


		BottomPanel(){
			//add(rndMoveButton);
			add(moveNorthButton);
			add(moveEastButton);
			add(moveSouthButton);
			add(moveWestButton);

		}

		//JButton getRndMoverButton() {   return rndMoveButton;  }
		JButton getMoveNorthButton() { return moveNorthButton; }
		JButton getMoveEastButton() { return moveEastButton; }
		JButton getMoveSouthButton() { return moveSouthButton; }
		JButton getMoveWestButton() { return moveWestButton; }
	}
}

class MoveModel{

	private final int boardRows = 9, boardCols = 9, squareSize = 50;
	int playerX = squareSize/4;
	int playerY = 50*(boardRows/2) + squareSize/4;
	int computerX = squareSize/4 + 50*(boardCols-1);
	int computerY = 50*(boardRows/2) + squareSize/4;
	private final int playerSize =25;
	int getPlayerX() {  return playerX; }

	int getComputerX() {  return computerX; }

	void setPlayerX(final int playerX) {  this.playerX = playerX; }

	int getPlayerY() {return playerY; }

	int getComputerY() {return computerY; }

	void setPlayerY(final int playerY) {  this.playerY = playerY; }

	int getPlayerSize() {return playerSize; }

	int getBoardRows() {return boardRows; }

	int getBoardCols() {return boardCols; }

	int getSquareSize() {return squareSize; }
}
