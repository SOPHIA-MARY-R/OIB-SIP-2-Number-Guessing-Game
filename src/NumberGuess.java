import javax.swing.*;
import java.awt.*;

public class NumberGuess {
    JFrame jFrame = new JFrame();
    JLabel titleLabel = new JLabel("Guess the number (1-100)");
    JTextField textField = new JTextField();
    JButton checkButton = new JButton("Check");
    JLabel message = new JLabel("You lose 1 point for each wrong guess");
    JLabel attemptLabel = new JLabel("Attempts");
    JLabel attempt;
    JLabel scoreLabel = new JLabel("Score");
    JLabel score;
    JButton playAgain = new JButton("Play Again!");

    int generatedNumber = 1 + (int)(100 * Math.random());
    int attemptCount;
    int gameScore;

    public NumberGuess(){
        attempt = new JLabel("");
        score = new JLabel("");
        attemptCount = 0;
        gameScore = 101;

        titleLabel.setBounds(60, 70, 400, 20);
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));

        textField.setBounds(150, 100, 80, 30);
        textField.setFont(new Font("Sans Serif", Font.BOLD, 15));
        textField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        textField.setHorizontalAlignment(JLabel.CENTER);

        checkButton.setBounds(150, 140, 80, 30);
        checkButton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        checkButton.setFont(new Font("Sans Serif", Font.BOLD, 17));
        checkButton.setFocusable(false);
        checkButton.setBackground(new Color(255, 51, 153));
        checkButton.setForeground(new Color(255, 255, 255));
        checkButton.addActionListener(e -> {
            int guessedNumber = Integer.parseInt(textField.getText());
            textField.setText("");
            attemptCount++;
            gameScore--;
            attempt.setText(String.valueOf(attemptCount));
            score.setText(String.valueOf(gameScore));
            if(guessedNumber > generatedNumber){
                message.setText(guessedNumber + " is greater!!");
            }
            else if(guessedNumber < generatedNumber){
                message.setText(guessedNumber + " is less!");
            }
            else{
                message.setText("You win!! Score: " + gameScore);
                message.setFont(new Font("Sans Serif", Font.BOLD, 18));
            }
        });

        message.setBounds(30, 180, 300, 30);
        message.setFont(new Font("Sans Serif", Font.ITALIC, 16));
        message.setForeground(new Color(255, 255, 255));
        message.setOpaque(true);
        message.setBackground(new Color(17, 179, 158));
        message.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        message.setHorizontalAlignment(JLabel.CENTER);

        attemptLabel.setBounds(100, 250, 80, 30);
        attemptLabel.setForeground(new Color(255, 255, 255));
        attemptLabel.setFont(new Font("Sans Serif", Font.BOLD, 17));

        attempt.setBounds(200, 250, 80, 30);
        attempt.setFont(new Font("Sans Serif", Font.BOLD, 17));
        attempt.setOpaque(true);
        attempt.setBackground(new Color(255, 255, 255));
        attempt.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        attempt.setHorizontalAlignment(JLabel.CENTER);

        scoreLabel.setBounds(100, 290, 80, 30);
        scoreLabel.setForeground(new Color(255, 255, 255));
        scoreLabel.setFont(new Font("Sans Serif", Font.BOLD, 17));

        score.setBounds(200, 290, 80, 30);
        score.setFont(new Font("Sans Serif", Font.BOLD, 17));
        score.setOpaque(true);
        score.setBackground(new Color(255, 255, 255));
        score.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        score.setHorizontalAlignment(JLabel.CENTER);

        playAgain.setBounds(130, 340, 130, 30);
        playAgain.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        playAgain.setFont(new Font("Sans Serif", Font.PLAIN, 17));
        playAgain.setFocusable(false);
        playAgain.setBackground(new Color(255, 51, 153));
        playAgain.setForeground(new Color(255, 255, 255));
        playAgain.addActionListener(e -> {
            jFrame.dispose();
            new NumberGuess();
        });

        jFrame.add(titleLabel);
        jFrame.add(textField);
        jFrame.add(checkButton);
        jFrame.add(message);
        jFrame.add(attemptLabel);
        jFrame.add(attempt);
        jFrame.add(scoreLabel);
        jFrame.add(score);
        jFrame.add(playAgain);

        jFrame.getContentPane().setBackground(new Color(73, 142, 232));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
