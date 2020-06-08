import Utils.ArrayUtils;
import Utils.SwingUtils;
import com.company.Console;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileNotFoundException;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        if (args.length != 2 && args.length != 3){
            System.err.println("Введены неправильные аргументы");
            return;
        }
        if (!"console".equals(args[0]) & !"window".equals(args[0])){
            System.err.println("Выберите вид программы");
            return;
        }
        int[][] array = ArrayUtils.readIntArray2FromFile(args[1]);

        if (array.length == 0) {
            System.err.println("В исходном файле не содержится массив");
            return;
        }

        if ("console".equals(args[0])) {
            Console console = new Console();
            try {
                console.play(args[2], array);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else if ("window".equals(args[0])) {
            SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    (new MasForm()).setVisible(true);
                }
            });
        }
    }
}
