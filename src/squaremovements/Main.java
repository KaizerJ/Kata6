package squaremovements;

import control.Command;
import control.MoveDownCommand;
import control.MoveLeftCommand;
import control.MoveRightCommand;
import control.MoveUpCommand;
import control.ResetCommand;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import model.Square;
import presenter.SquarePresenter;

public class Main extends JFrame{
    private final Map<String,Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        setTitle("SquareMovements");
        int squareSize = 20;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SwingSquareDisplay squareDisplay = new SwingSquareDisplay(squareSize,
                                               SquarePresenter.ScreenSize.getX(),
                                               SquarePresenter.ScreenSize.getY());
        
        add(squareDisplay, BorderLayout.CENTER);
        Square square = new Square(squareSize, SquarePresenter.ScreenSize.getX(),
                SquarePresenter.ScreenSize.getY());
        new SquarePresenter(square, squareDisplay).update();
        
        putCommands(square);
        
        add(buttomPanel(), BorderLayout.SOUTH);
        this.pack();
    }

    private void execute() {
        this.setVisible(true);
    }

    private void putCommands(Square square) {
        commands.put("MoveLeft", new MoveLeftCommand(square));
        commands.put("MoveUp", new MoveUpCommand(square));
        commands.put("Reset", new ResetCommand(square));
        commands.put("MoveDown", new MoveDownCommand(square));
        commands.put("MoveRight", new MoveRightCommand(square));
    }

    private Component buttomPanel() {
        JPanel jpanel = new JPanel();
        jpanel.add(leftButton());
        jpanel.add(upButton());
        jpanel.add(resetButton());
        jpanel.add(downButton());
        jpanel.add(rightButton());
        return jpanel;
    }

    private JButton leftButton() {
        JButton leftButton = new JButton("<");
        leftButton.addActionListener((ActionEvent e) -> {
            commands.get("MoveLeft").execute();            
        });
        return leftButton;
    }
    
    private JButton upButton() {
        JButton upButton = new JButton("Up");
        upButton.addActionListener((ActionEvent e) -> {
            commands.get("MoveUp").execute();            
        });
        return upButton;
    }
    
    private JButton resetButton() {
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener((ActionEvent e) -> {
            commands.get("Reset").execute();            
        });
        return resetButton;
    }
    
    private JButton downButton() {
        JButton downButton = new JButton("Down");
        downButton.addActionListener((ActionEvent e) -> {
            commands.get("MoveDown").execute();            
        });
        return downButton;
    }
    
    private JButton rightButton() {
        JButton rightButton = new JButton(">");
        rightButton.addActionListener((ActionEvent e) -> {
            commands.get("MoveRight").execute();            
        });
        return rightButton;
    }
}
