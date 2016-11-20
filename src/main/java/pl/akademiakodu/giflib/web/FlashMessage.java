package pl.akademiakodu.giflib.web;

/**
 * Created by Jaremina on 2016-11-20.
 */
public class FlashMessage {
    private Status status;
    private String message;

    public FlashMessage(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
