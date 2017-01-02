package runner;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import rmi.ClientRemoteHelper;
import rmi.HotelWorkerRemoteHelper;
import rmi.LoginRemoteHelper;
import rmi.WebManagerRemoteHelper;
import rmi.WebSalerRemoteHelper;

public class ServerRunner extends JFrame {

	private JPanel contentPane;
	private JLabel stateLabel;
	private JTextArea logArea;
	private JButton startBT;
	private JButton endBT;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new ServerRunner();
	}

	/**
	 * Create the frame.
	 */
	public ServerRunner() {
		JFrame frame=new JFrame();
		frame.setTitle("服务器");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(150, 100, 604, 617);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startBT = new JButton("启动服务器");
		startBT.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		startBT.setBounds(86, 33, 142, 29);
		startBT.addActionListener(new StartServerListener());
		contentPane.add(startBT);
		
		endBT = new JButton("停止服务器");
		endBT.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		endBT.setBounds(325, 33, 142, 29);
		endBT.addActionListener(new StopServerListener());
		contentPane.add(endBT);
		
		JLabel label = new JLabel("\u670D\u52A1\u5668\u72B6\u6001");
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		label.setBounds(25, 100, 98, 21);
		contentPane.add(label);
		
		stateLabel = new JLabel("未启动");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		stateLabel.setBounds(147, 100, 186, 21);
		contentPane.add(stateLabel);
		
		JLabel label_2 = new JLabel("系统当前时间");
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		label_2.setBounds(25, 149, 119, 21);
		contentPane.add(label_2);

		JLabel timeLabel = new JLabel();
		timeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		timeLabel.setBounds(147, 148, 270, 25);
		contentPane.add(timeLabel);
		
		JLabel label_1 = new JLabel("\u65E5\u5FD7\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 19));
		label_1.setBounds(35, 215, 81, 21);
		contentPane.add(label_1);
		
		logArea = new JTextArea();
		logArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		logArea.setBounds(25, 250, 532, 296);
		logArea.setLineWrap(true);
		//设置滚动条指向最下方,便于阅读新收到的消息。
		logArea.setCaretPosition(logArea.getText().length());

		JScrollPane scroll=new JScrollPane(logArea);
		
		//分别设置水平和垂直滚动条自动出现 
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		contentPane.add(logArea);
		
		frame.setVisible(true);

		//利用dead loop和线程来实现动态显示时间
		while(true){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date current = new Date(System.currentTimeMillis());
			String currentTime = formatter.format(current);
			timeLabel.setText(currentTime);
			//每一秒刷新下时间
			try {
			Thread.sleep(1000);//sleep是以ms为单位
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}
	
	class StartServerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			new ClientRemoteHelper();
			new HotelWorkerRemoteHelper();
			new WebSalerRemoteHelper();
			new WebManagerRemoteHelper();
			new LoginRemoteHelper();
			
			stateLabel.setText("服务器已经启动!");	
			
			//获得启动服务器时间
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date current = new Date();
			String currentTime = formatter.format(current);
			
			logArea.append("服务器于 "+currentTime+" 成功启动！");
			logArea.append("\r\n");
			startBT.setEnabled(false);
			endBT.setEnabled(true);
		}
		
	}
	
	class StopServerListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			stateLabel.setText("服务器已经关闭!");
				
			//获得结束服务器时间
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date current = new Date();
			String currentTime = formatter.format(current);
			
			logArea.append("服务器于 "+currentTime+" 成功关闭！感谢您的使用");
			logArea.append("\r\n");
			startBT.setEnabled(true);
			endBT.setEnabled(false);
			
			JOptionPane.showMessageDialog(null, "感谢您的使用,系统将在5秒后关闭,再见");
			
			try {
				Thread.sleep(5000);//sleep是以ms为单位
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			
		}
		
	}

	}

	