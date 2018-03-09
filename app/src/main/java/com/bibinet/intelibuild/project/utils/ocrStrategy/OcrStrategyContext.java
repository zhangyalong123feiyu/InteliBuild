package com.bibinet.intelibuild.project.utils.ocrStrategy;

/**
 * Created by bibinet on 2018-2-2.
 */

public class OcrStrategyContext {
    private OcrIndentifyResultStrategy ocrIndentifyResultStrategy;

    public OcrStrategyContext(OcrIndentifyResultStrategy ocrIndentifyResultStrategy) {
        this.ocrIndentifyResultStrategy = ocrIndentifyResultStrategy;
    }
    public double getOcrIndentifyResult(String string){
        return ocrIndentifyResultStrategy.getOcrCorrectResult(string);
    }
}