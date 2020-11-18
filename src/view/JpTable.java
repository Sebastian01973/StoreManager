package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JpTable extends JPanel {
    private JTable jTable;
    private DefaultTableModel dtmElements;
    private JScrollPane jScrollPane;
    private String[]  headers;

    public JpTable(ActionListener action, MouseListener mouseListener) {
        dtmElements = new DefaultTableModel() {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        dtmElements.setColumnIdentifiers(Constant.MAIN_HEADERS);
        this.setLayout(new BorderLayout());
        initComponents(action, mouseListener);
    }
    private void initComponents(ActionListener action, MouseListener mouseListener){
        jTable = new JTable();
        jTable = new JTable();
        jTable.setModel(dtmElements);
        jTable.setIntercellSpacing(new Dimension(0, 0));
        jTable.getTableHeader().setReorderingAllowed(false);
        jTable.getTableHeader().setBackground(Constant.C_DARK_BLUE);
        jTable.getTableHeader().setForeground(Color.WHITE);
        jTable.getTableHeader().setPreferredSize(new Dimension(0, 50));
        jTable.getTableHeader().setFont(Constant.FONT_ARIAL_ROUNDER_17);
        jTable.getTableHeader().setResizingAllowed(false);
        jTable.setFont(Constant.FONT_ARIAL_ROUNDER_15);
        jTable.setBackground(Color.WHITE);
        jTable.setFillsViewportHeight(false);
        jTable.setRowHeight( 35 );
        jTable.setBorder(null);
        jTable.addMouseListener(mouseListener);
        jTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setForeground(Color.white);
        jScrollPane.setBorder(null);
        jScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.setBorder(null);
    }

    public void addRowTable(Object[] vector){
        dtmElements.addRow(vector);
    }

    public void cleanRowsTable() {
        dtmElements.setNumRows(0);
    }

    private void centerText() {
        DefaultTableCellRenderer centeRenderer = new DefaultTableCellRenderer();
        centeRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setCellRenderer(centeRenderer);
        }
    }

    public void addRowsToTable(ArrayList<Object[]> matrix, String[] newHeaders){
        cleanRowsTable();
        this.headers = newHeaders;
        dtmElements.setColumnIdentifiers(newHeaders);
        this.centerText();
        for (Object[] objects : matrix) {
            addRowTable(objects);
        }
    }

    public String getSelectedRow(Point point ){
        int selectedRow = jTable.rowAtPoint(point);
        return String.valueOf(jTable.getValueAt(selectedRow,0));
    }
}
