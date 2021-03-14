package testris;
import java.awt.*;  
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import sun.audio.*;

import java.util.Date;
import java.util.Random;
import java.util.TimerTask;
import java.util.Timer;
import testris.Cadastro;
import testris.Usuario;
import javax.swing.*;  
   
public class Tetris extends JFrame implements KeyListener, ActionListener {

        int pos[] = {0,1};  
        boolean bottom = false;  
int n = 20;  
int m = 10;  
JButton b[][];  
Color tmp[][] = new Color[m][n];  
String txt[][] = new String [m][n];
int[][] nsoma2 = new int [m][n];
int nsoma;
int row = 0;  
int rand = 0;  
int centralx = 0;  
int bugbug = 0;
int centraly = 0;  
int deltax = 0;  
int perim[][] = new int[m+4][n+4];  
or[][][] prof = new or[4][4][7]; 
int verificacao = 1;
int numero;
int LinhaC;
int dif;
int pontinhos, pontostotalzinho;
int secondsPassed = 0;

boolean comecou = false;
boolean chamou = false;
boolean voltou = true;
boolean chamouotempo = false;
int difcron;
String nome;
JLabel cronometro = new JLabel();
JLabel timer = new JLabel();
JLabel timer2 = new JLabel();
JLabel seta = new JLabel();

String dificuldade = "";
Usuario p = new Usuario();
usuarioDAO cad = new usuarioDAO();

Font customFont;

int alet[] = {1,2,3,4,5,6,7,8,9};
static AudioPlayer MGP = AudioPlayer.player;
static AudioStream BGM;
static AudioStream BGM1;
AudioData MD;

JLabel titulo, titulo2, titulo3;
JLabel fundo;
JLabel rotulo[] = new JLabel[3];
JButton botao[] = new JButton[12];
JLabel caixa = new JLabel();
JLabel resposta = new JLabel();
JLabel pontos = new JLabel();
JLabel pontostotal = new JLabel();
JTextField campo = new JTextField();

JOptionPane soma = new JOptionPane();

//cores

Color rnd[] = {Color.red, Color.yellow, Color.cyan, Color.green, Color.white, Color.blue, Color.orange};


int rowsclrd = 0;  
public Tetris(){  
	super("Math Tetris");
        for(int a = 0;a<4;a++){  
                for(int b = 0;b<4;b++){  
                        for(int c = 0;c<7;c++){  
                                prof[a][b][c] = new or();  
                        }  
                }  
        }  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
        prof[0][0][0].x = -1;  
        prof[0][1][0].x = 0;  
        prof[0][2][0].x = 0;  
        prof[0][3][0].x = 1;  
        prof[1][0][0].x = 0;  
        prof[1][1][0].x = 0;  
        prof[1][2][0].x = -1;  
        prof[1][3][0].x = -1;  
        prof[2][0][0].x = 1;  
        prof[2][1][0].x = 0;  
        prof[2][2][0].x = 0;  
        prof[2][3][0].x = -1;  
        prof[3][0][0].x = 0;  
        prof[3][1][0].x = 0;  
        prof[3][2][0].x = 1;  
        prof[3][3][0].x = 1;  
        prof[0][0][1].x = -1;  
        prof[0][1][1].x = -1;  
        prof[0][2][1].x = 0;  
        prof[0][3][1].x = 1;  
        prof[1][0][1].x = -1;  
        prof[1][1][1].x = 0;  
        prof[1][2][1].x = 0;  
        prof[1][3][1].x = 0;  
        prof[2][0][1].x = 1;  
        prof[2][1][1].x = 1;  
        prof[2][2][1].x = 0;  
        prof[2][3][1].x = -1;  
        prof[3][0][1].x = 1;  
        prof[3][1][1].x = 0;  
        prof[3][2][1].x = 0;  
        prof[3][3][1].x = 0;  
        prof[0][0][2].x = -1;  
        prof[0][1][2].x = 0;  
        prof[0][2][2].x = 1;  
        prof[0][3][2].x = 1;  
        prof[1][0][2].x = 0;  
        prof[1][1][2].x = 0;  
        prof[1][2][2].x = 0;  
        prof[1][3][2].x = -1;  
        prof[2][0][2].x = 1;  
        prof[2][1][2].x = 0;  
        prof[2][2][2].x = -1;  
        prof[2][3][2].x = -1;  
        prof[3][0][2].x = 0;  
        prof[3][1][2].x = 0;  
        prof[3][2][2].x = 0;  
        prof[3][3][2].x = 1;  
        prof[0][0][3].x = -1;  
        prof[0][1][3].x = 0;  
        prof[0][2][3].x = 0;  
        prof[0][3][3].x = 1;  
        prof[1][0][3].x = -1;  
        prof[1][1][3].x = -1;  
        prof[1][2][3].x = 0;  
        prof[1][3][3].x = 0;  
        prof[2][0][3].x = 1;  
        prof[2][1][3].x = 0;  
        prof[2][2][3].x = 0;  
        prof[2][3][3].x = -1;  
        prof[3][0][3].x = 1;  
        prof[3][1][3].x = 1;  
        prof[3][2][3].x = 0;  
        prof[3][3][3].x = 0;  
        prof[0][0][4].x = -1;  
        prof[0][1][4].x = 0;  
        prof[0][2][4].x = 0;  
        prof[0][3][4].x = 1;  
        prof[1][0][4].x = 0;  
        prof[1][1][4].x = 0;  
        prof[1][2][4].x = -1;  
        prof[1][3][4].x = 0;  
        prof[2][0][4].x = 1;  
        prof[2][1][4].x = 0;  
        prof[2][2][4].x = 0;  
        prof[2][3][4].x = -1;  
        prof[3][0][4].x = 0;  
        prof[3][1][4].x = 0;  
        prof[3][2][4].x = 1;  
        prof[3][3][4].x = 0;  
        prof[0][0][5].x = 0;  
        prof[0][1][5].x = 0;  
        prof[0][2][5].x = 1;  
        prof[0][3][5].x = 1;  
        prof[1][0][5].x = 0;  
        prof[1][1][5].x = 0;  
        prof[1][2][5].x = 1;  
        prof[1][3][5].x = 1;  
        prof[2][0][5].x = 0;  
        prof[2][1][5].x = 0;  
        prof[2][2][5].x = 1;  
        prof[2][3][5].x = 1;  
        prof[3][0][5].x = 0;  
        prof[3][1][5].x = 0;  
        prof[3][2][5].x = 1;  
        prof[3][3][5].x = 1;  
        prof[0][0][6].x = -1;  
        prof[0][1][6].x = 0;  
        prof[0][2][6].x = 1;  
        prof[0][3][6].x = 2;  
        prof[1][0][6].x = 0;  
        prof[1][1][6].x = 0;  
        prof[1][2][6].x = 0;  
        prof[1][3][6].x = 0;  
        prof[2][0][6].x = 1;  
        prof[2][1][6].x = 0;  
        prof[2][2][6].x = -1;  
        prof[2][3][6].x = -2;  
        prof[3][0][6].x = 0;  
        prof[3][1][6].x = 0;  
        prof[3][2][6].x = 0;  
        prof[3][3][6].x = 0;  
        prof[0][0][0].y = 0;  
        prof[0][1][0].y = 0;  
        prof[0][2][0].y = 1;  
        prof[0][3][0].y = 1;  
        prof[1][0][0].y = -1;  
        prof[1][1][0].y = 0;  
        prof[1][2][0].y = 0;  
        prof[1][3][0].y = 1;  
        prof[2][0][0].y = 0;  
        prof[2][1][0].y = 0;  
        prof[2][2][0].y = -1;  
        prof[2][3][0].y = -1;  
        prof[3][0][0].y = 1;  
        prof[3][1][0].y = 0;  
        prof[3][2][0].y = 0;  
        prof[3][3][0].y = -1;  
        prof[0][0][1].y = 0;  
        prof[0][1][1].y = 1;  
        prof[0][2][1].y = 0;  
        prof[0][3][1].y = 0;  
        prof[1][0][1].y = -1;  
        prof[1][1][1].y = -1;  
        prof[1][2][1].y = 0;  
        prof[1][3][1].y = 1;  
        prof[2][0][1].y = -1;  
        prof[2][1][1].y = 0;  
        prof[2][2][1].y = 0;  
        prof[2][3][1].y = 0;  
        prof[3][0][1].y = 1;  
        prof[3][1][1].y = 1;  
        prof[3][2][1].y = 0;  
        prof[3][3][1].y = -1;  
        prof[0][0][2].y = 0;  
        prof[0][1][2].y = 0;  
        prof[0][2][2].y = 0;  
        prof[0][3][2].y = 1;  
        prof[1][0][2].y = -1;  
        prof[1][1][2].y = 0;  
        prof[1][2][2].y = 1;  
        prof[1][3][2].y = 1;  
        prof[2][0][2].y = 0;  
        prof[2][1][2].y = 0;  
        prof[2][2][2].y = 0;  
        prof[2][3][2].y = -1;  
        prof[3][0][2].y = 1;  
        prof[3][1][2].y = 0;  
        prof[3][2][2].y = -1;  
        prof[3][3][2].y = -1;  
        prof[0][0][3].y = 1;  
        prof[0][1][3].y = 1;  
        prof[0][2][3].y = 0;  
        prof[0][3][3].y = 0;  
        prof[1][0][3].y = -1;  
        prof[1][1][3].y = 0;  
        prof[1][2][3].y = 0;  
        prof[1][3][3].y = 1;  
        prof[2][0][3].y = -1;  
        prof[2][1][3].y = -1;  
        prof[2][2][3].y = 0;  
        prof[2][3][3].y = 0;  
        prof[3][0][3].y = 1;  
        prof[3][1][3].y = 0;  
        prof[3][2][3].y = 0;  
        prof[3][3][3].y = -1;  
        prof[0][0][4].y = 0;  
        prof[0][1][4].y = 0;  
        prof[0][2][4].y = 1;  
        prof[0][3][4].y = 0;  
        prof[1][0][4].y = -1;  
        prof[1][1][4].y = 0;  
        prof[1][2][4].y = 0;  
        prof[1][3][4].y = 1;  
        prof[2][0][4].y = 0;  
        prof[2][1][4].y = 0;  
        prof[2][2][4].y = -1;  
        prof[2][3][4].y = 0;  
        prof[3][0][4].y = 1;  
        prof[3][1][4].y = 0;  
        prof[3][2][4].y = 0;  
        prof[3][3][4].y = -1;  
        prof[0][0][5].y = 0;  
        prof[0][1][5].y = 1;  
        prof[0][2][5].y = 0;  
        prof[0][3][5].y = 1;  
        prof[1][0][5].y = 0;  
        prof[1][1][5].y = 1;  
        prof[1][2][5].y = 0;  
        prof[1][3][5].y = 1;  
        prof[2][0][5].y = 0;  
        prof[2][1][5].y = 1;  
        prof[2][2][5].y = 0;  
        prof[2][3][5].y = 1;  
        prof[3][0][5].y = 0;  
        prof[3][1][5].y = 1;  
        prof[3][2][5].y = 0;  
        prof[3][3][5].y = 1;  
        prof[0][0][6].y = 0;  
        prof[0][1][6].y = 0;  
        prof[0][2][6].y = 0;  
        prof[0][3][6].y = 0;  
        prof[1][0][6].y = -1;  
        prof[1][1][6].y = 0;  
        prof[1][2][6].y = 1;  
        prof[1][3][6].y = 2;  
        prof[2][0][6].y = 0;  
        prof[2][1][6].y = 0;  
        prof[2][2][6].y = 0;  
        prof[2][3][6].y = 0;  
        prof[3][0][6].y = -1;  
        prof[3][1][6].y = 0;  
        prof[3][2][6].y = 1;  
        prof[3][3][6].y = 2;  
        for (int y = 0;y<2;y++){  
        for (int x = 0;x<m+4;x++){  
        perim[x][y]= 1;  
        }}  
        for (int y = n+2;y<n+4;y++){  
                for (int x = 0;x<m+4;x++){  
                perim[x][y]= 4;  
                }}  
        for (int y = 2;y<n+2;y++){  
                for (int x = 0;x<2;x++){  
                perim[x][y]= 2;  
                }}  
        for (int y = 2;y<n+2;y++){  
                for (int x = m+2;x<m+4;x++){  
                perim[x][y]= 2;  
                }}  
        for(int y = 0;y<n+4;y++){  
                for (int x = 0;x<m+4;x++){  
                       // System.out.print(perim[x][y]);  
                }  
                
 JLabel s = new JLabel();
                
                ImageIcon icon = new ImageIcon("icon_wink.gif");
                s.setIcon( icon );  
                
        }  
        init();
            b = new JButton [m][n]; 
            
            
            //BOTÕES
           
            for (int y = 0;y<n;y=y+1){  
                for (int x = 0;x<m;x++){  
                        b[x][y] = new JButton();  
                        tmp[x][y] = Color.DARK_GRAY;  
                        b[x][y].setBackground(Color.DARK_GRAY);  
                        add(b[x][y]);  
                        b[x][y].setEnabled(false);  
                        b[x][y].setText("");
                        
                        
                }//end inner for  
        }  
            
      int y=0;
         
            
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
            
            JButton alo = new JButton();
            alo.setBounds(415, 770, 45, 40); 
 
            alo.setBackground(Color.DARK_GRAY);  
            add(alo);  
            alo.setEnabled(false);  
            alo.setText("");
            
            setFocusable(true);  
            addKeyListener(this);  
            setSize(700,850); 
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            
            if(dif == 0) {
     		   dificuldade = "Arcade";
     	   }
     	   else if(dif == 1) {
     		   dificuldade = "Facil";
     	   }
     	   else if(dif == 2) {
     		   dificuldade = "Medio";
     	   }
     	   else if(dif == 3) {
     		   dificuldade = "Dificil";
     	   }
            
            
            if(voltou == true) {
            	music();
            	
            	
            }
        //    rowcheck(); 
            chamar();
//          blockgen();  
             

            
           
             
    }//end constructor Mine()  
   
