import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Toast extends JFrame{
	
	public void Play(String file) throws LineUnavailableException, UnsupportedAudioFileException, IOException
	{
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(file));
	    Clip clip = AudioSystem.getClip();
	    clip.open(inputStream);
	    clip.start();
	}
	
    Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 13);
    Font font2 = new Font(Font.MONOSPACED, Font.CENTER_BASELINE, 25);
    
    int count; int total=0; int col=0; int row=0; String contents = "";
    
	public Toast () {
		JFrame frame = new JFrame("����佺Ʈ_Ű����ũ");
        
        Panel NorthPanel = new Panel();
        NorthPanel.setBackground(Color.orange);
        NorthPanel.setLayout(new FlowLayout());
        
        Label highbar = new Label();
        highbar.setText("<��� �佺Ʈ Ű����ũ>");
        highbar.setFont(font2);
		NorthPanel.add(highbar);
		
		
		Panel CenterPanel = new Panel();
		CenterPanel.setLayout(null);
		CenterPanel.setBackground(Color.LIGHT_GRAY);
		String menu[] = {"��ġ�� �佺Ʈ", "<HTML><body>�ܽ����<br>�佺Ʈ</body></HTML>", 
				"<HTML><body>�ҽ���<br>�佺Ʈ</body></HTML>", "<HTML><body>û����<br>���̵�</body></HTML>", 
				"<HTML><body><center>�ڸ�<br>���̵�</center></body></HTML>",
				"<HTML><body><center>����<br>���̵�</center></body></HTML>", "+�� �߰�","���� �佺Ʈ",
				"<HTML><body>������<br>�佺Ʈ</body></HTML>", "���� �佺Ʈ","�Ƹ޸�ī��","ī���","ī���ī","+���� �߰�",
				"���� �佺Ʈ", "<HTML><body>�Ұ��<br>�佺Ʈ</body></HTML>","<HTML><body><center>������ũ<br>�佺Ʈ</center></body></HTML>",
				"<HTML><body><center>����<br>������</center></body></HTML>", "<HTML><body><center>����<br>������</center></body></HTML>",
				"<HTML><body>�ٳ���<br>������</body></HTML>", "+ġ�� �߰�"};
		
		String menu_txt[] = {"��ġ�� �佺Ʈ", "�ܽ���� �佺Ʈ", "�ҽ��� �佺Ʈ", "û���� ���̵�", 
				"�ڸ� ���̵�","���� ���̵�", "+�� �߰�","���� �佺Ʈ","������ �佺Ʈ", "���� �佺Ʈ",
				"�Ƹ޸�ī��","ī���","ī���ī","+���� �߰�","���� �佺Ʈ", "�Ұ�� �佺Ʈ","������ũ �佺Ʈ",
				"���� ������", "���� ������","�ٳ��� ������", "+ġ�� �߰�"};
		
		/*
		 	�佺Ʈ 0 1 2 7 8 9 14 15 16
			Ŀ�� 10 11 12
			���̵� 3 4 5
			������ 17 18 19
		*/
		
		int price[] = {2000, 2500, 2500, 2700, 2700,2700, 500, 2500, 
				2500, 2500, 2700,3300,3500,700,2300, 2300, 2500,
				3500,3500,3500,300};
		JButton bt_menu[] = new JButton[menu.length];
        TextField num[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        JButton ok[] = new JButton[menu.length];
        Label won[] = new Label[menu.length];
        Label name[] = new Label[menu.length];
        Color[] color = {new Color(190,170,50), new Color(150, 100, 0), new Color(255,255,0), new Color(173, 52, 125)};
        
        bt_menu[0] = new JButton(new ImageIcon("./img/��ġ��.png"));
        bt_menu[1] = new JButton(new ImageIcon("./img/�ܽ����.png"));
        bt_menu[2] = new JButton(new ImageIcon("./img/�Ҽ���.png"));
        bt_menu[3] = new JButton(new ImageIcon("./img/û����.png"));
        bt_menu[4] = new JButton(new ImageIcon("./img/�ڸ�.png"));
        bt_menu[5] = new JButton(new ImageIcon("./img/����.png"));
        bt_menu[6] = new JButton(new ImageIcon("./img/ham.jpg"));
        bt_menu[7] = new JButton(new ImageIcon("./img/����.png"));
        bt_menu[8] = new JButton(new ImageIcon("./img/������.png"));
        bt_menu[9] = new JButton(new ImageIcon("./img/����.png"));
        bt_menu[10] = new JButton(new ImageIcon("./img/�Ƹ޸�ī��.jpg"));
        bt_menu[11] = new JButton(new ImageIcon("./img/ī���.jpg"));
        bt_menu[12] = new JButton(new ImageIcon("./img/ī���ī.jpg"));
        bt_menu[13] = new JButton(new ImageIcon("./img/potato.jpg"));
        bt_menu[14] = new JButton(new ImageIcon("./img/����.png"));
        bt_menu[15] = new JButton(new ImageIcon("./img/�Ұ��.png"));
        bt_menu[16] = new JButton(new ImageIcon("./img/������ũ.png"));
        bt_menu[17] = new JButton(new ImageIcon("./img/���⽺����.jpg"));
        bt_menu[18] = new JButton(new ImageIcon("./img/���ڽ�����.jpg"));
        bt_menu[19] = new JButton(new ImageIcon("./img/�ٳ���������.jpg"));
        bt_menu[20] = new JButton(new ImageIcon("./img/cheese.jpg"));
        
        for (int i = 0; i < menu.length; i++) {
        	if(i<7) {
        		bt_menu[i].setBounds(25 + i * 150, 40, 100, 100);
        	}
        	else if(i<14) {
        		bt_menu[i].setBounds(25 + (i - 7) * 150, 250, 100, 100);
        		
        	}
        	else {
        		bt_menu[i].setBounds(25 + (i - 14) * 150, 470, 100, 100);
        	}
        	
        	name[i] = new Label(menu_txt[i]);
        	name[i].setFont(font1);
        	name[i].setBounds(bt_menu[i].getX()-3, bt_menu[i].getY() - 20, 115, 20);
        	
        	num[i] = new TextField("0");
            num[i].setBackground(Color.white);
            num[i].setEditable(false);
            num[i].setBounds(bt_menu[i].getX() + 30, bt_menu[i].getY() + 130, 40, 20);
            
            minus[i] = new Button("-");
            minus[i].setBounds(bt_menu[i].getX(), num[i].getY(), 20, 20);
            minus[i].setEnabled(true);
            
            plus[i] = new Button("+");
            plus[i].setBounds(bt_menu[i].getX() + (100 - 20), num[i].getY(), 20, 20);
            plus[i].setEnabled(true);
            
            won[i] = new Label(price[i] + "��");
            won[i].setBounds(bt_menu[i].getX() + 30, num[i].getY() - 25, 100, 20);
            
            ok[i] = new JButton("Ȯ��");
            ok[i].setBounds(bt_menu[i].getX(), num[i].getY() + 30, 100, 20);
            ok[i].setEnabled(false);
            
            CenterPanel.add(name[i]);
            CenterPanel.add(bt_menu[i]);
            CenterPanel.add(num[i]);
            CenterPanel.add(minus[i]);
            CenterPanel.add(plus[i]);
            CenterPanel.add(won[i]);
            CenterPanel.add(ok[i]);
        }
        
        bt_menu[0].setBackground(color[0]);
    	bt_menu[1].setBackground(color[0]);
    	bt_menu[2].setBackground(color[0]);

    	bt_menu[7].setBackground(color[0]);
    	bt_menu[8].setBackground(color[0]);
    	bt_menu[9].setBackground(color[0]);

    	bt_menu[14].setBackground(color[0]);
    	bt_menu[15].setBackground(color[0]);
    	bt_menu[16].setBackground(color[0]);

        Panel SouthPanel = new Panel();
        TextArea txt = new TextArea("");
        
        String[] [] data = new String[0][0];
        String[] title = {"��ǰ��","�ܰ�","����","�հ�", "�� �ݾ�"};
        DefaultTableModel model = new DefaultTableModel(data, title);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1150,200));
        SouthPanel.add(scrollPane);

        
	    Panel SelectPanel = new Panel();
	    SelectPanel.setLayout(new GridLayout(3,1,50,0));
	    JButton order[] = new JButton[3];
	   
	    order[0] = new JButton(new ImageIcon("./img/close.png"));
	    order[1] = new JButton(new ImageIcon("./img/reset.png"));
	    order[2] = new JButton(new ImageIcon("./img/buy.png"));
	    order[0].setBackground(Color.WHITE);
	    order[1].setBackground(Color.WHITE);
	    order[2].setBackground(Color.WHITE);
	    SelectPanel.add(order[0]);
	    SelectPanel.add(order[1]);
	    SelectPanel.add(order[2]);
	   
	    // �ݱ� ��ư
	    order[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
	    });
	    
        // �ʱ�ȭ ��ư
        order[1].addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Play("sound/reset.wav");
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	model.setNumRows(0); //�ֹ� ���� �ʱ�ȭ
            	txt.setText("");
            	total=0;
            }
        });
 
        // �ֹ���ư
        order[2].addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int answer = JOptionPane.showConfirmDialog(null, "�ֹ��Ͻðڽ��ϱ�?", "Order",JOptionPane.YES_NO_OPTION);
            	if(answer == JOptionPane.YES_OPTION)
            	{
            		if(total==0)
            		{
            			try {
							Play("sound/error.wav");
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
            			JOptionPane.showMessageDialog(null, "���� �׸��� �������� �ʽ��ϴ�.");
            		}

                	else {
                		for(int i=0; i<table.getRowCount(); i++) {
                			txt.append(table.getValueAt(i, 0)+" "+table.getValueAt(i, 1)+" X "+table.getValueAt(i, 2)+"��\n");
                		}
                		
                		contents = txt.toString();
                		if(!contents.contains("�佺Ʈ")&&contents.contains("�߰�"))
                		{
                			try {
    							Play("sound/error.wav");
    						} catch (LineUnavailableException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						} catch (UnsupportedAudioFileException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						} catch (IOException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
                			JOptionPane.showMessageDialog(null, "�佺Ʈ�� ���õ��� �ʾҽ��ϴ�.\n�߰� �ɼ��� �佺Ʈ ���� �� �߰��� �� �ֽ��ϴ�.");
                			txt.setText("");
                		}
                		else {
                			try {
    							Play("sound/order.wav");
    						} catch (LineUnavailableException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						} catch (UnsupportedAudioFileException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						} catch (IOException e1) {
    							// TODO Auto-generated catch block
    							e1.printStackTrace();
    						}
                			JOptionPane.showMessageDialog(null, txt.getText()+"�� �ݾ� : "+total+"��\n"+"�ֹ��Ǿ����ϴ�. \n�̿����ּż� �����մϴ�.");
                			total=0; txt.setText(""); model.setNumRows(0);
                		}
                	}
            	}
            	else
            		JOptionPane.showMessageDialog(null, "�޴� ���� �ܰ�� ���ư��ϴ�.\n");

                for (int i = 0; i < menu.length; i++) {
                    num[i].setText("0");
                }
            }
        });
        
	    
	    
	    for (int i = 0; i < menu.length; i++) {
            int j = i;
 
            bt_menu[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = 0;
                }
            });
 
            minus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        num[j].setText(count + "");
                        ok[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });
            
            plus[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    num[j].setText(count + "");
                    ok[j].setEnabled(true);
                    if (count > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });
            
            ok[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                   num[j].setText("0");
                   total= total+price[j] * count;
 
                   String inputStr[] = new String [5];
                   
                   inputStr[0] = menu_txt[j];
                   inputStr[1] = price[j]+"��";
                   inputStr[2] = ""+count;
                   inputStr[3] = price[j] * count+"��";
                   inputStr[4] = total+"��";
                   model.addRow(inputStr);
                   
                   count=0;
                   ok[j].setEnabled(false);
                }
            });
        }


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(NorthPanel, BorderLayout.NORTH);
        frame.add(CenterPanel, BorderLayout.CENTER);
        frame.add(SouthPanel, BorderLayout.SOUTH);
        frame.add(SelectPanel, BorderLayout.EAST);
		frame.setSize(1170, 958);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
        new Toast();
    }
}
