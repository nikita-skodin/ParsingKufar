import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {

    private int columnCount = 4;
    private static ArrayList <String []> arrayList;

    public BookTableModel(){
        arrayList = new ArrayList<String []>();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public int getRowCount() {
        return arrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] mas = arrayList.get(rowIndex);
        return mas[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> "Id";
            case 1 -> "Название товара";
            case 2 -> "Цена";
            case 3 -> "Регион";
            default -> "";
        };
    }

    public static void addDate(String[] row){
        String[] rowTable;
        rowTable = row;
        arrayList.add(rowTable);
    }
}
