package com.sjn.exceptionHandler;
import org.springframework.http.HttpStatus;

public class CustomErrorResponse {
    private HttpStatus status;
    private String title;
    private String detail;

    public CustomErrorResponse(HttpStatus status, String title, String detail) {
        this.status = status;
        this.title = title;
        this.detail = detail;
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

    
}