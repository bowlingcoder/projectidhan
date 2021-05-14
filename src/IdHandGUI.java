import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IdHandGUI extends JFrame{
    private JPanel cardPanel;
    private JPanel battlePanel;
    private JTable table1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton attackButton;
    private JButton defendButton;
    private JButton skipButton;
    private JButton abilitiesButton;

    public void testCombat(){
        Setup.playerCombat=new Combat();
        Character opponent=new Character();
        Setup.playerCombat.grid.addCharacter(opponent,5,3);
        table1.setRowHeight(30);
        String[] columnNames = { "0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19" };
        //table1=new JTable(testCombat.grid.getMap(),columnNames);
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        String[][]tiles=Setup.playerCombat.grid.getMap();
        for (int x=0;x<tiles.length;x++) {
            model.addColumn(columnNames[x]);
        }
        for (int y = 0; y < tiles[0].length; y++) {
            model.addRow(tiles[y]);
        }
    }

    public IdHandGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cardPanel);
        this.pack();
        this.setSize(1500,900);

        table1.setRowHeight(30);
        table1.setCellSelectionEnabled(true);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JTable table = (JTable) e.getSource();
                int column = table.columnAtPoint(e.getPoint());
                int row = table.rowAtPoint(e.getPoint());
                Character tempCharacter=Setup.playerCombat.grid.tiles[row][column].currentCharacter;
                if (tempCharacter!=null){
                    textArea1.setText(tempCharacter.displayCharacter());
                }
                else{
                    textArea1.setText("");
                }
            }
        });
        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Setup.playerCombat.selectedActionType!=1){
                    Setup.playerCombat.selectedActionType=1;
                }
                else{
                    Setup.playerCombat.selectedActionType=0;
                }
            }
        });
    }

    public static void main(String[] args){
        IdHandGUI frame = new IdHandGUI();
        frame.setVisible(true);
        frame.testCombat();
    }
}
