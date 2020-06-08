import Utils.ArrayUtils;
import Utils.JTableUtils;
import Utils.SwingUtils;
import com.company.Logic;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MasForm extends JFrame {

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;
    private JPanel jPanel;
    private JTable table1;
    private JButton button1;
    private JTable table2;
    private JButton button2;
    private JButton button3;

    public MasForm() {
        this.setTitle("");
        this.setContentPane(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setSize(700, 500);
        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(table1, arr);
                    }
                } catch (Exception e2 )
                {
                    SwingUtils.showErrorMessageBox(e2);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int[][] array = JTableUtils.readIntMatrixFromJTable(table1);
                    int[][] myArr = Logic.process(array);
                    JTableUtils.writeArrayToJTable(table2, myArr);
                } catch (Exception e1) {
                    SwingUtils.showErrorMessageBox(e1);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserSave.showSaveDialog(jPanel) == JFileChooser.APPROVE_OPTION) {
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        int[][] arr = JTableUtils.readIntMatrixFromJTable(table2);
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e1) {
                    SwingUtils.showErrorMessageBox(e1);
                }
            }
        });
    }
}