        private void init() {
        	
        	 titulo = new JLabel();
		 		
        	 try {
      		    //create the font to use. Specify the size!
      		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("8-Bit Madness.ttf")).deriveFont(30f);
      		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      		    //register the font
      		    ge.registerFont(customFont);
      		} catch (IOException e) {
      		    e.printStackTrace();
      		} catch(FontFormatException e) {
      		    e.printStackTrace();
      		}

     		titulo.setBounds(210, 180, 500, 100);
     		
     		titulo.setText("MATH TETRIS");
     		titulo.setFont(new Font("Eight-Bit Madness", Font.BOLD | Font.BOLD, 50));
     		titulo.setForeground(new Color(255, 179, 4));
     		
     		add(titulo);
     		
     		botao[0] = new JButton();
     		
     		botao[0].setBounds(titulo.getX() +43, titulo.getY() + 100, 200, 70);
     		botao[0].setText("Arcade");
     		botao[0].setOpaque(true);
     		botao[0].setBackground(new Color(255, 211, 114));
     		
     		botao[0].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
     		botao[0].addActionListener(this);
     		add(botao[0]);
     		
     		botao[1] = new JButton();
     		
     		botao[1].setBounds(botao[0].getX(), botao[0].getY() + 90, 200, 70);
     		botao[1].setText("Classic");
     		botao[1].setOpaque(true);
     		botao[1].setBackground(new Color(255, 211, 114));
     		
