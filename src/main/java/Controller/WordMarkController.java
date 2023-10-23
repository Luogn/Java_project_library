package Controller;

import javafx.event.ActionEvent;

public class WordMarkController extends  SceneController {
    public void gotoDictionary(ActionEvent event) throws Exception {
        super.switchToScene1(event);
    }

    public void gotoGame(ActionEvent event) throws Exception {
        super.switchToScene3(event);
    }

    public void gotoTranslation(ActionEvent event) throws Exception {
        super.switchToScene4(event);
    }

}
