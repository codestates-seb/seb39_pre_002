package seb39_pre_002.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

//데이터 한 개씩 더해짐
@AllArgsConstructor
@Getter
public class SingleResponseDto<T> {
    private T data;
}
