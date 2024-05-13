package com.ecommerce.dto.response;

import com.ecommerce.dto.CategoryDTO;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDTO extends CategoryDTO {
    private List<ProductResponseDTO> productResponseDTOList;
}
