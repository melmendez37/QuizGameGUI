import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

public class Quiz implements ActionListener{

    //questions
    String[] questions = {
        "What is 1+1?",
        "What is this subject?",
        "What programming language are we using?",
        "When was Xavier University - Ateneo de Cagayan established?",
        "Who created the Society of Jesus?",
        "What country has the highest life expectancy?",
        "What is the most common surname in the United States?",
        "What year was the United Nations established?",
        "How many ghosts chase Pac-Man at the start of each game?",
        "Who discovered that the earth revolves around the sun?"
    };

    //choices of answers
    String [][] choices = {
        {"11", "2", "1"},
        {"CSCC34", "CSCC21", "CSCC20"},
        {"C++", "Python", "Java"},
        {"1933", "1925", "2020"},
        {"St. Ignatius of Loyola", "St. Peter Faber", "St. Francis Xavier"},
        {"Wakanda", "Hong Kong", "Taiwan"},
        {"Smith", "Brent", "John"},
        {"1944", "1945", "1946"},
        { "1", "2", "4"},
        {"Nicholas Cage", "Nicholas Nickleby", "Nicolaus Copernicus"}


    };

    //answers
    char[] answers = { 'B', 'C', 'C', 'A', 'A', 'B', 'A', 'B', 'C', 'C'};
 
    char guess;
    char answer;
    int index;
    int pone_score = 0;
    int ptwo_score = 0;
    int total_questions = questions.length;
    int result;
    int secs = 15;

    JFrame frame = new JFrame();
    JTextField tfield = new JTextField();
    JTextArea tarea = new JTextArea();

    JButton bA = new JButton();
    JButton bB = new JButton();
    JButton bC = new JButton();

    JLabel alabelA = new JLabel();
    JLabel alabelB = new JLabel();
    JLabel alabelC = new JLabel();
    JLabel time = new JLabel();
    JLabel seconds_left = new JLabel();
    JLabel who_player = new JLabel();
    JTextField player_one = new JTextField();
    JTextField player_two = new JTextField();