     		botao[1].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
     		
     		botao[1].addActionListener(this);
     		add(botao[1]);
     		
     		botao[2] = new JButton();
    		
    		botao[2].setBounds(botao[0].getX(), botao[0].getY(), 200, 70);
    		botao[2].setText("Easy");
    		botao[2].setOpaque(true);
    		botao[2].setBackground(new Color(255, 211, 114));
    		
    		botao[2].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
    		
    		botao[2].addActionListener(this);
    		add(botao[2]);
    		
    		botao[3] = new JButton();
    		
    		botao[3].setBounds(botao[0].getX(), botao[0].getY() + 90, 200, 70);
    		botao[3].setText("Normal");
    		botao[3].setOpaque(true);
    		botao[3].setBackground(new Color(255, 211, 114));
    		
    		botao[3].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
    		
    		botao[3].addActionListener(this);
    		add(botao[3]);
    		
    		botao[4] = new JButton();
    		
    		botao[4].setBounds(botao[0].getX(), botao[0].getY() + 180, 200, 70);
    		botao[4].setText("Hard");
    		botao[4].setOpaque(true);
    		botao[4].setBackground(new Color(255, 211, 114));
    		botao[4].setVisible(false);
    		botao[4].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
    		
    		botao[4].addActionListener(this);
    		add(botao[4]);
    		
    		botao[5] = new JButton();
    		
    		botao[5].setBounds(botao[0].getX() - 60, botao[0].getY() + 180, 125, 60);
    		botao[5].setText("Rules");
    		botao[5].setOpaque(true);
    		botao[5].setBackground(new Color(255, 211, 114));
    		botao[5].setVisible(true);
    		botao[5].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
    		
    		botao[5].addActionListener(this);
    		add(botao[5]);
    		
     		
    		botao[8] = new JButton();
    		
    		botao[8].setBounds(botao[5].getX() + 200, botao[5].getY(), 125, 60);
    		botao[8].setText("Exit");
    		botao[8].setOpaque(true);
    		botao[8].setBackground(new Color(255, 211, 114));
    		botao[8].setVisible(true);
    		botao[8].setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
    	
    		botao[8].addActionListener(this);
    		add(botao[8]);
    		
    		botao[11] = new JButton();
    		botao[11].setBounds(botao[5].getX()+132+1/2, cronometro.getY()+460, 60, 60);
    		botao[11].setIcon(new ImageIcon("img/ranking.png"));
    		botao[11].setOpaque(true);
    		botao[11].setVisible(true);
    		botao[11].setBackground(new Color(255, 211, 114));
    		
    		botao[11].addActionListener(this);
    		add(botao[11]);
    		
     		caixa.setBounds(150,200, 400, 350);
     		caixa.setBackground(new Color(11, 92, 95)); 
     		caixa.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.GRAY));
     		caixa.setOpaque(true);
     		add(caixa);
     		
     		campo = new JTextField();
			campo.setBounds(540, 70, 80, 40);
			campo.setForeground(new Color(255, 179, 4));
			campo.setBackground(Color.WHITE);
			campo.setFont( new Font("Eight-Bit Madness", Font.BOLD, 30) );
			campo.setOpaque(true);
		    campo.setHorizontalAlignment(JTextField.CENTER);
		    
		    
			add(campo);
			
			 titulo2 = new JLabel();
		 		
	     		titulo2.setBounds(campo.getX()-60 ,campo.getY()-90, 500, 100);
	     		
	     		titulo2.setText("DIGITE A SOMA");
	     		titulo2.setFont( new Font("Eight-Bit Madness", Font.BOLD, 30 ) );
	     		titulo2.setForeground(new Color(255, 211, 114));
	     		
	     		add(titulo2);
	     		
	     		 titulo3 = new JLabel();
			 		
		     		titulo3.setBounds(campo.getX()-40 ,campo.getY()-70, 500, 100);
		     		
		     		titulo3.setText("DOS BLOCOS ");
		     		titulo3.setFont( new Font("Eight-Bit Madness", Font.BOLD, 30 ) );
		     		titulo3.setForeground(new Color(255, 211, 114));
		     		
		     		add(titulo3);
			
     		resposta = new JLabel();
	  		resposta.setBounds(470, 10, 215, 120);
	  		resposta.setOpaque(true);
	  		resposta.setBackground(new Color(0, 110, 110)); 
	  		
	  		add(resposta);
	  		
	  		campo.setVisible(false);
			titulo2.setVisible(false);
			titulo3.setVisible(false);
			resposta.setVisible(false);
			
			pontos = new JLabel();
	 		
     		pontos.setBounds(campo.getX()-15 ,campo.getY()+110, 500, 100);
     		
     		pontos.setText("Score");
     		pontos.setFont( new Font("Eight-Bit Madness", Font.BOLD, 35 ) );
     		pontos.setForeground(new Color(255, 211, 114));
     		
     		add(pontos);
     		
     		pontostotal = new JLabel();
	 		
     		pontostotal.setBounds(pontos.getX()+42 ,pontos.getY()+40, 500, 100);
     		
     		pontostotal.setText("0");
     		pontostotal.setFont( new Font("Eight-Bit Madness", Font.BOLD, 35 ) );
     		pontostotal.setForeground(Color.WHITE);
     		
     		add(pontostotal);
     		
     		timer = new JLabel();
	 		
     		timer.setBounds(pontos.getX()+17 ,pontostotal.getY()+100, 500, 100);
     		
     		
     		timer.setFont( new Font("Eight-Bit Madness", Font.BOLD, 35 ) );
     		timer.setForeground(new Color(255, 211, 114));
     		timer.setVisible(true);
     		
     		add(timer);
     		
     		timer.setIcon(new ImageIcon("img/pulheta.png"));
     		
     		
     		timer2 = new JLabel();
     		timer2.setBounds(pontos.getX()+17 ,pontostotal.getY()+100, 500, 100);	
     		timer2.setFont( new Font("Eight-Bit Madness", Font.BOLD, 35 ) );
     		timer2.setForeground(new Color(255, 211, 114));
     		timer2.setVisible(false);
     		add(timer2);
     		
     		timer2.setIcon(new ImageIcon("img/pulheta2.png"));
     		
     		
     		
     		cronometro = new JLabel();
     		cronometro.setText("0");
     		cronometro.setFont( new Font("Eight-Bit Madness", Font.BOLD, 35 ) );
     		cronometro.setForeground(Color.WHITE);
     		
     		cronometro.setBounds(pontos.getX()+45 , timer.getY()+70, 500, 100);
     		
     		add(cronometro);
     		
     		
     		seta = new JLabel();
     		
     		seta.setBounds(cronometro.getX()-55, cronometro.getY()+120, 200, 200);
     		seta.setIcon(new ImageIcon("img/flechaMod.png"));
     		add(seta);
     		
     		
