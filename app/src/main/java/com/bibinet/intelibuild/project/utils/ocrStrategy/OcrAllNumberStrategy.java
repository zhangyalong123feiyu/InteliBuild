package com.bibinet.intelibuild.project.utils.ocrStrategy;

/**
 * Created by bibinet on 2018-2-6.
 */

public abstract class OcrAllNumberStrategy {
    public static final int AllNumber=1;
    public int type;
    public OcrAllNumberStrategy(int type){
        this.type=type;
    }
    public abstract int getOcrNumberToger(String string);

}