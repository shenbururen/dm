package cn.sanenen.dm.common.fx;

import cn.hutool.core.util.StrUtil;
import javafx.scene.control.TextArea;

/**
 * @author sun
 **/
public class FxSub {

    public static void maxLength(TextArea logTextArea, int length) {
        logTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue && newValue.length() > length) {
                logTextArea.setText("..." + StrUtil.sub(newValue, newValue.length() - length, newValue.length()));
                //光标放到最后
                logTextArea.setScrollTop(Double.MAX_VALUE);
            }
        });
    }
}