botao[6] = new JButton();
    		
    		botao[6].setBounds(campo.getX()-20, campo.getY() + 80, 120, 50);
    		botao[6].setText("Send");
    		botao[6].setOpaque(true);
    		botao[6].setBackground(new Color(255, 211, 114));
    		botao[6].setVisible(false);
    		botao[6].setFont( new Font("Eight-Bit Madness", Font.BOLD, 23) );
    		
    		botao[6].addActionListener(this);
    		add(botao[6]);
    		
botao[7] = new JButton();
    		
    		botao[7].setBounds(campo.getX()-20, campo.getY() + 690, 120, 50);
    		botao[7].setText("Back");
    		botao[7].setOpaque(true);
    		botao[7].setBackground(new Color(255, 211, 114));
    		botao[7].setVisible(false);
    		botao[7].setFont( new Font("Eight-Bit Madness", Font.BOLD, 23) );
    		
    		botao[7].addActionListener(this);
    		add(botao[7]);
     		
    		
}
        

		class or {  
                int x;  
                int y;  
        }  
   
		public void Responder() {
			campo.setVisible(true);
			titulo2.setVisible(true);
			titulo3.setVisible(true);
			resposta.setVisible(true);
			botao[6].setVisible(true);
			campo.setText("");
		}
		
		public void NaoResponder() {
			campo.setVisible(false);
			titulo2.setVisible(false);
			titulo3.setVisible(false);
			resposta.setVisible(false);
			botao[6].setVisible(false);
			campo.setText("");
		}
        public void blockgen(){  
        	rowcheck();
        	AudioPlayer.player.stop(BGM1);
        		
        	if (comecou == false) {
                Component temporaryLostComponent = null;  
                pos[0] = 0;  
                pos[1] = 1;  
                rand = (int) (Math.floor(Math.random()*7+1));  
        centralx = 4;  
        centraly = 0;  
          
                if ((b[4+prof[pos[0]][0][rand-1].x][prof[pos[0]][0][rand-1].y].getBackground() == Color.DARK_GRAY) &&  
                (b[4+prof[pos[0]][1][rand-1].x][prof[pos[0]][1][rand-1].y].getBackground() == Color.DARK_GRAY) &&  
                (b[4+prof[pos[0]][2][rand-1].x][prof[pos[0]][2][rand-1].y].getBackground() == Color.DARK_GRAY) &&  
                (b[4+prof[pos[0]][3][rand-1].x][prof[pos[0]][3][rand-1].y].getBackground() == Color.DARK_GRAY)){  
                b[4+prof[pos[0]][0][rand-1].x][prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);  
                b[4+prof[pos[0]][1][rand-1].x][prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);  
                b[4+prof[pos[0]][2][rand-1].x][prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]);  
                b[4+prof[pos[0]][3][rand-1].x][prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);
                
                b[4+prof[pos[0]][0][rand-1].x][prof[pos[0]][0][rand-1].y].setText(alet[rand-1]+"");  
                b[4+prof[pos[0]][1][rand-1].x][prof[pos[0]][1][rand-1].y].setText(alet[rand-1]+"");  
                b[4+prof[pos[0]][2][rand-1].x][prof[pos[0]][2][rand-1].y].setText(alet[rand-1]+"");  
                b[4+prof[pos[0]][3][rand-1].x][prof[pos[0]][3][rand-1].y].setText(alet[rand-1]+"");  
               
                
        go();
                
                
                } else {  
                        JOptionPane.showMessageDialog(temporaryLostComponent, "Game Over! Você conseguiu "+rowsclrd+" linhas, parabéns!");  
                        nome = JOptionPane.showInputDialog("Digite seu nome para sua pontuaçao entrar para o Ranking");
                        pegarpontos();
                        this.setVisible(false);
                        AudioPlayer.player.stop(BGM);
                    	myTimer.cancel();
                        
            new Tetris();
                }  
        }
        }
        public void rotate(){  
                if (pos[0] < 3){  
                        pos[1] = pos[0];  
                pos[0]++;  
                } else if (pos[0] == 3){  
                        pos[0] = 0;  
                        pos[1] = 3;  
                } else {  
                        System.out.println("error"+"icon_wink.gif");  
                }  
                if ((perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 4) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 1) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 2) && (perim[2+centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y+2] != 3)  
                         && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 4) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 1) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 2) && (perim[centralx+2+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y+2] != 3)  
                         && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 4) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 1) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 2) && (perim[centralx+2+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y+2] != 3)  
                         && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 4) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 1) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 2) && (perim[centralx+prof[pos[0]][3][rand-1].x+2][centraly+prof[pos[0]][3][rand-1].y+2] != 3)){  
                	
                	b[centralx+prof[pos[1]][0][rand-1].x][centraly+prof[pos[1]][0][rand-1].y].setBackground(Color.DARK_GRAY);  
                    b[centralx+prof[pos[1]][1][rand-1].x][centraly+prof[pos[1]][1][rand-1].y].setBackground(Color.DARK_GRAY);  
                    b[centralx+prof[pos[1]][2][rand-1].x][centraly+prof[pos[1]][2][rand-1].y].setBackground(Color.DARK_GRAY);  
                    b[centralx+prof[pos[1]][3][rand-1].x][centraly+prof[pos[1]][3][rand-1].y].setBackground(Color.DARK_GRAY);  
                    
                    b[centralx+prof[pos[1]][0][rand-1].x][centraly+prof[pos[1]][0][rand-1].y].setText("");  
                    b[centralx+prof[pos[1]][1][rand-1].x][centraly+prof[pos[1]][1][rand-1].y].setText("");  
                    b[centralx+prof[pos[1]][2][rand-1].x][centraly+prof[pos[1]][2][rand-1].y].setText("");  
                    b[centralx+prof[pos[1]][3][rand-1].x][centraly+prof[pos[1]][3][rand-1].y].setText("");  
                    
                    b[centralx+(prof[pos[0]][0][rand-1].x)][centraly+(prof[pos[0]][0][rand-1].y)].setBackground(rnd[rand-1]);  
                    b[centralx+(prof[pos[0]][1][rand-1].x)][centraly+(prof[pos[0]][1][rand-1].y)].setBackground(rnd[rand-1]);  
                    b[centralx+(prof[pos[0]][2][rand-1].x)][centraly+(prof[pos[0]][2][rand-1].y)].setBackground(rnd[rand-1]);  
                    b[centralx+(prof[pos[0]][3][rand-1].x)][centraly+(prof[pos[0]][3][rand-1].y)].setBackground(rnd[rand-1]);  
                    
                    b[centralx+(prof[pos[0]][0][rand-1].x)][centraly+(prof[pos[0]][0][rand-1].y)].setText(alet[rand-1]+"");  
                    b[centralx+(prof[pos[0]][1][rand-1].x)][centraly+(prof[pos[0]][1][rand-1].y)].setText(alet[rand-1]+"");   
                    b[centralx+(prof[pos[0]][2][rand-1].x)][centraly+(prof[pos[0]][2][rand-1].y)].setText(alet[rand-1]+"");  
                    b[centralx+(prof[pos[0]][3][rand-1].x)][centraly+(prof[pos[0]][3][rand-1].y)].setText(alet[rand-1]+"");  


                } else {  
                        if (pos[1] > 0){  
                                pos[0] = pos[1];  
                                pos[1]--;  
                        } else if (pos[1] == 0){  
                                pos[0] = 0;  
                                pos[1] = 3;                             }  
                        }  
        }  
         
         
        public int getxs(){  
                   int xs = 0;  
                   int[] xf = {-1, -1, -1, -1};  
                   for (int d = 0;d<4;d++){  
                           if ((xf[0] != prof[pos[0]][d][rand-1].x) || (xf[1] != prof[pos[0]][d][rand-1].x) || (xf[2] != prof[pos[0]][d][rand-1].x) || (xf[3] != prof[pos[0]][d][rand-1].x)){  
                                   xf[d] = prof[pos[0]][d][rand-1].x;  
                           }  
                   }  
                   for (int d = 0;d<4;d++){  
                           if (xf[d] != -1){  
                                   xs++;  
                           }  
                   }  
                   return xs;  
        }  
         
        
         //CLICK PARA BAIXO
        
        
        
   public void movedown(){

           int[] m2 = {-1, -1, -1, -1};  
           int[] m1 = {-1, -1, -1, -1};  
           int[] zero = {-1, -1, -1, -1};  
           int[] one = {-1, -1, -1, -1};  
           int[] two = {-1, -1, -1, -1};  
                for (int d = 0;d<4;d++){  
                        if (prof[pos[0]][d][rand-1].x == -2){  
                                m2[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].x == -1){  
                                m1[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].x == 0){  
                                zero[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].x == 1){  
                                one[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].x == 2){  
                                two[d] = d;  
                        }  
                }  
                int tmpm2 = -5;  
                int tmpm1 = -5;  
                int tmpzero = -5;  
                int tmpone = -5;  
                int tmptwo = -5;  
                for (int d = 0;d<4;d++){  
                        if (m2[d] != -1){  
                                if (tmpm2<prof[pos[0]][m2[d]][rand-1].y){  
                                tmpm2 = prof[pos[0]][m2[d]][rand-1].y;  
                                }  
                        }  
                        if (m1[d] != -1){  
                                if (tmpm1<prof[pos[0]][m1[d]][rand-1].y){  
                                tmpm1 = prof[pos[0]][m1[d]][rand-1].y;  
                        }  
                        }  
                        if (zero[d] != -1){  
                                if (tmpzero<prof[pos[0]][zero[d]][rand-1].y){  
                                tmpzero = prof[pos[0]][zero[d]][rand-1].y;  
                        }  
                        }  
                        if (one[d] != -1){  
                                if (tmpone<prof[pos[0]][one[d]][rand-1].y){  
                                tmpone = prof[pos[0]][one[d]][rand-1].y;  
                        }  
                        }  
                        if (two[d] != -1){  
                                if (tmptwo<prof[pos[0]][two[d]][rand-1].y){  
                                tmptwo = prof[pos[0]][two[d]][rand-1].y;  
                        }  
                        }  
                }  
                int total = 0;  
                for (int d = 0;d<4;d++){  
                        if (prof[pos[0]][d][rand-1].x == -2){  
                                if (perim[2+centralx+-2][2+centraly+tmpm2+1] != 4){  
                                        if(b[centralx+-2][centraly+tmpm2+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].x == -1){  
                                if (perim[2+centralx+-1][2+centraly+tmpm1+1] != 4){  
                                                if (b[centralx+-1][centraly+tmpm1+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].x == 0){  
                                if (perim[2+centralx][2+centraly+tmpzero+1] != 4){  
                                                if (b[centralx][centraly+tmpzero+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].x == 1){  
                                if (perim[2+centralx+1][2+centraly+tmpone+1] != 4){  
                                                if (b[centralx+1][centraly+tmpone+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].x == 2){  
                                if (perim[2+centralx+2][2+centraly+tmptwo+1] != 4){  
                                        if (b[centralx+2][centraly+tmptwo+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        }  
                }  
                 if (total == 4){  
                          b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(Color.DARK_GRAY);  
                          b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setText("");
                    b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(Color.DARK_GRAY);  
                    b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setText("");  
                    b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(Color.DARK_GRAY);
                    b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setText("");  
                    b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(Color.DARK_GRAY); 
                    b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setText("");  
                        centraly++;  
                        b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);  
                        b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setText(alet[rand-1]+"");  
                    b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);
                    b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setText(alet[rand-1]+"");  
                    b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]); 
                    b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setText(alet[rand-1]+"");  
                    b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);  
                    b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setText(alet[rand-1]+"");  
                  } else {  
                	  try {
						
            if(LinhaC == 0) {
						bottom = true;  
						
            }
					} catch (Exception e) {
						if(LinhaC == 0) {
							bottom = true;  
						}
					}
                         }  
                 }  
             
	
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			secondsPassed++;
		
		}
	};
	
	public void chamar() {
		if(chamou == false) {
   	  myTimer.scheduleAtFixedRate(task, 1000, 1000);
		}
	}
     
   public void go(){  
           do{  
           try {  
        	  mudarCor();
        	  secondsPassed = 0;
        	   System.out.println();
        	   
        	   if(dif == 0){
        	   if(rowsclrd == 0){
                Thread.sleep(1000L);
        	   }else if(rowsclrd == 1){
                   Thread.sleep(700L);
           	   }else if(rowsclrd == 2){
                   Thread.sleep(600L);
           	   }else if(rowsclrd == 3){
                   Thread.sleep(500L);
           	   }else if(rowsclrd == 4){
                   Thread.sleep(400L);
           	   }else if(rowsclrd == 5){
                   Thread.sleep(350L);
           	   }else if(rowsclrd == 6){
                   Thread.sleep(250L);
           	   }else if(rowsclrd == 7){
                   Thread.sleep(200L);
           	   }else if(rowsclrd == 8){
                   Thread.sleep(150L);
           	   }else if(rowsclrd == 9){
                   Thread.sleep(50L);
           	   }
        	   
        	   
        	   } else if (dif == 1) {
        		   
        		   Thread.sleep(600L);
    
        	   }else if (dif == 2) {
        		   
        		   Thread.sleep(350L);
    
        	   }else if (dif == 3) {
        		   
        		   Thread.sleep(150L);
    
        	   }
        } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
        }  
           
           
           if(rowsclrd==1){
        	   movedown();  
        	   
           }else{
        	   movedown();
        	   
           }
   }  
   while(bottom == false);  
           bottom = false;  
           rowcheck();
           
           try {
        	  if(row == 10) {
        		  Thread.sleep(2000L);
        		 
        		  blockgen(); 
        	  } else {
        		 
        		  blockgen();      
        		  
        	  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
           }  
     
   //CHEQUE LINHA
   
   public void mudarCor() {
	   if(dif == 1) {
     	  if(secondsPassed >= 25) {
     		  cronometro.setForeground(Color.RED);
     	  }else {
     		 cronometro.setForeground(Color.WHITE);
     	  }
  
     
     	  
       	  }else if(dif ==2) {
       		  if(secondsPassed >= 20) {
         		  cronometro.setForeground(Color.RED);
         	  }else {
         		 cronometro.setForeground(Color.WHITE);
         		 }
         	  }
       		  
       		  else if(dif==3) {
       		  
       			  if(secondsPassed >= 15) {
       	     		  cronometro.setForeground(Color.RED);
       	     	  }else {
       	     		cronometro.setForeground(Color.WHITE);
       	     	  }
       			  
       			  } 
       		  else {
       	     	  if(secondsPassed >= 20) {
       	     		  cronometro.setForeground(Color.RED);
       	     	  }else {
       	     		cronometro.setForeground(Color.WHITE);
       	     	  }
             		  
               		     		  }
       		  } 
   public void tempo() {
	   if(chamouotempo == false) {
	   musicTempo();
	   chamouotempo = true;
	   }
   }
   
public void pegarpontos() {
	String pontosfinais = Integer.toString(pontostotalzinho);
	   p.setLogin(pontosfinais);
	   p.setNome(nome);
	   p.setDificuldade(dificuldade);
	   Cadastro mp = new  Cadastro();
	   if(mp.cadastar(p)){
			System.out.println("Show");
		}else{
			System.out.println("Shown't");
		}
   }
   
public boolean cadastrar(Usuario usuario){
	Connection conn = null;
	Conexao conexao = new Conexao();
	
	try {
		String sql = "Insert into tbtetris (nome, pontos, dificuldade) values (?, ?, ?)";
		conn = conexao.getConexao();
		PreparedStatement pstm = conn.prepareCall(sql);
		pstm.setString(1, usuario.getNome());
		pstm.setString(2, usuario.getLogin());
		pstm.setString(2, usuario.getDificuldade());
		pstm.execute();
		
		return true;
	} catch (Exception e) {
		System.err.println(e.getMessage());
		return false;
	}finally{
		conexao.Fechar(conn);
	}
	
}
   public void rowcheck(){  
	 
           
           for (int y = 0;y<20;y++){  
                   for (int x = 0;x<10;x++){  
                           if (b[x][y].getBackground() != Color.DARK_GRAY && b[x][y].getBackground()!= Color.GRAY && b[x][y].getBackground()!= Color.MAGENTA){  
                        	  
                                   row++;  
                                   
                           } 
                           if (row == 10) {
                        	  
                        	  for(int z=0; z<10;z++) {
                        		  try {
									nsoma2[z][y] = Integer.parseInt(b[z][y].getText());
								
								} catch (NumberFormatException e) {
									
									go();
								}
                        	  }
                        		
                      nsoma = nsoma2[0][y] + nsoma2[1][y] + nsoma2[2][y] + nsoma2[3][y] + nsoma2[4][y] + 
                    		  nsoma2[5][y] + nsoma2[6][y] + nsoma2[7][y] + nsoma2[8][y] + nsoma2[9][y] 
                    		  ;

                	if(verificacao%2 == 0 ) {
                		
                		
                		 
						try {
							
							
							
							System.out.println(nsoma);
							LinhaC = 1;
							 for (int kaka = 0;kaka<10;kaka++){  
							b[kaka][y].setBackground(new Color(186, 245, 255));  
							b[kaka][y].setForeground(Color.WHITE); 
							 }
								System.out.println(nsoma);
				
								 	
	                        	  secondsPassed = 0;
	                        	
	                        	  Responder();
	                          	  if(dif == 1) {
	                        	  while(secondsPassed<=35) {
	                        		  if(secondsPassed >= 25) {
	                             		  cronometro.setForeground(Color.RED);
	                             		  tempo();
	                             	  }else {
	                             		 cronometro.setForeground(Color.WHITE);
	                             	  }
	                        		  comecou = true;
	                        		  cronometro.setText(Integer.toString(secondsPassed));
	                        	
	                        	 if(secondsPassed % 2==0){
	                        		 timer.setVisible(false);
	                        		 timer2.setVisible(true);
	                        	 }else{
	                        		 timer2.setVisible(false);
	                        		 timer.setVisible(true);
	                        	 }
	                        	  }
	                          	  }else if(dif ==2) {
	                          		  
	                          		  
	                          		  while(secondsPassed<=25) {
	                          			  if(secondsPassed >= 20) {
	                                 		  cronometro.setForeground(Color.RED);
	                                 		 tempo();
	                          			  }else {
	                                 		 cronometro.setForeground(Color.WHITE);
	                                 		 }
		                        		  comecou = true;
		                        		  cronometro.setText(Integer.toString(secondsPassed));
		                        	
		                        	 if(secondsPassed % 2==0){
		                        		 timer.setVisible(false);
		                        		 timer2.setVisible(true);
		                        	 }else{
		                        		 timer2.setVisible(false);
		                        		 timer.setVisible(true);
		                        	 }
	                          		  }
	                          		  }
	                          		  else if(dif==3) {
	                          			  	                          			
	                          		  while(secondsPassed<=20) {
	                          			if(secondsPassed >= 15) {
	                         	     		  cronometro.setForeground(Color.RED);
	                         	     		 tempo();
	                          			}else {
	                         	     		cronometro.setForeground(Color.WHITE);
	                         	     	  }
		                        		  comecou = true;
		                        		  cronometro.setText(Integer.toString(secondsPassed));
		                        	 
		                        	 if(secondsPassed % 2==0){
		                        		 timer.setVisible(false);
		                        		 timer2.setVisible(true);
		                        	 }else{
		                        		 timer2.setVisible(false);
		                        		 timer.setVisible(true);
		                        	 }
		                        	
	                          	  }
	                          		  } else {
	                          			
	  	                          		  while(secondsPassed<=25) {
	  	                          		  if(secondsPassed >= 20) {
	                                 		  cronometro.setForeground(Color.RED);
	                                 		 tempo();
	                                 	  }else {
	                                 		 cronometro.setForeground(Color.WHITE);
	                                 		 }
	  		                        		  comecou = true;
	  		                        		  cronometro.setText(Integer.toString(secondsPassed));
	  		                        
	  		                        	 if(secondsPassed % 2==0){
	  		                        		 timer.setVisible(false);
	  		                        		 timer2.setVisible(true);
	  		                        	 }else{
	  		                        		 timer2.setVisible(false);
	  		                        		 timer.setVisible(true);
	  		                        	 }
	  	                          	  }
	                          		  }
	                          	  
	                        	  secondsPassed = 0;
	                        	  cronometro.setText(Integer.toString(secondsPassed));
					
							String numeroLabel = campo.getText();							

							numero = Integer.parseInt(numeroLabel);
							pontinhos = numero*10;
							
						} catch (HeadlessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberFormatException e) {
							System.out.println("Coloque certo");
						}
                		if(numero == nsoma) {
                		 rowsclrd++;  
                         rowclear(y);
                         LinhaC= 0 ;
                         NaoResponder();
                         pontostotalzinho = Integer.parseInt(pontostotal.getText());
                         pontostotalzinho = pontostotalzinho + pontinhos;
                         pontostotal.setText(Integer.toString(pontostotalzinho));
                         
                 		AudioPlayer.player.stop(BGM1);
                         comecou = false;
                        chamouotempo = false;
                        
                		}else {
                		int linha = y;	
                			chamouotempo = false;
                		rowperdeu(y);
                		LinhaC = 0;
                		 NaoResponder();
                		 comecou = false;
                			AudioPlayer.player.stop(BGM1);
                		
                		
                		}
                		
                	}else {
                	verificacao++;
                	}
                  
                           }  
                   }  
                   row = 0; 
                   
           }  
   } 
   
   
   
   
   //LIMPA LINHA
   
  public void rowperdeu(int y) {  
      for (int x = 0;x<10;x++){  
              b[x][y].setBackground(Color.GRAY);  
              b[x][y].setText("X"); 
      }  
                
  }
     
   
   public void rowclear(int y){  
           int inc = 0;  
           for (int x = 0;x<10;x++){  
                   try {
					b[x][y].setBackground(Color.DARK_GRAY);
					  b[x][y].setText(""); 
					Thread.sleep(80);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
                 
           }  
           for (int c = y-1;c>-1;c--){  
       for (int x = 0;x<10;x++){  
           tmp[x][y-inc] = b[x][c].getBackground();  
           txt[x][y-inc] = b[x][c].getText();  
       }inc++;}  
           for (int c = y;c>-1;c--){  
                   for (int x = 0;x<10;x++){  
                           b[x][c].setBackground(tmp[x][c]);
                           b[x][c].setText(txt[x][c]);  
                   }  
           } 
   }  
     
   public void movelr(){                   
           int[] m2 = {-1, -1, -1, -1};  
           int[] m1 = {-1, -1, -1, -1};  
           int[] zero = {-1, -1, -1, -1};  
           int[] one = {-1, -1, -1, -1};  
           int[] two = {-1, -1, -1, -1};  
                for (int d = 0;d<4;d++){  
                        if (prof[pos[0]][d][rand-1].y == -2){  
                                m2[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].y == -1){  
                                m1[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].y == 0){  
                                zero[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].y == 1){  
                                one[d] = d;  
                        } else if (prof[pos[0]][d][rand-1].y == 2){  
                                two[d] = d;  
                        }  
                }  
                        int tmpm2 = -5;  
                        int tmpm1 = -5;  
                        int tmpzero = -5;  
                        int tmpone = -5;  
                        int tmptwo = -5;  
                if (deltax == 1){  
                for (int d = 0;d<4;d++){  
                        if (m2[d] != -1){  
                                if (tmpm2<prof[pos[0]][m2[d]][rand-1].x){  
                                tmpm2 = prof[pos[0]][m2[d]][rand-1].x;  
                                }  
                        }  
                        if (m1[d] != -1){  
                                if (tmpm1<prof[pos[0]][m1[d]][rand-1].x){  
                                tmpm1 = prof[pos[0]][m1[d]][rand-1].x;  
                        }  
                        }  
                        if (zero[d] != -1){  
                                if (tmpzero<prof[pos[0]][zero[d]][rand-1].x){  
                                tmpzero = prof[pos[0]][zero[d]][rand-1].x;  
                        }  
                        }  
                        if (one[d] != -1){  
                                if (tmpone<prof[pos[0]][one[d]][rand-1].x){  
                                tmpone = prof[pos[0]][one[d]][rand-1].x;  
                        }  
                        }  
                        if (two[d] != -1){  
                                if (tmptwo<prof[pos[0]][two[d]][rand-1].x){  
                                tmptwo = prof[pos[0]][two[d]][rand-1].x;  
                        }  
                        }  
                }  
                } else if (deltax == -1){  
                        tmpm2 = 5;  
                        tmpm1 = 5;  
                        tmpzero = 5;  
                        tmpone = 5;  
                        tmptwo = 5;  
                        for (int d = 0;d<4;d++){  
                                if (m2[d] != -1){  
                                        if (tmpm2>prof[pos[0]][m2[d]][rand-1].x){  
                                        tmpm2 = prof[pos[0]][m2[d]][rand-1].x;  
                                        }  
                                }  
                                if (m1[d] != -1){  
                                        if (tmpm1>prof[pos[0]][m1[d]][rand-1].x){  
                                        tmpm1 = prof[pos[0]][m1[d]][rand-1].x;  
                                }  
                                }  
                                if (zero[d] != -1){  
                                        if (tmpzero>prof[pos[0]][zero[d]][rand-1].x){  
                                        tmpzero = prof[pos[0]][zero[d]][rand-1].x;  
                                }  
                                }  
                                if (one[d] != -1){  
                                        if (tmpone>prof[pos[0]][one[d]][rand-1].x){  
                                        tmpone = prof[pos[0]][one[d]][rand-1].x;  
                                }  
                                }  
                                if (two[d] != -1){  
                                        if (tmptwo>prof[pos[0]][two[d]][rand-1].x){  
                                        tmptwo = prof[pos[0]][two[d]][rand-1].x;  
                                }  
                                }  
                        }  
                }  
                int total = 0;  
                for (int d = 0;d<4;d++){  
                        if (prof[pos[0]][d][rand-1].y == -2){  
                                if (perim[2+centralx+deltax+tmpm2][2+centraly-2] != 2){  
                                        if(b[centralx+deltax+tmpm2][centraly-2].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].y == -1){  
                                if (perim[2+centralx+deltax+tmpm1][2+centraly-1] != 2){  
                                                if (b[centralx+deltax+tmpm1][centraly-1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].y == 0){  
                                if (perim[2+centralx+deltax+tmpzero][2+centraly] != 2){  
                                                if (b[centralx+deltax+tmpzero][centraly].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].y == 1){  
                                if (perim[2+centralx+deltax+tmpone][2+centraly+1] != 2){  
                                                if (b[centralx+deltax+tmpone][centraly+1].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        } else if (prof[pos[0]][d][rand-1].y == 2){  
                                if (perim[2+centralx+deltax+tmptwo][2+centraly+2] != 2){  
                                        if (b[centralx+deltax+tmptwo][centraly+2].getBackground() == Color.DARK_GRAY){  
                                        total++;  
                                }}  
                        }  
                } if (total == 4){  
                                        b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(Color.DARK_GRAY);  
                                        b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(Color.DARK_GRAY);  
                            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(Color.DARK_GRAY);  
                            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(Color.DARK_GRAY);
                            
                            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setText("");  
                            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setText("");  
                b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setText("");  
                b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setText("");  
                                centralx = centralx+deltax;  
                                b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setBackground(rnd[rand-1]);  
                            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setBackground(rnd[rand-1]);  
                            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setBackground(rnd[rand-1]);  
                            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setBackground(rnd[rand-1]);
                            
                            b[centralx+prof[pos[0]][0][rand-1].x][centraly+prof[pos[0]][0][rand-1].y].setText(alet[rand-1]+"");  
                            b[centralx+prof[pos[0]][1][rand-1].x][centraly+prof[pos[0]][1][rand-1].y].setText(alet[rand-1]+"");  
                            b[centralx+prof[pos[0]][2][rand-1].x][centraly+prof[pos[0]][2][rand-1].y].setText(alet[rand-1]+"");  
                            b[centralx+prof[pos[0]][3][rand-1].x][centraly+prof[pos[0]][3][rand-1].y].setText(alet[rand-1]+"");    
                }  
                           
                   
   }  
   
   public static void music() 
   {       
     
       ContinuousAudioDataStream loop = null;
      

       try
       {
           InputStream test = new FileInputStream("BGM and SE/tetris.wav");
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
   
   public static void musicTempo() 
   {       
     
       ContinuousAudioDataStream loop = null;
      

       try
       {
           InputStream test = new FileInputStream("BGM and SE/time.wav");
           BGM1 = new AudioStream(test);
           AudioPlayer.player.start(BGM1);
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

   
   static JFrame frame;
   public static void main(String[] args)
   {
	
   		frame = new Tetris();
   		frame.addWindowListener(getWindowAdapter());
   }
   
   private static WindowAdapter getWindowAdapter() {
	    return new WindowAdapter() {
	      @Override
	      public void windowClosing(WindowEvent we) {
	        super.windowClosing(we);
	        JOptionPane.showMessageDialog(frame, "Cant Exit");
	      }
	      @Override
	      public void windowIconified(WindowEvent we) {
	        frame.setState(JFrame.NORMAL);
	        JOptionPane.showMessageDialog(frame, "Cant Minimize");
	      }
	    };
	  }
   
@Override  
public void keyPressed(KeyEvent e) {  
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){  
             
        	deltax = 1;  
                movelr();  
                }  
        if (e.getKeyCode() == KeyEvent.VK_LEFT){  
                deltax = -1;  
                movelr();  
                }  
        if (e.getKeyCode() == KeyEvent.VK_UP){  
                rotate();  
                }  
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
        	
                movedown();  
                } 
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	botao[6].getAction();
        }
}  
   

   
@Override  
public void keyReleased(KeyEvent e) {  
        // TODO Auto-generated method stub  
         
}  
   
   
@Override  
public void keyTyped(KeyEvent e) {  
        // TODO Auto-generated method stub  
         
}

@Override
public void actionPerformed(ActionEvent arg0) {
	if(arg0.getSource().equals(botao[0])) {
		caixa.setVisible(false);
		dif = 0;
		botao[1].setVisible(false);
		botao[7].setVisible(true);
		botao[0].setVisible(false);
		botao[2].setVisible(false);
		botao[3].setVisible(false);
		botao[8].setVisible(false);
		botao[4].setVisible(false);
		botao[5].setVisible(false);
		titulo.setVisible(false);
		botao[11].setVisible(false);
		repaint();
		revalidate();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				blockgen();
				try {
					Thread.sleep(25);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	
	}
	
	if(arg0.getSource().equals(botao[1])) {
		botao[0].setVisible(false);
		botao[1].setVisible(false);
		botao[4].setVisible(true);
		botao[5].setVisible(false);
		botao[8].setVisible(false);
		botao[7].setVisible(true);
		botao[11].setVisible(false);

	}
	
	if(arg0.getSource().equals(botao[2])) {
		caixa.setVisible(false);
		botao[1].setVisible(false);
		botao[0].setVisible(false);
		botao[2].setVisible(false);
		botao[3].setVisible(false);
		botao[4].setVisible(false);
		botao[7].setVisible(true);
		botao[11].setVisible(false);
		botao[8].setVisible(false);
botao[5].setVisible(false);
		titulo.setVisible(false);
		
		dif = 1;
new Thread(new Runnable() {
			
			@Override
			public void run() {
				blockgen();
				try {
					Thread.sleep(25);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
	
	if(arg0.getSource().equals(botao[3])) {
		caixa.setVisible(false);
		botao[1].setVisible(false);
		botao[0].setVisible(false);
		botao[2].setVisible(false);
		botao[3].setVisible(false);
		botao[7].setVisible(true);
		botao[4].setVisible(false);
		botao[5].setVisible(false);
		titulo.setVisible(false);
		botao[8].setVisible(false);
		botao[11].setVisible(false);

		dif = 2;
new Thread(new Runnable() {
			
			@Override
			public void run() {
				blockgen();
				try {
					Thread.sleep(25);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
	
	if(arg0.getSource().equals(botao[4])) {
		caixa.setVisible(false);
		botao[1].setVisible(false);
		botao[0].setVisible(false);
		botao[2].setVisible(false);
		botao[3].setVisible(false);
		botao[7].setVisible(true);
		botao[4].setVisible(false);
		botao[5].setVisible(false);
		titulo.setVisible(false);
		botao[8].setVisible(false);

		dif = 3;
new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				blockgen();
				try {
					Thread.sleep(25);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
	
	
	if(arg0.getSource().equals(botao[5])) {
		
		new Regras(); 
	}
	
	if(arg0.getSource().equals(botao[8])) {
		
		System.exit(0); 
	}
	
	if(arg0.getSource().equals(botao[6])) {
		secondsPassed = 100;
	}
	
	if(arg0.getSource().equals(botao[7])) {
		comecou = true;
		AudioPlayer.player.stop(BGM);		
		AudioPlayer.player.stop(BGM1);
	myTimer.cancel();
	this.setVisible(false);
	voltou = true;
		new Tetris();
		
	
	}
	if(arg0.getSource().equals(botao[11])) {
		this.setVisible(false);
		new Ranking();
		AudioPlayer.player.stop(BGM);		
		AudioPlayer.player.stop(BGM1);
	myTimer.cancel();
	}
	
	
}  
}  