package lab6;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public JLabel label;
    public JSpinner sidesField;
    public JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init() {
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3);
        colorCombo = new JComboBox<String>();
        colorCombo.addItem("Random");
        colorCombo.addItem("Black");
        add(label);
        add(sidesField);
        add(colorCombo);
    }
    
    public JComboBox getColor() {
    	return colorCombo;
    }
}