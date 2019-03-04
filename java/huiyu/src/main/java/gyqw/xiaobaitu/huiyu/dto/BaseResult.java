package gyqw.xiaobaitu.huiyu.dto;

/**
 * 返回结果类
 * by kevin.yao
 */
public class BaseResult {
    //结果code
    private int code;
    //结果描述
    private String message;
    //签名
    private String sign;
    //返回结果数据
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", sign='" + sign + '\'' +
                ", data=" + data +
                '}';
    }
}
