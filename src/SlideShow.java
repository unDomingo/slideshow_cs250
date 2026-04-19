import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlideShow extends JFrame {

	// Declare variables used in the slideshow
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private JPanel bottomPanel;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		// Initialize layout managers
		card = new CardLayout();
		cardText = new CardLayout();

		// Initialize panels
		slidePane = new JPanel();
		textPane = new JPanel();
		buttonPane = new JPanel();
		bottomPanel = new JPanel(new BorderLayout());

		// Initialize buttons and labels
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		// Set up frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set layouts for slideshow and text panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);

		// Style the text panel so the updated destination description stands out
		textPane.setBackground(Color.BLUE);

		// Add each slide image and its matching text description
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();

			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			lblTextArea.setForeground(Color.WHITE);

			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		// Set up button panel
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		// Add text and buttons to one bottom panel so both display correctly
		bottomPanel.add(textPane, BorderLayout.CENTER);
		bottomPanel.add(buttonPane, BorderLayout.SOUTH);

		// Add main panels to the frame
		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}

	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Returns the image HTML for each slide.
	 * These file names must match the image files in the resources folder.
	 */
	private String getResizeIcon(int i) {
		String image = "";

		if (i == 1) {
			image = "<html><body><img width='800' height='500' src='"
					+ getClass().getResource("/resources/grandcanyon-unsplash.jpg")
					+ "'></body></html>";
		} else if (i == 2) {
			image = "<html><body><img width='800' height='500' src='"
					+ getClass().getResource("/resources/paris-unsplash.jpg")
					+ "'></body></html>";
		} else if (i == 3) {
			image = "<html><body><img width='800' height='500' src='"
					+ getClass().getResource("/resources/tokyo-unsplash.jpg")
					+ "'></body></html>";
		} else if (i == 4) {
			image = "<html><body><img width='800' height='500' src='"
					+ getClass().getResource("/resources/puntacana-unsplash.jpg")
					+ "'></body></html>";
		} else if (i == 5) {
			image = "<html><body><img width='800' height='500' src='"
					+ getClass().getResource("/resources/rome-unsplash.jpg")
					+ "'></body></html>";
		}

		return image;
	}

	/**
	 * Updated descriptions to reflect Product Owner's new requirement
	 * focusing on wellness and detox travel experiences while keeping
	 * the original destinations from the slideshow.
	 */
	private String getTextDescription(int i) {
		String text = "";

		if (i == 1) {
			text = "1. Grand Canyon - Now focused on wellness travel with guided hikes, fresh air, and relaxation in nature.";
		} else if (i == 2) {
			text = "2. Paris - Includes wellness experiences like spa treatments, walking tours, and stress-free exploration.";
		} else if (i == 3) {
			text = "3. Tokyo - Offers balance with peaceful gardens, healthy food, and calming cultural experiences.";
		} else if (i == 4) {
			text = "4. Punta Cana - Known for beachside relaxation, resort spas, and wellness-focused stays.";
		} else if (i == 5) {
			text = "5. Rome - Combines history with wellness through walking tours, fresh meals, and relaxation.";
		}

		return text;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}