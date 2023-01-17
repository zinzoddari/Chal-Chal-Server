package com.chalchal.chalchalserver.global.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> {

    @JsonProperty
    private final LocalDateTime timestamp = LocalDateTime.now();

    @Builder.Default
    @JsonProperty
    private int status = HttpStatus.OK.value();

    @JsonProperty
    private String message;

    @Builder.Default
    @JsonProperty
    private T data = null;

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseEntity<ResultResponse<Void>> ok() {
        return ResponseEntity.ok(new ResultResponse<>());
    }

    public static ResponseEntity<ResultResponse<Object>> ok(ResultResponse resultResponse) {
        return ResponseEntity
                .ok(resultResponse);
    }
}
