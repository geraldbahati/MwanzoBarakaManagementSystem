import Logic.MemberEvent;
import Logic.SaveLoadEvent;
import Presentation.Views.DefaultFrame;
import Presentation.Views.HomeFrame;

public class MBMSMain {
    public static void main(String[] args) {
        SaveLoadEvent saveLoadEvent = new SaveLoadEvent();
        var loadedMember = saveLoadEvent.loadSavedMember();
        if (loadedMember == null) {
            runDefaultProgram();
        } else {
            MemberEvent.setMember(loadedMember);
            runHomePage();
        }

    }


    private static void runDefaultProgram() {
        DefaultFrame frame = new DefaultFrame();
        frame.setVisible(true);
    }

    private static void runHomePage() {
        HomeFrame frame = new HomeFrame();
        frame.setVisible(true);
    }
}
