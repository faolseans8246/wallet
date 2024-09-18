package org.example.wallet.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private String message;
    private boolean success = false;
    private Object data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
        this.success = true;
    }

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public ApiResponse(Object data) {
        this.data = data;
    }
}
