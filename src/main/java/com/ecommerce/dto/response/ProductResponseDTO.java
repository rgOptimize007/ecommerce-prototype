package com.ecommerce.dto.response;

import com.ecommerce.dto.ProductDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO extends ProductDTO {
    private Long productId;
}
