package chat;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;


public class LoginClient extends JFrame{


	private JFrame frame;
	private JTextField clientUserName;
	private JTextField serverIP;
	private JTextField portInput;
	private int port = 8818;
	private String ip = "localhost";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginClient window = new LoginClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginClient() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLUE);
		frame.setBounds(100, 100, 619, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Client Register");

		clientUserName = new JTextField();
		clientUserName.setBounds(207, 50, 276, 61);
		frame.getContentPane().add(clientUserName);
		clientUserName.setColumns(10);
		
		serverIP = new JTextField();
		serverIP.setBounds(207, 120, 276, 61);
		frame.getContentPane().add(serverIP);
		serverIP.setColumns(10);
		serverIP.setText("127.0.0.1");
		
		portInput = new JTextField();
		portInput.setBounds(207, 190, 276, 61);
		frame.getContentPane().add(portInput);
		portInput.setColumns(10);
		portInput.setText("8818");

		JButton clientLoginBtn = new JButton("Connect");
		clientLoginBtn.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				try {
					if (serverIP.getText().equals("") || clientUserName.getText().equals("") || portInput.getText().equals("")) {
						JOptionPane.showMessageDialog(frame,  "Input invalid.\n");
					} else {
						String id = clientUserName.getText(); 
						ip = serverIP.getText(); 
						port = Integer.parseInt(portInput.getText()); 
						Socket s = new Socket(ip, port); 
						DataInputStream inputStream = new DataInputStream(s.getInputStream()); 
						DataOutputStream outStream = new DataOutputStream(s.getOutputStream());
						outStream.writeUTF(id);
						
						String msgFromServer = new DataInputStream(s.getInputStream()).readUTF(); 
						if(msgFromServer.equals("Username already taken")) {
							JOptionPane.showMessageDialog(frame,  "Username already taken\n"); 
						}else {
							new ClientView(id, s);
							frame.dispose();
						}
					}
					
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(frame,  "Error.\n");
				}
			}
		});
		
		clientLoginBtn.setFont(new Font("Tempus Sans ITC", Font.BOLD, 19));
		clientLoginBtn.setBounds(207, 279, 132, 61);
		frame.getContentPane().add(clientLoginBtn);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(44, 55, 132, 47);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("Server IP:");
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(44, 115, 132, 47);
		frame.getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel2 = new JLabel("Port:");
		lblNewLabel2.setForeground(new Color(255, 255, 255));
		lblNewLabel2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 25));
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(44, 175, 132, 47);
		frame.getContentPane().add(lblNewLabel2);
	}

	
}