    String currentPlayer = "one";

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
            secs--;
            seconds_left.setText(String.valueOf(secs));
            if(secs<=0){
                displayAnswer();
                //switch to player two
            }
        }
    });

    public Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);

        tfield.setBounds(0,0, 300, 50);
        tfield.setBackground(new Color(25,25,25));
        tfield.setForeground(new Color(25,220,0));
        tfield.setFont(new FontUIResource("Helvetica", Font.BOLD, 20));
        tfield.setBorder(BorderFactory.createBevelBorder(1));
        tfield.setHorizontalAlignment(JTextField.CENTER);
        tfield.setEditable(false);

        tarea.setBounds(0,50, 300, 50);
        tarea.setLineWrap(true);
        tarea.setWrapStyleWord(true);
        tarea.setBackground(new Color(25,25,25));
        tarea.setForeground(new Color(25,220,0));
        tarea.setFont(new FontUIResource("Helvetica", Font.PLAIN, 16));
        tarea.setBorder(BorderFactory.createBevelBorder(1));
        tarea.setEditable(false);

        bA.setBounds(0, 100, 50, 50);
        bA.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bA.setFocusable(false);
        bA.addActionListener(this);
        bA.setText("A");

        bB.setBounds(0, 150, 50, 50);
        bB.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bB.setFocusable(false);
        bB.addActionListener(this);
        bB.setText("B");

        bC.setBounds(0, 200, 50, 50);
        bC.setFont(new Font("Helvetica", Font.PLAIN, 20));
        bC.setFocusable(false);
        bC.addActionListener(this);
        bC.setText("C");

        alabelA.setBounds(60,100,200,50);
        alabelA.setBackground(new Color(50,50,50));
        alabelA.setForeground(new Color(25, 255, 0));
        alabelA.setFont(new Font("Helvetica", Font.PLAIN, 16));

        alabelB.setBounds(60,150,200,50);
        alabelB.setBackground(new Color(50,50,50));
        alabelB.setForeground(new Color(25, 255, 0));
        alabelB.setFont(new Font("Helvetica", Font.PLAIN, 16));

        alabelC.setBounds(60,200,200,50);
        alabelC.setBackground(new Color(50,50,50));
        alabelC.setForeground(new Color(25, 255, 0));
        alabelC.setFont(new Font("Helvetica", Font.PLAIN, 16));

        seconds_left.setBounds(300, 0, 100, 100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Helvetica", Font.BOLD, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(secs));

        time.setBounds(500,480,100,20);
        time.setBackground(new Color(25,25,25));
        time.setForeground(new Color(255,0,0));
        time.setFont(new Font("Helvetica", Font.PLAIN, 16));
        time.setHorizontalAlignment(JTextField.CENTER);

        player_one.setBounds(300,100,100,50);
        player_one.setBackground(new Color(25,25,25));
        player_one.setForeground(new Color(25,255,0));
        player_one.setFont(new Font("Helvetica", Font.PLAIN, 30));
        player_one.setBorder(BorderFactory.createBevelBorder(1));
        player_one.setHorizontalAlignment(JTextField.CENTER);
        player_one.setEditable(false);

        player_two.setBounds(300,150,100,50);
        player_two.setBackground(new Color(25,25,25));
        player_two.setForeground(new Color(25,255,0));
        player_two.setFont(new Font("Helvetica", Font.PLAIN, 30));
        player_two.setBorder(BorderFactory.createBevelBorder(1));
        player_two.setHorizontalAlignment(JTextField.CENTER);
        player_two.setEditable(false);


        frame.add(player_one);
        frame.add(player_two);
        frame.add(time);

        frame.add(seconds_left);
        frame.add(alabelA);
        frame.add(alabelB);
        frame.add(alabelC);

        frame.add(bA);
        frame.add(bB);
        frame.add(bC);
        frame.add(tarea);
        frame.add(tfield);
        frame.setVisible(true);
    
        nextQuestion();
    }

    public void nextQuestion(){

        //displays ur qustions
        if(index>=total_questions){
            results();

        }
        else{
            tfield.setText("Question for player " + currentPlayer);
            tarea.setText(questions[index]);
            alabelA.setText(choices[index][0]);
            alabelB.setText(choices[index][1]);
            alabelC.setText(choices[index][2]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //sumbit an answer

        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);

        if(e.getSource()==bA){
            answer = 'A';
            if(answer == answers[index]){
                if(currentPlayer.equals("one"))
                pone_score++;
                else
                ptwo_score++;
            }
        }
        if(e.getSource()==bB){
            answer = 'B';
            if(answer == answers[index]){
                if(currentPlayer.equals("one"))
                pone_score++;
                else
                ptwo_score++;
            }
        }
        if(e.getSource()==bC){
            answer = 'C';
            if(answer == answers[index]){
                if(currentPlayer.equals("one"))
                pone_score++;
                else
                ptwo_score++;
            }
        }

        player_one.setText("P1: " + Integer.toString(pone_score));
        player_two.setText("P2: " +Integer.toString(ptwo_score));

        if(pone_score == 3 || ptwo_score == 3){
            timer.stop();
            results();
        }
        else{
        displayAnswer();
        }

    }

    public void displayAnswer(){

        timer.stop();
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);

        if(answers[index] != 'A')
            alabelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            alabelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            alabelC.setForeground(new Color(255,0,0));
        
        Timer pause = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                alabelA.setForeground(new Color(25,255,0));
                alabelB.setForeground(new Color(25,255,0));
                alabelC.setForeground(new Color(25,255,0));

                answer = ' ';
                secs = 15;
                seconds_left.setText(String.valueOf(secs));
                bA.setEnabled(true);
                bB.setEnabled(true);
                bC.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();
        currentPlayer = currentPlayer == "one" ? "two" : "one";
    }

    public void results(){
        bA.setEnabled(false);
        bB.setEnabled(false);
        bC.setEnabled(false);

        tfield.setText("Winner! " + "Player " + currentPlayer);
        tarea.setText("");
        alabelA.setText("");
        alabelB.setText("");
        alabelC.setText("");
    }
}