package umc7.spring.apiPayload.code.exception.handler;

import umc7.spring.apiPayload.code.BaseErrorCode;
import umc7.spring.apiPayload.code.exception.GeneralException;

public class MissionHandler extends GeneralException {

    public MissionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
