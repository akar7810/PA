package lab12;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    private final JLabel nameLabel = new JLabel("Class Name:");
    private final JTextField nameField = new JTextField(30);
    private final JTextField baseField = new JTextField(30);
    private final JButton addButton = new JButton("Add component");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        add(nameLabel);
        add(nameField);
        add(baseField);
        add(addButton);
        addButton.addActionListener(e ->
        {
            JComponent newComp;
			try {
				newComp = createComponent(nameField.getText(),baseField.getText());
				 if (newComp != null) {
		                frame.designPanel.addAtRandomLocation(newComp);
		            }
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
        });

    }

    private JComponent createComponent(String name, String base) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

            Class newComp = Class.forName(name);
            Component component = (Component) newComp.getConstructor().newInstance();
            Method method = newComp.getMethod("setText", String.class);
            method.invoke(component,base);
            return (JComponent) component;


    }

}