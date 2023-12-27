package Main.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;

import aims.Aims;
import media.Disc;
import media.Media;
import media.Playable;

public class MediaStore extends JPanel {
	private Media media;
	
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title =  new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Aims.cart.addMedia(media);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JDialog dialog = new JDialog();
				String info = "Media added to cart succesfully";
				JTextArea statusDialog = new JTextArea(info);
				
				statusDialog.setEditable(false);
				dialog.add(statusDialog);

				dialog.setTitle("Info");
				dialog.setLocationRelativeTo(null);
				dialog.setSize(new Dimension(200, 75));
				dialog.setVisible(true);
			}
		});
		container.add(addToCartButton);
		
		if (media instanceof Playable) {
			Disc disc = (Disc) media;
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialog dialog = new JDialog();
					String info = "Title: " + disc.getTitle()
								+ "\nCategory: " + disc.getCategory()
								+ "\nDirector: " + disc.getDirector()
								+ "\nLength: " + disc.getLength()
								+ "\nCost: " + disc.getCost() ;
					JTextArea mediaInfo = new JTextArea(info);
					
					mediaInfo.setEditable(false);
					dialog.add(mediaInfo);

					dialog.setTitle("Playing " + media.getTitle() + " (demo)");
					dialog.setLocationRelativeTo(null);
					dialog.setSize(new Dimension(400, 400));
					dialog.setVisible(true);
				}
			});
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
