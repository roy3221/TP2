/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android10.sample.presentation.mapper;

import com.fernandocejas.android10.sample.domain.Product;
import com.fernandocejas.android10.sample.presentation.internal.di.PerActivity;
import com.fernandocejas.android10.sample.presentation.model.ProductModel;
import com.fernandocejas.android10.sample.presentation.model.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link Product} (in the domain layer) to {@link ProductModel} in the
 * presentation layer.
 */
@PerActivity
public class ProductModelDataMapper {

  @Inject
  public ProductModelDataMapper() {}

  /**
   * Transform a {@link Product} into an {@link ProductModel}.
   *
   * @param product Object to be transformed.
   * @return {@link ProductModel}.
   */
  public ProductModel transform(Product product) {
    if (product == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    ProductModel productModel = new ProductModel(product.getid());
    productModel.setImage_width(product.getImage_width());
    productModel.setImage_height(product.getImage_height());
    productModel.setImage_width(product.getImage_width());


    return productModel;
  }

  /**
   * Transform a Collection of {@link Product} into a Collection of {@link ProductModel}.
   *
   * @param productsCollection Objects to be transformed.
   * @return List of {@link ProductModel}.
   */
  public Collection<ProductModel> transform(Collection<Product> productsCollection) {
    Collection<ProductModel> productModelsCollection;

    if (productsCollection != null && !productsCollection.isEmpty()) {
      productModelsCollection = new ArrayList<>();
      for (Product product : productsCollection) {
        productModelsCollection.add(transform(product));
      }
    } else {
      productModelsCollection = Collections.emptyList();
    }

    return productModelsCollection;
  }
}
