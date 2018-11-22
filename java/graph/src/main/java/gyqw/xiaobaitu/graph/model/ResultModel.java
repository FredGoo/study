package gyqw.xiaobaitu.graph.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author fred
 * 2018-11-21 5:32 PM
 */
public class ResultModel implements Serializable {
    private Boolean success;
    private String errorCode;
    private String errorMessage;
    private List<NodeModel> result;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<NodeModel> getResult() {
        return result;
    }

    public void setResult(List<NodeModel> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", result=" + result +
                '}';
    }
}
