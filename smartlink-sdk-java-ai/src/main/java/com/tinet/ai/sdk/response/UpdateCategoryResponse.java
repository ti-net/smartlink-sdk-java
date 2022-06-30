package com.tinet.ai.sdk.response;

import com.tinet.ai.sdk.model.CategoryResponseModel;
import com.tinet.smartlink.sdk.core.response.BaseResponse;

/**
 * @author feizq
 * @date 2022/06/20
 **/
public class UpdateCategoryResponse extends BaseResponse {

    private CategoryResponseModel category;

    public CategoryResponseModel getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseModel category) {
        this.category = category;
    }
}
