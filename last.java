import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class last extends JFrame implements ActionListener {

    JButton obj[] = new JButton[9];
    JLabel l1;

    ImageIcon img1 = new ImageIcon("circle.png");
    ImageIcon img2 = new ImageIcon("cross.png");

    int a = 0;
    int count = 0;
    int arr[] = new int[9];

    last(int x) {
        l1 = new JLabel("Player1: X                             Player2: O");
        l1.setHorizontalTextPosition(JLabel.CENTER);
        l1.setVerticalTextPosition(JLabel.CENTER);
        l1.setFont(new Font("MV Boli", Font.BOLD, 15));
        l1.setForeground(Color.cyan);
        l1.setBounds(0, 0, 400, 50);
        l1.setBackground(new Color(0x04aa6d));
        l1.setOpaque(true);

        this.a = x;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tic-Tac-Tao");
        this.setVisible(true);
        this.setSize(400, 480);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.add(l1);

        for (int i = 0; i < 9; i++) {
            obj[i] = new JButton(String.valueOf(i));
            if (i < 3) {
                obj[i].setBounds((i % 3) * 130, 50, 130, 130);
            } else {
                obj[i].setBounds((i % 3) * 130, ((i / 3) * 130) + 50, 130, 130);
            }
            this.add(obj[i]);
            obj[i].addActionListener(this);
        }
    }

    void winDisplay(int x) {
        if (x == 1) {
            l1.setText("                Winner: Player1 (X)              ");
            l1.setBounds(0, 0, 400, 50);
        } else {
            l1.setText("                 Winner: Player1 (O)              ");
            l1.setBounds(0, 0, 400, 50);
        }

    }

    void check() {

        // Left_right
        for (int i = 1; i < 9; i += 3) {
            if ((arr[i] == 1) && (arr[i - 1] == 1) && (arr[i + 1] == 1)) {
                obj[i].setBackground(Color.green);
                obj[i - 1].setBackground(Color.green);
                obj[i + 1].setBackground(Color.green);
                winDisplay(1);
                break;
            } else if ((arr[i] == 2) && (arr[i - 1] == 2) && (arr[i + 1] == 2)) {
                obj[i].setBackground(Color.green);
                obj[i - 1].setBackground(Color.green);
                obj[i + 1].setBackground(Color.green);
                winDisplay(2);
                break;
            }
        }

        // top_bottom
        for (int i = 3; i < 6; i++) {
            if ((arr[i] == 1) && (arr[i - 3] == 1) && (arr[i + 3] == 1)) {
                obj[i].setBackground(Color.green);
                obj[i - 3].setBackground(Color.green);
                obj[i + 3].setBackground(Color.green);
                winDisplay(1);

                break;
            } else if ((arr[i] == 2) && (arr[i - 3] == 2) && (arr[i + 3] == 2)) {
                obj[i].setBackground(Color.green);
                obj[i - 3].setBackground(Color.green);
                obj[i + 3].setBackground(Color.green);
                winDisplay(2);
                break;
            }
        }

        // diagnols

        if (((arr[4] == 1) && (arr[0] == 1) && (arr[8] == 1))) {
            obj[4].setBackground(Color.green);
            obj[0].setBackground(Color.green);
            obj[8].setBackground(Color.green);
            winDisplay(1);
        }

        else if (((arr[4] == 2) && (arr[0] == 2) && (arr[8] == 2))) {
            obj[4].setBackground(Color.green);
            obj[0].setBackground(Color.green);
            obj[8].setBackground(Color.green);
            winDisplay(2);
        }

        else if (((arr[4] == 1) && (arr[2] == 1) && (arr[6] == 1))) {
            obj[4].setBackground(Color.green);
            obj[2].setBackground(Color.green);
            obj[6].setBackground(Color.green);
            winDisplay(1);
        }

        else if (((arr[4] == 2) && (arr[2] == 2) && (arr[6] == 2))) {
            obj[4].setBackground(Color.green);
            obj[2].setBackground(Color.green);
            obj[6].setBackground(Color.green);
            winDisplay(2);
        }

    }

    void setValues(JButton x) {
        x.setEnabled(false);
        x.setBackground(Color.darkGray);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == obj[0]) {
            if (a == 1) {
                arr[0] = 1;
                setValues(obj[0]);
                obj[0].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[0] = 2;
                setValues(obj[0]);
                obj[0].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[1]) {
            arr[1] = 1;
            if (a == 1) {
                setValues(obj[1]);
                obj[1].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[1] = 2;
                setValues(obj[1]);
                obj[1].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[2]) {
            if (a == 1) {
                arr[2] = 1;
                setValues(obj[2]);
                obj[2].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[2] = 2;
                setValues(obj[2]);
                obj[2].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[3]) {
            if (a == 1) {
                arr[3] = 1;
                setValues(obj[3]);
                obj[3].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[3] = 2;
                setValues(obj[3]);
                obj[3].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[4]) {
            if (a == 1) {
                arr[4] = 1;
                setValues(obj[4]);
                obj[4].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[4] = 2;
                setValues(obj[4]);
                obj[4].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[5]) {
            if (a == 1) {
                arr[5] = 1;
                setValues(obj[5]);
                obj[5].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[5] = 2;
                setValues(obj[5]);
                obj[5].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[6]) {
            if (a == 1) {
                arr[6] = 1;
                setValues(obj[6]);
                obj[6].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[6] = 2;
                setValues(obj[6]);
                obj[6].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[7]) {
            if (a == 1) {
                arr[7] = 1;
                setValues(obj[7]);
                obj[7].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[7] = 2;
                setValues(obj[7]);
                obj[7].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }

        else if (e.getSource() == obj[8]) {
            if (a == 1) {
                arr[8] = 1;
                setValues(obj[8]);
                obj[8].setIcon(img2);
                if (++count >= 5) {
                    check();
                }
                a = 0;
            } else {
                arr[8] = 2;
                setValues(obj[8]);
                obj[8].setIcon(img1);
                if (++count >= 5) {
                    check();
                }
                a = 1;
            }
        }
    }

    public static void main(String[] args) {
        if ((int) Math.round(Math.random()) == 1) {
            new last(1);
        }
    }
}
