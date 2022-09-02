package com.chalchal.chalchalsever.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenResponse {
    private long index;
    private long id;
    private long refreshTokenIndex;

    private String ACCESS_TOKEN;
    private String REFRESH_TOKEN;
}
