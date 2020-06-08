import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class masTabModel extends AbstractTableModel {

    private int columnCount = 1;
    private ArrayList<String []> dataArrayList;

    public masTabModel(){
        dataArrayList = new ArrayList<String []>();
        for (int i = 0; i < dataArrayList.size();i++){
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void addData(String []row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;

    }

}
