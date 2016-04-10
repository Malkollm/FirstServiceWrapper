package com.company;

/**
 * Created by Марсель on 07.04.2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//узнат
public class Main implements ActionListener {

    /**
     * Инициализация компонентов окна Main
     */
    public Main() {
        initComponents();
    }

    //узнать
    private JFrame viewForm;

    private void initComponents() {
        /**
         *  Создание пользовательского окна
         */
        viewForm = new JFrame("Работа над службой");
        viewForm.setSize(600, 400);
        viewForm.setVisible(true);
        viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //Закрытие формы при нажатии на кнопку

        /**
         * Создание кнопок
         */
        JButton bInstService = new JButton("Установка службы");
        bInstService.setVisible(true);
        bInstService.setLocation(10, 25);
        bInstService.setSize(165, 50);
        /**
         * СОбытие для кнопки
         */
        bInstService.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Запуск исполняемой среды
                Runtime rt = Runtime.getRuntime();
                //Исполняемая среда
                String s = "C:/rja/bin/InstallApp-NT.bat";

                //Процессу присваивается значение null
                Process p=null;
                try{
                    //Процессу передается выполнение исполняемой среды
                    p = rt.exec(s);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(viewForm, "Установленно",
                        "Установка службы", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton bStartService = new JButton("Запуск службы");
        bStartService.setVisible(true);
        bStartService.setLocation(10, 105);
        bStartService.setSize(165, 50);
        bStartService.addActionListener(new ActionListener() {

            //Описание события для кнопки
            public void actionPerformed(ActionEvent e) {
                //Запуск исполняемой среды
                Runtime rt = Runtime.getRuntime();
                //Исполняемая среда
                String s = "C:/rja/bin/StartApp-NT.bat";

                //Процессу присваивается значение null
                Process p=null;
                try{
                    //Процессу передается выполнение исполняемой среды
                    p = rt.exec(s);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(viewForm, "Запущено",
                        "Запуск службы", JOptionPane.WARNING_MESSAGE);
            }
        });

        JButton bStopService = new JButton("Удаление службы");
        bStopService.setVisible(true);
        bStopService.setLocation(10, 185);
        bStopService.setSize(165, 50);
        bStopService.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Запуск исполняемой среды
                Runtime rt = Runtime.getRuntime();
                //Исполняемая среда
                String s = "C:/rja/bin/UninstallApp-NT.bat";

                //Процессу присваивается значение null
                Process p=null;
                try{
                    //Процессу передается выполнение исполняемой среды
                    p = rt.exec(s);
                } catch (IOException e1){
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(viewForm, "Удалено",
                        "Удаление службы", JOptionPane.WARNING_MESSAGE);
            }
        });

        /**
         * Добавляем на панель наши кнопки и метку
         */
        viewForm.getContentPane().add(bInstService);
        viewForm.getContentPane().add(bStartService);
        viewForm.getContentPane().add(bStopService);
        viewForm.getContentPane().add(new JLabel());
    }

    public void actionPerformed(ActionEvent action) {
    }


    public static void main(String[] args) {

        //узнать
        SwingUtilities.invokeLater(new Runnable() {
            //узнать
            public void run() {
                //узнать
                new Main();
            }
        });
    }
}

