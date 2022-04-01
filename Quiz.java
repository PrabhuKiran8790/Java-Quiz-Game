package com.prabhu.quiz_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {

    ReadExcel sheet = new ReadExcel("F:\\Java\\src\\com\\prabhu\\quiz_app\\data.xlsx");

    String answer;
    char index;
    int correct_guesses = 0;
    int total_questions = sheet.getQuestions().length;
    int result;
    int seconds = 30;

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 720);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0, 0, 720, 50);
        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Times New Roman", Font.BOLD, 25));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Quiz App");

        textarea.setBounds(0, 50, 720, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setText("Sample Text");

        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 210, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 320, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 430, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(255, 255, 255));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
        answer_labelA.setText("Text Label A");

        answer_labelB.setBounds(125, 210, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(255, 255, 255));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
        answer_labelB.setText("Text Label B");


        answer_labelC.setBounds(125, 320, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(255, 255, 255));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
        answer_labelC.setText("Text Label C");


        answer_labelD.setBounds(125, 430, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(255, 255, 255));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
        answer_labelD.setText("Text Label D");


        seconds_left.setBounds(610, 580, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("MV Boli", Font.BOLD, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));


        time_label.setBounds(610, 545, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Time Left");


        number_right.setBounds(225, 225, 415, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("MV Boli", Font.BOLD, 20));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 415, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("MV Boli", Font.BOLD, 20));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(seconds_left);
        frame.add(time_label);
//        frame.add(number_right);
//        frame.add(percentage);
        frame.add(textarea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();
    }    Timer timer = new Timer(1000, actionEvent -> {
        seconds--;
        seconds_left.setText(String.valueOf(seconds));
        if (seconds <= 0) {
            displayAnswer();
        }
    });


    /*
    separate methods for next question, button clicks,
    displaying answer and result
     */

    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textField.setText("Question " + (index + 1));
            textarea.setText(sheet.getQuestions()[index]);
            answer_labelD.setText(sheet.getOptions()[index][3]);
            answer_labelA.setText(sheet.getOptions()[index][0]);
            answer_labelB.setText(sheet.getOptions()[index][1]);
            answer_labelC.setText(sheet.getOptions()[index][2]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = "A";
            if (answer.equals(sheet.getCorrectOptions()[index])) {
                correct_guesses++;
            }
        }

        if (e.getSource() == buttonB) {
            answer = "B";
            if (answer.equals(sheet.getCorrectOptions()[index])) {
                correct_guesses++;
            }
        }

        if (e.getSource() == buttonC) {
            answer = "C";
            if (answer.equals(sheet.getCorrectOptions()[index])) {
                correct_guesses++;
            }
        }

        if (e.getSource() == buttonD) {
            answer = "D";
            if (answer.equals(sheet.getCorrectOptions()[index])) {
                correct_guesses++;
            }
        }
        displayAnswer();

    }

    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (!(sheet.getCorrectOptions()[index]).equals("A")) answer_labelA.setForeground(new Color(255, 0, 0));
        if ((sheet.getCorrectOptions()[index]).equals("A")) answer_labelA.setForeground(new Color(25, 255, 0));

        if (!(sheet.getCorrectOptions()[index]).equals("B")) answer_labelB.setForeground(new Color(255, 0, 0));
        if ((sheet.getCorrectOptions()[index]).equals("B")) answer_labelB.setForeground(new Color(25, 255, 0));

        if (!(sheet.getCorrectOptions()[index]).equals("C")) answer_labelC.setForeground(new Color(255, 0, 0));
        if ((sheet.getCorrectOptions()[index]).equals("C")) answer_labelC.setForeground(new Color(25, 255, 0));

        if (!(sheet.getCorrectOptions()[index]).equals("D")) answer_labelD.setForeground(new Color(255, 0, 0));
        if ((sheet.getCorrectOptions()[index]).equals("D")) answer_labelD.setForeground(new Color(25, 255, 0));


        Timer pause = new Timer(800, actionEvent -> {
            answer_labelA.setForeground(new Color(255, 255, 255));
            answer_labelB.setForeground(new Color(255, 255, 255));
            answer_labelC.setForeground(new Color(255, 255, 255));
            answer_labelD.setForeground(new Color(255, 255, 255));

            answer = " ";
            seconds = 30;
            seconds_left.setText(String.valueOf(seconds));
            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);
            index++;
            nextQuestion();
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        time_label.setText("Result");
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        textField.setText("Results!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        result = (int) ((correct_guesses / (double) total_questions) * 100);

        number_right.setText("(" + correct_guesses + "/" + total_questions + ") Questions answered correctly");
        seconds_left.setBounds(610, 580, 100, 100);
        seconds_left.setFont(new Font("MV Boli", Font.BOLD, 35));
        if (result < 75) {
            percentage.setForeground(new Color(255, 0, 0));
            percentage.setText("Your Score: " + result);
            seconds_left.setForeground(new Color(255, 0, 0));
            seconds_left.setText("Fail");
        }
        if (result >= 75) {
            percentage.setForeground(new Color(25, 255, 0));
            percentage.setText("Your Score: " + result);
            seconds_left.setForeground(new Color(25, 255, 0));
            seconds_left.setText("Pass");
        }
        frame.add(number_right);
        frame.add(percentage);
    }
}