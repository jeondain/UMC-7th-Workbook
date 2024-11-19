package umc7.spring.apiPayload.code.exception.handler;

import umc7.spring.apiPayload.code.BaseErrorCode;
import umc7.spring.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}