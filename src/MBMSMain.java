import Presentation.Views.DefaultFrame;
import Presentation.Views.RegisterFrame;

import java.awt.*;

public class MBMSMain {
    public static void main(String[] args) {
//        var frame = new RegisterFrame();
        runProgram();
    }

    private static void runProgram() {
        EventQueue.invokeLater(() -> {
            try {
                DefaultFrame frame = new DefaultFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
