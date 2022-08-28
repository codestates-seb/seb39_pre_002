package seb39_pre_002.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

//페이지네이션?
@Getter //없으면 406오류
public class MultiResponseDto<T> {
    private List<T> data;
    private PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page page) {
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber() + 1,
                page.getSize(), page.getTotalElements(), page.getTotalPages());
    }
}
