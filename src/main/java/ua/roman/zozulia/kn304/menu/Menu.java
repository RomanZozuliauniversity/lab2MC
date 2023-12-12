package ua.roman.zozulia.kn304.menu;

import ua.roman.zozulia.kn304.massServiceSystems.Mss;
import ua.roman.zozulia.kn304.massServiceSystems.MssCalculator;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Menu {
    private int count;
    private double[][] mass;

    private int beginAdmissionRange;
    private int endAdmissionRange;

    private int beginServiceRange;
    private int endServiceRange;

    private JTextField textFieldCounfOfCastomers;
    private JTextField[] jTextFields;
    private JTextField[] jTextFields1;

    public void createMenu(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        JFrame frame = new JFrame("Лабораторна робота 2");
        frame.setBounds(dimension.width/2- 700,dimension.height/2 - 350,1400,700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.CYAN);
        frame.add(leftPanel);

        JLabel countOfCastomers = new JLabel("Кількість покупців");
        countOfCastomers.setFont(new Font("s",Font.BOLD,14));
        countOfCastomers.setBounds(15,16,150,30);
        textFieldCounfOfCastomers = new JTextField();
        textFieldCounfOfCastomers.setBounds(200,20,50,20);
        leftPanel.add(countOfCastomers);
        leftPanel.add(textFieldCounfOfCastomers);

        JLabel label = new JLabel("Введіть знвчення генератора х0:");
        label.setFont(new Font("s",Font.BOLD,14));
        label.setBounds(15,40,270,30);
        leftPanel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(265,48,60,20);
        leftPanel.add(textField);

        JLabel label1 = new JLabel("Діапазон проміжку часу між");
        label1.setFont(new Font("s",Font.BOLD,14));
        label1.setBounds(15,80,200,30);
        leftPanel.add(label1);

        JLabel label2 = new JLabel("поступленням заявок        [ ");
        label2.setFont(new Font("s",Font.BOLD,14));
        label2.setBounds(15,92,200,30);
        leftPanel.add(label2);

        jTextFields = new JTextField[2];

        jTextFields[0] = new JTextField();
        jTextFields[0].setBounds(216,98,40,20);
        leftPanel.add(jTextFields[0]);

        JLabel label3 = new JLabel(";");
        label3.setFont(new Font("s",Font.BOLD,14));
        label3.setBounds(260,92,5,30);
        leftPanel.add(label3);

        jTextFields[1] = new JTextField();
        jTextFields[1].setBounds(267,98,40,20);
        leftPanel.add(jTextFields[1]);


        JLabel label4 = new JLabel(" ] хв.");
        label4.setFont(new Font("s",Font.BOLD,14));
        label4.setBounds(312,92,60,30);
        leftPanel.add(label4);






        JLabel label5 = new JLabel("Діапазон часу");
        label5.setFont(new Font("s",Font.BOLD,14));
        label5.setBounds(15,128,200,30);
        leftPanel.add(label5);

        JLabel label6 = new JLabel("обслуговування заявок    [ ");
        label6.setFont(new Font("s",Font.BOLD,14));
        label6.setBounds(15,140,200,30);
        leftPanel.add(label6);

        jTextFields1 = new JTextField[2];

        jTextFields1[0] = new JTextField();
        jTextFields1[0].setBounds(216,146,40,20);
        leftPanel.add(jTextFields1[0]);

        JLabel label7 = new JLabel(";");
        label7.setFont(new Font("s",Font.BOLD,14));
        label7.setBounds(260,140,5,30);
        leftPanel.add(label7);

        jTextFields1[1] = new JTextField();
        jTextFields1[1].setBounds(267,146,40,20);
        leftPanel.add(jTextFields1[1]);


        JLabel label8 = new JLabel(" ] хв.");
        label8.setFont(new Font("s",Font.BOLD,14));
        label8.setBounds(312,140,60,30);
        leftPanel.add(label8);

        JButton button = new JButton("Oбчислити");
        button.setBounds(130,200,120,30);
        button.setBackground(Color.white);
        leftPanel.add(button);

        button.addActionListener(e -> {
            try {

                count = Integer.parseInt(textFieldCounfOfCastomers.getText());
                beginAdmissionRange = Integer.parseInt(jTextFields[0].getText());
                endAdmissionRange = Integer.parseInt(jTextFields[1].getText());
                beginServiceRange = Integer.parseInt(jTextFields1[0].getText());
                endServiceRange = Integer.parseInt(jTextFields1[1].getText());

            }catch (Exception ex){
                JFrame f= new JFrame();
                JOptionPane.showMessageDialog(f,"Помилка з вводом даних","Результат",JOptionPane.ERROR_MESSAGE);
            }

            MssCalculator calculator = new MssCalculator(count,beginAdmissionRange,endAdmissionRange,beginServiceRange,endServiceRange);
            mass = new double[100][8];
            mass = calculator.calculate();

            JPanel rightPanel = new JPanel();
            rightPanel.setBackground(Color.white);
            String[] array = new String[]{"N","t1","t2","t3","t4","t5","t6","t7"};
            String[][] result = new String[count][8];

            double sum1=0,sum2=0,sum5=0,sum6=0,sum7=0;

            for (int i = 0; i < count; i++) {
                sum1 += mass[i][1];
                sum2 += mass[i][2];
                sum6 += mass[i][6];
                sum5+= Mss.subtractUseHours(mass[i][4],mass[i][3]);
            }


            JLabel jlabel = new JLabel();
            jlabel.setFont(new Font("s",Font.BOLD,14));
            jlabel.setText("Інтенсивність вхідного потоку заявок = " + new DecimalFormat("#.###").format((1 / ((sum1 ) /count)))+" заявок/хв.");
            jlabel.setBounds(15,250,420,30);
            leftPanel.add(jlabel);

            JLabel jlabel1 = new JLabel();
            jlabel1.setFont(new Font("s",Font.BOLD,14));
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            jlabel1.setText("Час очікування обслуговування заявкою = "+ decimalFormat.format(sum5/count)+" хв.");
            jlabel1.setBounds(15,280,380,30);
            leftPanel.add(jlabel1);

            JLabel jlabel2 = new JLabel();
            jlabel2.setFont(new Font("s",Font.BOLD,14));
            jlabel2.setText("час перебування заявки в системі = "+decimalFormat.format(sum6/count)+" хв.");
            jlabel2.setBounds(15,310,380,30);
            leftPanel.add(jlabel2);


            JLabel jlabel3 = new JLabel();
            jlabel3.setFont(new Font("s",Font.BOLD,14));
            double co = (1 / ((sum1 ) / count))  / (1 / ((sum2 / count)));
            jlabel3.setText("Коефіцієнт завантаження системи = "+decimalFormat.format(co));
            jlabel3.setBounds(15,340,380,30);
            leftPanel.add(jlabel3);


            for (int i = 0; i < count; i++) {
                result[i][0] = String.valueOf(Math.round(mass[i][0]));
                result[i][6] = String.valueOf(Math.round(mass[i][6]));
                result[i][7] = String.valueOf(Math.round(mass[i][7]));
                for (int j = 1; j < 6; j++) {
                    result[i][j] = String.valueOf(decimalFormat.format(mass[i][j]));
                }
            }

            JTable table = new JTable(result,array);

            String[][] last_row = new String[1][mass[0].length];
            System.arraycopy(result[count - 1], 0, last_row[0], 0, last_row[0].length);

            JTable lastRow  = new JTable(last_row,array);
            lastRow.setBackground(Color.white);
            lastRow.setForeground(Color.black);
            lastRow.setEnabled(false);
            lastRow.setFont(new Font("font", Font.ITALIC,15));

            if (count<=30){
                lastRow.setBounds(440, 514, 900, 15);
            }else {
                lastRow.setBounds(440, 514, 882, 15);
            }
            table.setBackground(Color.white);
            table.setForeground(Color.black);
            table.setEnabled(false);
            table.setFont(new Font("font", Font.ITALIC,15));
            JScrollPane scroll = new JScrollPane(table); // створєм скролл
            scroll.setForeground(Color.white);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setBounds(440,10,900,504);
            table.updateUI();
            scroll.updateUI();

            leftPanel.add(scroll);

            leftPanel.add(lastRow);
            leftPanel.updateUI();
        });

    }
}
