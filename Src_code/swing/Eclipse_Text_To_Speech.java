package swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import marryTTS.TextToSpeech;
import tesseract_OCR.ocr.ScanedImage;

//import com.sum.speech.freetts.Voice;
//import com.sum.speech.freetts.VoiceManager;
//import com.sum.speech.freetts.audio.JavaClipAudioPlayer;

public class Eclipse_Text_To_Speech {

	private JFrame frmConverttexttospeech;
	private JFrame frame;
	private TextToSpeech tts;
//	 private static final String Saywhat = "kelvin 16";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eclipse_Text_To_Speech window = new Eclipse_Text_To_Speech();
					window.frmConverttexttospeech.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public Eclipse_Text_To_Speech() {
		tts = new TextToSpeech();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConverttexttospeech = new JFrame();
		frmConverttexttospeech.setTitle("Convert Text To Speech");
		frmConverttexttospeech.setBounds(0, 0, 1360, 800);
		frmConverttexttospeech.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConverttexttospeech.getContentPane().setLayout(null);
		
// panelHeader includes lblImage, lblConvertTextToSpeech
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(Color.GRAY);
		panelHeader.setBorder(new LineBorder(Color.LIGHT_GRAY, 12));
		panelHeader.setBounds(10, 0, 1324, 138);
		frmConverttexttospeech.getContentPane().add(panelHeader);
		panelHeader.setLayout(null);

		JLabel lblConvertTextToSpeech = new JLabel("Convert Text To Speech");
		lblConvertTextToSpeech.setBackground(Color.WHITE);
		lblConvertTextToSpeech.setBounds(197, 32, 1106, 70);
		lblConvertTextToSpeech.setBorder(new LineBorder(Color.WHITE, 8));
		lblConvertTextToSpeech.setFont(new Font("Times New Roman", Font.BOLD, 72));
		panelHeader.add(lblConvertTextToSpeech);

		JLabel lblImage = new JLabel();
		lblImage.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\IMG20201030161106 (1) (1).jpg"));
		lblImage.setBounds(10, 11, 182, 116);
		panelHeader.add(lblImage);

		/* Test
		 * An I/O Stream represents an input source or an output destination. A stream
		 * can represent many different kinds of sources and destinations, including
		 * disk files, devices, other programs, and memory arrays. Streams support many
		 * different kinds of data, including simple bytes, primitive data types,
		 * localized characters, and objects. Some streams simply pass on data, others
		 * manipulate and transform the data in useful ways.
		 */
		
		// Tìm hieu Tesseract OCR
		// Tieng Viet
		
// panelBody includes btnExit, btnClear, btnSpeak, btnVoice1, btnVoice2, btnVoice3 and textArea
		JPanel panelBody = new JPanel();
		panelBody.setBorder(new LineBorder(new Color(0, 0, 0), 12));
		panelBody.setBounds(10, 149, 1324, 601);
		frmConverttexttospeech.getContentPane().add(panelBody);
		panelBody.setLayout(null);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit?", "Notification",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		JRadioButton btnVoice1 = new JRadioButton("Voice 1");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnExit.setBounds(26, 450, 281, 46);
		panelBody.add(btnExit);

		btnVoice1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnVoice1.setBounds(100, 50, 250, 15);
		panelBody.add(btnVoice1);
		btnVoice1.setSelected(true);
		btnVoice1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tts.setVoice("cmu-rms-hsmm");
			}
		});

		JRadioButton btnVoice2 = new JRadioButton("Voice 2");
		btnVoice2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnVoice2.setBounds(100, 100, 250, 15);
		panelBody.add(btnVoice2);
		btnVoice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tts.setVoice("dfki-poppy-hsmm");

			}
		});

		

		JRadioButton btnVoice3 = new JRadioButton("Voice 3");
		btnVoice3.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnVoice3.setBounds(100, 150, 250, 15);
		panelBody.add(btnVoice3);
		btnVoice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tts.setVoice("cmu-slt-hsmm");

			}
		});

		ButtonGroup bg = new ButtonGroup();
		bg.add(btnVoice1);
		bg.add(btnVoice2);
		bg.add(btnVoice3);

		JTextArea textArea = new JTextArea();
		textArea.setBorder(BorderFactory.createLineBorder(Color.black));
		textArea.setBounds(352, 54, 890, 490);
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 30));
//		panelBody.add(textArea);
		
		JScrollPane jsp = new JScrollPane(textArea);
		textArea.setWrapStyleWord(true);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(352, 54, 920, 490);
		panelBody.add(jsp);		

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textArea.setText("");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnClear.setBounds(26, 390, 281, 46);
		panelBody.add(btnClear);
		
		//Choose Image
		JButton btnGetImage = new JButton("Choose Image");
		btnGetImage.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnGetImage.setBounds(26, 270, 281, 46);
		panelBody.add(btnGetImage);
		btnGetImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				do {
					JFileChooser jfc = new JFileChooser();
					FileNameExtensionFilter fnef = new FileNameExtensionFilter("Picture", "jpg", "png");
					jfc.setFileFilter(fnef);
					jfc.setMultiSelectionEnabled(false);

					jfc.showDialog(btnGetImage, "Choose Image");
					File f = jfc.getSelectedFile();
					String rs = ScanedImage.printText(f);
					textArea.setText(rs);
				} while (false);

			}
		});
		
		JButton btnSpeak = new JButton("Speak");
		btnSpeak.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = textArea.getText();
				tts.speak(text, 2.0f, false, true);
			}
		});
		btnSpeak.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnSpeak.setBounds(26, 330, 281, 46);
		panelBody.add(btnSpeak);
	}
}
