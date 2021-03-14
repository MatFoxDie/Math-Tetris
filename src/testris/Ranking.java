package testris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Ranking extends JFrame implements ActionListener{
	
	JLabel titulo;
	JLabel titulo1,titulo2;
	JLabel fundo;
	public static String usuario;
	JLabel rotulo[] = new JLabel[3];
	
	JButton botao[] = new JButton[6];
	
	JLabel nomes[] = new JLabel[20];
	
	JLabel dificuldade[] = new JLabel[20];
	JLabel pontos[] = new JLabel[20];
	
	static AudioPlayer MGP = AudioPlayer.player;
	static AudioStream BGM;
	static AudioStream BGM1;
	AudioData MD;
	
	JTextField campo[] = new JTextField[2];
	JPasswordField pw = new JPasswordField();
	JButton b [] [];
	int m = 10;
	int y=0;
	int n = 20;
	int dif;
	int z =30;
	public Ranking() {
		setSize(500,500); 
		
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
		setVisible(true);
		setForeground(new Color(47,79,79));
		
		music();

	}
           
           
          
	
	private void init() {
		
		JLabel caixa = new JLabel();
		caixa.setBounds(50,50, 400, 350);
		caixa.setBackground(new Color(11, 92, 95)); 
		caixa.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.GRAY));
		caixa.setOpaque(true);
		
		 titulo = new JLabel();
		 		
		titulo.setBounds((this.getWidth() / 3)-100,30, 500, 75);
		
		titulo.setText("Jogador");
		titulo.setFont( new Font("Arial", Font.BOLD, 20 ) );
		titulo.setForeground(new Color(255, 179, 4));
		
		add(titulo);
		
		 titulo1 = new JLabel();
	 		
			titulo1.setBounds((this.getWidth() / 3)+30,30, 500, 75);
			
			titulo1.setText("Dificuldade");
			titulo1.setFont( new Font("Arial", Font.BOLD, 20 ) );
			titulo1.setForeground(new Color(255, 179, 4));
			
			add(titulo1);
		
			 titulo2 = new JLabel();
		 		
				titulo2.setBounds((this.getWidth() / 3)+180,30, 500, 75);
				
				titulo2.setText("Pontos");
				titulo2.setFont( new Font("Arial", Font.BOLD, 20 ) );
				titulo2.setForeground(new Color(255, 179, 4));
				
				add(titulo2);
				
				for(int i=0; i<10; i++) {
					nomes[i] = new JLabel();
					nomes[i].setBounds((this.getWidth() / 3)-100,z+30, 500, 75);
					nomes[i].setText("a");
					nomes[i].setFont( new Font("Arial", Font.BOLD, 20 ) );
					nomes[i].setForeground(new Color(255, 179, 4));
					
					add(nomes[i]);
					z=z+22;
				}
				z =30;
				for(int i=0; i<10; i++) {
					dificuldade[i] = new JLabel();
					dificuldade[i].setBounds((this.getWidth() / 3)+30,z+30, 500, 75);
					dificuldade[i].setText("a");
					dificuldade[i].setFont( new Font("Arial", Font.BOLD, 20 ) );
					dificuldade[i].setForeground(new Color(255, 179, 4));
					
					add(dificuldade[i]);
					z=z+22;
				}
				
				z =30;
				for(int i=0; i<10; i++) {
					pontos[i] = new JLabel();
					pontos[i].setBounds((this.getWidth() / 3)+180,z+30, 500, 75);
					pontos[i].setText("a");
					pontos[i].setFont( new Font("Arial", Font.BOLD, 20 ) );
					pontos[i].setForeground(new Color(255, 179, 4));
					
					add(pontos[i]);
					z=z+22;
				}
				
		botao[0] = new JButton();
		
		
		botao[0].setBounds(caixa.getX() + 120, caixa.getY() + 275, 150, 70);
		botao[0].setText("Voltar");
		botao[0].setOpaque(true);
		botao[0].setBackground(new Color(255, 211, 114));
		
		botao[0].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
		
		botao[0].addActionListener(this);
		add(botao[0]);
		
		
		botao[2] = new JButton();
		
		botao[2].setBounds(botao[0].getX(), botao[0].getY(), 200, 70);
		botao[2].setText("Easy");
		botao[2].setOpaque(true);
		botao[2].setVisible(false);
		botao[2].setBackground(new Color(255, 211, 114));
		
		botao[2].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
		
		botao[2].addActionListener(this);
		add(botao[2]);
		
		botao[3] = new JButton();
		
		botao[3].setBounds(botao[0].getX(), botao[0].getY() + 90, 200, 70);
		botao[3].setText("Normal");
		botao[3].setOpaque(true);
		botao[3].setVisible(false);
		botao[3].setBackground(new Color(255, 211, 114));
		
		botao[3].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
		
		botao[3].addActionListener(this);
		add(botao[3]);
		
		botao[4] = new JButton();
		
		botao[4].setBounds(botao[0].getX(), botao[0].getY() + 180, 200, 70);
		botao[4].setText("Hard");
		botao[4].setOpaque(true);
		botao[4].setVisible(false);
		botao[4].setBackground(new Color(255, 211, 114));
		botao[4].setVisible(false);
		botao[4].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
		
		botao[4].addActionListener(this);
		add(botao[4]);
		
		
		
		add(caixa);
		
		
		
		
		 b = new JButton [m][n];
	        for (int y = 0;y<n;y=y+1){  
	            for (int x = 0;x<m;x++){  
	                    b[x][y] = new JButton();  
	                   
	                    b[x][y].setBackground(Color.DARK_GRAY);  
	                    add(b[x][y]);  
	                    b[x][y].setEnabled(false);  
	                    b[x][y].setText("");
	                    
		 //BOTÕES
	            }
	        }
   

	
    
    
    
    b[0][y].setBounds(10, 10, 45, 40);	
    b[1][y].setBounds(55, 10, 45, 40);	
    b[2][y].setBounds(100, 10, 45, 40);	
    b[3][y].setBounds(145, 10, 45, 40);	
    b[4][y].setBounds(190, 10, 45, 40);	
    b[5][y].setBounds(235, 10, 45, 40);	
    b[6][y].setBounds(280, 10, 45, 40);	
    b[7][y].setBounds(325, 10, 45, 40);	
    b[8][y].setBounds(370, 10, 45, 40);	
    b[9][y].setBounds(415, 10, 45, 40);	
   
    y++;
    b[0][y].setBounds(10, 50, 45, 40);	
    b[1][y].setBounds(55, 50, 45, 40);	
    b[2][y].setBounds(100, 50, 45, 40);	
    b[3][y].setBounds(145, 50, 45, 40);	
    b[4][y].setBounds(190, 50, 45, 40);	
    b[5][y].setBounds(235, 50, 45, 40);	
    b[6][y].setBounds(280, 50, 45, 40);	
    b[7][y].setBounds(325, 50, 45, 40);	
    b[8][y].setBounds(370, 50, 45, 40);	
    b[9][y].setBounds(415, 50, 45, 40);	
    y++;
  
    b[0][y].setBounds(10, 90, 45, 40);		
    b[1][y].setBounds(55, 90, 45, 40);		
    b[2][y].setBounds(100, 90, 45, 40);		
    b[3][y].setBounds(145, 90, 45, 40);		
    b[4][y].setBounds(190, 90, 45, 40);		
    b[5][y].setBounds(235, 90, 45, 40);		
    b[6][y].setBounds(280, 90, 45, 40);		
    b[7][y].setBounds(325, 90, 45, 40);		
    b[8][y].setBounds(370, 90, 45, 40);	
    b[9][y].setBounds(415, 90, 45, 40);	
    y++;
    b[0][y].setBounds(10, 130, 45, 40);		
    b[1][y].setBounds(55, 130, 45, 40);		
    b[2][y].setBounds(100, 130, 45, 40);		
    b[3][y].setBounds(145, 130, 45, 40);		
    b[4][y].setBounds(190, 130, 45, 40);		
    b[5][y].setBounds(235, 130, 45, 40);		
    b[6][y].setBounds(280, 130, 45, 40);		
    b[7][y].setBounds(325, 130, 45, 40);		
    b[8][y].setBounds(370, 130, 45, 40);	
    b[9][y].setBounds(415, 130, 45, 40);	
    y++;
    b[0][y].setBounds(10, 170, 45, 40);		
    b[1][y].setBounds(55, 170, 45, 40);		
    b[2][y].setBounds(100, 170, 45, 40);		
    b[3][y].setBounds(145, 170, 45, 40);		
    b[4][y].setBounds(190, 170, 45, 40);		
    b[5][y].setBounds(235, 170, 45, 40);		
    b[6][y].setBounds(280, 170, 45, 40);		
    b[7][y].setBounds(325, 170, 45, 40);		
    b[8][y].setBounds(370, 170, 45, 40);	
    b[9][y].setBounds(415, 170, 45, 40);	
    y++;
    b[0][y].setBounds(10, 210, 45, 40);		
    b[1][y].setBounds(55, 210, 45, 40);		
    b[2][y].setBounds(100, 210, 45, 40);		
    b[3][y].setBounds(145, 210, 45, 40);		
    b[4][y].setBounds(190, 210, 45, 40);		
    b[5][y].setBounds(235, 210, 45, 40);		
    b[6][y].setBounds(280, 210, 45, 40);		
    b[7][y].setBounds(325, 210, 45, 40);		
    b[8][y].setBounds(370, 210, 45, 40);	
    b[9][y].setBounds(415, 210, 45, 40);	
    y++;
    b[0][y].setBounds(10, 250, 45, 40);		
    b[1][y].setBounds(55, 250, 45, 40);		
    b[2][y].setBounds(100, 250, 45, 40);		
    b[3][y].setBounds(145, 250, 45, 40);		
    b[4][y].setBounds(190, 250, 45, 40);		
    b[5][y].setBounds(235, 250, 45, 40);		
    b[6][y].setBounds(280, 250, 45, 40);		
    b[7][y].setBounds(325, 250, 45, 40);		
    b[8][y].setBounds(370, 250, 45, 40);
    b[9][y].setBounds(415, 250, 45, 40);	
    y++;
    b[0][y].setBounds(10, 290, 45, 40);		
    b[1][y].setBounds(55, 290, 45, 40);		
    b[2][y].setBounds(100, 290, 45, 40);		
    b[3][y].setBounds(145, 290, 45, 40);		
    b[4][y].setBounds(190, 290, 45, 40);		
    b[5][y].setBounds(235, 290, 45, 40);		
    b[6][y].setBounds(280, 290, 45, 40);		
    b[7][y].setBounds(325, 290, 45, 40);		
    b[8][y].setBounds(370, 290, 45, 40);
    b[9][y].setBounds(415, 290, 45, 40);	
    y++;
    b[0][y].setBounds(10, 330, 45, 40);		
    b[1][y].setBounds(55, 330, 45, 40);		
    b[2][y].setBounds(100, 330, 45, 40);		
    b[3][y].setBounds(145, 330, 45, 40);		
    b[4][y].setBounds(190, 330, 45, 40);		
    b[5][y].setBounds(235, 330, 45, 40);		
    b[6][y].setBounds(280, 330, 45, 40);		
    b[7][y].setBounds(325, 330, 45, 40);		
    b[8][y].setBounds(370, 330, 45, 40);
    b[9][y].setBounds(415, 330, 45, 40);	
    y++;
    b[0][y].setBounds(10, 370, 45, 40);		
    b[1][y].setBounds(55, 370, 45, 40);		
    b[2][y].setBounds(100, 370, 45, 40);		
    b[3][y].setBounds(145, 370, 45, 40);		
    b[4][y].setBounds(190, 370, 45, 40);		
    b[5][y].setBounds(235, 370, 45, 40);		
    b[6][y].setBounds(280, 370, 45, 40);		
    b[7][y].setBounds(325, 370, 45, 40);		
    b[8][y].setBounds(370, 370, 45, 40);
    b[9][y].setBounds(415, 370, 45, 40);	
    y++;
    b[0][y].setBounds(10, 410, 45, 40);		
    b[1][y].setBounds(55, 410, 45, 40);		
    b[2][y].setBounds(100, 410, 45, 40);		
    b[3][y].setBounds(145, 410, 45, 40);		
    b[4][y].setBounds(190, 410, 45, 40);		
    b[5][y].setBounds(235, 410, 45, 40);		
    b[6][y].setBounds(280, 410, 45, 40);		
    b[7][y].setBounds(325, 410, 45, 40);		
    b[8][y].setBounds(370, 410, 45, 40);
    b[9][y].setBounds(415, 410, 45, 40);	
    y++;
    b[0][y].setBounds(10, 450, 45, 40);		
    b[1][y].setBounds(55, 450, 45, 40);		
    b[2][y].setBounds(100, 450, 45, 40);		
    b[3][y].setBounds(145, 450, 45, 40);		
    b[4][y].setBounds(190, 450, 45, 40);		
    b[5][y].setBounds(235, 450, 45, 40);		
    b[6][y].setBounds(280, 450, 45, 40);		
    b[7][y].setBounds(325, 450, 45, 40);		
    b[8][y].setBounds(370, 450, 45, 40);
    b[9][y].setBounds(415, 450, 45, 40);	
    y++;
    b[0][y].setBounds(10, 490, 45, 40);		
    b[1][y].setBounds(55, 490, 45, 40);		
    b[2][y].setBounds(100, 490, 45, 40);		
    b[3][y].setBounds(145, 490, 45, 40);		
    b[4][y].setBounds(190, 490, 45, 40);		
    b[5][y].setBounds(235, 490, 45, 40);		
    b[6][y].setBounds(280, 490, 45, 40);		
    b[7][y].setBounds(325, 490, 45, 40);		
    b[8][y].setBounds(370, 490, 45, 40);
    b[9][y].setBounds(415, 490, 45, 40);	
    y++;
    b[0][y].setBounds(10, 530, 45, 40);		
    b[1][y].setBounds(55, 530, 45, 40);		
    b[2][y].setBounds(100, 530, 45, 40);		
    b[3][y].setBounds(145, 530, 45, 40);		
    b[4][y].setBounds(190, 530, 45, 40);		
    b[5][y].setBounds(235, 530, 45, 40);		
    b[6][y].setBounds(280, 530, 45, 40);		
    b[7][y].setBounds(325, 530, 45, 40);		
    b[8][y].setBounds(370, 530, 45, 40);
    b[9][y].setBounds(415, 530, 45, 40);	
    y++;
    b[0][y].setBounds(10, 570, 45, 40);		
    b[1][y].setBounds(55, 570, 45, 40);		
    b[2][y].setBounds(100, 570, 45, 40);		
    b[3][y].setBounds(145, 570, 45, 40);		
    b[4][y].setBounds(190, 570, 45, 40);		
    b[5][y].setBounds(235, 570, 45, 40);		
    b[6][y].setBounds(280, 570, 45, 40);		
    b[7][y].setBounds(325, 570, 45, 40);		
    b[8][y].setBounds(370, 570, 45, 40);
    b[9][y].setBounds(415, 570, 45, 40);	
    y++;
    b[0][y].setBounds(10, 610, 45, 40);		
    b[1][y].setBounds(55, 610, 45, 40);		
    b[2][y].setBounds(100, 610, 45, 40);		
    b[3][y].setBounds(145, 610, 45, 40);		
    b[4][y].setBounds(190, 610, 45, 40);		
    b[5][y].setBounds(235, 610, 45, 40);		
    b[6][y].setBounds(280, 610, 45, 40);		
    b[7][y].setBounds(325, 610, 45, 40);		
    b[8][y].setBounds(370, 610, 45, 40);
    b[9][y].setBounds(415, 610, 45, 40);	
    y++;
    b[0][y].setBounds(10, 650, 45, 40);		
    b[1][y].setBounds(55, 650, 45, 40);		
    b[2][y].setBounds(100, 650, 45, 40);		
    b[3][y].setBounds(145, 650, 45, 40);		
    b[4][y].setBounds(190, 650, 45, 40);		
    b[5][y].setBounds(235, 650, 45, 40);		
    b[6][y].setBounds(280, 650, 45, 40);		
    b[7][y].setBounds(325, 650, 45, 40);		
    b[8][y].setBounds(370, 650, 45, 40);
    b[9][y].setBounds(415, 650, 45, 40);	
    y++;
    b[0][y].setBounds(10, 690, 45, 40);		
    b[1][y].setBounds(55, 690, 45, 40);		
    b[2][y].setBounds(100, 690, 45, 40);		
    b[3][y].setBounds(145, 690, 45, 40);		
    b[4][y].setBounds(190, 690, 45, 40);		
    b[5][y].setBounds(235, 690, 45, 40);		
    b[6][y].setBounds(280, 690, 45, 40);		
    b[7][y].setBounds(325, 690, 45, 40);		
    b[8][y].setBounds(370, 690, 45, 40);
    b[9][y].setBounds(415, 690, 45, 40);	
    y++;
    b[0][y].setBounds(10, 730, 45, 40);		
    b[1][y].setBounds(55, 730, 45, 40);		
    b[2][y].setBounds(100, 730, 45, 40);		
    b[3][y].setBounds(145, 730, 45, 40);		
    b[4][y].setBounds(190, 730, 45, 40);		
    b[5][y].setBounds(235, 730, 45, 40);		
    b[6][y].setBounds(280, 730, 45, 40);		
    b[7][y].setBounds(325, 730, 45, 40);		
    b[8][y].setBounds(370, 730, 45, 40);
    b[9][y].setBounds(415, 730, 45, 40);	
    y++;
    b[0][y].setBounds(10, 770, 45, 40);		
    b[1][y].setBounds(55, 770, 45, 40);		
    b[2][y].setBounds(100, 770, 45, 40);		
    b[3][y].setBounds(145, 770, 45, 40);		
    b[4][y].setBounds(190, 770, 45, 40);		
    b[5][y].setBounds(235, 770, 45, 40);		
    b[6][y].setBounds(280, 770, 45, 40);		
    b[7][y].setBounds(325, 770, 45, 40);		
    b[8][y].setBounds(370, 770, 45, 40);
    b[9][y].setBounds(415, 770, 45, 40);
    
    JButton tela = new JButton();
    tela.setBounds(415, 770, 45, 40); 

    tela.setBackground(Color.DARK_GRAY);  
    add(tela);  
    tela.setEnabled(false);  
    tela.setText("");
    
    

	
	fundo = new JLabel();
		fundo.setBounds(0, 0, getWidth(), getHeight());
		fundo.setOpaque(true);
		fundo.setBackground(Color.DARK_GRAY); 
		
		add(fundo);
}
	 public static void music() 
	   {       
	     
	       ContinuousAudioDataStream loop = null;
	      

	       try
	       {
	           InputStream test = new FileInputStream("tetris.wav");
	           BGM = new AudioStream(test);
	           AudioPlayer.player.start(BGM);
	           //MD = BGM.getData();
	           //loop = new ContinuousAudioDataStream(MD);
	          

	       }
	      
	       catch(FileNotFoundException e){
	           System.out.print(e.toString());
	       }
	       catch(IOException error)
	       {
	           System.out.print(error.toString());
	       }
	       MGP.start(loop);
	   }

@Override
public void actionPerformed(ActionEvent e) {
	
	if (e.getSource().equals(botao[0])) {
		this.setVisible(false);
		AudioPlayer.player.stop(BGM);	
		new Tetris();
		
		
	}
	
	if (e.getSource().equals(botao[1])) {
		botao[0].setVisible(false);
		botao[1].setVisible(false);
		botao[4].setVisible(true);
	}
	if (e.getSource().equals(botao[2])){
		dif = 1;
		
	}
	
	
}
}
