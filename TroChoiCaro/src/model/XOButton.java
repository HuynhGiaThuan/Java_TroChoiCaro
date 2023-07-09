/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class XOButton extends JButton {
	private ImageIcon X;
	private ImageIcon O;
	public Point point;
	public static boolean isXMove = true;
	public int value = 0;
	
	public XOButton(int x, int y) {
		X = new ImageIcon("./src/Photo//icons8_delete_24px_1.png");
		O = new ImageIcon("./src/Photo//icons8_round_24px.png");
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.setIcon(new ImageIcon("assets/image/blank.jpg"));
		this.point = new Point(x, y);
              
               
                XOButton _this = this;
		this.addMouseListener( new MouseListener() {

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
//                        if(_this.isEnabled()){
//                            _this.setBackground(Color.GRAY);
//                            _this.setIcon(new ImageIcon(".//Photo//unnamed.png"));
//                        }Point(x, y)
                            
                      
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
//                        if(_this.isEnabled()) {
//                            _this.setBackground(Color.RED);
//                            _this.setIcon(new ImageIcon("assets/image/x3.jpg"));
//                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // TODO Auto-generated method stub
//                        _this.setIcon(null);
                    }
                });
	}
	
	public void setState(Boolean isXMove) {
		if (isXMove) {
			setIcon(X);
			value = 2;
			XOButton.isXMove = false;
                        this.setDisabledIcon(X);
		} else {
			setIcon(O);
			value = 1;
                        this.setDisabledIcon(O);
			XOButton.isXMove = true;
		}
	}
        public void resetState(){
            value = 0;
            this.setEnabled(true);
            this.setIcon(new ImageIcon("assets/image/blank.jpg"));
            this.setDisabledIcon(new ImageIcon("assets/image/blank.jpg"));
        }
	
	
}